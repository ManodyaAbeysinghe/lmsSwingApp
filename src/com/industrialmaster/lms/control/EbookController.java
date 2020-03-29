
package com.industrialmaster.lms.control;


import com.industrialmaster.lms.model.Ebook;
import com.industrialmaster.tms.util.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EbookController {
    
    public static boolean save(Ebook ebook){
     String sql = "INSERT INTO ebook" + "(book_id, extension) VALUES "+
       "(?,?)";
      
     try{
       Connection con = DB.getCon();
    PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1,ebook.getBook_id());
       ps.setString(2,ebook.getExtension());
       
    
    
    ps.executeUpdate();
    
    return true;
}catch(Exception ex){
ex.printStackTrace();
return false;
}
}
    
    
    
   public static List<Ebook> getAll(){// Generics have been used
    List<Ebook> list = new ArrayList<>();
    //a.SQL statement
    String sql = "SELECT * FROM ebook";
    //b.database connection
    try{
    Connection con = DB.getCon();
    //c. Prepare statement and execute
    PreparedStatement ps = con.prepareStatement(sql);
    
    ResultSet rs = ps.executeQuery();// this is the result set
    
    while(rs.next()){ //while there is a next
    Ebook ebook = new Ebook();
    ebook.setId(rs.getInt("id"));
    ebook.setBook_id(rs.getString("book_id"));
    ebook.setExtension(rs.getString("extension"));
    
    list.add(ebook);
    }
    
    }catch(Exception e){
    e.printStackTrace();
    } 
    return list;
    }
    
    
   
        public static Ebook getOne(int id){
    
    Ebook ebook = new Ebook();
    try{
     Connection con = DB.getCon();
     
     String sql = "SELECT * FROM ebook WHERE id=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, id);
     ResultSet rs = ps.executeQuery();
     if(rs.next()){
     ebook.setId(rs.getInt("id"));
     ebook.setBook_id(rs.getString("book_id"));
     ebook.setExtension(rs.getString("extension"));
     
     }
     
    }catch(Exception e){
    e.printStackTrace();
    }
    return ebook;
    }
      
      
     
   public static  boolean update(Ebook ebook){
         //3.Store in the database
       //a. SQL statement
       String sql = "UPDATE user SET" + 
               "book_id=?, extension=?" +
               "WHERE id=?";
       
     try{
         //b. DB connection
         Connection con = DB.getCon();
         
         
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,ebook.getBook_id());
       ps.setString(2,ebook.getExtension());
    
      
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
       String sql = "DELETE FROM ebook WHERE id=?";
       
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
