package Database;

import java.util.Scanner;

public class QuestionMenu {


    public static void menu() throws Exception {

        int choice = 0;

        while(choice != 5) {
            choice = Pmenu();

            if(choice >= 1 && choice <= 3)
                addQuestion(choice);
            else if(choice == 4)
                nukeIt();
        }
        DatabaseConnection.getInstance().closeConnection();
    }


    //Menu taken from 211 assignment
    private static int Pmenu() {
        Scanner kb = new Scanner(System.in);
        int choice = 0;
        do {
         System.out.println("1) Add a true false question");
         System.out.println("2) Add a multiple choice question");
         System.out.println("3) Add a short answer question");
         System.out.println("4) Nuke database");
         System.out.println("5) Quit");

         System.out.println("Please enter your choice -----> ");
         choice = kb.nextInt();
         kb.nextLine();


        } while(choice < 0 || choice > 5);


        return choice;
    }


    private static void nukeIt() {
        DatabaseConnection DB_CONNECTION = DatabaseConnection.getInstance();
        DB_CONNECTION.clearQuestionData();
    }


    private static void addQuestion(final int choice) throws Exception {
        DatabaseConnection DB_CONNECTION = DatabaseConnection.getInstance();

        Scanner kb = new Scanner(System.in);

        if(choice == 1)
            DB_CONNECTION.addQuestion(createTrueFalseQuestion());
        else if(choice == 2)
            DB_CONNECTION.addQuestion(createMultipleChoiceQuestion());
        else if(choice == 3)
            DB_CONNECTION.addQuestion(createShortAnswerQuestion());
        else
            System.out.println("This should not ever happen.");

    }


    private static Question createTrueFalseQuestion() {

        Scanner kb = new Scanner(System.in);

        String question;
        String answer;
        String hint;
        int difficulty;
        int roomType;
        System.out.println("What is the true false question you'd like to add? ");
        question = kb.nextLine();

        System.out.println("Is the answer True or False? (Type 'T' or 'F')");
        answer = kb.nextLine();

        System.out.println("What is a hint you would give to lead you to the answer?");
        hint = kb.nextLine();

        do {
            System.out.println("What would the difficulty of this question be? (Enter the number that you believe is closest to difficulty of the question");
            System.out.println("0: Easy");
            System.out.println("1: Medium");
            System.out.println("2: Hard");
            System.out.println("3: Master");
            difficulty = Integer.valueOf(kb.nextLine());

        } while(difficulty < 0 && difficulty > 3);


        do {
            System.out.println("Would you like this question to appear in a typical room, at the entrance room, or the exit room?");
            System.out.println("0: Entrance");
            System.out.println("1: Exit");
            System.out.println("2: Room");
            roomType = Integer.valueOf(kb.nextLine());
        } while(roomType < 0 && roomType > 3);


        Question q = new Question(difficulty, roomType, 0, question, answer, null, null, null, hint);

        return q;
    }


    private static Question createMultipleChoiceQuestion() throws Exception {

        Scanner kb = new Scanner(System.in);
        String question;
        String answer;
        String wrongAnswerOne;
        String wrongAnswerTwo;
        String wrongAnswerThree;
        String hint;
        int difficulty;
        int roomType;


        System.out.println("What is the multiple choice question you'd like to add? ");
        question = kb.nextLine();

        System.out.println("What is the answer to your question?");
        answer = kb.nextLine();

        System.out.println("What is a hint you would give to lead you to the answer?");
        hint = kb.nextLine();

        System.out.println("The next questions are for wrong answers to the multiple choice question generator.");
        System.out.println("The same question will be asked three times.");

        System.out.println("What is a wrong answer to the question?");
        wrongAnswerOne = kb.nextLine();

        System.out.println("What is a wrong answer to the question?");
        wrongAnswerTwo = kb.nextLine();

        System.out.println("What is a wrong answer to the question?");
        wrongAnswerThree = kb.nextLine();


        System.out.println("What would the difficulty of this question be? (Enter the number that you believe is closest to difficulty of the question");
        System.out.println("0: Easy");
        System.out.println("1: Medium");
        System.out.println("2: Hard");
        System.out.println("3: Master");
        difficulty = Integer.valueOf(kb.nextLine());

        System.out.println("Would you like this question to appear in a typical room, at the entrance room, or the exit room?");
        System.out.println("0: Entrance");
        System.out.println("1: Exit");
        System.out.println("2: Room");
        roomType = Integer.valueOf(kb.nextLine());

        Question q = new Question(difficulty, roomType, 1, question, answer, wrongAnswerOne, wrongAnswerTwo, wrongAnswerThree, hint);



        return q;
    }


    private static Question createShortAnswerQuestion() throws Exception {

        Scanner kb = new Scanner(System.in);

        String question;
        String answer;
        String hint;
        int difficulty;
        int roomType;

        System.out.println("What is the short answer question you'd like to add? ");
        question = kb.nextLine();

        System.out.println("What is the answer to your question?");
        answer = kb.nextLine();

        System.out.println("What is a hint you would give to lead you to the answer?");
        hint = kb.nextLine();

        System.out.println("What would the difficulty of this question be? (Enter the number that you believe is closest to difficulty of the question");
        System.out.println("0: Easy");
        System.out.println("1: Medium");
        System.out.println("2: Hard");
        System.out.println("3: Master");
        difficulty = Integer.valueOf(kb.nextLine());

        System.out.println("Would you like this question to appear in a typical room, at the entrance room, or the exit room?");
        System.out.println("0: Entrance");
        System.out.println("1: Exit");
        System.out.println("2: Room");
        roomType = Integer.valueOf(kb.nextLine());

        Question q = new Question(difficulty, roomType, 2, question, answer, null, null, null, hint);


        return q;
    }


    public static void main(String[] args) throws Exception {
        QuestionMenu.menu();
    }

}
