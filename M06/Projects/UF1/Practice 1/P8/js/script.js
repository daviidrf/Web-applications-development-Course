document.addEventListener("DOMContentLoaded", function () {
    var interval = setInterval(clock, 1000);
}, false);


function clock() {
    var days = document.getElementById("days");
    var months = document.getElementById("months");
    var years = document.getElementById("years");
    var hours = document.getElementById("hours");
    var minutes = document.getElementById("minutes");
    var seconds = document.getElementById("seconds");
    var phase = document.getElementById("phase");

    var date = new Date();

    var day = date.getDate();
    var month = date.getMonth();
    var year = date.getFullYear();
    var h = new Date().getHours();
    var m = new Date().getMinutes();
    var s = new Date().getSeconds();
    var am = "AM";

    if (h > 12) {
        h = h - 12;
        var am = "PM";
    }

    h = h < 10 ? "0" + h : h;
    m = m < 10 ? "0" + m : m;
    s = s < 10 ? "0" + s : s;

    days.innerHTML = day;
    months.innerHTML = month;
    years.innerHTML = year;
    hours.innerHTML = h;
    minutes.innerHTML = m;
    seconds.innerHTML = s;
    phase.innerHTML = am;
}

