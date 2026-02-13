import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HandleStudentFeatures {

    //Scanner
    Scanner in = new Scanner(System.in);
    //Get My Details

    public void getMyDetails() throws SQLException {
    System.out.println("Enter your roll Number :");
    String roll = in.nextLine();

    String url = "jdbc:mysql://localhost:3306/sms";
    String user = "root";
    String pass = "Kadalamuttai@143";

    String query = "SELECT * FROM student WHERE roll_number = ?";
    try (Connection connect = DriverManager.getConnection(url, user, pass);
         PreparedStatement pst = connect.prepareStatement(query)) {

        pst.setString(1, roll);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            System.out.println("=======================================");
            System.out.println("        Student Details                ");
            System.out.println("=======================================");
            System.out.println("Roll Number   : " + rs.getString("roll_number"));
            System.out.println("Name          : " + rs.getString("student_name"));
            System.out.println("Age           : " + rs.getInt("age"));
            System.out.println("Grade         : " + rs.getString("grade"));
            System.out.println("Section       : " + rs.getString("section"));
            System.out.println("Address       : " + rs.getString("address"));
            System.out.println("Parent Name   : " + rs.getString("parent_name"));
            System.out.println("Contact Number: " + rs.getString("contact_number"));
            System.out.println("Courses       : " + rs.getString("courses_enrolled"));
            System.out.println("=======================================");
        } else {
            System.out.println("No student found with Roll Number: " + roll);
        }
    }
}


public void getMyFees() throws SQLException {
    System.out.println("Enter your Roll No :");
    String roll = in.nextLine();

    String url = "jdbc:mysql://localhost:3306/sms";
    String user = "root";
    String pass = "Kadalamuttai@143";

    String query = "SELECT student_name, fees FROM student WHERE roll_number = ?";

    try (Connection connect = DriverManager.getConnection(url, user, pass);
         PreparedStatement pst = connect.prepareStatement(query)) {

        pst.setString(1, roll);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            System.out.println("=======================================");
            System.out.println("        Fee Details                    ");
            System.out.println("=======================================");
            System.out.println("Student Name : " + rs.getString("student_name"));
            System.out.println("Outstanding Fees : " + rs.getBigDecimal("fees"));
            System.out.println("=======================================");
        } else {
            System.out.println("No student found with Roll Number: " + roll);
        }
    }
}
public void getMyCourse() throws SQLException {
    System.out.println("Enter Your Roll Number :");
    String roll = in.nextLine();

    String url = "jdbc:mysql://localhost:3306/sms";
    String user = "root";
    String pass = "Kadalamuttai@143";

    // Join student_course with course to get course details
    String query = "SELECT c.course_id, c.course_name, c.course_description, c.course_fee " +
                   "FROM student_course sc " +
                   "JOIN course c ON sc.course_id = c.course_id " +
                   "WHERE sc.roll_number = ?";

    try (Connection connect = DriverManager.getConnection(url, user, pass);
         PreparedStatement pst = connect.prepareStatement(query)) {

        pst.setString(1, roll);
        ResultSet rs = pst.executeQuery();

        System.out.println("=======================================");
        System.out.println("        My Courses                     ");
        System.out.println("=======================================");

        boolean found = false;
        while (rs.next()) {
            found = true;
            System.out.println("Course ID   : " + rs.getString("course_id"));
            System.out.println("Course Name : " + rs.getString("course_name"));
            System.out.println("Description : " + rs.getString("course_description"));
            System.out.println("Course Fee  : " + rs.getBigDecimal("course_fee"));
            System.out.println("---------------------------------------");
        }

        if (!found) {
            System.out.println("No courses found for Roll Number: " + roll);
        }

        System.out.println("=======================================");
    }
}


}
