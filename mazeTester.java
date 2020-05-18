import java.util.Arrays;
import java.util.Scanner;

public class mazeTester {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        mazebuilder factory = new mazebuilder();
        int choice = menu(kb);
        System.out.println("choice : " + choice);
        maze maze = factory.newMaze(choice);
            playGame(maze);

    }



    private static void playGame(maze maze) {
        Scanner kb = new Scanner(System.in);
        boolean gameOver;
        char t = 'n';
        do {
            do {
            System.out.println(maze.toString());
            String choice = gameMenu(kb);
            maze.movePlayer(choice);
            }while(!Arrays.equals(maze.getPos(), maze.getExitPos()));


            System.out.println("continue y/n");
            String temp = kb.nextLine();
            gameOver= !temp.equalsIgnoreCase("y");

        }while(!gameOver);
    }

    private static String gameMenu(Scanner kb) {
        String game_choice;
        boolean bool =true;
        do {
            System.out.println("move up     " + "     [W]\n" +
                    "            [A] " + " [S] " + " [D]\n" +
                    "    move down" + " move left" + " move right\n");
            game_choice = kb.nextLine();
            if(game_choice.equalsIgnoreCase("a") ||game_choice.equalsIgnoreCase("w") || game_choice.equalsIgnoreCase("s") ||game_choice.equalsIgnoreCase("d") ){
                bool =false;
            }
        } while (bool);
        return game_choice;
    }
    private static int menu(Scanner kb) {
        System.out.println("Welcome to Maze Tester!\n"
                            +"Please pick the difficulty of the maze you want to try.\n"
                            +"1.  easy mode\n"
                            +"2.  medium mode\n"
                            +"3.  hard mode\n");
        int choice = kb.nextInt();
        return choice;
    }
}
