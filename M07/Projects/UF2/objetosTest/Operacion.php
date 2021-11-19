<?php
abstract class Operacion
{
    // Atributos privates
    protected $value1;
    protected $value2;
    protected $result;

    // 1 único contructor
    public function __construct($value1, $value2)
    { //Dos guiones bajos
        $this->value1 = $value1;
        $this->value2 = $value2;
    }

    //Métodos
    public function printResult()
    {
        echo $this->result . "<br>";
    }
}
?>