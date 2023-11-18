<%@page import="logic.TipoVehiculoLogic"%>
<%@page import="logic.AlquilerLogic"%>
<%@page import="entities.Alquiler"%>
<%@page import="entities.Persona"%>
<%@page import="entities.Vehiculo"%>
<%@page import="entities.TipoVehiculo"%>
<%@page import="logic.PersonaLogic"%>
<%@page import="logic.VehiculoLogic"%>
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
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
    <%
    Integer idAlquiler = (Integer)request.getAttribute("idAlq");
    
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
				<li><a href="#">Cerrar Sesion</a></li>
			</ul>

		</nav>

	</header>



	 <div>
	 <form class="formulario">
    
	 <h1>Editar Alquiler Admin</h1>
     <div class="contenedor">

		<div class="agrupainput">
			 
			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<div class="agrupabotonesBusc">
						
					</div>
					<%
						AlquilerLogic alqLog = new AlquilerLogic();
						Alquiler alq = new Alquiler();
						Persona pers = new Persona();
						if(idAlquiler!=null) {
							alq = alqLog.getById(idAlquiler);							
							int idPer = alq.getPersona().getId();
							PersonaLogic perLog = new PersonaLogic();
							pers = perLog.getById(idPer);
							}
					%>
					<input type="text" placeholder="Cliente" name="cliente" value="<%=idAlquiler==null?"":pers.getApellido() %> <%=idAlquiler==null?"":pers.getNombre()%> <%=idAlquiler==null?"":pers.getDni()%>">
					<div><input type="hidden" name="idPers" value="<%=pers.getId()%>"></div>
					<div><input type="hidden" name="idAlq" value="<%=idAlquiler%>"></div>
				</div>
			</div>

			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<div class="agrupabotonesBusc">
						
					</div>
					<%
						int idVehic = alq.getVehiculo().getIdVehiculo();
					
						VehiculoLogic vehicLog = new VehiculoLogic();
						Vehiculo vehic = new Vehiculo();
						vehic = vehicLog.getById(idVehic);
																	
						int idTipoVehic = vehic.getTipoVehiculo().getId();
						TipoVehiculoLogic tVehicLog = new TipoVehiculoLogic();
						TipoVehiculo tVehic = new TipoVehiculo();
						tVehic = tVehicLog.getById(idTipoVehic);
					%>
					<input type="text" placeholder="Tipo Vehiculo" value="<%=tVehic.getDescripcion()%>">
				</div>
			</div>
			
			<div><input type="hidden"></div>
			
		</div>

		
		<div class="agrupainput">
			 
			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<div class="agrupabotonesBusc">
						
					</div>
					<input type="text" placeholder="Vehiculo" value="<%=vehic.getMarcayModelo()%> <%=vehic.getColor()%>">
				</div>
			</div>

			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<div class="titulo">Senia: </div><div style="margin: -1px -54px 0px 54px;"><input type="text" placeholder="Senia" value="<%=idAlquiler==null?"":alq.getSenia()%>"></div>
					
				</div>
			</div>
			
			<div><input type="hidden"></div>
			
		</div>

        <div class="agrupainput">

			<div class="input-contenedor">
			 
				<div class="titulo">Fecha inic:</div> <div class="date"><input type="date" value=<%=alq.getFechaInic()%>></div>
				
			</div>

			<div class="input-contenedor">
				
				<div class="titulo">Fecha fin: </div> <div class="date"><input type="date" name="fecFin" value=<%=alq.getFechaFin()%>></div>
				
			</div>

			<div class="input-contenedor">
				
				<div style="margin: 0px -46px 0px 1px;"><input type="text" placeholder="Importe" value="<%=idAlquiler==null?"":alq.getImporte()%>"></div>
			
			</div>

        </div> 
		
		

        <div class="agrupainput">

			<div class="input-contenedor">
				
				<div class="titulo">Km_Inic: </div><div style="margin: 0px -46px 0px 1px;"><input type="text" placeholder="Km_Inic" value="<%=idAlquiler==null?"":alq.getKmInic()%>"></div>
				
			</div>	

			<div class="input-contenedor">
			
				<div class="titulo">Km_Fin: </div><div style="margin: 0px -46px 0px 1px;"><input type="text" name="Kmfin" placeholder="Km_Fin" value="<%=idAlquiler==null?"":alq.getKmFin()%>"></div>
				
			</div>
	
	
			<div class="input-contenedor">
				
				<div class="titulo">Fecha entrega: </div> <div class="date"><input type="date" name="fecentrega" value=<%=alq.getFechaEntrega()%>></div>
				
			</div>
	
		</div>



		<div class="agrupainput">

			<div class="input-contenedor">
            
				<div class="titulo">Fecha cancel: </div> <div class="date"><input type="date" name="feccancel" value=<%=alq.getFechaCancel()%>></div>
				
			</div>


			<div class="input-contenedor">
			 
				<div class="titulo">Reclamos_Obs: </div><div style="margin: 0px -46px 0px 1px;"><input type="text" name="recyobs" placeholder="Reclamos_Obs" value="<%=idAlquiler==null?"":alq.getReclamoyObs()%>"></div>
			 
			</div>
			
			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<div class="input-contenedortipov1">
					<div class="labeltipov"><div class="label1"><label for="tipovehiculo">Estado Alq:</label></div></div>
					<div class="select">
					<select name="txtestado" id="tipovehiculo">
						<option value="<%=alq.getEstado()%>"><%=alq.getEstado()%></option>
						<option value="<%=Alquiler.ESTADO_PENDIENTE%>">Pendiente</option>
						<option value="<%=Alquiler.ESTADO_VIGENTE%>">Vigente</option>
						<option value="<%=Alquiler.ESTADO_FINALIZADO%>">Finalizado</option>
						<option value="<%=Alquiler.ESTADO_CANCELADO%>">Cancelado</option>
					</select>
					</div>
					</div>
					
				</div>
			</div>
			
			<div><input type="hidden"></div>
			
		</div>

        
		

	

		<div class="agrupabotones">
			<input type="submit" name="accion" value="Actualizar" class="button" id="btn_actualizar">
			<input type="submit" name="accion" value="Cancelar" class="button">
		</div>
		
     </div>
    </form>
	</div>
	<script src="scripts/btn.js"></script>
</body>
<script src="scripts/script.js"></script>
</html>