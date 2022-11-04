<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="..\css\Plantilla.css"></jsp:include>
</style>
<title>Listar Cuentas</title>
</head>
<body>

<jsp:include page="../Encabezado.jsp" />  

<div class="parteDer">
   <h3 class="titulo"> Listar Cuenta </h3> 

<form method="post" action="ServletHTML">
    	<p>  Buscar una cuenta en especifico: <input type="text" name="BuscarCuenta"></input>
	    <input type="submit" name="btnBuscar" value="Buscar"></input></p>
	    <p>  Filtrar por: <select name="ddlFiltro"></select>
	    <input type="submit" name="btnFiltrar" value="Filtrar"></input></p>
	    <table border="1">
	    <tr>
            <th>Nro Cuenta</th>
            <th>Nro Cuenta</th>
            <th>Fecha de creacion</th>
            <th>Tipo de cuenta</th>
            <th>Cbu</th>
            <th>Saldo</th>
        </tr>
	<tr>  
	     <td> 1 </td>    
	     <td> 1 </td>
	     <td> 20/08/2022 </td> 
	     <td> Corriente </td> 
	     <td> 12312412412412 </td> 
	     <td> 180.000,00 </td>   
	</tr>

</table>


</form>
   
</div>

</body>
</html>