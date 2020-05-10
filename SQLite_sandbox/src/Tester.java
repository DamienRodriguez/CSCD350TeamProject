import java.sql.*;

public class Tester {

    public static void main(String[]args) throws Exception {
        DamiensDBConnector connection = new DamiensDBConnector();

        //connection.trueFalseAddQuestion(1, "The Happy part of Stu Land is the best part.", "T", "Bad part is bad.");
        connection.mutipleChoiceAddQuestion(1, "How many years are there between world fairs?", "5 years", "7 years", "10 years", "4 years", "it is 5 years.");

    }
}
