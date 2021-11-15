<?php
session_start();
// En el caso de que haya sesión abierta, lo redirigimos a la principal
if (isset($_SESSION["role"])) {
    header("Location: index.php");
}
require_once "functions.php";
loadBody();
?>
<?php
if (isset($_POST["sign"])) {
    $errors = "";
    $allOkay = true;
    $name = filter_input(INPUT_POST, "name", FILTER_SANITIZE_SPECIAL_CHARS);
    $lastName = filter_input(INPUT_POST, "lastName", FILTER_SANITIZE_SPECIAL_CHARS);
    $nick = filter_input(INPUT_POST, "nick", FILTER_SANITIZE_SPECIAL_CHARS);
    $email = filter_input(INPUT_POST, "email", FILTER_SANITIZE_SPECIAL_CHARS);
    $pass = filter_input(INPUT_POST, "pass", FILTER_SANITIZE_SPECIAL_CHARS);
    $date = filter_input(INPUT_POST, "date", FILTER_SANITIZE_SPECIAL_CHARS);
    $afitions = "";

    // Comprobamos que el nombre real no cumple con el patrón de letras y espacio
    if (!preg_match('/^[a-z A-Z]+$/', $name)) {
        $errors .= "Name → only letters or spaces <br>";
        $allOkay = false;
    }

    if (!preg_match('/^[a-z A-Z]+$/', $lastName)) {
        $errors .= "Last name → only letters or spaces <br>";
        $allOkay = false;
    }

    // Comprobamos que el nickname no cumple con el patrón de letras, numeros - y _
    if (!preg_match('/^[a-zA-Z\_\-]+$/', $nick)) {
        $errors .=  "Nickname → Must contains letters, numbers, – or _ <br>";
        $allOkay = false;
    } else {
        // Si lo cumple comprobamos que el nickname no se encuentre ya en el fichero de usuarios
        $file = fopen("users/users.txt", "r");
        while (!feof($file)) {
            $userFile = explode(":", fgets($file));
            if ($nick == $userFile[0]) {
                $allOkay = false;
                $errors .= "Nick name already exists, introduce other";
                break;
            }
        }
    }

    // Comprobamos que el email no es valido
    if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
        $errors .=  "Email → Incorrect email, introduce other <br>";
        $allOkay = false;
    }

    // Comprobamos que la contraseña no cumple con el patrón de letras y numeros de mínimo 8 caracteres
    if (!preg_match('/^[a-zA-Z0-9]{8,}+$/', $pass)) {
        $errors .=  "Password -> At least 8 caracters with uppercase, lowercase letters and numbers <br>";
        $allOkay = false;
    }

    // Comprobamos que no sea un fecha incorrecta
    //  date_parse(), devuelve una array asociativo, en este caso de la fecha
    $date = date_parse($date);
    if (!checkdate($date['month'], $date['day'], $date['year'])) {
        $errors .=  "Date → Must be valid date <br>";
        $allOkay = false;
    }

    // Compararemos que el el año de la fecha introducida es mayor a la actual, si es así sería erróneo
    $currentYear = getdate();
    if ($date['year'] > $currentYear['year']) {
        $errors .=  "Year -> Not valid year <br>";
        $allOkay = false;
    }

    // Comprobamos que hay hoobies seleccionados
    if (isset($_POST["hobbies"])) {
        $afitions = $_POST["hobbies"];
    } else {
        $errors .= "Hobbies → At least 1 hoobie must be selected <br>";
        $allOkay = false;
    }

    // Después de haber comprobado según nuestros criterios de validación que son correctos, 
    // procederemos a introducir la información del usuario en el fichero de usuarios 
    if ($allOkay) {
        $afitionsStr = implode(",", $afitions);
        $dateStr = $date['month'] . '/' . $date['day'] . '/' . $date['year'];
        // En formato CSV para almacenarlo en el fichero, por defecto siempre con rol basic
        $info = "$nick:$pass:$email:$name:$lastName:$dateStr:$afitionsStr:basic:";
        $file = fopen("users/users.txt", "a+");
        fwrite($file, "$info\n");
        fclose($file);
        header("Location: login.php");
    } else {
        echo $errors;
    }
}
?>
<div class="row d-flex justify-content-center align-items-center min-vh-100">
    <form class="row g-4" method="POST" action="register.php">
        <h1 class="text-center">Register</h1>
        <div class="col-md-6">
            <label class="form-label">Name</label>
            <input type="text" class="form-control" name="name" placeholder="Jordi" value="<?php if (isset($_POST['name'])) echo $_POST['name']; ?>">
        </div>
        <div class="col-md-6">
            <label class="form-label">Last name</label>
            <input type="text" class="form-control" name="lastName" placeholder="Rocha" value="<?php if (isset($_POST['lastName'])) echo $_POST['lastName']; ?>">
        </div>
        <div class="col-6">
            <label class="form-label">Nick name</label>
            <input type="text" class="form-control" name="nick" placeholder="jordi_rocha" value="<?php if (isset($_POST['nick'])) echo $_POST['nick']; ?>">
        </div>
        <div class="col-6">
            <label class="form-label">Email</label>
            <input type="text" class="form-control" name="email" placeholder="jordirocha@gmail.com" value="<?php if (isset($_POST['email'])) echo $_POST['email']; ?>">
        </div>
        <div class="col-6">
            <label class="form-label">Password</label>
            <input type="password" class="form-control" name="pass" placeholder="Password" value="<?php if (isset($_POST['pass'])) echo $_POST['pass']; ?>">
        </div>
        <div class="col-6">
            <label class="form-label">Date of birth</label>
            <input type="date" class="form-control" name="date" value="<?php if (isset($_POST['date'])) echo $_POST['date']; ?>">
        </div>
        <div class="col-md-4">
            <label class="form-label">Hobbies</label>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="Programming" name="hobbies[]">
                <label class="form-check-label">
                    Programming
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="Sports" name="hobbies[]">
                <label class="form-check-label">
                    Sports
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="Reading" name="hobbies[]">
                <label class="form-check-label">
                    Reading
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="Listening music" name="hobbies[]">
                <label class="form-check-label">
                    Listening music
                </label>
            </div>
        </div>
        <div class="col-12">
            <input type="submit" class="btn btn-primary" name="sign" value="Sign in"></input>
        </div>
    </form>
</div>

</div>

</body>

</html>