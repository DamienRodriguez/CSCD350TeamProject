import java.sql.*;

public class Tester {

    final static String DBCONNECTION = "jdbc:sqlite:trivia.db";

    public static void main(String[]args) throws Exception {
        Connection c = null;

        try {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection(DBCONNECTION);
        System.out.println("SQLite database connected.");

        } catch (Exception e) {
        System.out.println("Database connection failed.");
        System.out.println(e);
        }

        Statement myStm = c.createStatement();
        String sql = "insert into trueFalse values(1, 'There are no kings in the US', 'T', 'George Washington was going to be declared king.')";

        myStm.executeUpdate(sql);
    }
}
