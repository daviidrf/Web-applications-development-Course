document.addEventListener("DOMContentLoaded", function () {
    let validar = document.getElementById("validar");

    validar.addEventListener("click", function () {
        let dni = document.getElementById("DNI").value;
        calDNI(dni);
    }, false);
});
function calDNI(dni) {
    let abc = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'];

    if (dni.length == 9) {
        if (abc[dni.substring(0, 8) % 23] == dni.substring(8)) {
            console.log("DNI CORRECTO");
            document.getElementById("resultado").innerText =
                "DNI CORRECTO"
        } else {
            console.log("DNI INCORRECTO");
            document.getElementById("resultado").innerText =
                "DNI NO VALIDO!"
        }
    }
    else{
        console.log("LA LONGITUD DEL DNI NO ES LA CORRECTA!")
    }
}