<%@page import="logic.TipoVehiculoLogic"%>
<%@page import="entities.TipoVehiculo"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entities.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport"
	content="width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
<link rel="stylesheet" href="estilos/estilostiposvehic.css">

<%
	Persona p = (Persona)session.getAttribute("usuario");
	//TipoVehiculo tv = (TipoVehiculo)request.getAttribute("tipovehiculo");
	//TipoVehiculo tv = new TipoVehiculo();
	LinkedList<TipoVehiculo> ltv = (LinkedList<TipoVehiculo>)request.getAttribute("listaTipoVehiculo");
%>

</head>
<body>


<header class="header">

		<div class="logo">Xtreme</div>
		<input type="checkbox" id="toggle">
		<label for="toggle"> <img class="menu" src="imagenes/menu.svg" alt="menu"> </label>
	
		<nav class="navigation">

			<ul>
				<li><a href="#">Inicio</a></li>
				<li><a href="#">Reserva</a>
					<ul>
						<li><a href="#">A B M C</a>
							<ul>
								<li><a href="#">Alta</a></li>
								<li><a href="#">Reserva</a></li>
								
							</ul>
						</li>
						
					</ul>
				</li>
				<li><a href="#">A B M Cs</a>
					<ul>
						<li><a href="#">Persona</a>
							<ul>
								<li><a href="#">Alta</a></li>
								<li><a href="#">Personas</a></li>
								
							</ul>
						</li>
						<li><a href="#">Rol</a>
							<ul>
								<li><a href="#">Alta</a></li>
								<li><a href="#">Roles</a></li>
								
							</ul>
						</li>
						<li><a href="#">Vehiculo</a>
							<ul>
								<li><a href="#">Alta</a></li>
								<li><a href="#">Vehiculos</a></li>
								
							</ul>
						</li>
						<li><a href="#">Tipo Vehiculo</a>
							<ul>
								<li><a href="#">Alta</a></li>
								<li><a href="#">Tipos Vehiculo</a></li>
								
							</ul>
						</li>
					</ul>
				</li>
				<li><a href="#">Informes</a>
					<ul>
						<li><a href="#">Personas</a></li>
						<li><a href="#">Roles</a></li>
						<li><a href="#">Vehiculos</a></li>
						<li><a href="#">Tipos Vehiculos</a></li>
					</ul>
				</li>
				<li><a href="#">Cerrar Sesion</a></li>
			</ul>

		</nav>

	</header>




	<div>
		<h1>Tipos vehiculo</h1>
		
		<div id="main-container">
		<div id="agregarnuevo">
			<a href="altapersona.html">Agregar Nuevo</a>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>DESCRIPCION</th>
					<th>PRECIO</th>
					<th>ACCIONES</th>	
				</tr>
			</thead>
			
			<tbody>
			<% 
			TipoVehiculoLogic tvl = new TipoVehiculoLogic();
			LinkedList<TipoVehiculo> listtv = tvl.getAllTiposVehiculo();
			//TipoVehiculo tv = null;
			for (TipoVehiculo tve : listtv) { 
			%>
				<tr>
					<td data-label="ID"><%=tve.getId()%></td>
					<td data-label="DESCRIPCION"><%=tve.getDescripcion()%></td>
					<td data-label="PRECIO"><%=tve.getCosto()%></td>
					
					<td data-label="ACCIONES">
						<div id="contenedorlinks">
						<div id="editar">
							<a href="ServletTiposVehiculo?accion=editartipovehiculo&id=<%=tve.getId()%>">Editar</a>
						</div>
						<div id="eliminar">
							<a href="">Eliminar</a>
						</div>
						</div>
					</td>
				</tr>				
			<% } %>	
			</tbody>
		</table>
		</div>
	</div>


</body>
</html>