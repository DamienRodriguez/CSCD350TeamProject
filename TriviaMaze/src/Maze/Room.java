package Maze;
import TriviaDataBase.*;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

/*Room.java
 *Author: Kevin Underwood
 *Revision: 2
 *Rev. Author: Damien Rodriguez
 *Description: Class used to create rooms for the maze.
 */

public class Room {

    private boolean hasExit = false;
    private boolean hasEntrance = false;
    private boolean visited = true;
    private int[] coordinates;
    private int numDoors;

    private Door nDoor;
    private Door sDoor;
    private Door wDoor;
    private Door eDoor;

    Room(int[] coords, Hashtable<String, Question> questionIndex, Hashtable<String, Question> usedQuestions) {
        setCoordinates(coords);
        setDoors(questionIndex, usedQuestions);
    }


    private void setDoors(Hashtable<String, Question> index, Hashtable<String, Question> used) {

        if(this.coordinates[0] != 0) {
            nDoor = new Door();
            generateQuestion(nDoor, index, used);
            this.numDoors++;
        }

        if(this.coordinates[0] != 4) {
            sDoor = new Door();
            generateQuestion(sDoor, index, used);
            this.numDoors++;
        }

        if(this.coordinates[1] != 0) {
            wDoor = new Door();
            generateQuestion(wDoor, index, used);
            this.numDoors++;
        }

        if(this.coordinates[1] != 4) {
            eDoor = new Door();
            generateQuestion(eDoor, index, used);
            this.numDoors++;
        }
    }


    private void generateQuestion(final Door door, Hashtable<String, Question> questionIndex, Hashtable<String, Question> usedQuestions) {

        Object[] keySet = questionIndex.keySet().toArray();
        Random rand = new Random();

        int upperBound = keySet.length;
        int index = rand.nextInt(upperBound);

        Question q = questionIndex.get(keySet[index]);

        while(usedQuestions.contains(q) && index < keySet.length) {
            q = questionIndex.get(keySet[index++]);
        }

        door.setQuestion(q);

        usedQuestions.put(q.getId(), q);
    }


    public int getNumDoors() {
        return numDoors;
    }


    private void setNumDoors(final int doors) {
        this.numDoors = doors;
    }


    private void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }


    public void setHasExit() {
        this.hasExit = true;
    }


    boolean getHasExit() {
        return hasExit;
    }


    void sethasEntrance() {
        this.hasEntrance = true;
    }


    private boolean getHasEntrance() {
        return hasEntrance;
    }


    private void isVisited() {
        this.visited = true;
    }


    private boolean getVisited() {
        return visited;
    }


    private char whatIsInRoom() {
        boolean[] arr = {getHasExit()};
        int numOfTrue = 0;
        for (boolean b : arr) {
            if (b)
                numOfTrue++;
        }//end for
        if (numOfTrue == 1) {
            if (getHasExit())
                return 'O';
            else if (getHasEntrance())
                return 'I';
            //else if (this.equals())
        //return'P';
    }

        return ' ';
    }


    @Override
    public String toString() {
        isVisited(); //can only be drawn if it was visited.
        char c = whatIsInRoom();

        //Needs work when drawing out the room info.
        if (this.coordinates[1] == 0) { //left side
            if (this.coordinates[0] == 0) {
                return "***%*" + c + "|%*-*"; //upper corner
            }//end if
            else if (this.coordinates[0] == 4) {//lower corner
                return "*-*%*" + c + "|%***";
            }else {
                return "*-*%*" + c + "|%*-*"; //West walls
            }//end if

        } else if (this.coordinates[1] == 4) { //right side
            if (this.coordinates[0] == 0) {
                return "***%|" + c + "*%*-*"; //upper corner
            }else if (this.coordinates[0] == 4) { //lower corner
                return "*-*%|" + c + "*%***";
            }else {
                return "*-*%|" + c + "*%*-*"; //East Wall
            }
        } else {
            if (this.coordinates[0] == 0) {//North Wall
                return "***%|" + c + "|%*-*";
            }else if (this.coordinates[0] == 4) {//South Wall
                return "*-*%|" + c + "|%***";
            }else {
                return "*-*%|" + c + "|%*-*"; //base room
            }
        }
    }


    public void answerQuestion(String i) {

        if(i.equalsIgnoreCase("w"))
            nDoor.question(questionPrompt(nDoor.getQuestion()));

        if(i.equalsIgnoreCase("s"))
            sDoor.question(questionPrompt(sDoor.getQuestion()));

        if(i.equalsIgnoreCase("d"))
            eDoor.question(questionPrompt(eDoor.getQuestion()));

        if(i.equalsIgnoreCase("a"))
            wDoor.question(questionPrompt(wDoor.getQuestion()));

    }


    private String questionPrompt(final Question question) {
        Scanner kb = new Scanner(System.in);

        System.out.println(question.getQuestion());
        System.out.print("---->");
        return kb.nextLine();
    }

}
