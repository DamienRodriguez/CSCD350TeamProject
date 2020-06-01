import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class QuestionReader {

    public static void main(String[] args) throws FileNotFoundException {
    System.out.println("In Question Reader.");

    File file = new File("Questions.txt");
    Scanner sc = new Scanner(file);
    String[] question = null;
    int counter = 1;
    while (sc.hasNextLine()){
        question = sc.nextLine().split(" ! ");
        if (question.length == 6)
            addQuestionMC(question, counter);
        else if (question.length == 3){
            if (question[1].equalsIgnoreCase("t") || question[1].equalsIgnoreCase("f"))
                addQuestionTF(question, counter);
            else
                addQuestionSA(question, counter);
        }
        counter ++;
    }//end while loop
    sc.close();
}

	private static void addQuestionSA(String[] question, int counter) {
        //System.out.println("Adding Question SA.");
        String qid = "";
        if (counter <= 32){
            qid = "ees";
        }
        if (counter > 32 && counter <= 64){
            qid = "mes";
        }
        if (counter > 64 && counter <= 96){
            qid = "hes";
        }
        System.out.println(qid);
        for (int x = 0; x < question.length; x ++){
            System.out.println(question[x]);
        }
    }

    private static void addQuestionTF(String[] question, int counter) {
        //System.out.println("Adding Question TF.");
        String qid = "";
        if (counter <= 32){
            qid = "eet";
        }
        if (counter > 32 && counter <= 64){
            qid = "met";
        }
        if (counter > 64 && counter <= 96){
            qid = "het";
        }
        System.out.println(qid);
        for (int x = 0; x < question.length; x ++){
            System.out.println(question[x]);
        }
    }

    private static void addQuestionMC(String[] question, int counter) {
        //System.out.println("Adding Question MC.");
        String qid = "";
        if (counter <= 32){
            qid = "eem";
        }
        if (counter > 32 && counter <= 64){
            qid = "mem";
        }
        if (counter > 64 && counter <= 96){
            qid = "hem";
        }
        System.out.println(qid);
        for (int x = 0; x < question.length; x ++){
            System.out.println(question[x]);
        }
	}

}