<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="..\css\Plantilla.css"></jsp:include>
</style>
<title>Abonar Prestamo</title>
</head>
<body>

<jsp:include page="../Encabezado.jsp" />  


<div class="parteDer">
   <h3 class="titulo"> Abonar prestamo </h3> 

<form method="post" action="ServletHTML">
<br>

<table border="1">
     <tr>
         <th> N° de Prestamo </th>
         <th> N° de Cuota </th>
         <th> Monto a pagar </th>
         <th> Fecha de vencimiento </th>
     </tr>
     
     <tr>
         <td> 3 </td>
         <td> 1 </td>
         <td> 1.000 </td>
         <td> 11/07/2023 </td>
         <td><input type="submit" name="btnPagar" value="Pagar cuota" /></td>
     </tr>

</table>

</form>
   
</div>

</body>
</html>