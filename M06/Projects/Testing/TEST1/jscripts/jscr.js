document.addEventListener("DOMContentLoaded", function () {
    let boton = document.getElementById("calcular");
    let limpiar = document.getElementById("reset");

    boton.addEventListener("click", function () {
        let imc = inMassa();
        returnHtml(imc, messMassa(imc));
    }, false);

    limpiar.addEventListener("click", function () {
        reset();
    }, false);

    //FUNCION PARA LIMPIAR LOS CAMPOS
    function reset() {
        document.getElementById("altura").value = "";
        document.getElementById("peso").value = "";
        document.getElementById("showResult").style.display = "none";
        document.getElementById("showResult").style.border = "0px";
    }

    //FUNCION QUE CALCULA EL IMC
    function inMassa() {
        let altura = document.getElementById("altura").value;
        let peso = document.getElementById("peso").value;

        return peso / (altura * altura);
    }

    //FUNCION QUE TE DEVUELVE UNA FRASE SEGUN TU IMC
    function messMassa(imc) {
        if (imc < 18.5) {
            return "Bajo peso";
        } else if (imc > 18.5 && imc < 24.9) {
            return "Normopeso";
        } else if (imc > 25 && imc < 26.9) {
            return "Sobrepeso";
        } else {
            return "Sobrepeso Grado 2";
        }
    }

    //FUNCION QUE ENVIA EL MENSAJE AL HTML
    function returnHtml(imc, message) {
        document.getElementById("resultado").innerText =
            "Tu IMC es " + imc.toFixed(1)
            + " y tienes " + message;

        document.getElementById("showResult").style.display = "block";
        document.getElementById("showResult").style.border = "2px solid black";
    }
});

