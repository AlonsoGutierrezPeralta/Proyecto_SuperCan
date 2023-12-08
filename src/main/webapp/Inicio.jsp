<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SuperCan</title>
<link rel="stylesheet" href="css/Inicio.css">

</head>
<body>
	<div>
		
			<jsp:include page="cabecera.jsp"></jsp:include>
		<p>
		<br>
		
		
		 <div id="slidershow">
	        <div class="carrusel">
	            <img src="img/1.jpg" alt="" id="imgcab">
	        </div>
    	</div>

    <div class="main">
            <h1>Consulta sobre</h1>
            <hr>
            <div class="contenedor">
                <!--ALIMENTACION-->
                <figure>
                    <div class="item"><a href=""><img src="img/alimentacion.jpg" alt="" class="item-img"></a></div>
                    <div class="item-text"><h3>¿Como deberia alimentar a mi mascota?</h3></div>
                </figure>
                <!--RAZA-->
                <figure>
                    <div class="item"><a href=""><img src="img/raza.jpg" alt="" class="item-img"></a></div>
                    <div class="item-text"><h3>¿Que raza es mi mascota?</h3></div>
                </figure>
            </div>
            <div class="contenedor">
                <!--HIGIENE-->
                <figure>
                    <div class="item"><a href=""><img src="img/higiene.png" alt="" class="item-img"></a></div>
                    <div class="item-text"><h3>Higiene de las mascotas</h3></div>
                </figure>
                <!--ADIESTRAMIENTO-->
                <figure>
                    <div class="item"><a href=""><img src="img/adiestramiento.jpg" alt="" class="item-img"></a></div>
                    <div class="item-text"><h3>¿Como adiestrar bien a mi mascota?</h3></div>
                </figure>

            </div>
        </div>
    </div>
    <div class="main-marcas">
        <h1>Marcas con las que trabajamos</h1>
        <hr>
        <div class="marcas-trabajamos container">
            <div class="container-titulo-controles">            
                <div class="indicadores"></div>
            </div>
    
            <div class="container-principal">
                <button role="button" id="flecha-izquierda" class="flecha-izquierda"><i class="fas fa-angle-left"></i></button>
    
                <div class="container-carousel">
                    <div class="carousel">
                        <div class="marca">
                            <a href="#"><img src="img/marca1.png" alt=""></a>
                        </div>
                        <div class="marca">
                            <a href="https://www.pedigree.es/"><img src="img/marca2.png" alt=""></a>
                        </div>
                        <div class="marca">
                            <a href="https://www.purina-latam.com/pe/proplan/perros/exigent?gclid=CjwKCAiAqIKNBhAIEiwAu_
                            ZLDijKvYctySIKx5siiDkiYvmiJR8j0mQxUfM0zzg9GDpIIcNeftQWgRoCpPgQAvD_BwE&gclsrc=aw.ds">
                            <img src="img/marca3.png" alt=""></a>
                        </div>
                        <div class="marca">
                            <a href="https://www.delkoalimentos.com.ar/"><img src="img/marca4.png" alt=""></a>
                        </div>
                        <div class="marca">
                            <a href="https://www.purina-latam.com/pe/catchow?gclid=CjwKCAiAqIKNBhAIEiwAu_
                            ZLDj0Ytl2lpOojPVvXP4vj-_KIErgewEpdDzBNFtylP8JDcWu0G-hxOxoCKmoQAvD_BwE&gclsrc=aw.ds">
                            <img src="img/marca5.png" alt=""></a>
                        </div>
                        <div class="marca">
                            <a href="http://ricocat.com.pe/productos.php?marca=20"><img src="img/marca6.png" alt=""></a>
                        </div>
                        <div class="marca">
                            <a href="https://www.purina-latam.com/pe/dogchow/
                            familia-de-productos?gclid=CjwKCAiAqIKNBhAIEiwAu_
                            ZLDixlz7efaIn8xmjpzLSOUa43x3nOTCVtdgQeN54DxSjAOZg
                            ZLUindRoCJUsQAvD_BwE&gclsrc=aw.ds"><img src="img/marca7.png" alt=""></a>
                        </div>
                    </div>
                </div>
    
                <button role="button" id="flecha-derecha" class="flecha-derecha"><i class="fas fa-angle-right"></i></button>
            </div>
        </div>
    </div>
		
		
		<jsp:include page="footer.jsp"></jsp:include>
		
	</div>
	
	
</body>
</html>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/Inicio.js"></script>
<script src="js/cm.js"></script>
