import javax.xml.transform.Result;
import java.sql.*;

/* DatabaseConnection.java
 * Author: Damien Rodriguez
 * Revision: 4
 * Rev. Author: Damien Rodriguez
 * Description: Database connection class. Singleton pattern implemented.
 * Has functionality to execute SQL queries within the SQLite database
 */
public class DatabaseConnection {

    private static DatabaseConnection SINGLE_INSTANCE = null;
    private final String DB_CONNECTION = "jdbc:sqlite:trivia.db";
    private final String MULTIPLECHOICE_COUNT_QUERY = "SELECT COUNT(*) AS rowCount FROM questions WHERE wrongAnswerOne IS NOT NULL";
    private final String TRUEFALSE_COUNT_QUERY = "SELECT COUNT(*) AS rowCount FROM questions WHERE length(answer) == 1 AND wrongAnswerOne IS NULL";
    private final String SHORTANSWER_COUNT_QUERY = "SELECT COUNT(*) AS rowCount FROM questions WHERE length(answer) != 1 AND wrongAnswerOne IS NULL";
    private final String TOTAL_COUNT_QUERY = "SELECT COUNT(*) AS rowCount FROM questions";
    private Connection c;

    private int trueFalseRecordCount;
    private int multipleChoiceRecordCount;
    private int shortAnswerChoiceRecordCount;
    private int totalRecordCount;



    ///Returns: nothing, it sets up the connection to our global Connection variable
    ///Throws:
    ///ClassNotFoundException: Throws the exception when the driver .jar file isn't present
    ///SQLException: Throws exception when SQL database connection fails
    private DatabaseConnection() throws Exception {
        connectionSetUp();
        setMultipleChoiceRecordCount(getRecordCount(MULTIPLECHOICE_COUNT_QUERY));
        setTrueFalseRecordCount(getRecordCount(TRUEFALSE_COUNT_QUERY));
        setShortAnswerChoiceRecordCount(getRecordCount(SHORTANSWER_COUNT_QUERY));
        setTotalRecordCount(getRecordCount(TOTAL_COUNT_QUERY));

        if(this.totalRecordCount != (this.multipleChoiceRecordCount + this.trueFalseRecordCount + this.shortAnswerChoiceRecordCount))
            throw new SQLException("SQL statements aren't getting the seperate categories that you are expecting.");

    }

    private int getRecordCount(final String sql) throws SQLException {

        Statement statement = this.c.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        int count = rs.getInt("rowCount");
        rs.close();

        return count;
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

    //combine the addQuestions into one method with logic on how to know what kind of question is being asked








    public void addQuestion(final Question q) throws Exception {
        String sql = "insert into questions values(";


        if(q.getWrongAnswerOne() != null) {
            sql = sql + q.getId() + ", '" + q.getQuestion() + "', '" + q.getAnswer() + "', '" + q.getWrongAnswerOne() + "', '" + q.getWrongAnswerTwo() + "', '" + q.getWrongAnswerThree() + "', '" + q.getHint() + "')";
        }

        else {
            sql = sql + q.getId() + ", '" + q.getQuestion() + "', '" + q.getAnswer() + "', '" + null + "', '" + null + "', '" + null + "', '" + q.getHint() + "')";
        }

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


    public ResultSet searchQuery(final String query) throws Exception {
        Statement temp_statement = this.c.createStatement();
        ResultSet rs = temp_statement.executeQuery(query);
        temp_statement.close();
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

    public void closeConnection() throws SQLException {
        this.c.close();
    }

    public int getTrueFalseRecordCount() {
        return trueFalseRecordCount;
    }

    public void setTrueFalseRecordCount(int trueFalseRecordCount) {
        this.trueFalseRecordCount = trueFalseRecordCount;
    }

    public int getMultipleChoiceRecordCount() {
        return multipleChoiceRecordCount;
    }

    public void setMultipleChoiceRecordCount(int multipleChoiceRecordCount) {
        this.multipleChoiceRecordCount = multipleChoiceRecordCount;
    }

    public int getShortAnswerChoiceRecordCount() {
        return shortAnswerChoiceRecordCount;
    }

    public void setShortAnswerChoiceRecordCount(int shortAnswerChoiceRecordCount) {
        this.shortAnswerChoiceRecordCount = shortAnswerChoiceRecordCount;
    }

    public int getTotalRecordCount() {
        return totalRecordCount;
    }

    public void setTotalRecordCount(int totalRecordCount) {
        this.totalRecordCount = totalRecordCount;
    }

    public static void main(String[] args) {
        DatabaseConnection db = DatabaseConnection.getInstance();

        System.out.println(db.getTotalRecordCount());
        System.out.println(db.getMultipleChoiceRecordCount());
        System.out.println(db.getShortAnswerChoiceRecordCount());
        System.out.println(db.getTrueFalseRecordCount());
    }
}
