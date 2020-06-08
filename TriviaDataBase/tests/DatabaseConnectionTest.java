import database.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

    public DatabaseConnection db = null;

    @BeforeEach
    void setUp() {
        db = DatabaseConnection.getInstance();
    }

    @Test
    void getInstance() {
        assertTrue(db instanceof DatabaseConnection);
    }
/*
    @Test
    void searchQuery() throws Exception {
        ArrayList<Question> list = new ArrayList<Question>();

        db.searchQuery("SELECT * FROM questions WHERE wrongAnswerOne IS NOT NULL", list);

        System.out.println(list.toString());

        Question q = list.get(0);

        assertEquals("eem-1",q.getId());
        assertEquals("test", q.getQuestion());
        assertEquals("test", q.getAnswer());
        assertEquals("test", q.getHint());
        assertEquals("test", q.getWrongAnswerOne());
        assertEquals("test", q.getWrongAnswerTwo());
        assertEquals("test", q.getWrongAnswerThree());


    }


    @Test
    void addQuestion() throws Exception {
        db.addQuestion(new Question("eem-2","test 2", "test 2", "test 2", "test 2","test 2", "test 2"));

        ArrayList<Question> checker = new ArrayList<Question>();

        db.searchQuery("SELECT * FROM questions WHERE wrongAnswerOne IS NOT NULL", checker);

        boolean added = false;
        if(checker.size() > 1) {
            added = true;
        }

        assertTrue(added);
    }


    @Test
    void closeConnection() {
    }

    @Test
    void getTrueFalseRecordCount() {
    }

    @Test
    void getMultipleChoiceRecordCount() {
    }

    @Test
    void getShortAnswerChoiceRecordCount() {
    }

    @Test
    void getTotalRecordCount() {
    }

 */
}