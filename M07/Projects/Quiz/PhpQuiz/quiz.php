<?php
session_start();
// Si no existe rol o es de tipo admin lo mandaremos al inicio
if (!isset($_SESSION["role"]) || $_SESSION["role"] == "admin") {
    header("Location: index.php");
}
require_once "functions.php";
loadBody()
?>
<form class="row g-3 mt-5" method="POST" action="quiz.php">
    <div class="col-md-6">
        <label for="code" class="form-label"><strong>Input your code:</strong></label>
        <input type="text" class="form-control" value="<?php if (isset($_POST['code'])) echo $_POST['code']; ?>" name="code" placeholder="Introduce your code">
    </div>
    <div class="col-12">
        <button type="submit" class="btn btn-primary">Let's go!</button>
    </div>
</form>
<br>
<?php
if (isset($_POST["code"])) {
    $code = filter_input(INPUT_POST, "code", FILTER_SANITIZE_SPECIAL_CHARS);
    // Comprobamos que el código tenga un patrón valido
    if (preg_match('/^[a-zA-Z0-9]{4,10}+$/', $code)) {
        // Antes redirigirlo, debemos de comprobar que exista una encuesta con este código
        // En nuestro caso creamos un fichero por encuenta, si existe un fichero 
        // con ese nombre crearemos la variable de sesión
        if (file_exists("quiz/{$code}.txt")) {
            // Variable de sesión con el codigo
            $_SESSION["code"] = $code;
            header("Location: test.php");
        } else {
            echo <<<HER
                <div class="alert alert-danger" role="alert">{$code} doesn't exist in our quiz.</div>
            HER;
        }
    } else {
        echo <<<HER
                <div class="alert alert-danger" role="alert">{$code} has invalid format.</div>
        HER;
    }
}
?>
</div>

</body>

</html>