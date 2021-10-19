var interval, timeout;
document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("btnStart").addEventListener("click", start);
    document.getElementById("btnEnd").addEventListener("click", end);
});


function func1(){
    console.log("HOLA");
}

function func2(){
    console.log("ADIOS");
}

function start(){
    interval = setInterval(func1,1000);
}

function end(){
    clearTimeout(interval);
    timeout = setTimeout(func2,4000);
}