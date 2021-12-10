$(document).ready(function () {
  $("#date1").datepicker({
    firstDay: 1,
    dateFormat: "dd/mm/yy",
    dayNamesMin: ["Dg", "Dl", "Dm", "Dc", "Dj", "Dv", "Ds"],
    monthNames: [
      "Gener",
      "Febrer",
      "Març",
      "Abril",
      "Maig",
      "Juny",
      "Juliol",
      "Agost",
      "Septembre",
      "Octubre",
      "Novembre",
      "Decembre",
    ],
    minDate: 0,
    maxDate: "+2m",
  });
  

  
});

$("#date1").click(function() {
    $("#date2").datepicker({
        firstDay: 1,
        dateFormat: "dd/mm/yy",
        dayNamesMin: ["Dg", "Dl", "Dm", "Dc", "Dj", "Dv", "Ds"],
        monthNames: [
          "Gener",
          "Febrer",
          "Març",
          "Abril",
          "Maig",
          "Juny",
          "Juliol",
          "Agost",
          "Septembre",
          "Octubre",
          "Novembre",
          "Decembre",
        ],
        //minDate: $("#date1").text(),
        maxDate: "+2m",
      });
});
    

