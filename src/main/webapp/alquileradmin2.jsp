<%@page import="entities.Vehiculo"%>
<%@page import="logic.VehiculoLogic"%>
<%@page import="logic.PersonaLogic"%>
<%@page import="entities.Persona"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entities.TipoVehiculo"%>
<%@page import="logic.TipoVehiculoLogic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
 	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" >
	<link rel="stylesheet" href="estilos/estilosalquiler.css">
<%-- 	<%
		String idVehiculo= request.getParameter("id");
		String txtidtipovehiculo=request.getParameter("txtidtipovehiculo");
	%> --%>
</head>
<body>
	

	    <header class="header">

		<div class="logo">Xtreme</div>
		<input type="checkbox" id="toggle">
		<label for="toggle"> <img class="menu" src="imagenes/menu.svg" alt="menu"> </label>
	
		<nav class="navigation">

			<ul>
				<li><a href="index.html">Inicio</a></li>
				<li><a href="#">Reserva</a>
					<ul>
						<li><a href="#">A B M C</a>
							<ul>
								<li><a href="#">Alta</a></li>
								<li><a href="#">Reservas</a></li>
								
							</ul>
						</li>
						
					</ul>
				</li>
				<li><a href="#">A B M Cs</a>
					<ul>
						<li><a href="#">Persona</a>
							<ul>
								<li><a href="#">Alta</a></li>
								<li><a href="principalpersonas.html">Personas</a></li>
								
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
						<li><a href="#">Reservas</a></li>
						<li><a href="#">Vehiculos</a></li>
						<li><a href="#">Tipos Vehiculos</a></li>
					</ul>
				</li>
				<li><a href="#">Cerrar Sesion</a></li>
			</ul>

		</nav>

	</header>



	 <div>
<%-- 	 <%
	 	VehiculoLogic vl = new VehiculoLogic();
	 	int id = Integer.parseInt((String)request.getAttribute("idvehiculo"));
		Vehiculo vehic = vl.getById(id);
	 %> --%>
	 <form class="formulario" action="ServletAlquilerAdmin">
    
	 <h1>Alquiler</h1>
     <div class="contenedor">

		<div class="agrupainput">
			 
			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<label for="">Nom Ape Clte:</label>
					<input type="text" name="gimnasios" id="gimnasios" list="personas">
					<br>
	
					<datalist id="personas">
<%-- 					<%
					PersonaLogic pl = new PersonaLogic();
					LinkedList<Persona> listpl = pl.getAll();
					for (Persona per : listpl) {
					%>
						<option value="<%=per.getId()%> "><%=per.getApellido()%> Dni: <%=per.getDni()%></option>
					<%
					}
					%>	 --%>
						
					</datalist>
					
				</div>
			</div>

			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<label for="">Tipo Vehic:</label>
					<!-- recuperando tipovehiculo y luego agregarlo en el input -->
 					<%-- <input name="txtidtipovehiculo" type="text" id="gimnasios" list="tiposVehic" value="<%=txtidtipovehiculo==null?"":txtidtipovehiculo%>"> --%>
					<br> 
	
					<datalist id="tiposVehic">
<%-- 					<% 
					TipoVehiculoLogic tvl = new TipoVehiculoLogic();
					LinkedList<TipoVehiculo> listtv = tvl.getAllTiposVehiculo();
					for (TipoVehiculo tve : listtv) {						
					%>
        			
        			<option value="<%=tve.getId()%>"><%=tve.getDescripcion()%></option>
        			
        			<% } %>	
        			
					</datalist>  --%>
					
					
										
				</div>
			</div>
			
			<!-- <div><input type="hidden"></div> -->
			
		</div>

		
		<div class="agrupainput">
			 
			<div class="agrupabotones" style="margin: 3px 0px 14px 0px;">
				<input type="submit" name="accion" value="Buscar" class="button">
			</div>

			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<div style="width: 63px;"><label for="">Vehic:</label></div>					
					
					<%-- <input name="vehiculo" type="text" value="<%=idVehiculo==null?"":idVehiculo %>" placeholder="Vehic"> --%>										

			<!-- <div><input type="hidden"></div> -->
				</div>
			</div>
		</div>
		
		
        <div class="agrupainput">

			<div class="input-contenedor">
				
				<div class="titulo">Km_Inic: </div><div style="margin: 0px -46px 0px 0px;"><input type="text" placeholder="Km_Inic"></div>
				
			</div>	


			<div class="input-contenedor">
			
				<div class="titulo">Km_Fin: </div><div style="margin: 0px -46px 0px 0px;"><input type="text" placeholder="Km_Fin"></div>
				
			</div>

		<div class="input-contenedor">
				
			<div class="titulo">Senia: </div><div style="margin: 0px -46px 0px 0px;"><input type="text" placeholder="Senia"></div>
			
		</div>

        </div>       

        <div class="agrupainput">

			<div class="input-contenedor">
			 
			 <div class="titulo">Fecha inic:</div> <div class="date"><input type="date"></div>
			 
			</div>
	
			<div class="input-contenedor">
				
				<div class="titulo">Fecha fin: </div> <div class="date"><input type="date"></div>
				
			</div>
	
			<div class="input-contenedor">
				
				<div class="titulo">Fecha entrega: </div> <div class="date"><input type="date"></div>
				
			</div>
	
			</div>

		<div class="agrupainput">

			<div class="input-contenedor">
            
				<div class="titulo">Fecha cancel: </div> <div class="date"><input type="date"></div>
				
			</div>


			<div class="input-contenedor">
			 
				<div class="titulo">Reclamos_Obs: </div><div style="margin: 0px -46px 0px 0px;"><input type="text" placeholder="Reclamos_Obs"></div>
			 
			</div>
			
			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<label for="">Estado Alq:</label>
					<div style="margin: 24px -51px 0px -147px;"><input type="text" name="gimnasios" id="gimnasios" list="estadoALq"></div>
					<br>
	
					<datalist id="estadoALq">
						<option value="pendiente">
						<option value="en curso">
						<option value="finalizado">
						<option value="cancelado">	
					</datalist>
					
				</div>
			</div>
			
			<div><input type="hidden"></div>
			
		</div>

        
		

	

		<div class="agrupabotones">
			<input type="submit" value="Aceptar" class="button">
			<input type="button" value="Cancelar" class="button" onclick=mostrarPrincipal()>
		</div>
		
     </div>
    </form>
	</div>

</body>
</html>