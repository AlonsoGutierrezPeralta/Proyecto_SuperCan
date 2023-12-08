    <%@page import="DAO.DAOFactory"%>
<%@page import="model.Alimentos"%>
<%@page import="model.tipoAlimentos"%>
<%@page import="java.util.ArrayList"%>
 <%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SuperCan</title>
<link rel="stylesheet" href="css/Mantenimiento.css">

</head>
<body>

<div>
	<header>
		<jsp:include page="cabecera.jsp"></jsp:include>
	</header>
	
	<main>
				<form id="form" action="MantenimientoAlimentos" method = "post">
				<h1><strong>Mantenimiento de Alimentos</strong></h1>
				<div class="form-group">
						<label class="textos1" >Codigo          :</label> <input type="text"
						name ="txtCodigo"
							class="form-group" id="inputAddress" placeholder="Ingrese c�digo" value="${p.codigoAL}">
						
					</div>
					<div class="form-group">
						<label class="textos1">Descripcion       :</label> <input type="text"
							name ="txtDescripcion"  class="form-group" id="inputAddress"
							placeholder="Ingrese Descripcion" value="${p.descripcion}">
					</div>
					<div class="form-group">
						<label class="textos1">Marca      :</label> <input type="text"
							name ="txtMarca"  class="form-group" id="inputAddress" value="${p.marca}"
							>
					</div>
					
						<div class="form-group">
						<label class="textos1">Peso:</label> <input type="text"
							name ="txtPeso"  class="form-group" id="inputAddress" value="${p.peso}"
							>
							<label class="textos2" >Precio :</label> <input type="text"
							name ="txtPrecio"  class="form-group" id="inputAddress" value="${p.precio}"
							>
					</div>
					
					<div class="form-group">
						<label class="textos1">Stock:</label> <input type="text"
							name ="txtStock"  class="form-group" id="inputAddress" value="${p.stock}"
							>
							<label class="textos2" for="inputState">Tipo:</label> 
							<select id="inputState"  name ="cboTipo"
								class="form-group">
								<option value ="0"selected>seleccione...</option>
						<%
								DAOFactory fabrica1 = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
								ArrayList<tipoAlimentos> lstTipoAlimentos = fabrica1.getTipoAlimentosDAO().ListadoTipoAl();
								request.setAttribute("lstTipoAlimentos", lstTipoAlimentos);
								%>

								<c:forEach items="${lstTipoAlimentos}" var="a">

									<c:if test="${a.getIdAlimento() == p.idAlimento}">

										<option value="${a.getIdAlimento()}" selected="selected">${a.getDescripcion()}</option>

									</c:if>

									<c:if test="${a.getIdAlimento() != p.idAlimento}">

										<option value="${a.getIdAlimento()}">${a.getDescripcion()}</option>

									</c:if>

								</c:forEach>
							</select>
					</div>
			<div class="form-group">
						<label class="textos1" >Etapa de vida:</label> <input type="text"
						name ="txtEtapa"
							class="form-group" id="inputAddress" placeholder="Ingrese etapa de vida" value="${p.etapaVida}"}>
						
					</div>
					
			


					
					<button type="submit" name = "btnAccion"  value="reg" class="btn btn-primary">Registrar</button>
					<button type="submit" name = "btnAccion"  value="act" class="btn btn-primary">Actualizar</button>
					<button type="submit" name = "btnAccion"  value="eli" class="btn btn-primary">Eliminar</button>
					<button type="submit" name = "btnAccion"  value="lstA" class="btn btn-primary">Listado</button>
					${mensaje}
				</form>
				
		
		</main>
</div>

</body>
</html>