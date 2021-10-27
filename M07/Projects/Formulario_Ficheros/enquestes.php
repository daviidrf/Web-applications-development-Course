<?php
require_once 'functions.php';
header_nav("ENCUESTA");
?>
<div class="mx-auto" style="text-align: center;margin-top:8rem;" id="formulario">
    <?php
    $codePattern =  '/^[A-Za-z0-9]{4,10}$/';
    $arrayLetras = chargeArrayLetras();
    $name = 0;
    $introducedCode = filter_input(INPUT_POST, "code", FILTER_SANITIZE_SPECIAL_CHARS);

    if (preg_match($codePattern, $introducedCode)) {
        if (file_exists("recursos/preguntas/" . $introducedCode . ".txt")) {
            $encuestasFile = fopen("recursos/preguntas/" . $introducedCode . ".txt", "r");
            $preguntas = explode(';', fgets($encuestasFile));

            echo <<<HER
                <form action="checkAnswers.php" method="post" style="text-align:left; margin-left: 10rem;">
            HER;
            for ($i = 1; $i < sizeof($preguntas); $i++) {
                if ($i % 2 != 0) {
                    $name++;
                    echo <<<HER
                        <h5>$preguntas[$i]</h5>
                    HER;
                } else {
                    $respuestas = explode(':', $preguntas[$i]);
                    for ($j = 0; $j < sizeof($respuestas); $j++) {
                        echo <<<HER
                            <input type="radio" class="options" name="$name" value="$arrayLetras[$j]">
                            <label for="$arrayLetras[$j]">$respuestas[$j]</label><br>
                        HER;
                    }
                    echo "<br>";
                }
            }
            echo <<<HER
                <input type="submit" name="validar" value="Validar" class="btn btn-primary" style="margin-top: 10px;">
                <div style="display: none;">
                    <input type="text" name="code" value="$introducedCode" class="btn btn-primary">
                </div>
                </form>
            HER;
        } else {
            echo <<<HER
            <a href="index.php"><button type="submit" class="btn btn-primary">Volver</button></a>
            <br><p style="margin-top: 10px">Tu código es valido pero no existe!</p>
            HER;
        }
    } else {
        echo <<<HER
            <a href="index.php"><button type="submit" class="btn btn-primary">Volver</button></a>
            <br><p style="margin-top: 10px">Codigo invalido!</p>
            HER;
    }
    ?>

</div>

<?php
jvCharge();
?>

</body>

</html>