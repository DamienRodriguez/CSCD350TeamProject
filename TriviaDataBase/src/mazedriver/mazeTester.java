package mazedriver;


/*
Author: Kevin Underwood
Class: CSCD350
version 1.4
attributions: took BFS from an old homework assignment and retrofitted it for this purpose
Revisor: Damien Rodriguez

Notes: Cheats are simple allows the user to just run through and test the movement and function of the maze.
        Its activated on creation of the maze on creation
 */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


import database.DatabaseConnection;
import momento.*;


public class mazeTester {

    private static Caretaker caretaker = new Caretaker(); //YOU MUST ADD THIS TO THE MAZE DRIVER
    private static Originator originator = new Originator(); //YOU MUST ADD THIS TO THE MAZE DRIVER

    public static void main(String[] args) {
        boolean gameOver;
        String t = "y";
        Scanner kb = new Scanner(System.in);
        do {
            maze maze = menu(kb);

            playGame(maze);
            kb.nextLine();
            System.out.println("keep playing? y/n");
            String temp = kb.nextLine();
            gameOver = t.equalsIgnoreCase(temp);
        } while (gameOver);

    }


    //I believe that this is where the issue happens
    private static void playGame(maze maze) {
        Scanner kb = new Scanner(System.in);
        player player1 = new player();
        Room[][] tempmaze = maze.getMaze();

        int doorStatus = -1; //default value

        do {
            System.out.println(maze.toString());
            String choice = gameMenu(kb);

            if(choice.equalsIgnoreCase("e")) {
                saveGame(kb, maze, player1, DatabaseConnection.getInstance().getHashTableCursor());
            }
            else if(choice.equalsIgnoreCase("q")) {
                Memento gameState = loadGame(kb);
                System.out.println(gameState.toString());
                maze = gameState.getMaze();
                player1.setPos(gameState.getPosition());
                DatabaseConnection.getInstance().setHashTableCursor(gameState.getCursor());
            }

            else {
                doorStatus = maze.touchDoor(choice, player1);
                if(doorStatus < 3){

                    //door ask stuff
                    if(doorStatus == 0) {

                        if(maze.answerQuestion(kb)) //correct answer, door updated in player
                            player1.movePlayer(choice, tempmaze);
                        else {
                            maze.lock(choice, player1);
                            System.out.println("The lock clicks...\n"+"You know that door will never open again");
                        }
                    }
                    else if(doorStatus == 2)
                        System.out.println("The doors locked!\n"+"I better find another way round!");
                }
                else
                    System.out.println("That is a wall humble adventurer.");


            }

        } while (!Arrays.equals(player1.getPos(), maze.getExitPos()) && BFS(tempmaze,player1));

        System.out.println(maze.toString());
        int[] temp = player1.getPos();
        if (temp[0] == 4 && temp[1] == 4) {
            System.out.println("You win!");
        } else
            System.out.println("You lose.");


    }


    private static String gameMenu(Scanner kb) {
        String game_choice;
        boolean bool = true;
        do {
            System.out.println("            [Q] " + " [W] " + " [E]\n" +
                    "            [A] " + " [S] " + " [D]\n" +
                    "       load | " + " move up " + " | save\n" +
                    "  move left |" + " move down " + " | move right\n");
            game_choice = kb.nextLine();

            if (game_choice.equalsIgnoreCase("a") || game_choice.equalsIgnoreCase("w") || game_choice.equalsIgnoreCase("s") || game_choice.equalsIgnoreCase("d") || game_choice.equalsIgnoreCase("e") || game_choice.equalsIgnoreCase("q")) {
                bool = false;
            }
        } while (bool);
        return game_choice;
    }


    private static maze menu(Scanner kb) {
        mazebuilder factory = new mazebuilder();
        System.out.println("Welcome to Maze Tester!\n"
                + "Please pick the difficulty of the maze you want to try.\n"
                + "1.  easy mode\n"
                + "2.  medium mode\n"
                + "3.  hard mode\n");
        int choice = kb.nextInt();
        kb.nextLine();
        System.out.println("play with cheats?\n"+"(y/n)");
        String cheats = kb.nextLine();


        return factory.newMaze(choice,cheats);

    }


    public static boolean BFS(Room[][] tempmaze, player player1) {

        int xValue = tempmaze.length;
        int yvalue = tempmaze[0].length;
        int[] temp =player1.getPos();
        boolean[][] visited = new boolean[xValue][yvalue];

        Queue queue = new LinkedList<>();
        queue.add(temp[0] + "/" + temp[1]);

        while (!queue.isEmpty()) {

            String x = (String) queue.remove();
            int row = Integer.parseInt(x.split("/")[0]);
            int col = Integer.parseInt(x.split("/")[1]);

            if (row >= 0 && col >= 0 && row < xValue && col < yvalue && !visited[row][col]) {
                visited[row][col] = true;
                if (tempmaze[row][col].getWestdoor() < 2)
                    queue.add(row + "/" + (col - 1)); //go west
                if (tempmaze[row][col].getEastdoor() < 2)
                    queue.add(row + "/" + (col + 1)); //go east
                if (tempmaze[row][col].getNorthdoor() < 2)
                    queue.add((row - 1) + "/" + col); //go north
                if (tempmaze[row][col].getSouthdoor() < 2)
                    queue.add((row + 1) + "/" + col); //go south
                if (visited[4][4])
                    return true;
            }
        }
        return false;
    }


    static void saveGame(Scanner kb, maze maze, player player1, int questionCursor) {
        System.out.println("What would like to call your save game?");
        String saveName = kb.nextLine();

        //SAVEGAME MUST BE ADDED TO MAZE() C
        int cursor = questionCursor;
        int[] playerPosition = player1.getPos();

        originator.setState(saveName, cursor, playerPosition, maze);
        caretaker.addMemento(originator.save());
    }


    static Memento loadGame(Scanner kb) {
        System.out.println("in load game");
        String saveName = "";
        Memento mySave = null;
        while (saveName == null || saveName.equals("")) {
            System.out.println("Please enter the save name: ");
            saveName = kb.nextLine();
            mySave = caretaker.getMemento(saveName);
        }
        return mySave;
    }


}
