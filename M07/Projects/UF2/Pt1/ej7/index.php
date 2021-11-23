<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Discogràfica</title>
</head>

<body>
    <?php
    require_once "clases/Guitar.php";
    require_once "clases/Guitarist.php";
    require_once "clases/LeadGuitarist.php";
    require_once "clases/RockBand.php";


    $band = new RockBand("Pirates of the Caribbean");
    $bandMemberA = new Guitarist("Jack", "Sparrow");
    $bandMemberB = new LeadGuitarist("Keira", "Knighley");

    $bandMemberA->addInstrument(new Guitar("Gibson SG"));
    $bandMemberB->addInstrument(new Guitar("Fender Stratocaster"));
    $bandMemberB->addInstrument(new Guitar("Superstrat"));

    $band->addMusician($bandMemberA);
    $band->addMusician($bandMemberB);

    foreach ($band->getMusicians() as $musician) {
        echo "Musician " . $musician->getName() . "<br>";
        echo "is the " . $musician->getMusicianType() . "<br>";
        echo "in the  " . $band->getName() . " band <br>";
        echo "called " . $band->getGenre() . "<br>";

        foreach ($musician->getInstruments() as $instrument) {

            echo "And plays the " . $instrument->getName() . " ";
            echo $instrument->getCategory() . "<br>";
        }
        echo "<p>";
    }
    ?>
</body>

</html>