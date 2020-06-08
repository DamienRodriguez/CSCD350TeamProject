package momento;
import mazedriver.Room;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing memento saveState.");
        Caretaker caretaker = new Caretaker(); //YOU MUST ADD THIS TO THE MAZE DRIVER
        Originator originator = new Originator(); //YOU MUST ADD THIS TO THE MAZE DRIVER
        Scanner kb = new Scanner(System.in);
        //saveGame(caretaker, originator, kb);
        //Memento mySave = loadGame(caretaker, originator, kb);

        //System.out.println(mySave.toString());
        kb.close();
    }

    /*
    public static void saveGame(Caretaker caretaker, Originator originator, Scanner kb){
        System.out.println("What would like to call your save game?");
        String saveName = kb.nextLine();

        //SAVEGAME MUST BE ADDED TO MAZE() C
        int cursor = 10; 
        int[] playerPosition = new int[] {3,3};
         maze = new Room[5][5];
        
        originator.setState(saveName, cursor, playerPosition, maze);
        caretaker.addMemento(originator.save());
    }



    public static Memento loadGame(Caretaker caretaker, Originator originator, Scanner kb){
        String saveName = "";
        Memento mySave = null;
        while (saveName == null || saveName == ""){
            System.out.println("Please enter the save name: ");
            saveName = kb.nextLine();
            mySave = caretaker.getMemento(saveName);
        }
        return mySave;
    }

     */
}