<?php
require_once 'functions.php';
header_nav("Inicio");
?>
<section class="vh-100 d-flex align-items-center justify-content-center h-100" style=" margin: 5%;">
    <div class="container py-5 h-100">
        <div class="row d-flex align-items-center justify-content-center h-100">
            <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
                <form action="" method="get">
                    <div class="form-outline mb-4 dspace">
                        <label class="form-label" for="form1Example23" style="margin-bottom: 10px;">Nombre:</label>
                        <input type="text" name="name" id="form1Example23" class="form-control form-control-lg" />
                    </div>
                    <div class="form-outline mb-4 dspace">
                        <label class="form-label" for="form1Example23" style="margin-bottom: 10px;">Apellidos:</label>
                        <input type="text" name="surname" id="form1Example23" class="form-control form-control-lg" />
                    </div>

                    <div class="form-outline mb-4 dspace">
                        <label class="form-label" for="form1Example23" style="margin-bottom: 5px;">Correo Electrónico:</label>
                        <input type="email" name="mail" id="form1Example23" class="form-control form-control-lg" />
                    </div>

                    <div class="form-outline mb-4 dspace">
                        <label class="form-label" for="form1Example23" style="margin-bottom: 5px;">Fecha nacimiento:</label>
                        <input type="date" name="birthdate" id="form1Example23" class="form-control form-control-lg" />
                    </div>

                    <div class="form-outline mb-4 dspace">
                        <label class="form-label" for="form1Example13" style="margin-bottom: 5px;">Usuario:</label>
                        <input type="text" name="user" id="form1Example13" class="form-control form-control-lg" />
                    </div>
                    <div class="form-outline mb-4 dspace">
                        <label class="form-label" for="form1Example23" style="margin-bottom: 5px;">Contraseña:</label>
                        <input type="password" name id="form1Example23" class="form-control form-control-lg" />
                    </div>

                    <div class="form-outline mb-4 dspace">
                        <label class="form-label" for="form1Example23" style="margin-bottom: 10px;">Hobbies: (Selecciona alguno)</label>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                            <label class="form-check-label" for="flexCheckDefault">
                                Deporte
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked">
                            <label class="form-check-label" for="flexCheckChecked">
                                Cine
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked">
                            <label class="form-check-label" for="flexCheckChecked">
                                Musica
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked">
                            <label class="form-check-label" for="flexCheckChecked">
                                Leer
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked">
                            <label class="form-check-label" for="flexCheckChecked">
                                Otros
                            </label>
                        </div>
                    </div>

                    <div class="d-flex justify-content-around align-items-center mb-4 dspace">
                        <a href="login.php">Ya tienes cuenta? Inicia Sesión</a>
                    </div>

                    <button type="submit" name="click" class="btn btn-primary btn-lg btn-block dspace">Registrarse</button>
                </form>
            </div>
        </div>
    </div>
</section>
<?php
if (isset($_GET["click"])) {
    $name = $_GET["name"];
    $surname = $GET["surname"];
    $mail = $_GET["mail"];
    $birthdate = $_GET["birthdate"];
    $user = $_GET["user"];
    $password = $_GET["password"];
}



jvCharge();
?>
</body>

</html>