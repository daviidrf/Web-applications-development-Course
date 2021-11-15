<?php
session_start();
// En el caso de que haya sesión abierta, lo redirigimos a la principal
if (isset($_SESSION["role"])) {
    header("Location: index.php");
}
require_once "functions.php";
loadBody();
?>
<div class="row d-flex justify-content-center align-items-center min-vh-100">
    <form class="row g-3" method="POST">
        <h1 class="text-center">Log in</h1>
        <div class="col-md-6">
            <label class="form-label">User name</label>
            <input type="text" class="form-control" name="user" value="<?php if (isset($_POST['user'])) echo $_POST['user']; ?>">
        </div>
        <div class="col-md-6">
            <label class="form-label">Password</label>
            <input type="password" class="form-control" name="pass" value="<?php if (isset($_POST['pass'])) echo $_POST['pass']; ?>">
        </div>
        <div class="col-12">
            <input type="submit" name="signin" value="Sign in" class="btn btn-primary"></input>
        </div>
    </form>
</div>

<?php
if (isset($_POST["signin"])) {
    $name = filter_input(INPUT_POST, "user", FILTER_SANITIZE_SPECIAL_CHARS);
    $pass = filter_input(INPUT_POST, "pass", FILTER_SANITIZE_SPECIAL_CHARS);
    // Abrimos el fichero donde están todos los usuarios, en modo lectura
    $file = fopen("users/users.txt", "r");
    $exists = false;
    while (!feof($file)) {
        $userFile = explode(":", fgets($file));
        if ($name == $userFile[0] && $pass == $userFile[1]) {
            $exists = true;
            $_SESSION["name"] =  $userFile[0];
            $_SESSION["role"] = $userFile[7];
            // Dependiendo del rol asignaremos un color diferente a la barra de navegación
            if ($_SESSION["role"] == "basic") {
                $color = "bg-success";
            } elseif ($_SESSION["role"] == "admin") {
                $color = "bg-dark";
            }
            // Creamos la cookie con el valor, solo durará lo que dure la sesión
            setcookie("color", $color);
            break;
        }
    }
    // Si todo está correcto lo redirigiremos a la página principal, sino mostramos los errores
    if ($exists) {
        header("Location: index.php");
    } else {
        echo "Incorrect user name or passoword";
    }
}
?>

</div>

</body>

</html>