<!--FONT per a fer el navbar: https://getbootstrap.com/docs/5.1/components/navbar/#supported-content -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
  <a class="navbar-brand" href="index.php">
    <img src="view/img/icono.png" alt="icono de la pagina web" width="100px">
    Home
  </a>
   
   <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
   </button>
   <div class="collapse navbar-collapse" id="navbarNav">
   <ul class="navbar-nav">
    <?php
    if(isset($_SESSION["login"])){

      echo <<<HER
       <li class="nav-item"><a class="nav-link"  aria-current="page" href="index.php?menu=user&option=list" class="text-light">List all users</a></li>
      <li class="nav-item"><a class="nav-link"  aria-current="page" href="index.php?menu=user&option=formAdd" class="text-light">Add a user</a></li>
      <li class="nav-item"><a class="nav-link"  aria-current="page" href="index.php?menu=user&option=formDel" class="text-light">Delete a user</a></li>
  


HER;
    }else{
      echo '<li class="nav-item"><a class="nav-link"  aria-current="page"  href="index.php?menu=user&option=formLogin" class="text-light">Login</a></li>';

    }
    echo "</div></ul></nav>";
   ?>
