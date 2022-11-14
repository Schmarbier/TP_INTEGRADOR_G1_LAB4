<%@ page import="entidades.Genero"%>
<%@ page import="entidades.Nacionalidad"%>
<%@ page import="entidades.Provincia"%>
<%@ page import="entidades.Localidad"%>
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
<title>Modificación Clientes</title>
</head>
<body>

<jsp:include page="Encabezado.jsp" />  


<div class="parteDer">
   <h3 class="titulo"> Modificación Clientes </h3>

    <form method="post" action="ServletAdmin">
    
       <p>  Ingrese el usuario del cliente que desea modificar: <input type="text" required name="txtUsuarioModificar"></input>
	    <input type="submit" name="btnBuscarUsuario" value="Buscar Usuario"></input></p>
  
   </form>
	    
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
	            <th></th>
	        </tr>
	        
	    <%ArrayList<Cliente>ListaClienteTodos = null;
	    
	    if(request.getAttribute("ListaClientes")!=null){
	    	ListaClienteTodos = (ArrayList<Cliente>)request.getAttribute("ListaClientes"); 
	    }
	    
	    if(ListaClienteTodos!=null)
        	  for(Cliente CLI : ListaClienteTodos){
        %>
        
        <!-- CARGA LA LISTA CON TODOS LOS CLIENTES -->
        
    <tr>  
         <form action="ServletAdmin" method="post">
	     <td> <%=CLI.getNro_Cliente() %> </td>    
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
	     <td> <%=CLI.getUsuario()%> <input type="hidden" name="hiddenUsuario" value="<%=CLI.getUsuario()%>"> </td> 
	     <td> <%=CLI.getUsuario().getContraseña() %> </td> 
	     <td> <input type="submit" name="btnModificarCliente" value="Modificar"></input> </td>
	     </form>
	</tr>
	<% }

	    
	    ArrayList<Cliente> ClienteXuser = null;
	
	   if(request.getAttribute("CLIENTE")!=null){
		   ClienteXuser = (ArrayList<Cliente>) request.getAttribute("CLIENTE");
	   }
	   
	   if(ClienteXuser!=null)
		   for(Cliente C : ClienteXuser){
			
		%>	   
			 
			 
	<!-- CARGA LA LISTA SOLAMENTE CON EL/LOS USUARIOS BUSCADOS -->		 
    <tr>  
		 <form action="ServletAdmin" method="post">
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
	     <td> <%=C.getUsuario()%> <input type="hidden" name="hiddenUsuario" value="<%=C.getUsuario()%>"></td> 
	     <td> <%=C.getUsuario().getContraseña() %> </td>
	     <td> <input type="submit" name="btnModificarCliente" value="Modificar"></input> </td>  
	     </form> 
	</tr>	   
		<% }
	   
	   
	   
	   
	  ArrayList<Cliente> ClienteMODIFICAR = null;
	  if(request.getAttribute("ClienteModificar")!=null){
		  ClienteMODIFICAR = (ArrayList<Cliente>) request.getAttribute("ClienteModificar");
	  }
	  
	  if(ClienteMODIFICAR!=null)
		  for(Cliente CL : ClienteMODIFICAR){
			  
	%>
		
		
		<!-- CARGA LA LISTA CON EL CLIENTE A MODIFICAR -->
	<tr>  <form action="ServletAdmin" method="post">
	
	     <td> <input type="text" name="txtNroCliente" readonly value="<%=CL.getNro_Cliente() %>">  </td>    
	     <td> <input type="text" name="txtNombre" required pattern="[A-Za-zñÑ]+" title="Ingrese solo letras" value="<%=CL.getNombre() %>">  </td>
	     <td> <input type="text" name="txtApellido" required pattern="[A-Za-zñÑ]+" title="Ingrese solo letras" value="<%=CL.getApellido() %>"> </td> 
	     <td> <input type="number" name="txtDNI" required pattern = "[0-9]{8}" title="Ingrese un DNI valido" value="<%=CL.getDni() %>"> </td> 
	     <td> <input type="number" name="txtCUIL" required pattern = "[0-9]{11}" title="Ingrese un CUIL valido" value="<%=CL.getCuil() %>"> </td> 
	     <td> <input type="text" name="txtDireccion" required value="<%=CL.getDireccion() %>"> </td> 
	     <td> <input type="tel" name="txtTelefono" required title="Ingrese un numero telefonico valido" value="<%=CL.getTelefono() %>"> </td> 
	     <td> <input type="text" name="txtFechaNac" required pattern="\d{1,2}/\d{1,2}/\d{4}" title="La fecha no es valida" value="<%=CL.getFecha_nac() %>"> </td> 
	    
	     <td> <select name="ddlGenero">
	  		<% ArrayList <Genero> gList = null;
	           if(request.getAttribute("generos")!=null) gList=(ArrayList<Genero>)request.getAttribute("generos");
	           if(gList!=null)
	           for(Genero g : gList){ %>
				<option value="<%=g.getCod_genero()%>"><%=g.getDescripcion()%></option>
				<%}%>
			</select> </td> 
			
	     <td> <select name="ddlNacionalidad" >
	  		<% ArrayList <Nacionalidad> nList = null;
	           if(request.getAttribute("nacionalidades")!=null) nList=(ArrayList<Nacionalidad>)request.getAttribute("nacionalidades");
	           if(nList!=null)
	           for(Nacionalidad nac : nList){ %>
				<option value="<%=nac.getCod_nacionalidad()%>"><%=nac.getDescripcion()%></option>
				<%}%>
			</select> </td> 
			
	     <td> <select name="ddlProvincia" >
	  		<% ArrayList <Provincia> pList = null;
	           if(request.getAttribute("provincias")!=null) pList=(ArrayList<Provincia>)request.getAttribute("provincias");
	           if(pList!=null)
	           for(Provincia prov : pList){ %>
				<option value="<%=prov.getCod_provincia()%>"><%=prov.getDescripcion()%></option>
				<%}%>
			</select> </td> 
			
	     <td> <select name="ddlLocalidad" >
				<% ArrayList <Localidad> lList = null;
	               if(request.getAttribute("localidades")!=null) lList=(ArrayList<Localidad>)request.getAttribute("localidades");
	               if(lList!=null)
	               for(Localidad loc : lList){ %>
				    <option value="<%=loc.getCod_localidad()%>"><%= loc.getCod_provincia().getDescripcion()%> - <%=loc.getDescripcion()%></option>
				<%}%>
			</select>  </td> 
	     
	     <td> <input type="email" name="txtEmail" title="Ingrese un EMAIL valido" value="<%=CL.getEmail() %>"> </td> 
	     <td> <input type="text" name="txtUsuario" readonly value="<%=CL.getUsuario()%>"> </td> 
	     <td> <input type="text" name="txtContraseña" required value="<%=CL.getUsuario().getContraseña() %>"> </td>
	     <td> <input type="submit" name="btnModificarAceptar" value="Aceptar">
	          <input type="submit" name="btnModificarCancelar" value="Cancelar"> </td>   
	          </form>
	</tr>
		<%} %>
		
	</table>
	

</div>

</body>
</html>