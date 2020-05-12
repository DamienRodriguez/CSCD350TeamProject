import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {
    public DatabaseConnection db = null;

    @BeforeEach
    void setUp() throws Exception {
        db = DatabaseConnection.getInstance();
        db.trueFalseAddQuestion(0, "test","test","test");
        db.mutipleChoiceAddQuestion(0, "test","test","test","test","test","test");
        db.shortAnswerQuestions(0,"test","test","test");
    }

    @AfterEach
    void tearDown() throws Exception {
        db.clearTestData();
    }

    @Test
    void getInstance() {
        db = DatabaseConnection.getInstance();
        assertEquals(db instanceof DatabaseConnection, true);
    }

    @Test
    void searchFourPartQuery() {
        assertEquals(0,1);
        //need kevins help
    }

    @Test
    void searchSevenPartQuery() {
        assertEquals(0,1);
        //need kevins help
    }


}