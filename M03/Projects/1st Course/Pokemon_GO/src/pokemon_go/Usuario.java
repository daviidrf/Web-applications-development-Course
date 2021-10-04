package pokemon_go;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private ArrayList<Pokemon> Mochila;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.Mochila = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Pokemon> getMochila() {
        return Mochila;
    }

    public void setMochila(ArrayList<Pokemon> Mochila) {
        this.Mochila = Mochila;
    }

    
    
}
