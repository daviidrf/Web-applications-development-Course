<?php
require_once "Address.php";
class Empleat
{
    // Atributos privates
    private $name;
    private $salary;
    private Address $address;

    // 1 único contructor
    public function __construct($name, $salary = 1000)
    { //Dos guiones bajos
        $this->name = $name;
        $this->salary = $salary;
        $this->address = new Address("Avenida", "Carrilet", "22", "2", "08902", "Hospitalet");
    }

    //Métodos
    public function printData()
    {
        echo "<h3>Datos del empleado:</h3> <br>";
        echo "<b>Name:</b> " . $this->name .
            "<br><b>Salary:</b> " . $this->salary .
            "<br>";
        echo  $this->address->printAddress($this->address);
    }
}
