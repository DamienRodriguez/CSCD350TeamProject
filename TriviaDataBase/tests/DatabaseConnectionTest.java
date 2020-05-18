import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {
    public DatabaseConnection db = null;


    /*
    @BeforeEach
    void setUp() throws Exception {
        db = DatabaseConnection.getInstance();
        db.trueFalseAddQuestion(0, "test","test","test");
        db.mutipleChoiceAddQuestion(0, "test","test","test","test","test","test");
        db.shortAnswerAddQuestion(0, "test","test","test");
    }


    @AfterEach
    void tearDown() throws Exception {
        db.clearTestData();
    }
     */



    @Test
    void getInstance() {
        db = DatabaseConnection.getInstance();
        assertEquals(db instanceof DatabaseConnection, true);
    }



    @Test
    void searchTrueFalseQuery() throws Exception {
        ResultSet rs = db.searchQuery("SELECT * FROM trueFalse");

        int diff = rs.getInt("diff");
        String question = rs.getString("question");
        String answer = rs.getString("answer");
        String hint = rs.getString("hint");


        assertEquals(0, diff);
        assertEquals("test", question);
        assertEquals("test",answer);
        assertEquals("test",hint);
    }


    @Test
    void searchMultipleChoiceQuery() throws Exception {
        ResultSet rs = db.searchQuery("SELECT * FROM multipleChoice");

        int diff = rs.getInt("diff");
        String question = rs.getString("question");
        String answer = rs.getString("answer");
        String wrongAnswerOne = rs.getString("wrongAnswerOne");
        String wrongAnswerTwo = rs.getString("wrongAnswerTwo");
        String wrongAnswerThree = rs.getString("wrongAnswerThree");
        String hint = rs.getString("hint");


        assertEquals(0, diff);
        assertEquals("test", question);
        assertEquals("test",answer);
        assertEquals("test",hint);
        assertEquals("test", wrongAnswerOne);
        assertEquals("test",wrongAnswerTwo);
        assertEquals("test",wrongAnswerThree);
    }


    @Test
    void searchShortAnswerQuery() throws Exception {
        ResultSet rs = db.searchQuery("SELECT * FROM shortAnswer");

        int diff = rs.getInt("diff");
        String question = rs.getString("question");
        String answer = rs.getString("answer");
        String hint = rs.getString("hint");


        assertEquals(0, diff);
        assertEquals("test", question);
        assertEquals("test",answer);
        assertEquals("test",hint);
    }


}