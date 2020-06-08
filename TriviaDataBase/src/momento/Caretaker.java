package momento;
import java.util.ArrayList;

public class Caretaker {
    private ArrayList<Memento> mementos = new ArrayList<>();

    public void addMemento(Memento m){
        mementos.add(m);
    }

    public Memento getMemento(String saveName){

        if (mementos.size()==0)
           {
            System.out.println("There are no save games.");
            return null;
            }

        for (int x = 0; x < mementos.size(); x ++){
            if (mementos.get(x).getName().equalsIgnoreCase(saveName)){
                return mementos.get(x);
            }
        }

        System.out.println("Your save was not found. These saves were found: ");
        for (int x = 0; x < mementos.size(); x ++){
            System.out.println(mementos.get(x).getName());
        }
        return null;
    }
}