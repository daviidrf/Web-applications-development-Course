<?php
session_start();
require_once "functions.php";
loadBody()
?>
<div class="row d-flex justify-content-center align-items-center min-vh-100">
    <!-- Mensaje de bienvenida para el usuario, en el caso de que haya sesión abierta saludará al usuario -->
    <h1 class="text-center">¡Bienvenido<?php if (isset($_SESSION["name"])) echo " " . $_SESSION["name"] ?>!</h1>
</div>
</div>

</body>

</html>