<%@page import="entities.Alquiler"%>
<%@page import="java.util.LinkedList"%>
<%@page import="logic.AlquilerLogic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" >
	<link rel="stylesheet" href="estilos/estilosbuscaralquileresxcltes.css">
<%
Boolean rol2 = (Boolean)request.getSession().getAttribute("rol2");
if( !(rol2!=null) ){
	response.sendRedirect("loginvista.jsp");
}else if(!rol2){
	request.getSession().invalidate();
	response.sendRedirect("index2.jsp");
}
Integer idPersona = (Integer)request.getSession().getAttribute("idUsr");
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




	<div>
		<h1>Alquileres x Cliente</h1>
		
		<div id="main-container">
		<div style="text-align: center">
			<input type="text" class="form-control" id="input-search" placeholder="Filtrar por tipo... " style="margin: 5px 0px 5px 8px; padding: 4px 0px 5px 5px; font-size: 14px;">
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>ID ALQ</th>
					<th>VEHICULO</th>
					<th>VEHIC COLOR</th>					
					<th>TIPO VEHICULO</th>
					<th>FEC INICIO</th>
					<th>ESTADO</th>
					<th>ACCION</th>	
				</tr>
			</thead>
			
			<tbody id="tbody-clientes">
			<%
				AlquilerLogic alqLog = new AlquilerLogic();
				LinkedList<Alquiler> listAlquileresxClteUsr = alqLog.getAllByALquileresxClte(idPersona);
				for(Alquiler alq : listAlquileresxClteUsr) {
			%>
				<tr>
					<td data-label="ID ALQ"><%=alq.getId()%></td>
					<td data-label="VEHICULO"><%=alq.getVehiculo().getMarcayModelo()%></td>
					<td data-label="VEHIC COLOR"><%=alq.getVehiculo().getColor()%></td>
					<td data-label="TIPO VEHICULO"><%=alq.getVehiculo().getTipoVehiculo().getDescripcion()%></td>
					<td data-label="FEC INICIO"><%=alq.getFechaInic()%></td>
					<td data-label="ESTADO"><%=alq.getEstado()%></td>
					<td data-label="ACCION">
						<div id="contenedorlinks">
						<div id="aceptar">
							<a href="ServletAlquilerUsuario?accion=alquilerelegido&id=<%=alq.getId()%>">Mostrar</a>
						</div>
						</div>
					</td>
				</tr>
				
			<% } %>
			</tbody>
		</table>
		</div>
	</div>
	<script>
		document.getElementById("input-search").addEventListener("input", onInputChange);
		function onInputChange(){
			let inputText = document.getElementById("input-search").value.toString().toLowerCase();
			/*console.log(inputText);*/
			let tableBody = document.getElementById("tbody-clientes");
			let tableRows = tableBody.getElementsByTagName("tr");
			/*console.log(tableRows);*/	
			for (let i = 0; i < tableRows.length; i++) {
				/*console.log(tableRows[i].cells[2].textContent);*/	
				let textoConsulta = tableRows[i].cells[3].textContent.toString().toLowerCase();
				if (textoConsulta.indexOf(inputText) === -1) {
					tableRows[i].style.visibility = "collapse";
				} else {
					tableRows[i].style.visibility = "";
				}	
			}
		}
	</script>
</body>
</html>