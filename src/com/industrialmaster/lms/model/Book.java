
package com.industrialmaster.lms.model;


public class Book {

  
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

   
    public String getTitle() {
        return title;
    }

  
    public void setTitle(String title) {
        this.title = title;
    }

   
    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(String language_id) {
        this.language_id = language_id;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }
    
     private int id;
    
    private String title;
    private String pages;
    private String language_id;
    private String edition;
}
