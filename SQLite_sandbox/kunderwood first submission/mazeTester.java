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
            System.out.println(maze.toString());
            System.out.println("continue y/n");
            String temp = kb.nextLine();
            if(temp.equalsIgnoreCase("y")){
                gameOver=false;
            }else
                gameOver=true;

        }while(!gameOver);
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
