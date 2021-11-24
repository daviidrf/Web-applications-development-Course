<?php
// El MainController llama a los controladores de tipo. 
// (UserController,CategoryController...)

// SubControladores
require_once "controller/CategoryController.php";

class MainController
{
    //El MainController no tiene vista ni modelo.

    //processRequest inicia todo.
    public function processRequest()
    {

        $request = isset($_GET["menu"]) ? $_GET["menu"] : null;

        //Dependiendo de una variable llamará un controlador u otro.
        switch ($request) {
            case "category":
                $category = new CategoryController();
                break;
            case "users":
                //TODO
                break;
            case "product":
                //TODO
                break;
            default:
                $category = new CategoryController();
                $category->processRequest();
        }
    }
}
