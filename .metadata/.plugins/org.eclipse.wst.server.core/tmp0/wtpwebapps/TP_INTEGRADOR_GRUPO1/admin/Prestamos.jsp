<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="..\css\Plantilla.css"></jsp:include>
</style>
<title>Prestamos</title>
</head>
<body>

<jsp:include page="../Encabezado.jsp" />  

<div class="parteDer">
   <h3 class="titulo"> Prestamos </h3> 

<form method="post" action="ServletHTML">
	    <p>  Filtrar por: <select name="ddlFiltro"></select>
	    <input type="submit" name="btnFiltrar" value="Filtrar"></input></p>
	    <table border="1">
	    <tr>
            <th>Nro Prestamo</th>
            <th>Nro Cliente</th>
            <th>Fecha de solicitud</th>
            <th>Importe solicitado</th>
            <th>Importe solicitado (con intereses)</th>
            <th>Nro de cuenta a depositar</th>
            <th>Plazo de pago (meses)</th>
            <th>Monto de pago (por mes)</th>
            <th>Cantidad de cuotas</th>
            <th>Fecha de vencimiento de cuota</th>
        </tr>
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
	     <td> <input type="submit" name="btnAceptarSolicitud" value="Aceptar"></input> </td>
	     <td> <input type="submit" name="btnRechazaSolicitud" value="Rechazar"></input> </td>
	</tr>
</table>

</form>
   
</div>

</body>
</html>