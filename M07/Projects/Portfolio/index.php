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
    <div id="testimonial-trigger" class="testimonial text-white parallax" data-stellar-background-ratio="0.5"
        style="background-image: url(img/space.png); background-size: contain;">
        <div class="cover"></div>
        <!-- Begin page header-->
        <div class="page-header-wrapper">
            <div class="container">
                <div class="page-header text-center wow fadeInDown" data-wow-delay="0.4s">
                    <h1>David</h1>
                    <div class="devider"></div>
                    <p class="subtitle" style="font-size: larger">Portfolio de M07</p>
                </div>
            </div>
        </div>
        <!-- End page header-->
        <div class="container">
            <div class="testimonial-inner center-block text-center">
                <div id="owl-testimonial" class="owl-carousel">
                    <div class="item">
                        <blockquote>
                            <p style="font-size: larger;">"Hazlo o no lo hagas pero no lo intentes".</p>
                            <footer><cite title="Source Title">Yoda</cite></footer>
                        </blockquote>
                    </div>
                    <div class="item">
                        <blockquote>
                            <p style="font-size: larger;">"Uno puede aprender mucho de un pueblo por las historias que cuentan de otros".</p>
                            <footer><cite title="Source Title">Gran Almirante Thrawn</cite></footer>
                        </blockquote>
                    </div>
                    <div class="item">
                        <blockquote>
                            <p style="font-size: larger;">"Puedes pensar que soy malvado. Yo lo soy. Soy eficiente".</p>
                            <footer><cite title="Source Title">Darth Maul</cite></footer>
                        </blockquote>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- End testimonials -->




<!-- PRACTICAS -->
<section id="about-section" class="page bg-style1">
    <!-- Begin page header-->
    <div class="page-header-wrapper">
        <div class="container">
            <div class="page-header text-center wow fadeInUp" data-wow-delay="0.3s">
                <h2>Practicas</h2>
                <div class="devider"></div>
                <h5 class="subtitle"><b>Aquí subiré las practicas del módulo de M07 - Desarrollo Web en entorno
                        Servidor.</b></h5>
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
                            <p>Tabla de multiplicar, se generan las tablas desde la del 1 hasta el número que
                                introduces.</p>
                        </div>
                    </a>
                </div>

                <div class="col-md-3 col-sm-6">
                    <a href="ex2.php" class="rotate-box-1 square-icon wow zoomIn" data-wow-delay="0.2s">
                        <span class="rotate-box-icon"><i class="fab fa-galactic-republic"></i></span>
                        <div class="rotate-box-info">
                            <h4>PRACTICA 2</h4>
                            <p>DNI, el usuario introduce un DNI y se verifica si está en formato válido y si es la letra
                                que le toca.</p>
                        </div>
                    </a>
                </div>

                <div class="col-md-3 col-sm-6">
                    <a href="ex3.php" class="rotate-box-1 square-icon wow zoomIn" data-wow-delay="0.4s">
                        <span class="rotate-box-icon"><i class="fab fa-galactic-republic"></i></span>
                        <div class="rotate-box-info">
                            <h4>PRACTICA 3</h4>
                            <p>Palindromos, el usuario introduce una frase o palabra y se verifica si es palindroma o
                                no.</p>
                        </div>
                    </a>
                </div>

                <div class="col-md-3 col-sm-6">
                    <a href="ex4.php" class="rotate-box-1 square-icon wow zoomIn" data-wow-delay="0.6s">
                        <span class="rotate-box-icon"><i class="fab fa-galactic-republic"></i></span>
                        <div class="rotate-box-info">
                            <h4>PRACTICA 4</h4>
                            <p>Formulario, el usuario introduce los valores pedidos en cada campo y "PHP" funciona de
                                 validados de cada dato.</p>
                        </div>
                    </a>
                </div>
            </div> <!-- /.row -->
        </div> <!-- /.container -->
    </div>
    <!-- End PRACTICAS -->
</section>
<!-- End about section -->




<!-- Begin footer -->
<footer class="text-off-white">
    <div class="footer-top">
        <div class="container">
            <div class="row wow bounceInLeft" data-wow-delay="0.4s">
                <div class="container footer-top" style=" text-align: center;">
                    <h2>Redes de interés</h2>
                    <div class="devider"></div>
                    <p class="subtitle" style="margin-bottom: 20px;">Dejo adjuntado mi GitHub y Linkedin para ver más
                        proyectos e información.</p>
                    <ul class="social-list" id="redes" style="margin-left: 40px;">
                        
                        <li> <a href="https://www.linkedin.com/in/davidrodfel/"
                                class="rotate-box-1 square-icon text-center wow zoomIn" data-wow-delay="0.5s"><span
                                    class="rotate-box-icon"><i class="fab fa-linkedin-in"></i></span></a></li>
                        <li> <a href="https://github.com/daviidrf"
                                class="rotate-box-1 square-icon text-center wow zoomIn" data-wow-delay="0.6s"><span
                                    class="rotate-box-icon"><i class="fab fa-github"></i></span></a></li>
                        
                    </ul>
                </div>
            </div> <!-- /.row -->
        </div> <!-- /.container -->
    </div>

    <div class="footer">
        <div class="container text-center wow fadeIn centrarX" data-wow-delay="0.4s">
            <p class="copyright">Copyright &copy; 2021 - Designed By <a href="https://www.behance.net/poljakova"
                    class="theme-author">David Rodriguez</a> &amp; Developed by <a href="http://www.imransdesign.com/"
                    class="theme-author">David Rodriguez</a></p>
        </div>
    </div>

</footer>
<!-- End footer -->

<a href="#" class="scrolltotop"><i class="fa fa-arrow-up"></i></a> <!-- Scroll to top button -->



<?php
jvCharge();
?>

</body>

</html>