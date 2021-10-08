<!--PEDIMOS EL HEAD Y EL NAVBAR DE "functions.php"-->
<?php
require_once 'functions.php';
header_nav("Exercici 4");
//if(isset($_POST["variable"]))
?>

<div class="mx-auto" style="text-align: center;margin-top:8rem;" id="formulario">
    <h1>FORMULARIO</h1>
    <form action="ex4.php" method="post" style="margin-bottom: 2rem;">
        <label style="margin-bottom: 10px;">Username* :</label>
        <input type="text" name="username" class="form-control col-3 forD" placeholder="Username" style="width: 15rem; margin: 0 auto;" required>
        <br>
        <!--USERNAME-->
        <label style="margin-bottom: 10px;">Name* :</label>
        <input type="text" name="nombre" class="form-control col-3 forD" placeholder="Nombre" style="width: 15rem; margin: 0 auto;" required>
        <br>
        <!--NOMBRE-->
        <label style="margin-bottom: 10px;">Age* :</label>
        <input type="text" name="edad" class="form-control col-3 forD" placeholder="Edad" style="width: 15rem; margin: 0 auto;" required>
        <br>
        <!--PESO-->
        <label style="margin-bottom: 10px;">Weight* :</label>
        <input type="text" name="peso" class="form-control col-3" placeholder="Peso" style="width: 15rem; margin: 0 auto;" required>
        <br>
        <!--GENERO-->
        <label style="margin-bottom: 10px;">Gender :</label><br>
        <label for="html">Male</label>
        <input type="radio" id="html" name="sexo" value="HTML" class="col-3" style="width: 2rem; margin: 0 auto;">
        <label for="css" style="margin-left: 10px;">Female</label>
        <input type="radio" id="css" name="sexo" value="CSS" class="col-3" style="width: 2rem; margin: 0 auto;">
        <label for="css" style="margin-left: 10px;">Other</label>
        <input type="radio" id="css" name="sexo" value="CSS" class="col-3" style="width: 2rem; margin: 0 auto;">
        <br>
        <br><br>
        <!--ESTADO CIVIL-->
        <label style="margin-bottom: 10px;">Escribe tu estado civil :</label>
        <input type="text" name="estado" class="form-control col-3 forD" placeholder="Estado Civil" style="width: 15rem; margin: 0 auto;">
        <br>
        <!--HOBBIES-->
        <label style="margin-bottom: 10px;">Hobbies :</label><br>

        <label style="margin-bottom: 10px;">Deporte :</label>
        <input type="checkbox" name="aficiones" class="forD" placeholder="Aficiones" style="width: 2rem; margin: 0 auto;">
        
        <label style="margin-bottom: 10px;">Cine :</label>
        <input type="checkbox" name="aficiones" class="forD" placeholder="Aficiones" style="width: 2rem; margin: 0 auto;">
        
        <label style="margin-bottom: 10px;">Juegos :</label>
        <input type="checkbox" name="aficiones" class="forD" placeholder="Aficiones" style="width: 2rem; margin: 0 auto;">
        <br><br>
        <!--EMAIL-->
        <label style="margin-bottom: 10px;">E-mail* :</label>
        <input type="email" name="correo" class="form-control col-6 forD" placeholder="Correo Electronico" style="width: 15rem; margin: 0 auto;" required>

        <button type="submit" name="enviar" value="Enviar" class="btn btn-primary" style="margin-top: 10px;">Enviar</button>
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