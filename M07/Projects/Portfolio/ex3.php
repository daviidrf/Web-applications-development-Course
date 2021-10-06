<!--PEDIMOS EL HEAD Y EL NAVBAR DE "functions.php"-->
<?php
require_once 'functions.php';
header_nav("Exercici 3");
?>

<div class="mx-auto" style="text-align: center;margin-top:8rem;" id="formulario">
    <h1>VERIFICAR PALINDROMO</h1>
    <form action="ex3.php" method="post" style="margin-bottom: 2rem;">
        <label style="margin-bottom: 10px;">Escribe una frase o palabra :</label>
        <input type="text" name="quote" class="form-control col-6" placeholder="Quote" style="width: 15rem; margin: 0 auto;">
        <input type="submit" name="verificar" value="Verificar" class="btn btn-primary" style="margin-top: 10px;">
    </form>

    <!--CALCULAMOS SI EL STRING PASADO POR POST ES PALINDROMO-->
    <?php
    $quote = $_POST['quote'];

    //CON "str_replace" LIMPIAMOS EL STRING DE ACENTOS Y SIGNOS DE PUNTUACIÓN.
    $quote = str_replace(
        array('á', 'Á', 'é', 'É', 'í', 'Í', 'ó', 'Ó', 'ú', 'Ú', ',', '.', '?', '¿', '!', '¡', ' '),
        array('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U', '', '', '', '', '', '', ''),
        $quote
    );

    //CON "strtolower" PASAMOS A MINÚSCULA EL STRING.
    $quote = strtolower($quote);

    //CON "strrev" INVERTIMOS EL ORDEN DE LOS CARÁCTERES DEL STRING.
    $reversedQuote = strrev($quote);

    if ($quote == $reversedQuote) {
        echo "ES PALINDROMO!";
    } else {
        echo "NO ES PALINDROMO!";
    }
    ?>
</div>

<!--PEDIMOS LOS JAVASCRIPTS DE "functions.php"-->
<?php
    jvCharge();
?>

</body>

</html>