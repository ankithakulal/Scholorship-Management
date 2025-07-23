# Scholorship-Management

A simple Java-based GUI application for managing scholarship data designed for educational institutions or scholarship providers.

🚀 Features
 
 Login Authentication
 Add New Scholarships
 Update Existing Scholarship Details
 Remove Scholarships
 View All Available Scholarships
 User-friendly Swing-based GUI
 Database connectivity using JDBC

Technologies Used
 Java (Swing for GUI)
 JDBC for database connection
 MySQL or Oracle DB (Assumed)
 NetBeans or Eclipse (for development)

Project Structure

├── AddScholarship.java
├── RemoveScholarship.java
├── UpdateScholarship.java
├── ViewScholarship.java
├── login.java
├── Conn.java # Database connection helper
├── Splash.java # Optional splash screen
├── Home.java # Main dashboard after login

🔧 How to Run

1. Make sure you have **Java** and your **JDK** installed.
2. Set up your database (MySQL/Oracle) with the required table structure.
3. Update your `Conn.java` file with appropriate DB credentials:
   ```java
   Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/scholarship_db", "root", "password");
