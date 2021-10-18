var colors = ["green", "green", "red", "red", "yellow",
    "yellow", "blue", "blue", "fucsia", "fucsia",
    "pink", "pink", "turquesa", "turquesa", "purple",
    "purple"];
colors = order(colors);

var seleccion1; //First card selection.
var seleccion2; //Second card selection.
var contador = 0; //Counter to know when show or hide the cards.
var aciertos = 0; //Conter to know how many successful pairs are made.

document.addEventListener("DOMContentLoaded", function () {

    document.addEventListener("submit", generar);
    let juego = document.getElementById("resultado");
    juego.addEventListener("click", makePair);

}, false);

//This function validate if the user introduced is in the correct format.
function generar() {
    document.getElementById("showResult").style.display = "none";
    document.getElementById("showResult").style.border = "0px solid black";
    deleteMemory(document.getElementById("userMemory"));

    let user = document.getElementById("user").value;

    if (calcularErrores(user)) {
        document.getElementById("formulari").style.display = "none";
        document.getElementById("formulari").style.border = "0px solid black";
        generarMemorama();
        document.getElementById("showResult").style.display = "block";
        console.log("USER VALIDO");
    }
}

//This function generate the Memoram in the HTML file.
function generarMemorama() {
    let resultado = document.getElementById("resultado");

    let colorNum = 0;
    for (let row = 0; row < 4; row++) {
        let fila = document.createElement("div");
        fila.setAttribute('id', 'row' + row);
        fila.setAttribute('class', 'row');
        resultado.appendChild(fila);
        for (let col = 0; col < 4; col++) {
            let casilla = document.createElement("div");
            casilla.setAttribute('id', colorNum);
            casilla.setAttribute('class', colors[colorNum] + ' col-3 default');
            casilla.setAttribute('style', 'border: 2px solid gray; width:140px; height:140px;');
            document.getElementById("row" + row).appendChild(casilla);
            colorNum++;
        }

    }
    // let marcador = document.createElement("div");
    // marcador.innerHTML = "<p>Aciertos: " + aciertos + "/8</p>"
    // document.body.insertBefore(marcador, resultado);
}

//This function validate the card pairs and hide or show them.
function makePair(e) {

    if (!e.target.classList.contains("girado") && aciertos < 8) {
        if (contador == 0) {
            seleccion1 = e.target.classList;
            seleccion1.remove("default");
            seleccion1.add("girado");
            contador++;
        }
        else if (contador == 1) {
            seleccion2 = e.target.classList;
            seleccion2.remove("default");
            seleccion2.add("girado");
            contador++;
        }
        if (contador == 2) {
            console.log(seleccion1[0]);
            console.log(seleccion2[0]);
            console.log("---------");
            if (seleccion1[0] != seleccion2[0]) {
                setTimeout(function () {
                    seleccion1.add("default");
                    seleccion2.add("default");
                    seleccion1.remove("girado");
                    seleccion2.remove("girado");
                }, 800);

            }
            else {
                aciertos++;
            }
            contador = 0;
            console.log(aciertos);
        }
    }
}

//This function order randomly the array of colors.
function order(colors) {
    return colors.sort(function () {
        return Math.random() - 0.5;
    });
}

//VALIDACIONES Y ERRORES

function deleteMemory(userMemory) {
    if (userMemory != null) {
        userMemory.remove();
    }
}
function calcularErrores(user) {
    let check = true;

    //IF'S DE NAME
    if (!validarStringNull(user) || !validarStringLength(user)) {
        console.log("El user no puede estar vacio!");
        check = false;

        let userError = document.createElement("p");
        userError.innerText = "El user no puede estar vacio!";
        userError.setAttribute('id', 'userMemory');
        document.getElementById("userError").appendChild(userError);

        document.getElementById("userError").style.display = "block";
        document.getElementById("userError").style.color = "red";
        document.getElementById("userError").style.fontWeight = "bold";
    } else if (!isUserNameValid(user)) {
        console.log("El user no cumple con los requisitos!");
        check = false;

        let userError = document.createElement("p");
        userError.innerText = "El user no cumple con los requisitos!";
        userError.setAttribute('id', 'userMemory');
        document.getElementById("userError").appendChild(userError);

        document.getElementById("userError").style.display = "block";
        document.getElementById("userError").style.color = "red";
        document.getElementById("userError").style.fontWeight = "bold";
    }
    return check;
}
function isUserNameValid(user) {

    let required = /^[A-Z][a-z0-9]{4,8}$/;
    let valid = required.test(user);
    return valid;

}
function validarStringNull(user) {
    if (user == null) {
        return false;
    }
    return true;
}
function validarStringLength(user) {
    if (user.length == 0) {
        return false;
    }
    return true;
}
