package momento;

import mazedriver.maze;

public class Originator {
    private Memento state;
    private String saveName;
    private int cursor;
    private int[] playerPosition;
    private mazedriver.maze maze;

    public void setState(String saveName, int cursor, int[] playerPosition, maze maze){
        this.saveName = saveName;
        this.cursor = cursor;
        this.playerPosition = playerPosition;
        this.maze = maze;
    }

    public Memento save() {
        return new Memento(saveName, cursor, playerPosition, maze);
    }

    public void restore(Memento m)
    {
        state = m.getState();
    }
}