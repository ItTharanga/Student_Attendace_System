/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atendance;

import DB_Connection.DB_Connection;
import Login.CommonDetails;
import Registration.Semester_Year_Registration;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import main.MainApplication;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

/**
 *
 * @author Dell
 */
public class Class_Details extends javax.swing.JFrame {

    /**
     * Creates new form Class_Details
     */
    public Class_Details() {
        initComponents();
        CommonDetails.centerScreen(this);
        departmentDetails();
    }
   public void departmentDetails(){
        String sql="select department_name from department";
         DB_Connection con = new DB_Connection();
         ResultSet r= con.search(sql);
        try {
            while(r.next()){
                department_combox.addItem(r.getString("department_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Semester_Year_Registration.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
   
    public void loadStudentDetails(Map<String, Boolean> studentMap){
         try {
        String department = department_combox.getSelectedItem().toString();
        String subjectId = class_table.getValueAt(class_table.getSelectedRow(), 6).toString();
        if (semester_combox.getSelectedIndex() != 0 && semester_year_combox.getSelectedIndex() !=0 && !acc_year_text.getText().equals("") && 
            !"Select Department Name".equals(department) && !subjectId.equals("")) {
            String yearLevel = semester_year_combox.getSelectedItem().toString();
            String semLevel = semester_combox.getSelectedItem().toString();
            String accYear = acc_year_text.getText();
            int semesterYearId = 0;
            int departmentId = 0;
            int semYearSubId = 0;
            
        DB_Connection con = new DB_Connection();
        String semSql="select semester_year_id from semester_year where academic_year ="+accYear+" and year_level ='"+yearLevel+"' and semester_level ='"+semLevel+"'";
        
        ResultSet r= con.search(semSql);   
            if(r.next()){
                semesterYearId = r.getInt("semester_year_id");
            }
            
        String depSql="select department_id from department where department_name='"+department+"'";
        ResultSet dep= con.search(depSql);   
            if(dep.next()){
                departmentId = dep.getInt("department_id");
            }
        
        
        String semYearSubSql="select sem_year_sub_id from semester_year_subject where subject_id ="+subjectId+" and semester_year_id ="+semesterYearId+"";
        ResultSet semYearSub= con.search(semYearSubSql);   
            if(semYearSub.next()){
                semYearSubId = semYearSub.getInt("sem_year_sub_id");
            }
        
        
        String studentSql="select * from student where student_id in (select student_id from sem_year_sub_students where sem_year_sub_id="+semYearSubId+")";
        ResultSet student= con.search(studentSql);   
        DefaultTableModel model = (DefaultTableModel)attendance_tab.getModel();
            while(student.next()){
               
                String regNo = student.getString("reg_num");
                // check register number is avaliable on student map
                boolean isPresent = studentMap.get(regNo) == null ? false : studentMap.get(regNo);
                String stuName = student.getString("first_name") + " " +  student.getString("last_name");
                model.addRow(new Object[]{student.getInt("student_id"), "0", stuName, regNo, student.getString("nic_num"), isPresent});
                
                
            }
        
        }
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }   
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        sub_id_txt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        attendance_tab = new javax.swing.JTable();
        acc_year_text = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        department_combox = new javax.swing.JComboBox<>();
        semester_year_combox = new javax.swing.JComboBox<>();
        semester_combox = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        class_table = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        dateChooserCombo1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        attendance_tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stu_id", "attendance_id", "Student Name", "Reg No", "Nic", "Is Present"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(attendance_tab);
        if (attendance_tab.getColumnModel().getColumnCount() > 0) {
            attendance_tab.getColumnModel().getColumn(0).setMinWidth(0);
            attendance_tab.getColumnModel().getColumn(0).setPreferredWidth(0);
            attendance_tab.getColumnModel().getColumn(0).setMaxWidth(0);
            attendance_tab.getColumnModel().getColumn(1).setMinWidth(0);
            attendance_tab.getColumnModel().getColumn(1).setPreferredWidth(0);
            attendance_tab.getColumnModel().getColumn(1).setMaxWidth(0);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 500, 320));
        getContentPane().add(acc_year_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 80, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Date");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 50, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setText("Ac Year");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 80, 20));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Include attendance Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, 250, 30));

        jTextField5.setEditable(false);
        jTextField5.setEnabled(false);
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 290, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Update Attendance Details");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, 500, 30));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Select Attendance Details Image");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Mark Student Attendance Details ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 320, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 0));
        jButton4.setText("Main Menu");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 580, 160, 30));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("Exit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 580, -1, 30));

        department_combox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        department_combox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Department Name" }));
        department_combox.setToolTipText("");
        department_combox.setName("ss"); // NOI18N
        department_combox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                department_comboxActionPerformed(evt);
            }
        });
        department_combox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                department_comboxPropertyChange(evt);
            }
        });
        getContentPane().add(department_combox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, -1, 30));

        semester_year_combox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        semester_year_combox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year Level", "First Year", "Second Year", "Third Year", "Fourth Year" }));
        semester_year_combox.setToolTipText("");
        semester_year_combox.setName("ss"); // NOI18N
        semester_year_combox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semester_year_comboxActionPerformed(evt);
            }
        });
        getContentPane().add(semester_year_combox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 130, 30));

        semester_combox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        semester_combox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semester Level", "First Semester", "Second Semester" }));
        semester_combox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semester_comboxActionPerformed(evt);
            }
        });
        getContentPane().add(semester_combox, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 140, 30));

        jButton7.setText("Load Class Details");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 220, 30));

        class_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Class Id", "Date", "Subject Code", "Subject Name", "Lecture Name", "Select", "subject_id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(class_table);
        if (class_table.getColumnModel().getColumnCount() > 0) {
            class_table.getColumnModel().getColumn(0).setMinWidth(0);
            class_table.getColumnModel().getColumn(0).setPreferredWidth(0);
            class_table.getColumnModel().getColumn(0).setMaxWidth(0);
            class_table.getColumnModel().getColumn(6).setMinWidth(0);
            class_table.getColumnModel().getColumn(6).setPreferredWidth(0);
            class_table.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 240, 450, 280));

        jButton8.setText("Search this class Student's attendance");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 530, 420, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("*");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 30, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("*");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 30, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setText("*");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 30, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("*");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 30, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("*");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 30, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        jLabel12.setText("*");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 30, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 51));
        jLabel13.setText("*");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 30, 20));
        getContentPane().add(dateChooserCombo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 90, 110, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
        new MainApplication().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void department_comboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department_comboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_department_comboxActionPerformed

    private void department_comboxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_department_comboxPropertyChange
        CommonDetails.selectedDepartment = department_combox.getSelectedItem().toString();
    }//GEN-LAST:event_department_comboxPropertyChange

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       final JFileChooser chooser = new JFileChooser();
      // chooser.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY );
       //chooser.addChoosableFileFilter(new FileNameExtensionFilter("*.Images","jpg","png"));
       int returnVal = chooser.showOpenDialog( this );

       if( returnVal == JFileChooser.APPROVE_OPTION ) {
          String filePath = ( chooser.getSelectedFile().toString() );
           jTextField5.setText(filePath);

       }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     try {
         
          
            if (dateChooserCombo1.getDate() == null || department_combox.getSelectedIndex() == 0 || acc_year_text.getText().equals("") || 
                    semester_year_combox.getSelectedIndex() == 0 || semester_combox.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Please select required things (*)", "information box" 
                        + "Inform", JOptionPane.INFORMATION_MESSAGE);
            } else {
                if (class_table.getSelectedRowCount() == 1) {
            String text  = getImgText(jTextField5.getText());
            String lines[] = text.split("\\r?\\n");
            Map<String, Boolean> studentDetails = new HashMap();
            for(int i=0; i<lines.length; i++) {
                splitText(lines[i], studentDetails);
     
            }
            loadStudentDetails(studentDetails);
            } else {
             JOptionPane.showMessageDialog(null, "Please select class from class table.", "information box" 
                        + "Inform", JOptionPane.INFORMATION_MESSAGE);
         }
            }
                
         
        } catch (Exception e) {
            e.printStackTrace();
        }       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void semester_year_comboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semester_year_comboxActionPerformed

    }//GEN-LAST:event_semester_year_comboxActionPerformed

    private void semester_comboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semester_comboxActionPerformed

    }//GEN-LAST:event_semester_comboxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            
            DB_Connection con = new DB_Connection();
            int classSelectedRaw = class_table.getSelectedRow();
            
            if (classSelectedRaw == -1) {      
                JOptionPane.showMessageDialog(null, "Please select the particular class in the table", "information box" 
                        + "Inform", JOptionPane.INFORMATION_MESSAGE);
            } else {
            String classId = class_table.getValueAt(classSelectedRaw, 0).toString();
            for (int i = 0; i<attendance_tab.getRowCount(); i++) {
                String studentId = attendance_tab.getValueAt(i, 0).toString();
                String isPresent = attendance_tab.getValueAt(i, 5).toString();       
                
                String search = "select * from attendance where class_id ="+classId+" and student_id ="+studentId+"";
                ResultSet r = con.search(search);
                String query = null;
                if (r.next()) {
                    query = "UPDATE attendance SET is_present="+isPresent+" WHERE attendance_id="+r.getInt("attendance_id")+"";
                } else {
                    query = "INSERT INTO attendance (class_id, student_id, is_present) "
                        + "VALUES("+classId+", "+studentId+", "+isPresent+")";
                }
                con.register(query);
            }
            
            JOptionPane.showMessageDialog(null, "Attendance Details included Successfully", "information box" 
                        + "Inform", JOptionPane.INFORMATION_MESSAGE);
            DefaultTableModel model = (DefaultTableModel)attendance_tab.getModel();
            model.setRowCount(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            
            if (dateChooserCombo1.getDate() != null && department_combox.getSelectedIndex() != 0) {
                DefaultTableModel model = (DefaultTableModel)class_table.getModel();
                model.setRowCount(0);
                SimpleDateFormat dateFor = new SimpleDateFormat("yyyy-MM-dd");
                Date date = dateChooserCombo1.getDate();
                String d = dateFor.format(date);
                
                 DB_Connection con = new DB_Connection();
                 String depName= department_combox.getSelectedItem().toString();
                
                String search = "select c.class_id , c.date,s.subject_code ,s.subject_name , st.first_name, s.subject_id "
                        + "from class c inner join semester_year_subject sys on "
                        + "c.sem_year_sub_id = sys.sem_year_sub_id inner join \n" +
"subject s on sys.subject_id = s.subject_id inner join department d on s.department_id = d.department_id "
                        + "inner join staff st on c.staff_id = st.staff_id " +
"where c.date = '"+d+"' and d.department_name ='"+depName+"'";
                ResultSet r = con.search(search);
                
                while (r.next()) {
                      model.addRow(new Object[]{r.getInt("class_id"), r.getString("date"), r.getString("subject_code"), r.getString("subject_name"), 
                          r.getString("first_name"), false, r.getInt("subject_id")});
                }
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            int selectedClass = class_table.getSelectedRow();
            
            if (selectedClass != -1) {
                DefaultTableModel model = (DefaultTableModel)attendance_tab.getModel();
                model.setRowCount(0);
                String classId = class_table.getValueAt(selectedClass, 0).toString();
                String search = "select s.student_id, a.attendance_id, s.first_name , s.last_name , s.reg_num , s.nic_num , "
                        + "a.is_present from attendance a inner join student s on a.student_id = s.student_id where class_id ="+classId+"";
                DB_Connection con = new DB_Connection();
                ResultSet r = con.search(search);
                
                while (r.next()) {
                    String stuNamee = r.getString("first_name") + " " + r.getString("last_name");
                    model.addRow(new Object[]{r.getInt("student_id"), r.getInt("attendance_id"), stuNamee, 
                    r.getString("reg_num"), r.getString("nic_num"), r.getBoolean("is_present")});
                }
            } else {
                JOptionPane.showMessageDialog(null, "Select Class from table", "information box" 
                        + "Inform", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton8ActionPerformed
public static void splitText(String text, Map<String, Boolean> studentMap) {
        System.out.println(text);
        String[] split1 = text.split("2016/");
        String code = null;
        boolean isPresent = false;
        
       
       if (split1.length>1) {
           System.out.println(split1[1]);
           String[] split2 = split1[1].split(" ");
           if (split2.length>0) {
           code = split2[0];
               
               String statud = split2[split2.length-1];
               if (statud.contains("y") || statud.contains("e") || statud.contains("s") || 
                       statud.contains("Y") || statud.contains("E") || statud.contains("S")) {
                   isPresent = true;
               }
               studentMap.put(code, isPresent);
           }
       }
    }

public String getImgText(String imageLocation) {
     //   System.out.println("0000");
        ITesseract instance = new Tesseract();
       // System.out.println("ddddd");
      try 
      {
       //  System.out.println("111");
         String imgText = instance.doOCR(new File(imageLocation));
        // System.out.println("222");
         return imgText;
      } 
      catch (Exception e) 
      {
         e.getMessage();
         return "Error while reading image";
      }
   }
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
            java.util.logging.Logger.getLogger(Class_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Class_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Class_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Class_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Class_Details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField acc_year_text;
    private javax.swing.JTable attendance_tab;
    private javax.swing.JTable class_table;
    private com.toedter.calendar.JDateChooser dateChooserCombo1;
    private javax.swing.JComboBox<String> department_combox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JComboBox<String> semester_combox;
    private javax.swing.JComboBox<String> semester_year_combox;
    public static javax.swing.JLabel sub_id_txt;
    // End of variables declaration//GEN-END:variables


}