📚 Course Scheduler Application

Submitted by: Samuel Peprah Millner

The Course Scheduler Application is a Java-based desktop program built using Swing for the GUI and Apache Derby as the embedded SQL database. It allows students and administrators at a university to schedule, manage, and drop courses each semester. The GUI leverages JComboBox components to dynamically display and manage student, course, and semester data.

Time spent: ~12–15 hours (design, implementation, debugging, and GUI wiring)

⸻

✅ Required Features

The following functionality was implemented and tested for both Admin and Student roles:
	•	Add & Drop Courses: Students can schedule or drop courses; admins can drop entire courses and view enrolled students.



 
	•	Waitlist Management: Automatically adds students to the waitlist if a class is full and promotes them when space becomes available.


 
	•	Display Features: Admins can view student lists per class and semester, and students can view their own schedule.




 
	•	Dynamic ComboBoxes: Drop-down menus are auto-populated with real-time data from the database (e.g., course codes, semesters, student names).

⸻

🔧 Technical Overview

The application utilizes:
	•	Java Swing GUI components (JComboBox, JLabel, JButton, etc.) to provide a user-friendly interface.



 
	•	Apache Derby for persistent storage of student, course, schedule, and semester information.


 
	•	SQL queries and PreparedStatements for all data operations—ensuring secure and efficient communication with the database.


 
	•	OOP Design with separation of concerns:


 
	•	StudentQueries, CourseQueries, ClassQueries, ScheduleQueries, etc. handle DB interaction.




 
	•	MainFrame.java handles GUI logic and user interaction.

GUI Design Guidelines Implemented:
	•	Students/Admins select known data (e.g., names, semesters) via ComboBoxes.



 
	•	All display results and operation confirmations appear directly on the same GUI pane without needing extra display steps.

⸻

💡 Key Concepts Practiced
	•	Java Swing GUI development


 
	•	SQL database integration using JDBC


 
	•	Object-Oriented Design (separating queries, models, and UI logic)



 
	•	Dynamic UI updates with real-time database feedback

 
	•	PreparedStatements to prevent SQL injection

⸻

🧠 Challenges Faced
	•	Structuring the application cleanly across multiple user types (Admin vs. Student)

 
	•	Managing ComboBox state and syncing changes with live database updates


 
	•	Ensuring database changes cascade correctly when classes or students are dropped


 
	•	Avoiding UI flickering and redundant DB calls during display updates

⸻

🧪 Testing
	•	Ran through a variety of trace-based test scenarios (manual and scripted) including:

 
	•	Dropping full courses and confirming waitlist promotion

 
	•	Dropping students and validating that schedules and waitlists update accordingly

 
	•	Displaying students by class and verifying waitlist order
