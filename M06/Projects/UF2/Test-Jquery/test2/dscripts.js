$(document).ready(function(){
    $("button").click(function(){
        $("#intro").val("Estic dins de la caixa input");

        // Añadir texto detras de la etiqueta.
        $("p").append(" <-- TEXTO AÑADIDO DETRAS");

        // Añadir texto delante de la etiqueta.
        $("p").prepend("TEXTO AÑADIDO DELANTE --> ");

        // PRUEBAS DE AÑADIR TEXTO.
        var text1 = "<h1>TITULO AÑADIDO</h1>";
        var text2 = $("<p></p>").text("Texto añadido 2");
        var text3 = document.createElement("p");
        text3.innerHTML = "Texto añadido 3";
        $("body").append(text1,text2,text3);

        

    });
});