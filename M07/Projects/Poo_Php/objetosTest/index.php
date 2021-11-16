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

        $jordi = new Persona("Jordi",21);
        $david = new Persona("David",21);
        $jose = new Persona("Jose");

        $jordi -> toPrint();
        echo "<hr>";
        $david -> toPrint();
        echo "<hr>";
        $jose -> toPrint();
        echo "<hr>";

        $suma = new Suma(10,5); // Creamos un objeto (Suma) y le damos los números para sumar.
        $suma -> operation(); // Realizamos la operacion, que en este caso es una suma.
        $suma -> printResult(); //Imprimimos el el "result" despues de ejecutar la operation.
    ?>
</body>
</html>