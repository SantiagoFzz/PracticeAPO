package model;

public class Semaphore implements Runnable{

    private StateSemaphore stateSemaphore;

    public Semaphore(StateSemaphore stateSemaphore) {
        this.stateSemaphore = stateSemaphore;
    }

    @Override
    public void run() {
        System.out.println("Hola desde Semaphore");
    }
}
