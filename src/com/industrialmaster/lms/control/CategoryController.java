
package com.industrialmaster.lms.control;


import com.industrialmaster.lms.model.Category;
import com.industrialmaster.tms.util.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CategoryController {
    
        public static  boolean save(Category category){
    
         //3.Store in the database
       //a. SQL statement
       String sql = "INSERT INTO category" + "(category,category_persian) VALUES "+
       "(?,?)";
       
     try{
         //b. DB connection
         Connection con = DB.getCon();
         
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,category.getCategory());
       ps.setString(2,category.getCategory_persian());
      
      
       //d. ExecuteUpdate();
       ps.executeUpdate();
      
       return true;
       }catch(Exception ex){
       ex.printStackTrace();
      return false;
       }
    }
    
        
              public static List<Category> getAll(){// Generics have been used
    
    List<Category> list = new ArrayList<Category>();
    //a.SQL statement
    String sql = "SELECT * FROM category";
    //b.database connection
    try{
    Connection con = DB.getCon();
    
    //c. Prepare statement and execute
    PreparedStatement ps = con.prepareStatement(sql);
    
    ResultSet rs = ps.executeQuery();// this is the result set
    
    while(rs.next()){ //while there is a next
    Category category = new Category();
    category.setId(rs.getInt("id"));
    category.setCategory(rs.getString("category"));
    category.setCategory_persian(rs.getString("category_persian"));
   
    list.add(category);
    }
    
    }catch(Exception e){
    e.printStackTrace();
    } 
    return list;
    }
        
    
     public static Category getOne(int id){
    
    Category category = new Category();
    try{
     Connection con = DB.getCon();
     
     String sql = "SELECT * FROM category WHERE id=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, id);
     ResultSet rs = ps.executeQuery();
     if(rs.next()){
     category.setId(rs.getInt("id"));
     category.setCategory(rs.getString("category"));
     category.setCategory_persian(rs.getString("category_persian"));
     
   
     }
     
    }catch(Exception e){
    e.printStackTrace();
    }
    return category;
    }
      
    
     public static  boolean update(Category catg){
         //3.Store in the database
       //a. SQL statement
       String sql = "UPDATE category SET" + 
               "category=?, category_persian=?" +
               "WHERE id=?";
       
     try{
         //b. DB connection
         Connection con = DB.getCon();
         
         
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,catg.getCategory());
       ps.setString(2,catg.getCategory_persian());
       
      
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
       String sql = "DELETE FROM category WHERE id=?";
       
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
