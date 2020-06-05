package mazedriver;


/*
Author: Kevin Underwood
Class: CSCD350
version 1.2

 */


public class Room {
    private boolean visited = true;
    private int[] coordinates;



    Room(int[] coords) {
        setCoordinates(coords);
        /*
         * doors
         * 0 locked can be attempted
         * 1  unlocked
         * 2 permanently locked
         */

        int northdoor = 0;
        int southdoor = 0;
        int eastdoor = 0;
        int westdoor = 0;
    }

    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    //set


    //unlock all

    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

    private void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }


    boolean getHasExit() {
        return this.coordinates[0] == 4 && this.coordinates[1] == 4;
    }



    private boolean getHasEntrance() {
        return this.coordinates[0] == 0 && this.coordinates[1] == 0;
    }


    private void isVisited() {
        this.visited = true;
    }



    private boolean getHasPlayer() {
        return this.coordinates[0] == (mazedriver.player.pos[0]) && this.coordinates[1] == (mazedriver.player.pos[1]);

    }


    private char whatIsInRoom() {
        boolean[] arr = {getHasExit(),getHasEntrance(),getHasPlayer()};
        int numOfTrue = 0;
        for (boolean b : arr) {
            if (b)
                numOfTrue++;
        }//end for
        if (numOfTrue == 1) {
            if (getHasPlayer())
                return 'P';
            else if (getHasEntrance())
                return 'I';
            else if (getHasExit())
                return'O';
        }else if(numOfTrue >=2)
            return 'P';

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


}
