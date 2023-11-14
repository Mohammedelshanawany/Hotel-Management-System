/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author MohamedNouh
 */
public class tables {
    public static Connection getcon() {
         try{
    String url ="jdbc:oracle:thin:@localhost:1521:orcl";
     String driver = "oracle.jdbc.OracleDriver";
      String username ="hr";
        String pass ="hr";
    Class.forName(driver);
     
              Connection con = DriverManager.getConnection(url, username, pass);
              
              return con;
             
         }catch(Exception e){
         
         return null;
         
         }
         
    
}

    
     public static void Insert(String query,String msg){
     
     Connection con =null;
     Statement st =null;
     try{
     
     con= getcon();
     st=con.createStatement();
     st.executeUpdate(query);
     if(!msg.equals(""))
         JOptionPane.showMessageDialog(null, msg);
        }catch(Exception e ){
     
         JOptionPane.showMessageDialog(null, e);
            }
     
     }
     public static ResultSet select(String query){
     
         Connection con =null;
         Statement st=null;
         ResultSet rs=null;
         try{
         con=getcon();
         st=con.createStatement();
         rs=st.executeQuery(query);
         return rs;
         
         }catch(Exception e){
         
         JOptionPane.showMessageDialog(null, e);
         return null;
         }
     
     
     }
}
