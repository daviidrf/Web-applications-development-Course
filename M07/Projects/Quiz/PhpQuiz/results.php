<?php
session_start();
require_once "functions.php";
loadBody();
// Si no existe código de encuesta o en el caso de acceda copiando la ruta, 
// tanto results como save no existirán, lo redirigiremos a la principal
if (!isset($_SESSION["code"]) || !isset($_POST["results"]) && !isset($_POST["save"])) {
    header("Location: index.php");
}
// Como ambos botones están en la misma página y para no perder la información 
// debemos de comprobar por donde hemos llegado aquí
if (isset($_POST["results"])) {
    $quiz = fopen("answers/{$_SESSION["code"]}.txt", "r");
    $solutions = fgets($quiz);
    $solutions = explode(':', $solutions);
    $points  = 0;
    $ok = 0;
    $mssgOk = "";
    $mssgFail = "";
    for ($i = 0; $i < sizeof($solutions); $i++) {
        if (isset($_POST[$i])) {
            if ($solutions[$i] == $_POST[$i]) {
                $ok++;
                $mssgOk .= $i + 1 . ", ";
            } else {
                $mssgFail .= $i + 1 . ", ";
            }
        } else {
            $mssgFail .= $i + 1 . ", ";
        }
    }
    // Si hemos accedido desde quiz.php tendremos los resultados, los almacenaremos todos en sesiones, 
    // así no hará falta pasarlos en oculto desde el form 
    $_SESSION["mssgOk"] = "You did $ok good from " . sizeof($solutions) . " questions: $mssgOk";
    $_SESSION["mssgFail"] = "You failed " . sizeof($solutions) - $ok .  " questions: $mssgFail";
    $_SESSION["points"] = $ok * 10;
    $_SESSION["ok"] = $ok;
    $_SESSION["fail"] = sizeof($solutions) - $ok;
} elseif (isset($_POST["save"])) {
    // Si pulsamos a guardar desde el segun form, guardaremos los datos obtenidos en el fichero de estadisticas de usuarios
    // Como tenemos los datos en sesiones no es más fácil acceder a ellos
    $userStatistics =  $_SESSION["name"] . ":" . $_SESSION["ok"] . ":" . $_SESSION["fail"] . ":" .  $_SESSION["points"];
    $file = fopen("points/results.txt", "a+");
    // Asegurarnos de que cuando añada haga salto de línea
    fwrite($file, "$userStatistics\n");
    fclose($file);
    // Mostramos que ha se han guardado correctamente
    echo <<<HER
        <div class="alert alert-success mt-5" role="alert">Data saved 😁!</div>
    HER;
}

echo <<<EOT
        <div class="alert alert-success mt-5" role="alert">{$_SESSION['mssgOk']}</div>
        <div class="alert alert-danger" role="alert">{$_SESSION['mssgFail']}</div>
        <div class="alert alert-warning" role="alert">You got {$_SESSION['ok']} points</div>
        <form method="POST" action="generatePDF.php">
        <div class="col-12 text-center">
            <input type="submit" value="Generate PDF" class="btn btn-success" name="inform">
        </div>
        </form>
        <form method="POST" class="mt-1">
        <div class="col-12 text-center">
           <input type="submit" value="Save results" class="btn btn-primary" name="save">
        </div>
        </form>
    EOT;
?>

</div>

</body>

</html>