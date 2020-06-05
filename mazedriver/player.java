package mazedriver;


/*
Author: Kevin Underwood
Class: CSCD350
version 1.2

 */


public class player {


    public static int[] pos = new int[]{0,0};

    public void movePlayer(String i) {
        int temp;

        if (i.equalsIgnoreCase("w") && pos[0] > 0) { //move up

            temp = pos[0];
            pos[0] = temp - 1;


        } else if (i.equalsIgnoreCase("s") && pos[0] < 4) {//move down

            temp = pos[0];
            pos[0] = temp + 1;


        } else if (i.equalsIgnoreCase("d") && pos[1] < 4) {//move right
            temp = pos[1];
            pos[1] = temp + 1;


        } else if (i.equalsIgnoreCase("a") && pos[1] > 0) {//move left
            temp = pos[1];
            pos[1] = temp - 1;


        } else
            System.out.println("invalid, its a wall...");

        System.out.println("new position: "+pos[0]+","+pos[1]);
    }



    public int[] getPos() {
        return pos;
    }
}