<nav>
    <ul>
        <li>
            <a href="index.php">Home</a>
        </li>
        <?php
        if (isset($_SESSION["login"])) {
            echo <<<HER
        <li>
            <a href="index.php?menu=user&option=list"> List all Users</a>
        </li>

        <li>
            <a href="index.php?menu=user&option=formAdd"> Add a User</a>
        </li>
        <!--
        <li>
            <a href="index.php?menu=user&option=formDelete"> Delete a User</a>
        </li>
        -->
        HER;
        } else {
            //header("Location:index.php");
        }
        ?>

        <!--el resto de opciones-->

    </ul>


</nav>