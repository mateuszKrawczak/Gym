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

    ArrayList<Equipment> training = new ArrayList<Equipment>();

    private Equipment backEquipment;
    private Equipment chestEquipment;
    private Equipment bicepsEquipment;
    private Equipment tricepsEquipment;
    private Equipment legsEquipment ;
    private Equipment cardioEquipment;
    JTextArea output;

    private TrainingPlan trainingMode;

    Bodybuilder(JTextArea output, Equipment backEquipment, Equipment chestEquipment){
        this.idNumber = ++ID;
        this.output = output;

        this.backEquipment = backEquipment;
        this.chestEquipment = chestEquipment;
    }
    Bodybuilder(){
        this.idNumber = ++ID;
    }
    Bodybuilder(JTextArea output, ArrayList<Equipment> training,TrainingPlan trainingMode){
        this.idNumber = ++ID;
        this.output = output;

        this.trainingMode = trainingMode;
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
            }
        }

    }

   /* @Override
    public void run(){
        while(running){
            sleep((int)(Math.random() * 1000) + 2000);
            entry();
            sleep((int)(Math.random() * 1000) + 2000);
            collectLockerKey();
            sleep((int)(Math.random() * 1000) + 2000);
            changeClothes();
            while(isWorkoutFinished() == false){

                sleep((int)(Math.random() * 1000) + 1000);
                if(backEquipment.isAvailable()){
                    backTraining();
                }

                sleep((int)(Math.random() * 1000) + 1000);
                if(chestEquipment.isAvailable()){
                    chestTraining();
                }

                sleep((int)(Math.random() * 1000) + 1000);
                if(tricepsEquipment.isAvailable()){
                    tricepsTraining();
                }


                sleep((int)(Math.random() * 1000) + 1000);
                if(bicepsEquipment.isAvailable()){
                    bicepsTraining();
                }


            }
            sleep((int)(Math.random() * 1000) + 2000);
            toilet();
            sleep((int)(Math.random() * 1000) + 2000);
            changeClothes();
            sleep((int)(Math.random() * 1000) + 2000);
            returnLockerKey();
            sleep((int)(Math.random() * 1000) + 2000);
            exit();
        }
    }*/
   @Override
   public void run(){
       while(running){
           sleep((int)(Math.random() * 1000) + 2000);
           entry();
           sleep((int)(Math.random() * 1000) + 2000);
           collectLockerKey();
           sleep((int)(Math.random() * 1000) + 2000);
           changeClothes();
           while(isWorkoutFinished() == false){
               switch(trainingMode) {
                   case ARMS_TRAINING:
                       sleep((int) (Math.random() * 1000) + 1000);
                       if (tricepsEquipment.isAvailable()) {
                           tricepsTraining();
                       }
                       sleep((int) (Math.random() * 1000) + 1000);
                       if (bicepsEquipment.isAvailable()) {
                           bicepsTraining();
                       }
                       break;
                   case TOP_TRAINING:
                       sleep((int) (Math.random() * 1000) + 1000);
                       if (backEquipment.isAvailable()) {
                           backTraining();
                       }

                       sleep((int) (Math.random() * 1000) + 1000);
                       if (chestEquipment.isAvailable()) {
                           chestTraining();
                       }
                       break;



               }

           }
           sleep((int)(Math.random() * 1000) + 2000);
           toilet();
           sleep((int)(Math.random() * 1000) + 2000);
           changeClothes();
           sleep((int)(Math.random() * 1000) + 2000);
           returnLockerKey();
           sleep((int)(Math.random() * 1000) + 2000);
           exit();
       }
   }
    public synchronized void entry() {
        output.append("\nClient " + idNumber + " entered the gym");
    }

    public synchronized void collectLockerKey(){
        output.append("\nClient " + idNumber + " has collected key to the locker");
    }

    public synchronized void returnLockerKey(){
        output.append("\nClient " + idNumber + " has returned key to the locker");
    }

    public synchronized void changeClothes() {
        output.append("\nClient " + idNumber + " is changing clothes");
    }

    public synchronized void bicepsTraining(){
        output.append("\nClient " + idNumber + " has started biceps training");
        bicepsEquipment.setUser(this);
        sleep(3000);
        bicepsFinished = true;
        bicepsEquipment.removeUser();
        output.append("\nClient " + idNumber + " has finished biceps training");
    }

    public synchronized void tricepsTraining(){
        output.append("\nClient " + idNumber + " has started triceps training");
        tricepsEquipment.setUser(this);
        sleep(3000);
        tricepsFinished = true;
        tricepsEquipment.removeUser();
        output.append("\nClient " + idNumber + " has finished triceps training");
    }

    public synchronized void chestTraining(){
        output.append("\nClient " + idNumber + " has started chest training");
        chestEquipment.setUser(this);
        sleep(3000);
        chestFinished = true;
        chestEquipment.removeUser();
        output.append("\nClient " + idNumber + " has finished chest training");
    }

    public synchronized void backTraining(){
        output.append("\nClient " + idNumber + " has started back training");
        backEquipment.setUser(this);
        sleep(3000);
        backFinished = true;
        backEquipment.removeUser();
        output.append("\nClient " + idNumber + " has finished back training");
    }

    public synchronized void toilet() {
        output.append("\nClient " + idNumber + " is using toilet");
    }

    public synchronized void exit() {
        output.append("\nClient " + idNumber + " has leaved the gym");
        running = false;
    }

    public boolean isWorkoutFinished(){
        if(!backFinished) return false;
        if(!bicepsFinished) return false;
        if(!tricepsFinished) return false;
        if(!chestFinished) return false;
        return true;
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
