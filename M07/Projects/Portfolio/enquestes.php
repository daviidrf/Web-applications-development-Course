<?php
require_once 'functions.php';
header_nav("PT AVALUABLE 1");
?>
<div class="mx-auto" style="text-align: center;margin-top:8rem;" id="formulario">
    <!-- <h1>GENERAR SEMANAS</h1> -->
    <form action="enquestes.php" method="post" style="margin-bottom: 2rem;">
        <label style="margin-bottom: 10px;">Escribe un código :</label>
        <input type="text" name="code" class="form-control col-6" placeholder="Code" style="width: 15rem; margin: 0 auto;">
        <input type="submit" name="validar" value="Validar" class="btn btn-primary" style="margin-top: 10px;">
    </form>

    <?php
    // /^[A-Z][a-z0-9]{4,8}$/
    $codePattern =  '/^[A-Za-z0-9]{4,10}$/';
    $arrayCodigos = ["dA7vId", "j0RdI", "V1n1C1Us"];
    $arrayEncuestas = array(
        "dA7vId" => "Enquesta de Genshin Impact; 
                            1- Quants elements hi ha en el joc?;7:3:9:6;
                            2- Quin és el nom de la primera regió del joc?;Liyue:Inazuma:Mondstadt:Sumeru;
                            3- Com es diu l'arcont de Liyue?;Venti:Zhongli:Baal:Diluc;
                            4- De quin element és el protagonista a l'inici del joc?;Anemo:Hydro:Ningún:Geo",
        "j0RdI"  => "Enquesta de Star Wars;
                            1- Quantes pel·lícules <Live Action> hi ha actualment?;3:11:9:6;
                            2- Quin d'aquests personatges va traicionar a la República?;Obi Wan Kenobi:Mace Windu:Anakin Skywalker:Luke Skywalker;
                            3- En quina pel·lícula mor Han Solo?;La Venganza de los Sith:El Imperio contraataca:La Amenaza Fantasma:El Despertar de la Fuerza;
                            4- Quin d'aquests personatges forma part de l'Imperi galàctic?;Thrawn:Lando Calrissian:Hux:Capità Rex"
    );
    $arrayRespuestas = array(
        "dA7vId" => "1a;2c;3b;4c",
        "j0RdI"  => "1b;2c;3d;4a"
    );

    $introducedCode = filter_input(INPUT_POST, "code", FILTER_SANITIZE_SPECIAL_CHARS);

    if (preg_match($codePattern, $introducedCode)) {
        if (array_key_exists($introducedCode, $arrayEncuestas)) {
            //echo "Tu codigo existe";
            $preguntas = explode(';',$arrayEncuestas[$introducedCode]);
            for ($i=1; $i < sizeof($preguntas) ; $i++) { 
                if($i%2 != 0){
                    echo $preguntas[$i] . "<br>";
                }
                else{
                    $respuestas = explode(':',$preguntas[$i]);
                    for ($j=0; $j < sizeof($respuestas); $j++) { 
                        echo $respuestas[$j] . "<br>";
                    }
                    echo "<br>";
                }
            }
            echo <<<HER

HER;
        } else {
            echo "Tu código es valido pero no existe!";
        }
    } else {
        echo "Codigo invalido";
    }
    ?>


    <div id="resultado">

    </div>
</div>

<!--PEDIMOS LOS JAVASCRIPTS DE "functions.php"-->
<?php
jvCharge();
?>

</body>

</html>