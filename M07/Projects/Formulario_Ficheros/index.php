<?php
require_once 'functions.php';
header_nav("Inicio");
?>
<div class="mx-auto" style="text-align: center;margin-top:8rem;" id="formulario">
    <div>
        <h1>Bienvenido :D</h1>
        <a href="login.php"><button type="submit" class="btn btn-primary">Login</button></a>
        <a href="register.php"><button type="submit" class="btn btn-primary">Register</button></a>
    </div>
</div>
<?php
jvCharge();
?>
</body>

</html>