import java.sql.*;

public class Question {

    private String id;
    private String question;
    private String answer;
    private String hint;
    private String wrongAnswerOne;
    private String wrongAnswerTwo;
    private String wrongAnswerThree;


    // This is the constructor that will be used for search queries
    public Question(final ResultSet rs) throws SQLException {
        setId(rs.getString("id"));
        setQuestion(rs.getString("question"));
        setAnswer(rs.getString("answer"));
        setWrongAnswerOne(rs.getString("wrongAnswerOne"));
        setWrongAnswerTwo(rs.getString("wrongAnswerTwo"));
        setWrongAnswerThree(rs.getString("wrongAnswerThree"));
        setHint(rs.getString("hint"));

    }


    public Question() {
        this.id = null;
        setQuestion(null);
        setAnswer(null);
        setWrongAnswerOne(null);
        setWrongAnswerTwo(null);
        setWrongAnswerThree(null);
        setHint(null);
    }


    //This constructor is used for question creation via the menu admin tool.
    //This will be where the random ID generation would take place
    public Question(final int difficulty, final int roomType, final int questionType, final String question, final String answer, final String wrongAnswerOne, final String wrongAnswerTwo, final String wrongAnswerThree, final String hint) throws Exception {
        createID(difficulty, roomType, questionType);
        setQuestion(question);
        setAnswer(answer);
        setWrongAnswerOne(wrongAnswerOne);
        setWrongAnswerTwo(wrongAnswerTwo);
        setWrongAnswerThree(wrongAnswerThree);
        setHint(hint);
    }


    //This constructor would be for test purposes ONLY
    //This is meant to emulate a true or false/short answer question, with fixed "magic" values for testing
    //This will eventually be deleted after a testing method can be used for the random generation
    public Question(final String questionID, final String question, final String answer, final String hint) {
        setId(questionID);
        setQuestion(question);
        setAnswer(answer);
        setHint(hint);
        setWrongAnswerOne(null);
        setWrongAnswerTwo(null);
        setWrongAnswerThree(null);
    }


    //Please see above constructors comments
    //This however emulates multipleChoice questions with fixed "magic" number values for testing
    public Question(final String questionID, final String question, final String answer, final String wrongAnswerOne, final String wrongAnswerTwo, final String wrongAnswerThree, final String hint) {
        setId(questionID);
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


    public void createID(final int difficulty, final int roomType, final int questionType) throws Exception {

        final DatabaseConnection DB_CONNECTION = DatabaseConnection.getInstance();

        int numID = numberID(questionType, DB_CONNECTION);
        String alphaID = alphaID(difficulty, roomType, questionType);

        String questionID = alphaID + "-" + numID;
        if(!DB_CONNECTION.exists(questionID)) {
            numID++;
            questionID = alphaID + "-" + numID;
            setId(questionID);
        }
        else {
            setId(questionID);
        }


        //I believe this updates the record count. Could potentially be
        DB_CONNECTION.updateRecordCount(alphaID.charAt(2));
        DB_CONNECTION.closeConnection();

    }


    //the below methods were made protected for testing purposes. They will be returned to private after testing is completed.
    protected String alphaID(final int difficulty, final int roomType, final int questionType) {

        String characterID = "";
        if(difficulty == 0) {
            characterID = characterID + "e";
        }
        else if(difficulty == 1) {
            characterID = characterID + "m";
        }
        else if(difficulty == 2) {
            characterID = characterID + "h";
        }

        if(roomType == 0) {
            characterID = characterID + "e";
        }
        else if(roomType == 1) {
            characterID = characterID + "x";
        }
        else if(roomType == 2) {
            characterID = characterID + "r";
        }

        if(questionType == 0) {
            characterID = characterID + "t";
        }
        else if(questionType == 1) {
            characterID = characterID + "m";
        }
        else if(questionType == 2) {
            characterID = characterID + "s";
        }

        return characterID;
    }


    protected int numberID(final int questionType, final DatabaseConnection DB_CONNECTION) {

        int id = 0;
        if(questionType == 0)
            id = DB_CONNECTION.getTrueFalseRecordCount() + 1;
        else if(questionType == 1)
            id = DB_CONNECTION.getMultipleChoiceRecordCount() + 1;
        else if(questionType == 2)
            id = DB_CONNECTION.getShortAnswerChoiceRecordCount() + 1;
        else
            throw new IllegalArgumentException("questionType wasn't within range. Passed into numberID.");

        return id;


    }


}
