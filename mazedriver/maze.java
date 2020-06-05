package mazedriver;

/*
Author: Kevin Underwood
Class: CSCD350
version 1.2

 */
public class maze {
    private final int size;
    private Room[][] maze;
    private int[] exitPos;

    public maze(int size, int dif) {
        this.size =size;
        Room[][] maze = new Room[size][size];

        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                maze[row][column] = makeRoom(row, column);
            }
        }

        exitPos = new int[]{4, 4};

        setMaze(maze);
    }


    public int[] getExitPos(){
        return this.exitPos;
    }


    public void setMaze(final Room[][] maze) {
        this.maze = maze;
    }


    private Room makeRoom(int x, int y) {
        int[] coords = new int[]{x, y};
        return new Room(coords);
    }


    @Override
    public String toString() {
        StringBuilder strTop = new StringBuilder();
        StringBuilder strMid = new StringBuilder();
        StringBuilder strBot = new StringBuilder();
        StringBuilder strFinal = new StringBuilder();

        for (Room[] rooms : maze) {

            for (int y = 0; y < maze.length; y++) {
                String[] temp = rooms[y].toString().split("%");
                strTop.append(temp[0]).append(" ");
                strMid.append(temp[1]).append(" ");
                strBot.append(temp[2]).append(" ");
            }

            strFinal.append(strTop);
            strFinal.append("\n");

            strFinal.append(strMid);
            strFinal.append("\n");

            strFinal.append(strBot);
            strFinal.append("\n");

            strTop = new StringBuilder();
            strMid = new StringBuilder();
            strBot = new StringBuilder();

        }
        return strFinal.toString();
    }

}
