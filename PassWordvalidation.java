import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassWordvalidation {

    public boolean AdminValidaion(String admin_name, String password) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/sms";
        String user = "root";
        String pass = "Kadalamuttai@143";
        String query = "SELECT * FROM admin WHERE password = ? AND admin_name = ?";

        Connection connect = DriverManager.getConnection(url, user, pass);
        PreparedStatement pst = connect.prepareStatement(query);
        pst.setString(1, password);
        pst.setString(2, admin_name);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            return true;
        }

        return false;
    }

    public boolean StudentValidation(String rollNo,  String mob) throws SQLException {

    String url = "jdbc:mysql://localhost:3306/sms";
    String user = "root";
    String pass = "Kadalamuttai@143";

    String query = "SELECT * FROM student WHERE roll_number = ? AND contact_number = ?";

    Connection connect = DriverManager.getConnection(url, user, pass);
    PreparedStatement pst = connect.prepareStatement(query);

    pst.setString(1, rollNo);        // roll_number
    pst.setString(2, mob);        // contact_number

    ResultSet rs = pst.executeQuery();

    while (rs.next()) {
        return true;
    }

    return false;
}

}


