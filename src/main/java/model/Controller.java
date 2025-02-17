package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {

    public Controller(){

    }

    public String writeInFile(String message) {
        String messageReturn = "No se pudo crear el archivo";
        try (FileWriter fw = new FileWriter("C:\\Users\\Isabella\\Documents\\SantiagoApo\\APO 2\\Practicas\\practicaJava\\src\\main\\files\\archivo2.txt")) {
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

        try(FileReader fr = new FileReader("C:\\Users\\Isabella\\Documents\\SantiagoApo\\APO 2\\Practicas\\practicaJava\\src\\main\\files\\archivo2.txt")) {

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

        return "Consonantes: " + contadorConsonantes + "\nVocales: " + contadorVocales + "\nNumeros: " + contadorNumeros;
    }
}
