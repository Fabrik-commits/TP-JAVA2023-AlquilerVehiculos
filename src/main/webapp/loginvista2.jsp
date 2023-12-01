<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" >
	<link rel="stylesheet" href="estilos/estilos.css">
</head>
<body>
	<form class="formulario" action="Signin" method="post">
    
    <h1>Login</h1>
     <div class="contenedor">
     
     
         
         <div class="input-contenedor">
         <i class="fas fa-envelope icon"></i>
         <input type="text" name="email" placeholder="Correo Electronico">
         
         </div>
         
         <div class="input-contenedor">
        <i class="fas fa-key icon"></i>
         <input type="password" name="password" placeholder="Contraseña">
         
         </div>
         <input type="submit" name="accion" value="Login2" class="button">
         <p style="color: red">Usuario y/o Clave incorrecta, vuelva a intentarlo</p>
         <p>¿No tienes una cuenta? <a class="link" href="registrarvista.jsp">Registrate </a></p>
     </div>
    </form>
</body>

</html>