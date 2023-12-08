<%@page import="model.TipoUsuario"%>
<%@page import="mantenimientos.GestionTipoUsuario"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SuperCan</title>
<link rel="stylesheet" href="css/RegistroUsuario.css">
</head>
<body>
	<div class="contenedor">
        <img src="img/perro2registro.jpg" alt="image not found" width="35%">
        <form action="usuario"  method="post">
            <h1>CREAR CUENTA</h1>
            <br>
            <label>Nombre</label> 
            <input name="txtNombre"  type="text" class="box1" required>
            <label>Apellido</label>   
            <input name="txtApellido"  type="text" class="box2" required>
            <p></p>
            <br>
            <label>DNI</label>
            <input name="txtDni"  type="text" class="box3" required>
            <p></p>
            <br>
            <label>Usuario</label>
            <input name="txtUsuario"  type="text" class="box1" required>
            <label>Contraseña</label>
            <input name="txtContraseña"  type="password" class="box1" required>
            <p></p>
            <br>
            <label>Correo</label>
            <input name="txtCorreo"  type="email" class="box4" required>
            <p></p>
            <br>
            <label>Tipo</label>
            <select name="cboTipo" class="box5">
            	<option value="0"selected>Seleccione...</option>
            		<%
							GestionTipoUsuario gt = new GestionTipoUsuario();
							ArrayList<TipoUsuario> lstTipoUsuario = gt.ListadoTipoU();
							for (TipoUsuario tu : lstTipoUsuario) {
							%>
            	<option value="<%=tu.getCodigoTipoUsuario()%>"><%=tu.getDescripcion() %></option>
            	<%
							}
							%>
            </select>
            <p></p>
            <br>
            <div class="registrar">
                <p>¿Ya eres usuario? <a href="LogIn.jsp"> Ingresar aqui</a></p>
            </div>
            <p></p>
            <br>
            <button  type="submit" name = "btnAccion"  value="reg">Crear Cuenta</button>
        </form>
        ${mensaje}
    </div>
</body>
</html>