const espais = ["Sala de reunions", "Despatx de direcció", "Sala de videoconferències"];
var idInv;

// Coses que carrega desde que s'entra a la pàgina
$(document).ready(function () {

    console.log("Js cargat...");
    $("#form2").hide();

    var selectEspai = '<label class="form-label">Espai on sha introduit la incidència</label> ' +
        '<select id="espaiSelected" class="form-select">';

    // Afegim cada element del array d'espais.
    espais.forEach(element => selectEspai = selectEspai +
        '<option value="' + element + '">' + element + '</option>');

    selectEspai = selectEspai + '</select><div id="selectError"></div>';


    $("#selectEspai").html(selectEspai);

    $("#datepick1").datepicker({
        dayNamesMin: ["Dg", "Dl", "Dm", "Dc", "Dj", "Dv", "Ds"],
        monthNames: ["Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Septembre", "Octubre", "Novembre", "Desembre"],
        dateFormat: "dd/mm/yy",
        firstDay: 1,
        minDate: "-7D",
        maxDate: 0
    })

    
});

// Mostrar o cultar seccions segons els errors

function validateForm1() {
    if (Form1()) {
        $("#issueDisplay").hide();
        $("#form1").hide();
        $("#form2").show();
        

        $("#form2title").html($("#espaiSelected").val())
        $("#form2id").html($("#idInv").val())

        let form2interval = setInterval(function() {
            if(Form2()) {
                $("#form2btn").removeAttr('disabled');
                clearInterval(form2interval);
            }
        }, 1000);
    }

}

function validateForm2() {

    if (Form2()) {
        $("#form2").hide();
        $("#issueDisplay").show(); 
    }

}





// Operacions per validar camps

function Form1() {
    let idInv = $("#idInv").val();
    if (idInv.length != 9) {
        $("#idError").html('<p class="error">Identificador incorrecto</p>');
        console.log("Form no valido");
        return false;
    } else {
        $("#idError").hide();
        console.log("Form valido");
        return true;
    }
}

function Form2() {
    let validated = false;

    let desc = $("#description").val();
    if (desc.length <= 150 && desc.length > 0) {
        $("#descError").hide();
        validated = true;
    } else {
        $("#descError").show();
        $("#descError").html('<p class="error">Descripció sobrepasa els caràcters soportats</p>');
        validated = false;
    }

    if($("#datepick1").val().length != 0) {
        $("#dateError").hide();
        validated = true;
    } else {
        $("#dateError").show();
        $("#dateError").html('<p class="error">Fica una data</p>');
        validated = false;
    }

    if (/^([6][0-9]{8})$/.test($("#phone").val()) || /^([9][3][0-9]{7})$/.test($("#phone").val())) {
        $("#phoneError").hide();
        validated = true;
    } else {
        $("#phoneError").show();
        $("#phoneError").html('<p class="error">Teléfon incorrecte</p>');
        validated = false;
    }

    if (/^[a-zA-Z0-9\._-]+@[a-zA-Z0-9-]{2,}[.][a-zA-Z]{2,4}$/.test($("#mail").val())) {
        $("#mailError").hide();
        validated = true;
    } else {
        $("#mailError").show();
        $("#mailError").html('<p class="error">Correu incorrecte</p>');
        validated = false;
    }

    return validated;
}
