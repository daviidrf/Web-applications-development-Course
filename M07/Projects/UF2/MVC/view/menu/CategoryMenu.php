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
   <li class="nav-item"><a class="nav-link"  aria-current="page" href="index.php?menu=category&option=list" class="gris">List all categories</a></li>
   <li class="nav-item"><a class="nav-link"  aria-current="page" href="index.php?menu=category&option=searchName" class="gris">Search category by name</a></li>
   <li class="nav-item"><a class="nav-link"  aria-current="page"href="index.php?menu=category&option=formAdd" class="gris">Add category</a></li>
   <li class="nav-item"><a class="nav-link"  aria-current="page" href="index.php?menu=category&option=formDel" class="gris">Delete category</a></li>
  </ul>
  </div>
</nav>
