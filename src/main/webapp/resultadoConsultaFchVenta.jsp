<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
             <%@page import="model.CabeceraBoleta"%>
<%@page import="mantenimientos.GestionVentaMySQL"%>
<%@page import="model.FechaVenta"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	
	<div>
  <jsp:include page="cabecera.jsp"></jsp:include>
  
  
  
<section style="width: 60%; text-align: center;  background-color: white;  box-shadow: 7px 13px 37px #000 ; border-radius: 10px; margin: 10% auto;" >
        <table class="table">
            <thead>
                <tr>
                       <th scope="col"></th>
                    <th scope="col">Descripcion</th>
                    <th scope="col">Precio</th>
                    <th scope="col">Cantidad</th>
                    <th scope="col">Tipo</th>
                    <th scope="col">Fecha</th>
                    <th scope="col"></th>
                  
                </tr>
            </thead>
     <tbody>
						<%-- ${lstAlimentos} Muestra todo el contenido --%>
							<%
							// Captura el listado enviado como atributo y se debe convertir de Obj -> clase
									ArrayList<FechaVenta> lstVentaFecha = (ArrayList<FechaVenta>)
													request.getAttribute("lstVentaFecha");

							for(FechaVenta f : lstVentaFecha){
							%>	
								
								<tr>
								<th></th>
								<td><%=f.getDescripcion() %></td>
								<td><%=f.getPrecio() %></td>
								<td><%=f.getCantidad() %></td>
								<td><%=f.getTipo() %></td>
								<td><%=f.getFch_bol() %></td>
								<td></td>
								
								
							
								
								</tr>
						<%	
							}
						%>	

						
					</tbody>
        </table>
    </section>
    </div>
	
</body>
</html>