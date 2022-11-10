<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="css\Plantilla.css"></jsp:include>
</style>
<title>Listado Clientes</title>
</head>
<body>

<jsp:include page="Encabezado.jsp" />  

<div class="parteDer">
   <h3 class="titulo"> Listado Clientes </h3> 

<form method="post" action="ServletHTML">
    	<p>  Buscar usuario en especifico: <input type="text" name="BuscarUsuario"></input>
	    <input type="submit" name="btnBuscar" value="Buscar"></input></p>
	    <p>  Filtrar por: <select name="ddlFiltro"></select>
	    <input type="submit" name="btnFiltrar" value="Filtrar"></input></p>
	    <table border="1">
	    <tr>
            <th>Nro Cliente</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Dni</th>
            <th>Cuil</th>
            <th>Direccion</th>
            <th>Telefono</th>
            <th>Fecha de nacimiento</th>
            <th>Genero</th>
            <th>Nacionalidad</th>
            <th>Provincia</th>
            <th>Localidad</th>
            <th>Email</th>
            <th>Usuario</th>
            <th>Contraseña</th>
        </tr>
	<tr>  
	     <td> 1 </td>    
	     <td> Juan </td>
	     <td> Marquez </td> 
	     <td> 43520065 </td> 
	     <td> 20435200649 </td> 
	     <td> Uruguay 865 </td> 
	     <td> 1137845392 </td> 
	     <td> 11/07/2001 </td> 
	     <td> Masculino </td> 
	     <td> Argentino </td> 
	     <td> Buenos Aires </td> 
	     <td> Tigre </td> 
	     <td> juanmarquez123@gmail.com.ar </td> 
	     <td> Juancete </td> 
	     <td> bokita123 </td>    
	</tr>

</table>

</form>
   
</div>

</body>
</html>