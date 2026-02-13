import java.sql.SQLException;
import java.util.Scanner;

public class MenuService {

    Scanner in = new Scanner(System.in);

    public void showAdminMenu() throws SQLException {
    System.out.println("Welcome, Admin! Please choose an option:");
    HandleAdminFeatures features  = new HandleAdminFeatures();

    int choice;
    do {
        System.out.println("1 -> Add Student");
        System.out.println("2 -> Update Student");
        System.out.println("3 -> Delete Student");
        System.out.println("4 -> View Student by Roll Number");
        System.out.println("5 -> View All Students");
        System.out.println("6 -> Manage Courses");
        System.out.println("7 -> Manage Fees");
        System.out.println("8 -> Logout");
        System.out.print("Enter your choice: ");

        choice = in.nextInt();
        in.nextLine(); // clear buffer

        switch (choice) {
            case 1:
                System.out.println("Enter Roll Number:");
                String rollNumber = in.nextLine();
                System.out.println("Enter Student Name:");
                String studentName = in.nextLine();
                System.out.println("Enter Age:");
                int age = in.nextInt(); in.nextLine();
                System.out.println("Enter Grade:");
                String grade = in.nextLine();
                System.out.println("Enter Section:");
                String section = in.nextLine();
                System.out.println("Enter Fees:");
                double fees = in.nextDouble(); in.nextLine();
                System.out.println("Enter Address:");
                String address = in.nextLine();
                System.out.println("Enter Parent Name:");
                String parentName = in.nextLine();
                System.out.println("Enter Contact Number:");
                String contactNumber = in.nextLine();
                System.out.println("Enter Courses Enrolled (comma-separated IDs):");
                String coursesEnrolled = in.nextLine();

                features.AddStudent(rollNumber, studentName, age, grade, section, fees,
                           address, parentName, contactNumber, coursesEnrolled);
                break;

            case 2:
                System.out.println("Enter Roll Number to update:");
                String rollNoUpdate = in.nextLine();
               features.UpdateStudentDetails(rollNoUpdate);
                break;

            case 3:
                System.out.println("Enter Roll Number to delete:");
                String rollNoDelete = in.nextLine();
               features.DeleteStudent(rollNoDelete);
                break;

            case 4:
                System.out.println("Enter Roll Number to view:");
                String rollNoView = in.nextLine();
               features.ViewStudentById(rollNoView);
                break;

            case 5:
               features.viewAllStudent();
                break;

            case 6:
               features.ManageCourses();
                break;

            case 7:
               features.ManageFees();
                break;

            case 8:
                System.out.println("You have logged out.");
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }

        if (choice != 8) {
            System.out.print("Press 1 to continue or any other number to exit: ");
            choice = in.nextInt();
            in.nextLine(); // clear buffer
        }

    } while (choice == 1);
}


    public void showStudentMenu() throws SQLException {

        System.out.println("======================================================");
        System.out.println("WELCOME TO MENAKA'S INTERNATIONAL CENTER FOR LEARNING!");
        System.out.println("======================================================");
        HandleStudentFeatures hsf = new HandleStudentFeatures();
        System.out.println("Please select an option:");

        int choice;
        do {
            System.out.println("1 -> View My Details");
            System.out.println("2 -> View My Fees");
            System.out.println("3 -> View My Courses");
            System.out.println("4 -> Logout");
            System.out.print("Enter your choice: ");

            choice = in.nextInt();

            switch (choice) {
                case 1:
                    hsf.getMyDetails(); 
                    break;
                case 2:
                    hsf.getMyFees();
                    break;
                case 3:
                    hsf.getMyCourse();
                    break;
                case 4:
                    System.out.println("Thank you! Keep learning and growing.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.print("Press 1 to continue or any other number to exit: ");
            choice = in.nextInt();

        } while (choice == 1);
    }
}
