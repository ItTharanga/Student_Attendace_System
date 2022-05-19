/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author Dell
 */
public class DB_Connection {
private Connection c = null;


  
  public Connection getConnection() {
    try { 
        Class.forName("com.mysql.cj.jdbc.Driver");
        if(c==null){
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_attendance_system","root","MySql@1u23");
        }
    }
    
    catch (Exception ex) {
        System.out.println(ex);
    }
    return c;
}
  public int register(String quary) {
   int id = 0;
   try{
    System.out.println("sql =" + quary);
    PreparedStatement  st=getConnection().prepareStatement(quary, Statement.RETURN_GENERATED_KEYS);
    st.execute();
    
   ResultSet rs = st.getGeneratedKeys();
    if(rs.next()){
     id= rs.getInt(1);
     }
   }
   catch (SQLException ex) {
   System.out.println(ex);
   }
 return id;
  }
  
  public ResultSet search(String sql){
     ResultSet g=null;
    try {
        System.out.println("search = " + sql);
        java.sql.Statement st=getConnection().createStatement();   
        g= st.executeQuery(sql);
        
    } catch (SQLException ex) {
        Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
    }
   return g;
  }
  
}