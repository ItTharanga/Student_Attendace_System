/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting;

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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import main.MainApplication;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

/**
 *
 * @author Dell
 */
public class AttendanceReport extends javax.swing.JFrame {

    /**
     * Creates new form Class_Details
     */
    public AttendanceReport() {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        department_combox = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        class_table = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 680, 290));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Date");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 50, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Student's Attendance Details Records");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 340, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 0));
        jButton4.setText("Main Menu");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 650, 160, 30));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("Exit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 650, -1, 30));

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
        getContentPane().add(department_combox, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, 30));

        jButton7.setText("Load Class Details");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 330, 30));

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
            class_table.getColumnModel().getColumn(5).setMinWidth(0);
            class_table.getColumnModel().getColumn(5).setPreferredWidth(0);
            class_table.getColumnModel().getColumn(5).setMaxWidth(0);
            class_table.getColumnModel().getColumn(6).setMinWidth(0);
            class_table.getColumnModel().getColumn(6).setPreferredWidth(0);
            class_table.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 680, 130));

        jButton8.setText("Search this class Student's attendance");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 680, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("*");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 30, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setText("*");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 30, 20));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 590, 70, 30));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 240, 40, 20));
        getContentPane().add(dateChooserCombo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 130, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
        new MainApplication().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            
            if (dateChooserCombo1.getDate() != null && department_combox.getSelectedIndex() != 0) {
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
                DefaultTableModel model = (DefaultTableModel)class_table.getModel();
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

    private void department_comboxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_department_comboxPropertyChange
        CommonDetails.selectedDepartment = department_combox.getSelectedItem().toString();
    }//GEN-LAST:event_department_comboxPropertyChange

    private void department_comboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department_comboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_department_comboxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int raw = class_table.getSelectedRow();
            if (raw == -1) {
            JOptionPane.showMessageDialog(null, "Search attendance details", "information box" 
                        + "Inform", JOptionPane.INFORMATION_MESSAGE);
            } else {
            JRTableModelDataSource dt = new JRTableModelDataSource(attendance_tab.getModel());
            
            String date = class_table.getValueAt(raw, 1).toString();
            String subCode = class_table.getValueAt(raw, 2).toString();
            String subject = class_table.getValueAt(raw, 3).toString();
            String lecture = class_table.getValueAt(raw, 4).toString();
            Map para = new HashMap();
            para.put("date", date);
            para.put("sub_code", subCode);
            para.put("subject", subject);
            para.put("lecture", lecture);

            JasperReport jr = JasperCompileManager.compileReport("C:\\jasper\\Blank_A4_2.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr, para, dt);
            JasperViewer.viewReport(jp, false);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed
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
            java.util.logging.Logger.getLogger(AttendanceReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AttendanceReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AttendanceReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AttendanceReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AttendanceReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable attendance_tab;
    private javax.swing.JTable class_table;
    private com.toedter.calendar.JDateChooser dateChooserCombo1;
    private javax.swing.JComboBox<String> department_combox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel sub_id_txt;
    // End of variables declaration//GEN-END:variables


}
