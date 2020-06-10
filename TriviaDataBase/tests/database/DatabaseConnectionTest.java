package database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

    @AfterEach
    void tearDown() {
        DatabaseConnection.getInstance().clearQuestionData();
    }

    @Test
    void getInstance() {
        DatabaseConnection instance = DatabaseConnection.getInstance();
        assertTrue(instance instanceof DatabaseConnection);
    }

    @Test
    void addQuestion() {
        Question q = new Question(0,0,0,"test","test","test","test","test","test");
        DatabaseConnection.getInstance().addQuestion(q);
        assertEquals(1, DatabaseConnection.getInstance().getTotalRecordCount());
    }
    @Test
    void getTrueFalseRecordCount() {
        DatabaseConnection test = DatabaseConnection.getInstance();
        assertEquals(0, test.getTrueFalseRecordCount());
    }

    @Test
    void setTrueFalseRecordCount() {
    }

    @Test
    void getMultipleChoiceRecordCount() {
        DatabaseConnection test = DatabaseConnection.getInstance();
        assertEquals(0, test.getMultipleChoiceRecordCount());
    }

    @Test
    void setMultipleChoiceRecordCount() {
    }

    @Test
    void getShortAnswerChoiceRecordCount() {
        DatabaseConnection test = DatabaseConnection.getInstance();
        assertEquals(0, test.getShortAnswerChoiceRecordCount());
    }

    @Test
    void setShortAnswerChoiceRecordCount() {
    }

    @Test
    void getTotalRecordCount() {
        DatabaseConnection test = DatabaseConnection.getInstance();
        assertEquals(0, test.getTotalRecordCount());
    }

    @Test
    void setTotalRecordCount() {
    }

    @Test
    void updateRecordCount() {
        DatabaseConnection.getInstance().updateRecordCount('t');
        assertEquals(1, DatabaseConnection.getInstance().getTrueFalseRecordCount());
        assertEquals(0, DatabaseConnection.getInstance().getShortAnswerChoiceRecordCount());
        assertEquals(0, DatabaseConnection.getInstance().getMultipleChoiceRecordCount());
        assertEquals(1, DatabaseConnection.getInstance().getTrueFalseRecordCount());
    }

    @Test
    void clearQuestionData() {
        DatabaseConnection.getInstance().clearQuestionData();
        assertEquals(DatabaseConnection.getInstance().getTotalRecordCount(), 0);

    }

    @Test
    void closeConnection() {
        DatabaseConnection test = DatabaseConnection.getInstance();
        assertTrue(test.closeConnection());
    }

    @Test
    void recordExists() {
        Question q = new Question(0,0,0,"test","test","test","test","test","test");
        q.setId("test");
        DatabaseConnection.getInstance().addQuestion(q);
        assertTrue(DatabaseConnection.getInstance().recordExists("test"));
    }

}