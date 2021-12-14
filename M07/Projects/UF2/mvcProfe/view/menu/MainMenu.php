<nav>
    <ul>
        <li>
            <a href="index.php">Home</a>
        </li>
        <?php
        if (isset($_SESSION["login"])) {
            echo <<<HER
            <li>
                <a href="index.php?menu=category"> Categories</a>
            
            </li>
            <li>
                <a href="index.php?menu=user"> Users</a>
            </li>
            <li>
                <a href="index.php?menu=product"> Products</a>
            </li>
            <li>
            <a href="index.php?menu=user&option=logout"> Logout</a>
            </li>
            HER;
        } else {
            echo <<<HER
            <li>
                <a href="index.php?menu=user&option=showLogin">Login</a>
            </li>
            HER;
        }

        ?>


    </ul>


</nav>