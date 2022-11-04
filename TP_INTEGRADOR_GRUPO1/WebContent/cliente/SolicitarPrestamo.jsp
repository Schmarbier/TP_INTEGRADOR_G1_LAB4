<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="..\css\Plantilla.css"></jsp:include>
</style>
<title>Solicitar Prestamo</title>
</head>
<body>

<jsp:include page="../Encabezado.jsp" />  

 

<div class="parteDer">
   <h3 class="titulo"> Solicitar prestamo </h3> 

<form method="post" action="SimulacionPrestamo.jsp">

<b>Numero de Prestamo: </b> 1 <br>
<b>Fecha : </b>3/11/2022 <br>
<b>Importe Solicitado :</b> <input type="number" name="txtImporte"/> <br>
<b>N° de Cuenta en donde depositar:</b> <input type="number" name="txtCuentaDepositar"/> <br>
<b>Cantidad de cuotas : </b><select  name="ddlCuotas"></select> <br><br>
<input type="submit" name="btnSimular" value="Simular Prestamo">

</form>

</div>

</body>
</html>