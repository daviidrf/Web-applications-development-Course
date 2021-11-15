<?php
session_start();
// Si no existe sesion o si es de tipo admin, lo mandaremos al inicio
if (!isset($_SESSION["role"]) || $_SESSION["role"] == "admin") {
    header("Location: index.php");
}
require_once "functions.php";
loadBody();

$user = $_SESSION["name"];

$numTest = 0;
$numAciertos = 0;
$numFallos = 0;
$numPoints = 0;

$statsFile = fopen("points/results.txt", "r");

// Recorreremos todo el fichero
while (!feof($statsFile)) {
    $fileLine =  explode(":", fgets($statsFile));
    // Primero comprobamos que el nombre de usario coincida, cada posicion es un elemento a acumular
    if ($fileLine[0] == $user) {
        $numTest += 1;
        $numAciertos += $fileLine[1];
        $numFallos += $fileLine[2];
        $numPoints += $fileLine[3];
    }
}

echo <<<HER
        <h1 class="text-center">Tus resultados</h1>
        <div class="alert alert-info mt-5" role="alert">
            <p>Número de test realizados por ti: $numTest</p>
            <p>Número de aciertos: $numAciertos</p>
            <p>Número de fallos: $numFallos</p>
            <p>Número de puntos: $numPoints</p>
        </div>
    HER;
?>
</div>

</body>

</html>