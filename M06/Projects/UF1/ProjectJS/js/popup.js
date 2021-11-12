var totalPrice = 0;
window.addEventListener('DOMContentLoaded', function () {
    let produts = document.getElementById("products");
    chargeDate();

    let jsonStringCart = getCookie('cart');
    let cartArray = JSON.parse(jsonStringCart);

    cartArray.forEach(function (item) {
        let tr = document.createElement("tr");
        tr.innerHTML = `
            <td>${item.id}</td>
            <td><img src="${item.img}" alt="" height="70"></td>
            <td>${item.name}</td>
            <td>${item.quantity}</td>
            <td>${item.price} $</td>
            `;
        produts.append(tr);
        totalPrice += item.price * item.quantity;
    });
    let tr = document.createElement("tr");
    tr.innerHTML = `
        <td></td>
        <td></td>
        <td></td>
        <td><b>Total</b></td>
        <td><b>${totalPrice} $</b></td>
    `;
    produts.appendChild(tr);

    document.getElementById("btnPrint").addEventListener("click", printTicket);
    document.getElementById("btnCancel").addEventListener("click", closePopup);

});


function getCookie(name) {
    var match = document.cookie.match(new RegExp('(^| )' + name + '=([^;]+)'));
    if (match) return match[2];
    // let arrCook = document.cookie.split(";");
    // for (let i = 0; i < arrCook.length; i++) {
    //     if (arrCook[i].includes(cname + "=true")) {
    //         return arrCook[i].split("=")[1];;
    //     }
    // }
    // return "";
}

function chargeDate() {
    let dateDiv = document.getElementById("date");

    let date = new Date();
    let month = date.toLocaleString("default", { month: 'long' });
    let dayName = date.toLocaleString("default", { weekday: 'long' });
    let day = date.getDay();
    let year = date.getFullYear();

    dateDiv.innerText = `${dayName} dia ${day}, de/d’${month} del ${year}`;
}

function printTicket() {
    window.print();
    let jsonStringCart = getCookie('cart');
    let cartArray = JSON.parse(jsonStringCart);

    cartArray = [];
    ArrayToString(cartArray);

    window.opener.updateCart();
}

function closePopup() {
    window.close();
}

function ArrayToString(array) {
    let jsonStringCart = JSON.stringify(array);
    document.cookie = "cart=" + jsonStringCart;
}