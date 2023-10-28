let obtenerDato = document.getElementsByTagName("td");

console.log(obtenerDato[6].innerHTML);
  	
console.log(obtenerDato[7].innerHTML);

function mostrarPrincipal(){
    window.location="principal.jsp";
}

function mostrarPrincipalTiposVehic(){
    window.location="principaltiposvehic.jsp";
}

function mostrarroles()
{
	var img=document.getElementById("img")
	if("true")
	{
		img.style.visibility="visible";
	}
	else
	{
		img.style.visibility="hidden";
	}
}

function obtener()
{
	let obtenerDato = document.getElementsByTagName("td");

  	console.log(obtenerDato[6].innerHTML);
  	
  	console.log(obtenerDato[7].innerHTML);
  	
}