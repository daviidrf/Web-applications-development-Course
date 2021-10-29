<?php
require_once 'functions.php';
header_nav("Inicio");
?>
<section class="vh-100 d-flex align-items-center justify-content-center h-100" style=" margin: 10%;">
    <div class="container py-5 h-100">
        <div class="row d-flex align-items-center justify-content-center h-100">
            <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
                <form action="" method="get">
                    <div class="form-outline mb-4 dspace">
                        <label class="form-label" for="form1Example13" style="margin-bottom: 10px;">Usuario:</label>
                        <input type="email" id="form1Example13" class="form-control form-control-lg" />
                    </div>

                    <div class="form-outline mb-4 dspace">
                        <label class="form-label" for="form1Example23" style="margin-bottom: 10px;">Contraseña:</label>
                        <input type="password" id="form1Example23" class="form-control form-control-lg" />
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