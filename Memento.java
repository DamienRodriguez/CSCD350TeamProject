class Memento{
    private Memento state;
    private String saveName;
    private int cursor;
    private int[] playerPosition;
    private Room[][] maze;
 
    public Memento(String saveName, int cursor, int[] playerPosition, Room[][] maze)
    {
        this.saveName = saveName;
        this.cursor = cursor;
        this.playerPosition = playerPosition;
        this.maze = maze;
    }

    public Memento getState()
    {
        return state;
    }

    public String toString()
    {
        String str = "Save Name: " + saveName;
        
        str += ", the cursor is at: " + cursor;

        str += ", Player Position: X, Y";
        for (int fromPos : playerPosition)
        {
            str += ", " + fromPos;
        }

        return str;
    }

    public String getName()
    {
        return saveName;
    }
}