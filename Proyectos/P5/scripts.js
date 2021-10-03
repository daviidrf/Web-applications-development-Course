document.addEventListener("DOMContentLoaded", function () {
    let recibir = document.getElementById("enviar");
    let numeros = new Array(6);

    for (let i = 0; i < numeros.length; i++) {

        recibir.addEventListener("click", function () {
            numeros[i] = document.getElementById("numeros").value;



            //calPALINDROMA(palin);
        }, false);
    }
    for (let i = 0; i < numeros.length; i++) {
        console.log(numeros[i]);
    }


    function calPALINDROMA(palin) {

    }

});