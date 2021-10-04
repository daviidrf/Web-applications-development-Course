package objetos_spotproven;

import java.util.ArrayList;
import java.util.Scanner;

public class Objetos_SpotProven {

    public static void main(String[] args) {
        
        Scanner ent = new Scanner(System.in);
        int opcion;
        
        ArrayList<Cancion> SpotProven = new ArrayList();
        CancionDAO utilidades = new CancionDAO();

        do {
            opcion = menu(ent);
            System.out.println("----------------------------------------");
            
            switch (opcion) {
                case 1://Añadir Cancion que no este repetida.
                    utilidades.insertar_cancion(SpotProven, ent);
                    System.out.println("----------------------------------------");
                    break;
                case 2://Eliminar cancion indicada.
                    utilidades.eliminar_cancion(SpotProven, ent);
                    System.out.println("----------------------------------------");
                    break;
                case 3://Listar todas las canciones.
                    utilidades.listar_canciones(SpotProven, ent);
                    System.out.println("----------------------------------------");
                    break;
                case 4://Listar todas las Personas del ArrayList.
                    utilidades.generar_listaDinamica(SpotProven, ent);
                    System.out.println("----------------------------------------");
                    break;
                case 5://Listar canciones del album indicado.
                    utilidades.listar_canciones_porAlbum(SpotProven, ent);
                    System.out.println("----------------------------------------");
                    break;
                case 0:
                    System.out.println("Cerrando SpotProven...\n");;
                    break;
                default:
                    System.out.println("Opcion Incorrecta!");
                    break;
            }
        } while (opcion != 0);
    }

    private static int menu(Scanner ent) {
        int menu;

        do {
            System.out.println("1-Insertar cancion");
            System.out.println("2-Borrar cancion");
            System.out.println("3-Listar canciones");
            System.out.println("4-Generar lista de canciones dinámica");
            System.out.println("5-Listar canciones de un album");
            System.out.println("0-Salir programa");

            System.out.print("\nEscoge opcion: ");
            menu = ent.nextInt();
            ent.nextLine();

        } while (menu < 0 && menu > 5);

        return menu;
    }
    
}
