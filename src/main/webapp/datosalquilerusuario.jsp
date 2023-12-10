<%@page import="entities.Persona"%>
<%@page import="entities.Alquiler"%>
<%@page import="entities.Vehiculo"%>
<%@page import="entities.TipoVehiculo"%>
<%@page import="logic.PersonaLogic"%>
<%@page import="logic.AlquilerLogic"%>
<%@page import="logic.VehiculoLogic"%>
<%@page import="logic.TipoVehiculoLogic"%>
<%
	HttpSession miSesion = request.getSession();
	/* HttpSession miSesion2 = request.getSession(); */
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
 	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" >
	<link rel="stylesheet" href="estilos/estilosalquiler.css">
<%
	Boolean rol2 = (Boolean)request.getSession().getAttribute("rol2");
	if( !(rol2!=null) ){			//!(rol1!=null && rol2!=null)	!( rol2)
	response.sendRedirect("index2.jsp");
	}else if(!rol2){
		request.getSession().invalidate();
		response.sendRedirect("loginvista.jsp");
	}  	
	Integer idAlq = (Integer)request.getAttribute("idAlq");
	Integer idPersona = (Integer)miSesion.getAttribute("idUsr");
%>	
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
				<li><a href="Signin?accion=cerrarsesion">Cerrar Sesion</a></li>
			</ul>

		</nav>

	</header>
	
	<div>
	 <form class="formulario">
    
	 <h1>Datos Alquiler Usuario</h1>
     <div class="contenedor">

		<div class="agrupainput">
			 
			<div class="input-contenedor">	
				<div class="agrupainputtipov">
<!-- 					<div class="agrupabotonesBusc">
						
					</div> -->
					<%
					PersonaLogic plog = new PersonaLogic();
					Persona per = new Persona();
					if(idPersona!=null){
						per = plog.getById(idPersona);
					}
					%>
					<div class="titulo">Cliente: </div><input type="text" value="<%=idPersona==null?"":per.getApellido()%> <%=idPersona==null?"":per.getDni()%>" placeholder="Cliente">
				</div>
			</div>

			<div class="input-contenedor">	
				<div class="agrupainputtipov">
<!-- 					<div class="agrupabotonesBusc">
						
					</div> -->
					<%
					Alquiler alq = new Alquiler();
					Vehiculo vehic = new Vehiculo();
					VehiculoLogic vehicLog = new VehiculoLogic();
					AlquilerLogic alqLog = new AlquilerLogic();
					
					alq = alqLog.getById(idAlq);
					int idVehic = alq.getVehiculo().getIdVehiculo();
					
					vehic = vehicLog.getById(idVehic);
					int idTVehic = vehic.getTipoVehiculo().getId();
					TipoVehiculoLogic tvl = new TipoVehiculoLogic();
					TipoVehiculo tv = new TipoVehiculo();
					tv = tvl.getById(idTVehic);
					//Alquiler alq = new Alquiler();
					//AlquilerLogic alqLog = new AlquilerLogic();
/* 					if(alqLog.getById(idAlq)!=null){
						alq = alqLog.getById(idAlq);
						//Double importe = (Double)alq.getImporte();
						//System.out.println(alq.getVehiculo().getTipoVehiculo().getId());
						//System.out.println();
					}	 */		
					%>
					<div class="titulo">Tipo Vehiculo: </div><input type="text" value="<%=tv.getDescripcion()%>" placeholder="Tipo Vehiculo">
				</div>
			</div>
			
			<div><input type="hidden"></div>
			
		</div>

		
		<div class="agrupainput">
			 
			<div class="input-contenedor">	
				<div class="agrupainputtipov">
<!-- 					<div class="agrupabotonesBusc">
						
					</div> -->
					<div class="titulo">Vehiculo: </div><input type="text" value="<%=idAlq==null?"":vehic.getMarcayModelo()%> <%=idAlq==null?"":vehic.getColor()%>" placeholder="Vehiculo">
				</div>
			</div>

			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<div class="titulo">Senia: </div><div style="margin: -1px -54px 0px 54px;"><input type="text" value="<%=idAlq==null?"":alq.getSenia()%>" placeholder="Senia"></div>
					
				</div>
			</div>
			
			<div><input type="hidden"></div>
			
		</div>

        <div class="agrupainput">

			<div class="input-contenedor">
			 
				<div class="titulo">Fecha inic:</div> <div class="date"><input type="date" value=<%=alq.getFechaInic()%>></div>
				
			</div>

			<div class="input-contenedor">
				
				<div class="titulo">Fecha fin: </div> <div class="date"><input type="date" value=<%=alq.getFechaFin()%>></div>
				
			</div>

			<div class="input-contenedor">
				
				<div class="titulo">Importe: </div><div style="margin: 0px -46px 0px 1px;"><input type="text" value="<%=alq.getImporte()%>" placeholder="Importe"></div>
			
			</div>

        </div> 
		
		

        <div class="agrupainput">

			<div class="input-contenedor">
				
				<div class="titulo">Km_Inic: </div><div style="margin: 0px -46px 0px 1px;"><input type="text" value="<%=alq.getKmInic()%>" placeholder="Km_Inic"></div>
				
			</div>	

			<div class="input-contenedor">
			
				<div class="titulo">Km_Fin: </div><div style="margin: 0px -46px 0px 1px;"><input type="text" value="<%=alq.getKmFin()%>" placeholder="Km_Fin"></div>
				
			</div>
	
	
			<div class="input-contenedor">
				
				<div class="titulo">Fecha entrega: </div> <div class="date"><input type="date" value=<%=alq.getFechaEntrega()%>></div>
				
			</div>
	
		</div>



		<div class="agrupainput">

			<div class="input-contenedor">
            
				<div class="titulo">Fecha cancel: </div> <div class="date"><input type="date" value=<%=alq.getFechaCancel()%>></div>
				
			</div>


			<div class="input-contenedor">
			 
				<div class="titulo">Reclamos_Obs: </div><div style="margin: 0px -46px 0px 1px;"><input type="text" value="<%=alq.getReclamoyObs()%>" placeholder="Reclamos_Obs"></div>
			 
			</div>
			
			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<div class="input-contenedortipov1">
					<div class="labeltipov"><div class="label1"><label for="tipovehiculo">Estado Alq:</label></div></div>
<!-- 					<div class="select">
					<select name="" id="tipovehiculo">
						<option value="">-----------------------------</option>
						<option value="">Pendiente</option>
						<option value="">En curso</option>
						<option value="">Finalizado</option>
						<option value="">Cancelado</option>
					</select> -->
					<input type="text" name="txtestado" placeholder="Estado Alq" value="Pendiente">
					</div>
					
					
				</div>
			</div>
			
			<div><input type="hidden"></div>
			
		</div>

        
		

	

		<div class="agrupabotones">
			<input type="submit" name="accion" value="Aceptado" class="button">
			<!-- <input type="button" value="Cancelar" class="button" onclick=mostrarPrincipal()> -->
		</div>
		
     </div>
    </form>
	</div>
	<script src="scripts/script.js"></script>
</body>
</html>