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
			<a href="altapersona.html">Agregar Nuevo</a>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>DNI</th>
					<th>NOMBRE</th>					
					<th>APELLIDO</th>
					<th>TELEFONO</th>
					<th>ROL-CLTE</th>
					<th>ROL-EMPL</th>
					<th>ACCIONES</th>	
				</tr>
			</thead>
			
			<tbody>
				<tr>
					<td data-label="ID">1</td>
					<td data-label="DNI">2</td>
					<td data-label="NOMBRE">3</td>
					<td data-label="APELLIDO">4</td>
					<td data-label="TELEFONO">5</td>
					<td data-label="ROL-CLTE">6</td>
					<td data-label="ROL-EMPL">7</td>
					<td data-label="ACCIONES">
						<div id="contenedorlinks">
						<div id="editar">
							<a href="">Editar</a>
						</div>
						<div id="eliminar">
							<a href="">Eliminar</a>
						</div>
						</div>
					</td>
				</tr>
				<tr>
					<td data-label="ID">1</td>
					<td data-label="DNI">2</td>
					<td data-label="NOMBRE">3</td>
					<td data-label="APELLIDO">4</td>
					<td data-label="TELEFONO">5</td>
					<td data-label="ROL-CLTE">6</td>
					<td data-label="ROL-EMPL">7</td>
					<td data-label="ACCIONES">					
						<div id="contenedorlinks">
							<div id="editar">
								<a href="">Editar</a>
							</div>
							<div id="eliminar">
								<a href="">Eliminar</a>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td data-label="ID">1</td>
					<td data-label="DNI">2</td>
					<td data-label="NOMBRE">3</td>
					<td data-label="APELLIDO">4</td>
					<td data-label="TELEFONO">5</td>
					<td data-label="ROL-CLTE">6</td>
					<td data-label="ROL-EMPL">7</td>
					<td data-label="ACCIONES">
						<div id="contenedorlinks">
							<div id="editar">
								<a href="">Editar</a>
							</div>
							<div id="eliminar">
								<a href="">Eliminar</a>
							</div>
						</div>
					</td>
				</tr>
				
			</tbody>
		</table>
		</div>
	</div>

</body>
</html>