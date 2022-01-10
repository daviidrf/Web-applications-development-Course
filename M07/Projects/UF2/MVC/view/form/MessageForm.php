<div id="info">
    <?php
        if (isset($_SESSION['info'])) {
            foreach ($_SESSION['info'] as $info) {
                echo "<p>$info</p>";
            }
        }
        else {
            echo "<p>{$_SESSION['info']}</p>";          
        }
    ?>
</div>
<div id="error">
    <?php
        if (isset($_SESSION['error'])) {
            foreach ($_SESSION['error'] as $error) {
                echo "<p>$error</p>";
            }
        }
        else {
            echo "<p>{$_SESSION['error']}</p>";            
        }
    ?>
</div>
