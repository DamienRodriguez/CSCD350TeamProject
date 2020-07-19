package question;

import database.DatabaseConnection;

import java.sql.ResultSet;


//Part of a larger structure where the questions are created here, but are sent to a larger
//list of items that consist of all of the questions that could be asked


/*TODO:
    Look into whether it would be more cost efficient to assign a question ID to the associated door,
    Or if pulling the question as each door is accessed would be more efficient
 */
public class trueFalseQuestion implements QuestionI {

    private String questionID;
    private String question;
    private String answer;
    private String hint;

    public trueFalseQuestion(final ResultSet rs) {
        try {

            setQuestionID(rs.getString(1));
            setQuestion(rs.getString(2));
            setAnswer(rs.getString(3));
            setHint(rs.getString(4));

        } catch(Exception e) {
            System.out.println("Error occured in trueFalseQuestion(ResultSet)");
            e.printStackTrace();
        }
    }


    //this constructor will only be used with the createQuestion method
    public trueFalseQuestion(final int difficulty, final String question, final String answer, final String hint) {

        this.question = question;
        this.answer = answer;
        this.hint = hint;
        this.questionID = generateQuestionID(DatabaseConnection.getInstance().getTrueFalseRecordCount(), difficulty);



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


    public void createQuestion() {
        trueFalseQuestion q = QuestionMenu.createTrueFalseQuestion();

        //send question to databaseManager for processing

    }

    //this will be in every single Question class, maybe move this to a seperate, smaller class
    //and have it strictly handle questionID generation
    private String generateQuestionID(final int recordCount, final int difficulty) {
        String questionID = "TF-"; //init

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
