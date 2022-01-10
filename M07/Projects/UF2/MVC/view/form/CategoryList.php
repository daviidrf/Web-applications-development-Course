<div>
<p>Category list</p>
<?php
    if(isset($content)){
        echo <<<HER
        <table class="table table-striped table-bordered border-secondary">
        <thead class="table-dark">
        <th>Name</th>
        <th>Description</th>
        </thead>

HER;

        foreach($content as $category){
            echo "<tr><td>".$category->getName()."</td><td>".$category->getDescription()."</td></tr>";
        }
        echo "</table>";
    }
?>
</div>
