<?php
session_start();
// En el caso de que la sesión no exista o sus roles sean diferentes a admin, 
// los mandaremos a la principal
if (!isset($_SESSION["role"]) || $_SESSION["role"] != "admin") {
    header("Location: index.php");
}
require_once "functions.php";
loadBody();
?>
<?php
if (isset($_POST["btnCreate"])) {
    $allOkay = true;
    $errors = "";
    $code = filter_input(INPUT_POST, "code", FILTER_SANITIZE_SPECIAL_CHARS);
    $title = filter_input(INPUT_POST, "title", FILTER_SANITIZE_SPECIAL_CHARS);
    // Datos de la 1r pregunta
    $question1 = filter_input(INPUT_POST, "question1", FILTER_SANITIZE_SPECIAL_CHARS);
    $answers1 =  $_POST["answer1"];
    $correct1 = $_POST["okans1"];
    // Datos de la 2n pregunta
    $question2 = filter_input(INPUT_POST, "question2", FILTER_SANITIZE_SPECIAL_CHARS);
    $answers2 = $_POST["answer2"];
    $correct2 = $_POST["okans2"];
    // Datos de la 3r pregunta
    $question3 = filter_input(INPUT_POST, "question3", FILTER_SANITIZE_SPECIAL_CHARS);
    $answers3 = $_POST["answer3"];
    $correct3 = $_POST["okans3"];

    // Comprobaremos que el código cumple con el patrón
    if (preg_match('/^[a-zA-Z0-9]{4,10}+$/', $code)) {
        // Después de haberlo comprobado, hay que verificar que el fichero 
        // con el nombre del código exista
        if (file_exists("quiz/{$code}.txt")) {
            $allOkay = false;
            $errors .= "The code introduced already exists<br>";
        }
    } else {
        $allOkay = false;
        $errors .= "The code introduced isn't valid<br>";
    }

    // Comprobamos que el titulo está vacío
    if (empty($title)) {
        $errors .= "Title is empty<br>";
        $allOkay = false;
    }

    // Comprobamos que los titulos de las preguntas están vacios
    if (empty($question1) || empty($question1) || empty($question1)) {
        $allOkay = false;
        $errors .= "Empty question<br>";
    }

    // Cada respuesta un array de 3 posiciones con las posibles respuestas, 
    // comprobaremos si tienen alguna posición vacía, que no tiene respuesta escrita
    if (checkAnwsers($answers1) || checkAnwsers($answers2) || checkAnwsers($answers3)) {
        $allOkay = false;
        $errors .= "Missing answers on questions<br>";
    }

    if (!$allOkay) {
        echo $errors;
    } else {
        // Abriremos fichero, en este no existe, por eso ponemos a+, nos creará el fichero a escribir
        $fileQuiz = fopen("quiz/$code.txt", "a+");
        // Todas las respuestas que son arrays, las convertiremos a string separadas por ':'
        $q1 = implode(":", $answers1);
        $q2 = implode(":", $answers2);
        $q3 = implode(":", $answers3);
        // En formato CSV para almacenarlo en el fichero
        $question = "$title;$question1;$q1;$question2;$q2;$question3;$q3";
        fwrite($fileQuiz, $question);
        fclose($fileQuiz);
        // Abriremos fichero, en este no existe, por eso ponemos a+, nos creará el fichero a escribir
        $fileAnwser = fopen("answers/$code.txt", "a+");
        $answers = "$correct1:$correct2:$correct3";
        fwrite($fileAnwser, $answers);
        fclose($fileAnwser);
        // Una vez creada, redirigiremos a la misma página, en nuestro caso para para 
        // mostrar que se ha añadido creado correctamente
        header("Location: create.php?status=ok");
    }
}

// Si existe el estado mostraremos mensaje al usuario
if (isset($_GET["status"])) {
    echo <<<JRR
        <div class="alert alert-success mt-5" role="alert">Quiz correctly created</div>
    JRR;
}

// Comprueba que dado un array si el valor de sus posiciones se encuentra vacío
function checkAnwsers($arrAnswers)
{
    for ($i = 0; $i < sizeof($arrAnswers); $i++) {
        if (empty($arrAnswers[$i])) {
            return true;
        }
    }
    return false;
}

?>
<div class="row d-flex justify-content-center align-items-center min-vh-100">
    <form class="row g-3" method="POST">
        <h1 class="text-center">Create quiz</h1>
        <div class="col-md-6">
            <label class="form-label">Code</label>
            <input type="text" class="form-control" name="code" value="<?php if (isset($_POST['code'])) echo $_POST['code']; ?>">
        </div>
        <div class="col-md-6">
            <label class="form-label">Title</label>
            <input type="text" class="form-control" name="title" value="<?php if (isset($_POST['title'])) echo $_POST['title']; ?>">
        </div>
        <div class="col-12">
            <label class="form-label">Question 1</label>
            <input type="text" class="form-control" name="question1" value="<?php if (isset($_POST['question1'])) echo $_POST['question1']; ?>">
        </div>
        <div class="col-6">
            <label class="form-label">Answer</label>
            <input type="text" class="form-control" name="answer1[]" value="<?php if (isset($_POST['answer1'])) echo $_POST['answer1'][0]; ?>">
        </div>
        <div class="col-6">
            <label class="form-label">Answer</label>
            <input type="text" class="form-control" name="answer1[]" value="<?php if (isset($_POST['answer1'])) echo $_POST['answer1'][1]; ?>">
        </div>
        <div class="col-6">
            <label class="form-label">Answer</label>
            <input type="text" class="form-control" name="answer1[]" value="<?php if (isset($_POST['answer1'])) echo $_POST['answer1'][2]; ?>">
        </div>
        <div class="col-md-4">
            <label for="inputState" class="form-label">Correct answer</label>
            <select name="okans1" class="form-select">
                <option value="0A" selected>1</option>
                <option value="0B">2</option>
                <option value="0C">3</option>
            </select>
        </div>
        <div class="col-12">
            <label class="form-label">Question 2</label>
            <input type="text" class="form-control" name="question2" value="<?php if (isset($_POST['question2'])) echo $_POST['question2']; ?>">
        </div>
        <div class="col-6">
            <label class="form-label">Answer</label>
            <input type="text" class="form-control" name="answer2[]" value="<?php if (isset($_POST['answer2'])) echo $_POST['answer2'][0]; ?>">
        </div>
        <div class="col-6">
            <label class="form-label">Answer</label>
            <input type="text" class="form-control" name="answer2[]" value="<?php if (isset($_POST['answer2'])) echo $_POST['answer2'][1]; ?>">
        </div>
        <div class="col-6">
            <label class="form-label">Answer</label>
            <input type="text" class="form-control" name="answer2[]" value="<?php if (isset($_POST['answer2'])) echo $_POST['answer2'][2]; ?>">
        </div>
        <div class="col-md-4">
            <label for="inputState" class="form-label">Correct answer</label>
            <select name="okans2" class="form-select">
                <option value="1A" selected>1</option>
                <option value="1B">2</option>
                <option value="1C">3</option>
            </select>
        </div>
        <div class="col-12">
            <label class="form-label">Question 3</label>
            <input type="text" class="form-control" name="question3" value="<?php if (isset($_POST['question3'])) echo $_POST['question3']; ?>">
        </div>
        <div class="col-6">
            <label class="form-label">Answer</label>
            <input type="text" class="form-control" name="answer3[]" value="<?php if (isset($_POST['answer3'])) echo $_POST['answer3'][0]; ?>">
        </div>
        <div class="col-6">
            <label class="form-label">Answer</label>
            <input type="text" class="form-control" name="answer3[]" value="<?php if (isset($_POST['answer3'])) echo $_POST['answer3'][1]; ?>">
        </div>
        <div class="col-6">
            <label class="form-label">Answer</label>
            <input type="text" class="form-control" name="answer3[]" value="<?php if (isset($_POST['answer3'])) echo $_POST['answer3'][2]; ?>">
        </div>
        <div class="col-md-4">
            <label for="inputState" class="form-label">Correct answer</label>
            <select name="okans3" class="form-select">
                <option value="2A" selected>1</option>
                <option value="2B">2</option>
                <option value="2C">3</option>
            </select>
        </div>
        <div class="col-12">
            <input type="submit" name="btnCreate" value="Create" class="btn btn-primary"></input>
        </div>
    </form>
</div>

</div>

</body>

</html>