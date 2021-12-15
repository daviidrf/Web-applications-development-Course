<nav>
    <ul>
        <li>
            <a href="index.php">Home</a>
        </li>
        <?php
        if (isset($_SESSION["login"])) {
        echo <<<HER
            <li>
            <a href="index.php?menu=category&option=list"> List all Categories</a>
            </li>

            <li>
                <a href="index.php?menu=category&option=formAdd"> Add a Category</a>

            </li>

            <li>
                <a href="index.php?menu=category&option=search"> Search a Category</a>

            </li>
        HER;
        } else {
            header("Location:index.php");
        }
        ?>
            <!--el resto de opciones-->
            
    </ul>


</nav>