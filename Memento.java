class Memento{
    private Memento state;
    private String saveName;
    private String[] answeredQs;
    private int[] playerPosition;
    private Room[][] maze;
 
    public Memento(String saveName, String[] answeredQs, int[] playerPosition, Room[][] maze)
    {
        this.saveName = saveName;
        this.answeredQs = answeredQs;
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
        
        for (String fromAQ : answeredQs)
        {
            str += ", " + fromAQ;
        }

        str += ", Player Position: X, Y";
        for (int fromPos : playerPosition)
        {
            str += ", " + fromPos;
        }

        return str;
    }
}