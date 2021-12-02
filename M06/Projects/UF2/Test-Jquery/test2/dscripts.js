$(document).ready(function(){

    // NODOS POR ENCIMA DE LA ETIQUETA

    //$("span").parent().css({"color":"red","border":"2px solid red"}); // Para el padre de la etiqueta.
    //$("span").parents().css({"color":"red","border":"2px solid red"}); // Para todos los padres.
    //$("span").parent().eq(1).css({"color":"red","border":"2px solid red"}); // Si hay varias coincidencias selecciona uno en especifico.
    //$("span").parentsUntil("div").css({"color":"red","border":"2px solid red"}); // Para los padres hasta que se encuentre con la etiqueta de until.


    // NODOS POR DEBAJO DE LA ETIQUETA

    //$(".ancestors").children("div:first").css({"color":"red","border":"2px solid red"});

    // NODOS HERMANOS

    //$("#div1").siblings().css({"color":"blue","border":"2px solid blue"});


//-----------------------------------------------------------------------------------------------------------------------------------------------------------//


    // $("button").click(function(){
    //     $("#intro").val("Estic dins de la caixa input");

    //     // Añadir texto detras de la etiqueta.
    //     $("p").append(" <-- TEXTO AÑADIDO DETRAS");

    //     // Añadir texto delante de la etiqueta.
    //     $("p").prepend("TEXTO AÑADIDO DELANTE --> ");

    //     // PRUEBAS DE AÑADIR TEXTO.
    //     var text1 = "<h1>TITULO AÑADIDO</h1>";
    //     var text2 = $("<p></p>").text("Texto añadido 2");
    //     var text3 = document.createElement("p");
    //     text3.innerHTML = "Texto añadido 3";
    //     $("body").append(text1,text2,text3);

        

    //});

//-----------------------------------------------------------------------------------------------------------------------------------------------------------//

let year = new Date().getFullYear();

for (i = year; i >= (year-20); i--)
{
    $('#yearSel').append($('<option/>').val(i).html(i));
}


});