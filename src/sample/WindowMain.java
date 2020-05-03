package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class WindowMain extends Application {

    Button signInButton;
    Button changingClothesButton;
    Button trainChestButton;
    Button trainTricepsButton;
    Button trainBicepsButton;
    Button trainBackButton;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("gymHall.fxml"));
        primaryStage.setTitle("Gym");

        primaryStage.setScene(new Scene(root, 1200, 900));



        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
