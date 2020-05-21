public class Main {
    public static void main(String[] args) {
        System.out.println("Testing memento saveState.");
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();

        //below are the variables that will go into the memento
        String saveName = "mysave"; //functionality for retrieving named saves to be added later
        String[] answeredQs = new String[] {"AAA-00000", "BBB-11111", "CCC-22222"};
        int[] playerPosition = new int[] {3,3};
        Room[][] maze = new Room[5][5];
        
        originator.setState(saveName, answeredQs, playerPosition, maze);
        caretaker.addMemento(originator.save());
        Memento mySave = caretaker.getMemento();
        String saveDetails = mySave.toString();
        System.out.println(saveDetails); //savedetails does not print out the entire maze.
    }
}