<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" >
<link rel="stylesheet" href="estilos/estilosalta.css">

<%
	/* Persona p = (Persona)session.getAttribute("usuario"); */
	//System.out.println(request.getSession().getAttribute("rol1"));
	//System.out.println();
	//String rol1 = (String)request.getSession().getAttribute("rol1");
	//System.out.println(rol1);
	
	//Todo este codigo de abajo es para validar si el usr es admin
	Boolean rol1 = (Boolean)request.getSession().getAttribute("rol1");
	Boolean rol2 = (Boolean)request.getSession().getAttribute("rol2");
	if( !(rol1!=null && rol2!=null) ){
		response.sendRedirect("loginvista.jsp");
	}else if( !(rol1 && rol2) ){
		request.getSession().invalidate();
		response.sendRedirect("index2.jsp");
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
				<li><a href="principal.jsp">Inicio</a></li>
				<li><a href="#">Reserva</a>
<!-- 					<ul>
						<li><a href="#">A B M C</a>
							<ul>
								<li><a href="#">Alta</a></li>
								<li><a href="#">Reservas</a></li>
								
							</ul>
						</li>
						
					</ul> -->
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
								<li><a href="principalpersonas.html">Personas</a></li>
								
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
	 <form class="formulario" action="ServletPersonas">
    
	 <h1>Alta Persona</h1>
     <div class="contenedor">

        <div class="agrupainput">

        <div class="input-contenedor">
         <i class="fas fa-user icon"></i>
         <input type="text" name="txtnombre" placeholder="Nombre">
         
        </div>

        <div class="input-contenedor">
            <i class="fas fa-user icon"></i>
            <input type="text" name="txtapellido" placeholder="Apellido">
            
        </div>

        </div>

        <div class="agrupainput">
        <div class="input-contenedor">
            <i class="fas fa-home icon"></i>
            <input type="text" name="txtdireccion" placeholder="Direccion">
            
        </div>

        <div class="input-contenedor">
            <i class="fas fa-mobile icon"></i>
            <input type="text" name="txttelefono" placeholder="Telefono">
            
        </div>
        </div>

        <div class="agrupainput">
        <div class="input-contenedor">
            <i class="fas fa-id-card icon"></i>
            <input type="text" name="txtdni" placeholder="Dni">
            
        </div>
         
        <div class="input-contenedor">
         <i class="fas fa-envelope icon"></i>
         <input type="text" name="txtemail" placeholder="Correo Electronico">
         
        </div>
        </div>
        
		
        <div class="input-contrasena">
        <i class="fas fa-key icon"></i>
        <input type="password" name="txtpassword" placeholder="Contrasena"> 
         
        </div>
	

		
        

		<div class="sumaroles">
		<div class="rolunidad"><i class="fas fa-user icon"></i><label for="">Rol Admin</label><input type="checkbox" name="checkrol1"></div>		
		<div class="rolunidad"><i class="fas fa-user icon"></i><label for="">Rol Cliente</label><input type="checkbox" name="checkrol2"></div>
		</div>

		<div class="agrupabotones">
			<input type="submit" name="accion" value="Agregar" class="button">
			<input type="submit" name="accion" value="Cancelar" class="button" onclick=mostrarPrincipal()>
		</div>
		
     </div>
    </form>
	</div>

</body>
<script src="scripts/script.js"></script>
</html>