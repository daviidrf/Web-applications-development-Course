<?php

//seccion de llamada a la vista y al modelo
require_once "view/UserView.php";
require_once "model/User.php";//desde la vista podré acceder
require_once "model/persist/UserDAO.php";//prohibido para la vista

class UserController{

    //todos los controladores tendrán 2 atributos
    private $view;
    private $model;

    public function __construct()
    {
        $this->view=new UserView();//acceder a los trozos de la vista
        $this->model=new UserDAO();//hacer el CRUD
    }

    public function processRequest(){

        $request=null;//la primera vez
        if(isset($_POST["action"])){
            $request=$_POST["action"];//recojo las variables de formulario
        }else if(isset($_GET["option"])){
            $request=$_GET["option"];//recojo las variables de menu Categorias
        }

        switch($request){
            case "list":
                $this->list();//metodo que me hara listar users
                break;

            case "formAdd":
               // $this->formAdd();//metodo que mostrara el formulario para añadir categoria
                break;

            case "add":
               // $this->add();//metodo que recoje la nueva categ. y me la inserta en el archivo
                break;

            case "formDel":
               // $this->formDel();//metodo que muestra el formulario para decir que cate. borrar
                break;

            default:
                //enseñar la vista por defecto
                $this->view->display();
        }

    }

            /*
            *
            *
            *
            */
    public function list(){


        //llamada al modelo: CategoryDAO 
        //y le pedira que le dé todas las categorias: array de objetos Category
        $users=[];
        //demano un array de Category
        $users = $this->model->listAll();


        $this->view->display("view/form/UserList.php", $users);
        
        //enviar a la vista la lista de las categorias
    }
}
