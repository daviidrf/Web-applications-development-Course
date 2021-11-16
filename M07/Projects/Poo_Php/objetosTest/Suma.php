<?php
    require_once "Operacion.php"; // Llamo a la clase padre para poder hacer el "extends".

    class Suma extends Operacion{
       public function operation(){
           $this -> result = $this -> value1 + $this -> value2;
       }
    
    }
?>