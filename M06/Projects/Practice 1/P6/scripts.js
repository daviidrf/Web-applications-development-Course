// var colors = ["green_1", "green_2", "red_1", "red_2", "yellow_1",
//     "yellow_2", "blue_1", "blue_2", "black_1", "black_2",
//     "brown_1", "brown_2", "orange_1", "orange_2", "purple_1",
//     "purple_2"];

var colors = ["green", "green", "red", "red", "yellow",
    "yellow", "blue", "blue", "black", "black",
    "brown", "brown", "orange", "orange", "purple",
    "purple"];
colors = order(colors);

document.addEventListener("DOMContentLoaded", function () {

    document.addEventListener("submit", generar);
    let juego = document.getElementById("resultado");
    juego.addEventListener("click", changeColor);
}, false);

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

function generarMemorama() {
    let colorNum = 0;
    for (let row = 0; row < 4; row++) {
        let fila = document.createElement("div");
        fila.setAttribute('id', 'row' + row);
        fila.setAttribute('class', 'row');
        document.getElementById("resultado").appendChild(fila);
        for (let col = 0; col < 4; col++) {
            let casilla = document.createElement("div");
            casilla.setAttribute('id', colorNum + ' col-3 casilla');
            casilla.setAttribute('class', colors[colorNum] + ' col-3 casilla');
            casilla.setAttribute('style', 'border: 2px solid black; width:140px; height:140px;');
            document.getElementById("row" + row).appendChild(casilla);
            colorNum++;
        }

    }
}

function changeColor(e) {
    let juego = document.getElementById("resultado");
    let colorNum = 0;
    for (let i = 0; i < colors.length; i++) {
        console.log(colors[i]);
        console.log(e.target);
    }

    for (let row = 0; row < 4; row++) {
        for (let col = 0; col < 4; col++) {
            //e.target.style.backgroundColor = colors[colorNum];
            colorNum++;
        }
    }
}

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