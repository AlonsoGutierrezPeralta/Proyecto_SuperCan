<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="mantenimientos.GestionTipo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.TipoTodo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SuperCan</title>
<link rel="stylesheet" href="css/ReporteVentas.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div>

		<jsp:include page="cabecera.jsp"></jsp:include>
		
  <header>
        REPORTE DE VENTAS
    </header>
       <form id="form" action="productos" method="post">
    <div class="opciones">
        <div class="cont">
            <label>
                Tipo
            </label>
              <select name="cboTipoTodo" class="cont2">
            <option value="0">selected...</option>
                		<%
							GestionTipo gtp = new GestionTipo();
							ArrayList<TipoTodo> lstTipoTodo = gtp.ListadoTodo();
							for (TipoTodo tp : lstTipoTodo) {
							%>
            	<option><%=tp.getDescripcionT() %></option>
            	<%
							}
							%>
        </select>
        </div>
        <div class="cont3">
            <button  type="submit" name = "btnAccion" value="reporteprod"  >Reporte</button>
        </div>
        <div class="cont4">
            <button   type="submit" name = "btnAccion" value="pdf"  >Imprimir PDF</button>
        </div>
    </div>
     </form>
    <section style="width: 60%;text-align: center;">
        <table class="table">
            <thead>
                <tr>
                    <th scope="col"></th>
                    <th scope="col">Código</th>
                    <th scope="col">Descripción</th>
                    <th scope="col">Precio</th>
                    <th scope="col">Cantidad</th>
                    <th scope="col">Tipo</th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row"> <img alt="" src="#" class="#"> </th>
                    <td>
                        
                    </td>
                    <td>
                        
                    </td>
                    <td>

                    </td>
                    <td>

                    </td>
                </tr>
            </tbody>
        </table>
    </section>
    <br><br>
    <br><br>
    <br><br>
    <br><br>
    <br><br>
   
    <jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>