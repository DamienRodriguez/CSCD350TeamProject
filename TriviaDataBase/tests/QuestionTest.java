import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    public static Question q;
    @BeforeAll
    static void setUp() {
        q = new Question("test", "test",  "test", "test","test", "test");
    }

    @Test
    void getID() {
        assertEquals("ee-00001", q.getId());
    }


    @Test
    void getQuestion() {
        assertEquals("test", q.getQuestion());
    }


    @Test
    void getAnswer() {
        assertEquals("test", q.getAnswer());
    }


    @Test
    void getHint() {
        assertEquals("test", q.getHint());
    }


    @Test
    void getWrongAnswerOne() {
        assertEquals("test", q.getWrongAnswerOne());
    }


    @Test
    void getWrongAnswerTwo() {
        assertEquals("test", q.getWrongAnswerTwo());
    }


    @Test
    void getWrongAnswerThree() {
        assertEquals("test", q.getWrongAnswerThree());
    }


    @Test
    void getIDParseArray() {

        char[] temp = {'e','e','-','0','0','0','0','1'};

        assertTrue(Arrays.equals(q.getIDParseArray(), temp));
    }
}