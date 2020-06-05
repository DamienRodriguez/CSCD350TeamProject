package mazedriver;


/*
Author: Kevin Underwood
Class: CSCD350
version 1.4

 */


public class mazebuilder {

    public mazedriver.maze newMaze(int choice, String cheats) {
        if(choice == 1){
            System.out.println("Easy maze chosen...building");
            return new mazedriver.maze(5,choice,cheats);
        }else if(choice == 2){
            System.out.println("Medium maze chosen...building");
            return new mazedriver.maze(5,choice,cheats);
        }else if(choice == 3){
            System.out.println("Hard maze chosen...building");
            return new mazedriver.maze(5,choice,cheats);
        }else{
            System.out.println("You should not have gotten here...");
            System.out.println("Returning the easy mode.");
            return new mazedriver.maze(5,1,cheats);
        }


    }
}
