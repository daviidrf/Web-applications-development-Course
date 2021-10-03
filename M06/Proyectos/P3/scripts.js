document.addEventListener("DOMContentLoaded", function () {
    var recibir = document.getElementById("enviar");
    var buscar = document.getElementById("buscar");

    recibir.addEventListener("click", function () {
        var numeros = new Array(6);

        for (let i = 0; i < numeros.length; i++) {
            numeros[i] = parseInt(prompt("Introduce un numero :"));
        }

        //We save the normal array in a variable to show in the HTMl.
        var arrayNormal = numeros.join(' - ');
        console.log(arrayNormal);

        //Order numbers in ascending order.
        console.log(numeros.sort(function (a, b) { return a - b }).join(' - '));

        //Order numbers in descending order.
        console.log(numeros.sort(function (a, b) { return b - a }).join(' - '));

        returnHtml(numeros, arrayNormal);

        buscar.addEventListener("click", function () {
            let busqueda = parseInt(prompt("Que número quieres buscar ?"));
            let index = numeros.indexOf(busqueda);

            console.log(numeros);
            console.log(index);

            if (index != -1) {
                document.getElementById("numBuscado").innerText =
                    "El número buscado se encuentra en la Matriz.\n" + 
                    "Su posición és la " + (index + 1) + ".";
            }
            else {
                document.getElementById("numBuscado").innerText =
                    "El número buscado no se encuentra en la Matriz.";
            }

        }, false);

    }, false);

    //This function returns the rersults to the HTML.
    function returnHtml(numeros, arrayNormal) {
        document.getElementById("array").innerText =
            "Array --> " + arrayNormal;
        document.getElementById("arrayASC").innerText =
            "Array Ascendente --> " + numeros.sort(function (a, b) { return a - b }).join(' - ');
        document.getElementById("arrayDESC").innerText =
            "Array Descendente --> " + numeros.sort(function (a, b) { return b - a }).join(' - ');

        document.getElementById("showResult").style.display = "block";
        document.getElementById("showResult").style.border = "2px solid black";
        document.getElementById("buscar").style.display = "block";
    }
});