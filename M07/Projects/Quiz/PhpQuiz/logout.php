<?php
session_start();
// Destruimos todas las sesiones
session_destroy();
// La cookie con el color la caducamos
setcookie("color", "" , time() - 3600);
// Volveremos a la página principal
header("Location: index.php");