<?php
//Desde aquí se llama al modelo y a la vista.
require_once "view/CategoryView.php";
require_once "model/CategoryModel.php"; // Desde la vista podré acceder.
require_once "model/persist/CategoryDAO.php"; // Prohibido para la vista.

class CategoryController
{
    // Todos los controladores tendran 2 atributos.
    private $view;
    private $model;

    public function __construct()
    {
        $this->view = new CategoryView(); // Acceder a los trozos de la vista.
        $this->model = new CategoryDAO(); // Hacer el CRUD (Data Acces Object).
    }

    public function processRequest()
    {
        // A category vengo desde un submenú -- $_GET
        // A category vengo desde un formulario relacionado con category -- $_POST
        $request = isset($_POST["action"]) ? $_POST["action"] : null;
        switch ($request) {
        }
    }
}
