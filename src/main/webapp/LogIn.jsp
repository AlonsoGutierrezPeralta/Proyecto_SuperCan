<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SuperCan</title>
<link rel="stylesheet" href="css/LogIn.css">
</head>
<body>
   <div class="contenedor">
        <img src="img/perroregistro.jpg" alt="image not found" width="50%">
        <form action="Login" method="post" >
            <h1>INGRESAR</h1>
            <p>Usuario</p>
            <input name="txtUsuario" type="text" class="box" >
            <p>Contraseña</p>
            <input  name="txtClave" type="password" class="box" >
            <div  class="registrar">
                <p>¿No tienes una cuenta? <a href="RegistroUsuario.jsp"> Cree una</a></p>
            </div>
            <button type="submit" >Ingresar</button>
        </form>
    </div>
</body>
</html>