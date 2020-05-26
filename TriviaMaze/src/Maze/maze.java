package Maze;

import java.util.*;
import TriviaDataBase.*;

public class maze {
    private final int size;
    private Room[][] maze;
    private int[] pos, exitPos;


    private Hashtable<String, Question> questionIndex = new Hashtable<String, Question>();
    private Set<String> keySet = null;



    //if this breaks, it is the database connection m
    private void setQuestionIndex() {
        DatabaseConnection DB = DatabaseConnection.getInstance();
        ArrayList<Question> myList = DB.searchQuery("SELECT * FROM questions WHERE length(answer) == 1 AND wrongAnswerOne IS NULL");

        for (Question question : myList) {
            this.questionIndex.put(question.getId(), question);
        }

        this.keySet = this.questionIndex.keySet();
    }

    public maze(int size, int dif) {
        this.size =size;
        Room[][] maze = new Room[size][size];

        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                maze[row][column] = makeRoom(row, column);
            }
        }
        pos= new int[]{0, 0};
        exitPos = new int[]{4, 4};

        setMaze(maze);
    }


    public int[] getPos(){
        return this.pos;
    }


    public int[] getExitPos(){
        return this.exitPos;
    }


    public void setMaze(final Room[][] maze) {
        this.maze = maze;
    }


    private Room makeRoom(int x, int y) {
        int[] coords = new int[]{x, y};
        Room temp = new Room(coords);

        Question[] questions = new Question[temp.getNumDoors()];

        for(int i = 0; i < questions.length; i++) {
            questions[i] = questionIndex.get(keySet.iterator().next());
        }
        temp.setDoors(questions);

    }


    @Override
    public String toString() {
        StringBuilder strTop = new StringBuilder();
        StringBuilder strMid = new StringBuilder();
        StringBuilder strBot = new StringBuilder();
        StringBuilder strFinal = new StringBuilder();

        for (int x = 0; x < maze.length; x++) {

            for (int y = 0; y < maze.length; y++) {
                    String[] temp = maze[x][y].toString().split("%");
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


    public void movePlayer(String i) {
        int temp;

        if (i.equalsIgnoreCase("w") && pos[0] > 0) { //move up

            temp = pos[0];
            pos[0] = temp - 1;
            roomInteractions();
        } else if (i.equalsIgnoreCase("s") && pos[0] < 4) {//move down

            temp = pos[0];
            pos[0] = temp + 1;
            roomInteractions();
            
        } else if (i.equalsIgnoreCase("d") && pos[1] < 4) {//move right
            temp = pos[1];
            pos[1] = temp + 1;
            roomInteractions();

        } else if (i.equalsIgnoreCase("a") && pos[1] > 0) {//move left
            temp = pos[1];
            pos[1] = temp - 1;
            roomInteractions();

        } else
            System.out.println("invalid, its a wall...");
    }


    private void roomInteractions() {
        System.out.println(pos[0] + " , " + pos[1]);

        if(this.maze[pos[0]][pos[1]].getHasExit()){
            System.out.println("This is the exit.");
        }


    }

}
