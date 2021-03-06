/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atendance;

import DB_Connection.DB_Connection;
import Login.CommonDetails;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import main.MainApplication;

/**
 *
 * @author dthameera
 */
public class Mark_Claass_Details extends javax.swing.JFrame {

    /**
     * Creates new form Mark_Claass_Details
     */
    public Mark_Claass_Details() {
        initComponents();
        CommonDetails.centerScreen(this);
        departmentSelection();
    }
    public void clearSemTable() {
        DefaultTableModel model = (DefaultTableModel) semester_year_table.getModel();
        model.setRowCount(0);
    }
    public void departmentSelection(){
    String sql= "select department_name from department";
    DB_Connection con = new DB_Connection();
    ResultSet r = con.search(sql);
        try {
            while(r.next()){
              department_combox.addItem(r.getString("department_name"));
            }
        } catch (Exception e) {
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

        sem_yearLevel_text = new javax.swing.JTextField();
        semester_level_text = new javax.swing.JTextField();
        semester_combox = new javax.swing.JComboBox<>();
        semester_search_text = new javax.swing.JToggleButton();
        semester_year_combox = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        semester_year_table = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        department_text = new javax.swing.JTextField();
        department_combox = new javax.swing.JComboBox<>();
        semester_year_detail_lab = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        staff_table = new javax.swing.JTable();
        staff_txt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        start_hour_combo = new javax.swing.JComboBox();
        start_secod_combo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        end_secod_combo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        end_hour_combo = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        class_table = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        dateChooserCombo1 = new com.toedter.calendar.JDateChooser();
        academic_year_text = new com.toedter.calendar.JYearChooser();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sem_yearLevel_text.setEditable(false);
        sem_yearLevel_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sem_yearLevel_textActionPerformed(evt);
            }
        });
        getContentPane().add(sem_yearLevel_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 100, 30));

        semester_level_text.setEditable(false);
        semester_level_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semester_level_textActionPerformed(evt);
            }
        });
        getContentPane().add(semester_level_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 130, 30));

        semester_combox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        semester_combox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semester Level", "First Semester", "Second Semester" }));
        semester_combox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semester_comboxActionPerformed(evt);
            }
        });
        getContentPane().add(semester_combox, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 130, 40));

        semester_search_text.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        semester_search_text.setText("Load Semester Year Subjects");
        semester_search_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semester_search_textActionPerformed(evt);
            }
        });
        getContentPane().add(semester_search_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 610, 40));

        semester_year_combox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        semester_year_combox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year Level", "First Year", "Second Year", "Third Year", "Fourth Year" }));
        semester_year_combox.setToolTipText("");
        semester_year_combox.setName("ss"); // NOI18N
        semester_year_combox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semester_year_comboxActionPerformed(evt);
            }
        });
        getContentPane().add(semester_year_combox, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 100, 40));

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
        semester_year_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                semester_year_tableMouseClicked(evt);
            }
        });
        semester_year_table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                semester_year_tableKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(semester_year_table);
        if (semester_year_table.getColumnModel().getColumnCount() > 0) {
            semester_year_table.getColumnModel().getColumn(0).setMinWidth(0);
            semester_year_table.getColumnModel().getColumn(0).setPreferredWidth(0);
            semester_year_table.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 610, 130));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Lecture Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 120, 40));

        department_text.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        department_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                department_textActionPerformed(evt);
            }
        });
        getContentPane().add(department_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 220, 30));

        department_combox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        department_combox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Department" }));
        department_combox.setToolTipText("");
        department_combox.setName("ss"); // NOI18N
        department_combox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                department_comboxActionPerformed(evt);
            }
        });
        getContentPane().add(department_combox, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 220, 40));

        semester_year_detail_lab.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(semester_year_detail_lab, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 240, 30));

        staff_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Staff ID", "First Name", "Last Name", "NIC Num:", "Select"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        staff_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                staff_tableMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                staff_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(staff_table);
        if (staff_table.getColumnModel().getColumnCount() > 0) {
            staff_table.getColumnModel().getColumn(0).setMinWidth(0);
            staff_table.getColumnModel().getColumn(0).setPreferredWidth(0);
            staff_table.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, 320, 130));
        getContentPane().add(staff_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, 170, 30));

        jButton1.setText("Search By Name");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 100, 130, 30));

        start_hour_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        start_hour_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start_hour_comboActionPerformed(evt);
            }
        });
        getContentPane().add(start_hour_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 50, 30));

        start_secod_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        getContentPane().add(start_secod_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, 50, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText(":");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 20, -1));

        end_secod_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        getContentPane().add(end_secod_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 370, 50, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText(":");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, 20, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("End Time");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 340, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Start Time");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, -1, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, 40, 50));

        jButton2.setText("Save Class Details");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 680, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Mark Class Details");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 220, -1));

        jButton3.setText("Mark Attendance Details");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 340, 180, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Lectures");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, 100, 30));

        end_hour_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        getContentPane().add(end_hour_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, 50, 30));

        class_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Class Id", "Date", "Subject Code", "Subject Name", "Lecture Name", "Start Time", "End Time", "Hours"
            }
        ));
        jScrollPane2.setViewportView(class_table);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 680, 150));

        jButton4.setText("Search Class Details");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 140, 90));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText(" Year");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 80, 40));
        getContentPane().add(dateChooserCombo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 120, 30));
        getContentPane().add(academic_year_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 80, 30));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 0, 0));
        jButton5.setText("Main Menu");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 620, 160, 30));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("Exit");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 620, -1, 30));

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

        if (academic_year_text.getYear() == 0 || semester_year_combox.getSelectedIndex() == -1 || semester_combox.getSelectedIndex() == -1
                || department_combox.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Please select required details", "information box"
                + "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {
            clearSemTable();
            String sql= "select sem_year_sub_id, subject_name, subject_code, academic_year, year_level, semester_level, \n" +
            "    department_name from semester_year_subject inner join subject \n" +
            "    on semester_year_subject.subject_id =subject.subject_id inner join \n" +
            "    department on subject.department_id=department.department_id inner join \n" +
            "    semester_year on semester_year_subject.semester_year_id=semester_year.semester_year_id where "
            +   "semester_year.academic_year="+academic_year_text.getYear()+" and"
                    + " semester_year.year_level= '"+sem_yearLevel_text.getText()+"' and "
                    + "semester_year.semester_level= '"+semester_level_text.getText()+"' and "
                    + "department.department_name= '"+department_text.getText()+"'" ;

   
            DB_Connection con = new DB_Connection();
            ResultSet g=con.search(sql);
            try{
                DefaultTableModel tableModel = (DefaultTableModel)semester_year_table.getModel();
                String semYear = academic_year_text.getYear() + "-" + sem_yearLevel_text.getText() + "-" + semester_level_text.getText();
                semester_year_detail_lab.setText(semYear);
                while(g.next()){
   
                    Object[] arr = new Object[]{g.getString("sem_year_sub_id"),g.getString("subject_name"),
                        g.getString("subject_code"), g.getString("department_name"), false};
                    tableModel.addRow(arr);
                }
            }

            catch(Exception ex){
                ex.printStackTrace();

            }
        }

    }//GEN-LAST:event_semester_search_textActionPerformed

    private void semester_year_comboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semester_year_comboxActionPerformed
        String searchValue = semester_year_combox.getSelectedItem().toString();
        sem_yearLevel_text.setText(searchValue);
    }//GEN-LAST:event_semester_year_comboxActionPerformed

    private void department_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_department_textActionPerformed

    private void department_comboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department_comboxActionPerformed
        String searchValue= department_combox.getSelectedItem().toString();
        department_text.setText(searchValue);
    }//GEN-LAST:event_department_comboxActionPerformed

    private void semester_year_tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_semester_year_tableKeyPressed
      
    }//GEN-LAST:event_semester_year_tableKeyPressed

    private void semester_year_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_semester_year_tableMouseClicked
          int rawCount = semester_year_table.getRowCount();
        int selectedRaw = semester_year_table.getSelectedRow();
        for (int i=0; i<rawCount; i++) {            
            if (i != selectedRaw) {
                semester_year_table.setValueAt(false, i, 4);
            }
            
        }
    }//GEN-LAST:event_semester_year_tableMouseClicked

    private void staff_tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staff_tableMousePressed
   
    }//GEN-LAST:event_staff_tableMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) staff_table.getModel();
        tableModel.setRowCount(0);
        
        String sql= "select * from staff where first_name like '"+staff_txt.getText()+"%' or last_name like '"+staff_txt.getText()+"%'";
         DB_Connection con = new DB_Connection();
         ResultSet r = con.search(sql);
        try {
 
            while(r.next()){
              Object[] arr = new Object[]{r.getInt("staff_id"),r.getString("first_name"),
                        r.getString("last_name"), r.getString("nic_num"), false};
                    tableModel.addRow(arr);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void staff_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staff_tableMouseClicked
        int rawCount = staff_table.getRowCount();
        int selectedRaw = staff_table.getSelectedRow();
        for (int i=0; i<rawCount; i++) {            
            if (i != selectedRaw) {
                staff_table.setValueAt(false, i, 4);
            }
            
        }
    }//GEN-LAST:event_staff_tableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
           if (semester_year_table.getSelectedRow() == -1 || staff_table.getSelectedRow() == -1) {
               JOptionPane.showMessageDialog(null, "Please select subject and class details from tables", "information box" 
                        + "Inform", JOptionPane.INFORMATION_MESSAGE);
           } else {
     String year = String.valueOf(academic_year_text.getYear());
     SimpleDateFormat dateFor = new SimpleDateFormat("yyyy-MM-dd");
     Date date = dateChooserCombo1.getDate();
     String d = dateFor.format(date);
     
     String staffId = staff_table.getValueAt(staff_table.getSelectedRow(), 0).toString();
     String semSubjectId = semester_year_table.getValueAt(semester_year_table.getSelectedRow(), 0).toString();
     
     String startTime = start_hour_combo.getSelectedItem().toString() + ":" + start_secod_combo.getSelectedItem().toString() + ":00";
     String endTime = end_hour_combo.getSelectedItem().toString() + ":" + end_secod_combo.getSelectedItem().toString() + ":00";
     
     SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
     Date start = format.parse(startTime);
     Date end = format.parse(endTime);
     
     long difference = end.getTime() - start.getTime();
    
     //long diffSeconds = diff / 1000 % 60;
    // long diffMinutes = diff / (60 * 1000) % 60;
    // long diffHours = diff / (60 * 60 * 1000) % 24;
    //long diffDays = diff / (24 * 60 * 60 * 1000);
     
     long diffMinutes = difference / (60 * 1000);
     
      DB_Connection con = new DB_Connection();
    
       String insert = "INSERT INTO class(year, date, staff_id, sem_year_sub_id, start_time, end_time, hours) "
               + "VALUES('"+year+"', '"+d+"', "+staffId+", "+semSubjectId+", '"+startTime+"', '"+endTime+"', "+diffMinutes+")";
       int id = con.register(insert);
       int staffRaw = staff_table.getSelectedRow();
       String lecName = staff_table.getValueAt(staffRaw, 1).toString() + " " + staff_table.getValueAt(staffRaw, 2);
       DefaultTableModel tableModel = (DefaultTableModel)class_table.getModel();
       Object[] arr = new Object[]{id,d, semester_year_table.getValueAt(semester_year_table.getSelectedRow(), 2), 
           semester_year_table.getValueAt(semester_year_table.getSelectedRow(), 1), lecName, startTime, endTime, diffMinutes};
       tableModel.addRow(arr);
       
       JOptionPane.showMessageDialog(null, "Saved Successfully", "information box" 
                        + "Inform", JOptionPane.INFORMATION_MESSAGE); 
           }
        } catch (Exception e) {
            e.printStackTrace();
     
        }
 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        new Class_Details().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void start_hour_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start_hour_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_start_hour_comboActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            if (semester_year_table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Please select semester year subject from table", "information box"
                + "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {
            DefaultTableModel tableModel = (DefaultTableModel)class_table.getModel();
            tableModel.setRowCount(0);
            int selectRaw = semester_year_table.getSelectedRow();
            String semYearSubId = semester_year_table.getValueAt(selectRaw, 0).toString();
            String sem = "select c.class_id, c.date, s.subject_code, s.subject_name , st.first_name , st.last_name , "
                    + "c.start_time ,c.end_time ,c.hours from class c inner join semester_year_subject sys on c.sem_year_sub_id = sys.sem_year_sub_id "
                    + "inner join subject s on sys.subject_id = s.subject_id "
                    + "inner join staff st on c.staff_id = st.staff_id where sys.sem_year_sub_id = "+semYearSubId+" ";
            
            DB_Connection con = new DB_Connection();
            ResultSet classResult = con.search(sem);
            
            while (classResult.next()) {                
                
                 Object[] arr = new Object[]{classResult.getInt("class_id"), classResult.getString("date"), classResult.getString("subject_code"), 
                 classResult.getString("subject_name"), classResult.getString("first_name") + " " + classResult.getString("last_name"), 
                 classResult.getString("start_time"), classResult.getString("end_time"), classResult.getInt("hours")};
                 tableModel.addRow(arr);
            }
           
            while (classResult.next()) {                
                
            }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
        new MainApplication().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(Mark_Claass_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mark_Claass_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mark_Claass_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mark_Claass_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mark_Claass_Details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JYearChooser academic_year_text;
    private javax.swing.JTable class_table;
    private com.toedter.calendar.JDateChooser dateChooserCombo1;
    private javax.swing.JComboBox<String> department_combox;
    private javax.swing.JTextField department_text;
    private javax.swing.JComboBox end_hour_combo;
    private javax.swing.JComboBox end_secod_combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField sem_yearLevel_text;
    private javax.swing.JComboBox<String> semester_combox;
    private javax.swing.JTextField semester_level_text;
    private javax.swing.JToggleButton semester_search_text;
    private javax.swing.JComboBox<String> semester_year_combox;
    private javax.swing.JLabel semester_year_detail_lab;
    private javax.swing.JTable semester_year_table;
    private javax.swing.JTable staff_table;
    private javax.swing.JTextField staff_txt;
    private javax.swing.JComboBox start_hour_combo;
    private javax.swing.JComboBox start_secod_combo;
    // End of variables declaration//GEN-END:variables
}
