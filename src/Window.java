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
    JLabel labelChalisthenicsTraining = new JLabel("Chalisthenics training");
    JLabel labelDeadliftTraining = new JLabel("Deadlift training");

    JLabel labelGymHall = new JLabel("Gym hall");
    JLabel labelCrossfitHall = new JLabel("Crossfit hall");

    JTextArea receptionStatus = new JTextArea("Free");
    JTextArea changingRoomStatus = new JTextArea("Free");
    JLabel toiletStatus = new JLabel("Free");
    JLabel chestTrainingStatus = new JLabel("Free");
    JLabel backTrainingStatus = new JLabel("Free");
    JLabel bicepsTrainingStatus = new JLabel("Free");
    JLabel tricepsTrainingStatus = new JLabel("Free");
    JLabel legsTrainingStatus = new JLabel("Free");
    JLabel cardioTrainingStatus = new JLabel("Free");
    JLabel chalisthenicsTrainingStatus = new JLabel("Free");
    JLabel deadliftTrainingStatus = new JLabel("Free");

    JTextArea output = new JTextArea("");
    JScrollPane scroll = new JScrollPane(output);

    Equipment backEquipment = new Equipment("Back Equipment", backTrainingStatus);
    Equipment chestEquipment = new Equipment("Chest Equipment", chestTrainingStatus);
    Equipment bicepsEquipment= new Equipment("Biceps Equipment", bicepsTrainingStatus);
    Equipment tricepsEquipment = new Equipment("Triceps Equipment", tricepsTrainingStatus);
    Equipment legsEquipment = new Equipment("Legs Equipment", legsTrainingStatus);
    Equipment cardioEquipment = new Equipment("Cardio Equipment", cardioTrainingStatus);
    Equipment chalisthenicsEquipment = new Equipment("Chalisthenics Equipment", chalisthenicsTrainingStatus);
    Equipment deadliftEquipment = new Equipment("Deadlift Equipment", deadliftTrainingStatus);

    ChangingRoom changingRoom;
    Reception reception;
    Toilet toilet = new Toilet("Toilet",toiletStatus);
    ArrayList<Receptionist> receptionists = new ArrayList<>();
    ArrayList<Bodybuilder> bodybuilders = new ArrayList<>();
    ArrayList<Equipment> equipmentsArms = new ArrayList<>();
    ArrayList<Equipment> equipmentsBurnFat = new ArrayList<>();
    ArrayList<Equipment> equipmentsTop = new ArrayList<>();
    ArrayList<Equipment> equipmentsLegs = new ArrayList<>();
    ArrayList<Equipment> equipmentsBack = new ArrayList<>();
    ArrayList<Equipment> equipmentsChalisthenics = new ArrayList<>();

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

        setSize(1300,600);
        setTitle("Gym");
        setLocationRelativeTo(null);
        setLayout(null);

        buttonTrain.setBounds(5, 5, 75, 25);
        buttonTrain.addActionListener((e) -> train());
        buttonSwitchRoom.setBounds(5, 40, 150, 25);
        buttonSwitchRoom.addActionListener((e) -> changeRoom());
        labelReception.setBounds(50, 100, 100, 25);
        labelChangingRoom.setBounds(50, 300, 100, 25);
        labelToilet.setBounds(50, 500, 100, 25);
        labelChestTraining.setBounds(100, 100, 100, 25);
        labelBackTraining.setBounds(400, 100, 250, 25);
        labelBicepsTraining.setBounds(100, 400, 100, 25);
        labelTricepsTraining.setBounds(400, 400, 100, 25);
        labelLegsTraining.setBounds(400, 100, 250, 25);
        labelCardioTraining.setBounds(100, 100, 100, 25);
        labelDeadliftTraining.setBounds(100, 400, 100, 25);
        labelChalisthenicsTraining.setBounds(400, 400, 250, 25);

        receptionStatus.setBounds(50, 130, 180, 100);
        changingRoomStatus.setBounds(50, 330, 180, 100);
        toiletStatus.setBounds(50, 530, 250, 25);
        chestTrainingStatus.setBounds(100, 130, 250, 25);
        backTrainingStatus.setBounds(400, 130, 250, 25);
        bicepsTrainingStatus.setBounds(100, 430, 250, 25);
        tricepsTrainingStatus.setBounds(400, 430, 250, 25);
        legsTrainingStatus.setBounds(400, 130, 250, 25);
        cardioTrainingStatus.setBounds(100, 130, 250, 25);
        deadliftTrainingStatus.setBounds(100, 430, 250, 25);
        chalisthenicsTrainingStatus.setBounds(400, 430, 250, 25);

        scroll.setBounds(1000, 0,300, 600);

        hall.add(labelReception);
        hall.add(labelChangingRoom);
        hall.add(labelToilet);

        firstRoom.add(labelChestTraining);
        firstRoom.add(labelBackTraining);
        firstRoom.add(labelBicepsTraining);
        firstRoom.add(labelTricepsTraining);

        labelGymHall.setBounds(350, 10, 250, 25);
        labelCrossfitHall.setBounds(350, 10, 250, 25);
        firstRoom.add(labelGymHall);
        secondRoom.add(labelCrossfitHall);

        secondRoom.add(labelLegsTraining);
        secondRoom.add(labelCardioTraining);
        secondRoom.add(labelDeadliftTraining);
        secondRoom.add(labelChalisthenicsTraining);

        hall.add(receptionStatus);
        hall.add(changingRoomStatus);
        hall.add(toiletStatus);

        firstRoom.add(chestTrainingStatus);
        firstRoom.add(backTrainingStatus);
        firstRoom.add(bicepsTrainingStatus);
        firstRoom.add(tricepsTrainingStatus);

        secondRoom.add(legsTrainingStatus);
        secondRoom.add(cardioTrainingStatus);
        secondRoom.add(deadliftTrainingStatus);
        secondRoom.add(chalisthenicsTrainingStatus);

        add(buttonTrain);
        add(buttonSwitchRoom);
        add(scroll);

        hall.setBounds(0,0,300,600);
        hall.setBackground(new Color(224, 220, 184));
        hall.setLayout(null);

        firstRoom.setBounds(300,0,700,600);
        firstRoom.setBackground(new Color(186, 69, 65));
        firstRoom.setLayout(null);

        secondRoom.setBounds(300,0,700,600);
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
        equipmentsChalisthenics.add(chalisthenicsEquipment);
        equipmentsBack.add(deadliftEquipment);
        equipmentsBack.add(backEquipment);

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

        bodybuilders.add(new Bodybuilder(output, equipmentsTop, changingRoom, TrainingPlan.TOP_TRAINING, reception, toilet));
        bodybuilders.add(new Bodybuilder(output, equipmentsTop, changingRoom, TrainingPlan.TOP_TRAINING, reception, toilet));
        bodybuilders.add(new Bodybuilder(output, equipmentsArms, changingRoom, TrainingPlan.ARMS_TRAINING, reception, toilet));
        bodybuilders.add(new Bodybuilder(output, equipmentsLegs, changingRoom, TrainingPlan.LEGS_TRAINING, reception, toilet));
        bodybuilders.add(new Bodybuilder(output, equipmentsBurnFat, changingRoom, TrainingPlan.CARDIO_TRAINING, reception, toilet));
        bodybuilders.add(new Bodybuilder(output, equipmentsBack, changingRoom, TrainingPlan.DEADLIFT_TRAINING, reception, toilet));
        bodybuilders.add(new Bodybuilder(output, equipmentsChalisthenics, changingRoom, TrainingPlan.CHALISTHENICS_TRAINING, reception, toilet));

        for (int i = 0; i < 6; i++){
            bodybuilders.get(i).start();
        }

    }

}