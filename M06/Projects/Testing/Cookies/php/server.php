<?php
    //$ar = ["daw2","daw"];
    //echo json_encode($ar);

    $info = file_get_contents('php://input');
    //var_dump($info);

    $info = json_decode($info);
    var_dump($info);

    echo json_encode($info);

    //echo json_encode($_GET["variable"]);
?>