import javax.swing.*;

public class Equipment {

    private String name;

    private Bodybuilder user;

    private JLabel label;

    public Equipment(String name, JLabel label){
        this.name = name;
        this.label = label;
    }

    public boolean isAvailable(){
        if(user == null){
            return true;
        }
        return false;
    }

    public void setUser(Bodybuilder bodybuilder) {
        user = bodybuilder;
        label.setText("Taken by : " + bodybuilder.toString());
    }

    public void removeUser() {
        user = null;
        label.setText("Free");
    }

}
