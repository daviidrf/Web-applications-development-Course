<?php
// Inserta la estructura principal de la páginas, está vez tendiendo que cambiará según qué tipo de usuario seas
function loadBody()
{
    echo <<<JRR
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="preconnect" href="https://fonts.googleapis.com"> <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin> <link href="https://fonts.googleapis.com/css2?family=Rubik&display=swap" rel="stylesheet">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
            <link rel="stylesheet" href="css/index.css">
            <title>PRÀCTICA PUNTUABLE (DAW-2)</title>
        </head>

        <body>
        JRR;
    // Según el tipo de rol, la barra tendrá un color disintinto, sino el por defecto
    if (isset($_COOKIE["color"])) {
        echo '<nav class="navbar navbar-expand-lg navbar-dark ' . $_COOKIE["color"] . '">';
    } else {
        echo '<nav class="navbar navbar-expand-lg navbar-dark bg-info">';
    }
    echo <<<JRR
                <div class="container">
                    <a class="navbar-brand" href="#">QuizHoot</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="index.php">Home</a>
                            </li>
        JRR;
    // Cada rol tiene diferentes enlaces a los que ir
    if (isset($_SESSION["role"]) && $_SESSION["role"] == "basic") {
?>
        <li class="nav-item">
            <a class="nav-link" href="quiz.php">Quiz</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="stadistics.php">Stadistics</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="logout.php">Logout</a>
        </li>
    <?php
    } elseif (isset($_SESSION["role"]) && $_SESSION["role"] == "admin") {
    ?>
        <li class="nav-item">
            <a class="nav-link" href="create.php">Create</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="logout.php">Logout</a>
        </li>
    <?php
        // Si no hay rol, insertamos los por defecto
    } else {
    ?>
        <li class="nav-item">
            <a class="nav-link" href="login.php">Login</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="register.php">Register</a>
        </li>
    <?php
    }
    echo <<<HER
                        </ul>
                        <div class="d-flex">
            HER;
    // Hemos añadido también una imagen de tipo de usuario a parte del color
    if (isset($_SESSION["role"]) && $_SESSION["role"] == "admin") {
    ?>
        <img src="img/admin.ico" alt="role" height="40">
    <?php
    } else if (isset($_SESSION["role"]) && $_SESSION["role"] == "basic") {
    ?>
        <img src="img/user.jpg" alt="role" height="40">
<?php
    }
    echo <<<HER
                         </div>
                    </div>
                </div>
            </nav>
            <div class="container min-vh-100">
            HER;
}
