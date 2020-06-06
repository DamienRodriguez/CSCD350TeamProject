package mazedriver;


/*
Author: Kevin Underwood
Class: CSCD350
version 1.4
attribution: damien and I worked on the dungeon crawler for 349 together.
The drawing of the layout is based on that old driver.
 */


public class Room {

    private int[] coordinates;
    int northdoor = 0;
    int southdoor = 0;
    int eastdoor = 0;
    int westdoor = 0;

    Room(int[] coords) {
        setCoordinates(coords);

    }


    public int getNorthdoor() {
        return northdoor;
    }

    public int getSouthdoor() {
        return southdoor;
    }

    public int getEastdoor() {
        return eastdoor;
    }

    public int getWestdoor() {
        return westdoor;
    }

    public void setNorthdoor(int northdoor) {
        this.northdoor = northdoor;
    }

    public void setSouthdoor(int southdoor) {
        this.southdoor = southdoor;
    }

    public void setEastdoor(int eastdoor) {
        this.eastdoor = eastdoor;
    }

    public void setWestdoor(int westdoor) {
        this.westdoor = westdoor;
    }

    private void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }


    boolean getHasExit() {
        return this.coordinates[0] == 4 && this.coordinates[1] == 4;
    }



    private boolean getHasEntrance() {
        return this.coordinates[0] == 0 && this.coordinates[1] == 0;
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
