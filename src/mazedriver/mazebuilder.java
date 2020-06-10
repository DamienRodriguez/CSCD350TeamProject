package mazedriver;


/*
Author: Kevin Underwood
Class: CSCD350
version 1.4

 */


public class mazebuilder {

    public mazedriver.maze newMaze(String cheats) {

            return new mazedriver.maze(5,1,cheats);

    }


    public static maze loadMaze(Room[][] rooms) {
        return new maze(rooms);
    }

}
