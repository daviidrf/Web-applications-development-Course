<?php
require_once "../interficies/Musician.php";
class Guitarist implements Musician
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
    
    public function getFirstName()
    {
        return $this->firstName;
    } 
    public function setFirstName($firstName)
    {
        $this->firstName = $firstName;
        return $this;
    }

    public function getLastName()
    {
        return $this->lastName;
    }
    public function setLastName($lastName)
    {
        $this->lastName = $lastName;
        return $this;
    }

    public function setMusicianType($musicianType)
    {
        $this->musicianType = $musicianType;
        return $this;
    }

    // Métodos
    public function addInstrument($instrument)
    {
        $this->instruments[] = $instrument;
    }
    public function getInstruments()
    {
        return $this->instruments;
    }
    public function assignToBand($band)
    {
        $this->bandReference = $band;
    }
    public function getMusicianType()
    {
        return $this->musicianType;
    }
    public function getName()
    {
        return $this->firstName . " " . $this->lastName;
    }
    
} 