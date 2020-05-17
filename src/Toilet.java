import javax.swing.*;

public class Toilet {

        public String name;

        private Bodybuilder user;

        private JLabel label;

        public Toilet(String name, JLabel label){
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
            label.setText( bodybuilder.toString() + " is in");
        }

        public void removeUser() {
            user = null;
            label.setText("Free");
        }


}
