<?php
require_once 'functions.php';
require_once 'pdf/fpdf.php';
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

    for ($i = 0; $i < sizeof($respuestasCorrectas); $i++) {
        $cont++;
        if (isset($formAnswers[$i + 1])) {
            if ($cont . $formAnswers[$i + 1] == $respuestasCorrectas[$i]) {
                $correctas++;
            } else {
                $fallos++;
            }
        } else {
            $fallos++;
        }
    }
    echo <<<HER
    <div id="resultado">
        <div id="correctas"><h3>Respuestas correctas : $correctas</h3></div>
        <div id="fallos"><h3>Respuestas incorrectas : $fallos</h3></div>
    </div>
    <form action="generatePDF.php" method="post">
        <input type="submit" name="convertir" value="Generar PDF" class="btn btn-primary" style="margin-top: 10px;">
        <div style="display: none;">
            <input type="text" name="correctas" value="$correctas" class="btn btn-primary">
            <input type="text" name="fallos" value="$fallos" class="btn btn-primary">
        </div>

    </form>
    HER;


    ?>

</div>
<?php
jvCharge();
?>
</body>

</html>