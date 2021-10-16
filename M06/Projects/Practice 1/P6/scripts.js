var colors = ["green", "green", "red", "red", "yellow",
    "yellow", "blue", "blue", "fucsia", "fucsia",
    "pink", "pink", "turquesa", "turquesa", "purple",
    "purple"];
colors = order(colors);

var jugada1;
var jugada1ID;
var aciertos = 0;

document.addEventListener("DOMContentLoaded", function () {

    document.addEventListener("submit", generar);
    let juego = document.getElementById("resultado");

    //juego.addEventListener("click", showFirstCase);
    juego.addEventListener("click", provepair);




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
            casilla.setAttribute('id', colorNum);
            casilla.setAttribute('class', colors[colorNum] + ' col-3 default');
            casilla.setAttribute('style', 'border: 2px solid gray; width:140px; height:140px;');
            document.getElementById("row" + row).appendChild(casilla);
            colorNum++;
        }

    }
}

function showFirstCase(e) {
    jugada1 = e.target.classList;
    jugada1ID = e.target.id;

    e.target.classList.remove("default");

    console.log(jugada1[0]);
    console.log(jugada1ID);
}

function provepair(e) {
    var jugada2;
    var jugada2ID;

    jugada1 = e.target.classList;
    jugada1ID = e.target.id;

    jugada2 = e.target.classList;
    jugada2ID = e.target.id;

    console.log(jugada1[0]);
    console.log(jugada1ID);

    console.log(jugada2[0]);
    console.log(jugada2ID);







    // for (let i = 0; i < colors.length; i++) {
    //     //console.log(colors[i]);
    //     //console.log(e.target);
    // }

    // var arrayClases = [16];
    // for (let i = 0; i < 8; i++) {

    //     for (let j = 0; j < 2; j++) {
    //         casilla1 = e.currentTarget.classList;
    //         console.log(casilla1[0]);
    //         casilla2 = e.currentTarget.classList;
    //         console.log(casilla2[0]);
    //     }
    //arrayClases[i] = e.target.classList;

    //console.log(arrayClases[i][0]);
    //}
    // for (let i = 0; i < arrayClases.length; i++) {
    //     const element = array[index];

    // }

    //console.log(arrayClases.classList);



    //e.target.classList.remove("default");
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