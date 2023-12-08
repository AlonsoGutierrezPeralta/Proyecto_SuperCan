<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SuperCan</title>
<link rel="stylesheet" href="css/consultaCorreo.css?v=<?php echo(rand()); ?">
</head>
<body>
	<div>
		<jsp:include page="cabecera.jsp"></jsp:include>
		
		<div  class="titulo">
		<h1>Consultas por correo</h1>
		</div>
		
		<div class="cuerpo">
            <div class="caja_flotante">
                <form id="form"  onsubmit="nuevo(this)" method="post">
                    <h3>Rellene para mas consultas </h3>
                    
                    <input class="controls"  type="text" name="nombres" id="nombres" placeholder="Ingrese su nombre">
                    <input class="controls"  type="text" name="apellidos" id="apellidos" placeholder="Ingrese su apellido">
                    <input class="controls"  type="email" name="correo" id="correo" placeholder="Ingrese su Correo electrónico">
                    <input class="controls"   name="telefono" id="telefono" placeholder="Ingrese su número telefónico">
                    <textarea class="area"   id="message" name="message"  placeholder="Escribenos su consulta o compartenos su situacion"cols="30" rows="10"></textarea>
                    <input type="file"  name="image" id="file" >
                    <div class="preview">
                        <p id="nombres"></p>
                        <img id="image">

                    </div>
                    
                    <button class="botons">Enviar</button>
                </form>
                <a href="mailto:alonsogutierrezperalta@gmail.com" id="trucazo">mail</a>
            </div>
            <div class="caja_flotante2">
                <div class="carrusel"> 
                    <img id="imgcab" src="img/felicidad1.jpg" />
                    <div id="pruebita">Mi texto</div>
                </div>
            </div>
         </div>
         
         <jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/consultaCorreo.js"></script>