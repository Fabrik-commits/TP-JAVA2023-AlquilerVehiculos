<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
 	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" >
	<link rel="stylesheet" href="estilos/estilosreg.css">
</head>
<body>
	 <form class="formulario">
    
	 <h1>Registrate</h1>
     <div class="contenedor">
     
        <div class="input-contenedor">
         <i class="fas fa-user icon"></i>
         <input type="text" placeholder="Nombre">
         
        </div>

        <div class="input-contenedor">
            <i class="fas fa-user icon"></i>
            <input type="text" placeholder="Apellido">
            
        </div>

        <div class="input-contenedor">
            <i class="fas fa-home icon"></i>
            <input type="text" placeholder="Direccion">
            
        </div>

        <div class="input-contenedor">
            <i class="fas fa-mobile icon"></i>
            <input type="text" placeholder="Telefono">
            
        </div>

        <div class="input-contenedor">
            <i class="fas fa-id-card icon"></i>
            <input type="text" placeholder="Dni">
            
        </div>
         
        <div class="input-contenedor">
         <i class="fas fa-envelope icon"></i>
         <input type="text" placeholder="Correo Electronico">
         
        </div>
         
         <div class="input-contenedor">
        <i class="fas fa-key icon"></i>
         <input type="password" placeholder="Contrase�a">
         
        </div>

         <input type="button" value="Registrate" class="button" onclick=mostrarPrincipal()>
         <p>Al registrarte, aceptas nuestras Condiciones de uso y Pol�tica de privacidad.</p>
         <p>�Ya tienes una cuenta?<a class="link" href="loginvista.jsp">Iniciar Sesion</a></p>
     </div>
    </form>
</body>
<script src="scripts/script.js"></script>
</html>