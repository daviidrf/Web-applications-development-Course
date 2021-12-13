<?php
require_once "controller/CategoryController.php";
require_once "controller/UserController.php";


//derive/reparta a un controlador o a otro, segun el caso
class MainController{

    //no tiene vista
    //no tiene modelo

    public function processRequest(){

        $request=isset($_GET["menu"])?$_GET["menu"]:null;


//dependiendo de una variable, 
//llamaremos a un controlador u a otro
        switch($request){
            case "category":
                $category=new CategoryController();
                $category->processRequest();
                break;
            case "user":
                $user=new UserController();
                $user->processRequest();
                break;
            case "product":
                //llamada al controlador ProductController
                break;
            default://la primera vez que inicio la aplicacion $_GET["menu"] no tiene valor
                include ("view/menu/MainMenu.php");
            

        }


    }

}





?>