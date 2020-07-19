package question.dataClasses;

import java.sql.ResultSet;

public class multipleChoiceQuestion {

    private String questionID;
    private String question;
    private String answer;
    private String wrongAnswerOne;
    private String wrongAnswerTwo;
    private String wrongAnswerThree;
    private String hint;

    public multipleChoiceQuestion(final ResultSet rs) {
        try {

            setQuestionID(rs.getString(1));
            setQuestion(rs.getString(2));
            setAnswer(rs.getString(3));
            setWrongAnswerOne(rs.getString(4));
            setWrongAnswerTwo(rs.getString(5));
            setWrongAnswerThree(rs.getString(6));
            setHint(rs.getString(7));

        } catch(Exception e) {
            System.out.println("ERROR HAPPENED in multipleChoice(ResultSet) Constructor");
            e.printStackTrace();
        }
    }


    public String getQuestionID() {
        return questionID;
    }


    public void setQuestionID(String questionID) {
        this.questionID = questionID;
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


    public String getHint() {
        return hint;
    }


    public void setHint(String hint) {
        this.hint = hint;
    }

}
