public class Originator {
    private Memento state;
    private String saveName;
    private String[] answeredQs;
    private int[] playerPosition;
    private Room[][] maze;

    public void setState(String saveName, String[] answeredQs, int[] playerPosition, Room[][] maze){
        this.saveName = saveName;
        this.answeredQs = answeredQs;
        this.playerPosition = playerPosition;
        this.maze = maze;
    }

    public Memento save() {
        return new Memento(saveName, answeredQs, playerPosition, maze);
    }

    public void restore(Memento m)
    {
        state = m.getState();
    }
}