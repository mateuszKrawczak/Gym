import javax.swing.*;
import java.util.ArrayList;

public class Bodybuilder extends Thread{

    private static int ID = 0;

    private int idNumber;

    private boolean running = true;

    private boolean backFinished = false;
    private boolean chestFinished = false;
    private boolean tricepsFinished = false;
    private boolean bicepsFinished = false;
    private boolean legsFinished = false;
    private boolean cardioFinished = false;
    private boolean deadliftFinished = false;
    private boolean chalisthenicsFinished = false;
    private boolean clothesChanged = false;
    private boolean keyOwnership = false;

    ArrayList<Equipment> training = new ArrayList<Equipment>();

    private Equipment backEquipment;
    private Equipment chestEquipment;
    private Equipment bicepsEquipment;
    private Equipment tricepsEquipment;
    private Equipment legsEquipment ;
    private Equipment cardioEquipment;
    private Equipment deadliftEquipment ;
    private Equipment chalisthenicsEquipment;

    JTextArea output;

    private TrainingPlan trainingMode;
    private ChangingRoom changingRoom;
    private Reception reception;
    private Toilet toilet;

    Bodybuilder(JTextArea output, ArrayList<Equipment> training, ChangingRoom changingRoom,
            TrainingPlan trainingMode, Reception reception, Toilet toilet)
    {
        this.idNumber = ++ID;
        this.output = output;
        this.changingRoom = changingRoom;
        this.trainingMode = trainingMode;
        this.reception = reception;
        this.toilet = toilet;
        for(int i=0;i<training.size();i++){
            Equipment equipment = training.get(i);
            System.out.println(equipment.name.toString());
            switch(equipment.name.toString()){
                case "Back Equipment":
                    this.backEquipment = equipment;
                    break;
                case "Chest Equipment":
                    this.chestEquipment = equipment;
                    break;
                case "Triceps Equipment":
                    this.tricepsEquipment = equipment;
                    break;
                case "Biceps Equipment":
                    this.bicepsEquipment = equipment;
                    break;
                case "Legs Equipment":
                    this.legsEquipment = equipment;
                    break;
                case "Cardio Equipment":
                    this.cardioEquipment = equipment;
                    break;
                case "Deadlift Equipment":
                    this.deadliftEquipment = equipment;
                    break;
                case "Chalisthenics Equipment":
                    this.chalisthenicsEquipment = equipment;
                    break;
            }
        }
    }

   @Override
   public void run(){
       while(running){
           sleep((int)(Math.random() * 2000) + 3000);
           entry();
           sleep((int)(Math.random() * 1000) + 3000);
           while(keyOwnership == false){
               sleep((int)(Math.random() * 1000) + 3000);
           }
           sleep((int)(Math.random() * 1000) + 3000);
           while(clothesChanged == false){
               if(changingRoom.isAvailable()){
                   changeClothes(true);
               }
               sleep((int) (Math.random() * 1000) + 2000);
           }
           sleep((int)(Math.random() * 1000) + 3000);
           while(isWorkoutFinished() == false){
               switch(trainingMode) {
                   case ARMS_TRAINING:
                       sleep((int) (Math.random() * 1000) + 2000);
                       if (tricepsEquipment.isAvailable()) {
                           tricepsTraining();
                       }
                       sleep((int) (Math.random() * 1000) + 2000);
                       if (bicepsEquipment.isAvailable()) {
                           bicepsTraining();
                       }
                       break;
                   case TOP_TRAINING:
                       sleep((int) (Math.random() * 1000) + 2000);
                       if (backEquipment.isAvailable()) {
                           backTraining();
                       }
                       sleep((int) (Math.random() * 1000) + 2000);
                       if (chestEquipment.isAvailable()) {
                           chestTraining();
                       }
                       break;
                   case CARDIO_TRAINING:
                       sleep((int) (Math.random() * 1000) + 2000);
                       if (cardioEquipment.isAvailable()) {
                           cardioTraining();
                       }
                       break;
                   case LEGS_TRAINING:
                       sleep((int) (Math.random() * 1000) + 2000);
                       if (legsEquipment.isAvailable()) {
                           legsTraining();
                       }
                       break;
                   case DEADLIFT_TRAINING:
                       sleep((int) (Math.random() * 1000) + 2000);
                       if (deadliftEquipment.isAvailable()) {
                           deadliftTraining();
                       }
                       break;
                   case CHALISTHENICS_TRAINING:
                       sleep((int) (Math.random() * 1000) + 2000);
                       if (chalisthenicsEquipment.isAvailable()) {
                           chalisthenicsTraining();
                       }
                       break;
               }
           }
           sleep((int)(Math.random() * 1000) + 3000);
           if (toilet.isAvailable()) {
               toilet();
           }
           sleep((int)(Math.random() * 1000) + 3000);
           while(clothesChanged == true){
               if(changingRoom.isAvailable()){
                   changeClothes(false);
               }
               sleep((int) (Math.random() * 1000) + 2000);
           }
           sleep((int)(Math.random() * 1000) + 3000);
           entry();
           sleep((int)(Math.random() * 1000) + 3000);
           while(keyOwnership == true){
               sleep((int)(Math.random() * 1000) + 3000);
           }
           sleep((int)(Math.random() * 1000) + 3000);
           exit();
           sleep(5000);
       }
   }

    public synchronized void entry() {
        reception.comeToReception(this);
        output.append("\nClient " + idNumber + " has approached reception");
    }

    public synchronized void collectLockerKey(){
        sleep((int)(Math.random() * 500) + 1000);
        output.append("\nClient " + idNumber + " has collected key to the locker");
    }

    public synchronized void returnLockerKey(){
        sleep((int)(Math.random() * 500) + 1000);
        output.append("\nClient " + idNumber + " has returned key to the locker");
    }

    public synchronized void changeClothes(boolean status) {
       changingRoom.useChangingRoom(this);
       output.append("\nClient " + idNumber + " has entered changing room");
        sleep((int)(Math.random() * 500) + 4000);
       clothesChanged = status;
       changingRoom.exitChangingRoom(this);
       output.append("\nClient " + idNumber + " has left changing room");
    }

    public synchronized void bicepsTraining(){
        output.append("\nClient " + idNumber + " has started biceps training");
        bicepsEquipment.setUser(this);
        sleep((int)(Math.random() * 500) + 5000);
        bicepsFinished = true;
        bicepsEquipment.removeUser();
        output.append("\nClient " + idNumber + " has finished biceps training");
    }

    public synchronized void tricepsTraining(){
        output.append("\nClient " + idNumber + " has started triceps training");
        tricepsEquipment.setUser(this);
        sleep((int)(Math.random() * 500) + 5000);
        tricepsFinished = true;
        tricepsEquipment.removeUser();
        output.append("\nClient " + idNumber + " has finished triceps training");
    }

    public synchronized void chestTraining(){
        output.append("\nClient " + idNumber + " has started chest training");
        chestEquipment.setUser(this);
        sleep((int)(Math.random() * 500) + 5000);
        chestFinished = true;
        chestEquipment.removeUser();
        output.append("\nClient " + idNumber + " has finished chest training");
    }

    public synchronized void backTraining(){
        output.append("\nClient " + idNumber + " has started back training");
        backEquipment.setUser(this);
        sleep((int)(Math.random() * 500) + 5000);
        backFinished = true;
        backEquipment.removeUser();
        output.append("\nClient " + idNumber + " has finished back training");
    }
    public synchronized void cardioTraining(){
        output.append("\nClient " + idNumber + " has started cardio training");
        cardioEquipment.setUser(this);
        sleep((int)(Math.random() * 500) + 5000);
        cardioFinished = true;
        cardioEquipment.removeUser();
        output.append("\nClient " + idNumber + " has finished cardio training");
    }
    public synchronized void legsTraining(){
        output.append("\nClient " + idNumber + " has started legs training");
        legsEquipment.setUser(this);
        sleep((int)(Math.random() * 500) + 5000);
        legsFinished = true;
        legsEquipment.removeUser();
        output.append("\nClient " + idNumber + " has finished legs training");
    }
    public synchronized void deadliftTraining(){
        output.append("\nClient " + idNumber + " has started deadlift training");
        deadliftEquipment.setUser(this);
        sleep((int)(Math.random() * 500) + 5000);
        deadliftFinished = true;
        deadliftEquipment.removeUser();
        output.append("\nClient " + idNumber + " has finished deadlift training");
    }
    public synchronized void chalisthenicsTraining(){
        output.append("\nClient " + idNumber + " has started chalisthenics training");
        chalisthenicsEquipment.setUser(this);
        sleep((int)(Math.random() * 500) + 5000);
        chalisthenicsFinished = true;
        chalisthenicsEquipment.removeUser();
        output.append("\nClient " + idNumber + " has finished chalisthenics training");
    }
    public synchronized void toilet() {
        output.append("\nClient " + idNumber + " is using toilet");
        toilet.setUser(this);
        sleep((int)(Math.random() * 500) + 3000);
        toilet.removeUser();
        output.append("\nClient " + idNumber + " has left toilet");
    }

    public synchronized void exit() {
        output.append("\nClient " + idNumber + " has leaved the gym");
        resetFinished();
    }

    public void setKeyOwnership(){
       this.keyOwnership = !this.keyOwnership;
    }

    public boolean getKeyOwnership(){
       return this.keyOwnership;
    }

    public boolean isWorkoutFinished(){
        switch(trainingMode){
            case TOP_TRAINING:
                if(!chestFinished) return false;
                if(!backFinished) return false;
                return true;
            case ARMS_TRAINING:
                if(!bicepsFinished) return false;
                if(!tricepsFinished) return false;
                return true;
            case LEGS_TRAINING:
                if(!legsFinished) return false;
                return true;
            case CARDIO_TRAINING:
                if(!cardioFinished) return false;
                return true;
            case DEADLIFT_TRAINING:
                if(!deadliftFinished) return false;
                return true;
            case CHALISTHENICS_TRAINING:
                if(!chalisthenicsFinished) return false;
                return true;
            default:
                return false;
        }
    }

    public void resetFinished(){
        backFinished = false;
        chestFinished = false;
        tricepsFinished = false;
        bicepsFinished = false;
        legsFinished = false;
        cardioFinished = false;
        deadliftFinished = false;
        chalisthenicsFinished = false;
        clothesChanged = false;
        keyOwnership = false;
    }

    public void sleep(int timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return "Bodybuilder " + idNumber;
    }

}
