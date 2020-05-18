import java.sql.*;
import java.util.Random;

public class Question {

    private String id;
    private String question;
    private String answer;
    private String hint;
    private String wrongAnswerOne;
    private String wrongAnswerTwo;
    private String wrongAnswerThree;

    public Question(final ResultSet rs) throws SQLException {
        setId(rs.getString("id"));
        setQuestion(rs.getString("question"));
        setAnswer(rs.getString("answer"));
        setWrongAnswerOne(rs.getString("wrongAnswerOne"));
        setWrongAnswerTwo(rs.getString("wrongAnswerTwo"));
        setWrongAnswerThree(rs.getString("wrongAnswerThree"));
        setHint(rs.getString("hint"));

    }


    public Question(final String question, final String answer, final String wrongAnswerOne, final String wrongAnswerTwo, final String wrongAnswerThree, final String hint) {
        createID();
        setQuestion(question);
        setAnswer(answer);
        setWrongAnswerOne(wrongAnswerOne);
        setWrongAnswerTwo(wrongAnswerTwo);
        setWrongAnswerThree(wrongAnswerThree);
        setHint(hint);
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getQuestion() {
        return question;
    }


    public void setQuestion(String question) {
        this.question = question;
    }


    public String getAnswer() {
        return answer;
    }


    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public String getHint() {
        return hint;
    }


    public void setHint(String hint) {
        this.hint = hint;
    }


    public String getWrongAnswerOne() {
        return wrongAnswerOne;
    }


    public void setWrongAnswerOne(String wrongAnswerOne) {
        this.wrongAnswerOne = wrongAnswerOne;
    }


    public String getWrongAnswerTwo() {
        return wrongAnswerTwo;
    }


    public void setWrongAnswerTwo(String wrongAnswerTwo) {
        this.wrongAnswerTwo = wrongAnswerTwo;
    }


    public String getWrongAnswerThree() {
        return wrongAnswerThree;
    }


    public void setWrongAnswerThree(String wrongAnswerThree) {
        this.wrongAnswerThree = wrongAnswerThree;
    }

    public char[] getIDParseArray() {
        return this.id.toCharArray();
    }


    //Value hard coded for testing purposes
    public void createID() {
        int indexNum = numberID();
        String id = alphaID(0,0, 0) + "-" + indexNum;

        //if id exists
        //increment the indexNum by 1
        //check again, repeat as necessary. this is a concept that i forgot that involves hashtables.
        //assign unique id.
        //profit.
    }


    //need to figure out what to do with this method
    private String alphaID(final int difficulty, final int room_type, final int question_type) {

        String characterID = "";
        if(difficulty == 0) {
            characterID = characterID + "e";
        }
        else if(difficulty == 2) {
            characterID = characterID + "m";
        }
        else if(difficulty == 3) {
            characterID = characterID + "h";
        }

        if(room_type == 0) {
            characterID = characterID + "e";
        }
        else if(room_type == 2) {
            characterID = characterID + "x";
        }
        else if(room_type == 3) {
            characterID = characterID + "r";
        }

        if(question_type == 0) {
            characterID = characterID + "t";
        }
        else if(question_type == 2) {
            characterID = characterID + "m";
        }
        else if(question_type == 3) {
            characterID = characterID + "s";
        }

        return characterID;
    }


    //need to figure out how to handle padding when it comes to this number
    private int numberID() {
        Random random = new Random();
        int randInt = random.nextInt(1000);
        return randInt;
    }
}
