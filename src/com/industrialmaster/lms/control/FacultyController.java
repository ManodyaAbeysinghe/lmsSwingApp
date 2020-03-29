
package com.industrialmaster.lms.control;

import com.industrialmaster.lms.model.Faculty;
import com.industrialmaster.tms.util.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class FacultyController {
    
     public static  boolean save(Faculty faculty){
    
         //3.Store in the database
       //a. SQL statement
       String sql = "INSERT INTO faculties" + "(faculty, faculty_persian) VALUES "+
       "(?,?)";
       
     try{
         //b. DB connection
         Connection con = DB.getCon();
         
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,faculty.getFaculty());
       ps.setString(2,faculty.getFaculty_persian());
      
      
       //d. ExecuteUpdate();
       ps.executeUpdate();
      
       return true;
       }catch(Exception ex){
       ex.printStackTrace();
      return false;
       }
    }
      
       public static List<Faculty> getAll(){// Generics have been used
    
    List<Faculty> list = new ArrayList<Faculty>();
    //a.SQL statement
    String sql = "SELECT * FROM faculties";
    //b.database connection
    try{
    Connection con = DB.getCon();
    
    //c. Prepare statement and execute
    PreparedStatement ps = con.prepareStatement(sql);
    
    ResultSet rs = ps.executeQuery();// this is the result set
    
    while(rs.next()){ //while there is a next
    Faculty faculty = new Faculty();
    faculty.setId(rs.getInt("id"));
    faculty.setFaculty(rs.getString("faculty"));
    faculty.setFaculty_persian(rs.getString("faculty_persian"));
   
    list.add(faculty);
    }
    
    }catch(Exception e){
    e.printStackTrace();
    } 
    return list;
    } 
      
      public static Faculty getOne(int id){
    
    Faculty faculty = new Faculty();
    try{
     Connection con = DB.getCon();
     
     String sql = "SELECT * FROM faculties WHERE id=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, id);
     ResultSet rs = ps.executeQuery();
     if(rs.next()){
     faculty.setId(rs.getInt("id"));
     faculty.setFaculty(rs.getString("faculty"));
     faculty.setFaculty_persian(rs.getString("faculty_persian"));
    
   
     }
     
    }catch(Exception e){
    e.printStackTrace();
    }
    return faculty;
    }
       
      
      
        public static  boolean update(Faculty faculty){
    
        
         //3.Store in the database
       //a. SQL statement
       String sql = "UPDATE faculties SET" + 
               "faculty=?, faculty_persian=?" +
               "WHERE id=?";
       
     try{
         //b. DB connection
         Connection con = DB.getCon();
         
         
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,faculty.getFaculty());
       ps.setString(2,faculty.getFaculty_persian());
       
       
       
       
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
       String sql = "DELETE FROM faculties WHERE id=?";
       
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
