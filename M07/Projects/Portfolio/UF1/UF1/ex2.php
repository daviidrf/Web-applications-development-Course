<?php 
require_once "functions.php";
cabecera("Exercici 2");
?>
    <p>
        EXERCICI 2: Dir si un DNI és vertader o fals
    </p>
    <form method="get" action="#">
      <div class="form-group">
        <label for="num">Introdueix un DNI:</label>
        <input type="text" class="form-control" name="dni" placeholder="12345678Z">
      </div>
      
      <input type="submit" name="click" value="Comprobar" class="btn btn-dark"></button>
    </form>

    <?php
    //la primera vegada $_GET["dni"] no té res de res --> notice

    //comprobo que li hagi donat al botó
    if(isset($_GET["click"])){ //isset comproba si existeix o no contingut
       
      $dni=$_GET["dni"]; 
       //$dni=filter_input(INPUT_GET,'dni',FILTER_SANITIZE_SPECIAL_CHARS);
       //strlen: mira longitud
       //ctype_alpha: mira si és lletra el darrer caracter de $dni
       //is_numeric: mira si hi ha només numeros abans de la lletra final
      if(strlen($dni)!=9 || !ctype_alpha(substr($dni,-1)) || !is_numeric(substr($dni, 0,-1))){
        echo "El format no és el correcte";
      }else{//he comprovat que compleix el format
        $num=substr($dni, 0,-1);//agafo la part numèrica del dni
        $lletra=substr($dni,-1);//agafo la lletra
       
        $lletra=strtoupper($lletra);//passo a majuscules

        $residu=$num%23;//agafo el residu
        $lletras="TRWAGMYFPDXBNJZSQVHLCKE";//té totes les lletres en ordre
        
        if(strcmp($lletra,$lletras[$residu])!==0){
          echo "El DNI és fals";
        }else{
          echo "El DNI és bo";
        }
      }

      
        
       
    
    }




?>
</body>
</html>