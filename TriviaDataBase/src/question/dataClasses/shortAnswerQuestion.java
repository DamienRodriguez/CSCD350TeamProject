package question.dataClasses;

import database.DatabaseConnection;
import question.QuestionMenu;

import java.sql.ResultSet;

public class shortAnswerQuestion {

    private String questionID;
    private String question;
    private String answer;
    private String hint;

    public shortAnswerQuestion(final ResultSet rs) {
        try {

            setQuestionID(rs.getString(1));
            setQuestion(rs.getString(2));
            setAnswer(rs.getString(3));
            setHint(rs.getString(4));

        } catch(Exception e) {
            System.out.println("Error occured in shortAnswerQuestion(ResultSet)");
            e.printStackTrace();
        }
    }


    //this constructor will only be used with the createQuestion method
    public shortAnswerQuestion(final int difficulty, final String question, final String answer, final String hint) {
        this.question = question;
        this.answer = answer;
        this.hint = hint;
        this.questionID = generateQuestionID(DatabaseConnection.getInstance().getShortAnswerChoiceRecordCount(), difficulty);
    }


    //Attribute Getters and Setters
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


    public String getHint() {
        return hint;
    }


    public void setHint(String hint) {
        this.hint = hint;
    }


    //this will be in every single Question class, maybe move this to a seperate, smaller class
    //and have it strictly handle questionID generation
    private String generateQuestionID(final int recordCount, final int difficulty) {
        if(recordCount < 0 || difficulty < 0 || difficulty > 3)
            throw new IllegalArgumentException("Arguments in generateQuestionID are invalid.");

        String questionID = "SA-"; //init

        if(difficulty == 0)
            questionID = questionID + "EASY-";
        else if(difficulty == 1)
            questionID = questionID + "MEDI-";
        else if(difficulty == 2)
            questionID = questionID + "HARD-";
        else if(difficulty == 3)
            questionID = questionID + "MAST-";

        questionID = questionID + (recordCount + 1);

        return questionID;
    }
}
