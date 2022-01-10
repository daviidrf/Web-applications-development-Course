<?php

//seccion de llamada a la vista y al modelo
require_once "view/CategoryView.php";
require_once "model/Category.php";//desde la vista podré acceder
require_once "model/persist/CategoryDAO.php";//prohibido para la vista

class CategoryController{

    //todos los controladores tendrán 2 atributos
    private $view;
    private $model;

    public function __construct()
    {
        $this->view=new CategoryView();//acceder a los trozos de la vista
        $this->model=new CategoryDAO();//hacer el CRUD
    }

    public function processRequest(){

        $request=null;//la primera vez
        if(isset($_POST["action"])){
            $request=$_POST["action"];//recojo las variables de formulario
        }else if(isset($_GET["option"])){
            $request=$_GET["option"];//recojo las variables de menu Categorias
        }
        $_SESSION['info']=array(); //per donar sortida a tots els missatges generals d'informació
        $_SESSION['error']=array(); ////per donar sortida a tots els missatges d'error
        switch($request){
            case "list":
                $this->list();//metodo que me hara listar categories
                break;

            case "formAdd":
               $this->formAdd();//metodo que mostrara el formulario para añadir categoria
                break;

            case "add":
                $this->add();//metodo que añadirá categoria
                break;

            case "searchName":
                $this->searchName();//metodo que  mostrara el formulario para listar la categoria con nombre específico
                break;

            case "search":
                $this->search();//metodo que añadirá categoria
                break;

            case "formDel":
               //$this->formDel();//metodo que muestra el formulario para decir que cate. borrar
                break;

            default:
                //enseñar la vista por defecto
                $this->view->display();
        }

    }

    public function list()
    {


        //llamada al modelo: CategoryDAO
        //y le pedira que le dé todas las categorias: array de objetos Category
        $categories=[];
        //demano un array de Category
        $categories = $this->model->listAll();

        $_SESSION["info"][]="Llistat de les categories";
        $this->view->display("view/form/CategoryList.php", $categories);

        //enviar a la vista la lista de las categorias
    }

    public function formAdd()
    {
      $this->view->display("view/form/CategoryAddForm.php");
    }

    public function add()
    {
      $this->model->addCategory();
     // $this->view->display("view/form/CategoryAddSuccess.php");
     $this->view->display("view/form/CategoryAddForm.php");
    }

    public function searchName()
    {
      $this->view->display("view/form/CategorySearchName.php");

    }

    public function search()
    {
      $categories=[];
      //demano un array de Category
      $categories = $this->model->searchCategory();
      $this->view->display("view/form/CategoryList.php", $categories);
    }
}
?>
