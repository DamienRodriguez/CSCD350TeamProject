package test.mazedriver;

import mazedriver.maze;
import mazedriver.mazebuilder;
import org.junit.*;


import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;


public class mazebuilderTest { 

@Test
public void testNewMaze() throws Exception {
    assertThat(new mazebuilder().newMaze("Y"), instanceOf(maze.class));
    assertThat(new mazebuilder().newMaze("N"), instanceOf(maze.class));
} 
}
