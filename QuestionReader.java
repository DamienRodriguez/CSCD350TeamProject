import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class QuestionReader {

    public static void main(String[] args) throws FileNotFoundException {
    System.out.println("In Question Reader.");

    File file = new File("Questions.txt");
    Scanner sc = new Scanner(file);
    String[] question = null;
    while (sc.hasNextLine()){
        question = sc.nextLine().split(" ! ");
        if (question.length == 6)
            addQuestionMC(question);
        else if (question.length == 3){
            if (question[1].equalsIgnoreCase("t") || question[1].equalsIgnoreCase("f"))
                addQuestionTF(question);
            else
                addQuestionSA(question);
        }
    }//end while loop
    sc.close();
}

	private static void addQuestionSA(String[] question) {
        //System.out.println("Adding Question SA.");
        for (int x = 0; x < question.length; x ++){
            System.out.println(question[x]);
        }
    }

    private static void addQuestionTF(String[] question) {
        //System.out.println("Adding Question TF.");
        for (int x = 0; x < question.length; x ++){
            System.out.println(question[x]);
        }
    }

    private static void addQuestionMC(String[] question) {
        //System.out.println("Adding Question MC.");
        for (int x = 0; x < question.length; x ++){
            System.out.println(question[x]);
        }
	}

}