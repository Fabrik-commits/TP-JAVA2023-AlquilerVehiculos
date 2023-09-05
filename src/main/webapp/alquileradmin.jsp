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
	 <form class="formulario">
    
	 <h1>Alquiler</h1>
     <div class="contenedor">

		<div class="agrupainput">
			 
			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<label for="">Nom Ape Clte:</label>
					<input type="text" name="gimnasios" id="gimnasios" list="personas">
					<br>
	
					<datalist id="personas">
					<%
					PersonaLogic pl = new PersonaLogic();
					LinkedList<Persona> listpl = pl.getAll();
					for (Persona per : listpl) {
					%>
						<option value="<%=per.getNombre()%>  <%=per.getApellido()%>">Dni:  <%=per.getDni()%></option>

					<%
					}
					%>	
						
					</datalist>
					
				</div>
			</div>

			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<label for="">Tipo Vehic:</label>
					<input type="text" name="gimnasios" id="gimnasios" list="tipoVehic">
					<br>
	
					<datalist id="tipoVehic">
					<% 
					TipoVehiculoLogic tvl = new TipoVehiculoLogic();
					LinkedList<TipoVehiculo> listtv = tvl.getAllTiposVehiculo();
					for (TipoVehiculo tve : listtv) {
						
					%>
        			        			
        			<option value="<%=tve.getDescripcion()%>">Id: <%=tve.getId()%></option>
        			
        			<% } %>	
					</datalist>
					
				</div>
			</div>
			
			<div><input type="hidden"></div>
			
		</div>

		
		<div class="agrupainput">
			 
			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<label for="">Vehic:</label>
					<%-- con el tipo vehic obtenido obtener todos los vehiculos --%>
					<input type="text" name="gimnasios" id="gimnasios" list="vehic">
					<br>	
					<datalist id="vehic">
						<option value="Camion c/Acomplado">
						<option value="Chata">
						<option value="Camion Simple">
					</datalist>

					
<%-- 				<label for="">Vehic:</label>
					con el tipo vehic obtenido obtener todos los vehiculos
					<input type="text" name="gimnasios" id="gimnasios" list="vehic">
					<br>	
					<datalist id="vehic">
					<%
						VehiculoLogic vl = new VehiculoLogic();
						LinkedList<Vehiculo> listvehic = vl.getAll();
						for (Vehiculo vehic : listvehic) {
							
					%>
						<option value="<%=vehic.getMarcayModelo()%>">Id: <%=vehic.getIdVehiculo()%></option>

					<% } %>	
					</datalist> --%>
					
					
				</div>
			</div>

			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<label for="">Estado Vehic:</label>
					<input type="text" placeholder="Estado Vehic">
					
				</div>
			</div>
			
			<div><input type="hidden"></div>
			
		</div>

        <div class="agrupainput">

        <div class="input-contenedor">
         
		 <div class="titulo">Fecha inic:</div> <div class="date"><input type="date"></div>
         
        </div>

        <div class="input-contenedor">
            
            <div class="titulo">Fecha fin: </div> <div class="date"><input type="date"></div>
            
        </div>

		<div class="input-contenedor">
            
            <div class="titulo">Fecha cancel: </div> <div class="date"><input type="date"></div>
            
        </div>

        </div>

       

		<div class="agrupainput">

			<div class="input-contenedor">
            
				<div class="titulo">Fecha Entrega: </div> <div class="date2"><input type="date"></div>
				
			</div>

			<div class="input-contenedor">
				
				<div class="titulo">Km_Inic: </div><div style="margin: 0px -46px 0px 0px;"><input type="text" placeholder="Km_Inic"></div>
				
			</div>
	
			<div class="input-contenedor">
			
				<div class="titulo">Km_Fin: </div><div style="margin: 0px -46px 0px 0px;"><input type="text" placeholder="Km_Fin"></div>
				
			</div>
		</div>

		<div class="agrupainput">

			<div class="input-contenedor">
				
				<div class="titulo">Senia: </div><div style="margin: 0px -46px 0px 0px;"><input type="text" placeholder="Senia"></div>
				
			</div>
			 
			<div class="input-contenedor">
			 
				<div class="titulo">Reclamos_Obs: </div><div style="margin: 0px -46px 0px 0px;"><input type="text" placeholder="Reclamos_Obs"></div>
			 
			</div>
			
			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<label for="">Estado Alq:</label>
					<div style="margin: 24px -51px 0px -147px;"><input type="text" name="gimnasios" id="gimnasios" list="gyms"></div>
					<br>
	
					<datalist id="gyms">
						<option value="Camion c/Acomplado">
						<option value="Chata">
						<option value="Camion Simple">
					</datalist>
					
				</div>
			</div>
			
			<div><input type="hidden"></div>
			
		</div>

        
		

	

		<div class="agrupabotones">
			<input type="button" value="Aceptar" class="button" onclick=mostrarPrincipal()>
			<input type="button" value="Cancelar" class="button" onclick=mostrarPrincipal()>
		</div>
		
     </div>
    </form>
	</div>
</body>
<script src="scripts/script.js"></script>


</html>