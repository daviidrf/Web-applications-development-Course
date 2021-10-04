package pokemon_go;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pokemon_GO {

    public static final String AMARILLO = "\u001B[33m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AZUL = "\u001B[36m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        cargar_Logo();
        Usuario usuario_actual = comprobar_Credenciales();

        Scanner ent = new Scanner(System.in);
        int opcion;

        PokemonDAO utils = new PokemonDAO();

        do {
            opcion = menu(ent);
            System.out.println(AMARILLO + "\n-------------------------------------------------------------------" + RESET);

            switch (opcion) {
                case 1://Cazar Pokemon.
                    utils.cazar_Pokemon(usuario_actual);
                    System.out.println(AMARILLO + "\n-------------------------------------------------------------------" + RESET);
                    break;
                case 2://Listar Mochila de Pokemons Cazados.
                    utils.listarMochila(usuario_actual);
                    System.out.println(AMARILLO + "\n-------------------------------------------------------------------" + RESET);
                    break;
                case 3://Transferir Pokemon a otro usuario.
                    utils.transferir_Pokemon(usuario_actual);
                    System.out.println(AMARILLO + "\n-------------------------------------------------------------------" + RESET);
                    break;
                case 4://Recibir Pokemon de otro usuario.
                    utils.recibir_Pokemon(usuario_actual);
                    System.out.println(AMARILLO + "\n-------------------------------------------------------------------" + RESET);
                    break;
                case 5://Mostrar usuario con Record de captura.
                    utils.mostrarRecord();
                    System.out.println(AMARILLO + "\n-------------------------------------------------------------------" + RESET);
                    break;
                case 6://Evolucionar Pokemon.
                    utils.evolucionar_Pokemon(usuario_actual);
                    System.out.println(AMARILLO + "\n-------------------------------------------------------------------" + RESET);
                    break;
                case 0:
                    System.out.println("Cerrando Pokemon GO...\n");
                    break;
                default:
                    System.out.print(ROJO + "Opcion Incorrecta!" + RESET);
                    System.out.println(AMARILLO + "\n-------------------------------------------------------------------" + RESET);
                    break;
            }
        } while (opcion != 0);
    }

    //FUNCIONES LOCALES
    private static void cargar_Logo() {

        Scanner lector_logo = null;

        try {
            File f = new File("ficheros/logo.pok");
            lector_logo = new Scanner(f);

            while (lector_logo.hasNext()) {
                String logo = lector_logo.nextLine();
                System.out.println(AMARILLO + logo + RESET);
            }
            lector_logo.close(); //Cerrar fichero
            System.out.println(AMARILLO + "\n-------------------------------------------------------------------" + RESET);

        } catch (FileNotFoundException ex) {
            System.out.println("Este fichero no existe!");
        } catch (InputMismatchException ex) {
            System.out.println("Esto no es un String!");
            lector_logo.close(); //Cerrar fichero
        }
    }

    private static Usuario comprobar_Credenciales() {

        Scanner lector_password = null;
        Scanner ent = new Scanner(System.in);

        System.out.print("\nIntroduce el nombre de usuario: ");
        String user = ent.nextLine();
        
        Usuario newUser = new Usuario(user);

        File registro = new File("ficheros/users/user_" + user + ".dat");

        try {
            lector_password = new Scanner(registro);
            String pass;
            
            String password = lector_password.next();
            do {
                System.out.print("Introduce la contraseña: ");
                pass = ent.nextLine();

                if (pass.equals(password)) {
                    System.out.println(VERDE + "\nLogin correcto!" + RESET);
                } else {
                    System.out.println(ROJO + "\nLogin incorrecto!" + RESET);
                    System.out.println();
                }
            } while (!pass.equals(password));
            lector_password.close(); //Cerrar fichero
            System.out.println(AMARILLO + "\n-------------------------------------------------------------------" + RESET);

        } catch (FileNotFoundException ex) {
            try {

                FileWriter escribir_usuario = new FileWriter(registro);

                System.out.print("Introduce la nueva contraseña: ");
                String new_pass = ent.nextLine();

                escribir_usuario.write(new_pass);
                escribir_usuario.close();

                System.out.println("\nUsuario añadido :)");
                System.out.println(AMARILLO + "\n-------------------------------------------------------------------" + RESET);

            } catch (IOException exs) {
                Logger.getLogger(Pokemon_GO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return newUser;
    }

    private static int menu(Scanner ent) {
        int menu;

        do {
            System.out.println("\n1-Cazar Pokemon");
            System.out.println("2-Listar Mochila de Pokemon Cazados");
            System.out.println("3-Transferir Pokemon");
            System.out.println("4-Recibir Pokemon");
            System.out.println("5-Visualizar Record de Captura");
            System.out.println("6-Evolucionar Pokemon");
            System.out.println("0-Salir programa");

            System.out.print("\nEscoge opcion: ");
            menu = ent.nextInt();
            ent.nextLine();

        } while (menu < 0 && menu > 6);

        return menu;
    }

}