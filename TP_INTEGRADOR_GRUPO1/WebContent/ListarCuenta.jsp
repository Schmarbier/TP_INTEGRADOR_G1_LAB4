<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Cuenta"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="css\Plantilla.css"></jsp:include>
</style>
<title>Listar Cuentas</title>
</head>
<body>

<jsp:include page="Encabezado.jsp" />  

<div class="parteDer">
   <h3 class="titulo"> Listar Cuenta </h3> 
<form method="post" action="ServletAdmin">
    	<p>  Buscar </p>
    	<select name="dllBusqueda">
		  <option value="todo">Todo</option>
		  <option value="Nro_cuenta">Numero de Cuenta</option>
		  <option value="Nro_cliente">Numero de cliente</option>
		  <option value="Fecha_creacion">Fecha de creacion</option>
		  <option value="Descripcion">Tipo de cuenta</option>
		  <option value="Cbu">CBU</option>
		  <option value="Saldo">Saldo</option>
		</select>
		<input type="text" name="txtFiltro"></input>
	    <input type="submit" name="btnBuscar" value="Buscar"></input>
	    <input type="submit" name="Param" value="Mostrar todo"></input>
</form>
	    <table border="1">
	    <thead>
		    <tr>
	            <th>Nro Cuenta</th>
	            <th>Nro Cliente</th>
	            <th>Fecha de creacion</th>
	            <th>Tipo de cuenta</th>
	            <th>Cbu</th>
	            <th>Saldo</th>
	        </tr>
	    </thead>
	    <tbody>

	    	<%  
				ArrayList<Cuenta> lista = null;
				
				if(request.getAttribute("cuentas")!=null)
				{
					lista = (ArrayList<Cuenta>) request.getAttribute("cuentas");
				}
	    		if(lista!=null){
					for(Cuenta c:lista) 
					{
						%>
					<tr>  
						<td><%=c.getNro_cuenta()%>     
						<td><%=c.getNro_cliente()%></td>   
						<td><%=c.getFecha_creacion().toString()%></td>
						<td><%=c.getTipo_cuenta().getDescripcion()%></td>   
						<td><%=c.getCbu() %></td>
						<td><%=c.getSaldo() %></td>
					</tr>
				<%  } 
				}
				%>
	    		
	    </tbody>

</table>



   
</div>

</body>
</html>