<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div>
		<jsp:include page="cabecera.jsp"></jsp:include>
		
		<section style="width: 45%; margin-left: 25% ; background-color: #F9F7EC; margin-top:13%">
				<fieldset>
					<legend style="background-color: silver;">Formulario de
						compras</legend>
					<table>
						<tr>
							<td>
								<table>
									<tr>
										<td><img alt="" src="img/imgProd/${h.getCodigoH()}.jpg" width="350px" height="300px"></td>
									</tr>
								</table>
							</td>

							<td>
								<form action="Venta" method="post">
									<table>
										<tr>
											<td><label>Cod producto:</label></td>
											<td><label> <strong>${h.getCodigoH() }</strong> </label> <a href="#"><img
													src="img/Iconos/lupa.png" alt=""> </a></td>
										</tr>
										<tr>
											<td>Marca :</td>
											<td><label>${h.getMarca() }</label></td>
										</tr>
										<tr>
											<td>Descripción :</td>
											<td><label>${h.getDescripcion() }</label></td>
										</tr>
										<tr>
											<td>Precio :</td>
											<td><label>${h.precio } </label></td>
										</tr>
										<tr>
											<td>Cantidad a comprar:</td>
											<td><input type="number" value="1" name="cantidad"
												min="1" max=""></td>
										</tr>

										<tr>
											<td>
												<button name="opcion" value="agregarH" class="btn btn-primary" style="margin-top:15px;">
													Agregar compra <span
														class="glyphicon glyphicon-shopping-cart"></span>
												</button>
										</tr>

									</table>
								</form>
							</td>

						</tr>
					</table>



				</fieldset>
			</section>
			
			
		
	</div>
</body>
</html>