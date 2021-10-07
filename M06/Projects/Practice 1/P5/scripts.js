document.addEventListener("DOMContentLoaded", function () {
    document.addEventListener("submit", procesar);
}, false);

function procesar() {
    let name = document.getElementById("name").value;
    let surname = document.getElementById("surname").value;
    let age = parseInt(document.getElementById("age").value);

    calcularErrores(name, surname, age);

    if(calcularErrores(name, surname, age) == true){
        returnHtml(name, surname, age);
    }    

}

function calcularErrores (name, surname, age){
    let check = true;
    
    //IF'S DE NAME
    if (validarNameNull(name) == false) {
        console.log("El nombre es nulo!");
        // let error = document.createElement("p");
        // error.innerText = "El nombre introducido es nulo!";
        // document.getElementById("resultado").appendChild(error);
        check = false;
    }
    if(validarNameLength(name) == false){
        console.log("La longitud del nombre no puede ser 0!");
        check = false;
    }
    
    //IF'S DE SURNAME
    if(validarNameNull(surname) == false){
        console.log("En apellido es nulo!");
        check = false;
    }
    if(validarNameLength(surname) == false){
        console.log("La longitud del apellido no puede ser 0!");
        check = false;
    }

    //IF'S DE AGE
    if(validarAgeLenght(age) == false){
        console.log("La longitud del número no puedes ser 0");
        check = false;
    }
    if(validarAgeNull(age) == false){
        console.log("El número es nulo");
        check = false;
    }
    if(validarAgeNaN(age)){
        console.log("No es un numero");
        check = false;
    }
    
    return check;
}

function returnHtml(name, surname, age) {

    let nameP = document.createElement("p");
    nameP.innerText = "Nombre --> " + name;
    let surnameP = document.createElement("p");
    surnameP.innerText = "Apellido --> " + surname;
    let ageP = document.createElement("p");
    ageP.innerText = "Edad --> " + age;

    document.getElementById("resultado").appendChild(nameP);
    document.getElementById("resultado").appendChild(surnameP);
    document.getElementById("resultado").appendChild(ageP);

    document.getElementById("showResult").style.display = "block";
    document.getElementById("showResult").style.border = "2px solid black";
}

//FUNCIONES NAME
function validarNameNull(name) {
    if (name == null) {
        return false;
    }
    return true;
}

function validarNameLength(name) {
    if (name.length == 0) {
        return false;
    }
    return true;
}


//FUNCIONES AGE
function validarAgeNull(age) {
    if (age == null) {
        return false;
    }
    return true;
}

function validarAgeLenght(age) {
    let num = age;
    if (`${num}`.length == 0) {
        return false;
    }
    return true;
}
function validarAgeNaN(age) {
    return isNaN(age);
}