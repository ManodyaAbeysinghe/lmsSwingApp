
package com.industrialmaster.lms.control;

import com.industrialmaster.lms.model.Book;
import com.industrialmaster.tms.util.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class BookController {
      public static  boolean save(Book book){
    
         //3.Store in the database
       //a. SQL statement
       String sql = "INSERT INTO book" + "(title, pages,language_id, edition) VALUES "+
       "(?,?,?,?)";
       
     try{
         //b. DB connection
         Connection con = DB.getCon();
         
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,book.getTitle());
       ps.setString(2,book.getPages());
       ps.setString(3,book.getLanguage_id());
       ps.setString(4,book.getEdition());
      
       //d. ExecuteUpdate();
       ps.executeUpdate();
      
       return true;
       }catch(Exception ex){
       ex.printStackTrace();
      return false;
       }
    }
      
       public static List<Book> getAll(){// Generics have been used
    
    List<Book> list = new ArrayList<Book>();
    //a.SQL statement
    String sql = "SELECT * FROM book";
    //b.database connection
    try{
    Connection con = DB.getCon();
    
    //c. Prepare statement and execute
    PreparedStatement ps = con.prepareStatement(sql);
    
    ResultSet rs = ps.executeQuery();// this is the result set
    
    while(rs.next()){ //while there is a next
    Book book = new Book();
    book.setId(rs.getInt("id"));
    book.setTitle(rs.getString("title"));
    book.setPages(rs.getString("pages"));
    book.setLanguage_id(rs.getString("language_id"));
    book.setEdition(rs.getString("edition"));
    list.add(book);
    }
    
    }catch(Exception e){
    e.printStackTrace();
    } 
    return list;
    } 
      
      public static Book getOne(int id){
    
    Book book = new Book();
    try{
     Connection con = DB.getCon();
     
     String sql = "SELECT * FROM book WHERE id=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, id);
     ResultSet rs = ps.executeQuery();
     if(rs.next()){
     book.setId(rs.getInt("id"));
     book.setTitle(rs.getString("title"));
     book.setPages(rs.getString("pages"));
     book.setLanguage_id(rs.getString("language_id"));
   
     }
     
    }catch(Exception e){
    e.printStackTrace();
    }
    return book;
    }
       
      
      
        public static  boolean update(Book book){
    
        
         //3.Store in the database
       //a. SQL statement
       String sql = "UPDATE book SET" + 
               "title=?, pages=?,language_id=?,edition=?" +
               "WHERE id=?";
       
     try{
         //b. DB connection
         Connection con = DB.getCon();
         
         
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,book.getTitle());
       ps.setString(2,book.getPages());
       ps.setString(3,book.getLanguage_id());
       ps.setString(4,book.getEdition());
       
       
       
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
       String sql = "DELETE FROM book WHERE id=?";
       
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
