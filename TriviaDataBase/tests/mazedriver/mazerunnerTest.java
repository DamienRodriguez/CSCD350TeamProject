package test.mazedriver;

import mazedriver.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class mazerunnerTest {

    /**
     * Method: BFS(Room[][] tempmaze, player player1)
     */
    @Test
    public void testBFS() throws Exception {

        mazebuilder mazebuilder = new mazebuilder();
        maze maze = mazebuilder.newMaze("Y");
        Room[][] arr = maze.getMaze();
        player player = new player();
        assertEquals(true, mazerunner.BFS(arr,player));


    }
}
