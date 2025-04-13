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


public class ClassQueries {
    
    private static Connection connection;
    private static PreparedStatement addClass;
    private static PreparedStatement getAllCourseCodes;
    private static PreparedStatement getClassSeats;
    private static PreparedStatement dropClass;
    private static ResultSet resultSet;
    
    
    public static void addClass(ClassEntry Class){
        connection = DBConnection.getConnection();
        try
        {
            addClass = connection.prepareStatement("insert into app.class (semester, CourseCode, Seats) values (?,?,?)");
            //information from the basic class is now being used and sent to the database
            addClass.setString(1,Class.getSemester());
            addClass.setString(2,Class.getCourseCode());
            addClass.setInt(3,Class.getSeats());

            addClass.executeUpdate();
        }
        
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    
   //Creating a class that will have an array as a return value
    public static ArrayList<String> getAllCourseCodes(String Semester)
    {   //establishing a connection to the database
        connection = DBConnection.getConnection();
        //creating an arraylist that will store strings, is named "course"
        ArrayList<String> course = new ArrayList<String>();
        try
        {   
            getAllCourseCodes = connection.prepareStatement("select courseCode from app.course order by coursecode");
            resultSet = getAllCourseCodes.executeQuery();
            //need help understanding this loop 
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
    //I need help with getClassSeats not sure how to complete it and not sure what's going on. 
   public static int getClassSeats(String semester, String courseCode){
        int seatCount = 0;
         
        connection = DBConnection.getConnection();
        try
        {   //creating a query statement, we are selecting the seats column from the "class" table. I do not understand the rest of the query statement. 
            getClassSeats = connection.prepareStatement("select seats from app.class where semester = ? and Coursecode = ?");
            getClassSeats.setString(1,semester);
            getClassSeats.setString(2,courseCode);
            resultSet = getClassSeats.executeQuery();
            
            while(resultSet.next())
            {   //not understanding 
                seatCount = resultSet.getInt(1);
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return seatCount;
       
   }
   
    public static void dropClass(String semester, String courseCode) {
        connection = DBConnection.getConnection();
        try {
            dropClass = connection.prepareStatement("DELETE FROM app.class WHERE semester = ? AND CourseCode = ?");
            dropClass.setString(1, semester);
            dropClass.setString(2, courseCode);
            dropClass.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }   
    
    }
            
    


