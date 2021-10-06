<?php
require_once 'functions.php';
header_nav("Exercici 1");
?>
<div class="mx-auto" style="text-align: center; margin-top:8rem;" id="formulario">
  <h1>TABLA DE MULTIPLICAR</h1>
  <form action="ex1.php" method="post" style="margin-bottom: 2rem;">
    <label style="margin-bottom: 10px;">Escribe un número entre 0 y 20 :</label>
    <input type="text" name="numero" class="form-control col-6 mx-auto" placeholder="Numero" style="width: 9rem; margin: 0 auto;">
    <input type="submit" name="calcula" value="Calcula las tablas" class="btn btn-primary" style="margin-top: 10px;">
  </form>

  <?php
  $num = $_POST['numero'];

  if ($num > 0 && $num <= 20) { ?>
    <table border="3" class="table table-bordered mb-5 align-middle table-hover" id="dtabla">
      <tr>
        <th>X</th>
        <?php
        for ($i = 1; $i <= 10; $i++) {
          echo "<th>$i</th>";
        }
        ?>
      </tr>
      <tr>
        <?php
        for ($i = 1; $i <= $num; $i++) {
          echo "<tr>";
          echo "<th>$i</th>";
          for ($j = 1; $j <= 10; $j++) {
            echo "<td>" . $i * $j . "</td>";
          }
          echo "</tr>";
        }
        ?>
      </tr>
    </table>
  <?php
  } else {
    echo "<br>Este número no esta en el rango permitido!";
  }
  ?>
</div>

<?php
    jvCharge();
?>
</body>

</html>