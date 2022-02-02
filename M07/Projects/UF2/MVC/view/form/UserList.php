<div>
<p>User list</p>
<?php
    if(isset($content)){
        echo <<<HER
        <table class="table table-striped table-bordered border-secondary">
        <thead class="table-dark">
        <th>Name</th>
        <th>Password</th>
        </thead>

HER;

        foreach($content as $user){
            echo "<tr><td>".$user->getName()."</td><td>".$user->getPassword()."</td></tr>";
        }
        echo "</table>";
    }
?>
</div>
