document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("popup").addEventListener("click", function () {
        let name = window.parent.document.getElementById("iframe1").contentWindow.document.getElementById("name").value;
        let eventSelected = window.parent.document.getElementById("iframe1").contentWindow.document.getElementById("eventSelected").id;
        let numTickets = window.parent.document.getElementById("iframe1").contentWindow.document.getElementById("numTickets").value;
        let mostrarPrecio = document.getElementById("mostrarPrecio").innerText;



        console.log(name);
        console.log(eventSelected);
        console.log(numTickets);
        console.log(mostrarPrecio);

        let estado = window.parent.document.getElementById("estadoText");
        estado.innerText = 'Tickets Reservados';

        let popup = window.open("../popup/index.html", "DATOS COMPLETOS", "width=500,height=300");

        popup.addEventListener("DOMContentLoaded", function () {
            popup.document.getElementById("namePop").innerText = "Nombre:" + name;
            popup.document.getElementById("eventoPop").innerText = "Evento seleccionado: " + eventSelected;
            popup.document.getElementById("numTicketsPop").innerText = "Número de tickets: " + numTickets;
            popup.document.getElementById("precioTotalPop").innerText = "Precio Total: " + mostrarPrecio;
        }, false);


        // popup.document.write("<p>Nombre: " + name + "</p>");
        // popup.document.write("<p>Evento seleccionado: " + eventSelected + "</p>");
        // popup.document.write("<p>Número de Tickets: " + numTickets + "</p>");
        // popup.document.write("<p>Precio Total: " + mostrarPrecio + "</p>");
        // popup.document.write('<button id="print" type="button" class="btn btn-primary" style="margin-top: 10px;">Imprimir</button>');
        // popup.document.write('<button id="close" type="button" class="btn btn-primary" style="margin-top: 10px;">Cerrar</button>');

    });
}, false);