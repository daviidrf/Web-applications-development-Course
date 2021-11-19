<?php
class Cadena
{
    //No necesita atributos
    //No necesita constructor
    //Tiene una serie de métodos MUY útiles

    public static function largo ($cadena) {
        return strlen($cadena);
    }

    public static function mayus($cadena) {
        return strtoupper($cadena);
    }
}
?>