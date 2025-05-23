package ui;

import util.CustomRunnable;
import util.CustomThread;
import util.IFuntional;

// El Main es el hilo principal del lenguaje.
public class Main {

    public static void main(String[] args) {
        CustomThread ct = new CustomThread(1000);
        ct.start();

        for (int i = 10; i < 20; i++) {
            System.out.println("Desde el Main: " + i);
        }

        CustomRunnable c1 = new CustomRunnable(500);

        Thread t1 = new Thread(c1);
        t1.start();

        IFuntional f1 = () -> {
            System.out.println("Hola desde la interfaz estil despues de java 8");
        };

        f1.unique();

    }
}
