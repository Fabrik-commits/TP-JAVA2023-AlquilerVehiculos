<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title></title> 
	<meta name="viewport" content="width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" >
	<link rel="stylesheet" href="estilos/estilosindex.css">
	
<%
/* 	Boolean rol2 = (Boolean)request.getSession().getAttribute("rol2");
	if( !(rol2!=null) ){			//!(rol1!=null && rol2!=null)	!( rol2)
	response.sendRedirect("index2.jsp");
	} */
	
%>	
<%-- <input type="text" placeholder="Cliente" name="cliente" value="<%=idPersona==null?"":per.getApellido() %>"> --%>
<%-- <%=rol2==null?"loginvista.jsp":principalcliente.jsp%>  --%>
<%-- <a href="Signin?accion=cerrarsesion"> --%>
</head>  
<body>
	
	<h1>Xtreme</h1>
	<h4>vehicles</h4>
	<p>Alquiler de autos micros utilitarios y camiones</p>
	<p style="color: red">ACCESO NO AUTORIZADO</p>
	<div class="contenedor">
	<!-- <a href="Signin?accion=cerrarsesion"> -->
	<%-- <a class="link" href="<%=!(rol2!=null)?"loginvista.jsp":"principalcliente.jsp"%>">Aceptar</a> --%>
	<a href="loginvista.jsp">Aceptar</a>
	</div>
	
</body>
</html>