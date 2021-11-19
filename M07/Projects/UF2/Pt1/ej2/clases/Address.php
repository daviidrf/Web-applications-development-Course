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
    public static function printAddress($address)
    {
        echo "<b>Address:</b> <br>";
        echo " -Via type: " . $address->viaType .
            "<br> -Street name: " . $address->streetName .
            "<br> -Floor: " . $address->floor .
            "<br> -Door: " . $address->door .
            "<br> -Postal code: " . $address->postalCode .
            "<br> -City: " . $address->city;
    }
}
