document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("calcular").addEventListener("click", function () {


        let name = document.getElementById("name").value;
        let eventSelected = document.getElementById("eventSelected").value;
        let numTickets = parseInt(document.getElementById("numTickets").value);

        if (calcularErrores(name, numTickets)) {

            console.log(name);
            console.log(eventSelected);
            console.log(numTickets);
            let precioTotal = (eventSelected * numTickets);
            console.log(precioTotal);

            let estado = window.parent.document.getElementById("estadoText");
            estado.innerText = 'Pendiente la aceptación del precio';

            window.parent.document.getElementById("iframe2").contentWindow.document.getElementById("mostrarPrecio").innerText = precioTotal + " €";
        }
    });
}, false);

function deleteMemory(nameMemory, passMemory) {

    if (nameMemory != null) {
        nameMemory.remove();
    }
    if (passMemory != null) {
        passMemory.remove();
    }
}

function calcularErrores(name, numTickets) {
    let check = true;

    deleteMemory(document.getElementById("nameMemory"),
        document.getElementById("passMemory"));

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

    //IF'S DE NUM DE TICKETS
    if (!validarPassLenght(numTickets) || !validarPassNull(numTickets)) {
        console.log("La edad no puede estar vacio!");
        check = false;

        let numPassError = document.createElement("p");
        numPassError.innerText = "La cantidad no puede estar vacia!";
        ageError.setAttribute('id', 'passMemory');
        document.getElementById("numPassError").appendChild(numPassError);

        document.getElementById("numPassError").style.display = "block";
        document.getElementById("numPassError").style.color = "red";
        document.getElementById("numPassError").style.fontWeight = "bold";
    }

    if (validarPassNaN(numTickets)) {
        console.log("No es un numero!");
        check = false;

        let numPassError = document.createElement("p");
        numPassError.innerText = "No es un numero!";
        numPassError.setAttribute('id', 'passMemory');
        document.getElementById("numPassError").appendChild(numPassError);

        document.getElementById("numPassError").style.display = "block";
        document.getElementById("numPassError").style.color = "red";
        document.getElementById("numPassError").style.fontWeight = "bold";
    }

    if (!validarPassRango(numTickets)) {
        console.log("La edad tiene que ser mayor a 0!");
        check = false;

        let numPassError = document.createElement("p");
        numPassError.innerText = "La edad tiene que ser mayor a 0!";
        numPassError.setAttribute('id', 'passMemory');
        document.getElementById("numPassError").appendChild(numPassError);

        document.getElementById("numPassError").style.display = "block";
        document.getElementById("numPassError").style.color = "red";
        document.getElementById("numPassError").style.fontWeight = "bold";
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

//FUNCIONES numTickets
function validarPassNull(numTickets) {
    if (numTickets == null) {
        return false;
    } else {
        return true;
    }
}
function validarPassLenght(numTickets) {
    if (`${numTickets}`.length <= 0) {
        return false;
    } else {
        return true;
    }
}
function validarPassNaN(numTickets) {
    return isNaN(numTickets);
}
function validarPassRango(numTickets) {
    if (numTickets <= 0) {
        return false;
    } else {
        return true;
    }
}