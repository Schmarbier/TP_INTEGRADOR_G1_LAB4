<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="..\css\Plantilla.css"></jsp:include>
</style>
<title>Simulacion de Prestamo</title>
</head>
<body>

<jsp:include page="../Encabezado.jsp" />  

 

<div class="parteDer">
   <h3 class="titulo"> Simulacion de prestamo </h3> 

<form method="post" action="PrestamosPendientes.jsp">

<b>Importe Total a pagar :</b> <br>	
<b>Cantidad de cuotas :</b> <br>
<b>Monto a pagar por mes :</b> <br>
<b>Dia de Vencimiento de cuota :</b> <br> <br>
	<input type="submit" name="btnSolicitar" value="Confirmar Prestamo">

</form>





   
</div>

</body>
</html>