/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testbd;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author e10934a
 */


public class oracleSQL extends bd{

    
    @Override
    public void test(String url, String user, String pass){
   
          
    try { 
      //cargo el driver jdbc, debe estar en la libreria o en el classpath  
     Class.forName("oracle.jdbc.driver.OracleDriver");
     // System.out.println("Connecting to database...");    
      
     //establece la conexion a la bd 
      Connection conn = DriverManager.getConnection(url,user,pass);    
      
      DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
      System.out.println("Driver name: " + dm.getDriverName());
      System.out.println("Driver version: " + dm.getDriverVersion());
      System.out.println("Product name: " + dm.getDatabaseProductName());
      System.out.println("Product version: " + dm.getDatabaseProductVersion());
                
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("select sysdate from dual");
      //levanto la primera fila de la bd
      rs.next();
      System.out.println("-----------------------------------------------------------------------------------");
      System.out.print("Conexion bd ORACLE -> EXITOSA   ### Fecha de hoy BD: ");
      System.out.println(rs.getString(1) +" ###");
      System.out.println("-----------------------------------------------------------------------------------");
      conn.close();
     
      
    }   catch (SQLException ex) {
            Logger.getLogger(oracleSQL.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(oracleSQL.class.getName()).log(Level.SEVERE, null, ex);
        
        }
 }//end test  
    

}  