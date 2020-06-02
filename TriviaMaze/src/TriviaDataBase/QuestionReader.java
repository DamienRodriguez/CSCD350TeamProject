package TriviaDataBase;


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

class QuestionReader {


    private File file;
    private Scanner fin;
    ArrayList<String[]> questions;


    public QuestionReader() {
        try {
            file = new File("D:\\Code Dump\\CSCD350TeamProject\\TriviaMaze\\src\\TriviaDataBase\\Questions.txt");
            fin = new Scanner(file);
        } catch(Exception e) {
            System.out.println(e);
        }
        setQuestions();

        fin.close();
    }

    public ArrayList<String[]> getQuestions() {
        return this.questions;
    }


    public void setQuestions() {
        String [] question;
        while(fin.hasNextLine()) {
            question = fin.nextLine().split("!");
            this.questions.add(question);
        }
    }

}