<?php
require_once "model/User.php";
require_once "model/persist/DBConnect.php";

class UserDAO{

    private $dbConnect;

    public function __construct(){
        $this->dbConnect=new DBConnect("model/files/users.txt");
    }


    //metodos para listar, leer, añadir,..

    //metodo para crear una lista con todas
    //las categorias
    public function listAll(){

        $arrayUs=[];
        $linesFile=[];
        //$linesFile: me devuleve un array
        //donde cada posicion es una linea del archivo
        $linesFile=$this->dbConnect->readAllLines();

        if(count($linesFile)>0){
            //for($i=0;$i<count($linesFile);$i++)
            foreach($linesFile as $line){
                $pieces=explode(";",$line);
                $arrayUs[]=new User($pieces[0],$pieces[1]);
            }


        }
        //recorrer el archivo --> array de strings
        //pasar de array de strings a array de User
        //devuelvo a la vista el array de User

        return $arrayUs;//array de User--> Controlador



    }

    //metodo que servirá para añadir
    //una categoria al archivo
    public function addUser(){
      $name = filter_input(INPUT_POST,"name",FILTER_SANITIZE_SPECIAL_CHARS);
      $password=filter_input(INPUT_POST, "password", FILTER_SANITIZE_SPECIAL_CHARS);
      if (isset($name) && isset($password)) {
      $stringDatos="\n".$name.";".$password.";";
      $this->dbConnect->addNewLine($stringDatos);
      }
    }

    //metodo para modificar una categoria
    public function modifyUser(){

    }

    //metodo que servirá para añadir
    //una categoria al archivo
    public function loginUser(){
      $name = filter_input(INPUT_POST,"name",FILTER_SANITIZE_SPECIAL_CHARS);
      $password=filter_input(INPUT_POST, "password", FILTER_SANITIZE_SPECIAL_CHARS);
      $check = false;
      if (isset($name) && isset($password)) {
        $arrayCat=[];
        $linesFile=[];
        //$linesFile: me devuleve un array
        //donde cada posicion es una linea del archivo
        $linesFile=$this->dbConnect->readAllLines();

        if(count($linesFile)>0){
            //for($i=0;$i<count($linesFile);$i++)
            foreach($linesFile as $line){
                $pieces=explode(";",$line);
              
                if ($name == $pieces[0] && $password == $pieces[1]) {
                  $check = true;
                 
                }
            }
        }
      
        //recorrer el archivo --> array de strings
        //pasar de array de strings a array de Category
        //devuelvo a la vista el array de category
        return $check;//array de Category--> Controlador
      }

    }
}
?>
