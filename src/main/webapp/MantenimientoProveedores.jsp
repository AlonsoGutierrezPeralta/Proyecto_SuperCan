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
				<form id="form" action="Proveedor" method = "post">
				<h1><strong>Mantenimiento de Proveedores</strong></h1>
				<div class="form-group">
						<label class="textos1" >Codigo          :</label> <input type="text"
						name ="txtCodigo"
							class="form-group" id="inputAddress" placeholder="Ingrese código" value="${r.codigo }" > 
						<label class="textos2">RUC          :</label> <input type="text"
						name ="txtRUC"
							class="form-group" id="inputAddress" placeholder="Ingrese RUC"  value="${r.ruc }">
					</div>
					<div class="form-group">
						<label class="textos1">Razon Social        :</label> <input type="text"
							name ="txtRazon"  class="form-group" id="inputAddress"
							placeholder="Ingrese la razon social" value="${r.razon_social }">
					</div>
					<div class="form-group">
						<label class="textos1">Telefono :</label> <input type="text"
							name ="txtTelefono"  class="form-group" id="inputAddress"
							placeholder="Ingrese Telefono"  value="${r.telefono }">
							<label class="textos2">Correo  :</label> <input type="text"
							name ="txtCorreo"  
							class="form-group" id="inputAddress" placeholder="Ingrese Correo" value="${r.email }" >
					</div>
					
					<div class="form-group">
						<label class="textos1">Direccion      :</label> <input type="text"
							name ="txtDireccion"  class="form-group" id="inputAddress"
							placeholder="Ingrese la direccion" value="${r.direccion }"  >
					</div>
					
						<div class="form-group">
						<label class="textos1">Departamento :</label> <input type="text"
							name ="txtDepartamento"  class="form-group" id="inputAddress"
							placeholder="Ingrese departamento" value="${r.departamento }" >
							<label class="textos2" >Distrito :</label> <input type="text"
							name ="txtDistrito"  class="form-group" id="inputAddress"
							placeholder="Ingrese distrito" value="${r.distrito }" >
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