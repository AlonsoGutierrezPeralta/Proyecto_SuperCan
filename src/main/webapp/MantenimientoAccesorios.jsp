<%@page import="model.TipoAccesorios"%>
<%@page import="mantenimientos.GestionTipo"%>
<%@page import="model.Accesorios"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mantenimientos.GestionAccesorios"%>
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
  <div  >
  <header>
  <jsp:include page="cabecera.jsp"></jsp:include>
  </header>
  <main>
				<form id="form"   action="crudAccesorios" method = "post">
				<h1><strong>Mantenimiento de Accesorios y otros</strong></h1>
				<div class="form-group">
						<label class="textos1" >Codigo          :</label> <input type="text"
						name ="txtCodigo"
							class="form-group" id="inputAddress" placeholder="Ingrese c�digo"  value="${c.codigoA }" >
						
					</div>
					<div class="form-group">
						<label class="textos1">Descripcion       :</label> <input type="text"
							name ="txtDescripcion"  class="form-group" id="inputAddress"
							placeholder="Ingrese Descripcion" value="${c.descripcion }">
					</div>
					<div class="form-group">
						<label class="textos1">Marca      :</label> <input type="text"
							name ="txtMarca"  class="form-group" id="inputAddress" value="${c.marca }"
							>
					</div>
					
						<div class="form-group">
						<label class="textos1">Stock:</label> <input type="text"
							name ="txtStock"  class="form-group" id="inputAddress" value="${c.stock }"
							>
							<label class="textos2" >Precio :</label> <input type="text"
							name ="txtPrecio"  class="form-group" id="inputAddress" value="${c.precio }"
							>
					</div>
			
					
				<div class="form-row">
						
						<div class="form-group col-md-6">
							<label class="textos1" for="inputState">Tipo:</label> 
							<select id="inputState"  name ="cboTipo"
								class="form-group">
								<option value ="0"selected>seleccione...</option>
								<%
							GestionTipo gt = new GestionTipo();
							ArrayList<TipoAccesorios> lstTipoAccesorio = gt.listadoTA();
							for (TipoAccesorios ta : lstTipoAccesorio) {
							%>
							<option value="<%=ta.getIdAccesorio()%>"><%=ta.getDescripcion()%></option>
							<%
							}
							%>
							</select>
						</div>
					</div>


					
					<button type="submit" name = "btnAccion"  value="reg" class="btn btn-primary">Registrar</button>
					<button type="submit" name = "btnAccion"  value="act" class="btn btn-primary">Actualizar</button>
					<button type="submit" name = "btnAccion"  value="eli" class="btn btn-primary">Eliminar</button>
					<button type="submit" name = "btnAccion"  value="lst" class="btn btn-primary">Listado</button>
					${mensaje}
				</form>
				
		
		</main>
  
  
  
  
  
 
  
   <footer>
  <jsp:include page="footer.jsp"></jsp:include>
  </footer>
  
  </div>
  
  

</body>
</html>