package objetos_spotproven;

import java.util.ArrayList;
import java.util.Scanner;

public class CancionDAO {

    void insertar_cancion(ArrayList<Cancion> SpotProven, Scanner ent) {

        boolean encontrado = false;

        System.out.print("Introduce el titulo de la cancion: ");
        String titulo = ent.nextLine();
        System.out.print("Introduce el interprete: ");
        String interprete = ent.nextLine();

        System.out.print("Introduce el album: ");
        String album = ent.nextLine();
        System.out.print("Introduce la duracion (min): ");
        int minutos = ent.nextInt();

        Cancion anyadir = new Cancion(titulo, interprete, album, minutos);

        SpotProven.add(anyadir);
        System.out.println("\nCancion añadida...");
        System.out.println("Número de canciones en la lista: " + SpotProven.size());
        encontrado = true;

        if (!encontrado) {
            System.out.println("ERROR: La  canción ya existe!");
        }

    }

    void listar_canciones(ArrayList<Cancion> SpotProven, Scanner ent) {

        for (int i = 0; i < SpotProven.size(); i++) {

            System.out.println("Cancion --> "
                    + "\n Título: " + SpotProven.get(i).getTitulo_cancion()
                    + "\n Intérprete: " + SpotProven.get(i).getInterprete()
                    + "\n Album: " + SpotProven.get(i).getAlbum()
                    + "\n Duración: " + SpotProven.get(i).getDuracion() + " minutos");
            System.out.println();
        }
    }

    void eliminar_cancion(ArrayList<Cancion> SpotProven, Scanner ent) {

        boolean encontrado = false;

        System.out.print("Introduce titulo de la cancion a buscar: ");
        String titulo_buscado = ent.nextLine();
        System.out.print("Introduce el interprete de la cancion a buscar: ");
        String interprete_buscado = ent.nextLine();

        for (int i = 0; i < SpotProven.size(); i++) {

            if (SpotProven.get(i).getTitulo_cancion().equalsIgnoreCase(titulo_buscado) && SpotProven.get(i).getInterprete().equalsIgnoreCase(interprete_buscado)) {

                System.out.println("\nCancion borrada --> "
                        + "\n " + SpotProven.get(i).getTitulo_cancion()
                        + " ha sido eliminada con exito!");

                SpotProven.remove(i);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("\nEsta Cancion no Existe!");
        }
    }

    void listar_canciones_porAlbum(ArrayList<Cancion> SpotProven, Scanner ent) {

        boolean encontrado = false;

        System.out.print("Introduce del albumn a buscar: ");
        String album_buscado = ent.nextLine();

        for (int i = 0; i < SpotProven.size(); i++) {

            if (SpotProven.get(i).getAlbum().equalsIgnoreCase(album_buscado)) {

                System.out.println("Cancion --> "
                        + "\n Titulo: " + SpotProven.get(i).getTitulo_cancion()
                        + "\n Interprete: " + SpotProven.get(i).getInterprete()
                        + "\n Album: " + SpotProven.get(i).getAlbum()
                        + "\n Duracion: " + SpotProven.get(i).getDuracion() + " minutos");
                System.out.println();
                encontrado = true;
            }
        }
        if (!encontrado) {
                System.out.println("Este Album no Existe!");
            }
    }

    void generar_listaDinamica(ArrayList<Cancion> SpotProven, Scanner ent) {

        int num = 0;
        ArrayList<Cancion> ListaDinamica = new ArrayList();

        if (SpotProven.size() >= 3) {
            num = 3;
        } else {
            num = SpotProven.size();
        }
        
        System.out.println(SpotProven.size());

        for (int i = 0; i < num; i++) {

            int random = (int) Math.random() * SpotProven.size();
            
            
            ListaDinamica.add(SpotProven.get(random));
        }

        for (int i = 0; i < ListaDinamica.size(); i++) {
            System.out.println("Cancion --> "
                    + "\n Título: " + ListaDinamica.get(i).getTitulo_cancion()
                    + "\n Intérprete: " + ListaDinamica.get(i).getInterprete()
                    + "\n Album: " + ListaDinamica.get(i).getAlbum()
                    + "\n Duración: " + ListaDinamica.get(i).getDuracion() + " minutos");
            System.out.println();
        }
    }
}
