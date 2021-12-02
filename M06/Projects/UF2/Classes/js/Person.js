// Poniendo # delante haces el método o atributo privado.
class Person {
    // Atributos
    #name;
    #age;

    // Constructor
    constructor(name,age) {
        this.#name = name;
        this.#age = age;
    }

    // Getters y Setters
    get name() {
        return this.#name;
    }

    get age() {
        return this.#age;
    }

    set name(value) {
        this.#name = value;
    }

    set age(value) {
        this.#age = value;
    }


    // Métodos
    loadingFullPerson() {
        return "My name is " + this.name + " and my age is " + this.age;
    }

    loadingName() {
        return "My name is " + this.name;
    }
}