<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="..\css\Plantilla.css"></jsp:include>
</style>
<title>Baja Clientes</title>
</head>
<body>

<jsp:include page="../Encabezado.jsp" />  

<div class="parteDer">
   <h3 class="titulo"> Baja Clientes </h3> 

	<form method="post" action="ServletHTML">
	<p>  Ingrese el usuario del cliente que desea eliminar: <input type="text" required name="UsuarioEliminado"></input>
	     <input type="submit" name="btnEliminar" value="Eliminar Cliente"></input></p>
	</form>
   
</div>

</body>
</html>