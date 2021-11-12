//Array of Stats
var arrayStats = new Array(7);

document.addEventListener("DOMContentLoaded", function () {
    var procesar = document.getElementById("procesar");
    procesar.addEventListener("click", chargeFunctions, false);

});

//Function that charges the different stats into the array stats.
function chargeFunctions() {
    var texto = document.getElementById("texto").value;

    //We clean the text.
    var textoLimpio = texto.replace(/Á|á/g, "A")
        .replace(/É|é/g, "E")
        .replace(/Í|í/g, "I")
        .replace(/Ó|ó/g, "O")
        .replace(/Ú|ú/g, "U")
        .replace(/,/g, "")
        .replace(/\./g, "")
        .replace(/ /g, "")
        .toUpperCase();

    var arrayLetras = textoLimpio.split('');
    var arrayDePalabras = texto.split(' ');

    arrayStats[0] = countChars(arrayLetras);
    arrayStats[1] = arrayDePalabras.length;
    arrayStats[2] = arrayDePalabras[0];
    arrayStats[3] = arrayDePalabras[arrayDePalabras.length - 1];
    arrayStats[4] = arrayDePalabras.reverse().join(' ');
    arrayStats[5] = arrayDePalabras.sort().join(' ');
    arrayStats[6] = arrayDePalabras.sort().reverse().join(' ');

    returnHtml(arrayStats);
}

//This function counts all the occurrences for each char.
function countChars(arrayLetras){
    let charsUnico = [...new Set(arrayLetras)];
    var numLetras = [charsUnico.length];
    let repetido = 0;
    for (let i = 0; i < charsUnico.length; i++) {
        for (let j = 0; j < arrayLetras.length; j++) {
            if (charsUnico[i] == [arrayLetras[j]]) {
                repetido++;
            }
        }
        numLetras[i] = charsUnico[i].toUpperCase() + " --> " + repetido;
        repetido = 0;
    }
    return numLetras.join(' / ');
}

//This function returns the rersults to the HTML.
function returnHtml(arrayStats) {
    document.getElementById("resultado").innerText =
        "Número de cada carácter --> " + arrayStats[0] + "\n" +
        "Número de palabras --> " + arrayStats[1] + "\n" +
        "Primera palabra --> " + arrayStats[2] + "\n" +
        "Última palabra --> " + arrayStats[3] + "\n" +
        "Frase al revés --> " + arrayStats[4] + "\n" +
        "Palabras ordenadas A-Z --> " + arrayStats[5] + "\n" +
        "Palabras ordenadas Z-A --> " + arrayStats[6];

    document.getElementById("showResult").style.display = "block";
    document.getElementById("showResult").style.border = "2px solid black";
}