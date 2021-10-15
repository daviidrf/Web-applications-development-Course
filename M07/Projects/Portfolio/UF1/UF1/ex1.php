<?php 
require_once "functions.php";
cabecera("Exercici 1");
?>
    
    <h1>Tabla de multiplicar </h1>
    <!--Formulario: action-> a qué archivo envio el formulario, 
    method->cómo lo envio   -->
    
    
    <!--Bootstrap -->
<form action="index.php" method="get">
  
  <div class="row">
    <label for="numero" class="form-label col-6">Dona'm un numero entre 0 i 20</label>
    <input type="text" class="form-control col-6" name="numero" id="numero">
  </div>
  
  <button type="submit" class="btn btn-primary row" name="calcula">Calcula la taula</button>
</form>







     <?php

     //$numero=8;
$numero=$_GET["numero"];//si envio el formulari per get
//$numero=filter_input(INPUT_GET,"numero", FILTER_SANITIZE_SPECIAL_CHARS);
//$numero=$_POST["numero"];//si envio el formulari per post
//$numero=$_REQUEST["numero"];
echo $numero;
     if($numero >0 && $numero <20){ 
         echo "Tabla del $numero"; 
         echo "<table class='table table-bordered'>
         <tr>
         <th>X</th>
         <th>1</th>
         <th>2</th>
         <th>3</th>
         <th>4</th>
         <th>5</th>
         <th>6</th>
         <th>7</th>
         <th>8</th>
         <th>9</th>
         <th>10</th>
         </tr>";
        //dinamica
        for($i=1;$i<=$numero;$i++){
            
            echo "<tr>";
            echo "<td> <b>$i</b> </td>";

            for($j=1;$j<=10;$j++){
                echo "<td>";
                echo $i*$j;
                echo "</td>";
            }
            echo "</tr>";
        }
        echo "</table>";
     }else{
         echo "El numero $numero no es el correcto";
     }


?>
</body>
</html>