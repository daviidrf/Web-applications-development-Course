class Auto {
    // Atributos
    #marca;
    #modelo;
    #year;
    #precio;
    #puertas;
    #color;
    #transmision;

    // Constructor
    constructor(marca,modelo,year,precio,puertas,color,transmision) {
        this.#marca = marca;
        this.#modelo = modelo;
        this.#year = year;
        this.#precio = precio;
        this.#puertas = puertas;
        this.#color = color;
        this.#transmision = transmision;
    }

    // Getters y Setters
    get marca() {
        return this.#marca;
    }

    get modelo() {
        return this.#modelo;
    }
    
    get year() {
        return this.#year;
    }

    get precio() {
        return this.#precio;
    }

    get puertas() {
        return this.#puertas;
    }

    get color() {
        return this.#color;
    }

    get transmision() {
        return this.#transmision;
    }

    set marca(value) {
        this.#marca = value;
    }

    set modelo(value) {
        this.#modelo = value;
    }

    set year(value) {
        this.#year = value;
    }

    set precio(value) {
        this.#precio = value;
    }

    set puertas(value) {
        this.#puertas = value;
    }

    set color(value) {
        this.#color = value;
    }

    set transmision(value) {
        this.#transmision = value;
    }


    // Métodos
    
}