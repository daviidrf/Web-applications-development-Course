<?php
//un archivo lleno de funciones útiles
//de código que se repita

function cabecera($title){
    //notacion heredoc
echo <<<HER
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--Bootstrap: CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <!--Bootstrap: JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script> 

    <title>$title</title>
</head>
<body>
    <a href="index.php">Home</a> |  
    <a href="ex1.php">Exercici 1</a> |
    <a href="ex2.php">Exercici 2</a> |
    <a href="ex3.php">Exercici 3</a> |
    <a href="ex4.php">Exercici 4</a>
HER;
}



        function checkLetters($value) {

            if (preg_match("/[0-9]/", $value)) {
                $value = "<br>En el campo $value sólo letras y espacios en blanco!";
            }else{
                $value="<br>El valor es $value";
            }
            return $value;
        }
        function checkDNI($dni){
            if(strlen($dni)!=9){
                $dni="<br>ERROR EN EL FORMAT DEL DNI!";
            }
            else{
                $numero= substr($dni, 0, 8);
                $lletra=substr($dni, 8, 9);
                if(!filter_var($numero, FILTER_VALIDATE_INT) ||  !ctype_alpha($lletra)){
                        $dni="<br>ERROR EN EL FORMAT DEL DNI!";
                }else{
                    //comprovacio vertadera del dni
                    $lletresDNI="TRWAGMYFPDXBNJZSQVHLCKE";
                    $lletra=strtoupper($lletra);
                    $residu=$numero%23;
                    if($lletresDNI[$residu]!=$lletra){
                        $dni="<br>ERROR EN EL FORMAT DEL DNI!";
                    }
                    else{
                        $dni="<br>Tu dni es $dni";
                    }
                  return $dni;
                }
                
                
            }
        }     









?>