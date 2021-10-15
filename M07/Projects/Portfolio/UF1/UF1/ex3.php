<?php 
require_once "functions.php";
cabecera("Exercici 3");
?>

    <p>
        EXERCICI 3: Dir si una frase és palíndroma (tenint en compte accents, majúscules i signes de puntuació)
      
    </p>
	
      
	<form method="get" action="#">
             <legend>Escriu una frase i et diré si és o no palíndroma:</legend><br/>
			 <input type="text" name="frase" placeholder="La frase..." required>
			 <input type="submit" name="clica" value="Comprova"><br/>
    </form>
        
    <?php

        if(isset($_GET["clica"])){
            
            $frase =  filter_input(INPUT_GET, 'frase', FILTER_SANITIZE_SPECIAL_CHARS);
            $frase2=replacingChars($frase);
             
            $fraserrev = strrev($frase2);
      
            if(strcmp($frase2,$fraserrev)==0){
                echo "$frase sí és palindroma ";
            }else{
                echo "$frase no és palindroma";
            }
        }
        /**  Clean the phrase of white spaces, make everything lowercase, remove accents
        *    @param $f the phrase to clean
        *    @return $f string, transformed phrase 
        */
        function replacingChars($texte){
            $texte = trim($texte);//traiem espais en blanc de davant i darrera de la paraula o de la frase
            $texte =  mb_strtolower($texte);//baixem a minúscules tant si tenim com si no tenim accents
           echo $texte;
            $texte = str_replace(" ","",$texte);//funcion para reemplazar
            $texte = str_replace(['á','à','é','è','í','ì','ó','ò','ú','ù'],
                             ['a','a','e','e','i','i','o','o','u','u'],$texte);
            $texte = str_replace([',','.'],["",""],$texte);
            return $texte;
        }
    ?>
</body>
</html>


    

		
