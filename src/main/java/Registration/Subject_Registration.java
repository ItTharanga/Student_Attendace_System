/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

import DB_Connection.DB_Connection;
import Login.CommonDetails;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import main.MainApplication;

/**
 *
 * @author Dell
 */
public class Subject_Registration extends javax.swing.JFrame {

    /**
     * Creates new form Subject_Registration
     */
    public Subject_Registration() {
        initComponents();
        department();
        CommonDetails.centerScreen(this);
        
    }
    public void clearSubjectTable (){
    
         DefaultTableModel model = (DefaultTableModel) subject_details_table.getModel();
         model.setRowCount(0);
    }
    public boolean isSubjectExist(String code) {
    
        try {
            String sql = "select * from subject where subject_code = '"+code+"'";
            
            DB_Connection con = new DB_Connection();
            ResultSet r = con.search(sql);
            
            if (r.next()) {
                return true;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public void cleartextfields() {
    name_text.setText("");
    code_text.setText("");
        
    }
    public void department(){
        String sql="select department_id,department_name from department";
        DB_Connection con = new DB_Connection();
        ResultSet r= con.search(sql);
       try{ 
            DefaultTableModel model = (DefaultTableModel) department_table.getModel();
            while(r.next()){
                model.addRow(new Object[]{r.getString("department_id"),r.getString("department_name")});
               
            }
         }

        catch(Exception ex){
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

        jSlider1 = new javax.swing.JSlider();
        jToggleButton4 = new javax.swing.JToggleButton();
        name_text = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        code_text = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        subject_details_table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        department_table = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        sub_search_cmb = new javax.swing.JComboBox<>();
        jToggleButton2 = new javax.swing.JToggleButton();
        search_txt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToggleButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jToggleButton4.setText("Update");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 160, 90, 30));

        name_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_textActionPerformed(evt);
            }
        });
        getContentPane().add(name_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 150, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Subject Code");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, -1, 30));

        code_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                code_textActionPerformed(evt);
            }
        });
        getContentPane().add(code_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 150, 30));

        jToggleButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jToggleButton1.setText("Save");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 160, 100, 30));

        subject_details_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject ID", "Subject Name", "Subject Code", "Department ID", "department Name"
            }
        ));
        jScrollPane3.setViewportView(subject_details_table);
        if (subject_details_table.getColumnModel().getColumnCount() > 0) {
            subject_details_table.getColumnModel().getColumn(3).setMinWidth(0);
            subject_details_table.getColumnModel().getColumn(3).setPreferredWidth(0);
            subject_details_table.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 490, 210));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Department Details");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 200, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("Subject Registraction");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, 50));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Main Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 470, 160, 30));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 470, -1, 30));

        jToggleButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jToggleButton6.setText("Edit");
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 210, 100, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        department_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Department ID", "Department Name"
            }
        ));
        jScrollPane1.setViewportView(department_table);
        if (department_table.getColumnModel().getColumnCount() > 0) {
            department_table.getColumnModel().getColumn(0).setMinWidth(0);
            department_table.getColumnModel().getColumn(0).setPreferredWidth(0);
            department_table.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 290, 260));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 440, 320));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Subject Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 100, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("*");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 130, 20, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
        jLabel20.setText("*");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 20, 30));

        sub_search_cmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sub Name", "Code" }));
        getContentPane().add(sub_search_cmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 160, 30));

        jToggleButton2.setText("Search");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 210, 100, 30));

        search_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_txtActionPerformed(evt);
            }
        });
        getContentPane().add(search_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, 120, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed

    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void name_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_textActionPerformed

    private void code_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_code_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_code_textActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        try {
            int row = department_table.getSelectedRow();
            if (name_text.getText().equals("") || code_text.getText().equals("")) {
                JOptionPane.showMessageDialog( null,"Please enter required fields", "information box" + "Warning", JOptionPane.INFORMATION_MESSAGE);
            }else if (row == -1) {
                JOptionPane.showMessageDialog( null,"Please select Department from department table", "information box" + "Warning", JOptionPane.INFORMATION_MESSAGE);
            }else if (isSubjectExist(code_text.getText())) {
                JOptionPane.showMessageDialog( null,"This subject is already exist", "information box" + "Warning", JOptionPane.INFORMATION_MESSAGE);
                }else {
                int id = Integer.valueOf(department_table.getModel().getValueAt(row, 0).toString());
                String departmentName = department_table.getModel().getValueAt(row, 1).toString();
                String sql = "insert into subject(subject_name,subject_code,department_id)values('"+name_text.getText()+"','"+code_text.getText()+"',"+id+")";
                DB_Connection con = new DB_Connection();
                int subjectId = con.register(sql);
                DefaultTableModel model = (DefaultTableModel) subject_details_table.getModel();

                model.addRow(new Object[]{subjectId,name_text.getText(),code_text.getText(),id,departmentName});
                department_table.clearSelection();
                cleartextfields();
                
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new MainApplication().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        try {
            clearSubjectTable();
            String sql = "select s.*, d.department_id, d.department_name from subject s inner join department d on s.department_id = d.department_id where ";
            
            if (search_txt.getText().equals("")) {
              JOptionPane.showMessageDialog( null,"Please enter subject name or code for search", "information box" + "Warning", JOptionPane.INFORMATION_MESSAGE);
            }
            
            else if (sub_search_cmb.getSelectedItem().equals("Sub Name")) {
            
                sql = sql + " s.subject_name like '"+search_txt.getText()+"%'";
            } else {
            
                sql = sql + "s.subject_code = '"+search_txt.getText()+"'";        
            }
            DB_Connection con = new DB_Connection();
            ResultSet r = con.search(sql);
            DefaultTableModel model = (DefaultTableModel) subject_details_table.getModel();
            while (r.next()) {
                model.addRow(new Object[]{r.getString("subject_id"), r.getString("subject_name"),
                    r.getString("subject_code"), r.getString("department_id"), r.getString("department_name")});              
            }
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void search_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_txtActionPerformed

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
            java.util.logging.Logger.getLogger(Subject_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Subject_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Subject_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Subject_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Subject_Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField code_text;
    private javax.swing.JTable department_table;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JTextField name_text;
    private javax.swing.JTextField search_txt;
    private javax.swing.JComboBox<String> sub_search_cmb;
    private javax.swing.JTable subject_details_table;
    // End of variables declaration//GEN-END:variables
}