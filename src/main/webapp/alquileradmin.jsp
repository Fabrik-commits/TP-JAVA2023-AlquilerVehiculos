<%
	HttpSession miSesion = request.getSession();
%>
<%-- <%@page import="java.time.LocalDateTime"%> --%>
<%@page import="entities.Vehiculo"%>
<%@page import="logic.VehiculoLogic"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entities.TipoVehiculo"%>
<%@page import="logic.TipoVehiculoLogic"%>
<%@page import="logic.PersonaLogic"%>
<%@page import="entities.Persona"%>
<%@page import="entities.Alquiler"%>
<%@page import="java.time.LocalDate"%>
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
    <%    
    //Integer idVehiculo = (Integer)request.getAttribute("idVehic");
    Integer idVehiculo = (Integer)miSesion.getAttribute("idVehic");
    //Integer idPersona = (Integer)request.getAttribute("idPer");
    Integer idPersona = (Integer)miSesion.getAttribute("idPer"); 
    //Integer idPersona = (Integer)session.getAttribute("personaElegida"); //TODO session 
    Double importeTotalVehic = (Double)request.getAttribute("importeTotal");
    String fechaInicial = (String)request.getAttribute("fecInit");
    String fechaFinal = (String)request.getAttribute("fecFin");
	%>
</head>
<body>
<!-- int number = Integer.parseInt(str); -->
<!-- int idVehiculo = Integer.parseInt(request.getAttribute("idVehic")); -->

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
	 <form class="formulario" action="ServletAlquilerAdmin">
    
	 <h1>Alquiler Admin</h1>
     <div class="contenedor">

		<div class="agrupainput">
			 
			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<div class="agrupabotonesBusc">
						<input type="button" value="BuscarClte" class="buttonCliVe" onclick=mostrarPrincipalClientes()>
					</div>
					<%
					PersonaLogic plog = new PersonaLogic();
					Persona per = new Persona();
					if(idPersona!=null){
						per = plog.getById(idPersona);
						//request.getSession().setAttribute("clienteBuscado", per);
						//request.getSession().getAttribute("clienteBuscado");
					}
					%>
					<input type="text" placeholder="Cliente" name="cliente" value="<%=idPersona==null?"":per.getApellido() %> <%=idPersona==null?"":per.getNombre()%> <%=idPersona==null?"":per.getDni()%>">
					<div><input type="hidden" name="idPers" value="<%=per.getId()%>"></div>
					<%-- <input type="text" placeholder="Cliente" value="<%=idPersona==null?"":((Persona) request.getSession().getAttribute("clienteBuscado")).getApellido()%>"> --%>
				</div>
			</div>

			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<label for="">Tipo Vehic:</label>
					
					<select name="txtidtipovehiculo" id="tipovehiculo" style="margin: 13px 0px 0px -20px;">
					<% 
					TipoVehiculoLogic tvl = new TipoVehiculoLogic();
					LinkedList<TipoVehiculo> listtv = tvl.getAllTiposVehiculo();
					for (TipoVehiculo tve : listtv) {				
					%>
					<option value="<%=tve.getId()%>"><%=tve.getDescripcion()%></option>
					<% } %>
					</select>
					
				</div>
			</div>
			
			<div><input type="hidden"></div>
			
		</div>

		
		<div class="agrupainput">
			 
			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<div class="agrupabotonesBusc">
						<input type="submit" name="accion" value="BuscarVehi" class="buttonCliVe">
					</div>
					<%
					//int id = Integer.parseInt(idVehiculo);
						VehiculoLogic vl = new VehiculoLogic();
						Vehiculo vehic = new Vehiculo();
						if(idVehiculo!=null)
							{
							vehic = vl.getById(idVehiculo);
  
							}
						
						//vehic = vl.getById(Integer.parseInt(idVehiculo));
					%>
					<input type="text" placeholder="Vehiculo" name="vehiculo" value="<%=idVehiculo==null?"":vehic.getMarcayModelo()%> <%=idVehiculo==null?"":vehic.getColor()%>">
					<div><input type="hidden" name="idVehiculo" value="<%=vehic.getIdVehiculo()%>"></div>
				</div>
			</div>

			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<div class="titulo">Senia: </div><div style="margin: -1px -54px 0px 54px;"><input type="text" name="senia" placeholder="Senia"></div>
					
				</div>
			</div>
			
			<div><input type="hidden"></div>
			
		</div>

        <div class="agrupainput">

			<div class="input-contenedor">
			 
				<div class="titulo">Fecha inic:</div> <div class="date"><input type="date" min="<%=LocalDate.now()%>" name="fecInic" value=<%=fechaInicial==null?"":fechaInicial%>></div>
				
				<%-- value=<%=importeTotalVehic==null?"":importeTotalVehic%> --%>
				<%-- value=<%=fechaInicial==null?"":fechaInicial%> --%>
				<%-- value="<%="fechaInicial==null?"":fechaInicial%>" --%>
				<%--  --%>
				<%-- value="<%=idVehiculo==null?"":vehic.getMarcayModelo()%> <%=idVehiculo==null?"":vehic.getColor()%>" --%>
			</div>

			<div class="input-contenedor">
				
				<div class="titulo">Fecha fin: </div> <div class="date"><input type="date" min="<%=LocalDate.now().plusDays(1)%>" name="fecFin" value=<%=fechaFinal==null?"":fechaFinal%>></div>
				
			</div>

			<div class="input-contenedor">
				
				<input type="submit" name="accion" value="CalculaImporte" class="buttonCalcImp"><div style="margin: 0px -46px 0px 1px;"><input type="text" name="importe" placeholder="Importe" value=<%=importeTotalVehic==null?"":importeTotalVehic%>></div>
																									
			</div>

        </div> 
		
		

        <div class="agrupainput">

			<div class="input-contenedor">
				
				<div class="titulo">Km_Inic: </div><div style="margin: 0px -46px 0px 1px;"><input type="text" name="kminic" placeholder="Km_Inic"></div>
				
			</div>	

			<div class="input-contenedor">
			
				<div class="titulo">Km_Fin: </div><div style="margin: 0px -46px 0px 1px;"><input type="text" name="kmfin" placeholder="Km_Fin"></div>
				
			</div>
	
	
			<div class="input-contenedor">
				
				<div class="titulo">Fecha entrega: </div> <div class="date"><input type="date" name="fecentrega"></div>
				
			</div>
	
		</div>



		<div class="agrupainput">

			<div class="input-contenedor">
            
				<div class="titulo">Fecha cancel: </div> <div class="date"><input type="date" name="feccancel"></div>
				
			</div>


			<div class="input-contenedor">
			 
				<div class="titulo">Reclamos_Obs: </div><div style="margin: 0px -46px 0px 1px;"><input type="text" name="recyobs" placeholder="Reclamos_Obs"></div>
			 
			</div>
			
			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<div class="input-contenedortipov1">
					<div class="labeltipov"><div class="label1"><label for="tipovehiculo">Estado Alq:</label></div></div>
					<div class="select">
					<select name="txtestado" id="estado">
						<option value="">-----------------------------</option>
						<option selected="selected" value=<%=Alquiler.ESTADO_PENDIENTE%>>Pendiente</option> 
						<option value=<%=Alquiler.ESTADO_VIGENTE%>>Vigente</option>
						<option value=<%=Alquiler.ESTADO_FINALIZADO%>>Finalizado</option>
						<option value=<%=Alquiler.ESTADO_CANCELADO%>>Cancelado</option>
					</select>
					</div>
					</div>
					
				</div>
			</div>
			
			<div><input type="hidden"></div>
			
		</div>


		<div class="agrupabotones">
			<input type="submit" name="accion" value="Aceptar" class="button">
			<input type="submit" name="accion" value="Cancelar" class="button">
		</div>
		
		
     </div>
    </form>
	</div>
</body>
<script src="scripts/script.js"></script>
</html>