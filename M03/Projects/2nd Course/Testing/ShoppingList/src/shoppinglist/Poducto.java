/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppinglist;

/**
 *
 * @author David
 */
public class Poducto {
    
    private String nombreProducto;
    private double precioProducto;
    private boolean comprado;

    public Poducto() {
    }

    public Poducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Poducto(String nombreProducto, double precioProducto, boolean comprado) {
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.comprado = comprado;
    }
    
//    public Poducto(Producto other) {
//        this.nombreProducto = other.nombreProducto;
//        this.precioProducto = other.precioProducto;
//        this.comprado = other.comprado;
//    }
    
    
}
