document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("calcular").addEventListener("click", function () {
        let name = document.getElementById("name").value;
        let eventSelected = document.getElementById("eventSelected").value;
        let numTickets = document.getElementById("numTickets").value;
        console.log(name);
        console.log(eventSelected);
        console.log(numTickets);

        let precioTotal = (eventSelected * numTickets);
        console.log(precioTotal);

        let estado = window.parent.document.getElementById("estadoText");
        estado.innerText = 'Pendiente la aceptación del precio';

        window.parent.document.getElementById("iframe2").contentWindow.document.getElementById("mostrarPrecio").innerText = precioTotal + " €";
    });
}, false);