/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    

/**
 *
 * @author jahmo
 */
 
 

public class CourseEntry{
       
    private String courseCode;
    private String description;
    
    //constructors method use the name of the overall class 
    public CourseEntry(String courseCode, String description){
        
        this.courseCode = courseCode;
        this.description = description;
        
    }
                
 
        public String getCourseCode(){
        return courseCode;
    
        
} 
        public String getCourseDescription(){
        
            return description;
    }
    
}

    



               


       
          
   
  
