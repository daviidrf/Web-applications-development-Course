<!--La plantilla basica para toda la aplicacion-->
<?php
//iniciar sesion se hace aqui, siempre
//y cuando lo necesite

session_start();

//llamada a mi primer controlador
require_once "controller/MainController.php";

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Primer MVC PHP</title>
    <link rel="icon" href="view/img/icono.png">
     
    <link href="view/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
   <!-- <link rel="stylesheet" href="view/css/style.css">-->
    <script src="view/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <!--<script src="view/js/script.js"></script>-->
</head>
<body>
    <?php
        $controlMain=new MainController();
        $controlMain->processRequest();
    ?>

</body>
</html>
