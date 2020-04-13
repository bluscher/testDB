/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testbd;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author e10934a
 */
public class microsoftSQL extends bd{


    @Override
    public void test(String url, String user, String pass){
 
        try {
 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = null;
            conn = DriverManager.getConnection(url, user, pass);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
                Statement stmt = conn.createStatement();
               ResultSet rs = stmt.executeQuery("select sysdatetime();");
               //levanto la primera fila de la bd
               rs.next();  
              
               System.out.println("-----------------------------------------------------------------------------------");
               System.out.print("Conexion bd MS SQL -> EXITOSA   ### Fecha de hoy BD: ");
               System.out.println(rs.getString(1)+ " ###");
               
               System.out.println("-----------------------------------------------------------------------------------");
               conn.close();
            }
 
        } catch (SQLException ex) {
            Logger.getLogger(oracleSQL.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(microsoftSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
}
