
package com.industrialmaster.lms.model;


public class User {
 int id;
private String fname;
private String lname;
private String faculty_id;
private String semester_id;
private String email;

    
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public String getFname() {
        return fname;
    }

    
    public void setFname(String fname) {
        this.fname = fname;
    }

    
    public String getLname() {
        return lname;
    }

    
    public void setLname(String lname) {
        this.lname = lname;
    }

    
    public String getFaculty_id() {
        return faculty_id;
    }

   
    public void setFaculty_id(String faculty_id) {
        this.faculty_id = faculty_id;
    }

    
    public String getSemester_id() {
        return semester_id;
    }

    
    public void setSemester_id(String semester_id) {
        this.semester_id = semester_id;
    }

    
    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }
}
