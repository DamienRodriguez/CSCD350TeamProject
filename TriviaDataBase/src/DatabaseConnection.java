import java.sql.*;

public class DatabaseConnection {


    private final String DB_CONNECTION = "jdbc:sqlite:trivia.db";
    private Connection c;


    public DatabaseConnection() throws Exception {
        connectionSetUp();
    }


    private void connectionSetUp() throws Exception {
        try {
            Class.forName("org.sqlite.JDBC");
            this.c = DriverManager.getConnection(DB_CONNECTION);

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void trueFalseAddQuestion(final int difficulty, final String question, final String answer, final String hint) throws Exception{
        String sql = "insert into trueFalse values(" + difficulty + ", '" + question + "', '" + answer + "', '" + hint + "')";
        executeStatement(sql);
    } //this will be the same but for the other queries for adding stuff into the database, so this will have to be refactored
      // for a more elegant solution. This smells like a template or builder type of problem (at least I think...)


    public void mutipleChoiceAddQuestion(final int difficulty, final String question, final String answer, final String wrongAnswer1, final String wrongAnswer2, final String wrongAnswer3, final String hint) throws Exception {
        String sql = "insert into multipleChoice values(" + difficulty + ", '" + question + "', '" + answer + "', '" + wrongAnswer1 + "', '" + wrongAnswer2 + "', '" + wrongAnswer3 + "', '" + hint + "')";
        executeStatement(sql);
    }


    public void shortAnswerQuestions(final int difficulty, final String question, final String answer, final String hint) throws Exception {
        String sql = "insert into shortAnswer values(" + difficulty + ", '" + question + "', '" + answer + "', '" + hint + "')";
        executeStatement(sql);
    }


    private void executeStatement(final String query) throws Exception {
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

        return rs;
    }


    public void clearTestData() throws Exception { //this was done to clear out the database before we implement stuff into the database
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
