<%@page import="model.Accesorios"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SuperCan</title>
<link rel="stylesheet" href="css/Alimentos.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div>
		<jsp:include page="cabecera.jsp"></jsp:include>
		
	
		<center>
			<h1 >
				<b>Accesorios y otros</b>
			</h1>
		</center>	
		 <main>
			
			<section style="width: 75%; margin-left: 10%;">

				<%-- Listado usando una tabla --%>
				<table class="table table-dark">
					<thead>
						<tr>
							<th scope="col"></th>
							<th scope="col">Descripcion</th>
							<th scope="col">Marca</th>
							<th scope="col">Precio</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<%-- ${lstAlimentos} Muestra todo el contenido --%>
							<%
							// Captura el listado enviado como atributo y se debe convertir de Obj -> clase
									ArrayList<Accesorios> lstAccesorios = (ArrayList<Accesorios>)
													request.getAttribute("lstAccesorios");

							// LA PARTE DE ABAJO ES LA QUE MUESTRA EL ERROR AL EJECUTAR LA P�GINA 
							// IGUAL CON LOS OTROS LISTADOS 
							// EN LA PARTE DE FOR(...)
							// ENTONCES NO AGREGU� LAS IMAGENES YA QUE NO PUEDO VER LO QUE ESTABA HACIENDO
							
							
							// Recorre el listado y lo muestro en la tabla
							for(Accesorios c : lstAccesorios){
							%>	
								
								<tr>
								<th scope="row"><img src="img/imgProd/<%=c.getCodigoA()%>.jpg" alt="no se encontro imagen"></th>
								<td><%=c.getDescripcion() %></td>
								<td><%=c.getMarca() %></td>
								<td><%=c.getPrecio() %></td>
								<td colspan="2" >
								 	<form action="crudAccesorios" method="post">
										<input name="codigo" value="<%=c.getCodigoA()%>" type="hidden">
										<button name="btnAccion" value="buscar" type="submit"
										  		class="btn btn-link">
											 <img alt="no se encontro imagen" src="img/Iconos/edit1.png"> 
										</button>
										
										<input name="txtCodigo" value="<%=c.getCodigoA()%>" type="hidden">
										<button name="btnAccion" value="eli" type="submit"
										class="btn btn-link"> <img alt="no se encontro imagen" src="img/Iconos/tacho.png"> </button>
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
