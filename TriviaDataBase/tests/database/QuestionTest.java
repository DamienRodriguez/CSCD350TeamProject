package database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {
    Question q = new Question();

    @BeforeEach
    void init() {
        q = new Question(0,0,0,"test","test","test","test","test","test");
        q.setId("test");
    }

    @Test
    void getId() {
        assertEquals("test",q.getId());
    }

    @Test
    void setId() {
        q.setId("Oni");
        assertEquals("Oni",q.getId());
    }

    @Test
    void getQuestion() {
        assertEquals("test",q.getQuestion());
    }

    @Test
    void setQuestion() {
        q.setQuestion("Omni");
        assertEquals("Omni",q.getQuestion());

    }

    @Test
    void getAnswer() {
        assertEquals("test",q.getAnswer());
    }

    @Test
    void setAnswer() {
        q.setAnswer("Invoker");
        assertEquals("Invoker",q.getAnswer());
    }

    @Test
    void getHint() {
        assertEquals("test",q.getHint());
    }

    @Test
    void setHint() {
        q.setHint("Slark");
        assertEquals("Slark",q.getHint());
    }

    @Test
    void getWrongAnswerOne() {
        assertEquals("test",q.getWrongAnswerOne());
    }

    @Test
    void setWrongAnswerOne() {
        q.setWrongAnswerOne("Crystal Maiden");
        assertEquals("Crystal Maiden", q.getWrongAnswerOne());
    }

    @Test
    void getWrongAnswerTwo() {
        assertEquals("test",q.getWrongAnswerTwo());
    }

    @Test
    void setWrongAnswerTwo() {
        q.setWrongAnswerTwo("Chen");
        assertEquals("Chen", q.getWrongAnswerTwo());
    }

    @Test
    void getWrongAnswerThree() {
        assertEquals("test",q.getWrongAnswerThree());
    }

    @Test
    void setWrongAnswerThree() {
        q.setWrongAnswerThree("Anti-Mage");
        assertEquals("Anti-Mage",q.getWrongAnswerThree());
    }

    @Test
    void getIDParseArray() {
        char[] myArray = {'t','e','s','t'};
        assertArrayEquals(myArray, q.getIDParseArray());
    }

    @Test
    void createTrueFalseFullID() throws Exception {
        Question q = new Question();
        q.createID(0,0,0);
        System.out.println(q.getId());

        assertEquals("eet-12",q.getId());
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
    void testToString() {
        String test = "test | test | test | test | test | test | test";
        System.out.println(q.toString());
        assertEquals(test, q.toString());

    }
}