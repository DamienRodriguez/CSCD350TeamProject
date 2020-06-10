package test.mazedriver;

import mazedriver.mazebuilder;
import mazedriver.player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class playerTest { 

/** 
* 
* Method: movePlayer(String i, Room[][] tempmaze) 
* 
*/ 
@Test
public void testMovePlayer() throws Exception { 
//TODO: Test goes here...
    player player = new player();
    player.movePlayer("S",new mazebuilder().newMaze("Y").getMaze());

    assertEquals(1,player.getPos()[0]);
    assertEquals(0,player.getPos()[1]);
    player.movePlayer("d",new mazebuilder().newMaze("Y").getMaze());
    assertEquals(1,player.getPos()[0]);
    assertEquals(1,player.getPos()[1]);
} 

/** 
* 
* Method: getPos() 
* 
*/ 
@Test
public void testGetPos() throws Exception { 
//TODO: Test goes here...
    player player = new player();
    player.setPos(new int[]{4,4});
    assertEquals(4,player.getPos()[0]);
    assertEquals(4,player.getPos()[1]);
} 

/** 
* 
* Method: setPos(int[] pos) 
* 
*/ 
@Test
public void testSetPos() throws Exception {
    player player = new player();
    player.setPos(new int[]{4,4});
    assertEquals(4,player.getPos()[0]);
    assertEquals(4,player.getPos()[1]);

    player.setPos(new int[]{0,0});
    assertEquals(0,player.getPos()[0]);
    assertEquals(0,player.getPos()[1]);
    player.setPos(new int[]{1,4});
    assertEquals(1,player.getPos()[0]);
    assertEquals(4,player.getPos()[1]);

} 


} 
