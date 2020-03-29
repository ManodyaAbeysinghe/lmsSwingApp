/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.industrialmaster.lms.control;

import com.industrialmaster.lms.model.Gender;
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
public class GenderController {
    
    public static  boolean save(Gender gender){
    
         //3.Store in the database
       //a. SQL statement
       String sql = "INSERT INTO gender" + "(gender, gender_persian) VALUES "+
       "(?,?)";
       
     try{
         //b. DB connection
         Connection con = DB.getCon();
         
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,gender.getGender());
       ps.setString(2,gender.getGender_persian());
      
      
       //d. ExecuteUpdate();
       ps.executeUpdate();
      
       return true;
       }catch(Exception ex){
       ex.printStackTrace();
      return false;
       }
    }
      
       public static List<Gender> getAll(){// Generics have been used
    
    List<Gender> list = new ArrayList<Gender>();
    //a.SQL statement
    String sql = "SELECT * FROM gender";
    //b.database connection
    try{
    Connection con = DB.getCon();
    
    //c. Prepare statement and execute
    PreparedStatement ps = con.prepareStatement(sql);
    
    ResultSet rs = ps.executeQuery();// this is the result set
    
    while(rs.next()){ //while there is a next
    Gender gender = new Gender();
    gender.setId(rs.getInt("id"));
    gender.setGender(rs.getString("gender"));
    gender.setGender_persian(rs.getString("gender_persian"));
   
    list.add(gender);
    }
    
    }catch(Exception e){
    e.printStackTrace();
    } 
    return list;
    } 
      
      public static Gender getOne(int id){
    
    Gender gender = new Gender();
    try{
     Connection con = DB.getCon();
     
     String sql = "SELECT * FROM gender WHERE id=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, id);
     ResultSet rs = ps.executeQuery();
     if(rs.next()){
     gender.setId(rs.getInt("id"));
     gender.setGender(rs.getString("gender"));
     gender.setGender_persian(rs.getString("gender_persian"));
    
   
     }
     
    }catch(Exception e){
    e.printStackTrace();
    }
    return gender;
    }
       
      
      
        public static  boolean update(Gender gender){
    
        
         //3.Store in the database
       //a. SQL statement
       String sql = "UPDATE gender SET" + 
               "gender=?, gender_persian=?" +
               "WHERE id=?";
       
     try{
         //b. DB connection
         Connection con = DB.getCon();
         
         
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,gender.getGender());
       ps.setString(2,gender.getGender_persian());
       
       
       
       
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
       String sql = "DELETE FROM gender WHERE id=?";
       
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
