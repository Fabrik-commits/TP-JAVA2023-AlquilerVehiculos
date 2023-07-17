<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" >
	<link rel="stylesheet" href="estilos/estilosvehic.css">
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




	<div class="contenedor-padre">
		<h1>Vehiculos</h1>
		
		<div id="main-container">
		<div id="agregarnuevo">
			<a href="tipovehiculo.html">Agregar Nuevo</a>
		</div>
		<table class="table">
			<thead>
				<tr>

					<th>MARCA Y MODELO</th>
					<th>ANIO</th>
					<th>KILOMETRAJE</th>
					<th>PASAJEROS</th>
					<th>COLOR</th>
					<th>ESTADO</th>
					<th>PRECIOxKM</th>
					<th>MATRICULA</th>
					<th>TIPO</th>
					<th>ACCIONES</th>	
				</tr>
			</thead>
			
			<tbody>
				<tr>
					
					<td data-label="MARCA Y MODELO">2</td>
					<td data-label="ANIO">3</td>

					<td data-label="KILOMETRAJE">2</td>
					<td data-label="PASAJEROS">3</td>

					<td data-label="COLOR">2</td>
					<td data-label="ESTADO">3</td>

					<td data-label="PRECIOxKM">2</td>
					<td data-label="MATRICULA">3</td>

					<td data-label="TIPO">3</td>
					
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
					
					<td data-label="MARCA Y MODELO">2</td>
					<td data-label="ANIO">3</td>

					<td data-label="KILOMETRAJE">2</td>
					<td data-label="PASAJEROS">3</td>

					<td data-label="COLOR">2</td>
					<td data-label="ESTADO">3</td>

					<td data-label="PRECIOxKM">2</td>
					<td data-label="MATRICULA">3</td>

					<td data-label="TIPO">3</td>
					
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
					
					<td data-label="MARCA Y MODELO">2</td>
					<td data-label="ANIO">3</td>

					<td data-label="KILOMETRAJE">2</td>
					<td data-label="PASAJEROS">3</td>

					<td data-label="COLOR">2</td>
					<td data-label="ESTADO">3</td>

					<td data-label="PRECIOxKM">2</td>
					<td data-label="MATRICULA">3</td>

					<td data-label="TIPO">3</td>
					
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