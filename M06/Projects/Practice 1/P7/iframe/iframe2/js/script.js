document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("popup").addEventListener("click", function () {
        let name = window.parent.document.getElementById("iframe1").contentWindow.document.getElementById("name").value;
        let eventSelected = window.parent.document.getElementById("iframe1").contentWindow.document.getElementById("eventSelected").value;
        let numTickets = window.parent.document.getElementById("iframe1").contentWindow.document.getElementById("numTickets").value;
        let mostrarPrecio = document.getElementById("mostrarPrecio").innerText;

        let eventSelectedName = eventName(eventSelected);

        console.log(name);
        console.log(eventSelectedName);
        console.log(numTickets);
        console.log(mostrarPrecio);

        var estado = window.parent.document.getElementById("estadoText");
        estado.innerText = 'Tickets Reservados';

        let popup = window.open("../popup/index.html", "DATOS COMPLETOS", "width=500,height=300");

        popup.addEventListener("DOMContentLoaded", function () {
            popup.document.getElementById("namePop").innerText = "Nombre:" + name;
            popup.document.getElementById("eventoPop").innerText = "Evento seleccionado: " + eventSelectedName;
            popup.document.getElementById("numTicketsPop").innerText = "Número de tickets: " + numTickets;
            popup.document.getElementById("precioTotalPop").innerText = "Precio Total: " + mostrarPrecio;

            let closePopup = popup.document.getElementById("close");
            closePopup.addEventListener("click", function () {
                popup.close();
            })

            let printPopup = popup.document.getElementById("print");
            printPopup.addEventListener("click", function () {
                estado.innerText = 'Tickets Reservados e imprimidos'
                popup.print();
            })
        }, false);
    });
}, false);

function eventName(eventSelected) {
    if (eventSelected == 10) {
        eventSelectedName = "Cine";
    } else if (eventSelected == 20) {
        eventSelectedName = "Teatro";
    }
}