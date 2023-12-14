<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="entities.Vehiculo"%>
<%@page import="java.util.LinkedList"%>
<%@page import="logic.VehiculoLogic"%>
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
<link rel="stylesheet" href="estilos/estilosvehic.css">

<%
	/* Persona p = (Persona)session.getAttribute("usuario"); */
	//System.out.println(request.getSession().getAttribute("rol1"));
	//System.out.println();
	//String rol1 = (String)request.getSession().getAttribute("rol1");
	//System.out.println(rol1);
	
	//Todo este codigo de abajo es para validar si el usr es admin
	Boolean rol1 = (Boolean)request.getSession().getAttribute("rol1");
	Boolean rol2 = (Boolean)request.getSession().getAttribute("rol2");
	if( !(rol1!=null && rol2!=null) ){
		response.sendRedirect("loginvista.jsp");
	}else if( !(rol1 && rol2) ){
		request.getSession().invalidate();
		response.sendRedirect("loginvista.jsp");
	}
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
				<li><a href="Signin?accion=cerrarsesion">Cerrar Sesion</a></li>
			</ul>
		</nav>

	</header>




	<div class="contenedor-padre">
		<h1>Vehiculos no Disponibles</h1>
		
		<div id="main-container">

		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>MARCA Y MODELO</th>
					<th>COLOR</th>
					<th>ESTADO</th>
					<th>MATRICULA</th>
					<th>TIPO</th>
					<th>ACCIONES</th>	
				</tr>
			</thead>
			
			<tbody>
			<%
				//Vehiculo vehic = new Vehiculo();
				VehiculoLogic vl = new VehiculoLogic();
				LinkedList<Vehiculo> listVehiculoNoDisp = vl.getAllVehicNoDisp();
				for(Vehiculo vehic : listVehiculoNoDisp) {
			%>
				<tr>
					<td data-label="ID"><%=vehic.getIdVehiculo()%></td>
					<td data-label="MARCA Y MODELO"><%=vehic.getMarcayModelo()%></td>
					<td data-label="COLOR"><%=vehic.getColor()%></td>
					<td data-label="ESTADO">
						<select name="txtestado" id="tipovehiculo">
							<option value="false">No Disponible</option>
							<option value="true">Disponible</option>														
						</select>
					</td>
					<td data-label="MATRICULA"><%=vehic.getMatricula()%></td>
<%-- 					<%
					System.out.println(vehic.getTipoVehiculo().getId());
					System.out.println(vehic.getTipoVehiculo().getDescripcion());
					%> --%>
					<td data-label="TIPO"><%=vehic.getTipoVehiculo().getDescripcion()%></td>
					
					<td data-label="ACCIONES">
						<div id="contenedorlinks">
							<div id="actualizar">
								<a href="ServletVehiculos?accion=estado&id=<%=vehic.getIdVehiculo()%>">Estado</a>
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