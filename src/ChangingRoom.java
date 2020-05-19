import javax.swing.*;
import java.util.ArrayList;

public class ChangingRoom {

    private int capacity;
    private ArrayList<Bodybuilder> people;
    private JTextArea textArea;

    public ChangingRoom(int capacity, JTextArea textArea){
        this.capacity = capacity;
        this.people = new ArrayList<>(capacity);
        this.textArea = textArea;
    }

    public boolean isAvailable() {
        if (people.size() < capacity) {
            return true;
        }
        return false;
    }

    public synchronized void useChangingRoom(Bodybuilder bodybuilder){
        this.people.add(bodybuilder);
        this.setTextArea();
    }

    public synchronized void exitChangingRoom(Bodybuilder bodybuilder){
        this.people.remove(bodybuilder);
        this.setTextArea();
    }

    public synchronized void setTextArea(){
        textArea.setText("");
        if(people.size() > 0){
            people.forEach(person -> {
                textArea.append(person.toString() + "\n");
            });
        }
        else textArea.setText("Free");
    }

}
