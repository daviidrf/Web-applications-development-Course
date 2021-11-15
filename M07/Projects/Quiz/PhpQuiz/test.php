<?php
require_once "functions.php";
session_start();
// Si no existe el código no entreremos, volvemos al inicio
if (!isset($_SESSION["code"])) {
    header("Location: index.php");
}
loadBody();
// Recogemos el valor de la variable de sesión código
$code = $_SESSION["code"];
// Abrimos la encuesta en modo lectura, esta se llama igual que el código
$file = fopen("quiz/{$code}.txt", "r");
// Separaremos toda la linea CSV por';', tendríamos lo mismo sin modificar nada de abajo
$questions = explode(";", fgets($file));
$numQuestion = 0;
$alphabet = range('A', 'Z');
?>
<form method="POST" action="results.php">
    <?php
    echo '<h2 class="mt-5 mb-4">' . $questions[0] . '</h2>';
    for ($i = 1; $i < sizeof($questions); $i++) {
        // Las encuestas son impares, en cambio las respuestas son pares
        if ($i % 2 != 0) {
            echo <<<HER
                <p class="form-text">Selecciona la respuesta correcta</p>
                <p class="fs-5">$questions[$i]</p>
                HER;
        } else {
            $answers = explode(':', $questions[$i]);
            for ($j = 0; $j < sizeof($answers); $j++) {
                echo <<<HER
                    <div class="form-check">
                    <input class="form-check-input" type="radio" name="$numQuestion" value="$numQuestion$alphabet[$j]">
                    <label class="form-check-label" for="flexRadioDefault1">
                    $answers[$j]
                    </label>
                    </div>
                    HER;
            }
            $numQuestion++;
            echo "<br>";
        }
    }
    ?>
    <div class="col-12">
        <input type="submit" value="Check results" class="btn btn-primary" name="results">
    </div>
</form>
</div>

</body>

</html>