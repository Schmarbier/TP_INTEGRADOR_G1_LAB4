<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="css\Plantilla.css"></jsp:include>
</style>
<title>Baja Cuentas</title>
</head>
<body>

<jsp:include page="Encabezado.jsp" />  

<div class="parteDer">
   <h3 class="titulo"> Baja Cuenta </h3> 

<form method="post" action="ServletHTML">

<p>  Ingrese el numero de cuenta que desea eliminar: <input type="number" required name="CuentaEliminada"></input>
	     <input type="submit" name="btnEliminarCuenta" value="Eliminar Cuenta"></input></p>


</form>
   
</div>

</body>
</html>