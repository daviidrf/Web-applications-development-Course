<!--PEDIMOS EL HEAD Y EL NAVBAR DE "functions.php"-->
<?php
require_once 'functions.php';
header_nav("Exercici 4");
?>

<div class="mx-auto" style="text-align: center;margin-top:8rem;" id="formulario">
    <h1>VERIFICAR PALINDROMO</h1>
    <form action="ex4.php" method="post" style="margin-bottom: 2rem;">
        <label style="margin-bottom: 10px;">Escribe tu username :</label>
        <input type="text" name="username" class="form-control col-3 forD" placeholder="Username" style="width: 15rem; margin: 0 auto;">
        <br>
        <label style="margin-bottom: 10px;">Escribe tu nombre :</label>
        <input type="text" name="nombre" class="form-control col-3 forD" placeholder="Nombre" style="width: 15rem; margin: 0 auto;">
        <br>
        <label style="margin-bottom: 10px;">Escribe tu edad :</label>
        <input type="text" name="edad" class="form-control col-3 forD" placeholder="Edad" style="width: 15rem; margin: 0 auto;">
        <br>
        <label style="margin-bottom: 10px;">Escribe tu peso :</label>
        <input type="text" name="peso" class="form-control col-3" placeholder="Peso" style="width: 15rem; margin: 0 auto;">
        <br>
        <label style="margin-bottom: 10px;">Escribe tu sexo :</label><br>
        <input type="radio" id="html" name="sexo" value="HTML" class="form-control col-3" style="width: 15rem; margin: 0 auto;">
        <label for="html">MALE</label><br><br>
        <input type="radio" id="css" name="sexo" value="CSS" class="form-control col-3" style="width: 15rem; margin: 0 auto;">
        <label for="css">FEMALE</label><br>
        <br>
        <label style="margin-bottom: 10px;">Escribe tu estado civil :</label>
        <input type="text" name="estado" class="form-control col-3 forD" placeholder="Estado Civil" style="width: 15rem; margin: 0 auto;">
        <br>
        <label style="margin-bottom: 10px;">Marca aficiones que tengas de esta lista :</label>
        <input type="checkbox" name="aficiones" class="form-control col-3 forD" placeholder="Aficiones" style="width: 15rem; margin: 0 auto;">
        <br>
        <label style="margin-bottom: 10px;">Escribe tu correo electronico :</label>
        <input type="email" name="correo" class="form-control col-6 forD" placeholder="Correo Electronico" style="width: 15rem; margin: 0 auto;">

        <input type="submit" name="enviar" value="Enviar" class="btn btn-primary" style="margin-top: 10px;">
    </form>

    <!--CALCULAMOS SI EL STRING PASADO POR POST ES PALINDROMO-->
    <?php
    $username = $_POST['username'];
    // $name = $_POST['nombre'];
    // $age = $_POST['edad'];
    // $weight = $_POST['peso'];
    // $gender = $_POST['sexo'];
    // $status = $_POST['estado'];
    // $hobbies = $_POST['aficiones'];
    // $mail = $_POST['correo'];

    
    ?>
</div>

<!--PEDIMOS LOS JAVASCRIPTS DE "functions.php"-->
<?php
jvCharge();
?>

</body>

</html>