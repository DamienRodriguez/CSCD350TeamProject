package test.mazedriver;

import mazedriver.maze;
import mazedriver.mazebuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RoomTest {


    /**
     * Method: getNorthdoor()
     */
    @Test
    public void testGetNorthdoor() throws Exception {

        assertEquals(1, new mazebuilder().newMaze("Y").getMaze()[0][0].getNorthdoor());
        assertEquals(3, new mazebuilder().newMaze("n").getMaze()[0][0].getNorthdoor());
        assertEquals(0, new mazebuilder().newMaze("n").getMaze()[1][1].getNorthdoor());
    }

    /**
     * Method: getSouthdoor()
     */
    @Test
    public void testGetSouthdoor() throws Exception {

        assertEquals(1, new mazebuilder().newMaze("Y").getMaze()[0][0].getSouthdoor());
        assertEquals(0, new mazebuilder().newMaze("n").getMaze()[0][0].getSouthdoor());
        assertEquals(3, new mazebuilder().newMaze("n").getMaze()[4][0].getSouthdoor());
    }

    /**
     * Method: getEastdoor()
     */
    @Test
    public void testGetEastdoor() throws Exception {
        assertEquals(1, new mazebuilder().newMaze("Y").getMaze()[0][0].getEastdoor());
        assertEquals(0, new mazebuilder().newMaze("n").getMaze()[0][0].getEastdoor());
        assertEquals(3, new mazebuilder().newMaze("n").getMaze()[0][4].getEastdoor());
    }

    /**
     * Method: getWestdoor()
     */
    @Test
    public void testGetWestdoor() throws Exception {
        maze maze = new mazebuilder().newMaze("Y");
        maze.getMaze()[0][0].setWestdoor(0);
        assertEquals(0, maze.getMaze()[0][0].getWestdoor());
        maze.getMaze()[0][0].setWestdoor(1);
        assertEquals(1, maze.getMaze()[0][0].getWestdoor());
        maze.getMaze()[0][0].setWestdoor(2);
        assertEquals(2, maze.getMaze()[0][0].getWestdoor());
        maze.getMaze()[0][0].setWestdoor(3);
        assertEquals(3, maze.getMaze()[0][0].getWestdoor());
    }

    /**
     * Method: setNorthdoor(int northdoor)
     */
    @Test
    public void testSetNorthdoor() throws Exception {
        maze maze = new mazebuilder().newMaze("Y");
        maze.getMaze()[0][0].setNorthdoor(0);
        assertEquals(0, maze.getMaze()[0][0].getNorthdoor());
        maze.getMaze()[0][0].setNorthdoor(1);
        assertEquals(1, maze.getMaze()[0][0].getNorthdoor());
        maze.getMaze()[0][0].setNorthdoor(2);
        assertEquals(2, maze.getMaze()[0][0].getNorthdoor());
        maze.getMaze()[0][0].setNorthdoor(3);
        assertEquals(3, maze.getMaze()[0][0].getNorthdoor());
    }

    /**
     * Method: setSouthdoor(int southdoor)
     */
    @Test
    public void testSetSouthdoor() throws Exception {
        maze maze = new mazebuilder().newMaze("Y");
        maze.getMaze()[0][0].setSouthdoor(0);
        assertEquals(0, maze.getMaze()[0][0].getSouthdoor());
        maze.getMaze()[0][0].setSouthdoor(1);
        assertEquals(1, maze.getMaze()[0][0].getSouthdoor());
        maze.getMaze()[0][0].setSouthdoor(2);
        assertEquals(2, maze.getMaze()[0][0].getSouthdoor());
        maze.getMaze()[0][0].setSouthdoor(3);
        assertEquals(3, maze.getMaze()[0][0].getSouthdoor());
    }

    /**
     * Method: setEastdoor(int eastdoor)
     */
    @Test
    public void testSetEastdoor() throws Exception {
        maze maze = new mazebuilder().newMaze("Y");
        maze.getMaze()[0][0].setEastdoor(0);
        assertEquals(0, maze.getMaze()[0][0].getEastdoor());
        maze.getMaze()[0][0].setEastdoor(1);
        assertEquals(1, maze.getMaze()[0][0].getEastdoor());
        maze.getMaze()[0][0].setEastdoor(2);
        assertEquals(2, maze.getMaze()[0][0].getEastdoor());
        maze.getMaze()[0][0].setEastdoor(3);
        assertEquals(3, maze.getMaze()[0][0].getEastdoor());
    }

    /**
     * Method: setWestdoor(int westdoor)
     */
    @Test
    public void testSetWestdoor() throws Exception {
        maze maze = new mazebuilder().newMaze("Y");
        maze.getMaze()[0][0].setWestdoor(0);
        assertEquals(0, maze.getMaze()[0][0].getWestdoor());
        maze.getMaze()[0][0].setWestdoor(1);
        assertEquals(1, maze.getMaze()[0][0].getWestdoor());
        maze.getMaze()[0][0].setWestdoor(2);
        assertEquals(2, maze.getMaze()[0][0].getWestdoor());
        maze.getMaze()[0][0].setWestdoor(3);
        assertEquals(3, maze.getMaze()[0][0].getWestdoor());
    }
}
