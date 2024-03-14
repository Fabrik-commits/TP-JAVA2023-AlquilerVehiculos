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
<link rel="stylesheet" href="estilos/estilos2.css">

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
		<input type="checkbox" id="toggle"> <label for="toggle">
			<img class="menu" src="imagenes/menu.svg" alt="menu">
		</label>

		<nav class="navigation">

			<ul>
				<li><a href="#">Inicio</a></li>
				<li><a href="#">Alquiler</a>
<!-- 					<ul>
						<li><a href="#">A B M C</a>
							<ul>
								<li><a href="#">Alta</a></li>
								<li><a href="#">Alquileres de Cliente</a></li>

							</ul></li>

					</ul> --></li>
				<li><a href="#">A B M Cs</a>
					<ul>
						<li><a href="#">Alquiler</a>
							<ul>
								<li><a href="alquileradmin.jsp">Alta</a></li>
								<li><a href="principalbuscaralquileresxclte.jsp">Alquileres y Clientes</a></li>
								
							</ul>
						</li>
						<li><a href="#">Persona</a>
							<ul>
								<li><a href="altapersona.jsp">Alta</a></li>
								<li><a href="ServletPersonas?accion=principalpersonas">Personas</a></li>

							</ul></li>
						<li><a href="#">Rol</a>
							<ul>
								<li><a href="ServletRoles?accion=altarol">Alta</a></li>
								<li><a href="ServletRoles?accion=principalroles">Roles</a></li>

							</ul></li>
						<li><a href="#">Vehiculo</a>
							<ul>
								<li><a href="ServletVehiculos?accion=altavehiculo">Alta</a></li>
								<li><a href="ServletVehiculos?accion=principalvehic">Vehiculos</a></li>

							</ul></li>
						<li><a href="#">Tipo Vehiculo</a>
							<ul>
								<li><a href="ServletTiposVehiculo?accion=altatipovehiculo">Alta</a></li>
								<li><a href="ServletTiposVehiculo?accion=principaltiposvehic">Tipos Vehiculo</a></li>

							</ul></li>
					</ul></li>
				<li><a href="#">Informes</a>
					<ul>
						<li><a href="#">Personas</a></li>
						<li><a href="#">Roles</a></li>
						<li><a href="#">Reservas</a></li>
						<li><a href="#">Vehiculos</a>
							<ul>
								<li><a href="principalvehicnodisp.jsp">Vehiculos no Disponibles</a></li>
								<li><a href="#">Vehiculos Temp</a></li>								
							</ul>						
						</li>
						<li><a href="#">Tipos Vehiculos</a></li>
					</ul></li>
				<li><a href="Signin?accion=cerrarsesion">Cerrar Sesion</a></li>
			</ul>
		</nav>

	</header>

</body>
</html>