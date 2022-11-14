<%@page import="java.util.ArrayList"%>
<%@page import=" entidades.Cliente"%>

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


<form method="post" action="ServletAdmin">

<form method="get" action="Servlet_ML_cliente">


         <form method="get" action="Servlet_ML_cliente">
    	<p>  Buscar usuario en especifico: <input type="text" required name="txtBuscarUsuario"></input>
	    <input type="submit" name="btnBuscarUser" value="Buscar"></input></p>
	    </form>
	    
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
	    <%ArrayList<Cliente>ListaCliente = null;
	    
	    if(request.getAttribute("ListaClientes")!=null){
	    	ListaCliente = (ArrayList<Cliente>)request.getAttribute("ListaClientes"); 
	    }
	    
	    if(ListaCliente!=null)
        	  for(Cliente CLI : ListaCliente){
        %>
        
    <tr>  
	     <td> <%=CLI.getNro_Cliente() %>  </td>    
	     <td> <%=CLI.getNombre() %>  </td>
	     <td> <%=CLI.getApellido() %> </td> 
	     <td> <%=CLI.getDni() %> </td> 
	     <td> <%=CLI.getCuil() %> </td> 
	     <td> <%=CLI.getDireccion() %> </td> 
	     <td> <%=CLI.getTelefono() %> </td> 
	     <td> <%=CLI.getFecha_nac() %> </td> 
	     <td> <%=CLI.getCod_Genero() %> </td> 
	     <td> <%=CLI.getCod_nacionalidad() %> </td> 
	     <td> <%=CLI.getCod_provincia() %> </td> 
	     <td> <%=CLI.getCod_localidad() %> </td> 
	     <td> <%=CLI.getEmail() %> </td> 
	     <td> <%=CLI.getUsuario()%> </td> 
	     <td> <%=CLI.getUsuario().getContraseña() %> </td>    
	</tr>
	<% } 
	     
	ArrayList<Cliente> ClienteXuser = null;
	
	   if(request.getAttribute("CLIENTE")!=null){
		   ClienteXuser = (ArrayList<Cliente>) request.getAttribute("CLIENTE");
	   }
	   
	   if(ClienteXuser!=null)
		   for(Cliente C : ClienteXuser){
			
		%>	   
			 
		 <tr>  
	     <td> <%=C.getNro_Cliente() %>  </td>    
	     <td> <%=C.getNombre() %>  </td>
	     <td> <%=C.getApellido() %> </td> 
	     <td> <%=C.getDni() %> </td> 
	     <td> <%=C.getCuil() %> </td> 
	     <td> <%=C.getDireccion() %> </td> 
	     <td> <%=C.getTelefono() %> </td> 
	     <td> <%=C.getFecha_nac() %> </td> 
	     <td> <%=C.getCod_Genero() %> </td> 
	     <td> <%=C.getCod_nacionalidad() %> </td> 
	     <td> <%=C.getCod_provincia() %> </td> 
	     <td> <%=C.getCod_localidad() %> </td> 
	     <td> <%=C.getEmail() %> </td> 
	     <td> <%=C.getUsuario()%> </td> 
	     <td> <%=C.getUsuario().getContraseña() %> </td>    
	</tr>	   
			   
		<% }%>
	
	

</table>

</form>
   
</div>

</body>
</html>