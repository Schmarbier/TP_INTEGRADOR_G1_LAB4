<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="..\css\Plantilla.css"></jsp:include>
</style>
<title>Alta Cuentas</title>
</head>
<body>

<jsp:include page="../Encabezado.jsp" />  


<div class="parteDer">
   <h3 class="titulo"> Alta Cuenta </h3> 

<form method="post" action="ServletHTML">

	  <p>  Nro Cuenta:  1 </p>
      <p>  Nro Cliente: <input type="number" required name="Cliente"></input></p>
      <p>  Fecha de alta: </p>
      <p>  Tipo de cuenta: <select required name="ddlCuentas"></select></p>
	  <p>  Cbu: <input type="number"  required name="Cbu"></input></p>
	  <p>  Saldo inicial: $10.000</p>
	  <p>  <input type="submit" name="btnAsignar" value="Asignar Cuenta"></input></p>


</form>
   
</div>

</body>
</html>