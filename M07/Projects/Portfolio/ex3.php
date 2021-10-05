<?php
require_once 'functions.php';
header_nav("Exercici 3");
?>
<div class="mx-auto" style="text-align: center;margin-top:8rem;" id="formulario">
    <h1>VERIFICAR PALINDROMO</h1>
    <form action="ex3.php" method="post" style="margin-bottom: 2rem;">
        <label style="margin-bottom: 10px;">Escribe una frase o palabra :</label>
        <input type="text" name="quote" class="form-control col-6 mx-auto" placeholder="Quote" style="width: 15rem;">
        <input type="submit" name="verificar" value="Verificar" class="btn btn-primary" style="margin-top: 10px;">
    </form>

    <?php
    $quote = $_POST['quote'];
    $quote = str_replace(
        array('á', 'Á', 'é', 'É', 'í', 'Í', 'ó', 'Ó', 'ú', 'Ú', ',', '.', '?', '¿', '!', '¡', ' '),
        array('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U', '', '', '', '', '', '', ''),
        $quote
    );
    $quote = strtolower($quote);
    $reversedQuote = strrev($quote);

    if ($quote == $reversedQuote) {
        echo "ES PALINDROMO!";
    } else {
        echo "NO ES PALINDROMO!";
    }
    ?>
</div>
<?php
    jvCharge();
?>
</body>

</html>