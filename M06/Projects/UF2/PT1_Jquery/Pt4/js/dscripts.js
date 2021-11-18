$(document).ready(function () {

    $("#procesar").click(function () {

        let name = $("#name").val();
        let phone = $("#phone").val();
        let postal = $("#postal").val();
        let mail = $("#mail").val();

        validateForm(name, phone, postal, mail);

    });
});

function validateForm(name, phone, postal, mail) {
    if(valName(name) && valPhone(phone)){
        $("#result").text("Form validated :)")
        $("#result").show();
    }
}


function valName(name) {
    $("#nameError").hide();
    let valid = /^[A-Z]/.test(name);
    if(name.length < 4){
        valid = false;
    }

    if(!valid) {
        $("#nameError").text("Incorrect name format!");
        $("#result").hide();
        $("#nameError").show();
    }

    return valid;
}

function valPhone(phone) {
    $("#phoneError").hide();
    var valid = /^([0-9]{3})\-([0-9]{6})$/.test(phone);

    if(!valid) {
        $("#phoneError").text("Incorrect phone format!");
        $("#result").hide();
        $("#phoneError").show();
    }

    return valid;
}
