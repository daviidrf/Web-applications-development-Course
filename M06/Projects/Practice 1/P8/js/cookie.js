document.addEventListener("DOMContentLoaded", function () {
    alertCookie();
}, false);

function alertCookie() {

    var cookieAlert = document.querySelector(".cookiealert");
    var acceptCookies = document.querySelector(".acceptcookies");

    if (!cookieAlert) {
        return;
    }

    cookieAlert.offsetHeight;

    if (!getCookie("acceptCookies")) {
        cookieAlert.classList.add("show");
    }

    // When clicking on the agree button, create a 1 year
    // cookie to remember user's choice and close the banner
    acceptCookies.addEventListener("click", function () {
        setCookie("acceptCookies", true);
        cookieAlert.classList.remove("show");

        // dispatch the accept event
        window.dispatchEvent(new Event("cookieAlertAccept"))
    });

    //CREA LA COOKIE AL CLICAR EL BOTON
    // setCookie(cname, cvalue);
    //RECOGE LA COOKIE Y COMPRUEBA SI EXISTE YA
    getCookie(cname);
}

function setCookie(cname, cvalue) {
    var d = new Date();
    var fechaCad = d.setTime(d.getTime() + 60 * 60 * 24 * 7 * 1000);
    var expires = "expires=" + d.toUTCString(fechaCad);
    document.cookie = cname + "=" + cvalue + ";" + expires + ";";
}

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var decCS = decodedCookie.split(';');
    for (var i = 0; i < decCS.length; i++) {
        var c = decCS[i];
        while (c.charAt(0) === ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) === 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}