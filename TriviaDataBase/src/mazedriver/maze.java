package mazedriver;

import database.*;


import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
Author: Kevin Underwood
Class: CSCD350
version 1.5
Revisor: Damien Rodriguez

 */
public class maze {

    private final int size;
    private Room[][] maze;
    private int[] exitPos;



    public maze(int size, int dif, String cheats) {
        DatabaseConnection databaseconnection = DatabaseConnection.getInstance();
        this.size =size;
        Room[][] maze = new Room[size][size];

        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                maze[row][column] = makeRoom(row, column);
                if(cheats.equalsIgnoreCase("y")) {
                    maze[row][column].setSouthdoor(1);
                    maze[row][column].setNorthdoor(1);
                    maze[row][column].setEastdoor(1);
                    maze[row][column].setWestdoor(1);
                }
            }
        }

        exitPos = new int[]{4, 4};
        setMaze(maze);
    }


    public int[] getExitPos(){
        return this.exitPos;
    }


    public void setMaze(final Room[][] maze) {
        this.maze = maze;
    }


    public Room[][] getMaze() {
        return maze;
    }


    private Room makeRoom(int x, int y) {
        int[] coords = new int[]{x, y};
        return new Room(coords);
    }


    @Override
    public String toString() {
        StringBuilder strTop = new StringBuilder();
        StringBuilder strMid = new StringBuilder();
        StringBuilder strBot = new StringBuilder();
        StringBuilder strFinal = new StringBuilder();

        for (Room[] rooms : maze) {

            for (int y = 0; y < maze.length; y++) {
                String[] temp = rooms[y].toString().split("%");
                strTop.append(temp[0]).append(" ");
                strMid.append(temp[1]).append(" ");
                strBot.append(temp[2]).append(" ");
            }

            strFinal.append(strTop);
            strFinal.append("\n");

            strFinal.append(strMid);
            strFinal.append("\n");

            strFinal.append(strBot);
            strFinal.append("\n");

            strTop = new StringBuilder();
            strMid = new StringBuilder();
            strBot = new StringBuilder();

        }
        return strFinal.toString();
    }


    public boolean answerQuestion(Scanner kb) {

        String[] answer;
        //Pull a question from the database
        Question question = DatabaseConnection.getInstance().pullQuestion();


        //stubbed for testing waiting for Damiens database.

        //determine what type of question is being asked
        if(question.getWrongAnswerOne() == null)
            if(question.getAnswer().length() == 1)
                return askTFQuestion(question);
            else
                return askSAQuestion(question);

        else
            return askMCQuestion(question);

    }


    private String[] makeAnswerArray(final Question question) {
        String[] answerArray;

        if(question.getWrongAnswerTwo() != null) {
            answerArray = new String[4];
            answerArray[0] = question.getAnswer();
            answerArray[1] = question.getWrongAnswerOne();
            answerArray[2] = question.getWrongAnswerTwo();
            answerArray[3] = question.getWrongAnswerThree();
        }

        //If it is a t/f or short answer question
        else {
            answerArray = new String[1];
            answerArray[0] = question.getAnswer();
        }

        return answerArray;
    }


    private int findAnswerInArray(final Question question, final String[] answerArray) {
        for(int i = 0; i < answerArray.length; i++) {
            if(answerArray[i].equals(question.getAnswer()))
                return i;
        }
        return -1;
    }


    private boolean askMCQuestion(final Question question) {

        //Display Question
        System.out.println(question.getQuestion());

        //Get answer Array
        String[] answerArray = makeAnswerArray(question);
        Collections.shuffle(Arrays.asList(answerArray));

        //Display answer options
        for(int i = 0; i < answerArray.length; i++) {
            System.out.println((i + 1) +") " + answerArray[i]);
        }

        System.out.println("Please enter a number between 1 and 4");
        System.out.print("----------->");
        Scanner kb = new Scanner(System.in);
        int answer = 0;

        //get user input
        try {
            answer = Integer.parseInt(kb.nextLine());
        } catch(Exception e) {
            return false; //if they put anything other than a number this will know
        }

        int actualAnswer = findAnswerInArray(question, answerArray);


        return actualAnswer == (answer - 1);
    }


    private boolean askTFQuestion(final Question question) {

        //Display Question
        System.out.println(question.getQuestion());

        //Get answer Array
        String[] answerArray = makeAnswerArray(question);

        //Display answer options

        System.out.println("Please enter either a 'T' or 'F'");
        System.out.print("----------->");
        Scanner kb = new Scanner(System.in);

        //get user input
        String input = kb.nextLine();
        if(input.length() != 1)
            return false;

        return question.getAnswer().equals(input);
    }


    private boolean askSAQuestion(final Question question) {

        //Display Question
        System.out.println(question.getQuestion());

        //Get answer Array
        String[] answerArray = makeAnswerArray(question);

        //Display answer options

        System.out.println("Please enter either a 'T' or 'F'");
        System.out.print("----------->");
        Scanner kb = new Scanner(System.in);

        //get user input
        String input = kb.nextLine();

        return question.getAnswer().equalsIgnoreCase(input);
    }

//DAMIEN LOOK HERE DAMIEN LOOK HERE DAMIEN LOOK HERE DAMIEN LOOK HERE DAMIEN LOOK HERE DAMIEN LOOK HERE DAMIEN LOOK HERE DAMIEN LOOK HERE
//These methods were a bit ambigous, and I didn't understand how to use them, so I expanded the askQuestion method. Hopefully it all works.

    //what if we call answer question here, and find some way for it to call lock
    //monkaHmm
    public int check(String c, player player1) {
        int[] temp = player1.getPos();
        if (c.equalsIgnoreCase("w")) { //move up
            return maze[temp[0]][temp[1]].getNorthdoor();
        } else if (c.equalsIgnoreCase("s")) {//move down
            return maze[temp[0]][temp[1]].getSouthdoor();
        } else if (c.equalsIgnoreCase("d")) {//move right
            return maze[temp[0]][temp[1]].getEastdoor();
        } else {//move left
            return maze[temp[0]][temp[1]].getWestdoor();
        }

    }


    public void lock(String c, player player1) {
        int[] temp = player1.getPos();
        if (c.equalsIgnoreCase("w")) { //move up
            maze[temp[0]][temp[1]].setNorthdoor(2);
        } else if (c.equalsIgnoreCase("s")) {//move down
            maze[temp[0]][temp[1]].setSouthdoor(2);
        } else if (c.equalsIgnoreCase("d")) {//move right
            maze[temp[0]][temp[1]].setEastdoor(2);
        } else if (c.equalsIgnoreCase("a")) {//move left
            maze[temp[0]][temp[1]].setWestdoor(2);

        }else System.out.println("Problem in lock");

    }
}
