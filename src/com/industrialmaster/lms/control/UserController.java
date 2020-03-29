
package com.industrialmaster.lms.control;

import com.industrialmaster.lms.model.User;
import com.industrialmaster.tms.util.DB;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class UserController {
  
    public static boolean save(User user){
     String sql = "INSERT INTO user" + "(firstname, lastname, faculty_id,semester_id,email) VALUES "+
       "(?,?,?,?,?)";
      
     try{
       Connection con = DB.getCon();
    PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1,user.getFname());
       ps.setString(2,user.getLname());
       ps.setString(3,user.getFaculty_id());
       ps.setString(4,user.getSemester_id());
       ps.setString(5,user.getEmail());
    
    
    ps.executeUpdate();
    
    return true;
}catch(Exception ex){
ex.printStackTrace();
return false;
}
}
    
    
      public static List<User> getAll(){// Generics have been used
    List<User> list = new ArrayList<>();
    //a.SQL statement
    String sql = "SELECT * FROM user";
    //b.database connection
    try{
    Connection con = DB.getCon();
    //c. Prepare statement and execute
    PreparedStatement ps = con.prepareStatement(sql);
    
    ResultSet rs = ps.executeQuery();// this is the result set
    
    while(rs.next()){ //while there is a next
    User user = new User();
    user.setId(rs.getInt("id"));
    user.setFname(rs.getString("firstname"));
    user.setLname(rs.getString("lastname"));
    user.setFaculty_id(rs.getString("faculty_id"));
    user.setSemester_id(rs.getString("semester_id"));
    user.setEmail(rs.getString("email"));
    list.add(user);
    }
    
    }catch(Exception e){
    e.printStackTrace();
    } 
    return list;
    }
    
   
        public static User getOne(int id){
    
    User user = new User();
    try{
     Connection con = DB.getCon();
     
     String sql = "SELECT * FROM user WHERE id=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, id);
     ResultSet rs = ps.executeQuery();
     if(rs.next()){
     user.setId(rs.getInt("id"));
     user.setFname(rs.getString("firstname"));
     user.setLname(rs.getString("lastname"));
     user.setFaculty_id(rs.getString("faculty_id"));
     user.setSemester_id(rs.getString("semester_id"));
     user.setEmail(rs.getString("email"));
     }
     
    }catch(Exception e){
    e.printStackTrace();
    }
    return user;
    }
      
      
     
              public static  boolean update(User user){
         //3.Store in the database
       //a. SQL statement
       String sql = "UPDATE user SET" + 
               "firstname=?, lastname=?,faculty_id=?,semester_id=?,email=?" +
               "WHERE id=?";
       
     try{
         //b. DB connection
         Connection con = DB.getCon();
         
         
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,user.getFname());
       ps.setString(2,user.getLname());
       ps.setString(3,user.getFaculty_id());
       ps.setString(4,user.getSemester_id());
       ps.setString(5,user.getEmail());
      
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
       String sql = "DELETE FROM user WHERE id=?";
       
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