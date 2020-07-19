package question;

import database.DatabaseConnection;

import static org.junit.jupiter.api.Assertions.*;

class trueFalseQuestionTest {

    private trueFalseQuestion q;


    @org.junit.jupiter.api.BeforeEach
    void init() {
        q = new trueFalseQuestion(0,"test","t","test");
    }

    @org.junit.jupiter.api.Test
    void getQuestionID() {
        assertEquals("TF-EASY-1", q.getQuestionID());
    }

    @org.junit.jupiter.api.Test
    void setQuestionID() {
        q.setQuestionID("test");
        assertEquals("test",q.getQuestionID());
    }

    @org.junit.jupiter.api.Test
    void getQuestion() {
        assertEquals("test",q.getQuestion());
    }

    @org.junit.jupiter.api.Test
    void setQuestion() {
        q.setQuestion("Appa, yip yip.");
        assertEquals("Appa, yip yip.", q.getQuestion());
    }

    @org.junit.jupiter.api.Test
    void getAnswer() {
        assertEquals("t",q.getAnswer());
    }

    @org.junit.jupiter.api.Test
    void setAnswer() {
        q.setAnswer("MY CABBAGES!");
        assertEquals("MY CABBAGES!", q.getAnswer());
    }

    @org.junit.jupiter.api.Test
    void getHint() {
        assertEquals("test",q.getHint());
    }

    @org.junit.jupiter.api.Test
    void setHint() {
        q.setHint("Boomi was here.");
        assertEquals("Boomi was here.", q.getHint());
    }

    @org.junit.jupiter.api.Test
    void createQuestion() {
        int previousRecordCount = DatabaseConnection.getInstance().getTrueFalseRecordCount();
        q.createQuestion();

        assertEquals(previousRecordCount + 1, DatabaseConnection.getInstance().getRecordCount("SELECT COUNT(*) AS rowCount FROM trueFalse"));
    }
}