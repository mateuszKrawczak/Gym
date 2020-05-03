import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Window extends JFrame {

    JButton buttonTrain = new JButton("Train!");


    JLabel labelReception = new JLabel("Reception");
    JLabel labelDressingRoom = new JLabel("Dressing room");
    JLabel labelChestTraining = new JLabel("Chest training");
    JLabel labelBackTraining = new JLabel("Back training");
    JLabel labelBicepsTraining = new JLabel("Biceps training");
    JLabel labelTricepsTraining = new JLabel("Triceps training");

    JLabel receptionStatus = new JLabel("Free");
    JLabel dressingRoomStatus = new JLabel("Free");
    JLabel chestTrainingStatus = new JLabel("Free");
    JLabel backTrainingStatus = new JLabel("Free");
    JLabel bicepsTrainingStatus = new JLabel("Free");
    JLabel tricepsTrainingStatus = new JLabel("Free");



    ArrayList<Bodybuilder> bodybuilders = new ArrayList<Bodybuilder>();

    public Window() {
        init();
    }

    public static void main(String[] args) throws IOException {
        Window window = new Window();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }





    private void init() {

        setSize(1300,1000);
        setTitle("Gym");
        setLocationRelativeTo(null);
        setLayout(null);

        buttonTrain.setBounds(5, 5, 75, 25);
        buttonTrain.addActionListener((e) -> train());

        labelReception.setBounds(100, 200, 100, 25);
        labelDressingRoom.setBounds(100, 400, 100, 25);
        labelChestTraining.setBounds(1100, 400, 100, 25);
        labelBackTraining.setBounds(500, 400, 100, 25);
        labelBicepsTraining.setBounds(500, 800, 100, 25);
        labelTricepsTraining.setBounds(1100, 800, 100, 25);

        receptionStatus.setBounds(100, 230, 50, 25);
        dressingRoomStatus.setBounds(100, 430, 50, 25);
        chestTrainingStatus.setBounds(1100, 430, 50, 25);
        backTrainingStatus.setBounds(500, 430, 50, 25);
        bicepsTrainingStatus.setBounds(500, 830, 50, 25);
        tricepsTrainingStatus.setBounds(1100, 830, 50, 25);





        add(labelReception);
        add(labelDressingRoom);
        add(labelChestTraining);
        add(labelBackTraining);
        add(labelBicepsTraining);
        add(labelTricepsTraining);

        add(receptionStatus);
        add(dressingRoomStatus);
        add(chestTrainingStatus);
        add(backTrainingStatus);
        add(bicepsTrainingStatus);
        add(tricepsTrainingStatus);

        add(buttonTrain);


    }
    void train(){
        System.out.println("Trenowanko");
        buttonTrain.setEnabled(false);
    }

}