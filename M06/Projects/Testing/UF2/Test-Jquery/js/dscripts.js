// Events -- "https://www.w3schools.com/jquERy/jquery_events.asp"
// Selectors -- "https://www.w3schools.com/jquERy/jquery_selectors.asp"

$(document).ready(function(){
    //$("p") Per tots el paràgrafs.
    //$("#title") Per un id específic, per exemple "title".
    //$(".error") Per una classe específica, per exemple "error".

    // ".click", ".dblclick", ".mouseenter", ".mouseleave", ".mousedown", ".hover", ".focus"

    $("#ocultar").click(function(){ // Quan faig click al botó amb el id "ocultar" executa.
        //$("p").hide(); // Tots els paràgrafs s'amaguen.
        //$("#par1").hide(); // S'amaga el paràgraf amb el id "par1".
        //$(".error").hide(); // S'amaga el paràgraf amb la classe "error".
        //$("#div1").hide(); // Amaga el "div" amb el id "div1".
        //$("p,h2").hide(); // Amaga els paràgrafs i els "h2".
        //$("p:odd").hide(); // Amaga els paràgrafs pars -- ":even" per impars.
        //$("div>p").hide(); // Amaga els paràgrafs dins de "divs".
        //$("p:eq(2)").hide(); // Amaga el paràgraf en la posició 2, comença per 0.
        //$(this).hide(); // Amaga el botó d'ocultar.
        console.log($("#entrada").val()); // Mostra el value del "id".
        //console.log($(".error").html()); // Mostra el contingut de la etiqueta amb la classe "error".
        //console.log($(".error").html()); // Mostra el text de la etiqueta amb la classe "error".
    });
    $("#mostrar").click(function(){
        //$("p,h2").show(); // Mostra els paràgrafs i els "h2".
        //$("#ocultar").show(); // Mostra el botó d'ocultar.
        //$("#div1").show();
    });
    $(".error").on({
        mouseenter: function(){
            $(this).css("background-color","yellow");
        },
        mouseleave: function(){
            $(this).css("background-color","lightblue")
        },
        click: function(){
            $(this).css("background-color","pink");
        }
    });
});