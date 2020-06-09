package savestate;

import mazedriver.*;

import java.io.*;
import java.util.Arrays;

public class SaveState {


    public void saveState(maze currentMaze, player currentPlayer) {

        try {
            File fMaze = new File("saveDataMaze.txt");
            File fPlayer = new File("saveDataPlayer.txt");

            FileOutputStream mazeOut = new FileOutputStream(fMaze);
            ObjectOutputStream oMazeOut = new ObjectOutputStream(mazeOut);

            FileOutputStream playerOut = new FileOutputStream(fPlayer);
            ObjectOutputStream oPlayerOut = new ObjectOutputStream(playerOut);

            oMazeOut.writeObject(currentMaze);
            oPlayerOut.writeObject(currentPlayer);

            oPlayerOut.close();
            oMazeOut.close();

            playerOut.close();
            mazeOut.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void loadState(maze currentMaze, player currentPlayer) {

        try {
            File fMaze = new File("saveDataMaze.txt");
            File fPlayer = new File("saveDataPlayer.txt");


            FileInputStream mazeOut = new FileInputStream(fMaze);
            ObjectInputStream oMazeOut = new ObjectInputStream(mazeOut);

            FileInputStream playerOut = new FileInputStream(fPlayer);
            ObjectInputStream oPlayerOut = new ObjectInputStream(playerOut);


            System.out.println("temp maze read in");
            maze tempMaze = (maze)oMazeOut.readObject();

            player tempPlayer = (player)oPlayerOut.readObject();

            System.out.println(tempMaze.toString());
            System.out.println(Arrays.toString(tempPlayer.getPos()));

            oPlayerOut.close();
            oMazeOut.close();

            playerOut.close();
            mazeOut.close();

        } catch(Exception e) {
            System.out.println(e);
        }

    }
}
