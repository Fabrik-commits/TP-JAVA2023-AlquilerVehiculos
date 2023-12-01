<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="logic.PersonaLogic"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entities.Persona"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" >
	<link rel="stylesheet" href="estilos/estilosbuscaralquileresxcltes.css">
<%
Boolean rol1 = (Boolean)request.getSession().getAttribute("rol1");
Boolean rol2 = (Boolean)request.getSession().getAttribute("rol2");	
if( !(rol1!=null && rol2!=null) ){
	response.sendRedirect("loginvista.jsp");
}else if(!rol1 && !rol2){
	request.getSession().invalidate();
	response.sendRedirect("loginvista.jsp");
	//System.out.println("probando");
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
								
							</ul>
						</li>
						<li><a href="#">Rol</a>
							<ul>
								<li><a href="ServletRoles?accion=altarol">Alta</a></li>
								<li><a href="ServletRoles?accion=principalroles">Roles</a></li>
								
							</ul>
						</li>
						<li><a href="#">Vehiculo</a>
							<ul>
								<li><a href="ServletVehiculos?accion=altavehiculo">Alta</a></li>
								<li><a href="ServletVehiculos?accion=principalvehic">Vehiculos</a></li>
								
							</ul>
						</li>
						<li><a href="#">Tipo Vehiculo</a>
							<ul>
								<li><a href="ServletTiposVehiculo?accion=add">Alta</a></li>
								<li><a href="ServletTiposVehiculo?accion=principaltiposvehic">Tipos Vehiculo</a></li>
								
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
		<h1>Alquileres y Clientes</h1>
		
		<div id="main-container">
		<div style="text-align: center">
			<input type="text" class="form-control" id="input-search" placeholder="Filtrar por apellido... " style="margin: 5px 0px 5px 8px; padding: 4px 0px 5px 5px; font-size: 14px;">
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>DNI</th>
					<th>NOMBRE</th>					
					<th>APELLIDO</th>
					<th>ACCIONES</th>	
				</tr>
			</thead>
			
			<tbody id="tbody-clientes">
			<%
				/* int idRol = 2; */
			
				PersonaLogic perLog = new PersonaLogic();
				LinkedList<Persona> listPersxRolUsr = perLog.getAllPersxRolUsr();
				for (Persona pers : listPersxRolUsr) {
			%>			
				<tr>
					<td data-label="DNI"><%=pers.getDni()%></td>
					<td data-label="NOMBRE"><%=pers.getNombre()%></td>
					<td data-label="APELLIDO"><%=pers.getApellido()%></td>
					<td data-label="ACCIONES">
						<div id="contenedorlinks">
						<div id="aceptar">
							<a href="ServletAlquilerAdmin?accion=clienteelegido&id=<%=pers.getId()%>">Alquileres</a>
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
				let textoConsulta = tableRows[i].cells[2].textContent.toString().toLowerCase();
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