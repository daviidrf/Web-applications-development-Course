document.addEventListener("DOMContentLoaded", function () {
    var procesar = document.getElementById("procesar");

    procesar.addEventListener("click", function () {
        var arrayStats = new Array(7);
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

        var arrayDePalabras = texto.split(' ');

        arrayStats[0] = [...textoLimpio].reduce((a, e) => { a[e] = a[e] ? a[e] + 1 : 1; return a }, {});
        arrayStats[1] = arrayDePalabras.length;
        arrayStats[2] = arrayDePalabras[0];
        arrayStats[3] = arrayDePalabras[arrayDePalabras.length - 1];
        arrayStats[4] = arrayDePalabras.reverse().join(' ');
        arrayStats[5] = arrayDePalabras.sort().join(' ');
        arrayStats[6] = arrayDePalabras.sort().reverse().join(' ');

        returnHtml(arrayStats);
    }, false);

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
});