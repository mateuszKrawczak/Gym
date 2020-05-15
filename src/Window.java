import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Window extends JFrame {

    JButton buttonTrain = new JButton("Train!");
    JButton buttonSwitchRoom = new JButton("Switch Room");

    JPanel hall =new JPanel();
    JPanel firstRoom =new JPanel();
    JPanel secondRoom =new JPanel();

    JLabel labelReception = new JLabel("Reception");
    JLabel labelChangingRoom = new JLabel("Changing room");
    JLabel labelToilet = new JLabel("Toilet");
    JLabel labelChestTraining = new JLabel("Chest training");
    JLabel labelBackTraining = new JLabel("Back training");
    JLabel labelBicepsTraining = new JLabel("Biceps training");
    JLabel labelTricepsTraining = new JLabel("Triceps training");
    JLabel labelLegsTraining = new JLabel("Legs training");
    JLabel labelCardioTraining = new JLabel("Cardio training");

    JTextArea receptionStatus = new JTextArea("Free");
    JTextArea changingRoomStatus = new JTextArea("Free");
    JLabel toiletStatus = new JLabel("Free");
    JLabel chestTrainingStatus = new JLabel("Free");
    JLabel backTrainingStatus = new JLabel("Free");
    JLabel bicepsTrainingStatus = new JLabel("Free");
    JLabel tricepsTrainingStatus = new JLabel("Free");
    JLabel legsTrainingStatus = new JLabel("Free");
    JLabel cardioTrainingStatus = new JLabel("Free");

    JTextArea output = new JTextArea("Tymczasowo taka konsola");
    JScrollPane scroll = new JScrollPane(output);

    Equipment backEquipment = new Equipment("Back Equipment", backTrainingStatus);
    Equipment chestEquipment = new Equipment("Chest Equipment", chestTrainingStatus);
    Equipment bicepsEquipment= new Equipment("Biceps Equipment", bicepsTrainingStatus);
    Equipment tricepsEquipment = new Equipment("Triceps Equipment", tricepsTrainingStatus);
    Equipment legsEquipment = new Equipment("Legs Equipment", legsTrainingStatus);
    Equipment cardioEquipment = new Equipment("Cardio Equipment", cardioTrainingStatus);

    ChangingRoom changingRoom;
    Reception reception;

    ArrayList<Receptionist> receptionists = new ArrayList<>();
    ArrayList<Bodybuilder> bodybuilders = new ArrayList<>();
    ArrayList<Equipment> equipmentsArms = new ArrayList<>();
    ArrayList<Equipment> equipmentsBurnFat = new ArrayList<>();
    ArrayList<Equipment> equipmentsTop = new ArrayList<>();
    ArrayList<Equipment> equipmentsLegs = new ArrayList<>();

    public Window() {
        init();
        initEquipmentsLists();
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
        buttonSwitchRoom.setBounds(5, 40, 150, 25);
        buttonSwitchRoom.addActionListener((e) -> changeRoom());
        labelReception.setBounds(100, 200, 100, 25);
        labelChangingRoom.setBounds(100, 400, 100, 25);
        labelToilet.setBounds(100, 800, 100, 25);
        labelChestTraining.setBounds(200, 400, 100, 25);
        labelBackTraining.setBounds(500, 400, 100, 25);
        labelBicepsTraining.setBounds(500, 800, 100, 25);
        labelTricepsTraining.setBounds(200, 800, 100, 25);
        labelLegsTraining.setBounds(500, 800, 100, 25);
        labelCardioTraining.setBounds(200, 800, 100, 25);

        receptionStatus.setBounds(100, 230, 175, 150);
        changingRoomStatus.setBounds(100, 430, 175, 100);
        toiletStatus.setBounds(100, 830, 250, 25);
        chestTrainingStatus.setBounds(200, 430, 250, 25);
        backTrainingStatus.setBounds(500, 430, 250, 25);
        bicepsTrainingStatus.setBounds(500, 830, 250, 25);
        tricepsTrainingStatus.setBounds(200, 830, 250, 25);
        legsTrainingStatus.setBounds(500, 830, 250, 25);
        cardioTrainingStatus.setBounds(200, 830, 250, 25);

        scroll.setBounds(1300, 25,250, 900);

        hall.add(labelReception);
        hall.add(labelChangingRoom);
        hall.add(labelToilet);

        firstRoom.add(labelChestTraining);
        firstRoom.add(labelBackTraining);
        firstRoom.add(labelBicepsTraining);
        firstRoom.add(labelTricepsTraining);

        secondRoom.add(labelLegsTraining);
        secondRoom.add(labelCardioTraining);

        hall.add(receptionStatus);
        hall.add(changingRoomStatus);
        hall.add(toiletStatus);

        firstRoom.add(chestTrainingStatus);
        firstRoom.add(backTrainingStatus);
        firstRoom.add(bicepsTrainingStatus);
        firstRoom.add(tricepsTrainingStatus);

        secondRoom.add(legsTrainingStatus);
        secondRoom.add(cardioTrainingStatus);


        add(buttonTrain);
        add(buttonSwitchRoom);
        add(scroll);

        hall.setBounds(0,0,300,1000);
        hall.setBackground(new Color(224, 220, 184));
        hall.setLayout(null);

        firstRoom.setBounds(300,0,1000,1000);
        firstRoom.setBackground(new Color(186, 69, 65));
        firstRoom.setLayout(null);

        secondRoom.setBounds(300,0,1000,1000);
        secondRoom.setBackground(new Color(168, 123, 0));
        secondRoom.setLayout(null);

        add(hall);
        add(firstRoom);

        secondRoom.setVisible(false);
        add(secondRoom);
    }
    void initEquipmentsLists(){
        equipmentsTop.add(chestEquipment);
        equipmentsTop.add(backEquipment);
        equipmentsArms.add(bicepsEquipment);
        equipmentsArms.add(tricepsEquipment);
        equipmentsBurnFat.add(cardioEquipment);
        equipmentsLegs.add(legsEquipment);
    }
    void changeRoom(){
        if(secondRoom.isVisible()){
            firstRoom.setVisible(true);
            secondRoom.setVisible(false);
        }else{
            secondRoom.setVisible(true);
            firstRoom.setVisible(false);
        }

    }

    void train(){

        changingRoom = new ChangingRoom(3, changingRoomStatus);
        reception = new Reception(receptionStatus);

        buttonTrain.setEnabled(false);

        for(int i=0;i<2;i++){
            receptionists.add(new Receptionist(output, reception));
        }

        for (int i = 0; i < 2; i++){
            receptionists.get(i).start();
        }

        bodybuilders.add(new Bodybuilder(output, equipmentsTop, changingRoom, TrainingPlan.TOP_TRAINING, reception));
        //bodybuilders.add(new Bodybuilder(output, equipmentsTop, changingRoom, TrainingPlan.TOP_TRAINING, reception));
        bodybuilders.add(new Bodybuilder(output, equipmentsArms, changingRoom, TrainingPlan.ARMS_TRAINING, reception));
        bodybuilders.add(new Bodybuilder(output, equipmentsLegs, changingRoom, TrainingPlan.LEGS_TRAINING, reception));
        bodybuilders.add(new Bodybuilder(output, equipmentsBurnFat, changingRoom, TrainingPlan.CARDIO_TRAINING, reception));

        for (int i = 0; i < 4; i++){
            bodybuilders.get(i).start();
        }

    }

}