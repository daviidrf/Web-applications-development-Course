document.addEventListener("DOMContentLoaded", function () {
    let validar = document.getElementById("validar");

    validar.addEventListener("click", function () {
        let palin = document.getElementById("palin").value;
        let palinLimpia = palin.replace(/Á|á/g, "A")
                               .replace(/É|é/g, "E")
                               .replace(/Í|í/g, "I")
                               .replace(/Ó|ó/g, "O")
                               .replace(/Ú|ú/g, "U")
                               .replace(/,/g, "")
                               .replace(/\./g, "")
                               .replace(/ /g, "")
                               .toUpperCase();
        console.log(palinLimpia);
        calPALINDROMA(palinLimpia);
    }, false);
});
function calPALINDROMA(palinLimpia) {
    let separado = palinLimpia.split("");
    let reverseSeparado = separado.reverse();
    let reverseJunto = reverseSeparado.join("");
    if (reverseJunto == palinLimpia) {
        console.log("ES PALINDROMO");
        document.getElementById("resultado").innerText =
            "ES PALINDROMO"
    } else {
        console.log("NO ES PALINDROMO!");
        document.getElementById("resultado").innerText =
            "NO ES PALINDROMO!"
    }
}