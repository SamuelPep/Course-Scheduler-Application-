/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jahmo
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseQueries
        

{
    private static Connection connection;
    //Would I read this as "The variable addCourse is of type PreparedStatement"?
    private static PreparedStatement addCourse;
    private static PreparedStatement getAllCourseCodes;
    private static ResultSet resultSet;
    
    
    //The instance variables labeled above are automatically used to create methods, I have never seen this before, need more elaboration 
    
    
    //Where does "CourseEntry course" come from? When creating a method, wouldn't the argument space only contain instance variables created before?
    public static void addCourse(CourseEntry course)
    {
        connection = DBConnection.getConnection();
        try
        {
            addCourse = connection.prepareStatement("insert into app.course (coursecode, description) values (?,?)");
            addCourse.setString(1, course.getCourseCode());
            addCourse.setString(2,course.getCourseDescription());
            addCourse.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    
    //creating a method that will establish a connection to the database and extract coursecodes from the database, and store it in java
    //Why does this method have "ArrayList<String>"? wouldn't it just be void?
    public static ArrayList<String> getAllCourseCodes()
    {   //1.Is this the connection instance variable from DB connection class? I need this line explained to me 
        //2. Is .getConnection from the DB connection class? How are we able to use it here without inheritance?
        connection = DBConnection.getConnection();
        //creating an arraylist with the name "course" where the data that we extract from the database will be stored 
        ArrayList<String> course = new ArrayList<String>();
        //Query classes will always have try and catch 
        try
        {   //1.We name this variable the same name as the method? Why do we do this?
            //2.I don't get "order by" 
            //3.should COURSECODE and course be in lowercase?
            getAllCourseCodes = connection.prepareStatement("select coursecode from app.course order by coursecode");
            //what is this line below doing?
            resultSet = getAllCourseCodes.executeQuery();
            
            while(resultSet.next())
            {
                course.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return course;
        
    }
      
        
        
        
        
    
}
