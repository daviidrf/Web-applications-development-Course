<?php
require_once 'functions.php';
header_nav("RESULTADO");
?>
<div class="mx-auto" style="text-align: center;margin-top:8rem;" id="formulario">
    <?php
    $arrayRespuestas = chargeArrayRespuestas();
    $respuestasCorrectas = explode(';', $arrayRespuestas[$_POST["code"]]);
    $cont = 0;
    $correctas = 0;
    $fallos = 0;
    $formAnswers = $_POST;
    $correctFrase = "Has acertado " . $correctas . " preguntas";
    $fallosFrase =  "Has fallado " . $fallos . " preguntas";

    for ($i = 0; $i < sizeof($respuestasCorrectas); $i++) {
        $cont++;
        if (isset($formAnswers[$i + 1])) {
            if ($cont . $formAnswers[$i + 1] == $respuestasCorrectas[$i]) {
                $correctas++;
                $correctFrase = $correctFrase . " , " . ($i + 1);
                $correctFrase = substr_replace($correctFrase, $correctas, 13, 1);
            } else {
                $fallos++;
                $fallosFrase = $fallosFrase . " , " . ($i + 1);
                $fallosFrase = substr_replace($fallosFrase, $fallos, 12, 1);
            }
        } else {
            $fallos++;
            $fallosFrase = $fallosFrase . " , " . ($i + 1);
            $fallosFrase = substr_replace($fallosFrase, $fallos, 12, 1);
        }
    }
    echo <<<HER
    <div id="resultado">
        <div id="correctas"><h3>$correctFrase</h3></div>
        <div id="fallos"><h3>$fallosFrase</h3></div>
    </div>
    <form action="generatePDF.php" method="post">
        <div style="display: none;">
            <input type="text" name="correctas" value="$correctFrase">
            <input type="text" name="fallos" value="$fallosFrase">
        </div>
        <input type="submit" name="convertir" value="Generar PDF" class="btn btn-primary" style="margin-top: 10px;">
    </form>
    HER;
    ?>
</div>
<?php
jvCharge();
?>
</body>

</html>