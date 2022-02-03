class Issue {
    // Atributos
    #location;
    #identificator;
    #description;
    #date;
    #phone;
    #mail;
    #priority;

    // Constructor
    constructor(location,identificator,description,date,phone,mail,priority) {
        this.#location = location;
        this.#identificator = identificator;
        this.#description = description;
        this.#date = date;
        this.#phone = phone;
        this.#mail = mail;
        this.#priority = priority;
    }

}