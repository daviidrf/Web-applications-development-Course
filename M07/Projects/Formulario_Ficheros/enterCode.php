<?php
require_once 'functions.php';
header_nav("Inicio");
?>
<div class="mx-auto" style="text-align: center;margin-top:8rem;" id="formulario">
    <!-- <h1>GENERAR SEMANAS</h1> -->
    <form action="enquestes.php" method="post" style="margin-bottom: 2rem;">
        <label style="margin-bottom: 10px;">Escribe un código :</label>
        <input type="text" name="code" class="form-control col-6" placeholder="Code" style="width: 15rem; margin: 0 auto;">
        <input type="submit" name="validar" value="Validar" class="btn btn-primary" style="margin-top: 10px;">
    </form>
</div>
<?php
jvCharge();
?>
</body>

</html>