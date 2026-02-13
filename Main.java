import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        
        Scanner in = new Scanner(System.in);
        PassWordvalidation pass = new PassWordvalidation();
        MenuService ms = new MenuService();

        System.out.println("======================================================");
        System.out.println(" WELCOME TO MENAKA'S INTERNATIONAL CENTER FOR LEARNING ");
        System.out.println("======================================================");

        int userWishChoice;
        do {
            System.out.println("1 -> Admin");
            System.out.println("2 -> Student");
            System.out.println("3 -> Leave Portal");
            System.out.print("Select Your Role : ");

            int userChoice = in.nextInt();
            switch (userChoice) {
                case 1:
                    System.out.println("Enter Admin Name : ");
                    String adminName = in.next();

                    System.out.println("Enter Admin Password : ");
                    String adminPassword = in.next();

                    boolean isValid = pass.AdminValidaion(adminName, adminPassword);
                    if (isValid) {
                        System.out.println("Admin Login Successful! ");
                        ms.showAdminMenu();
                    } else {
                        System.out.println("Invalid Admin Credentials! ");
                    }
                    break;
                case 2:
                    System.out.println("Enter Student Roll Number : ");
                    String rollNo = in.next();
                    in.nextLine();
                    System.out.println("Enter Student Contact Number : ");
                    String studentContact = in.nextLine();

                    boolean isStudentValid = pass.StudentValidation(rollNo, studentContact);
                    if (isStudentValid) {
                        System.out.println("Student Login Successful! ");
                        ms.showStudentMenu();
                    } else {
                        System.out.println("Invalid Student Credentials! ");
                    }
                    break;
                case 3:
                    System.out.println("Thank you for visiting! Enjoy Learning ");
                    break;
                default:
                    System.out.println("Invalid choice, please try again ");
                    break;
            }

            System.out.print("\n Do You Want MEICL Services ? Press 1 to continue or any other number to exit : ");
            userWishChoice = in.nextInt();

        } while (userWishChoice == 1);

        in.close();
    }
}
