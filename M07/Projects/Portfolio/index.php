<?php
//Call the functions file once.
require_once 'functions.php';

//Option 2:
//require "functions.php";

//Option 3:
//include "functions.php";

//Option 4:
//include_once "functions.php";

header_nav("Inicio");
?>


<!-- Begin testimonials -->
<div class="extra-space-l"></div>
<section id="testimonial-section">
    <div id="testimonial-trigger" class="testimonial text-white parallax" data-stellar-background-ratio="0.5" style="background-image: url(img/testimonial-bg.jpg);">
        <div class="cover"></div>
        <!-- Begin page header-->
        <div class="page-header-wrapper">
            <div class="container">
                <div class="page-header text-center wow fadeInDown" data-wow-delay="0.4s">
                    <h2>David</h2>
                    <div class="devider"></div>
                    <p class="subtitle">Portfolio de M07</p>
                </div>
            </div>
        </div>
        <!-- End page header-->
        <div class="container">
            <div class="testimonial-inner center-block text-center">
                <div id="owl-testimonial" class="owl-carousel">
                    <div class="item">
                        <blockquote>
                            <p>"Hazlo o no lo hagas pero no lo intentes".</p>
                            <footer><cite title="Source Title">Yoda</cite></footer>
                        </blockquote>
                    </div>
                    <div class="item">
                        <blockquote>
                            <p>"Uno puede aprender mucho de un pueblo por las historias que cuentan de otros".</p>
                            <footer><cite title="Source Title">Gran Almirante Thrawn</cite></footer>
                        </blockquote>
                    </div>
                    <div class="item">
                        <blockquote>
                            <p>"Puedes pensar que soy malvado. Yo no soy. Soy eficiente".</p>
                            <footer><cite title="Source Title">Darth Maul</cite></footer>
                        </blockquote>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- End testimonials -->

<!-- Begin about section -->
<section id="about-section" class="page bg-style1">
    <!-- Begin page header-->
    <div class="page-header-wrapper">
        <div class="container">
            <div class="page-header text-center wow fadeInUp" data-wow-delay="0.3s">
                <h2>Practicas</h2>
                <div class="devider"></div>
                <p class="subtitle">Aquí subiré las practicas del módulo de M07 Entornos de Desarrollo en Servidor.</p>
            </div>
        </div>
    </div>
    <!-- End page header-->
    <!-- Begin rotate box-1 -->
    <div class="rotate-box-1-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-6">
                    <a href="ex1.php" class="rotate-box-1 square-icon wow zoomIn" data-wow-delay="0">
                        <span class="rotate-box-icon"><i class="fab fa-galactic-republic"></i></span>
                        <div class="rotate-box-info">
                            <h4>PRACTICA 1</h4>
                            <p>Tabla de multiplicar, se generan las tablas desde la del 1 hasta el número que introduces.</p>
                        </div>
                    </a>
                </div>

                <div class="col-md-3 col-sm-6">
                    <a href="ex2.php" class="rotate-box-1 square-icon wow zoomIn" data-wow-delay="0.2s">
                        <span class="rotate-box-icon"><i class="fab fa-galactic-republic"></i></span>
                        <div class="rotate-box-info">
                            <h4>PRACTICA 2</h4>
                            <p>DNI, el usuario introduce un DNI y se verifica si es válido o no.</p>
                        </div>
                    </a>
                </div>

                <div class="col-md-3 col-sm-6">
                    <a href="ex3.php" class="rotate-box-1 square-icon wow zoomIn" data-wow-delay="0.4s">
                        <span class="rotate-box-icon"><i class="fab fa-galactic-republic"></i></span>
                        <div class="rotate-box-info">
                            <h4>PRACTICA 3</h4>
                            <p>Palindromos, el usuario introduce una frase o palabra y se verifica si es palindroma o no.</p>
                        </div>
                    </a>
                </div>

                <div class="col-md-3 col-sm-6">
                    <a href="#" class="rotate-box-1 square-icon wow zoomIn" data-wow-delay="0.6s">
                        <span class="rotate-box-icon"><i class="fab fa-galactic-republic"></i></span>
                        <div class="rotate-box-info">
                            <h4>PRACTICA 4</h4>
                            <p>Lorem ipsum dolor sit amet set, consectetur utes anet adipisicing elit, sed do
                                eiusmod tempor incidist.</p>
                        </div>
                    </a>
                </div>

            </div> <!-- /.row -->
        </div> <!-- /.container -->
    </div>
    <!-- End rotate box-1 -->

    <div class="extra-space-l"></div>
    <a href="#" class="scrolltotop"><i class="fa fa-arrow-up"></i></a> <!-- Scroll to top button -->

</section>
<!-- End about section -->

<?php
jvCharge();
?>

</body>

</html>