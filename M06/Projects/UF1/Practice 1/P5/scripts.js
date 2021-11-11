document.addEventListener("DOMContentLoaded", function () {
    document.addEventListener("submit", procesar);
}, false);

function procesar() {
    //OCULTAR CONTENEDOR DE SALIDA DE DATOS
    document.getElementById("showResult").style.display = "none";
    document.getElementById("showResult").style.border = "0px solid black";

    //BORRAR MEMORIA DE ERRORES PARA QUE NO SE REPITAN LOS ERRORES
    deleteMemory(document.getElementById("nameMemory"),
        document.getElementById("surnameMemory"),
        document.getElementById("ageMemory"));

    let name = document.getElementById("name").value;
    let surname = document.getElementById("surname").value;
    let age = parseInt(document.getElementById("age").value);

    //CALCULA LOS ERRORES Y VERIFICA SI MOSTRAR RESULTADO O NO
    if (calcularErrores(name, surname, age)) {
        returnHtml(name, surname, age);
    }
}

function returnHtml(name, surname, age) {

    deleteMemory(document.getElementById("showNameMemory"),
        document.getElementById("showSurnameMemory"),
        document.getElementById("showAgeMemory"));

    //CREAR SALIDAS DE DATOS
    let nameP = document.createElement("p");
    nameP.innerText = "Nombre --> " + name;
    nameP.setAttribute('id', 'showNameMemory');
    let surnameP = document.createElement("p");
    surnameP.innerText = "Apellido --> " + surname;
    surnameP.setAttribute('id', 'showSurnameMemory');
    let ageP = document.createElement("p");
    ageP.innerText = "Edad --> " + age;
    ageP.setAttribute('id', 'showAgeMemory');

    //AÑADIR SALIDAS DE DATOS
    document.getElementById("resultado").appendChild(nameP);
    document.getElementById("resultado").appendChild(surnameP);
    document.getElementById("resultado").appendChild(ageP);

    document.getElementById("showResult").style.display = "block";
    document.getElementById("showResult").style.border = "2px solid black";
}

////////////////////////////////////////BORRAR MEMORIA////////////////////////////////////////////

function deleteMemory(nameMemory, surnameMemory, ageMemory) {

    if (nameMemory != null) {
        nameMemory.remove();
    }
    if (surnameMemory != null) {
        surnameMemory.remove();
    }
    if (ageMemory != null) {
        ageMemory.remove();
    }
}

/////////////////////////////////////////VALIDACIONES/////////////////////////////////////////////

function calcularErrores(name, surname, age) {
    let check = true;

    //IF'S DE NAME
    if (!validarStringNull(name) || !validarStringLength(name)) {
        console.log("El nombre no puede estar vacio!");
        check = false;

        let nameError = document.createElement("p");
        nameError.innerText = "El nombre no puede estar vacio!";
        nameError.setAttribute('id', 'nameMemory');
        document.getElementById("nameError").appendChild(nameError);

        document.getElementById("nameError").style.display = "block";
        document.getElementById("nameError").style.color = "red";
        document.getElementById("nameError").style.fontWeight = "bold";
    }

    //IF'S DE SURNAME
    if (!validarStringNull(surname) || !validarStringLength(surname)) {
        console.log("El apellido no puede estar vacio!");
        check = false;

        let surnameError = document.createElement("p");
        surnameError.innerText = "El apellido no puede estar vacio!";
        surnameError.setAttribute('id', 'surnameMemory');
        document.getElementById("surnameError").appendChild(surnameError);

        document.getElementById("surnameError").style.display = "block";
        document.getElementById("surnameError").style.color = "red";
        document.getElementById("surnameError").style.fontWeight = "bold";
    }

    //IF'S DE AGE
    if (!validarAgeLenght(age) || !validarAgeNull(age)) {
        console.log("La edad no puede estar vacio!");
        check = false;

        let ageError = document.createElement("p");
        ageError.innerText = "La edad no puede estar vacio!";
        ageError.setAttribute('id', 'ageMemory');
        document.getElementById("ageError").appendChild(ageError);

        document.getElementById("ageError").style.display = "block";
        document.getElementById("ageError").style.color = "red";
        document.getElementById("ageError").style.fontWeight = "bold";
    }

    if (validarAgeNaN(age)) {
        console.log("No es un numero!");
        check = false;

        let ageError = document.createElement("p");
        ageError.innerText = "No es un numero!";
        ageError.setAttribute('id', 'ageMemory');
        document.getElementById("ageError").appendChild(ageError);

        document.getElementById("ageError").style.display = "block";
        document.getElementById("ageError").style.color = "red";
        document.getElementById("ageError").style.fontWeight = "bold";
    }

    if (!validarAgeRango()) {
        console.log("La edad tiene que ser mayor a 0!");
        check = false;

        let ageError = document.createElement("p");
        ageError.innerText = "La edad tiene que ser mayor a 0!";
        ageError.setAttribute('id', 'ageMemory');
        document.getElementById("ageError").appendChild(ageError);

        document.getElementById("ageError").style.display = "block";
        document.getElementById("ageError").style.color = "red";
        document.getElementById("ageError").style.fontWeight = "bold";
    }


    return check;
}

//FUNCIONES NAME
function validarStringNull(name) {
    if (name == null) {
        return false;
    }
    return true;
}
function validarStringLength(name) {
    if (name.length == 0) {
        return false;
    }
    return true;
}

//FUNCIONES AGE
function validarAgeNull(age) {
    if (age == null) {
        return false;
    } else {
        return true;
    }
}
function validarAgeLenght(age) {
    if (`${age}`.length <= 0) {
        return false;
    } else {
        return true;
    }
}
function validarAgeNaN(age) {
    return isNaN(age);
}
function validarAgeRango(age) {
    if (age <= 0) {
        return false;
    } else {
        return true;
    }
}