<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SuperCan</title>
<link rel="stylesheet" href="css/cabecera.css?v=<?php echo(rand()); ?">
<script src="https://kit.fontawesome.com/62712613b7.js" crossorigin="anonymous"></script>
</head>
<body>

		<div class="logo logo_main"><img class="banner" src="img/SuperCanLogo.png" alt="no se encontro imagen">SuperCan</div>
    <div class="nav">       
            <nav>
                <ul>
                    <li class="item" ><a href="Inicio.jsp">Inicio</a></li>
                    <li class="item"  ><a href="Nosotros.jsp">Nosotros</a></li>
                    <li class="item" ><a href="Razas.jsp">Razas</a></li>
                    <form action="productos" method="post">
                   	<li class="item"><button href="Alimentos.jsp" name="btnAccion" value="lstA" >Alimentos</button></li>
                    <li  class="item"><button href="Higiene.jsp" name="btnAccion" value="lstH" >Cuidado e higiene</button></li>
                    <li  class="item"><button href="Accesorios.jsp" name="btnAccion" value="lstC">Accesorios y otros</button></li>
                    </form>
                   
                    <c:if test="${u.codigoTipoUsuario!=2}">
                    <li class="item" ><a>Mantenimiento</a>
                     </c:if>
                    	<ul class="desplegable" >
							<li><a href="MantenimientoAlimentos.jsp" >alimentos</a></li>
							<li><a href="MantenimientoCuidados.jsp" >cuidado e higiene</a></li> 
							<li><a href="MantenimientoAccesorios.jsp" >accesorios y otros</a></li> 
							<li><a href="MantenimientoProveedores.jsp" >proveedores</a></li>                     	
                    	</ul>
                    </li>
                   
                    <c:if test="${u.codigoTipoUsuario!=2}">
                    <li class="item" ><a>Reporte</a>
                    </c:if>
						<ul class="desplegable" >
							<li><a href="ReporteUsuario.jsp" >usuario</a></li>
							<li><a href="ReporteVentas.jsp" >ventas</a></li> 
							                 	
                    	</ul>                    
                    </li>
                    
                    <li class="item" ><a>Consulta</a>
                        <ul class="desplegable" >
							<li><a href="consultaVentas.jsp" >ventas por fecha</a></li>
							<li><a href="consultaProd.jsp" >productos</a></li> 
							<li><a href="consultaCorreo.jsp" >consultas</a></li>                 	
                    	</ul>
                    </li>
                    
                    	<li class="item" ><a href=""><img class="imggm" src="img/Iconos/usuario.png" alt="Imagen no encontrada"></a>
                    		<ul class="desplegable" >
                    	
							<li  class="item" > <a href="">${u.nombre}   ${u.apellido}</a></li> 
							<li  class="item" > 
								<a href="Cerrar"><img class="imggm" src="img/Iconos/apagar.png" alt="Imagen no encontrada"></a></li> 
						                 	
                    		</ul>
                   	</li>
                </ul>
                 			     
                   
                
            </nav> 
            
            
    </div>
    
   


</body>
</html>