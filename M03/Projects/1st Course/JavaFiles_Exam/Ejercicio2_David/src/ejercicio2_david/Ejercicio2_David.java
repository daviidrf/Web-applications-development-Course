package ejercicio2_david;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2_David {

    public static void main(String[] args) {

        ArrayList<String> contenidoFichero = new ArrayList<>();

        //Saca las lineas del fichero que escojas y las guarda en el Array.
        contenidoFichero = validarFichero(contenidoFichero);
        //Guarda el Array con las lineas del fichero de origen en un fichero de salida.
        ficheroSalida(contenidoFichero);

    }

    private static ArrayList<String> validarFichero(ArrayList<String> contenidoFichero) {
        Scanner ent = new Scanner(System.in);

        System.out.print("Introduce el nombre del fichero que copiar: ");
        String ficheroBuscado = ent.nextLine();

        File FicheroElegido;
        Scanner lector;
        String linea;

        try {
            FicheroElegido = new File("ficheros/" + ficheroBuscado + ".txt");
            lector = new Scanner(FicheroElegido);

            while (lector.hasNext()) {
                linea = lector.nextLine();

                if (!linea.equalsIgnoreCase("LINEAERRONEA")) {
                    contenidoFichero.add(linea);
                }
            }
            lector.close();
        } catch (FileNotFoundException ex) {
            contenidoFichero.add("El fichero " + ficheroBuscado + " no existe! \n");
        }

        return contenidoFichero;
    }

    private static void ficheroSalida(ArrayList<String> contenidoFichero) {
        try {
            File ficheroSalida = new File("ficheros/sortida.txt");
            FileWriter escribirSalida = new FileWriter(ficheroSalida, true);

            for (int i = 0; i < contenidoFichero.size(); i++) {
                escribirSalida.write(contenidoFichero.get(i) + "\n");
            }
            escribirSalida.close();
            System.out.println("\nFichero copiado");

        } catch (IOException ex) {
            System.out.println("\nError de escritura!");
        }

    }
}