/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testbd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;
import java.util.Scanner;


/**
 *
 * @author e10934a
 */
public class test {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        
        String directorio = System.getProperty("user.dir");
        String separador = System.getProperty("file.separator");
        //System.out.println(directorio + separador);
        
        Properties p = new Properties();
        p.load(new FileReader(directorio + separador + "conf" + separador + "system.properties"));
        String url = p.getProperty("url");
        String user = p.getProperty("user");
        String pass = p.getProperty("pass");
        String tipo = p.getProperty("bd");
        
        bd t1,t2;
        //String tipo = args[0];
        //System.out.println(tipo);
        
        
        switch(tipo){
            case "1": t1 = new oracleSQL();
                      t1.test(url, user, pass);
                      break;
            
            case "2": t2 = new microsoftSQL();
                      t2.test(url, user, pass);
                      break;
        }
        
       pressAnyKeyToContinue();
        
    }
    
     static public void pressAnyKeyToContinue()
      { 
          String seguir = "";
          Scanner teclado = new Scanner(System.in);
          System.out.println("Press Enter key to continue...");
          try
            {
             seguir = teclado.nextLine();
            }   
         catch(Exception e)
          {}  
     }   
     
   
    
}
