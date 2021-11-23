<?php
require_once "Guitarist.php";
class Operacion extends Guitarist
{
    // 1 único contructor
    public function __construct($firstName, $lastName)
    { //Dos guiones bajos
        $this->musicianType = "Lead Guitarist";
        parent::__construct($firstName,$lastName);
    }
}
