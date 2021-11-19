<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>POO PHP</title>
</head>
<body>
    <h1>Ejemplo básico de PHP con clases</h1>
    <?php
        require_once "Persona.php"; // Conectar Vista (Actual) con la clase (Persona).
        require_once "Suma.php"; // Clase (Suma).
        require_once "Cadena.php"; // Clase (Cadena).
        require_once "Template.php"; // Clase (Template).

        ////////////////////////////////////////////////////

        $jordi = new Persona("Jordi",21);
        $david = new Persona("David",21);
        $jose = new Persona("Jose");

        $jordi -> toPrint();
        echo "<hr>";
        $david -> toPrint();
        echo "<hr>";
        $jose -> toPrint();
        echo "<hr>";

        ////////////////////////////////////////////////////

        $suma = new Suma(10,5); // Creamos un objeto (Suma) y le damos los números para sumar.
        $suma -> operation(); // Realizamos la operacion, que en este caso es una suma.
        $suma -> printResult(); // Imprimimos el el "result" despues de ejecutar la operation.

        ////////////////////////////////////////////////////

        $saludo = "Hola, buenos dias!";
        
        echo "<hr>";
        echo "USANDO MÉTODOS ESTATICOS";
        echo "<br>";
        echo "La longitud de tu cadena es " . Cadena::largo($saludo); // LLamando al método "largo" de la clase (Cadena).
        echo "<br>";
        echo "Tu cadena en mayúsculas es " . Cadena::mayus($saludo); // Convierte la cadena a mayúsculas con el método "mayus".
        echo "<hr>";

        ////////////////////////////////////////////////////

        $template = new Template();
        $template -> setVariable("Londres","Reino Unido");
        $template -> setVariable("Paris","Francia");
        $template -> getHtml();
    ?>
</body>
</html>