
package com.industrialmaster.lms.control;

import com.industrialmaster.lms.model.City;
import com.industrialmaster.tms.util.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CityController {
  
public static  boolean save(City cty){
    
         //3.Store in the database
       //a. SQL statement
       String sql = "INSERT INTO city" + "(city,city_persian) VALUES "+
       "(?,?)";
       
     try{
         //b. DB connection
         Connection con = DB.getCon();
         
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,cty.getCity());
       ps.setString(2,cty.getCity_persian());
      
      
       //d. ExecuteUpdate();
       ps.executeUpdate();
      
       return true;
       }catch(Exception ex){
       ex.printStackTrace();
      return false;
       }
    }          

    

public static List<City> getAll(){// Generics have been used
    
    List<City> list = new ArrayList<City>();
    //a.SQL statement
    String sql = "SELECT * FROM city";
    //b.database connection
    try{
    Connection con = DB.getCon();
    
    //c. Prepare statement and execute
    PreparedStatement ps = con.prepareStatement(sql);
    
    ResultSet rs = ps.executeQuery();// this is the result set
    
    while(rs.next()){ //while there is a next
    City cty = new City();
    cty.setId(rs.getInt("id"));
    cty.setCity(rs.getString("city"));
    cty.setCity_persian(rs.getString("city_persian"));
   
    list.add(cty);
    }
    
    }catch(Exception e){
    e.printStackTrace();
    } 
    return list;
    }

public static City getOne(int id){
    
     City cty = new City();
    try{
     Connection con = DB.getCon();
     
     String sql = "SELECT * FROM city WHERE id=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, id);
     ResultSet rs = ps.executeQuery();
     if(rs.next()){
     cty.setId(rs.getInt("id"));
     cty.setCity(rs.getString("city"));
     cty.setCity_persian(rs.getString("city_persian"));
     
   
     }
     
    }catch(Exception e){
    e.printStackTrace();
    }
    return cty;
    }


public static  boolean update(City cty){
    
        
         //3.Store in the database
       //a. SQL statement
       String sql = "UPDATE city SET" + 
               "city=?, city_persian=?" +
               "WHERE id=?";
       
     try{
         //b. DB connection
         Connection con = DB.getCon();
         
         
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1,cty.getCity());
       ps.setString(2,cty.getCity_persian());
       
       
       
       
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
       String sql = "DELETE FROM city WHERE id=?";
       
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
