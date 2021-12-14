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
    public function addCategory($name,$description){
        $exist = false;
        $allCategories = $this->dbConnect->readAllLines();

        foreach($allCategories as $cat){
            $pieces=explode(";",$cat);
            $arrayCat[]= new Category($pieces[0],$pieces[1]);
        }

        foreach ($arrayCat as $cat) {
            if($cat->getName() == $name) {
                $exist = true;
            } 
        }

        if(!$exist) {
            $this->dbConnect->addNewLine("\n$name;$description;");
            echo "Category added";
        } else {
            echo "This category already exists";
        }

    }


    public function searchCategory($name) {
        $allCategories = $this->dbConnect->readAllLines();

        if(count($allCategories)>0){
            foreach($allCategories as $cat){
                $pieces=explode(";",$cat);
                if($pieces[0] == $name) {
                    $categorySearched = new Category($pieces[0],$pieces[1]);
                    return $categorySearched;
                }
            }
        }
    }
}

?>