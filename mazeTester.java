import java.util.Scanner;

public class mazeTester {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        mazebuilder factory = new mazebuilder();
        int choice = menu(kb);
        System.out.println("choice : "+choice);
        maze maze = factory.newMaze(choice);
        System.out.println(maze.toString());

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
