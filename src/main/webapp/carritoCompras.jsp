<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>SuperCan</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

</head>

<body>
	<div >
		  <jsp:include page="cabecera.jsp" />
			
				<center >
					<h1 style="margin-top: 5%;" >
						<b >Carrito de compras</b>
					</h1>
			</center>
		
			<div style="width: 60%; height:auto; float:left;  margin-top: 3%; margin-left: 5%;background-color: #F9F7EC;  ">
				<table class="table table-striped" id="myTable">
					
					<thead>

						<tr>
							<th scope="col">Código</th>
							<th scope="col">Producto</th>
							<th scope="col">cantidad</th>
							<th scope="col">Precio</th>
							<th scope="col">subtotal</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<fmt:setLocale value="es_PE" />
						<c:forEach items="${carro }" var="d">
							<tr>

								<th scope="row">${d.idProd }</th>
								<td>${d.nomProd }</td>
								<td>${d.cantidad }</td>
								<td>${d.precioVta }</td>
								<td>${d.importe }</td>
								
						 		<td> 
									<form action="Venta" method="post">
										<input type="hidden" name="codigo" value="${d.idProd}">
										<button type="submit" name="opcion" value="eliminar"
											class="btn btn-outline-primary"><img alt="" src="img/Iconos/tacho.png"> </button>
									</form>
								</td>

							</tr>
						</c:forEach>
					</tbody>	
					
			</table>
			
				
			</div>
			<div style="width: 20%; height: 290px; float: left; border: 1px solid; background-color: #F9F7EC; margin-top: 3% ; margin-left: 5%" >
				<h1>Resumen de pedido</h1>
				<hr >
				<%-- muestra la variable global enviada desde el Listener --%>
				<label  style="margin-left: 50px" >Total artículos (${cantArticulos }) </label>
				<label   style="margin-left: 10px">Sub total S/.${subTotalVenta } </label>
				<hr>
				<form action="Venta" method="post" style="margin-top: 10%; margin-left: 40px" >
					<button    name="opcion" value="finalizar" class="btn btn-primary">Procesar compra<span class="glyphicon glyphicon-ok"></span>
					</button>
				</form>
			</div> 
		
			${mensaje }

			
	</div> 
	
</body>
</html>
