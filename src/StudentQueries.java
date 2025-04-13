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

public class StudentQueries {
    
    private static Connection connection; 
    //why do we need this line?
    private static ArrayList<String> faculty = new ArrayList<String>();
    private static PreparedStatement addStudent;
    private static PreparedStatement getStudentList;
    private static ResultSet resultSet; 
    private static PreparedStatement dropStudent;


    
    
    
    
    public static void addStudent(StudentEntry student){
        connection = DBConnection.getConnection();
        try {
            addStudent = connection.prepareStatement("insert into app.student (firstName, lastName, studentID) values (?,?,?)");
            addStudent.setString(1, student.getFirstName());
            addStudent.setString(2, student.getLastName());
            addStudent.setString(3, student.getStudentID());
            addStudent.executeUpdate();
        }
        
        
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    
   
    
    
    
    public static ArrayList<StudentEntry> getAllStudents()
    {    
        connection = DBConnection.getConnection();
        ArrayList<StudentEntry> student = new ArrayList<>();
        try
        {   // for the query statement, when doing the "get" statement, how do I know when to capitalize "studentID , FirstName, LastName"? I don't get it, "studentID" is in camel case but the rest are not, why is that?
            getStudentList = connection.prepareStatement("select studentID , FirstName, LastName from app.student order by LastName, FirstName ");
            resultSet = getStudentList.executeQuery();
            //need the loop explained to me 
            while(resultSet.next())
            {
                StudentEntry entry = new StudentEntry(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
                student.add(entry);
                
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return student;
        
    }
    
    
    public static StudentEntry getStudent(String studentID) {
    connection = DBConnection.getConnection();
    
        ArrayList<StudentEntry> student = new ArrayList<StudentEntry>();
        try
        {
            getStudentList = connection.prepareStatement("select studentID, FirstName, LastName from app.student where studentID = (?)");
            getStudentList.setString(1, studentID);
            resultSet = getStudentList.executeQuery();
            
            while(resultSet.next())
            {
                StudentEntry entry = new StudentEntry(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
                student.add(entry);
                
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return student.get(0);
        
    }
    
    public static void dropStudent(String studentID) {
    connection = DBConnection.getConnection();

    try {
        dropStudent = connection.prepareStatement("DELETE FROM app.student WHERE studentID = ?");
        dropStudent.setString(1, studentID);
        dropStudent.executeUpdate();

        System.out.println("Student with ID " + studentID + " has been dropped.");
    } catch (SQLException sqlException) {
        sqlException.printStackTrace();
    }
}
    
    
    
    
}
    
    
            
            
            
    

