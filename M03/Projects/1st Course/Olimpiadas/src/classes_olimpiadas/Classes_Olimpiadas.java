package classes_olimpiadas;

import java.util.Scanner;

public class Classes_Olimpiadas {

    public static void main(String[] args) {

        int deport_inf = 0, opcion;

        Esport[] todos_los_deportes = new Esport[4];

        System.out.println("-----------------------------");
        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    deport_inf = afegir_esport_atletes(todos_los_deportes, deport_inf);
                    break;
                case 2:
                    listar_todos_deportes(todos_los_deportes, deport_inf);
                    break;
                case 3:
                    mejor_deportista(todos_los_deportes, deport_inf);
                    break;
                case 4:
                    mejor_deportista_deporte(todos_los_deportes, deport_inf);
                    break;
                case 5:
                    ordenar_podium(todos_los_deportes, deport_inf);
                    mostrar_podium(todos_los_deportes, deport_inf);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...\n");
                    break;
            }
        } while (opcion != 0);
    }

    //Esta funcion muestra el menú.
    private static int menu() {
        Scanner ent = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1 - Introducir datos\n"
                    + "2 - Listar todos\n"
                    + "3 - Atleta con mas medallas(General)\n"
                    + "4 - Atleta con mas medallas(Deporte)\n"
                    + "5 - Mostrar podium(Deporte)\n"
                    + "0 - Sortir\n"
                    + "-----------------------------");
            System.out.print("Escoge una opcion: ");
            opcion = ent.nextInt();
            System.out.println("-----------------------------");
        } while (opcion < 0 || opcion > 5);

        return opcion;
    }

    //Esta funcion añade atletas y deporte y mira si el deporte esta creado.
    private static int afegir_esport_atletes(Esport[] todos_los_deportes, int deport_inf) {
        Scanner ent = new Scanner(System.in);
        String seguir;
        int diferencia = 0;

        System.out.print("Que deporte quieres: ");
        TipoDeporte afegir = TipoDeporte.valueOf(ent.nextLine().toUpperCase());

        //Esta funcion comprueba si el deporte existe.
        int indice = comprovar_si_existe(todos_los_deportes, deport_inf, afegir);

        if (indice == -1 && (deport_inf < todos_los_deportes.length)) {
            //Esta funcion inicializa las posiciones de los arrays del deporte en caso de que no exista.
            inicializar_posicion(todos_los_deportes, deport_inf, afegir);
            deport_inf++;
            indice = comprovar_si_existe(todos_los_deportes, deport_inf, afegir);
        }

        //Introduzco los datos del deporte.
        diferencia = todos_los_deportes[indice].cont_participantes;
        do {
            todos_los_deportes[indice].participantes[todos_los_deportes[indice].cont_participantes] = introducir_atleta(ent);
            todos_los_deportes[indice].medallas[todos_los_deportes[indice].cont_participantes] = (int) (Math.random() * 10);
            todos_los_deportes[indice].cont_participantes++;

            System.out.println("-----------------------------");
            System.out.print("Añadir otro atleta?(SI/NO) ");
            seguir = ent.nextLine();
            System.out.println("-----------------------------");

        } while (seguir.equalsIgnoreCase("SI") && (todos_los_deportes[indice].cont_participantes < todos_los_deportes[indice].participantes.length));
        diferencia = todos_los_deportes[indice].cont_participantes - diferencia;
        System.out.println("Has añadido " + diferencia + " atletas.");
        System.out.println("-----------------------------");

        return deport_inf;
    }

    //Esta funcion inicializa las posiciones de los arrays del deporte en caso de que no exista.
    private static void inicializar_posicion(Esport[] todos_los_deportes, int deport_inf, TipoDeporte afegir) {
        todos_los_deportes[deport_inf] = new Esport();
        todos_los_deportes[deport_inf].nom_deporte = afegir;
        todos_los_deportes[deport_inf].participantes = new Atleta[40];
        todos_los_deportes[deport_inf].medallas = new int[todos_los_deportes[deport_inf].participantes.length];
    }

    //Esta funcion te pide los datos de un objeto atleta.
    private static Atleta introducir_atleta(Scanner ent) {
        Atleta alta = new Atleta();

        System.out.print("Añade nombre del atleta: ");
        alta.nombre = ent.nextLine();

        System.out.print("Añade pais del atleta: ");
        alta.pais = ent.nextLine();

        return alta;
    }

    //Esta funcion comprueba si el deporte existe.
    private static int comprovar_si_existe(Esport[] todos_los_deportes, int deport_inf, TipoDeporte afegir) {

        for (int i = 0; i < deport_inf; i++) {
            if (todos_los_deportes[i].nom_deporte == afegir) {
                return i;
            }
        }
        return -1;
    }

    //Esta funcion lista los atletas del deporte que escojas.
    private static void listar_todos_deportes(Esport[] todos_los_deportes, int deport_inf) {
        Scanner ent = new Scanner(System.in);

        System.out.print("Que deporte quieres listar: ");
        TipoDeporte deporte_listar = TipoDeporte.valueOf(ent.nextLine().toUpperCase());

        int indice = comprovar_si_existe(todos_los_deportes, deport_inf, deporte_listar);

        if (indice != -1) {
            for (int i = 0; i < todos_los_deportes[indice].cont_participantes; i++) {
                System.out.println(todos_los_deportes[indice].participantes[i].nombre + " - "
                        + todos_los_deportes[indice].medallas[i] + " medallas");
            }
        } else {
            System.out.println("No tiene participantes este deporte!");
        }
        System.out.println("-----------------------------");
    }

    //Esta fucnion te dice el mejor atleta de un deporte en especifico.
    private static void mejor_deportista_deporte(Esport[] todos_los_deportes, int deport_inf) {
        Scanner ent = new Scanner(System.in);
        int medallas_max = 0, pos_mejor = 0;

        System.out.print("Que deporte quieres listar: ");
        TipoDeporte deporte_listar = TipoDeporte.valueOf(ent.nextLine().toUpperCase());

        int indice = comprovar_si_existe(todos_los_deportes, deport_inf, deporte_listar);

        if (indice != -1) {
            for (int i = 0; i < todos_los_deportes[indice].cont_participantes; i++) {
                if (todos_los_deportes[indice].medallas[i] > medallas_max) {
                    medallas_max = todos_los_deportes[indice].medallas[i];
                    pos_mejor = i;
                }
            }
            System.out.println("\nEl mejor atleta es " + todos_los_deportes[indice].participantes[pos_mejor].nombre
                    + " con " + todos_los_deportes[indice].medallas[pos_mejor] + " medallas.");
        } else {
            System.out.println("No tiene participantes este deporte!");
        }
        System.out.println("-------------------------");
    }

    //Esta funcion te dice el mejor atleta entre todos los deportes.
    private static void mejor_deportista(Esport[] todos_los_deportes, int deport_inf) {
        int medallas_max = 0;
        Atleta mejor_atleta = new Atleta();
        TipoDeporte mejor_deporte = null;

        for (int deportes = 0; deportes < deport_inf; deportes++) {
            for (int atletas = 0; atletas < todos_los_deportes[deportes].cont_participantes; atletas++) {
                if (todos_los_deportes[deportes].medallas[atletas] > medallas_max) {
                    medallas_max = todos_los_deportes[deportes].medallas[atletas];
                    mejor_atleta.nombre = todos_los_deportes[deportes].participantes[atletas].nombre;
                    mejor_atleta.pais = todos_los_deportes[deportes].participantes[atletas].pais;
                    mejor_deporte = todos_los_deportes[deportes].nom_deporte;
                }
            }
        }
        System.out.println("El mejor atleta es " + mejor_atleta.nombre + " del país " + mejor_atleta.pais
                + ", \ny su especialidad es " + mejor_deporte);
        System.out.println("-----------------------------");
    }

    //Esta funcion te muestra el podium del deporte que elijas.
    private static void ordenar_podium(Esport[] todos_los_deportes, int deport_inf) {
        Scanner ent = new Scanner(System.in);
        Atleta aux = new Atleta();
        int med_aux;
        
        for (int deportes = 0; deportes < deport_inf; deportes++) {
            for (int atletas = 0; atletas < (todos_los_deportes[deportes].cont_participantes - deportes - 1); atletas++) {
                if (todos_los_deportes[deportes].medallas[atletas] < todos_los_deportes[deportes].medallas[atletas + 1]) {
                    aux.nombre = todos_los_deportes[deportes].participantes[atletas].nombre;
                    aux.pais = todos_los_deportes[deportes].participantes[atletas].pais;
                    med_aux = todos_los_deportes[deportes].medallas[atletas];

                    todos_los_deportes[deportes].participantes[atletas].nombre = todos_los_deportes[deportes].participantes[atletas + 1].nombre;
                    todos_los_deportes[deportes].participantes[atletas].pais = todos_los_deportes[deportes].participantes[atletas + 1].pais;
                    todos_los_deportes[deportes].medallas[atletas] = todos_los_deportes[deportes].medallas[atletas + 1];

                    todos_los_deportes[deportes].participantes[atletas + 1].nombre = aux.nombre;
                    todos_los_deportes[deportes].participantes[atletas + 1].pais = aux.pais;
                    todos_los_deportes[deportes].medallas[atletas + 1] = med_aux;
                }
            }
        }
    }

    private static void mostrar_podium(Esport[] todos_los_deportes, int deport_inf) {
        Scanner ent = new Scanner(System.in);
        System.out.print("Que deporte quieres ver el podium: ");
        TipoDeporte deporte_listar = TipoDeporte.valueOf(ent.nextLine().toUpperCase());

        int indice = comprovar_si_existe(todos_los_deportes, deport_inf, deporte_listar);

        if (indice != -1) {
            for (int i = 0; i < 3; i++) {
                System.out.println(todos_los_deportes[indice].participantes[i].nombre + " - "
                        + todos_los_deportes[indice].medallas[i] + " medallas");
            }
        } else {
            System.out.println("No tiene participantes este deporte!");
        }
        System.out.println("-----------------------------");
    }
}
