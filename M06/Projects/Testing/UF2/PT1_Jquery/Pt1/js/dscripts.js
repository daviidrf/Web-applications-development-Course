$(document).ready(function () {
    $("#calcular").click(function () {

        let val1 = $("#num1").val();
        let val2 = $("#num2").val();
        let result = $("#result");

        if (val1 == "" || val2 == "") {
            result.text("No puedes dejar ningún número vacio!");
        } else {
            let operation = $("#operation").val();
            val1 = parseInt(val1);
            val2 = parseInt(val2);

            if (operation == "suma") {
                result.text(val1 + val2);
            } else if (operation == "resta") {
                result.text(val1 - val2);
            } else if (operation == "producto") {
                result.text(val1 * val2);
            } else if (operation == "division") {
                result.text(val1 / val2);
            } else {
                result.text("Operacion invalida!");
            }
        }


    });

});