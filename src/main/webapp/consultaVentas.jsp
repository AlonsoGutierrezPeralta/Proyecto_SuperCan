<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SuperCan</title>
  <link rel="stylesheet" href="css/ConsultaVentas.css">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div>
	<jsp:include page="cabecera.jsp"></jsp:include>
		 <header>
        CONSULTA DE VENTAS POR FECHA
    </header>
    <form action="Venta" method="post">
    <div class="opciones">
        <div class="cont">
            <p>
                Fecha
            </p>
        </div>
        <div class="cont2">
            <input type="date" name="txtFecha" id="">
        </div>
        <div class="cont3">
            <button type="submit" name = "opcion"  value="consultaFch" >Consultar</button>
        </div>
       
    </div>
     </form>
    <section style="width: 60%;text-align: center;">
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