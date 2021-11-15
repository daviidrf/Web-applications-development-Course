<?php
session_start();
require_once 'functions.php';
header_nav("Inicio");

$user = $_GET["user"];
$pass = $_GET["password"];
$sesion = false;

//echo $user . " " . $pass;

if(file_exists("recursos/users.txt")){
    $usersFile = fopen("recursos/users.txt", "r");

    while(!feof($usersFile)){
        $users = explode(':', fgets($usersFile));
        //var_dump($users);
        if($users[0] == $user && $users[1] == $pass){
            echo "USER VALIDO";
            $_SESSION["userS"] = $user;
            //$_SESSION["rolS"] = $users[7];
            $sesion = true;
        } 
    }

    if($sesion){
        header("Location:enquestes.php");
    }
    
}
?>
<section class="vh-100 d-flex align-items-center justify-content-center h-100" style=" margin: 10%;">
    <div class="container py-5 h-100">
        <div class="row d-flex align-items-center justify-content-center h-100">
            <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
                <form action="" method="GET">
                    <div class="form-outline mb-4 dspace">
                        <label class="form-label" for="form1Example13" style="margin-bottom: 10px;">Usuario:</label>
                        <input type="text" name="user" id="form1Example13" class="form-control form-control-lg" />
                    </div>

                    <div class="form-outline mb-4 dspace">
                        <label class="form-label" for="form1Example23" style="margin-bottom: 10px;">Contraseña:</label>
                        <input type="text" name="password" id="form1Example23" class="form-control form-control-lg" />
                    </div>

                    <div class="d-flex justify-content-around align-items-center mb-4 dspace">
                        <a href="register.php">No tienes cuenta? Registrate</a>
                    </div>

                    <button type="submit" class="btn btn-primary btn-lg btn-block dspace">Iniciar Sesión</button>
                </form>
            </div>
        </div>
    </div>
</section>
<?php
jvCharge();
?>
</body>

</html>