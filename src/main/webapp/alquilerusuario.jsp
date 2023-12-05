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
    
	 <h1>Alquiler Admin</h1>
     <div class="contenedor">

		<div class="agrupainput">
			 
			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<div class="agrupabotonesBusc">
						
					</div>
					<input type="text" placeholder="Cliente">
				</div>
			</div>

			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<label for="">Tipo Vehic:</label>
					
					<select name="" id="tipovehiculo" style="margin: 13px 0px 0px -20px;">
						<option value="">-----------------------------</option>
						<option value="">Camion   c/Acomplado</option>
						<option value="">Chata</option>
						<option value="">Camion   Simple</option>
					</select>
					
				</div>
			</div>
			
			<div><input type="hidden"></div>
			
		</div>

		
		<div class="agrupainput">
			 
			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<div class="agrupabotonesBusc">
						<input type="button" value="BuscarVehi" class="buttonCliVe" onclick=mostrarPrincipal()>
					</div>
					<input type="text" placeholder="Vehiculo">
				</div>
			</div>

			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<div class="titulo">Senia: </div><div style="margin: -1px -54px 0px 54px;"><input type="text" placeholder="Senia"></div>
					
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
				
				<input type="button" value="Calcula Importe" class="buttonCalcImp"><div style="margin: 0px -46px 0px 1px;"><input type="text" placeholder="Importe"></div>
			
			</div>

        </div> 
		
		

        <div class="agrupainput">

			<div class="input-contenedor">
				
				<div class="titulo">Km_Inic: </div><div style="margin: 0px -46px 0px 1px;"><input type="text" placeholder="Km_Inic"></div>
				
			</div>	

			<div class="input-contenedor">
			
				<div class="titulo">Km_Fin: </div><div style="margin: 0px -46px 0px 1px;"><input type="text" placeholder="Km_Fin"></div>
				
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
			 
				<div class="titulo">Reclamos_Obs: </div><div style="margin: 0px -46px 0px 1px;"><input type="text" placeholder="Reclamos_Obs"></div>
			 
			</div>
			
			<div class="input-contenedor">	
				<div class="agrupainputtipov">
					<div class="input-contenedortipov1">
					<div class="labeltipov"><div class="label1"><label for="tipovehiculo">Estado Alq:</label></div></div>
					<div class="select">
					<select name="" id="tipovehiculo">
						<option value="">-----------------------------</option>
						<option value="">Pendiente</option>
						<option value="">En curso</option>
						<option value="">Finalizado</option>
						<option value="">Cancelado</option>
					</select>
					</div>
					</div>
					
				</div>
			</div>
			
			<div><input type="hidden"></div>
			
		</div>
        		

		<div class="agrupabotones">
			<input type="button" value="Aceptar" class="button">
			<input type="button" value="Cancelar" class="button">
		</div>
		
     </div>
    </form>
	</div>	

</body>
</html>