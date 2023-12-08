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
                    �Est�s buscando a tu pr�ximo amigo canino?
                </p>
                <p class="titulo2">
                    En este apartado podr�s comprender mejor sobre tu pr�ximo amigo fiel si este se 
                    adecuaa ti y a tu familia,<br>tales como:historia, personalidad y caracter�sticas 
                    sobre este.<br>�Vamos,compru�balo!
                </p>
            </header>
            <div class="cuerpo">
                <article class="block1">    
                    <div class="intro">
                        <h1>Razas Grandes</h1>
                        <p class="intro1">
                            Si tu opci�n a escoger son las razas grandes debes de saber mejor
                            acerca de cada uno de ellos ya que necesitaras tener un gran
                            espacio para poder tenerlos debido a su tama�o y tambi�n 
                            porque nuestros amiguitos caninos se estresan al estar en 
                            espacios cerrados.
                        </p>
                        <p class="intro2">
                            Para poder ver las fotos de nuestros adorados amigos pulsa en 
                            el bat�n "ver" debajo de la imagen
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
                            Estas razas de perros por lo general son los m�s atractivos ya 
                            que se adecuan mejor a la mayor parte de las familias y tienen
                            una bonita conexi�n con los ni�os, difinitivamente quedar�s
                            encantado con cada uno de nuestros amigos caninos que 
                            ver�s a continuaci�n.
                        </p>
                        <p class="intro2">
                            Para poder ver las fotos de nuestros adorados amigos pulsa en 
                            el bot�n "ver" debajo de la imagen
                        </p> 
                    </div>
                </article>

                <article class="block3">    
                    <div class="intro">
                        <h1>Razas Peque�as</h1>
                        <p class="intro1">
                            Y por �ltimo pero no menos importante nuestros peque�os
                            amigos tan adorables algunos porque algunos de ellos tienen
                            un car�cter fuerte cuidado con estos son
                            "chiquitos pero poderosos" pero de todas formas con una 
                            buena educaci�n estos son muy lindos debido a su tama�o,
                            son una ternura.
                        </p>
                        <p class="intro2">
                            Para poder ver las fotos de nuestros adorados amigos pulsa en 
                            el bot�n "ver" debajo de la imagen
                        </p> 
                    </div>
                    <div class="img">
                        <img src="img/peq1.jpg" width="100%" height="70%" class ="gran1" alt="Iamgen no encontrada">
                        <p><strong><a href="RazasPeque�as.jsp">Ver</a></strong></p>
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