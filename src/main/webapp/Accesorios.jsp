<%@page import="model.Accesorios"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SuperCan</title>

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

		<fmt:setLocale value="es_PE" />
				<div class="container py-5" >
					<div class="row">

						<c:forEach items="${lstAccesorios }" var="c">
						<div class="col-sm-4"  >
							<div class="card"  >
								<img class="card-img-top" src="img/imgProd/${c.getCodigoA()}.jpg" alt="Card image cap" width="250px" height="250px">
								<div class="card-body">
									<h5 class="card-title">${c.getDescripcion()}</h5>
									<p class="card-text">
										<fmt:formatNumber type="currency" value="${c.getPrecio() }"></fmt:formatNumber>
									</p>
									<form action="add" method="post">
										<input type="hidden" name="codigoA" value="${c.getCodigoA()}">
										<button type="submit" name="btnAccion" value="addAccesorios"
											class="btn btn-outline-primary">Agregar</button>
									</form>
								</div>
							</div>
						</div>
          			  </c:forEach>
         	   </div>
            </div>



				<%-- Listado usando una tabla 
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
						<%-- ${lstAlimentos} Muestra todo el contenido 
							<%
							// Captura el listado enviado como atributo y se debe convertir de Obj -> clase
									ArrayList<Accesorios> lstAccesorios = (ArrayList<Accesorios>)
													request.getAttribute("lstAccesorios");
						
							
							
							// Recorre el listado y lo muestro en la tabla
							for(Accesorios c : lstAccesorios){
							%>	
								
								<tr>
								<th scope="row"><img src="img/imgProd/<%=c.getCodigoA()%>.jpg" alt="no se encontro imagen"></th>
								<td><%=c.getDescripcion() %></td>
								<td><%=c.getMarca() %></td>
								<td><%=c.getPrecio() %></td>
								<td><button>comprar</button></td>
								</tr>
						<%	
							}
						%>	
							--%>
						
					</tbody>
				</table>

			</section>
		</main>
		
		
		<jsp:include page="footer.jsp"></jsp:include>
		
	</div>
	
</body>
</html>
