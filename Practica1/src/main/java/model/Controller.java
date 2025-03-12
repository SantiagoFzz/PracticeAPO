package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    private ArrayList<Person> people;
    public Controller(){
        people = new ArrayList<>();
    }

    public String addPeople(String name, int age){

        return "";
    }

    public String writeInFile(String message) {
        String messageReturn = "No se pudo crear el archivo";
        try (FileWriter fw = new FileWriter("C:\\Users\\prestamo\\Documents\\PracticeApo\\PracticeAPO\\src\\main\\files\\archivo2.txt")) {
            fw.write(message);
            messageReturn = "Archivo creado correctamente";

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return messageReturn;
    }

        //Contar consonantes
    //Contar vocales
    //Contar numeros
    public String countCharacters(){
        int c;

        int contadorConsonantes = 0;
        int contadorVocales = 0;
        int contadorNumeros = 0;

        int[] vocales = {65, 69, 73, 79, 85, 97, 101, 105, 111, 117};

        try(FileReader fr = new FileReader("C:\\Users\\prestamo\\Documents\\PracticeApo\\PracticeAPO\\src\\main\\files\\archivo2.txt")) {

            while((c = fr.read()) != -1){
                if(c >= 48 && c<=57){
                    contadorNumeros++;
                }else{
                    boolean flag = false;
                    for( int j = 0; j < vocales.length; j++){
                        if(c == vocales[j]){
                            contadorVocales++;
                            flag = true;
                        }
                    }
                    if(!flag){
                        if((c >= 65 && c <= 90) || (c >= 97 && c <= 122)){
                            contadorConsonantes++;
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String textConsonantes;
        String textVocales;
        String textNumeros;

        if(contadorConsonantes == 0){
            textConsonantes = "No hay consonantes";
        }else{
            textConsonantes = "Consonantes: " + contadorConsonantes;
        }

        if(contadorVocales == 0){
            textVocales = "No hay vocales";
        }else{
            textVocales = "Vocales: " + contadorVocales;
        }

        if(contadorNumeros == 0){
            textNumeros = "No hay numeros.";
        }else{
            textNumeros = "Numeros: " + contadorNumeros;
        }

        return textConsonantes + "\n" + textNumeros + "\n" + textVocales;
    }
}
