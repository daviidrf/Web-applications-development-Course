<?php

function header_nav($title)
{
    //HER notacion especial php en lugar de la comillas
    //simples para que las variables funcionen.
    echo <<<HER
    <!DOCTYPE html>
    <html lang="es">
    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>$title</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
      <link href="styles.css" rel="stylesheet">
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
    </head>
    <body>

    <div class="collapse" id="navbarToggleExternalContent">
  <div class="bg-dark p-4">
    <a class="nav-link" href="index.php">Home</a>
    <a class="nav-link" href="ex1.php">Exercici 1</a>
    <a class="nav-link" href="ex2.php">Exercici 2</a>
    <a class="nav-link" href="ex3.php">Exercici 3</a>
  </div>
</div>
<nav class="navbar navbar-dark bg-dark">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
  </div>
</nav>
HER;
//CUANDO SE CIERRA QUE NO HAYA ESPACIOS DELANTE!
}
