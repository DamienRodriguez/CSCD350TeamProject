public class Room {
    private boolean hasExit = false;
    private boolean hasEntrance = false;
    private boolean visited = true;
    private int[] coordinates;



    Room(int[] coords) {
        setCoordinates(coords);
        /*
         * doors
         * 0 locked can be attempted
         * 1  unlocked
         * 2 permanently locked
         * */
        int northdoor = 0;
        int southdoor = 0;
        int eastdoor = 0;
        int westdoor = 0;
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


}
