let ciclos = ["DAW", "DAM", "ASIX"];
console.log(ciclos);


ciclos[2] = "DAW_BIO";
console.log(ciclos);


// for (let x in ciclos) {
//     console.log(ciclos[x]);
// }
console.log(ciclos.join('-'));


ciclos.push("ASIX");
console.log(ciclos.join('-'));


let index = ciclos.indexOf("DAM");
console.log(ciclos[index]);


if (index != -1) {
    ciclos.splice(index, 1, "CYBER");
}
console.log(ciclos.join('-'));


let elements = ciclos.slice(2,3);
console.log(ciclos);
console.log(elements);

///////////////////////////////////////////////////////

let text = "Hola que tal";
let subtext = text.substr(0,5);
console.log(text);
console.log(subtext);

let replace = text.replace("Hola", "Hello");
console.log(replace);

let MAYUS = "DAVID";
let minus = "david";

console.log(text.split(" "));

const accentsMap = new Map([
    ["A", "Á|À|Ã|Â|Ä"],
    ["a", "á|à|ã|â|ä"],
    ["E", "É|È|Ê|Ë"],
    ["e", "é|è|ê|ë"],
    ["I", "Í|Ì|Î|Ï"],
    ["i", "í|ì|î|ï"],
    ["O", "Ó|Ò|Ô|Õ|Ö"],
    ["o", "ó|ò|ô|õ|ö"],
    ["U", "Ú|Ù|Û|Ü"],
    ["u", "ú|ù|û|ü"],
    ["C", "Ç"],
    ["c", "ç"],
    ["N", "Ñ"],
    ["n", "ñ"]
  ]);




let frase = "Hola, que tal estás.";


console.log(frase);
console.log(fraseLimpia);

