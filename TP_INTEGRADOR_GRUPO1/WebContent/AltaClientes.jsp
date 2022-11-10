<%@ page import="entidades.Genero"%>
<%@ page import="entidades.Nacionalidad"%>
<%@ page import="entidades.Provincia"%>
<%@ page import="entidades.Localidad"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="css\Plantilla.css"></jsp:include>
</style>
<title>Alta Clientes</title>
</head>
<body>

<jsp:include page="Encabezado.jsp" />  

<div class="parteDer">
   <h3 class="titulo"> Alta Clientes </h3> 
   
<form method="get" action="ServletAgregarCliente">
      <%   int nroCli=0;
           if(request.getAttribute("ncli")!=null) nroCli = Integer.parseInt(request.getParameter("ncli").toString()); %>
	  <p>  Cliente nro:  <%= nroCli %> </p>
      <p>  Nombre:  <input type="text" name="nombre" placeholder="Ingrese un nombre"
           maxlength="30" required pattern="[A-Za-zñÑ]+" title="Ingrese solo letras" />
           Apellido: <input type="text" name="apellido" placeholder="Ingrese un apellido"
           maxlength="30" required pattern="[A-Za-zñÑ]+" title="Ingrese solo letras" />
      <p>  Dni: <input type="number" name="dni" placeholder="Ingrese un DNI"
           required pattern = "[0-9]{8}" title="Ingrese un DNI valido"/>
           Cuil:  <input type="number" name="cuil" placeholder="Ingrese un CUIL"
           required pattern = "[0-9]{11}" title="Ingrese un CUIL valido"/>
           
	  <p>  Género: 
	  		<select required name="genero" title="Seleccione un genero">
	  		<% ArrayList <Genero> gList = null;
	           if(request.getAttribute("generos")!=null) gList=(ArrayList<Genero>)request.getAttribute("generos");
	           if(gList!=null)
	           for(Genero g : gList){ %>
				<option value="<%=g.getCod_genero()%>"><%=g.getDescripcion()%></option>
				<%}%>
			</select> 
	       Nacionalidad: 
	  		<select required name="nacionalidad" title="Seleccione una nacionalidad">
	  		<% ArrayList <Nacionalidad> nList = null;
	           if(request.getAttribute("nacionalidades")!=null) nList=(ArrayList<Nacionalidad>)request.getAttribute("nacionalidades");
	           if(nList!=null)
	           for(Nacionalidad n : nList){ %>
				<option value="<%=n.getCod_nacionalidad()%>"><%=n.getDescripcion()%></option>
				<%}%>
			</select> 
           
	  <p>  Fecha de Nacimiento: <input type="text" name="fechaNacimiento" placeholder="dd/mm/aaaa" required pattern="\d{1,2}/\d{1,2}/\d{4}" title="La fecha no es v&aacute;lida"></input>

      <p>  Dirección:  <input type="text" name="direccion" placeholder="Ingrese una dirección"
           maxlength="50" required  />

	  <p>   Provincia: 
	  		<select required name="provincia" title="Seleccione una provincia">
	  		<% ArrayList <Provincia> pList = null;
	           if(request.getAttribute("provincias")!=null) pList=(ArrayList<Provincia>)request.getAttribute("provincias");
	           if(pList!=null)
	           for(Provincia p : pList){ %>
				<option value="<%=p.getCod_provincia()%>"><%=p.getDescripcion()%></option>
				<%}%>
			</select> 
			
	        Localidad: 
	  		<select required name="localidad" title="Seleccione una localidad">
				<% ArrayList <Localidad> lList = null;
	               if(request.getAttribute("localidades")!=null) lList=(ArrayList<Localidad>)request.getAttribute("localidades");
	               if(lList!=null)
	               for(Localidad l : lList){ %>
				    <option value="<%=l.getCod_localidad()%>"><%= l.getCod_provincia().getDescripcion()%> - <%=l.getDescripcion()%></option>
				<%}%>
			</select> 

           
      <p>  Email: <input type="email" required name="email" placeholder="Ingrese un EMAIL" title="Ingrese un EMAIL valido"></input></p>
      
           Teléfono: <input type="tel" required name="telefono" placeholder="Ingrese un numero telefonico" title="Ingrese un numero telefonico valido"></input></p>

      <p>  Usuario:  <input type="text" required name="usuario" placeholder="Usuario"
           maxlength="30" />

	  <p>  Contraseña: <input type="password" required name="contra" placeholder="Contraseña"></input></p>
	  <p>  Confirmar contraseña: <input type="password" required name="contra2" placeholder="Confirmar contraseña"></input></p>
      <p>  Reset: <input type="reset"></input></p>
	  <p>  <input type="submit" name="btnAgregar" value="Agregar Cliente"></input></p>
</form>

	<%  if(request.getAttribute("exito")!=null) {%> Cliente agregado con éxito <%}%>
	<%  if(request.getAttribute("error")!=null) {%> No se pudo agregar el cliente. Cliente ya existente <%}%>
	<%  if(request.getAttribute("errorContraseña")!=null) {%> Error. Las contraseñas no coinciden <%}%>

</div>

</body>
</html>