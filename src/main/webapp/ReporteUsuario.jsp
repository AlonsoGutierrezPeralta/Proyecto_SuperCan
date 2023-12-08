<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="model.TipoUsuario"%>
    <%@page import="mantenimientos.GestionUsuarioMySQL"%>
<%@page import="model.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mantenimientos.GestionTipoUsuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SuperCan</title>
  <link rel="stylesheet" href="css/ReporteUsuario.css?v=<?php echo(rand()); ?">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div>
	
		<jsp:include page="cabecera.jsp"></jsp:include>
		<header>
        REPORTE DE USUARIOS
    </header>
     <form id="form" action="usuario" method = "post">
        <div class="cont">
						
						<div class="form-group col-md-6" style="margin-left: 50%;">
							<label class="textos1" for="inputState">Tipo:</label> 
							<select id="inputState"  name ="cboTipo"
								class="form-group">
								<option value ="0"selected>seleccione...</option>
								<%
							GestionTipoUsuario gte = new GestionTipoUsuario();
							ArrayList<TipoUsuario> ListadoTipoU = gte.ListadoTipoU();
							for (TipoUsuario ta : ListadoTipoU) {
							%>
							<option name="cboTipo" value="<%=ta.getCodigoTipoUsuario()%>"><%=ta.getDescripcion()%></option>
							<%
							}
							%>
							</select>
						</div>
					</div>
        
        <div class="cont3">
           <button type="submit" name = "btnAccion"  value="rep"  >Reporte</button>
        </div>
        <div class="cont4">
        <button type="submit" name = "btnAccion"  value="imp" >Imprimir PDF</button>
        
           
        </div>
        </form>
    </div>
   
   

    
    
    
    <footer style="margin-top: 15%">
    	<jsp:include page="footer.jsp"></jsp:include>
	</footer>
	</div>
</body>
</html>