<?php
require_once "../interficies/Band.php";
class RockBand implements Band
{
    // Atributos privates
    protected $firstName;
    protected $lastName;
    protected $musicianType = "Guitarist";
    protected $instruments = [];
    protected $bandReference;

    // 1 único contructor
    public function __construct($firstName, $lastName)
    { //Dos guiones bajos
        $this->firstName = $firstName;
        $this->lastName = $lastName;
    }

    // Getters y Setters
    

    // Métodos
    
} 