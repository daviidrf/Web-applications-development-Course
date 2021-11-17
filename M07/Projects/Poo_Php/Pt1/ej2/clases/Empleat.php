<?php
require_once "Address.php";
class Empleat
{
    // Atributos privates
    private $name;
    private $salary;
    private $address;

    // 1 único contructor
    public function __construct($name, $salary=1000)
    { //Dos guiones bajos
        $this->name = $name;
        $this->salary = $salary;
        $this->address = new Address("Calle","Carrilet",22,2,08902,"Hospitalet");
    }

    //Métodos
    public function printData()
    {
        echo "Datos del empleado: <br>";
        echo "Name: " . $this -> name . 
                "<br>Salary: " . $this -> salary . 
                "<br>";
        
    }
}
