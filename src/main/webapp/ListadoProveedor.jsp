<%@page import="model.Proveedor"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SuperCan</title>
<link rel="stylesheet" href="css/listadoProveedor.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div>
		<jsp:include page="cabecera.jsp"></jsp:include>
		
	
		<center>
			<h1 >
				<b>Listado de Proveedores</b>
			</h1>
		</center>	
		 <main>
			
			<section style="width: 75%; margin-left: 10%;">

				<%-- Listado usando una tabla --%>
				<table class="table table-dark">
					<thead>
						<tr>
							<th scope="col"></th>
							<th scope="col">codigo</th>
							<th scope="col">RUC</th>
							<th scope="col">Razon social</th>
							<th scope="col">Email</th>
							<th scope="col">teléfono</th>
							<th scope="col">direccion</th>
							<th scope="col">departamento</th>
							<th scope="col">distrito</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<%-- ${lstAlimentos} Muestra todo el contenido --%>
							<%
							// Captura el listado enviado como atributo y se debe convertir de Obj -> clase
									ArrayList<Proveedor> lstProveedor = (ArrayList<Proveedor>)
													request.getAttribute("lstProveedor");

							
							
							// Recorre el listado y lo muestro en la tabla
							for(Proveedor r : lstProveedor){
							%>	
								
								<tr>
								<th scope="row"><img src="img/imgProd/<%=r.getCodigo()%>.jpg" alt="no se encontro imagen" class="imglst"></th>
								<td><%=r.getCodigo() %></td>
								<td><%=r.getRuc() %></td>
								<td><%=r.getRazon_social() %></td>
								<td><%=r.getEmail() %></td>
								<td><%=r.getTelefono() %></td>
								<td><%=r.getDireccion() %></td>
								<td><%=r.getDepartamento() %></td>
								<td><%=r.getDistrito() %></td>
								<td colspan="2">
									<form action="Proveedor" method="post" >
									  <input name="codigo" value="<%=r.getCodigo()%>" type="hidden"> 
										<button  name="btnAccion"  value="buscar" type="submit"
										class="btn btn-link"> 
										<img alt="no se encontro imagen" src="img/Iconos/edit1.png">
										 </button>
									
									
								<input name="txtCodigo" value="<%=r.getCodigo()%>" type="hidden"> 
									<button name="btnAccion" value="eli" type="submit"
										class="btn btn-link">
										<img alt="no se encontró imagen" src="img/Iconos/tacho.png">
									</button>
									</form>
	
								</td>
								
								</tr>
						<%	
							}
						%>	

						
					</tbody>
				</table>

			</section>
		</main>
		
		
		<jsp:include page="footer.jsp"></jsp:include>
		
	</div>
	
</body>

</html>


