package TriviaDataBase;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

class QuestionReader {


    private File file;
    private Scanner fin;
    Stack<Question> stack = new Stack<Question>();

    public Stack<Question> getStack() {
        return stack;
    }

    public void setStack(Stack<Question> stack) {
        this.stack = stack;
    }


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


    public void setQuestions() {


        String [] question;
        do {
            question = fin.nextLine().split("!");
            Question q = null;
            if(question.length == 3) {

                if(question[1].length() == 1)
                    q = new Question(0,0,1,question[0],question[1],"null","null","null",question[2]);
                else
                    q = new Question(0,0,2,question[0],question[1],"null","null","null",question[2]);
            }
            else
                q = new Question(0,0,1,question[0],question[1],question[2],question[3],question[4],question[5]);

            stack.add(q);

        } while(fin.hasNextLine());


    }


}