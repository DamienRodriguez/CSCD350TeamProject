public class maze {
    private final int size;
    private Room[][] maze;
    private int[] pos, exitPos;

    public maze(int size, int dif) {
        this.size =size;
        Room[][] maze = new Room[size][size];

        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                maze[row][column] = makeRoom(row, column);
            }
        }
        pos= new int[]{0, 0};
        exitPos = new int[]{5, 5};

        setMaze(maze);
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

        for (int x = 0; x < maze.length; x++) {

            for (int y = 0; y < maze.length; y++) {
                    String[] temp = maze[x][y].toString().split("%");
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
    public void movePlayer(char i) {
        int temp;

        if (i == 'w' && pos[0] > 0) { //move up

            temp = pos[0];
            pos[0] = temp - 1;
            roomInteractions();
        } else if (i == 's' && pos[0] < 4) {//move down

            temp = pos[0];
            pos[0] = temp + 1;
            roomInteractions();
            
        } else if (i == 'd' && pos[1] < 4) {//move right
            temp = pos[1];
            pos[1] = temp + 1;
            roomInteractions();

        } else if (i == 'a' && pos[1] > 0) {//move left
            temp = pos[1];
            pos[1] = temp - 1;
            roomInteractions();

        } else
            System.out.println("invalid, its a wall...");
    }


    private void roomInteractions() {
        System.out.println(pos[0] + " , " + pos[1]);
        if (canExit()) {
            if(this.maze[pos[0]][pos[1]].getHasExit()){
                System.out.println("This is the exit.");
            }
        }

    }

    private boolean canExit() {
        return false;
    }
}
