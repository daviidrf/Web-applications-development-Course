package pokemon_go;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;
import static pokemon_go.Pokemon_GO.AMARILLO;
import static pokemon_go.Pokemon_GO.AZUL;
import static pokemon_go.Pokemon_GO.RESET;
import static pokemon_go.Pokemon_GO.ROJO;
import static pokemon_go.Pokemon_GO.VERDE;

enum tipo {
    PLANTA, FUEGO, AGUA
};

public class Pokemon implements Serializable, Comparable<Pokemon> {

    private String nombre;
    private tipo tipo;
    private int CP;

    public Pokemon() {
        setNombreYtipo();
        this.CP = (int) ((Math.random() * 90) + 10);
    }

    public String getNombre() {
        return nombre;
    }

    public tipo getTipo() {
        return tipo;
    }

    public int getCP() {
        return CP;
    }

    private void setNombreYtipo() {
        int random = (int) (Math.random() * 6) + 1;

        switch (random) {
            case 1:
                this.nombre = "Charmander";
                this.tipo = tipo.FUEGO;
                break;
            case 2:
                this.nombre = "Bulbasaur";
                this.tipo = tipo.PLANTA;
                break;
            case 3:
                this.nombre = "Squirtle";
                this.tipo = tipo.AGUA;
                break;
            case 4:
                this.nombre = "Vulpix";
                this.tipo = tipo.FUEGO;
                break;
            default:
                this.nombre = "Odish";
                this.tipo = tipo.PLANTA;
                break;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pokemon other = (Pokemon) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nNombre --> " + this.nombre
                + "\nCombat Points --> " + this.CP;
    }

    public void visualizarPokemon() {
        Scanner mostrar_pokemon = null;

        File imagen = new File("ficheros/pokemons/"
                + this.nombre + ".pok");

        try {
            mostrar_pokemon = new Scanner(imagen);

            while (mostrar_pokemon.hasNext()) {
                String pokemon = mostrar_pokemon.nextLine();

                switch (this.tipo) {
                    case AGUA:
                        System.out.println(AZUL + pokemon + RESET);
                        break;
                    case FUEGO:
                        System.out.println(ROJO + pokemon + RESET);
                        break;
                    case PLANTA:
                        System.out.println(VERDE + pokemon + RESET);
                        break;
                    default:
                        System.out.println(AMARILLO + pokemon + RESET);
                        break;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero de Imagen no existe!");
        }
    }

    @Override
    public int compareTo(Pokemon o
    ) {
        int byName = o.getNombre().compareTo(this.getNombre());

        if (byName != 0) {
            return byName;
        }

        return Integer.compare(o.getCP(), this.getCP());
    }

    public void evolucionarPokemon(String pokemonParaEvolucionar) {

        switch (pokemonParaEvolucionar) {
            case "Charmander":
                this.nombre = "Charmeleon";
                this.CP = this.CP * 2;
                break;
            case "Bulbasaur":
                this.nombre = "Ivysaur";
                this.CP = this.CP * 2;
                break;
            case "Squirtle":
                this.nombre = "Wartortle";
                this.CP = this.CP * 2;
                break;
            case "Vulpix":
                this.nombre = "Ninetales";
                this.CP = this.CP * 2;
                break;
            case "Odish":
                this.nombre = "Beelum";
                this.CP = this.CP * 2;
                break;
            default:
                System.out.println("\nEste Pokemon ya esta evolucionado, no puede evolucionar mas!");
                break;
        }
    }
}
