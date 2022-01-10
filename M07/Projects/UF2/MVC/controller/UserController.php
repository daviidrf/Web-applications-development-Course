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
        $_SESSION['info']=array(); //per donar sortida a tots els missatges generals d'informació
        $_SESSION['error']=array(); ////per donar sortida a tots els missatges d'error
        
        switch($request){
            case "list":
                $this->list();//metodo que me hara listar usuarios
                break;

            case "formAdd":
               $this->formAdd();//metodo que mostrara el formulario para añadir usuario
                break;

            case "add":
                $this->add();//metodo que añadirá usurio
                break;

            case "formLogin":
                $this->formLogin();//metodo que mostrara el formulario para añadir usuario
                break;

            case "login":
                $this->login();//metodo que añadirá usurio
                break;

            case "formDel":
               // $this->formDel();//metodo que muestra el formulario para decir que usuario borrar
                break;
            
             case "logout":
              if(isset($_SESSION["login"])){
                session_destroy();
                header('Location:index.php');
              }
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


        $this->view->display("view/form/UserList.php", $categories);

        //enviar a la vista la lista de las categorias
    }

    public function formAdd()
    {
      $this->view->display("view/form/UserAddForm.php");
    }

    public function add()
    {
      $this->model->addUser();
      $this->view->display("view/form/UserAddSuccess.php");
    }



    public function formLogin()
    {
      $this->view->display("view/form/UserLoginForm.php");
    }

    public function login()
    {
     // $check = false;<---això noooo
      $check= $this->model->loginUser();//recollo el que vé del model i després comparo
      if ($check != false) {
        $_SESSION["login"]="userValidated";
        //$this->view->display("view/form/UserLoginForm.php");
       // echo "Perfecte";
      
       header('Location:index.php');
      } else {
        $_SESSION["error"][]="Error en les credencials";
        $this->view->display("view/form/UserLoginForm.php");
        
      }

    }
}
?>
