package mazedriver;


/*
Author: Kevin Underwood
Class: CSCD350
version 1.2

 */


public class mazebuilder {

    public mazedriver.maze newMaze(int choice) {
        if(choice == 1){
            System.out.println("easy maze chosen...building");
            return new mazedriver.maze(5,choice);
        }else if(choice == 2){
            System.out.println("medium maze chosen...building");
            return new mazedriver.maze(5,choice);
        }else if(choice == 3){
            System.out.println("Hard maze chosen...building");
            return new mazedriver.maze(5,choice);
        }else{
            System.out.println("You should not have gotten here...");
            System.out.println("returning the easy mode since you cant follow directions.");
            return new mazedriver.maze(5,1);
        }
    }
}
