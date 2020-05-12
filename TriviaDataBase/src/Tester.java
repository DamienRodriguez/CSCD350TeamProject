import java.sql.*;

public class Tester {

    public static void main(String[] args) throws Exception {

        DatabaseConnection connection = DatabaseConnection.getInstance(); //this should work

        connection.trueFalseAddQuestion(0, "This is a test", "T", "This is a test");
        connection.mutipleChoiceAddQuestion(0, "This is a multiple choice test.", "This is the answer.",
                "This is not the answer", "This is also not the answer",
                "This again, is not the right answer", "There is only one right answer.");

        connection.shortAnswerAddQuestion(0, "This is a multiple choice test.",
                "There is no answer.", "There is not an answer.");

        System.out.println("COMMENCING SEARCH QUERY");

        ResultSet test = connection.searchQuery("SELECT * FROM trueFalse");
        printResultSet(test);

        test = connection.searchQuery("SELECT * FROM multipleChoice");
        printResultSet(test);

        test = connection.searchQuery("SELECT * FROM shortAnswer");
        printResultSet(test);


        System.out.println("CLEARING TEST DATA");
        connection.clearTestData();
    }

    public static void printResultSet(final ResultSet test) throws Exception {

        try {
            ResultSetMetaData rsmd = test.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (test.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = test.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }//end of for loop
                System.out.println("");
            }//end of while loop
        } catch(Exception e) {
            System.out.println(e);
        }

    }
}
