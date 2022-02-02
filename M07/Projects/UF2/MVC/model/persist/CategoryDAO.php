<?php
require_once "model/Category.php";
require_once "model/persist/DBConnect.php";

class CategoryDAO{

    private $dbConnect;

    public function __construct(){
        $this->dbConnect=new DBConnect("model/files/categories.txt");
    }


    //metodos para listar, leer, añadir,..

    //metodo para crear una lista con todas
    //las categorias
    public function listAll(){

        $arrayCat=[];
        $linesFile=[];
        //$linesFile: me devuleve un array
        //donde cada posicion es una linea del archivo
        $linesFile=$this->dbConnect->readAllLines();

        if(count($linesFile)>0){
            //for($i=0;$i<count($linesFile);$i++)
            foreach($linesFile as $line){
                $pieces=explode(";",$line);
                $arrayCat[]=new Category($pieces[0],$pieces[1]);
            }


        }
        //recorrer el archivo --> array de strings
        //pasar de array de strings a array de Category
        //devuelvo a la vista el array de category

        return $arrayCat;//array de Category--> Controlador



    }

    //metodo que servirá para añadir
    //una categoria al archivo
    public function addCategory(){
      $name = filter_input(INPUT_POST,"name",FILTER_SANITIZE_SPECIAL_CHARS);
      $description = filter_input(INPUT_POST,"description",FILTER_SANITIZE_SPECIAL_CHARS);
      if (isset($name) && isset($description)) {

        $stringDatos="\n".$name.";".$description.";";
        $flag=$this->dbConnect->addNewLine($stringDatos);
        if($flag)  $_SESSION['info'][]="Categoria afegida correctament"; //per donar sortida a tots els missatges generals d'informació
        else $_SESSION['error'][]="Problemes en insertar aquest valor"; ////per donar sortida a tots els missatges d'error
      }
    }

    //metodo para modificar una categoria
    public function modifyCategory(){

    }

    //metodo para buscar una categoria
    public function searchCategory(){
      $name = filter_input(INPUT_POST,"name",FILTER_SANITIZE_SPECIAL_CHARS);
      if (isset($name)) {
        $arrayCat=[];
        $linesFile=[];
        //$linesFile: me devuleve un array
        //donde cada posicion es una linea del archivo
        $linesFile=$this->dbConnect->readAllLines();

        if(count($linesFile)>0){
            //for($i=0;$i<count($linesFile);$i++)
            foreach($linesFile as $line){
                $pieces=explode(";",$line);
                if ($name == $pieces[0]) {
                  $arrayCat[]=new Category($pieces[0],$pieces[1]);
                }
            }
        }
        //recorrer el archivo --> array de strings
        //pasar de array de strings a array de Category
        //devuelvo a la vista el array de category
        return $arrayCat;//array de Category--> Controlador
      }

    }
}
?>
