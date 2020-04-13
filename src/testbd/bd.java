/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testbd;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 *
 * @author e10934a
 */
public abstract class bd {
    
 protected String DB_URL = "";
 protected String USER = "";
 protected String PASS = ""; 
 URLClassLoader urlcl;

 
 public bd (String url, String user, String pass) throws MalformedURLException{
     this.DB_URL = url;
     this.USER = user;
     this.PASS = pass;
 
 }
 
 public bd(){}
 
    public abstract void test(String url, String user, String pass);
}
