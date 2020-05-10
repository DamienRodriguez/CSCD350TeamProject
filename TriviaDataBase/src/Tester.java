import java.sql.*;

public class Tester {

    public static void main(String[] args) throws Exception {

        DatabaseConnection connection = new DatabaseConnection();

        connection.trueFalseAddQuestion(0, "This is a test", "T", "This is a test");

        ResultSet test = connection.searchQuery("SELECT * FROM trueFalse");

        ResultSetMetaData rsmd = test.getMetaData();
        System.out.println("querying SELECT * FROM XXX");
        int columnsNumber = rsmd.getColumnCount();
        while (test.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = test.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }
    }
}
