<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="css\Plantilla.css"></jsp:include>
</style>
<title>Cuenta 1</title>
</head>
<body>

<jsp:include page="Encabezado.jsp" />  


<div class="container-sm border">
	<div class="row mt-3">
		<div class="col m-5 d-flex flex-column">
			<p class="h3 text-center mb-4">Informacion de la cuenta</p>
			<div class="input-group mb-3">
			  <div class="input-group-prepend">
			    <span class="input-group-text" id="basic-addon1">CBU</span>
			  </div>
			  <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
			</div>
			<div class="input-group mb-3">
			  <div class="input-group-prepend">
			    <span class="input-group-text" id="basic-addon1">Saldo</span>
			  </div>
			  <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
			</div>
			<div class="input-group mb-3">
			  <div class="input-group-prepend">
			    <span class="input-group-text" id="basic-addon1">Tipo de cuenta</span>
			  </div>
			  <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
			</div>
			<div class="input-group mb-3">
			  <div class="input-group-prepend">
			    <span class="input-group-text" id="basic-addon1">Fecha de creacion</span>
			  </div>
			  <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
			</div>
			<button type="button" class="btn btn-primary btn btn-block">Transferir dinero</button>
		</div>
		<div class="col m-5">
			<p class="h3 text-center mb-4">Movimientos</p>
		</div>
	</div>
</div>


<div class="parteDer">
   <h3 class="titulo"> Cuenta 1 </h3> 

<form method="post" action="TransferirDinero.jsp">

<b> Numero de cuenta </b> : 123 <br>
<b> Tipo de cuenta </b> : Corriente <br>
<b> Dinero Disponible </b>: $ 13.256,59 <br>
<b> CBU </b>: 0112600985066500112001450 <br>
<b> Alias </b> : CONEJO.AVE.MESA <br><br>

<b> <big> ¿Desea realizar una transferencia? </big> </b><br>
<input type="submit" name="btnTransferir" value="Transferir Dinero" />
<br><br>

<h3 class="titulo"> Movimientos </h3><br><br>

<table border ="1" >
<tr>
    <th> N° de Movimiento</th>
    <th> Fecha </th>
    <th> Tipo de movimiento </th>
    <th> Importe </th>
    <th> Descripcion </th>
</tr>

<tr> 
    <td> 1 </td>
    <td> 2/11/2021 </td>
    <td> Pago de prestamo </td>
    <td> $10.000 </td>
    <td> Se realizo el pago del mes 3 del prestamo 1230 </td>
</tr>
</table>


</form>
   
</div>

</body>
</html>