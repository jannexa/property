/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author JULIANNE
 */
public class session {
    public static session instance;
   private int uid;
   private String firstname;
   private String lastname;
   private String username;
   private String email;
   private String status;
   private String type;
   
   
   private session(){
   //Private cons. prevents instance    
   }
      public static synchronized session getInstance(){
     if(instance == null){ 
         instance = new session();   
     }
     return instance;
    }
    public static boolean setInstanceEmpty() {
        return instance == null;
  
    }
  public int getUid() {
        return uid = uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
   
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String name) {
        this.firstname = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isInstanceEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
