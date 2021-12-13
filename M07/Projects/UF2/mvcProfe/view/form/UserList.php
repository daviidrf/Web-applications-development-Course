<div>

<p>User list</p>
<?php
    if(isset($content)){
        echo <<<HER
        <table>
        <tr>
        <th>Name</th>
        <th>Password</th>
        <tr>

HER;

        foreach($content as $user){
            echo "<tr><td>".$user->getName()."</td><td>".$user->getPassword()."</td></tr>";
        }
        echo "</table>";
    }




?>




</div>