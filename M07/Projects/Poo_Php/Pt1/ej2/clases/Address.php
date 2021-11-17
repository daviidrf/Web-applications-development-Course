<?php
class Address
{
    // Atributos privates
    private $viaType;
    private $streetName;
    private $floor;
    private $door;
    private $postalCode;
    private $city;

    // 1 único contructor
    public function __construct($viaType, $streetName, $floor, $door, $postalCode, $city)
    { //Dos guiones bajos
        $this->viaType = $viaType;
        $this->streetName = $streetName;
        $this->floor = $floor;
        $this->door = $door;
        $this->postalCode = $postalCode;
        $this->city = $city;
    }

    //Métodos
    public function printData()
    {
        echo "Address: <br>";
        echo " Via type: " . $this->viaType . 
                "<br> Street name: " . $this->streetName . 
                "<br> Floor: " . $this->floor . 
                "<br> Door: " . $this->door . 
                "<br> Postal code: " . $this->postalCode . 
                "<br> City: " . $this->city;
    }
}
