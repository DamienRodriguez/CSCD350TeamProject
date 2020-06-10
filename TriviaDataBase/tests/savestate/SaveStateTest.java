package savestate;

import mazedriver.Room;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SaveStateTest {

    @Test
    void saveState() {
        SaveState state = new SaveState();
        Room[][] roomArray = new Room[1][1];
        roomArray[0][0] = null;
        int[] fakePos = {0,0};
        int fakeCursor = 1;
        assertTrue(state.saveState(roomArray, fakePos, fakeCursor));
    }

    @Test
    void loadState() {
        SaveState state = new SaveState();
        Room[][] roomArray = new Room[1][1];
        roomArray[0][0] = null;
        int[] fakePos = {0,0};
        int fakeCursor = 1;
        state.saveState(roomArray, fakePos, fakeCursor);

        ArrayList<Object> myList = state.loadState();

        assertEquals(3, myList.size());


    }
}