const marcas = ['Audi','BMW','Mercedes Benz','Chevrolet','Ford','Dodge'];
const modelos = ['A4','Mustang','A6','Serie 5','Clase C','Camaro'];
const puertas = [2,4];
const colores = ['Negro','Blanco','Rojo','Azul'];
const transmisiones = ['Automatico','Manual'];

const autos = [];
generateAutos();





function generateAutos() {
	let maxDate = new Date().getFullYear();
	let minDate = maxDate - 10;

	for (let index = 0; index < 15; index++) {

		let marca = marcas[Math.floor(Math.random() * marcas.length)];
		let modelo = modelos[Math.floor(Math.random() * modelos.length)];
		let year = Math.floor(Math.random() * (90000-20000) + 20000);
		let precio = Math.floor(Math.random() * (maxDate-minDate) + minDate);
		let puerta = puertas[Math.floor(Math.random() * puertas.length)];
		let color = colores[Math.floor(Math.random() * colores.length)];

		autos.push(new Auto(marca,modelo,year,precio,puerta,color));
	}
}