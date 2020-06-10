package test.mazedriver;

import mazedriver.Room;
import mazedriver.maze;
import mazedriver.mazebuilder;
import mazedriver.player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class mazeTest { 

@Test
public void testGetExitPos() throws Exception { 

    maze maze =new mazebuilder().newMaze("Y");
    assertEquals(4,maze.getExitPos()[0]);
    assertEquals(4,maze.getExitPos()[1]);
} 

/** 
* 
* Method: setMaze(final Room[][] maze) 
* 
*/ 
@Test
public void testSetMaze() throws Exception {
    maze maze =new mazebuilder().newMaze("Y");

    Room[][] newmaze =new mazebuilder().newMaze("Y").getMaze();
    maze.setMaze(newmaze);
    assertEquals(maze.getMaze().toString(),newmaze.toString());
} 

/** 
* 
* Method: toString() 
* 
*/ 
@Test
public void testToString() throws Exception {
    maze maze =new mazebuilder().newMaze("Y");
    Room[][] newmaze =new mazebuilder().newMaze("Y").getMaze();
    maze.setMaze(newmaze);
    assertEquals(maze.getMaze().toString(),newmaze.toString());
} 


/** 
* 
* Method: touchDoor(String c, player player1) 
* 
*/ 
@Test
public void testTouchDoor() throws Exception {

    assertEquals(1,new mazebuilder().newMaze("Y").touchDoor("w",new player()));
    assertEquals(1,new mazebuilder().newMaze("Y").touchDoor("S",new player()));
    assertEquals(1,new mazebuilder().newMaze("Y").touchDoor("A",new player()));
    assertEquals(1,new mazebuilder().newMaze("Y").touchDoor("d",new player()));
    assertEquals(0,new mazebuilder().newMaze("N").touchDoor("S",new player()));
    assertEquals(3,new mazebuilder().newMaze("N").touchDoor("W",new player()));
    assertEquals(3,new mazebuilder().newMaze("N").touchDoor("A",new player()));


} 


} 
