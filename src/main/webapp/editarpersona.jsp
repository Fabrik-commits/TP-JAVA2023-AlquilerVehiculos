<%@page import="logic.PersonaLogic"%>
<%@page import="entities.Persona"%>
<%@page import="entities.Rol"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
 	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" >
	<link rel="stylesheet" href="estilos/estilosalta.css">
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
	 <%
		PersonaLogic perslog = new PersonaLogic();
		int id = Integer.parseInt((String)request.getAttribute("id"));
		//int idd = 1;		
		Persona pers = perslog.getById(id); //dao.list(id);
		Rol rol1 = new Rol();
		Rol rol2 = new Rol();
		rol1.setId(1);
		rol2.setId(2);
	%>
	 <form class="formulario" action="ServletPersonas">
    
	 <h1>Editar Persona</h1>
     <div class="contenedor">

        <div class="agrupainput">

        <div class="input-contenedor">
         <i class="fas fa-user icon"></i>
         <input type="text" name="txtnombre" value="<%=pers.getNombre()%>" placeholder="Nombre">
         
        </div>

        <div class="input-contenedor">
            <i class="fas fa-user icon"></i>
            <input type="text" name="txtapellido" value="<%=pers.getApellido()%>" placeholder="Apellido">
            
        </div>

        </div>

        <div class="agrupainput">
        <div class="input-contenedor">
            <i class="fas fa-home icon"></i>
            <input type="text" name="txtdireccion" value="<%=pers.getDireccion()%>" placeholder="Direccion">
            
        </div>

        <div class="input-contenedor">
            <i class="fas fa-mobile icon"></i>
            <input type="text" name="txttelefono" value="<%=pers.getTel()%>" placeholder="Telefono">
            
        </div>
        </div>

        <div class="agrupainput">
        <div class="input-contenedor">
            <i class="fas fa-id-card icon"></i>
            <input type="text" name="txtdni" value="<%=pers.getDni()%>" placeholder="Dni">
            
        </div>
         
        <div class="input-contenedor">
         <i class="fas fa-envelope icon"></i>
         <input type="text" name="txtemail" value="<%=pers.getEmail()%>" placeholder="Correo Electronico">
         
        </div>
        </div>
        
		
        <div class="input-contrasena">
        <i class="fas fa-key icon"></i>
        <input type="text" name="txtpassword" value="<%=pers.getPassword()%>" placeholder="Contrasena"> 
         
        </div>
	        

		<div class="sumaroles">
		<div class="rolunidad"><i class="fas fa-user icon"></i><label for="">Rol Admin</label><input type="checkbox" name="checkrol1" <%=pers.hasRol(rol1)?"checked":""%>></div>		
		<div class="rolunidad"><i class="fas fa-user icon"></i><label for="">Rol Cliente</label><input type="checkbox" name="checkrol2" <%=pers.hasRol(rol2)?"checked":""%>></div>
		</div>
		
		<div><input type="hidden" name="txtid" value="<%= pers.getId()%>"></div>

		<div class="agrupabotones">
			<input type="submit" name="accion" value="Actualizar" class="button">
			<input type="submit" name="accion" value="Cancelar" class="button" onclick=mostrarPrincipal()>
		</div>
		
     </div>
    </form>
	</div>

</body>
</html>