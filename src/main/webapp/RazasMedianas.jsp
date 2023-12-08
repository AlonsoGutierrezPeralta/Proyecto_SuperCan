<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>SuperCan</title>
<link rel="stylesheet" href="css/RazasMedianas.css">
</head>
<body>
	<div>
		<jsp:include page="cabecera.jsp"></jsp:include> 
		
		 <header>
            <p class="titulo">
                Razas Medianas
            </p>
            <p class="titulo2">
                Si haz llegado hasta aquí es porque te intereso mucho sobre nuestros amigos caninos medianos <br>
                pulse sobre el botón "Más información" para conocer más sobre ellos
            </p>
        </header>
 
        <div class="fila1">
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada" src="img/med1.jpg" />
                    <div class="nombre">
                        <h1>Husky Siberiano</h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info1()"><strong>Más información</strong></p> 
                </div>               
            </div>
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada"   src="img/med2.jpg" />
                    <div class="nombre">
                        <h1>Dalmata </h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info2()"><strong>Más información</strong></p> 
                </div>                
            </div>
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada"  src="img/med3.jpg" />
                    <div class="nombre">
                        <h1>Samoyedo</h1>
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
                    <img alt="Imagen no encontrada" src="img/Bordercollie.jpg" />
                    <div class="nombre">
                        <h1>Border collie</h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info4()"><strong>Más información</strong></p> 
                </div>               
            </div>
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada"   src="img/med4.jpg" />
                    <div class="nombre">
                        <h1>Labrador</h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info5()"><strong>Más información</strong></p> 
                </div>                
            </div>
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada"  src="img/Shetlandsheepdog.jpg" />
                    <div class="nombre">
                        <h1>Shetland Sheepdog</h1>
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
                    <img alt="Imagen no encontrada" src="img/Pastorovejeroasutraliano.jpg" />
                    <div class="nombre">
                        <h1>Pastor Ovejero Australiano</h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info7()"><strong>Más información</strong></p> 
                </div>                
            </div>
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada"   src="img/Americopitbullterrier.jpg" />
                    <div class="nombre">
                        <h1>Americo Pitbull Terrier</h1>
                    </div> 
                </div>
                <div class="info">
                    <p onclick="info8()"><strong>Más información</strong></p> 
                </div>                
            </div>
            <div class='contenedor'>
                <div class="imgcontenedor"> 
                    <img alt="Imagen no encontrada"  src="img/Pastorganaderoasutraliano.jpg" />
                    <div class="nombre">
                        <h1>Pastor Ganadero Australiano</h1>
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

<script src="js/RazasMedianas.js"></script>