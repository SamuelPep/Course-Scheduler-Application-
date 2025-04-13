📚 Course Scheduler Application

Submitted by: Samuel Peprah Millner

The Course Scheduler Application is a Java-based academic project designed to simulate a college course registration system. It enables students to enroll in courses, manage schedules, and interact with waitlists while providing administrative functions such as managing courses and removing students. The application uses Apache Derby for persistent storage and follows clean object-oriented design principles.

Time spent: ~12–15 hours (design, implementation, testing, debugging)

⸻

✅ Required Features

The following core features were implemented and tested:
	•	Admin Functions:




 
	•	View class lists of scheduled and waitlisted students


 
	•	Drop a student from the system (and update waitlists accordingly)


 
	•	Drop a course from a semester, removing all scheduled/waitlisted students


 
	•	Student Functions:


 
	•	Drop a course (from either schedule or waitlist)


 
	•	Automatically promote next student on the waitlist upon seat availability


 
	•	Database Integration:

 
	•	All operations rely on SQL queries to interact with tables for students, schedules, courses, and semesters

 
	•	Uses PreparedStatements to safely pass variables into queries without string concatenation

⸻

🔧 Technical Overview
	•	Programming Language: Java
 
	•	Database: Apache Derby (embedded)



 
	•	Design Approach: Object-Oriented Programming

Major Components:
	•	SemesterQueries.java – Retrieves semester list


 
	•	StudentQueries.java – Manages student data


 
	•	CourseQueries.java – Handles course metadata


 
	•	ClassQueries.java – Retrieves class listings


 
	•	ScheduleQueries.java – Adds/drops students and manages scheduling/waitlists

Key Concepts:
	•	Separation of logic by query classes


 
	•	Efficient updates to the Schedule table during drop operations


 
	•	Ensured UI-like feedback by printing or returning operation results directly after command execution

⸻

💡 Key Concepts Practiced
	•	Object-Oriented Programming (OOP)

 
	•	SQL query construction and management


 
	•	Database normalization and relationship management

 
	•	PreparedStatement usage for secure updates

 
	•	Testing complex drop and waitlist logic based on real-time DB state

⸻

🧠 Challenges Faced
	•	Ensuring that dropping a student triggers a cascade of correct schedule/waitlist updates across semesters


 
	•	Keeping course schedule states consistent after class removals

 
	•	Using appropriate SQL joins and conditions to handle queries dynamically across different tables


 
	•	Designing methods that simulate front-end logic in a console-based environment without GUI support

⸻

🧪 Testing

The application was tested using a provided test script and a structured database. Each function was validated to ensure:
	•	Proper scheduling and waitlisting of students


 
	•	Waitlist promotion upon drops

 
	•	Correct display and removal of records

