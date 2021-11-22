$(document).ready(function () {

    $("#procesar").click(function () {

        let name = $("#name");
        let phone = $("#phone");
        let postal = $("#postal");
        let mail = $("#mail");

        validateForm(name, phone, postal, mail);

    });
});

function validateForm(name, phone, postal, mail) {

    if (/^[A-Z]/.test(name.val()) && name.val().length >= 4) {        
        name.css("background-color","greenyellow");
        $("#nameError").hide();

    } else {
        name.css("background-color","red");
        $("#nameError").text("Incorrect name format!");
        $("#nameError").show();
    }

    if (/^([0-9]{3})\-([0-9]{6})$/.test(phone.val())) {
        phone.css("background-color","greenyellow");
        $("#phoneError").hide();
    } else {
        phone.css("background-color","red");
        $("#phoneError").text("Incorrect phone format!");
        $("#phoneError").show();
    }

    if(postal.val().length == 5) {
        postal.css("background-color","greenyellow");
        $("#postalError").hide();
    } else {
        postal.css("background-color","red");
        $("#postalError").text("Incorrect postal code format!");
        $("#postalError").show();
    }

    if(/^[a-zA-Z0-9\._-]+@[a-zA-Z0-9-]{2,}[.][a-zA-Z]{2,4}$/.test(mail.val())){
        mail.css("background-color","greenyellow");
        $("#mailError").hide();
    } else {
        mail.css("background-color","red");
        $("#mailError").text("Incorrect mail format!");
        $("#mailError").show();
    }
}



