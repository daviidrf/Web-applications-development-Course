<!--La plantilla basica para toda la aplicacion-->
<?php 
//iniciar sesion se hace aqui, siempre 
//y cuando lo necesite

//session_start();

//llamada a mi primer controlador
require_once "controller/MainController.php";

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mi Modelo Vista Controlador</title>
    <link rel="stylesheet" href="view/css/style.css">
    <script src="view/js/script.js"></script>
</head>
<body>
    <?php
        $controlMain=new MainController();
        $controlMain->processRequest();
    ?>
    
</body>
</html>
