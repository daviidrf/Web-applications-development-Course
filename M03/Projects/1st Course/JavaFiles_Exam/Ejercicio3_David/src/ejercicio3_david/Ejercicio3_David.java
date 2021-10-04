package ejercicio3_david;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3_David {

    public static void main(String[] args) {

        ArrayList<Pertenencia> inventario = new ArrayList<>();

        //Carga el Array del fichero Inventario al Array Inventario, 
        //le pasamos el array y retorna el array actualizado.
        inventario = cargarInventario(inventario);

        int opcion;
        do {
            opcion = menu();
            System.out.println("--------------------------------------");
            switch (opcion) {
                case 1://Añadimos una nueva Pertenencia, le pasamos el array y retorna el array actualizado.
                    inventario = anyadirPertenencia(inventario);
                    System.out.println("\n--------------------------------------");
                    break;
                case 2://Listamos nuestro inventario, le pasamos el array.
                    listarInventario(inventario);
                    System.out.println("\n--------------------------------------");
                    break;
                case 3://Cerramos el programa guardando, le pasamos el array.
                    guardarInventario(inventario);
                    System.out.println("\n--------------------------------------");
                    break;
                case 0://Cerramos el programa sin guardar.
                    System.out.println("\nCerrando sin guardar...");
                    System.out.println("\n--------------------------------------");
                    break;
                default:
                    System.out.print("\nOpcion Incorrecta!");
                    break;

            }
        } while (opcion != 0 && opcion != 3);

    }

    private static int menu() {
        Scanner ent = new Scanner(System.in);
        int menu;

        do {
            System.out.println("\n1-Agregar Pertenencia");
            System.out.println("2-Listar Inventario");
            System.out.println("3-Salir Guardando");
            System.out.println("0-Salir sin guardar");

            System.out.print("\n--------------------------------------");
            System.out.print("\nEscoge opcion: ");
            menu = ent.nextInt();
            ent.nextLine();

        } while (menu < 0 && menu > 3);

        return menu;
    }

    private static ArrayList<Pertenencia> cargarInventario(ArrayList<Pertenencia> inventario) {

        FileInputStream ficheroInventario = null;
        ObjectInputStream Fichero = null;

        File fileInventario = new File("ficheros/inventario.txt");

        if (fileInventario.exists()) {
            try {
                ficheroInventario = new FileInputStream("ficheros/inventario.txt");
                Fichero = new ObjectInputStream(ficheroInventario);

                inventario = (ArrayList<Pertenencia>) Fichero.readObject();
                Fichero.close();

            } catch (IOException ex) {
                System.out.println("Error de lectura!");
            } catch (ClassNotFoundException ex) {
                System.out.println("Clase fichero incorrecta!");
            }
        } else {
            System.out.println("--------------------------------------");
            System.out.println("No tienes inventario,\npara crearlo añade alguna pertenencia y guarda.");
            System.out.println("--------------------------------------");
        }

        return inventario;
    }

    private static ArrayList<Pertenencia> anyadirPertenencia(ArrayList<Pertenencia> inventario) {
        Scanner ent = new Scanner(System.in);

        System.out.print("\nIntroduce nombre para tu pertenencia: ");
        String nombrePert = ent.nextLine();
        System.out.print("Introduce el año de compra de tu pertenencia: ");
        int anyoPert = ent.nextInt();

        Pertenencia nuevaPertenencia = new Pertenencia(nombrePert, anyoPert);

        inventario.add(nuevaPertenencia);
        
        System.out.println("\nPertenencia añadida!");

        return inventario;
    }

    private static void listarInventario(ArrayList<Pertenencia> inventario) {
        
        System.out.println("\nEn tu inventario hay actualmente " + inventario.size() + " pertenencias.");
        
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println(inventario.get(i).toString());
        }
        if (inventario.isEmpty()) {
            System.out.println("\nTu inventario esta vacio!");
        }
    }

    private static void guardarInventario(ArrayList<Pertenencia> inventario) {
        FileOutputStream ficheroInventario = null;
        ObjectOutputStream Fichero = null;

        try {
            ficheroInventario = new FileOutputStream("ficheros/inventario.txt");
            Fichero = new ObjectOutputStream(ficheroInventario);

            Fichero.writeObject(inventario);
            Fichero.close();

        } catch (FileNotFoundException ex) {
            try {
                ficheroInventario = new FileOutputStream("ficheros/inventario.txt");
                Fichero = new ObjectOutputStream(ficheroInventario);

                Fichero.writeObject(inventario);
                Fichero.close();
            } catch (IOException ex1) {
                System.out.println("\nError de escritura!");
            }

        } catch (IOException ex) {
            System.out.println("\nError de escritura!");
        }
        System.out.println("\nInventario guardado, saliendo...");
    }
}