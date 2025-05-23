package ui;

import model.Counter;

public class Main {

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 100; i++){
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < 100; i++){
                counter.increment();
            }
        });

        Thread thread3 = new Thread(() -> {
            for(int i = 0; i < 100; i++){
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();


        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Contador: " + counter.getCounter());
    }



}
