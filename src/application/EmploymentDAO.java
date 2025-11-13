package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmploymentDAO {

    public static boolean insert(EmploymentModel m) {

        String sql = "INSERT INTO employment_applications "
                + "(fullName, address, contact, email, education, gender, dateAvailable, position, salary, authorized, relative, relativeDetails) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, m.fullName);
            pst.setString(2, m.address);
            pst.setString(3, m.contact);
            pst.setString(4, m.email);
            pst.setString(5, m.education);
            pst.setString(6, m.gender);
            pst.setString(7, m.dateAvailable);
            pst.setString(8, m.position);
            pst.setString(9, m.salary);
            pst.setString(10, m.authorized);
            pst.setString(11, m.relative);
            pst.setString(12, m.relativeDetails);

            pst.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Insert Error: " + e.getMessage());
            return false;
        }
    }
}
