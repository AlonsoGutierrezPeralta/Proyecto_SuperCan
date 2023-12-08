<%@page import="model.Higiene"%>
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
<link rel="stylesheet" href="css/Alimentos.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div>
		<jsp:include page="cabecera.jsp"></jsp:include>
		
	
		<center>
			<h1 >
				<b>Cuidado e higiene</b>
			</h1>
		</center>	
		 <main>
			
			<section style="width: 75%; margin-left: 10%;">


		<fmt:setLocale value="es_PE" />
				<div class="container py-5" >
					<div class="row">

						<c:forEach items="${lstHigiene }" var="h">
						<div class="col-sm-4"  >
							<div class="card"  >
								<img class="card-img-top" src="img/imgProd/${h.getCodigoH()}.jpg" alt="Card image cap" width="250px" height="250px">
								<div class="card-body">
									<h5 class="card-title">${h.getDescripcion()}</h5>
									<p class="card-text">
										<fmt:formatNumber type="currency" value="${h.getPrecio() }"></fmt:formatNumber>
									</p>
									<form action="add" method="post">
										<input type="hidden" name="codigoH" value="${h.getCodigoH()}">
										<button type="submit" name="btnAccion" value="addHigiene"
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
									ArrayList<Higiene> lstHigiene = (ArrayList<Higiene>)
													request.getAttribute("lstHigiene");

							// LA PARTE DE ABAJO ES LA QUE MUESTRA EL ERROR AL EJECUTAR LA PÁGINA 
							// IGUAL CON LOS OTROS LISTADOS 
							// EN LA PARTE DE FOR(...)
							// ENTONCES NO AGREGUÉ LAS IMAGENES YA QUE NO PUEDO VER LO QUE ESTABA HACIENDO
							
							
							// Recorre el listado y lo muestro en la tabla
							for(Higiene h : lstHigiene){
							%>	
								
								<tr>
								<th scope="row"><img src="img/imgProd/<%=h.getCodigoH()%>.jpg" alt="no se encontro imagen"></th>
								<td><%=h.getDescripcion() %></td>
								<td><%=h.getMarca() %></td>
								<td><%=h.getPrecio() %></td>
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
