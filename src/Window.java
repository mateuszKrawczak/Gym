import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Window extends JFrame {

    JButton buttonTrain = new JButton("Train!");

    JLabel labelReception = new JLabel("Reception");
    JLabel labelDressingRoom = new JLabel("Dressing room");
    JLabel labelToilet = new JLabel("Toilet");
    JLabel labelChestTraining = new JLabel("Chest training");
    JLabel labelBackTraining = new JLabel("Back training");
    JLabel labelBicepsTraining = new JLabel("Biceps training");
    JLabel labelTricepsTraining = new JLabel("Triceps training");

    JLabel receptionStatus = new JLabel("Free");
    JLabel dressingRoomStatus = new JLabel("Free");
    JLabel toiletStatus = new JLabel("Free");
    JLabel chestTrainingStatus = new JLabel("Free");
    JLabel backTrainingStatus = new JLabel("Free");
    JLabel bicepsTrainingStatus = new JLabel("Free");
    JLabel tricepsTrainingStatus = new JLabel("Free");

    JTextArea output = new JTextArea("Tymczasowo taka konsola");
    JScrollPane scroll = new JScrollPane(output);

    Equipment backEquipment = new Equipment("Back Equipment", backTrainingStatus);
    Equipment chestEquipment = new Equipment("Chest Equipment", chestTrainingStatus);

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

        setSize(1600,1000);
        setTitle("Gym");
        setLocationRelativeTo(null);
        setLayout(null);

        buttonTrain.setBounds(5, 5, 75, 25);
        buttonTrain.addActionListener((e) -> train());

        labelReception.setBounds(100, 200, 100, 25);
        labelDressingRoom.setBounds(100, 400, 100, 25);
        labelToilet.setBounds(100, 800, 100, 25);
        labelChestTraining.setBounds(1100, 400, 100, 25);
        labelBackTraining.setBounds(500, 400, 100, 25);
        labelBicepsTraining.setBounds(500, 800, 100, 25);
        labelTricepsTraining.setBounds(1100, 800, 100, 25);

        receptionStatus.setBounds(100, 230, 250, 25);
        dressingRoomStatus.setBounds(100, 430, 250, 25);
        toiletStatus.setBounds(100, 830, 250, 25);
        chestTrainingStatus.setBounds(1100, 430, 250, 25);
        backTrainingStatus.setBounds(500, 430, 250, 25);
        bicepsTrainingStatus.setBounds(500, 830, 250, 25);
        tricepsTrainingStatus.setBounds(1100, 830, 250, 25);

        scroll.setBounds(1300, 25,250, 900);

        add(labelReception);
        add(labelDressingRoom);
        add(labelToilet);
        add(labelChestTraining);
        add(labelBackTraining);
        add(labelBicepsTraining);
        add(labelTricepsTraining);

        add(receptionStatus);
        add(dressingRoomStatus);
        add(toiletStatus);
        add(chestTrainingStatus);
        add(backTrainingStatus);
        add(bicepsTrainingStatus);
        add(tricepsTrainingStatus);

        add(buttonTrain);
        add(scroll);

    }
    void train(){

        buttonTrain.setEnabled(false);

        for (int i = 0; i < 3; i++){
            bodybuilders.add(new Bodybuilder(output, backEquipment, chestEquipment));
        }

        for (int i = 0; i < 3; i++){
            bodybuilders.get(i).start();
        }

    }

}