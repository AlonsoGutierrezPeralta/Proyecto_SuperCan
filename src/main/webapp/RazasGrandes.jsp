<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SuperCan</title>
<link rel="stylesheet" href="css/RazasGrandes.css">
</head>
<body>
	<div>
		
  			<jsp:include page="cabecera.jsp"></jsp:include>       	
       	
       	
       	<header>
            <p class="titulo">
                Razas grandes
            </p>
            <p class="titulo2">
                Si haz llegado hasta aqu� es porque te intereso mucho sobre nuestros amigos caninos grandes <br>
                pulse sobre el bot�n "M�s informaci�n" para conocer m�s sobre ellos
            </p>
        </header>
 
        <div class="fila1">
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada" src="img/Sanbernardo (1).jpg" />
                    <div class="nombre">
                        <h1>San bernardo</h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info1()"><strong>M�s informaci�n</strong></p> 
                </div>              
            </div>
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada"   src="img/gran3.jpg" />
                    <div class="nombre">
                        <h1>Mast�n Napolitano</h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info2()"><strong>M�s informaci�n</strong></p> 
                </div>             
            </div>
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada"  src="img/Pastorca�caso.jpg" />
                    <div class="nombre">
                        <h1>Pastor Ca�caso</h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info3()"><strong>M�s informaci�n</strong></p> 
                </div>              
            </div>
        </div> 
        <div class="fila1">
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada" src="img/gran2.jpg" />
                    <div class="nombre">
                        <h1>Gran Dan�s</h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info4()"><strong>M�s informaci�n</strong></p> 
                </div>            
            </div>
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada"   src="img/kuvasz.jpg" />
                    <div class="nombre">
                        <h1>Kuvasz</h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info5()"><strong>M�s informaci�n</strong></p> 
                </div>            
            </div>
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada"  src="img/Terranova.jpg" />
                    <div class="nombre">
                        <h1>Terranova</h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info6()"><strong>M�s informaci�n</strong></p> 
                </div>              
            </div>
        </div> 
        <div class="fila1">
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada" src="img/Broholmer (1).jpg" />
                    <div class="nombre">
                        <h1>Broholmer</h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info7()"><strong>M�s informaci�n</strong></p> 
                </div>             
            </div>
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada"   src="img/gran4.jpg" />
                    <div class="nombre">
                        <h1>Komondor</h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info8()"><strong>M�s informaci�n</strong></p> 
                </div>              
            </div>
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada"  src="img/Loberoirland�s.jpg" />
                    <div class="nombre">
                        <h1>Lobero Irland�s</h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info9()"><strong>M�s informaci�n</strong></p> 
                </div>             
            </div>
        </div>   
        
            
                <jsp:include page="footer.jsp"></jsp:include>
            
	</div>
</body>
</html>

<script src="js/RazasGrandes.js"></script>