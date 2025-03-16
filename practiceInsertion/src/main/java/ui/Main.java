package ui;
import model.*;
import java.util.Scanner;

public class Main {
    static Scanner scanner;
    static Person[] people;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        System.out.println("Cuantas personas quieres crear?: ");
        int numPersons = scanner.nextInt();
        people = new Person[numPersons];

        for(int i = 0; i < people.length; i++){
            scanner.nextLine();
            System.out.println("Digite la edad de la persona " + (i+1));
            people[i] = new Person(scanner.nextInt());
        }

        System.out.println("El arreglo ordenado es: ");

        //Tenemos dos metodos para ordenar el arreglo.
        orderByAge2();
    }

    public static void orderByAge1(){
        int posicion;
        int ageAux;
        Person peopleAux;
        for(int i = 0; i < people.length; i++){
            posicion = i;
            ageAux = people[i].getAge();
            peopleAux = people[i];

            while((posicion > 0 && people[posicion-1].getAge() > ageAux)){
                people[posicion] = people[posicion-1];
                posicion--;
            }
            people[posicion] = peopleAux;
        }

        for(int i = 0; i < people.length; i++){
            System.out.println(people[i].getAge());
        }
    }

    public static void orderByAge2(){
        Person key;

        for(int i = 1; i < people.length; i++){
            key = people[i];

            while(people[i-1].getAge() > people[i].getAge()){
                people[i] = people[i-1];
                i--;
            }

            people[i] = key;
        }
    }

    public static void printList(){
        for(int i = 0; i < people.length; i++){
            System.out.println(people[i].getAge());
        }
    }
}
