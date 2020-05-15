import java.sql.*;

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

    private void createID() {
        //put stuff here
    }
}
