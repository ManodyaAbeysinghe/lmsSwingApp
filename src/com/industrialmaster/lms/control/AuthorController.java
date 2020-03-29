
package com.industrialmaster.lms.control;

import com.industrialmaster.lms.model.Author;
import com.industrialmaster.tms.util.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class AuthorController {
   
       public static  boolean save(Author author){
    
         //3.Store in the database
       //a. SQL statement
       String sql = "INSERT INTO author" + "(firstname,lastname) VALUES "+
       "(?,?)";
       
     try{
         //b. DB connection
         Connection con = DB.getCon();
         
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,author.getFirstname());
       ps.setString(2,author.getLastname());
     
       //d. ExecuteUpdate();
       ps.executeUpdate();
      
       return true;
       }catch(Exception ex){
       ex.printStackTrace();
      return false;
       }
    }
       
       
       
          public static List<Author> getAll(){// Generics have been used
    
    List<Author> list = new ArrayList<Author>();
    //a.SQL statement
    String sql = "SELECT * FROM author";
    //b.database connection
    try{
    Connection con = DB.getCon();
    
    //c. Prepare statement and execute
    PreparedStatement ps = con.prepareStatement(sql);
    
    ResultSet rs = ps.executeQuery();// this is the result set
    
    while(rs.next()){ //while there is a next
    Author author = new Author();
    author.setId(rs.getInt("id"));
    author.setFirstname(rs.getString("firstname"));
    author.setLastname(rs.getString("lastname"));
   
    list.add(author);
    }
    
    }catch(Exception e){
    e.printStackTrace();
    } 
    return list;
    }
          
          
    public static Author getOne(int id){
    
    Author author = new Author();
    try{
     Connection con = DB.getCon();
     
     String sql = "SELECT * FROM author WHERE id=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, id);
     ResultSet rs = ps.executeQuery();
     if(rs.next()){
     author.setId(rs.getInt("id"));
     author.setFirstname(rs.getString("firstname"));
     author.setLastname(rs.getString("lastname"));
     
   
     }
     
    }catch(Exception e){
    e.printStackTrace();
    }
    return author;
    }
          
    
     public static  boolean update(Author author){
    
        
         //3.Store in the database
       //a. SQL statement
       String sql = "UPDATE author SET" + 
               "firstname=?, lastname=?" +
               "WHERE id=?";
       
     try{
         //b. DB connection
         Connection con = DB.getCon();
         
         
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,author.getFirstname());
       ps.setString(2,author.getLastname());
       
       
       
       
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
       String sql = "DELETE FROM author WHERE id=?";
       
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
