
package com.industrialmaster.lms.model;


public class Deposits {
     private int id;
   
   private String user_id;
   private String copy_id;
   private String deposit_date;
   private String due_date;

   
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public String getUser_id() {
        return user_id;
    }

    
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


    public String getCopy_id() {
        return copy_id;
    }


    public void setCopy_id(String copy_id) {
        this.copy_id = copy_id;
    }


    public String getDeposit_date() {
        return deposit_date;
    }


    public void setDeposit_date(String deposit_date) {
        this.deposit_date = deposit_date;
    }


    public String getDue_date() {
        return due_date;
    }


    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    
   
    
}
