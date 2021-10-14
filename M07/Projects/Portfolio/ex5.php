<!--PEDIMOS EL HEAD Y EL NAVBAR DE "functions.php"-->
<?php
require_once 'functions.php';
header_nav("Exercici 3");
?>

<div class="mx-auto" style="text-align: center;margin-top:8rem;" id="formulario">
    <h1>GENERAR SEMANAS</h1>
    <form action="ex5.php" method="post" style="margin-bottom: 2rem;">
        <label style="margin-bottom: 10px;">Escribe un número entero :</label>
        <input type="text" name="number" class="form-control col-6" placeholder="Número" style="width: 15rem; margin: 0 auto;">
        <input type="submit" name="generar" value="Generar" class="btn btn-primary" style="margin-top: 10px;">
    </form>

    <!--CALCULAMOS SI EL STRING PASADO POR POST ES PALINDROMO-->
    <?php
    $dias = ["Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"];
    $number = filter_input(INPUT_POST, "number", FILTER_SANITIZE_SPECIAL_CHARS);
    if (filter_var($number, FILTER_VALIDATE_INT)) {
        if ($number >= 1 && $number <= 8) { ?>
            <form action="ex5.php#resultado" method="post" style="margin-bottom: 2rem;">
                <table border="3" class="table table-bordered mb-5 align-middle table-hover" id="dtabla">
                    <tr>
                        <th style="text-align: center;">X</th>
                        <?php
                        for ($i = 0; $i < sizeof($dias); $i++) {
                            echo "<th>" . $dias[$i] . "</th>";
                        }
                        ?>
                    </tr>
                    <tr>
                        <?php
                        for ($i = 0; $i < $number; $i++) {
                            echo "<tr>";
                            echo "<th>Semana " . $i + 1 . "</th>";
                            for ($j = 0; $j < sizeof($dias); $j++) {
                                echo <<<HER
                            <td><input type="checkbox" class="form-check-input" name="seleccion[]" value="$dias[$j]" /></td>
HER;
                            }
                            echo "</tr>";
                        }
                        ?>
                    </tr>
                </table>

                <input type="submit" name="seleccionar" value="Seleccionar" class="btn btn-primary" style="margin-top: 10px;">
            </form>


    <?php
            $seleccion = $_POST["seleccion"];
            printf($seleccion);

            if (isset($seleccion)) {
                for ($i = 0; $i < sizeof($seleccion); $i++) {

                    echo "$seleccion[$i] -";
                }
            } else {

                echo "<ul><li>No has seleccionado ningún día.</li></ul>";
            }
        } else {
            echo "Numero en rango incorrecto!";
        }
    } else {
        echo "Numero en formato incorrecto!";
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