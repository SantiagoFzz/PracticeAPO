package model;

public class Counter {
    private int counter;

    public Counter() {
        counter = 0;
    }

    public synchronized void increment(){
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
