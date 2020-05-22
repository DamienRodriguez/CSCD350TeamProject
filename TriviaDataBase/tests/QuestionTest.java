import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    public final DatabaseConnection DB_CONNECTION = DatabaseConnection.getInstance();

    @Test
    void numberIDTrueFalseGeneration() throws Exception{
        Question q = new Question();

        //creating number ID for a TrueFalse question
        int id = q.numberID(0, DB_CONNECTION);

        assertEquals(DB_CONNECTION.getTrueFalseRecordCount() + 1,id);
    }

    @Test
    void numberIDMultipleChoiceGeneration() throws Exception{
        Question q = new Question();

        //creating number ID for a TrueFalse question
        int id = q.numberID(1, DB_CONNECTION);

        assertEquals(DB_CONNECTION.getMultipleChoiceRecordCount() + 1,id);
    }

    @Test
    void numberIDShortAnswerGeneration() throws Exception{
        Question q = new Question();

        //creating number ID for a TrueFalse question
        int id = q.numberID(2, DB_CONNECTION);

        assertEquals(DB_CONNECTION.getShortAnswerChoiceRecordCount() + 1,id);
    }

    @Test
    void alphaIDGeneration() {
        Question q = new Question();
        assertEquals("eet",q.alphaID(0,0,0));
    }

    @Test
    void getID() {
        Question q = new Question();
        q.setId("test");
        assertEquals("test",q.getId());

    }


    @Test
    void createTrueFalseFullID() throws Exception {
        Question q = new Question();
        q.createID(0,0,0);
        System.out.println(q.getId());

        assertEquals("eet-1",q.getId());
    }

    @Test
    void createMultipleChoiceFullID() throws Exception {
        Question q = new Question();
        q.createID(0,0,1);
        System.out.println(q.getId());
        assertEquals("eem-1",q.getId());
    }

    
    @Test
    void createShortAnswerFullID() throws Exception {
        Question q = new Question();
        q.createID(0,0,2);

        System.out.println(q.getId());
        assertEquals("ees-1",q.getId());
    }


    @Test
    void getIDParseArray() throws Exception {
        Question q = new Question();
        q.createID(0,0,0);
        System.out.println(q.getId());

        char[] temp = {'e','e', 't', '-','2'};

        assertTrue(Arrays.equals(q.getIDParseArray(), temp));
    }
}