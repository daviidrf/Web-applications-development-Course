<?php 
require_once "functions.php";
cabecera("Exercici 4");
?>
    
    <h4>Formulari per validar </h4>
    <body class="container">  
        <form   action="" method="post">  
            <div class="form-row">
                <div class="form-col-md6">
                    <div class="form-group">
                        <h6>Contactos</h6>  
                        <div class="alert alert-warning" role="alert">  *Datos requeridos </div> 
                    </div>
                    <div class="form-group">

                        <label for="nom">Nombre *:</label>  
                        <input type="text" class="form-control" name="nombre" value="<?php  if(isset($_POST["nombre"]))echo $_POST["nombre"];?>"  placeholder="Jose Luis" required />  

                    </div>
                    <div class="form-group"> 

                        <label for="cognoms">Apellidos *:</label>  
                        <input type="text" class="form-control" name="apellidos" value="<?php  if(isset($_POST["apellidos"]))echo $_POST["apellidos"];?>" placeholder="Garcia Garcia" required />  

                    </div>
                    <div class="form-group">

                        <label for="edat">Edad :</label> 
                        <input type="text" class="form-control" name="edad" min="18" max="99" step="1" value="<?php if (isset($_POST['edad'])) echo $_POST['edad']; ?>"/>


                    </div>
                    <div class="form-group">

                        <label for="pes">Peso *:</label> 
                        <input type="text" class="form-control" name="peso" max="500" step="0.01" value="<?php if (isset($_POST['peso'])) echo $_POST['peso']; ?>" required />


                    </div>
                    <div class="form-group">

                        <label for="email">Email *:</label>  
                        <input type="text" class="form-control" name="email" required  value="<?php if (isset($_POST['email'])) echo $_POST['email']; ?>"/>  
                        <small id="emailHelp" class="form-text text-muted"> Formato correcto: name@something.com</small>

                    </div>
                    <div class="form-group">

                        <label for="DNI">DNI *:</label>  
                        <input type="text" class="form-control" name="dni" value="<?php if (isset($_POST['dni'])) echo $_POST['dni']; ?>" placeholder="12345678Z" maxlength="9" size="9" />
                        <small id="emailHelp" class="form-text text-muted"> Formato correcto: 12345678Z </small>


                    </div>
                    <div class="form check">

                        <legend class="col-form-label">Sexo</legend>
                        <div class="form-check-inline"> 
                            <input type="radio" class="form-check-inpu" name="sexo" checked value="Hombre"  /> Hombre <!--me lo invento para ver todos los casos-->
                            <input type="radio" class="form-check-inpu" name="sexo" value="Mujer" /> Mujer
                            <input type="radio" class="form-check-inpu" name="sexo" value="Otros" /> Otros
                       
                        </div>
                    </div>
                    <div class="form check">

                        <legend class="col-form-label">Estado civil</legend>
                        <div class="form-check-inline">
                            <select name="estado">
                                <option value="Soltero" > Soltero </option>
                                <option value="Casado" selected> Casado </option>
                                <option value="Otros"> Otros </option>
                                </select>
                           <!-- <input type="radio" class="form-check-input" name="estado" value="Soltero" /> Soltero
                            <input type="radio"  class="form-check-input" name="estado" value="Casado" /> Casado
                            <input type="radio" class="form-check-input" name="estado" value="Otros" /> Otros-->

                        </div>
                    </div>
                    <div class="form check ">

                        <legend class="col-form-label">Aficiones *</legend>
                        <div class="form-check-inline">
                            <input type="checkbox" class="form-check-input" name="hobbies[]" value="Monta&ntilde;a" /> Monta&ntilde;a <!--atencion con los corchetes de hobbies-->
                            <input type="checkbox" class="form-check-input" name="hobbies[]" value="Cine" /> Cine
                            <input type="checkbox" class="form-check-input" name="hobbies[]" value="Otros" /> Otros
                        </div>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary" type="submit" name="ok">Enviar mensaje</button>  

                    </div>
                </div>
            </div>

        </form> 
<?php

//com recollir els valors donats des d'un formulari

if(isset($_POST["ok"])){//si he clicat al botó, llavors..true

    $mensajes="";
    //filtrado en los campos de texto
    $nombre = filter_input(INPUT_POST,"nombre",FILTER_SANITIZE_SPECIAL_CHARS);
    $apellidos = filter_input(INPUT_POST,"apellidos",FILTER_SANITIZE_SPECIAL_CHARS);
    
    $edad = filter_input(INPUT_POST,"edad",FILTER_SANITIZE_SPECIAL_CHARS);
    $peso = filter_input(INPUT_POST,"peso",FILTER_SANITIZE_SPECIAL_CHARS);
    $dni= filter_input(INPUT_POST,"dni",FILTER_SANITIZE_SPECIAL_CHARS);
    $email=filter_input(INPUT_POST,"email",FILTER_SANITIZE_SPECIAL_CHARS);
   
    if(!filter_var($edad,FILTER_VALIDATE_INT)){
        $mensajes .="<br>La edad no es un entero";
    }
    else{
        $mensajes .="<br>Tu edad es $edad";
    }

    if(!filter_var($peso,FILTER_VALIDATE_FLOAT)){
        $mensajes .="<br>El peso tiene que ser número";
    }
    else{
        $mensajes .="<br>Tu peso es $peso";
    }

    if(!filter_var($email,FILTER_VALIDATE_EMAIL)){
        $mensajes .="<br>El email no tiene el formato esperado";
    }
    else{
        $mensajes .="<br>Tu email es $email";
    }
    echo $mensajes;

    echo checkDNI($dni);

//letras?
echo checkLetters($nombre);
echo checkLetters($apellidos);

//aquellos campos que el usuario no escribe no hace falta filtrar
$sexo = $_POST["sexo"]; //es un radio
$estado = $_POST["estado"]; //es un radio
  //el resto no filtrable
    echo "<br />";
    echo "Sexo: " . $sexo;
    echo "<br />";
    echo "Estado civil: " . $estado;
$hobbies=$_POST["hobbies"];
    echo "<br />";
    echo "Aficiones: ";
    echo "<br />";
    if (isset($hobbies)) {
        //faltaria recorrer las aficiones
        for ($i = 0; $i < count($hobbies); $i++) {

            echo "$hobbies[$i] -";
        }
    } else {

        echo "<ul><li>Te faltaria decir alguna afici&oacute;n</li></ul>";
    }
    
}   
   

/*else{//no he clicat el botó

    echo "No has clicat";
}*/



?>

    
   



</body>
</html>