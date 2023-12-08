<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SuperCan</title>
<link rel="stylesheet" href="css/Nosotros.css">
</head>
<body>

<div>
	<jsp:include page="cabecera.jsp"></jsp:include>
	
	<p>
	<br>
	
	<div id="slidershow">
        <div class="carrusel">
            <img src="img/nosotros1.png" alt="" id="imgcab">
        </div>
    </div>
    <br>
    <div class="main">
        <div class="cuerpo">
            <div class="caja_flotante_iz">
                <h1 class="nosotros">Sobre Nosotros</h1>
                <p class="nosotros_txt">Somos un grupo de personas que busca lo mejor para los miembros m�s consentidos de nuestra familias.
                SuperCan surgio ante la necesidad de dar a nuestrar mascotas el mejor de los cuidados. Nos dedicamos a
                brinda informacion sobre como cuidar de nuestras mascotas. Brindamos 3 tipos de informaci�n de cuidado,
                sobre como cuidar la alimentacion de nuestra mascota, como cuidar el buen higiene de nuestras mascota y
                sobre como adiestrar bien a nuestras mascotas.
                Tambien damos inforamcion sobre las diferenes tipos de razas.
                Aparte de esta información que brindamos tambien tenemos una atención perzonalizada mediante el sistema
                de consultas de nuestra pagina.</p>
            </div>
            <div class="caja_flotante_de">
                <div class="imgderecha"> 
                    <img class="imgder" src="img/imgnosotrosder.jpg">
                </div>
            </div>
         </div>
    </div>
    
    
    <jsp:include page="footer.jsp"></jsp:include>
</div>

</body>
</html>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/Nosotros.js"></script>