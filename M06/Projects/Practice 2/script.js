
document.addEventListener("DOMContentLoaded", function () {

    document.getElementById("btnCrear").addEventListener("click", crear);
    

}, false);

function crear() {
    let num = document.getElementById("input1").value;
    let newDiv = document.createElement("div");

    //newDiv.appendChild(document.createTextNode("new div"));
    newDiv.innerText = "texto";

    for (let i = 0; i < num; i++) {
        let auxDiv = newDiv.cloneNode(true); //true para clonar sus atributos.
        auxDiv.id = "div" + (i + 1);
        document.getElementById("contenedor").appendChild(auxDiv);
    }

    let auxDiv = newDiv.cloneNode(true);
    auxDiv.id = "first";

    document.body.insertBefore(auxDiv, document.getElementById("input1"));

}

