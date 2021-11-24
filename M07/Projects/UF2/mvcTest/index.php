<!-- Plantilla MVC para aplicaciones -->
<?php
    // Inciar la sesión
    session_start();

    // Llamada al primer controlador
    require_once "controller/MainController.php";
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MVC</title>
</head>
<body>
    <?php
        $controlMain = new MainController();
        $controlMain -> processRequest();
    ?>
</body>
</html>