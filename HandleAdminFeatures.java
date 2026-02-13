import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;   
import java.util.Scanner;


public class HandleAdminFeatures {

    Scanner in = new Scanner(System.in);
    //================================
    // ADMIN FEATURES
    //================================

    public void AddStudent(
    String rollNumber,
    String studentName,
    int age,
    String grade,
    String section,
    double fees,
    String address,
    String parentName,
    String contactNumber,
    String coursesEnrolled
) throws SQLException {

    String url = "jdbc:mysql://localhost:3306/sms";
    String user = "root";
    String pass = "Kadalamuttai@143";

    String query = "INSERT INTO student "
                 + "(roll_number, student_name, age, grade, section, fees, address, parent_name, contact_number, courses_enrolled) "
                 + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    String addStudentCourse = "INSERT INTO student_course (roll_number, course_id) VALUES (?, ?)";

    try (Connection connect = DriverManager.getConnection(url, user, pass);
         PreparedStatement pst = connect.prepareStatement(query);
         PreparedStatement pst2 = connect.prepareStatement(addStudentCourse)) {

        connect.setAutoCommit(false);

        // Insert into student table
        pst.setString(1, rollNumber);
        pst.setString(2, studentName);
        pst.setInt(3, age);
        pst.setString(4, grade);
        pst.setString(5, section); 
        pst.setBigDecimal(6, BigDecimal.valueOf(fees)); 
        pst.setString(7, address);
        pst.setString(8, parentName);
        pst.setString(9, contactNumber);
        pst.setString(10, coursesEnrolled);

        int rows = pst.executeUpdate();

        if (rows > 0) {
            // Insert into student_course table
            // Assuming coursesEnrolled contains a comma-separated list of course IDs like "C101,C102"
            String[] courseIds = coursesEnrolled.split(",");
            for (String courseId : courseIds) {
                pst2.setString(1, rollNumber);
                pst2.setString(2, courseId.trim());
                pst2.executeUpdate();
            }

            connect.commit();
            System.out.println("Student added successfully with course enrollment! ");
        } else {
            connect.rollback();
            System.out.println("Failed to add student. ");
        }

    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    }
}

// Update student details
public void UpdateStudentDetails(String rollNumber) throws SQLException {
    String url = "jdbc:mysql://localhost:3306/sms";
    String user = "root";
    String pass = "Kadalamuttai@143";

    int choice;
    do {
        System.out.println("Choose the detail you want to update:");
        System.out.println("1 -> Student Name");
        System.out.println("2 -> Age");
        System.out.println("3 -> Grade");
        System.out.println("4 -> Section");
        System.out.println("5 -> Fees");
        System.out.println("6 -> Address");
        System.out.println("7 -> Parent Name");
        System.out.println("8 -> Contact Number");
        System.out.println("9 -> Courses Enrolled");
        System.out.println("10 -> Exit");

        choice = in.nextInt();
        in.nextLine(); // clear buffer

        String query = null;

        switch (choice) {
            case 1:
                System.out.println("Enter Student Name: ");
                String newName = in.nextLine();
                query = "UPDATE student SET student_name = ? WHERE roll_number = ?";
                try (Connection connect = DriverManager.getConnection(url, user, pass);
                     PreparedStatement pst = connect.prepareStatement(query)) {
                    connect.setAutoCommit(false);
                    pst.setString(1, newName);
                    pst.setString(2, rollNumber);
                    int rows = pst.executeUpdate();
                    if (rows > 0) {
                        connect.commit();
                        System.out.println("Student name updated successfully! ");
                    } else {
                        connect.rollback();
                        System.out.println("Failed to update student name. ");
                    }
                }
                break;

            case 2:
                System.out.println("Enter Age: ");
                int newAge = in.nextInt();
                query = "UPDATE student SET age = ? WHERE roll_number = ?";
                try (Connection connect = DriverManager.getConnection(url, user, pass);
                     PreparedStatement pst = connect.prepareStatement(query)) {
                    connect.setAutoCommit(false);
                    pst.setInt(1, newAge);
                    pst.setString(2, rollNumber);
                    int rows = pst.executeUpdate();
                    if (rows > 0) {
                        connect.commit();
                        System.out.println("Age updated successfully! ");
                    } else {
                        connect.rollback();
                        System.out.println("Failed to update age. ");
                    }
                }
                break;

            case 3:
                System.out.println("Enter Grade: ");
                String newGrade = in.nextLine();
                query = "UPDATE student SET grade = ? WHERE roll_number = ?";
                try (Connection connect = DriverManager.getConnection(url, user, pass);
                     PreparedStatement pst = connect.prepareStatement(query)) {
                    connect.setAutoCommit(false);
                    pst.setString(1, newGrade);
                    pst.setString(2, rollNumber);
                    int rows = pst.executeUpdate();
                    if (rows > 0) {
                        connect.commit();
                        System.out.println("Grade updated successfully! ");
                    } else {
                        connect.rollback();
                        System.out.println("Failed to update grade. ");
                    }
                }
                break;

            case 4:
                System.out.println("Enter Section: ");
                String newSection = in.nextLine();
                query = "UPDATE student SET section = ? WHERE roll_number = ?";
                try (Connection connect = DriverManager.getConnection(url, user, pass);
                     PreparedStatement pst = connect.prepareStatement(query)) {
                    connect.setAutoCommit(false);
                    pst.setString(1, newSection);
                    pst.setString(2, rollNumber);
                    int rows = pst.executeUpdate();
                    if (rows > 0) {
                        connect.commit();
                        System.out.println("Section updated successfully! ");
                    } else {
                        connect.rollback();
                        System.out.println("Failed to update section. ");
                    }
                }
                break;

            case 5:
                System.out.println("Enter Fees: ");
                double newFees = in.nextDouble();
                query = "UPDATE student SET fees = ? WHERE roll_number = ?";
                try (Connection connect = DriverManager.getConnection(url, user, pass);
                     PreparedStatement pst = connect.prepareStatement(query)) {
                    connect.setAutoCommit(false);
                    pst.setBigDecimal(1, BigDecimal.valueOf(newFees));
                    pst.setString(2, rollNumber);
                    int rows = pst.executeUpdate();
                    if (rows > 0) {
                        connect.commit();
                        System.out.println("Fees updated successfully! ");
                    } else {
                        connect.rollback();
                        System.out.println("Failed to update fees. ");
                    }
                }
                break;

            case 6:
                System.out.println("Enter Address: ");
                String newAddress = in.nextLine();
                query = "UPDATE student SET address = ? WHERE roll_number = ?";
                try (Connection connect = DriverManager.getConnection(url, user, pass);
                     PreparedStatement pst = connect.prepareStatement(query)) {
                    connect.setAutoCommit(false);
                    pst.setString(1, newAddress);
                    pst.setString(2, rollNumber);
                    int rows = pst.executeUpdate();
                    if (rows > 0) {
                        connect.commit();
                        System.out.println("Address updated successfully! ");
                    } else {
                        connect.rollback();
                        System.out.println("Failed to update address. ");
                    }
                }
                break;

            case 7:
                System.out.println("Enter Parent Name: ");
                String newParent = in.nextLine();
                query = "UPDATE student SET parent_name = ? WHERE roll_number = ?";
                try (Connection connect = DriverManager.getConnection(url, user, pass);
                     PreparedStatement pst = connect.prepareStatement(query)) {
                    connect.setAutoCommit(false);
                    pst.setString(1, newParent);
                    pst.setString(2, rollNumber);
                    int rows = pst.executeUpdate();
                    if (rows > 0) {
                        connect.commit();
                        System.out.println("Parent name updated successfully! ");
                    } else {
                        connect.rollback();
                        System.out.println("Failed to update parent name. ");
                    }
                }
                break;

            case 8:
                System.out.println("Enter Contact Number: ");
                String newContact = in.nextLine();
                query = "UPDATE student SET contact_number = ? WHERE roll_number = ?";
                try (Connection connect = DriverManager.getConnection(url, user, pass);
                     PreparedStatement pst = connect.prepareStatement(query)) {
                    connect.setAutoCommit(false);
                    pst.setString(1, newContact);
                    pst.setString(2, rollNumber);
                    int rows = pst.executeUpdate();
                    if (rows > 0) {
                        connect.commit();
                        System.out.println("Contact number updated successfully! ");
                    } else {
                        connect.rollback();
                        System.out.println("Failed to update contact number. ");
                    }
                }
                break;

            case 9:
            System.out.println("Enter Courses Enrolled (comma-separated course IDs): ");
            String newCourses = in.nextLine();

            // Update the string column (for backward compatibility)
            query = "UPDATE student SET courses_enrolled = ? WHERE roll_number = ?";
            try (Connection connect = DriverManager.getConnection(url, user, pass);
                PreparedStatement pst = connect.prepareStatement(query);
                PreparedStatement pstDelete = connect.prepareStatement("DELETE FROM student_course WHERE roll_number = ?");
                PreparedStatement pstInsert = connect.prepareStatement("INSERT INTO student_course (roll_number, course_id) VALUES (?, ?)")) {

                connect.setAutoCommit(false);

                // Update student table
                pst.setString(1, newCourses);
                pst.setString(2, rollNumber);
                int rows = pst.executeUpdate();

                // Clear old course links
                pstDelete.setString(1, rollNumber);
                pstDelete.executeUpdate();

                // Insert new course links
                String[] courseIds = newCourses.split(",");
                for (String courseId : courseIds) {
                    pstInsert.setString(1, rollNumber);
                    pstInsert.setString(2, courseId.trim());
                    pstInsert.executeUpdate();
                }

                if (rows > 0) {
                    connect.commit();
                    System.out.println("Courses updated successfully! ");
                } else {
                    connect.rollback();
                    System.out.println("Failed to update courses. ");
                }
            }
            break;

            case 10:
                System.out.println("Exiting update menu...");
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }

    } while (choice != 10);
}

// View Specific Student
public void ViewStudentById(String rollNo) throws SQLException {
    String url = "jdbc:mysql://localhost:3306/sms";
    String user = "root";
    String pass = "Kadalamuttai@143";

    String query =
        "SELECT s.roll_number, s.student_name, s.age, s.grade, s.section, " +
        "       s.fees, s.address, s.parent_name, s.contact_number, " +
        "       GROUP_CONCAT(c.course_name) AS courses_enrolled " +
        "FROM student s " +
        "LEFT JOIN student_course sc ON s.roll_number = sc.roll_number " +
        "LEFT JOIN course c ON sc.course_id = c.course_id " +
        "WHERE s.roll_number = ? " +
        "GROUP BY s.roll_number";

    try (Connection connect = DriverManager.getConnection(url, user, pass);
         PreparedStatement pst = connect.prepareStatement(query)) {

        pst.setString(1, rollNo);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            System.out.println("=======================================");
            System.out.println("Student Details");
            System.out.println("=======================================");
            System.out.println("Roll Number     : " + rs.getString("roll_number"));
            System.out.println("Name            : " + rs.getString("student_name"));
            System.out.println("Age             : " + rs.getInt("age"));
            System.out.println("Grade           : " + rs.getString("grade"));
            System.out.println("Section         : " + rs.getString("section"));
            System.out.println("Fees            : " + rs.getBigDecimal("fees"));
            System.out.println("Address         : " + rs.getString("address"));
            System.out.println("Parent Name     : " + rs.getString("parent_name"));
            System.out.println("Contact Number  : " + rs.getString("contact_number"));
            System.out.println("Courses Enrolled: " + rs.getString("courses_enrolled"));
            System.out.println("=======================================");
        } else {
            System.out.println("No student found with Roll Number: " + rollNo);
        }
    }
}



public void viewAllStudent() throws SQLException {
    String url = "jdbc:mysql://localhost:3306/sms";
    String user = "root";
    String pass = "Kadalamuttai@143";

    String query = "SELECT * FROM student";

    try (Connection connect = DriverManager.getConnection(url, user, pass);
         Statement st = connect.createStatement();
         ResultSet rs = st.executeQuery(query)) {

        while (rs.next()) {
            System.out.println("Roll Number     : " + rs.getString("roll_number"));
            System.out.println("Name            : " + rs.getString("student_name"));
            System.out.println("Age             : " + rs.getInt("age"));
            System.out.println("Grade           : " + rs.getString("grade"));
            System.out.println("Section         : " + rs.getString("section"));
            System.out.println("Fees            : " + rs.getBigDecimal("fees"));
            System.out.println("Address         : " + rs.getString("address"));
            System.out.println("Parent Name     : " + rs.getString("parent_name"));
            System.out.println("Contact Number  : " + rs.getString("contact_number"));
            System.out.println("Courses Enrolled: " + rs.getString("courses_enrolled"));
            System.out.println("=======================================");
        }

    } catch (SQLException e) {
        System.out.println("Error retrieving students.");
        throw e;
    }
}

// Manage courses
public void ManageCourses() {
    String url = "jdbc:mysql://localhost:3306/sms";
    String user = "root";
    String pass = "Kadalamuttai@143";

    String query = "SELECT course_id, course_name FROM course";
    String addCourse = "INSERT INTO course (course_id, course_name, course_description, course_fee) "
                     + "VALUES (?, ?, ?, ?)";

    try (Connection connect = DriverManager.getConnection(url, user, pass);
         Statement st = connect.createStatement();
         ResultSet rs = st.executeQuery(query)) {

        System.out.println("=======================================");
        System.out.println("        Manage Courses Feature         ");
        System.out.println("=======================================");
        System.out.println("Available Courses:");

        while (rs.next()) {
            System.out.println(rs.getString("course_id") + " -> " + rs.getString("course_name"));
        }

        System.out.println("\nDo you want to add new course ? press 1 to continue 0 to exit :");
        int choice = in.nextInt();
        in.nextLine(); // clear buffer

        if (choice == 1) {
            System.out.println("Enter Course id :");
            String courseId = in.nextLine();
            System.out.println("Enter Course Name :");
            String courseName = in.nextLine();
            System.out.println("Write Course description :");
            String des = in.nextLine();
            System.out.println("Enter course fee :");
            float fee = in.nextFloat();
            in.nextLine(); // clear buffer

            try (PreparedStatement pst = connect.prepareStatement(addCourse)) {
                connect.setAutoCommit(false);

                pst.setString(1, courseId);
                pst.setString(2, courseName);
                pst.setString(3, des);
                pst.setBigDecimal(4, BigDecimal.valueOf(fee));

                int rows = pst.executeUpdate();

                if (rows > 0) {
                    connect.commit();
                    System.out.println("Course added successfully!");
                } else {
                    connect.rollback();
                    System.out.println("Failed to add course.");
                }
            }
        } else {
            System.out.println("Exiting Manage Courses...");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

// Manage fees
public void ManageFees() {
    String url = "jdbc:mysql://localhost:3306/sms";
    String user = "root";
    String pass = "Kadalamuttai@143";

    System.out.println("Enter Roll Number of Student:");
    String rollNumber = in.nextLine();

    String selectQuery = "SELECT fees FROM student WHERE roll_number = ?";
    String updateQuery = "UPDATE student SET fees = ? WHERE roll_number = ?";

    try (Connection connect = DriverManager.getConnection(url, user, pass);
         PreparedStatement pstSelect = connect.prepareStatement(selectQuery);
         PreparedStatement pstUpdate = connect.prepareStatement(updateQuery)) {

        // Show current fees
        pstSelect.setString(1, rollNumber);
        ResultSet rs = pstSelect.executeQuery();

        if (rs.next()) {
            System.out.println("Current Fees: " + rs.getBigDecimal("fees"));

            System.out.println("Do you want to update fees? (1 = Yes, 0 = No):");
            int choice = in.nextInt();
            in.nextLine(); // clear buffer

            if (choice == 1) {
                System.out.println("Enter new fee amount:");
                double newFee = in.nextDouble();
                in.nextLine(); // clear buffer

                connect.setAutoCommit(false);
                pstUpdate.setBigDecimal(1, BigDecimal.valueOf(newFee));
                pstUpdate.setString(2, rollNumber);

                int rows = pstUpdate.executeUpdate();
                if (rows > 0) {
                    connect.commit();
                    System.out.println("Fees updated successfully!");
                } else {
                    connect.rollback();
                    System.out.println("Failed to update fees.");
                }
            } else {
                System.out.println("No changes made to fees.");
            }
        } else {
            System.out.println("No student found with Roll Number: " + rollNumber);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    
}

// Delete student
public void DeleteStudent(String rollNumber) throws SQLException {
    String url = "jdbc:mysql://localhost:3306/sms";
    String user = "root";
    String pass = "Kadalamuttai@143";

    String deleteStudentCourse = "DELETE FROM student_course WHERE roll_number = ?";
    String deleteStudent = "DELETE FROM student WHERE roll_number = ?";

    try (Connection connect = DriverManager.getConnection(url, user, pass);
         PreparedStatement pstCourse = connect.prepareStatement(deleteStudentCourse);
         PreparedStatement pstStudent = connect.prepareStatement(deleteStudent)) {

        connect.setAutoCommit(false);

        // First delete from student_course (child table)
        pstCourse.setString(1, rollNumber);
        pstCourse.executeUpdate();

        // Then delete from student (parent table)
        pstStudent.setString(1, rollNumber);
        int rows = pstStudent.executeUpdate();

        if (rows > 0) {
            connect.commit();
            System.out.println("Student deleted successfully! 🗑️");
        } else {
            connect.rollback();
            System.out.println("No student found with Roll Number: " + rollNumber);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    }
}


}

