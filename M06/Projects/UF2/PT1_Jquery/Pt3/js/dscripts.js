$(document).ready(function () {

    $("#validar").click(function () {

        let dni = $("#dni").val();
        console.log(validateDNI(dni));
        $("#result").text(validateDNI(dni));


    });
});

function validateDNI(dni) {
    var num;
    var letra = 'TRWAGMYFPDXBNJZSQVHLCKET';
    var regExp = /^[XYZ]?\d{5,8}[A-Z]$/;

    dni = dni.toUpperCase();

    if (regExp.test(dni) === true) {
        num = dni.substr(0, dni.length - 1);
        num = num.replace('X', 0);
        num = num.replace('Y', 1);
        num = num.replace('Z', 2);
        let = dni.substr(dni.length - 1, 1);
        num = num % 23;
        letra = letra.substring(num, num + 1);
        if (letra != let) {
            return "Dni erróneo, la letra del NIF no se corresponde";
        } else {
            return "Dni correcto";
        }
    } else {
        return "Dni erróneo, formato no válido";
    }
}