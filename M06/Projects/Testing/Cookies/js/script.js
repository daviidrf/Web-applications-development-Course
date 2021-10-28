document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("create").addEventListener("click", crearCookie, false);
    document.getElementById("delete").addEventListener("click", eliminarCookie, false);
    document.getElementById("modify").addEventListener("click", modificarCookie, false);
    document.getElementById("peticion").addEventListener("click", ajax, false);
}, false);

function crearCookie(){
    let fecha = new Date(2021,9,28);
    console.log(fecha);
    console.log(fecha.toUTCString());
    document.cookie = "curso=daw2;expires=" + fecha.toUTCString();
    //document.cookie = "id=45345;expires=" + fecha.toUTCString();

    console.log("Creando cookie...");
    console.log(document.cookie);
}

function eliminarCookie(){
    console.log("Borrando cookie...");
    document.cookie = "curso=daw2!;max-age=0";
}

function modificarCookie(){
    console.log("Modificando cookie...");
    document.cookie = "curso=daw2!;";
}

function ajax(){
    console.log("ajax");
    let info = {
        curso: "daw2",
        year: 2021,
        alumnos: ["David","Jordi"]
    };
    let xhr = new XMLHttpRequest();
    xhr.open("POST","php/server.php");
    //xhr.responseType = 'json';

    xhr.send(JSON.stringify(info));
    xhr.onload = function(){
        console.log("Respuesta recibida");
        console.log(xhr.response);
        let respuesta = JSON.parse(xhr.response);
        console.log(respuesta.variable);
        console.log(xhr.status);
    }
}