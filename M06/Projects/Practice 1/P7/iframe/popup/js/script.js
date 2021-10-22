document.addEventListener("DOMContentLoaded", function () {
    // let name = window.parent.document.getElementById("iframe1").contentWindow.document.getElementById("name").value;
    // let eventSelected = window.parent.document.getElementById("iframe1").contentWindow.document.getElementById("eventSelected").innerText;
    // let numTickets = window.parent.document.getElementById("iframe1").contentWindow.document.getElementById("numTickets").value;
    // let mostrarPrecio = document.getElementById("mostrarPrecio").innerText;

    

    let namePop = document.getElementById("namePop");
    let eventoPop = document.getElementById("eventoPop");
    let numTicketsPop = document.getElementById("numTicketsPop");
    let precioTotalPop = document.getElementById("precioTotalPop")



    namePop.innerText = "Nombre: ";
    eventoPop.innerText = "Evento seleccionado: ";
    numTicketsPop.innerText = "Número de tickets: ";
    precioTotalPop.innerText = "Precio Total: ";
}, false);