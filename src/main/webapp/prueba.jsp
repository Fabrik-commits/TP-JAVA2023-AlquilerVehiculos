<%@page import="entities.Vehiculo"%>
<%@page import="logic.VehiculoLogic"%>
<%@page import="logic.PersonaLogic"%>
<%@page import="entities.Persona"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entities.TipoVehiculo"%>
<%@page import="logic.TipoVehiculoLogic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	     Ingrese opcion elegida:
        <input list="suggestionList" id="answerInput">
        <datalist id="suggestionList">
        <% 
			TipoVehiculoLogic tvl = new TipoVehiculoLogic();
			LinkedList<TipoVehiculo> listtv = tvl.getAllTiposVehiculo();
			for (TipoVehiculo tve : listtv) {
						
		%>
            <option data-value="<%=tve.getId()%>"><%=tve.getDescripcion()%></option>

        <% } %>    
        </datalist>
        <input type="hidden" name="answer" id="answerInput-hidden">
</body>
</html>