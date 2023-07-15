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
	 <form class="formulario">
    
	 <h1>Alta Vehiculo</h1>
     <div class="contenedor">

        <div class="agrupainput">

        <div class="input-contenedor">
         
         <input type="text" placeholder="Marca y Modelo">
         
        </div>

        <div class="input-contenedor">
            
            <input type="text" placeholder="A&ntilde;o">
            
        </div>

        </div>

        <div class="agrupainput">
        <div class="input-contenedor">
            
            <input type="text" placeholder="Kilometraje">
            
        </div>

        <div class="input-contenedor">
            
            <input type="text" placeholder="Pasajeros">
            
        </div>
        </div>

        <div class="agrupainput">

        <div class="input-contenedor">
            
            <input type="text" placeholder="Color">
            
        </div>
         
        <div class="input-contenedor">
         
         <input type="text" placeholder="Estado">
         
        </div>
        </div>

		<div class="agrupainput">

			<div class="input-contenedor">
				
				<input type="text" placeholder="Precio x Km">
				
			</div>
			 
			<div class="input-contenedor">
			 
			 <input type="text" placeholder="Matricula">
			 
			</div>
			</div>
        
		
			<div class="agrupainputtipov">
				<div class="input-contenedortipov1">
				<div class="labeltipov"><label for="tipovehiculo">Tipo Vehiculo :</label></div>
				</div>
				<div class="input-contenedortipov2">
    			<select name="" id="tipovehiculo">
        			<option value="">-----------------------------</option>
        			<option value="">Camion   c/Acomplado</option>
        			<option value="">Chata</option>
        			<option value="">Camion   Simple</option>
    			</select>
				</div>
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