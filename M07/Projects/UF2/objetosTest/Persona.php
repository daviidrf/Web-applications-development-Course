<?php
    class Persona{
        // Atributos privates
        private $name;
        private $age;

        // 1 único contructor
        public function __construct($name="", $age=0){ //Dos guiones bajos
            $this -> name = $name;
            $this -> age = $age;
        }

        // Accesores (Getters y Setters)
        public function getName(){
            return $this -> name;
        }
        public function getAge(){
            return $this -> age;
        }

        public function setName($name){
            $this -> name = $name;
        }
        public function setAge($age){
            $this -> age = $age;
        }

        //Métodos
        public function toPrint(){
            echo "Datos de la persona: <br>";
            echo "Name: " . $this -> name . "<br>Age: " . $this -> age . "<br>";
        }
    }
?>