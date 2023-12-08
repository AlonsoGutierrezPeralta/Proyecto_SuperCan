<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SuperCan</title>
<link rel="stylesheet" href="css/RazasPequeñas.css">
</head>
<body>
 	<div>
 		<jsp:include page="cabecera.jsp"></jsp:include> 
 		
 		<header>
            <p class="titulo">
                Razas Pequeñas
            </p>
            <p class="titulo2">
                Si haz llegado hasta aquí es porque te intereso mucho sobre nuestros amigos caninos grandes <br>
                pulse sobre el botón "Más información" para conocer más sobre ellos
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
                    <p onclick="info1()"><strong>Más información</strong></p> 
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
                    <p onclick="info2()"><strong>Más información</strong></p> 
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
                    <p onclick="info3()"><strong>Más información</strong></p> 
                </div>               
            </div>
        </div> 
        <div class="fila1">
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada" src="img/peq3.jpg" />
                    <div class="nombre">
                        <h1>Papillón</h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info4()"><strong>Más información</strong></p> 
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
                    <p onclick="info5()"><strong>Más información</strong></p> 
                </div>               
            </div>
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada"  src="img/Corgi galés de Pembroke.jpg" />
                    <div class="nombre">
                        <h1>Corgi galés de Pembroke</h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info6()"><strong>Más información</strong></p> 
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
                    <p onclick="info7()"><strong>Más información</strong></p> 
                </div>               
            </div>
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada"   src="img/Cotóndetulear.jpg" />
                    <div class="nombre">
                        <h1>Cotón de tulear</h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info8()"><strong>Más información</strong></p> 
                </div>               
            </div>
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada"  src="img/peq4.jpg" />
                    <div class="nombre">
                        <h1>Pekinés</h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info9()"><strong>Más información</strong></p> 
                </div>               
            </div>
        </div>   
        
         <jsp:include page="footer.jsp"></jsp:include>
 	</div>

</body>
</html>

<script src="js/RazasPequeñas.js"></script>