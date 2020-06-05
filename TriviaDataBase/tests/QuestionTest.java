import Database.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {
    public final DatabaseConnection DB_CONNECTION = DatabaseConnection.getInstance();

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