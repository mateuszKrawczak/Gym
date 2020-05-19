import javax.swing.*;
import java.util.ArrayList;

public class Reception {

    private ArrayList<Bodybuilder> people;
    private JTextArea textArea;

    public Reception(JTextArea textArea){
        this.textArea = textArea;
        this.people = new ArrayList<>();
    }

    public synchronized void comeToReception(Bodybuilder bodybuilder){
        this.people.add(bodybuilder);
        this.setTextArea();
    }

    public synchronized void customerService(){
        if(this.people.size() > 0){
            Bodybuilder bodybuilder = this.people.get(0);
            bodybuilder.setKeyOwnership();
            if(bodybuilder.getKeyOwnership()){
                bodybuilder.collectLockerKey();
            }
            else{
                bodybuilder.returnLockerKey();
            }
            this.people.remove(bodybuilder);
            this.setTextArea();
        }
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

    public int getNumberOfPeople(){
        return people.size();
    }
}
