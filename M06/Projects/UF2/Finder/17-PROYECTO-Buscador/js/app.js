// Selectores
const marca = $("#marca");
const year = $("#year");
const minimo = $("#minimo");
const maximo = $("#maximo");
const puertas = $("#puertas");
const transmision = $("#transmision");
const color = $("#color");

// crear los años
const max = new Date().getFullYear();
const min = max - 10;


for (let i = max; i > min; i--) {
    $('#year').append($('<option/>').val(i).text(i));
}

// Datos para la busqueda
const datosBusqueda = {
    marca: '',
    year: '',
    minimo: '',
    maximo: '',
    puertas: '',
    transmision: '',
    color: ''
}

$(document).ready(function () {
    mostrarAutos(autos);
});

// Event Listeners para el formulario
$(marca).click('input', e => {
    datosBusqueda.marca = e.target.value;
    filtrarAuto();
});

$(year).click('input', e => {
    datosBusqueda.year = Number(e.target.value);
    filtrarAuto();
});

$(minimo).click('input', e => {
    datosBusqueda.minimo = Number(e.target.value);
    filtrarAuto();
});


$(maximo).click('input', e => {
    datosBusqueda.maximo = Number(e.target.value);
    filtrarAuto();
});


$(puertas).click('input', e => {
    datosBusqueda.puertas = Number(e.target.value);
    filtrarAuto();
});

$(transmision).click('input', e => {
    datosBusqueda.transmision = e.target.value;
    filtrarAuto();
});

$(color).click('input', e => {
    datosBusqueda.color = e.target.value;
    filtrarAuto();
});

function limpiarHTML() {
    $("#resultado").empty();
}

function mostrarAutos(autos) {
    limpiarHTML();

    // Construir el HTML de los autos
    autos.forEach(auto => {
        $("#resultado").append($('<p/>').html(`
        <p>${auto.marca} ${auto.modelo} - ${auto.year} - ${auto.puertas} Puertas - Transmisión: ${auto.transmision} - Precio: ${auto.precio} - Color: ${auto.color}</p>
    `));
    })
}
function noResultado() {
    limpiarHTML();
    $("#resultado").append($('<div/>').addClass("alerta error").html('No hay Reultados'))
}

function filtrarAuto() {
    const resultado = autos.filter(filtrarMarca).filter(filtrarYear).filter(filtrarMinimo).filter(filtrarMaximo).filter(filtrarPuertas).filter(filtrarTransmision).filter(filtrarColor);

    if (resultado.length) {
        mostrarAutos(resultado);
    } else {
        noResultado();
    }
}


// Aplica los filtros
function filtrarMarca(auto) {
    if (datosBusqueda.marca) {
        return auto.marca === datosBusqueda.marca;
    }
    return auto;
}
function filtrarYear(auto) {
    if (datosBusqueda.year) {
        return auto.year === datosBusqueda.year;
    }
    return auto;
}

function filtrarMinimo(auto) {
    if (datosBusqueda.minimo) {
        return auto.precio >= datosBusqueda.minimo;
    }
    return auto;
}
function filtrarMaximo(auto) {
    if (datosBusqueda.maximo) {
        return auto.precio <= datosBusqueda.maximo;
    }
    return auto;
}
function filtrarPuertas(auto) {
    if (datosBusqueda.puertas) {
        return auto.puertas === datosBusqueda.puertas;
    }
    return auto;
}

function filtrarTransmision(auto) {
    if (datosBusqueda.transmision) {
        return auto.transmision === datosBusqueda.transmision;
    }
    return auto;
}

function filtrarColor(auto) {
    if (datosBusqueda.color) {
        return auto.color === datosBusqueda.color;
    }
    return auto;
}