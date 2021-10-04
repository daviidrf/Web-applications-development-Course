package ejercicio3_david;

import java.io.Serializable;

public class Pertenencia implements Serializable{
    
    private String nombre;
    private int anyoCompra;

    public Pertenencia(String nombre, int anyoCompra) {
        this.nombre = nombre;
        this.anyoCompra = anyoCompra;
    }

    @Override
    public String toString() {
        return "\nNombre --> " + this.nombre +
                "\nAño de compra --> " + this.anyoCompra;
    }
    
    
    
}
