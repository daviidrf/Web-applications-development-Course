<?php
require_once "Operacion.php"; // Llamo a la clase padre para poder hacer el "extends".

class Suma extends Operacion
{
    private $symbol;

    public function __construct($value1, $value2, $symbol = "+")
    {
        $this->symbol = $symbol;
        parent::__construct($value1, $value2);
    }

    public function operation()
    {
        $this->result = $this->value1 + $this->value2;
    }

    //Métodos
    public function printResult()
    {
        echo "El resultat de la suma ($this->value1  $this->symbol  $this->value2) és: ";
        parent::printResult();
    }
}
