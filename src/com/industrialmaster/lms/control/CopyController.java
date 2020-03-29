
package com.industrialmaster.lms.control;

import com.industrialmaster.lms.model.Copy;
import com.industrialmaster.tms.util.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CopyController {
    public static  boolean save(Copy cpy){
    
         //3.Store in the database
       //a. SQL statement
       String sql = "INSERT INTO copies" + "(copy_id,status) VALUES "+
       "(?,?)";
       
     try{
         //b. DB connection
         Connection con = DB.getCon();
         
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,cpy.getCopy_id());
       ps.setString(2,cpy.getStatus());
      
      
       //d. ExecuteUpdate();
       ps.executeUpdate();
      
       return true;
       }catch(Exception ex){
       ex.printStackTrace();
      return false;
       }
    } 
    
    public static List<Copy> getAll(){// Generics have been used
    
    List<Copy> list = new ArrayList<Copy>();
    //a.SQL statement
    String sql = "SELECT * FROM copies";
    //b.database connection
    try{
    Connection con = DB.getCon();
    
    //c. Prepare statement and execute
    PreparedStatement ps = con.prepareStatement(sql);
    
    ResultSet rs = ps.executeQuery();// this is the result set
    
    while(rs.next()){ //while there is a next
    Copy cpy = new Copy();
    cpy.setId(rs.getInt("id"));
    cpy.setCopy_id(rs.getString("copy_id"));
    cpy.setStatus(rs.getString("status"));
   
    list.add(cpy);
    }
    
    }catch(Exception e){
    e.printStackTrace();
    } 
    return list;
    }
    
    
    
    public static Copy getOne(int id){
    
     Copy cpy = new Copy();
    try{
     Connection con = DB.getCon();
     
     String sql = "SELECT * FROM copies WHERE id=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, id);
     ResultSet rs = ps.executeQuery();
     if(rs.next()){
     cpy.setId(rs.getInt("id"));
     cpy.setCopy_id(rs.getString("copy_id"));
     cpy.setStatus(rs.getString("status"));
     
   
     }
     
    }catch(Exception e){
    e.printStackTrace();
    }
    return cpy;
    }
    
    
    
    public static  boolean update(Copy cpy){
    
        
         //3.Store in the database
       //a. SQL statement
       String sql = "UPDATE copies SET" + 
               "copy_id=?, status=?" +
               "WHERE id=?";
       
     try{
         //b. DB connection
         Connection con = DB.getCon();
         
         
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,cpy.getCopy_id());
       ps.setString(2,cpy.getStatus());
       
       
       
       
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
       String sql = "DELETE FROM copies WHERE id=?";
       
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


