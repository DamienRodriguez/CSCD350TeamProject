import java.sql.*;

/* DatabaseConnection.java
 * Author: Damien Rodriguez
 * Revision: 3
 * Rev. Author: Damien Rodriguez
 * Description: Database connection class. Singleton pattern implemented.
 * Has functionality to execute SQL queries within the SQLite database
 */
public class DatabaseConnection {

    private static DatabaseConnection SINGLE_INSTANCE = null;
    private final String DB_CONNECTION = "jdbc:sqlite:trivia.db";
    private Connection c;


    ///Returns: nothing, it sets up the connection to our global Connection variable
    ///Throws:
    ///ClassNotFoundException: Throws the exception when the driver .jar file isn't present
    ///SQLException: Throws exception when SQL database connection fails
    private DatabaseConnection() throws Exception {
        connectionSetUp();
    }


    public static DatabaseConnection getInstance() {
        try {
            if(SINGLE_INSTANCE == null) {
                synchronized (DatabaseConnection.class) {
                    if(SINGLE_INSTANCE == null)
                        SINGLE_INSTANCE = new DatabaseConnection();
                }
            }
            return SINGLE_INSTANCE;
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;

    }


    private void connectionSetUp() {
        try {
            Class.forName("org.sqlite.JDBC");
            this.c = DriverManager.getConnection(DB_CONNECTION);

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void trueFalseAddQuestion(final int difficulty, final String question, final String answer, final String hint) throws Exception{
        String sql = "insert into trueFalse values(" + difficulty + ", '" + question + "', '" + answer + "', '" + hint + "')";
        insertQuery(sql);
    } //this will be the same but for the other queries for adding stuff into the database, so this will have to be refactored
      // for a more elegant solution. This smells like a template or builder type of problem (at least I think...)


    public void mutipleChoiceAddQuestion(final int difficulty, final String question, final String answer, final String wrongAnswer1, final String wrongAnswer2, final String wrongAnswer3, final String hint) throws Exception {
        String sql = "insert into multipleChoice values(" + difficulty + ", '" + question + "', '" + answer + "', '" + wrongAnswer1 + "', '" + wrongAnswer2 + "', '" + wrongAnswer3 + "', '" + hint + "')";
        insertQuery(sql);
    }


    public void shortAnswerAddQuestion(final int difficulty, final String question, final String answer, final String hint) throws Exception {
        String sql = "insert into shortAnswer values(" + difficulty + ", '" + question + "', '" + answer + "', '" + hint + "')";
        insertQuery(sql);
    }


    private void insertQuery(final String query) throws Exception {
        try {
            Statement myStm = this.c.createStatement();
            myStm.executeUpdate(query);
            System.out.println("Query complete");
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    //this could be a problem.
    //insert is private, but this is not. We don't have a reliable way to put this,
    //as well as the insertQuery function into the same thing. Perhaps do an if block?
    //would look horrid, but would have to be refactored

    public ResultSet searchQuery(final String query) throws Exception {
        Statement temp_statement = this.c.createStatement();
        ResultSet rs = temp_statement.executeQuery(query);

        return rs;
    }

    //to be deleted later
    public void clearTestData() throws Exception {
        try {
            Statement temp = this.c.createStatement();
            temp.execute("DELETE FROM trueFalse");
            temp.execute("DELETE FROM multipleChoice");
            temp.execute("DELETE FROM shortAnswer");
            System.out.println("Deletion of Test Data Successful");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
