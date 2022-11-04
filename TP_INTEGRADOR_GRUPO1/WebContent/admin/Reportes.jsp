<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="..\css\Plantilla.css"></jsp:include>
</style>
<title>Reportes</title>
</head>
<body>

<jsp:include page="../Encabezado.jsp" />  

<div class="parteDer">
   <h3 class="titulo"> Reportes </h3> 

<form method="post" action="ServletHTML">
<div>
<span>Prestamos dados desde </span><input type="date" /><span> Hasta </span><input type="date" />
<table class="table">
  <thead>
    <tr>
            <th scope="col">Nro Prestamo</th>
            <th scope="col">Nro Cliente</th>
            <th scope="col">Fecha de solicitud</th>
            <th scope="col">Importe solicitado</th>
            <th scope="col">Importe solicitado (con intereses)</th>
            <th scope="col">Nro de cuenta a depositar</th>
            <th scope="col">Plazo de pago (meses)</th>
            <th scope="col">Monto de pago (por mes)</th>
            <th scope="col">Cantidad de cuotas</th>
            <th scope="col">Fecha de vencimiento de cuota</th>
    </tr>
  </thead>
  <tbody>
    <tr>
         <td> 1 </td>    
	     <td> 1 </td>
	     <td> 20/08/2022 </td> 
	     <td> 10.000 </td> 
	     <td> 12.000 </td> 
	     <td> 1 </td> 
	     <td> 12 </td>
	     <td> 1000 </td> 
	     <td> 12 </td>  
	     <td> 20/08 </td> 
    </tr>
    <tr>
  </tbody>
</table>
<br>
<span>Cantidad de movimientos hechos desde: </span><input type="date" /><span> Hasta: </span><input type="date" />
<table class="table">
  <thead>
    <tr>
      <th scope="col">Fecha</th>
      <th scope="col">Tipo de movimiento</th>
      <th scope="col">Detalle</th>
      <th scope="col">Importe</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">19/08/2022</th>
      <td>Transferencia</td>
      <td>Se realizo la tranferencia de 30mil pesos a la cuenta nº 12312412</td>
      <td>$30.000</td>
    </tr>
    <tr>
  </tbody>
</table>
<br>
<br>
<span>Dinero total depositado en el banco actualmente: <b>$28.392.122</b></span>
</div>

</form>
   
</div>

</body>
</html>