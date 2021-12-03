
function darkMode() {
    // Change body color
    var body = document.body;
    body.classList.toggle("bg-dark");
    body.classList.toggle("text-dark");
    body.classList.toggle("text-light");

    // Change navbar color
    var nav = document.getElementById("topNav");
    nav.classList.toggle("navbar-dark");
    nav.classList.toggle("bg-dark");

    // Change dark/light button color
    var changeBtn = document.getElementById("changeColor");
    changeBtn.classList.toggle("bi-moon");
    changeBtn.classList.toggle("bi-brightness-high");
}
