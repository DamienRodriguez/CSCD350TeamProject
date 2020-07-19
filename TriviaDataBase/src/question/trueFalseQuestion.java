package question;

import database.DatabaseConnection;


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


    //this constructor will only be used with the createQuestion method
    private trueFalseQuestion(final int difficulty, final String question, final String answer, final String hint) {

        this.question = question;
        this.answer = answer;
        this.hint = hint;
        this.questionID = generateQuestionID(DatabaseConnection.getInstance().getTrueFalseRecordCount(), difficulty);



    }

    public void createQuestion() {
        //ask user for the question

        //ask user for the answer

        //ask user for a hint

        //create question

        //send question to databaseManager for processing
    }

    //this will be in every single Question class, maybe move this to a seperate, smaller class
    //and have it strictly handle questionID generation
    private String generateQuestionID(final int recordCound, final int difficulty) {
        return null;
    }


    public QuestionI pullQuestion() {
        return null;
    }
}
