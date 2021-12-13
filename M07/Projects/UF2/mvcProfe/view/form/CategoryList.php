<div>

<p>Category list</p>
<?php
    if(isset($content)){
        echo <<<HER
        <table>
        <tr>
        <th>Name</th>
        <th>Description</th>
        <tr>

HER;

        foreach($content as $category){
            echo "<tr><td>".$category->getName()."</td><td>".$category->getDescription()."</td></tr>";
        }
        echo "</table>";
    }




?>




</div>