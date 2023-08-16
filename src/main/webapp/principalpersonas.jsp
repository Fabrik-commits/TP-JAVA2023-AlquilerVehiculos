<%@page import="java.util.LinkedList"%>
<%@page import="logic.PersonaLogic"%>
<%@page import="entities.Persona"%>
<%@page import="entities.Rol"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" >
	<link rel="stylesheet" href="estilos/estilospersonas.css">
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
		<h1>Personas</h1>
		
		<div id="main-container">
		<div id="agregarnuevo">
			<a href="ServletPersonas?accion=altapersona">Agregar Nuevo</a>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>DNI</th>
					<th>NOMBRE</th>					
					<th>APELLIDO</th>
					<th>TELEFONO</th>
					<th>DIRECCION</th>
					<th>E-MAIL</th>
					<th>ROL-CLTE</th>
					<th>ROL-ADMIN</th>
					<th>ACCIONES</th>	
				</tr>
			</thead>
			
			<tbody>
			<%
			PersonaLogic perLog = new PersonaLogic();
			LinkedList<Persona> listPers = perLog.getAll();	
			Rol rol1 = new Rol();
			Rol rol2 = new Rol();
			rol1.setId(1);
			rol2.setId(2);
			for (Persona pers : listPers) {
				if(pers.hasRol(rol1)){}
				else{}
				if(pers.hasRol(rol2)){}
				else{}
			%>
				<tr>
					<td data-label="DNI"><%=pers.getDni()%></td>
					<td data-label="NOMBRE"><%=pers.getNombre()%></td>
					<td data-label="APELLIDO"><%=pers.getApellido()%></td>
					<td data-label="TELEFONO"><%=pers.getTel()%></td>
					<td data-label="DIRECCION"><%=pers.getDireccion()%></td>
					<td data-label="E-MAIL"><%=pers.getEmail()%></td>
					
					
					<td data-label="ROL-CLTE"><img class="visto" style="max-width: 20%" height="auto" src="<%=pers.hasRol(rol2)?"imagenes/visto.png":"imagenes/novisto.png"%>">  </td>
					<td data-label="ROL-ADMIN"><img class="visto" style="max-width: 20%" height="auto" src="<%=pers.hasRol(rol1)?"imagenes/visto.png":"imagenes/novisto.png"%>"></td>
					
					
					<td data-label="ACCIONES">
						<div id="contenedorlinks">
						<div id="editar">
							<a href="ServletPersonas?accion=editarpersona&id=<%=pers.getId()%>">Editar</a>
						</div>
						<div id="eliminar">
							<a href="ServletPersonas?accion=eliminarpersona&id=<%=pers.getId()%>">Eliminar</a>
						</div>
						</div>
					</td>
				</tr>
				
			<% } %>	
				
								
			</tbody>
		</table>
		</div>
	</div>
<script src="scripts/script.js"></script>
</body>
</html>