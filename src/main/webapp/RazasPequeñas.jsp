<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SuperCan</title>
<link rel="stylesheet" href="css/RazasPeque�as.css">
</head>
<body>
 	<div>
 		<jsp:include page="cabecera.jsp"></jsp:include> 
 		
 		<header>
            <p class="titulo">
                Razas Peque�as
            </p>
            <p class="titulo2">
                Si haz llegado hasta aqu� es porque te intereso mucho sobre nuestros amigos caninos grandes <br>
                pulse sobre el bot�n "M�s informaci�n" para conocer m�s sobre ellos
            </p>
        </header>
 
        <div class="fila1">
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada" src="img/pug.jpg" />
                    <div class="nombre">
                        <h1>Pug</h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info1()"><strong>M�s informaci�n</strong></p> 
                </div>               
            </div>
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada"   src="img/peq2.jpg" />
                    <div class="nombre">
                        <h1>Chihuahua</h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info2()"><strong>M�s informaci�n</strong></p> 
                </div>               
            </div>
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada"  src="img/Schnauzerminiatura.jpeg" />
                    <div class="nombre">
                        <h1>Schnauzer miniatura</h1>
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
                    <img alt="Imagen no encontrada" src="img/peq3.jpg" />
                    <div class="nombre">
                        <h1>Papill�n</h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info4()"><strong>M�s informaci�n</strong></p> 
                </div>               
            </div>
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada"   src="img/Bullterrier.jpg" />
                    <div class="nombre">
                        <h1>Bullterrier</h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info5()"><strong>M�s informaci�n</strong></p> 
                </div>               
            </div>
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada"  src="img/Corgi gal�s de Pembroke.jpg" />
                    <div class="nombre">
                        <h1>Corgi gal�s de Pembroke</h1>
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
                    <img alt="Imagen no encontrada" src="img/Lhasaapso.jpg" />
                    <div class="nombre">
                        <h1>Lhasa apso</h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info7()"><strong>M�s informaci�n</strong></p> 
                </div>               
            </div>
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada"   src="img/Cot�ndetulear.jpg" />
                    <div class="nombre">
                        <h1>Cot�n de tulear</h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info8()"><strong>M�s informaci�n</strong></p> 
                </div>               
            </div>
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada"  src="img/peq4.jpg" />
                    <div class="nombre">
                        <h1>Pekin�s</h1>
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

<script src="js/RazasPeque�as.js"></script>