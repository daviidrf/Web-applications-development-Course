<?php
require_once "model/Product.php";
require_once "model/persist/DBConnect.php";

class ProductDAO{

    private $dbConnect;

    public function __construct(){
        $this->dbConnect=new DBConnect("model/files/products.txt");
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

    }

    //metodo para modificar una categoria
    public function modifyUser(){

    }
}
?>
