/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.industrialmaster.lms.control;

import com.industrialmaster.lms.model.Deposits;
import com.industrialmaster.tms.util.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MN
 */
public class DepositsController {
 
   
     public static  boolean save(Deposits deposit){
    
         //3.Store in the database
       //a. SQL statement
       String sql = "INSERT INTO deposits" + "(user_id,copy_id,deposit_date, due_date) VALUES "+
       "(?,?,?,?)";
       
     try{
         //b. DB connection
         Connection con = DB.getCon();
         
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,deposit.getUser_id());
       ps.setString(2,deposit.getCopy_id());
        ps.setString(3,deposit.getDeposit_date());
       ps.setString(4,deposit.getDue_date());
      
      
       //d. ExecuteUpdate();
       ps.executeUpdate();
      
       return true;
       }catch(Exception ex){
       ex.printStackTrace();
      return false;
       }
    } 
    
    public static List<Deposits> getAll(){// Generics have been used
    
    List<Deposits> list = new ArrayList<Deposits>();
    //a.SQL statement
    String sql = "SELECT * FROM deposits";
    //b.database connection
    try{
    Connection con = DB.getCon();
    
    //c. Prepare statement and execute
    PreparedStatement ps = con.prepareStatement(sql);
    
    ResultSet rs = ps.executeQuery();// this is the result set
    
    while(rs.next()){ //while there is a next
    Deposits deposit = new Deposits();
    deposit.setId(rs.getInt("id"));
    deposit.setUser_id(rs.getString("user_id"));
    deposit.setCopy_id(rs.getString("copy_id"));
    deposit.setDeposit_date(rs.getString("deposit_date"));
    deposit.setDue_date(rs.getString("due_date"));
   
    list.add(deposit);
    }
    
    }catch(Exception e){
    e.printStackTrace();
    } 
    return list;
    }
    
    
    
    public static Deposits getOne(int id){
    
     Deposits deposit = new Deposits();
    try{
     Connection con = DB.getCon();
     
     String sql = "SELECT * FROM deposits WHERE id=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, id);
     ResultSet rs = ps.executeQuery();
     if(rs.next()){
     deposit.setId(rs.getInt("id"));
    deposit.setUser_id(rs.getString("user_id"));
    deposit.setCopy_id(rs.getString("copy_id"));
    deposit.setDeposit_date(rs.getString("deposit_date"));
    deposit.setDue_date(rs.getString("due_date"));
     
   
     }
     
    }catch(Exception e){
    e.printStackTrace();
    }
    return deposit;
    }
    
    
    
    public static  boolean update(Deposits deposit){
    
        
         //3.Store in the database
       //a. SQL statement
       String sql = "UPDATE deposits SET" + 
               "user_id=?, copy_id=?, deposits_date=?,due_date=? " +
               "WHERE id=?";
       
     try{
         //b. DB connection
         Connection con = DB.getCon();
         
         
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,deposit.getUser_id());
       ps.setString(2,deposit.getCopy_id());
       ps.setString(3,deposit.getDeposit_date());
        ps.setString(4,deposit.getDue_date());
       
       
       
       
       //d. ExecuteUpdate();
       ps.executeUpdate();
      
      
       return true;
       }catch(Exception ex){
       ex.printStackTrace();
      return false;
       }
    }
    
    
    
    
    public static  boolean delete(int id){
    
         //3.Store in the database
       //a. SQL statement
       String sql = "DELETE FROM deposits WHERE id=?";
       
     try{
         //b. DB connection
         Connection con = DB.getCon();
         
         
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setInt(1,id);
      
       //d. ExecuteUpdate();
       ps.executeUpdate();
      
      
       return true;
       }catch(Exception ex){
       ex.printStackTrace();
      return false;
       }
    }
    
   
    
}
