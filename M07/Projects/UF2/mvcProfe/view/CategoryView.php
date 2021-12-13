<?php

class CategoryView{
public function __construct(){
    //vacio
}

//display()
//display("view/CategoryMenu.php")
//display("view/form1.php",arrayConObjetos)
public function display($template=null, $content=null){

    //Sección 1:menú variable
    include("view/menu/CategoryMenu.php");

    //Sección 2: la parte del listado o 
    //del formulario (central)
    if(!empty($template)) {
        include ($template);
    } 
    //Sección 3: mensajería
    //include ("view/form/MessageForm.php");

}

}
