import java.rmi.server.ExportException;
import java.sql.*;

public class DamiensDBConnector {


    private final String DB_CONNECTION = "jdbc:sqlite:trivia.db";
    private Connection c;


    public DamiensDBConnector() throws Exception {
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


    public void trueFalseAddQuestion(final int difficulty, final String question, final String answer, final String hint) throws Exception {
        String sql = "insert into trueFalse values(" + difficulty + ", '" + question + "', '" + answer + "', '" + hint + "')";
        executeStatement(sql);
    } //this will be the same but for the other queries for adding stuff into the database, so this will have to be refactored
      // for a more elegant solution. This smells like a template or builder type of problem (at least I think...)

    public void mutipleChoiceAddQuestion(final int difficulty, final String question, final String answer, final String wrongAnswer1, final String wrongAnswer2, final String wrongAnswer3, final String hint) throws Exception {
        String sql = "insert into multipleChoice values(" + difficulty + ", '" + question + "', '" + answer + "', '" + wrongAnswer1 + "', '" + wrongAnswer2 + "', '" + wrongAnswer3 + "', '" + hint + "')";
        executeStatement(sql);
    }

    private void executeStatement(final String query) throws Exception {
        Statement myStm = this.c.createStatement();
        myStm.executeUpdate(query);
    }


}
