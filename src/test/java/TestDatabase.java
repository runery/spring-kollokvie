import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;


public class TestDatabase {
    @Test
    public void testDb() throws SQLException, ClassNotFoundException {
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:jtds:sybase://syb03t:4100/testsma", "spk", "spkkps");
        closeConnection(conn);
    }

    @Test
    public void testAntallRaderMembers() throws SQLException, ClassNotFoundException {
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:jtds:sybase://syb03t:4100/testsma", "spk", "spkkps");
            PreparedStatement statement = conn.prepareStatement("select * from members");

            ResultSet resultSet = statement.executeQuery();

            int antall = 0;
            while (resultSet.next()) {
                antall++;
            }

            System.out.println("antall i members: " + antall);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(conn);
        }

    }

    public void closeConnection(Connection conn) {
        if (conn == null) return;

        try {
            conn.close();
        } catch (SQLException ex) {
            //noop
        }
    }

}
