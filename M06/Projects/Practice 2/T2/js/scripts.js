document.addEventListener("DOMContentLoaded", function () {

    document.getElementById("get_data").addEventListener("click", function () {
        let iframe1 = document.getElementById("iframe1");
        console.log(iframe1);
        let info = iframe1.contentWindow.document.getElementById("div_iframe").innerText;
        console.log(info);

    }, false);


    //let iframe2 = windows.frames;
    //console.log(iframe2);

}, false);