package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class GymController implements EventHandler<ActionEvent> {





        public void signingIn(ActionEvent event){
            System.out.println("Signing in");
    }

    public void changingClothes(ActionEvent event) {
        System.out.println("changingClothes");
    }
    public void backTraining(ActionEvent event){
        System.out.println("backTraining");
    }
    public void chestTraining(ActionEvent event){
        System.out.println("chestTraining");
    }
    public void bicepsTraining(ActionEvent event){
        System.out.println("bicepsTraining");
    }
    public void tricepsTraining(ActionEvent event){
        System.out.println("tricepsTraining");

    }


    @Override
    public void handle(ActionEvent event) {

    }
}
