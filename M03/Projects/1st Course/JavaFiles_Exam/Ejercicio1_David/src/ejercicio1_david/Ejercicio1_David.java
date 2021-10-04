package ejercicio1_david;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1_David {

    public static void main(String[] args) {

        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<String> apellidos = new ArrayList<>();

        //Guarda los nombres del fichero nombres en un Array para nombres y lo retorna.
        nombres = agregarLista(nombres);
        //Guarda los apellidos del fichero apellidos en un Array para apellidos y lo retorna.
        apellidos = agregarLista(apellidos);
        
        //Genera los nombres compuestos que le digas y los guarda en un fichero.
        generarNombresApellido(nombres, apellidos);
    }

    private static ArrayList<String> agregarLista(ArrayList<String> lista) {
        File fileApellidos = new File("ficheros/usa_apellidos.txt");
        Scanner lector;
        try {
            lector = new Scanner(fileApellidos);
            while (lector.hasNext()) {
                lista.add(lector.nextLine());
            }
            lector.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no existe!");
        }
        return lista;
    }

    private static void generarNombresApellido(ArrayList<String> nombres, ArrayList<String> apellidos) {
        Scanner ent = new Scanner(System.in);
        
        System.out.print("Cuantos nombres quieres generar: ");
        int numNombres = ent.nextInt();
        
        File nombresGenerados = new File("ficheros/nombres_generados.txt");
        int nom, ape;
        
        try {
            FileWriter crearNombres = new FileWriter(nombresGenerados);
            for (int i = 0; i < numNombres; i++) {
                nom = (int) (Math.random() * nombres.size());
                ape = (int) (Math.random() * apellidos.size());
                
                crearNombres.write(nombres.get(nom) + " " + apellidos.get(ape) + "\n");
                
            }
            crearNombres.close();
            System.out.println("\nNombres generados!");
            
        } catch (IOException ex) {
            System.out.println("\nError de escritura!");
        }
    }
}