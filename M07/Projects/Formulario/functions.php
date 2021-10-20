<?php

function header_nav($title)
{
  //HER notacion especial php en lugar de la comillas
  //simples para que las variables funcionen.
  echo <<<HER
    <!DOCTYPE html>
    <html lang="es">
    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <title>$title</title>
      <link  rel="icon"  href="img/logoSithM.png" type="image/png" />
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,500' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Lato:300,400' rel='stylesheet' type='text/css'>

        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
    
        <!-- Google Fonts  -->
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,500' rel='stylesheet' type='text/css'>
        <!-- Body font -->
        <link href='http://fonts.googleapis.com/css?family=Lato:300,400' rel='stylesheet' type='text/css'>
        <!-- Navbar font -->
    
        <!-- Libs and Plugins CSS -->
        <link rel="stylesheet" href="inc/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="inc/animations/css/animate.min.css">
        <link rel="stylesheet" href="inc/font-awesome/css/font-awesome.min.css"> <!-- Font Icons -->
        <link rel="stylesheet" href="inc/owl-carousel/css/owl.carousel.css">
        <link rel="stylesheet" href="inc/owl-carousel/css/owl.theme.css">
    
        <!-- Theme CSS -->
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/mobile.css">
    
        <!-- Skin CSS -->
        <link rel="stylesheet" href="css/skin/cool-gray.css">
        <!-- <link rel="stylesheet" href="css/skin/ice-blue.css"> -->
        <!-- <link rel="stylesheet" href="css/skin/summer-orange.css"> -->
        <!-- <link rel="stylesheet" href="css/skin/fresh-lime.css"> -->
        <!-- <link rel="stylesheet" href="css/skin/night-purple.css"> -->

        <link href="css/stylesDavid.css" rel="stylesheet">
      </head>


    <body data-spy="scroll" data-target="#main-navbar">
    <div class="page-loader"></div> <!-- Display loading image while page loads -->
    <div class="body">
    <!--========== BEGIN HEADER ==========-->
    <header id="header" class="header-main">

        <!-- Begin Navbar -->
        <nav id="main-navbar" class="navbar navbar-default navbar-fixed-top" role="navigation">
            <!-- Classes: navbar-default, navbar-inverse, navbar-fixed-top, navbar-fixed-bottom, navbar-transparent. Note: If you use non-transparent navbar, set "height: 98px;" to #header -->

            <div class="container">

                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand page-scroll" href="index.php">David</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a class="page-scroll" href="index.php#testimonial-section">Inicio</a></li>
                        <li><a class="page-scroll" href="index.php#about-section">Practicas</a></li>
                        <li><a class="page-scroll" href="index.php#redes">Redes</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container -->
        </nav>
        <!-- End Navbar -->

    </header>
    <!-- ========= END HEADER =========-->

HER; //CUANDO SE CIERRA QUE NO HAYA ESPACIOS DELANTE!
}

function jvCharge()
{
  echo <<<HER
  </div><!-- body ends -->

  <!-- Plugins JS -->
  <script src="inc/jquery/jquery-1.11.1.min.js"></script>
  <script src="inc/bootstrap/js/bootstrap.min.js"></script>
  <script src="inc/owl-carousel/js/owl.carousel.min.js"></script>
  <script src="inc/stellar/js/jquery.stellar.min.js"></script>
  <script src="inc/animations/js/wow.min.js"></script>
  <script src="inc/waypoints.min.js"></script>
  <script src="inc/isotope.pkgd.min.js"></script>
  <script src="inc/classie.js"></script>
  <script src="inc/jquery.easing.min.js"></script>
  <script src="inc/jquery.counterup.min.js"></script>
  <script src="inc/smoothscroll.js"></script>
  <script src="https://kit.fontawesome.com/85fd7f662a.js" crossorigin="anonymous"></script>
  
  <!-- Theme JS -->
  <script src="js/theme.js"></script>
HER;
}

function chargeArrayRespuestas()
{
  return array(
    "dA7vId" => "1a;2c;3b;4c",
    "j0RdI"  => "1b;2c;3d;4a"
  );
}

function chargeArrayLetras()
{
  return ["a", "b", "c", "d"];
}

function chargeArrayEncuestas()
{
  return array(
    "dA7vId" => "Enquesta de Genshin Impact; 
                        1- Quants elements hi ha en el joc?;7:3:9:6;
                        2- Quin és el nom de la primera regió del joc?;Liyue:Inazuma:Mondstadt:Sumeru;
                        3- Com es diu l'arcont de Liyue?;Venti:Zhongli:Baal:Diluc;
                        4- De quin element és el protagonista a l'inici del joc?;Anemo:Hydro:Ningún:Geo",
    "j0RdI"  => "Enquesta de Star Wars;
                        1- Quantes pel·lícules <Live Action> hi ha actualment?;3:11:9:6;
                        2- Quin d'aquests personatges va traicionar a la República?;Obi Wan Kenobi:Mace Windu:Anakin Skywalker:Luke Skywalker;
                        3- En quina pel·lícula mor Han Solo?;La Venganza de los Sith:El Imperio contraataca:La Amenaza Fantasma:El Despertar de la Fuerza;
                        4- Quin d'aquests personatges forma part de l'Imperi galàctic?;Thrawn:Lando Calrissian:Hux:Capità Rex"
  );
}


function codeReceived()
{
  return filter_input(INPUT_POST, "code", FILTER_SANITIZE_SPECIAL_CHARS);
}
