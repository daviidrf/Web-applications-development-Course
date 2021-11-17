<?php
class Empleat
{
    // Atributos privates
    private $name;
    private $salary;

    // 1 único contructor
    public function __construct($name, $salary=1000)
    { //Dos guiones bajos
        $this->name = $name;
        $this->salary = $salary;
    }

    //Métodos
    public function printData()
    {
        echo "Datos del empleado: <br>";
        echo "Name: " . $this -> name . "<br>Salary: " . $this -> salary . "<br>";
    }
}
