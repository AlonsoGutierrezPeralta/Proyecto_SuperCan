<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SuperCan</title>
<link rel="stylesheet" href="css/Razas.css">
</head>
<body>

	<div class="contenedor">
       	
  			<jsp:include page="cabecera.jsp"></jsp:include>       	
       	
       	
       	<header>
                <p class="titulo">
                    ¿Estás buscando a tu próximo amigo canino?
                </p>
                <p class="titulo2">
                    En este apartado podrás comprender mejor sobre tu próximo amigo fiel si este se 
                    adecuaa ti y a tu familia,<br>tales como:historia, personalidad y características 
                    sobre este.<br>¡Vamos,compruébalo!
                </p>
            </header>
            <div class="cuerpo">
                <article class="block1">    
                    <div class="intro">
                        <h1>Razas Grandes</h1>
                        <p class="intro1">
                            Si tu opción a escoger son las razas grandes debes de saber mejor
                            acerca de cada uno de ellos ya que necesitaras tener un gran
                            espacio para poder tenerlos debido a su tamaño y también 
                            porque nuestros amiguitos caninos se estresan al estar en 
                            espacios cerrados.
                        </p>
                        <p class="intro2">
                            Para poder ver las fotos de nuestros adorados amigos pulsa en 
                            el batón "ver" debajo de la imagen
                        </p> 
                    </div>
                    <div class="img">
                        <img id="gran1" src="img/gran1.jpg"  alt="Iamgen no encontrada">
                        <p><strong><a href="RazasGrandes.jsp">Ver</a></strong></p>
                        
                    </div> 
                </article>

                <article class="block2">   
                    <div class="img">
                        <img src="img/med1.jpg" width="100%" height="70%" class ="gran1" alt="Iamgen no encontrada">
                        <p><strong><a href="RazasMedianas.jsp"> Ver</a></strong></p>
                    </div>  
                    <div class="intro">
                        <h1>Razas Medianas</h1>
                        <p class="intro1">
                            Estas razas de perros por lo general son los más atractivos ya 
                            que se adecuan mejor a la mayor parte de las familias y tienen
                            una bonita conexión con los niños, difinitivamente quedarás
                            encantado con cada uno de nuestros amigos caninos que 
                            verás a continuación.
                        </p>
                        <p class="intro2">
                            Para poder ver las fotos de nuestros adorados amigos pulsa en 
                            el botón "ver" debajo de la imagen
                        </p> 
                    </div>
                </article>

                <article class="block3">    
                    <div class="intro">
                        <h1>Razas Pequeñas</h1>
                        <p class="intro1">
                            Y por último pero no menos importante nuestros pequeños
                            amigos tan adorables algunos porque algunos de ellos tienen
                            un carácter fuerte cuidado con estos son
                            "chiquitos pero poderosos" pero de todas formas con una 
                            buena educación estos son muy lindos debido a su tamaño,
                            son una ternura.
                        </p>
                        <p class="intro2">
                            Para poder ver las fotos de nuestros adorados amigos pulsa en 
                            el botón "ver" debajo de la imagen
                        </p> 
                    </div>
                    <div class="img">
                        <img src="img/peq1.jpg" width="100%" height="70%" class ="gran1" alt="Iamgen no encontrada">
                        <p><strong><a href="RazasPequeñas.jsp">Ver</a></strong></p>
                    </div> 
                </article>
            </div>
            
            <header>
                <jsp:include page="footer.jsp"></jsp:include>
            </header>
            
	</div>

</body>
</html>
<script src="js/Razas.js"></script>