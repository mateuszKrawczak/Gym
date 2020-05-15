import javax.swing.*;

public class Receptionist extends Thread {

    private static int ID = 0;
    private int idNumber;

    private Reception reception;
    private JTextArea output;

    public Receptionist(JTextArea output, Reception reception){
        this.idNumber = ++ID;
        this.reception = reception;
        this.output = output;
    }

    @Override
    public void run(){
        while(true){
            sleep((int)(Math.random() * 1000) + 2000);
            checkReception();
            sleep((int)(Math.random() * 1000) + 1000);
        }
    }

    public synchronized void checkReception(){
        output.append("\n" + this + " has checked reception");
        reception.customerService();
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
        return "Receptionist " + idNumber;
    }

}
