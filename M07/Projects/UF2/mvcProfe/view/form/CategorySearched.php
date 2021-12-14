<div>

    <p>Category list</p>
    <?php
    if (isset($content)) {
        echo <<<HER
        <table>
        <tr>
        <th>Name</th>
        <th>Description</th>
        <tr>

HER;
        echo "<tr><td>" . $content->getName() . "</td><td>" . $content->getDescription() . "</td></tr>";
        echo "</table>";
    }




    ?>




</div>