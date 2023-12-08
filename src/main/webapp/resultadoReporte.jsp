<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@page import="model.TipoUsuario"%>
<%@page import="mantenimientos.GestionUsuarioMySQL"%>
<%@page import="model.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mantenimientos.GestionTipoUsuario"%>
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
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido</th>
                    <th scope="col">DNI</th>
                    <th scope="col">nombre de usuario</th>
                  
                </tr>
            </thead>
     <tbody>
						<%-- ${lstAlimentos} Muestra todo el contenido --%>
							<%
							// Captura el listado enviado como atributo y se debe convertir de Obj -> clase
									ArrayList<Usuario> lstUsuario = (ArrayList<Usuario>)
													request.getAttribute("lstUsuario");

							for(Usuario u : lstUsuario){
							%>	
								
								<tr>
								<th></th>
								<td><%=u.getNombre() %></td>
								<td><%=u.getApellido() %></td>
								<td><%=u.getDni() %></td>
								<td><%=u.getUsuario() %></td>
								
								
							
								
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