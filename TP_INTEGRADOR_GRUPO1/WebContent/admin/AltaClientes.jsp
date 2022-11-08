<%@ page import="entidades.Genero"%>
<%@ page import="entidades.Nacionalidad"%>
<%@ page import="entidades.Provincia"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="..\css\Plantilla.css"></jsp:include>
</style>
<title>Alta Clientes</title>
</head>
<body>

<jsp:include page="../Encabezado.jsp" />  

<div class="parteDer">
   <h3 class="titulo"> Alta Clientes </h3> 

<form method="get" action="ServletAgregarCliente">
      <%   int nroCli=0;
           if(request.getAttribute("ncli")!=null) nroCli = (int) request.getAttribute("ncli"); %>
	  <p>  Cliente nro:  <%= nroCli++ %> </p>
      <p>  Nombre:  <input type="text" name="nombre" placeholder="nombre"
           maxlength="30" required pattern="[A-Za-zñÑ]+" />
           Apellido: <input type="text" name="apellido" placeholder="apellido"
           maxlength="30" required pattern="[A-Za-zñÑ]+" />
      <p>  Dni: <input type="number" name="dni" placeholder="DNI"
           maxlength="8" required/>
           Cuil:  <input type="number" name="cuil" placeholder="CUIL"
           maxlength="11" required/>
           
	  <p>  Género: 
	  		<select name="genero">
	  		<% ArrayList <Genero> gList = null;
	           if(request.getAttribute("generos")!=null) gList=(ArrayList<Genero>)request.getAttribute("generos");
	           if(gList!=null)
	           for(Genero g : gList){ %>
				<option value="<%=g.getCod_genero()%>"><%=g.getDescripcion()%></option>
				<%}%>
			</select> 
	       Nacionalidad: 
	  		<select name="nacionalidad">
	  		<% ArrayList <Nacionalidad> nList = null;
	           if(request.getAttribute("nacionalidades")!=null) nList=(ArrayList<Nacionalidad>)request.getAttribute("nacionalidades");
	           if(nList!=null)
	           for(Nacionalidad n : nList){ %>
				<option value="<%=n.getCod_nacionalidad()%>"><%=n.getDescripcion()%></option>
				<%}%>
			</select> 
           
	  <p>  Fecha de Nacimiento: <input type="date" name="fechaNacimiento"></input>

      <p>  Dirección:  <input type="text" name="direccion" placeholder="Dirección"
           maxlength="50" required pattern="[A-Za-zñÑ0-9]+" />

	  <p>  Localidad: 
	  		<select name="localidad">
				<option value="01">CABA</option>
				<option value="02">Buenos Aires</option>
				<option value="03">Merlo</option>
				<option value="04">Bariloche</option>
			</select> 

	       Provincia: 
	  		<select name="provincia">
	  		<% ArrayList <Provincia> pList = null;
	           if(request.getAttribute("provincias")!=null) pList=(ArrayList<Provincia>)request.getAttribute("provincias");
	           if(nList!=null)
	           for(Provincia n : pList){ %>
				<option value="<%=n.getCod_provincia()%>"><%=n.getDescripcion()%></option>
				<%}%>
			</select> 
           
      <p>  Email: <input type="email" name="email"></input></p>
      
           Teléfono: <input type="tel" name="telefono"></input></p>

      <p>  Usuario:  <input type="text" name="nombre" placeholder="Usuario"
           maxlength="30" required pattern="[A-Za-zñÑ]+" />

	  <p>  Contraseña: <input type="password" required name="contraseña"></input></p>
	  <p>  Confirmar contraseña: <input type="password" required name="ContraseñaRe"></input></p>
      <p>  Reset: <input type="reset"></input></p>
	  <p>  <input type="submit" name="btnAgregar" value="Agregar Cliente"></input></p>
</form>
   
<%
	boolean agregado = false;
	if(request.getAttribute("exito")!=null)
		agregado = (boolean)request.getAttribute("exito");	
%>
<%  if(agregado==true) {%> Cliente agregado con éxito <%}

    else {%> Error. No se pudo agregar el cliente<%}%>

</div>

</body>
</html>