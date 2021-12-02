// Javascript: Objetos -> Colección de propiedades
    var myCar = { // Objecte
        make: 'Ford',
        model: 'Mustang',
        year: 1969
    } 

    console.log(myCar);


// Javascript: Clases -> Instancia una clase
    var person1 = new Person("Carlos",23);

    console.log(person1.loadingFullPerson());
    console.log(person1.loadingName());

    person1.name = "Jordi"; // Para cambiar un valor se llama al setter
    console.log(person1.loadingName());


// LocalStorage
    // Forma 1 de crear y llamar
    localStorage.setItem("test",23);
    localStorage.setItem("user","proves");

    alert(localStorage.getItem("test"));

    // Forma 2 de crear y llamar
    localStorage.data = "Pedrito";

    alert(localStorage.data);

    // Borrar LocalStorage
    delete localStorage.user;