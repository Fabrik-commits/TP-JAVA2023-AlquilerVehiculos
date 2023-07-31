<%@page import="logic.TipoVehiculoLogic"%>
<%@page import="entities.TipoVehiculo"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
 	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" >
	<link rel="stylesheet" href="estilos/estilosaltavehic.css">
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
	 <form class="formulario" action="ServletVehiculos">
    
	 <h1>Alta Vehiculo</h1>
     <div class="contenedor">

        <div class="agrupainput">

        <div class="input-contenedor">
         
         <div class="titulo" style="padding: 3px">Marca y Modelo:</div>
         <input type="text" name="txtmarcaymodelo" placeholder="Marca y Modelo">
         
        </div>

        <div class="input-contenedor">
            
            <div class="titulo">A&ntilde;o:</div>
            <input type="text" name="txtanio" placeholder="A&ntilde;o">
            
        </div>
        
        <div class="input-contenedor">
            
            <div class="titulo">Kilometraje:</div>
            <input type="text" name="txtkilometraje" placeholder="Kilometraje">
            
        </div>

        </div>

        <div class="agrupainput">
        

        <div class="input-contenedor">
            
            <div class="titulo">Pasajeros:</div>
            <input type="text" name="txtpasajeros" placeholder="Pasajeros">
            
        </div>
        
        <div class="input-contenedor">
            
            <div class="titulo">Color:</div>
            <input type="text" name="txtcolor" placeholder="Color">
            
        </div>
         
        <div class="input-contenedor">
         
         <div class="titulo">Estado:</div>
         <input type="text" name="txtestado" placeholder="Estado">
         
        </div>
        
        </div>

        

		<div class="agrupainput">

			<div class="input-contenedor">
				
				<div class="titulo">Precio x Km:</div>
				<input type="text" name="txtprecioxkm" placeholder="Precio x Km">
				
			</div>
			 
			<div class="input-contenedor">
			 
			 <div class="titulo">Matricula:</div>
			 <input type="text" name="txtmatricula" placeholder="Matricula">
			 
			</div>
			
			<div class="input-contenedor">
			 
			 <div class="titulo">Capacidad Max:</div>
			 <input type="text" name="txtcapacidadmaxima" placeholder="Capacidad Max">
			 
			</div>
			
				<div><input type="hidden" name="txtidtipovehiculo" value=""></div>
			
		</div>
        
		
			<div class="agrupainputtipov">
				<div class="input-contenedortipov1">
				<div class="labeltipov"><label for="tipovehiculo">Tipo Vehiculo :</label></div>
				</div>
				
				<div class="input-contenedortipov2">
				
    			<select name="" id="tipovehiculo">
        			<option value="">Escoge una opcion</option>
        			
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
	

		<div class="agrupabotones">
			<input type="submit" name="accion" value="Agregar" class="button" onclick=mostrarPrincipal()>
			<input type="submit" name="accion" value="Cancelar" class="button" onclick=mostrarPrincipal()>
		</div>
		
     </div>
    </form>
	</div>
</body>

</html>