//Array of numbers.
var numeros = new Array(6);

//MAIN.
document.addEventListener("DOMContentLoaded", function () {

    var recibir = document.getElementById("enviar");
    var buscar = document.getElementById("buscar");
    recibir.addEventListener("click", ordenarNumeros, false);
    buscar.addEventListener("click", buscarNumero, false);
});

//Function to order the array.
function ordenarNumeros() {

    for (let i = 0; i < numeros.length; i++) {
        numeros[i] = parseInt(prompt("Introduce un numero :"));
    }

    var arrayASC = numeros.slice();
    var arrayDESC = numeros.slice();

    console.log(numeros);

    //Order numbers in ascending order.
    console.log(arrayASC.sort(function (a, b) { return a - b }).join(' - '));

    //Order numbers in descending order.
    console.log(arrayDESC.sort(function (a, b) { return b - a }).join(' - '));

    returnHtml(numeros, arrayASC, arrayDESC);
}

//Function to search a number in the array.
function buscarNumero() {
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
}

//This function returns the rersults to the HTML.
function returnHtml(numeros, arrayASC, arrayDESC) {
    document.getElementById("array").innerText =
        "Array --> " + numeros.join(' - ');
    document.getElementById("arrayASC").innerText =
        "Array Ascendente --> " + arrayASC.sort(function (a, b) { return a - b }).join(' - ');
    document.getElementById("arrayDESC").innerText =
        "Array Descendente --> " + arrayDESC.sort(function (a, b) { return b - a }).join(' - ');

    document.getElementById("showResult").style.display = "block";
    document.getElementById("showResult").style.border = "2px solid black";
    document.getElementById("buscar").style.display = "block";
}