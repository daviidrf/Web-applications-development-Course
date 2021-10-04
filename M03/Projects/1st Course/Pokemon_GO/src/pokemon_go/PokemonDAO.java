package pokemon_go;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static pokemon_go.Pokemon_GO.AMARILLO;
import static pokemon_go.Pokemon_GO.RESET;

public class PokemonDAO implements Operaciones {

    @Override
    public void cazar_Pokemon(Usuario usuario_actual) {
        Pokemon POK = new Pokemon();

        POK.visualizarPokemon();
        System.out.println(POK.toString());

        System.out.println(AMARILLO + "\n-------------------------------------------------------------------" + RESET);

        boolean validarMultiplicaciones = validarMultiplicaciones(POK, usuario_actual);

        System.out.println(AMARILLO + "\n-------------------------------------------------------------------" + RESET);

        if (validarMultiplicaciones) {
            crearMochila(POK, usuario_actual);
            System.out.println("\nPokemon atrapado!");
        } else {
            System.out.println("\nEl Pokemon se ha escapado!");
        }
    }

    private void crearMochila(Pokemon Nuevo, Usuario usuario_actual) {

        File bin_mochila = new File("ficheros/mochilas/" + usuario_actual.getNombre() + "_mochila.dat");

        if (bin_mochila.exists()) {//SI EXISTE
            ObjectInputStream Fichero = null;
            ObjectOutputStream PokemonNuevo = null;
            FileInputStream ficheroLectura = null;

            try {
                ficheroLectura = new FileInputStream("ficheros/mochilas/" + usuario_actual.getNombre() + "_mochila.dat");
                Fichero = new ObjectInputStream(ficheroLectura);

                usuario_actual.setMochila((ArrayList<Pokemon>) Fichero.readObject());
                usuario_actual.getMochila().add(Nuevo);
                Fichero.close();

                FileOutputStream escritura = new FileOutputStream("ficheros/mochilas/" + usuario_actual.getNombre() + "_mochila.dat");
                PokemonNuevo = new ObjectOutputStream(escritura);

                PokemonNuevo.writeObject(usuario_actual.getMochila());
                PokemonNuevo.close();

            } catch (IOException ex) {
                System.out.println("No tienes Mochila!");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error de clase!");
            }

        } else {//NO EXISTE
            ObjectOutputStream PokemonNuevo = null;
            try {
                FileOutputStream escritura = new FileOutputStream("ficheros/mochilas/" + usuario_actual.getNombre() + "_mochila.dat");
                PokemonNuevo = new ObjectOutputStream(escritura);

                usuario_actual.getMochila().add(Nuevo);

                PokemonNuevo.writeObject(usuario_actual.getMochila());
                PokemonNuevo.close();

            } catch (FileNotFoundException ex) {
                System.out.println("Fichero no existe!");
            } catch (IOException ex) {
                System.out.println("Error escritura!");
            }
        }
    }

    @Override
    public void listarMochila(Usuario usuario_actual) {
        ObjectInputStream Fichero = null;
        FileInputStream ficheroLectura = null;
        int num_pok = 0;

        try {
            ficheroLectura = new FileInputStream("ficheros/mochilas/" + usuario_actual.getNombre() + "_mochila.dat");
            Fichero = new ObjectInputStream(ficheroLectura);

            usuario_actual.setMochila((ArrayList<Pokemon>) Fichero.readObject());
            Fichero.close();

            if (usuario_actual.getMochila().isEmpty()) {
                System.out.println("Tu mochila esta vacia!");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Tu mochila esta vacia!");
        } catch (IOException ex) {
            System.out.println("Tu mochila esta vacia!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no correcta!");
        }

        Collections.sort(usuario_actual.getMochila());
        Collections.reverse(usuario_actual.getMochila());
        // ESTA LINEA LA COMENTAMOS O NO DEPENDIENDO DEL ORDEN QUE QUERAMOS

        for (int i = 0; i < usuario_actual.getMochila().size(); i++) {
            System.out.println(usuario_actual.getMochila().get(i).toString());
            num_pok++;
        }
        System.out.println("\nEn tu mochila hay actualmente " + num_pok + " Pokemons!");
    }

    @Override
    public void transferir_Pokemon(Usuario usuario_actual) {
        Scanner ent = new Scanner(System.in);

        File bin_mochila = new File("ficheros/mochilas/" + usuario_actual.getNombre() + "_mochila.dat");

        System.out.print("Introduce el usuario para transferir: ");
        String userTransf = ent.nextLine();

        System.out.print("Introduce el Pokemon que quieres transferir: ");
        String pokTransf = ent.nextLine();

        if (!userTransf.equals(usuario_actual.getNombre())) {
            if (bin_mochila.exists()) {//SI EXISTE
                ObjectInputStream Fichero = null;
                ObjectOutputStream transPok = null;
                FileInputStream ficheroLectura = null;
                FileOutputStream transfer = null;
                ObjectOutputStream GuardarMochila = null;
                FileOutputStream ArchivoMochila = null;

                try {
                    ficheroLectura = new FileInputStream("ficheros/mochilas/" + usuario_actual.getNombre() + "_mochila.dat");
                    Fichero = new ObjectInputStream(ficheroLectura);

                    usuario_actual.setMochila((ArrayList<Pokemon>) Fichero.readObject());
                    Fichero.close();
                    int index = 0;

                    for (int i = 0; i < usuario_actual.getMochila().size(); i++) {
                        if (usuario_actual.getMochila().get(i).getNombre().equalsIgnoreCase(pokTransf)) {
                            index = i;
                            break;
                        }
                    }

                    Pokemon PokEnviado = usuario_actual.getMochila().get(index);
                    usuario_actual.getMochila().remove(index);

                    ArchivoMochila = new FileOutputStream("ficheros/mochilas/" + usuario_actual.getNombre() + "_mochila.dat");
                    GuardarMochila = new ObjectOutputStream(ArchivoMochila);

                    GuardarMochila.writeObject(usuario_actual.getMochila());
                    GuardarMochila.close();

                    transfer = new FileOutputStream("ficheros/transfers/transfer_" + userTransf + ".dat");
                    transPok = new ObjectOutputStream(transfer);

                    transPok.writeObject(PokEnviado);
                    transPok.close();

                    System.out.println("\nTransfiriendo Pokemon...");

                } catch (IOException ex) {
                    Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    System.out.println("Clase no encontrada!");
                }
            } else {//NO EXISTE
                System.out.println("No tienes Pokemons!");
            }
        } else{
            System.out.print("\nNo puedes transferirte un Pokemon a ti mismo!");
        }

    }

    @Override
    public void recibir_Pokemon(Usuario usuario_actual) {

        ArrayList<Pokemon> Mochila = new ArrayList<>();
        Pokemon RecibirOther;
        Scanner ent = new Scanner(System.in);

        File bin_transfer = new File("ficheros/transfers/transfer_" + usuario_actual.getNombre() + ".dat");
        File bin_mochila = new File("ficheros/mochilas/" + usuario_actual.getNombre() + "_mochila.dat");

        if (bin_transfer.exists()) {//SI EXISTE
            ObjectInputStream Fichero = null;
            ObjectOutputStream transPok = null;
            FileInputStream ficheroLectura = null;
            FileOutputStream transfer = null;
            ObjectInputStream FicheroMochila = null;
            FileInputStream ficheroLecturaMochila = null;

            if (bin_mochila.exists()) {
                try {
                    ficheroLectura = new FileInputStream("ficheros/transfers/transfer_" + usuario_actual.getNombre() + ".dat");
                    Fichero = new ObjectInputStream(ficheroLectura);

                    RecibirOther = (Pokemon) Fichero.readObject();
                    Fichero.close();

                    ficheroLecturaMochila = new FileInputStream("ficheros/mochilas/" + usuario_actual.getNombre() + "_mochila.dat");
                    FicheroMochila = new ObjectInputStream(ficheroLecturaMochila);

                    usuario_actual.setMochila((ArrayList<Pokemon>) FicheroMochila.readObject());
                    usuario_actual.getMochila().add(RecibirOther);
                    FicheroMochila.close();

                    transfer = new FileOutputStream("ficheros/mochilas/" + usuario_actual.getNombre() + "_mochila.dat");
                    transPok = new ObjectOutputStream(transfer);

                    transPok.writeObject(usuario_actual.getMochila());
                    transPok.close();
                    
                    bin_transfer.delete();

                    System.out.println("\nRecibiendo Pokemon...");

                } catch (IOException ex) {
                    Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    System.out.println("Clase no encontrada!");
                }
            } else {
                ObjectOutputStream PokemonNuevo = null;
                try {
                    ficheroLectura = new FileInputStream("ficheros/transfers/transfer_" + usuario_actual.getNombre() + ".dat");
                    Fichero = new ObjectInputStream(ficheroLectura);

                    RecibirOther = (Pokemon) Fichero.readObject();
                    Fichero.close();

                    usuario_actual.getMochila().add(RecibirOther);

                    FileOutputStream escritura = new FileOutputStream("ficheros/mochilas/" + usuario_actual.getNombre() + "_mochila.dat");
                    PokemonNuevo = new ObjectOutputStream(escritura);

                    PokemonNuevo.writeObject(usuario_actual.getMochila());
                    PokemonNuevo.close();
                    
                    bin_transfer.delete();

                    System.out.println("\nRecibiendo Pokemon...");

                } catch (FileNotFoundException ex) {
                    System.out.println("Fichero no existe!");
                } catch (IOException ex) {
                    Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    System.out.println("Error con la clase!");
                }
            }
        } else {//NO EXISTE
            System.out.println("No tienes Pokemons!");
        }
    }

    private boolean validarMultiplicaciones(Pokemon POK, Usuario usuario_actual) {
        Scanner ent = new Scanner(System.in);
        Duration tiempoTardado = null;
        int numeroMults = (POK.getCP() / 10);
        int correcto = 0;

        Instant start = Instant.now();

        for (int i = 0; i < numeroMults; i++) {

            int num1 = (int) (Math.random() * 10) + 1;
            int num2 = (int) (Math.random() * 10) + 1;

            int solucion = num1 * num2;

            System.out.print("Resuelve esta multiplicacion " + num1 + " x " + num2 + " = ");
            int respuesta = ent.nextInt();

            Instant end = Instant.now();
            tiempoTardado = Duration.between(start, end);

            if (tiempoTardado.toSeconds() > 60) {
                System.out.println("\nTe has pasado del tiempo limite!");
                break;
            }

            if (respuesta == solucion) {
                correcto++;
            } else {
                System.out.println("\nTe has equivocado");
                break;
            }
        }
        System.out.print("\nTu velocidad aproximada ha sido de " + ((double) (tiempoTardado.toSeconds() / numeroMults))
                + " segundos por pregunta.");
        System.out.println("\nEn total has tardado: " + tiempoTardado.toSeconds() + " segundos.");

        if ((correcto == numeroMults) && (tiempoTardado.toSeconds() <= 60)) {
            guardarRecord(usuario_actual, tiempoTardado);
            return true;
        }

        return false;
    }

    private void guardarRecord(Usuario usuario_actual, Duration tiempoTardado) {

        Scanner lectorRecord = null;
        String userRecord = usuario_actual.getNombre() + " " + tiempoTardado.toSeconds();

        File record = new File("ficheros/record.dat");

        if (record.exists()) {
            try {
                lectorRecord = new Scanner(record);
                String usuarioRecord = null;

                while (lectorRecord.hasNext()) {
                    usuarioRecord = lectorRecord.nextLine();
                }
                lectorRecord.close();

                String[] partesRecord = usuarioRecord.split(" ");
                String name = partesRecord[0];
                int tiempo = Integer.parseInt(partesRecord[1]);

                if (tiempo > tiempoTardado.toSeconds()) {
                    usuarioRecord = userRecord;
                }

                try {
                    FileWriter addRecord = new FileWriter(record);
                    addRecord.write(userRecord);
                    addRecord.close();

                } catch (IOException ex) {
                    System.out.println("Error de escritura!");
                }

            } catch (FileNotFoundException ex) {
                System.out.println("Fichero no existe!");
            }
        } else {
            try {
                FileWriter addRecord = new FileWriter(record);
                addRecord.write(userRecord);
                addRecord.close();

            } catch (IOException ex) {
                System.out.println("Error de escritura!");
            }
        }

    }

    @Override
    public void mostrarRecord() {
        File record = new File("ficheros/record.dat");
        Scanner lectorRecord = null;

        if (record.exists()) {
            try {
                lectorRecord = new Scanner(record);
                String usuarioRecord = null;
                while (lectorRecord.hasNext()) {
                    usuarioRecord = lectorRecord.nextLine();
                }
                lectorRecord.close();

                String[] partesRecord = usuarioRecord.split(" ");
                String name = partesRecord[0];
                int tiempo = Integer.parseInt(partesRecord[1]);

                System.out.println("El record de captura mas rapida lo tiene:\n");
                System.out.print("Usuario --> " + name
                        + "\nTiempo --> " + tiempo + " segundos");

            } catch (FileNotFoundException ex) {
                Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.print("Nadie ha capturado un Pokemon!");
        }
    }

    @Override
    public void evolucionar_Pokemon(Usuario usuario_actual) {
        Scanner ent = new Scanner(System.in);
        ObjectInputStream Fichero = null;
        FileInputStream ficheroLectura = null;
        ObjectOutputStream PokemonEvolucionado = null;
        int i;

        System.out.print("Introduce Pokemon que quieres evolucionar: ");
        String pokemonBuscado = ent.nextLine();

        try {
            ficheroLectura = new FileInputStream("ficheros/mochilas/" + usuario_actual.getNombre() + "_mochila.dat");
            Fichero = new ObjectInputStream(ficheroLectura);

            usuario_actual.setMochila((ArrayList<Pokemon>) Fichero.readObject());
            Fichero.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Tu mochila esta vacia!");
        } catch (IOException ex) {
            System.out.println("Error de lectura!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no correcta!");
        }

        Collections.sort(usuario_actual.getMochila());
        Collections.reverse(usuario_actual.getMochila());
        // ESTA LINEA LA COMENTAMOS O NO DEPENDIENDO DEL ORDEN QUE QUERAMOS

        for (i = 0; i < usuario_actual.getMochila().size(); i++) {
            if (usuario_actual.getMochila().get(i).getNombre().equalsIgnoreCase(pokemonBuscado)) {
                usuario_actual.getMochila().get(i).evolucionarPokemon(pokemonBuscado);
                break;
            }
        }
        if (!pokemonBuscado.equalsIgnoreCase(usuario_actual.getMochila().get(i).getNombre())) {
            System.out.println("\nEl Pokemon " + pokemonBuscado + " ha evolucionado a "
                    + usuario_actual.getMochila().get(i).getNombre() + "!");

            usuario_actual.getMochila().get(i).visualizarPokemon();
        }

        FileOutputStream escritura;
        try {
            escritura = new FileOutputStream("ficheros/mochilas/" + usuario_actual.getNombre() + "_mochila.dat");
            PokemonEvolucionado = new ObjectOutputStream(escritura);

            PokemonEvolucionado.writeObject(usuario_actual.getMochila());
            PokemonEvolucionado.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
