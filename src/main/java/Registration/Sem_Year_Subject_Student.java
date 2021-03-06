/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

import DB_Connection.DB_Connection;
import Login.CommonDetails;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import main.MainApplication;

/**
 *
 * @author Dell
 */
public class Sem_Year_Subject_Student extends javax.swing.JFrame {

    /**
     * Creates new form Sem_Year_Subject_Registration
     */
    public Sem_Year_Subject_Student() {
        initComponents();
        departmentSelection();
        CommonDetails.centerScreen(this);
        
    }
    public void clearSemTable() {
        DefaultTableModel model = (DefaultTableModel) semester_year_table.getModel();
        model.setRowCount(0);
    }
    public void clearStudentTable() {
        DefaultTableModel model = (DefaultTableModel) student_table.getModel();
        model.setRowCount(0);
    }
     public void clearSubjectStudentTable() {
        DefaultTableModel model = (DefaultTableModel) subject_student_table.getModel();
        model.setRowCount(0);
    }
    public void departmentSelection(){
    String sql= "select department_name from department";
    DB_Connection con = new DB_Connection();
    ResultSet r = con.search(sql);
        try {
            while(r.next()){
              department_combox.addItem(r.getString("department_name"));
              department_combox1.addItem(r.getString("department_name"));
            }
        } catch (Exception e) {
        }
    }
    public boolean isStudentExistForSubject(String subjectId, String studentId){
    String sql= "select * from sem_year_sub_students where sem_year_sub_id = "+subjectId+" and"
            + " student_id = "+studentId+"";
    DB_Connection con = new DB_Connection();
    ResultSet r = con.search(sql);
        try {
            if(r.next()){
            return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        sem_yearLevel_text = new javax.swing.JTextField();
        semester_level_text = new javax.swing.JTextField();
        semester_combox = new javax.swing.JComboBox<String>();
        semester_search_text = new javax.swing.JToggleButton();
        semester_year_combox = new javax.swing.JComboBox<String>();
        academic_year_text = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        semester_year_table = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        department_text = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        department_combox = new javax.swing.JComboBox<String>();
        jScrollPane5 = new javax.swing.JScrollPane();
        student_table = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        department_combox1 = new javax.swing.JComboBox<String>();
        department_text1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        academic_year_text1 = new javax.swing.JTextField();
        semester_search_text1 = new javax.swing.JToggleButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        subject_student_table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        sem_lable = new javax.swing.JLabel();
        sem_search_lable = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("Add Students For The Subjects");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, -1, 51));

        sem_yearLevel_text.setEditable(false);
        sem_yearLevel_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sem_yearLevel_textActionPerformed(evt);
            }
        });
        getContentPane().add(sem_yearLevel_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 100, 30));

        semester_level_text.setEditable(false);
        semester_level_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semester_level_textActionPerformed(evt);
            }
        });
        getContentPane().add(semester_level_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 140, 30));

        semester_combox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        semester_combox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Semester Level", "First Semester", "Second Semester" }));
        semester_combox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semester_comboxActionPerformed(evt);
            }
        });
        getContentPane().add(semester_combox, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 140, 40));

        semester_search_text.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        semester_search_text.setText("Search");
        semester_search_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semester_search_textActionPerformed(evt);
            }
        });
        getContentPane().add(semester_search_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 130, 40));

        semester_year_combox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        semester_year_combox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Year Level", "First Year", "Second Year", "Third Year", "Fourth Year" }));
        semester_year_combox.setToolTipText("");
        semester_year_combox.setName("ss"); // NOI18N
        semester_year_combox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semester_year_comboxActionPerformed(evt);
            }
        });
        getContentPane().add(semester_year_combox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 100, 40));

        academic_year_text.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        academic_year_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                academic_year_textActionPerformed(evt);
            }
        });
        getContentPane().add(academic_year_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 120, 30));

        semester_year_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sem Year Sub ID", "Subject Name", "Subject Code", "Department", "Select "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(semester_year_table);
        if (semester_year_table.getColumnModel().getColumnCount() > 0) {
            semester_year_table.getColumnModel().getColumn(0).setMinWidth(0);
            semester_year_table.getColumnModel().getColumn(0).setPreferredWidth(0);
            semester_year_table.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 610, 160));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText(" Year");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 130, 40));

        department_text.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        department_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                department_textActionPerformed(evt);
            }
        });
        getContentPane().add(department_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 220, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Add student into related department with related semester year subject");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 500, 30));

        jSeparator2.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 1050, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("Search Students in related Academic Year");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 30, 330, 30));

        department_combox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        department_combox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select or Type  Department" }));
        department_combox.setToolTipText("");
        department_combox.setName("ss"); // NOI18N
        department_combox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                department_comboxActionPerformed(evt);
            }
        });
        getContentPane().add(department_combox, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 220, 40));

        student_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "NIC Number", "Reg No:", "Select "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(student_table);
        if (student_table.getColumnModel().getColumnCount() > 0) {
            student_table.getColumnModel().getColumn(0).setMinWidth(0);
            student_table.getColumnModel().getColumn(0).setPreferredWidth(0);
            student_table.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, 510, 160));

        jSeparator1.setForeground(new java.awt.Color(255, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 60, 330));

        department_combox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        department_combox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select or Type  Department" }));
        department_combox1.setToolTipText("");
        department_combox1.setName("ss"); // NOI18N
        department_combox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                department_combox1ActionPerformed(evt);
            }
        });
        getContentPane().add(department_combox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 220, 40));

        department_text1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        department_text1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                department_text1ActionPerformed(evt);
            }
        });
        getContentPane().add(department_text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 220, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setText("Loading Subject Details with Related Semester Year and Department");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 500, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Academic Year");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 70, 130, 40));

        academic_year_text1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        academic_year_text1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                academic_year_text1ActionPerformed(evt);
            }
        });
        getContentPane().add(academic_year_text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 110, 120, 30));

        semester_search_text1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        semester_search_text1.setText("Search Students");
        semester_search_text1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semester_search_text1ActionPerformed(evt);
            }
        });
        getContentPane().add(semester_search_text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 110, 150, 30));

        subject_student_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "sem_year_sub_student_id", "sem_year_sub_id", "Subject", "student Name", "Stu. Reg No", "Student Id"
            }
        ));
        jScrollPane6.setViewportView(subject_student_table);
        if (subject_student_table.getColumnModel().getColumnCount() > 0) {
            subject_student_table.getColumnModel().getColumn(0).setMinWidth(0);
            subject_student_table.getColumnModel().getColumn(0).setPreferredWidth(0);
            subject_student_table.getColumnModel().getColumn(0).setMaxWidth(0);
            subject_student_table.getColumnModel().getColumn(1).setMinWidth(0);
            subject_student_table.getColumnModel().getColumn(1).setPreferredWidth(0);
            subject_student_table.getColumnModel().getColumn(1).setMaxWidth(0);
            subject_student_table.getColumnModel().getColumn(5).setMinWidth(0);
            subject_student_table.getColumnModel().getColumn(5).setPreferredWidth(0);
            subject_student_table.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 670, 180));

        jButton1.setText("Include Selected Students For Selected Subjects");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 360, 320, 40));

        jButton2.setText("Save All");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 620, -1, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setText("Main Menu");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 650, 160, 30));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 650, -1, 30));

        sem_lable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(sem_lable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 200, 30));

        sem_search_lable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(sem_search_lable, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 200, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sem_yearLevel_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sem_yearLevel_textActionPerformed

    }//GEN-LAST:event_sem_yearLevel_textActionPerformed

    private void semester_level_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semester_level_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semester_level_textActionPerformed

    private void semester_comboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semester_comboxActionPerformed
        String searchValue = semester_combox.getSelectedItem().toString();
        semester_level_text.setText(searchValue);
    }//GEN-LAST:event_semester_comboxActionPerformed

    private void semester_search_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semester_search_textActionPerformed

       if (academic_year_text.getText().equals("") || sem_yearLevel_text.getText().equals("") || semester_level_text.getText().equals("") || department_text.getText().equals("") ) {       
            JOptionPane.showMessageDialog(null, "Please Enter Accademic Year, year level, semester level, department", "information box" 
                        + "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {
     clearSemTable();
     String sql= "select sem_year_sub_id, subject_name, subject_code, academic_year, year_level, semester_level, \n" +
"    department_name from semester_year_subject inner join subject \n" +
"    on semester_year_subject.subject_id =subject.subject_id inner join \n" +
"    department on subject.department_id=department.department_id inner join \n" +
"    semester_year on semester_year_subject.semester_year_id=semester_year.semester_year_id where "
+   "semester_year.academic_year="+academic_year_text.getText()+" " ;

        if (!sem_yearLevel_text.getText().equals("")) {        
            sql = sql + " and semester_year.year_level= '"+sem_yearLevel_text.getText()+"'";
        }
        if (!semester_level_text.getText().equals("")) {
            sql = sql + " and semester_year.semester_level= '"+semester_level_text.getText()+"'";
        }
        if (!department_text.getText().equals("")) {
            sql = sql + " and department.department_name= '"+department_text.getText()+"'";
        }
        
          
        DB_Connection con = new DB_Connection();
        ResultSet g=con.search(sql);
       try{
       DefaultTableModel tableModel = (DefaultTableModel)semester_year_table.getModel();
       
       String sem = academic_year_text.getText()+"-"+sem_yearLevel_text.getText()+"-"+semester_level_text.getText()+"-"+
               department_text.getText();
       sem_lable.setText(sem);
        while(g.next()){
         String academicYear=g.getString("academic_year");
         String yearLevel= g.getString("year_level");
         String semesterLlevel= g.getString("semester_level");

                Object[] arr = new Object[]{g.getString("sem_year_sub_id"),g.getString("subject_name"),
                    g.getString("subject_code"),g.getString("department_name"), false};
               tableModel.addRow(arr);
            }
        }

        catch(Exception ex){
            
        }
        }
     
    }//GEN-LAST:event_semester_search_textActionPerformed

    private void semester_year_comboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semester_year_comboxActionPerformed
        String searchValue = semester_year_combox.getSelectedItem().toString();
        sem_yearLevel_text.setText(searchValue);
    }//GEN-LAST:event_semester_year_comboxActionPerformed

    private void academic_year_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_academic_year_textActionPerformed

    }//GEN-LAST:event_academic_year_textActionPerformed

    private void department_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_department_textActionPerformed

    private void department_comboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department_comboxActionPerformed
         String searchValue= department_combox.getSelectedItem().toString();
         department_text.setText(searchValue);
    }//GEN-LAST:event_department_comboxActionPerformed

    private void department_combox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department_combox1ActionPerformed
        String searchValue= department_combox1.getSelectedItem().toString();
        department_text1.setText(searchValue);
    }//GEN-LAST:event_department_combox1ActionPerformed

    private void department_text1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department_text1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_department_text1ActionPerformed

    private void academic_year_text1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_academic_year_text1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_academic_year_text1ActionPerformed

    private void semester_search_text1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semester_search_text1ActionPerformed

        try {
            if (department_text1.getText().equals("") || academic_year_text1.getText().equals("")) {                
                JOptionPane.showMessageDialog(null, "Please Enter Search Values", "information box" 
                        + "Warning", JOptionPane.INFORMATION_MESSAGE);
            } else {
              clearStudentTable();
            
            String sql = "select stu.* from student stu inner join department dep on stu.department_id = dep.department_id "
                          + "where dep.department_name = '"+department_text1.getText()+"' and stu.academic_year = "+academic_year_text1.getText()+"";
            
        DB_Connection con = new DB_Connection();
        ResultSet g=con.search(sql);
 
         DefaultTableModel tableModel = (DefaultTableModel)student_table.getModel();
         while(g.next()){

                Object[] arr = new Object[]{g.getString("student_id"), g.getString("first_name") + " " + g.getString("last_name"),
                               g.getString("nic_num"), g.getString("reg_num"), false};
               tableModel.addRow(arr);
            }
        }        
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_semester_search_text1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            clearSubjectStudentTable();
            int stuRowCount = student_table.getRowCount();
            int subRowCount = semester_year_table.getRowCount();
            
            if (stuRowCount == 0 || subRowCount == 0) {
                JOptionPane.showMessageDialog(null, "Please Select Subjects And Students", "information box" 
                        + "Warning", JOptionPane.INFORMATION_MESSAGE);
            } else {
            int studentId = 0;
            String stuName = "";
            String reNo = "";
             DefaultTableModel tableModel = (DefaultTableModel)subject_student_table.getModel();

            for (int i = 0; i<subRowCount; i++) {
                
               Boolean isSelectSem = (Boolean)semester_year_table.getValueAt(i, 4);                
               if (isSelectSem == true) {   
                   String subId = semester_year_table.getValueAt(i, 0).toString();
                
                   String subject = semester_year_table.getValueAt(i, 1).toString() + "-" + semester_year_table.getValueAt(i, 2).toString();   
                 for (int j = 0; j<stuRowCount; j++) {
                
                 Boolean isSelect = (Boolean) student_table.getValueAt(j, 4);           
                 if (isSelect == true) {
                 studentId = Integer.valueOf(student_table.getValueAt(j, 0).toString());
                 stuName = student_table.getValueAt(j, 1).toString();
                 reNo = student_table.getValueAt(j, 3).toString();
                //String insert = "INSERT INTO student_attendance_system.sem_year_sub_students (sem_year_sub_id, student_id) VALUES("+subId+", "+studentId+")";
               // DB_Connection con =  new DB_Connection();
               // int id=con.register(insert);
                Object[] arr = new Object[]{0,subId, subject, stuName, reNo, studentId};
                tableModel.addRow(arr);
                 }
                 }
                   
                    
                }
            }
            
            } 
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            DB_Connection con = new DB_Connection();
            
            int rowCount = subject_student_table.getRowCount();
            for (int i = 0; i<rowCount; i++) {
             String search = "select sem_year_sub_student_id from sem_year_sub_students where sem_year_sub_id = "
                        + ""+subject_student_table.getValueAt(i, 1)+" and student_id = "+subject_student_table.getValueAt(i, 5)+"";
                ResultSet r = con.search(search);
                
                if (!r.next()) {
             String sql = "insert into sem_year_sub_students (sem_year_sub_id, student_id) values"
                     + "("+subject_student_table.getValueAt(i, 1)+", "+subject_student_table.getValueAt(i, 5)+")";
             
             con.register(sql);
                } 
            
            }
            clearSubjectStudentTable();
            JOptionPane.showMessageDialog(null, "Save Completed", "information box" 
                        + "Inform", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        new MainApplication().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sem_Year_Subject_Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sem_Year_Subject_Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sem_Year_Subject_Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sem_Year_Subject_Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sem_Year_Subject_Student().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField academic_year_text;
    private javax.swing.JTextField academic_year_text1;
    private javax.swing.JComboBox<String> department_combox;
    private javax.swing.JComboBox<String> department_combox1;
    private javax.swing.JTextField department_text;
    private javax.swing.JTextField department_text1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel sem_lable;
    private javax.swing.JLabel sem_search_lable;
    private javax.swing.JTextField sem_yearLevel_text;
    private javax.swing.JComboBox<String> semester_combox;
    private javax.swing.JTextField semester_level_text;
    private javax.swing.JToggleButton semester_search_text;
    private javax.swing.JToggleButton semester_search_text1;
    private javax.swing.JComboBox<String> semester_year_combox;
    private javax.swing.JTable semester_year_table;
    private javax.swing.JTable student_table;
    private javax.swing.JTable subject_student_table;
    // End of variables declaration//GEN-END:variables
}
