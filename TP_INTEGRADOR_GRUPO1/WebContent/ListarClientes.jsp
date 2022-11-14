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
	    
	    
    
	    <table class="table" >
	    <tr>
             <th class="th">Nro Cliente</th>
	            <th class="th">Nombre</th>
	            <th class="th">Apellido</th>
	            <th class="th">Dni</th>
	            <th class="th">Cuil</th>
	            <th class="th">Direccion</th>
	            <th class="th">Telefono</th>
	            <th class="th">Fecha de nacimiento</th>
	            <th class="th">Genero</th>
	            <th class="th">Nacionalidad</th>
	            <th class="th">Provincia</th>
	            <th class="th">Localidad</th>
	            <th class="th">Email</th>
	            <th class="th">Usuario</th>
	            <th class="th">Contraseña</th>
        </tr>
	    <%ArrayList<Cliente>ListaCliente = null;
	    
	    if(request.getAttribute("ListaClientes")!=null){
	    	ListaCliente = (ArrayList<Cliente>)request.getAttribute("ListaClientes"); 
	    }
	    
	    if(ListaCliente!=null)
        	  for(Cliente CLI : ListaCliente){
        %>
        
    <tr class="tr">  
	     <td class="td" > <%=CLI.getNro_Cliente() %>  </td>    
	     <td class="td" > <%=CLI.getNombre() %>  </td>
	     <td class="td" > <%=CLI.getApellido() %> </td> 
	     <td class="td" > <%=CLI.getDni() %> </td> 
	     <td class="td" > <%=CLI.getCuil() %> </td> 
	     <td class="td" > <%=CLI.getDireccion() %> </td> 
	     <td class="td" > <%=CLI.getTelefono() %> </td> 
	     <td class="td" > <%=CLI.getFecha_nac() %> </td> 
	     <td class="td" > <%=CLI.getCod_Genero() %> </td> 
	     <td class="td" > <%=CLI.getCod_nacionalidad() %> </td> 
	     <td class="td" > <%=CLI.getCod_provincia() %> </td> 
	     <td class="td" > <%=CLI.getCod_localidad() %> </td> 
	     <td class="td" > <%=CLI.getEmail() %> </td> 
	     <td class="td" > <%=CLI.getUsuario()%> </td> 
	     <td class="td" > <%=CLI.getUsuario().getContraseña() %> </td>    
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