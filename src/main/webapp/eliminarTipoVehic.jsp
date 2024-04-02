<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" >
	<link rel="stylesheet" href="estilos/tipovehiculo.css">
</head>
<body>
	<form class="formulario">
    
		<h1>Eliminar Tipo Vehiculo</h1>
		 <div class="contenedor">
		 				  
			 <div class="input-contenedor">
			 <p style="font-size: larger;">Estas seguro de eliminar este registro ?</p>			
			 
			 </div>
								  
			 <div class="agrupabotones">
			    <%-- <input type="hidden" name="idVehic" value="<%=id%>"> --%>
				<input type="submit" name="accion" value="Eliminar" class="button">
				<input type="button" value="Cancelar" class="button" onclick=mostrarPrincPersonas()>
			</div>
			 
		 </div>
		</form>
</body>
<script src="scripts/script3.js"></script>
</html>