<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entidades.Cliente"%>
<%@page import="negocioImp.ClienteNegocioImp"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="css\Plantilla.css"></jsp:include>
</style>
<title>Mis Datos</title>
</head>
<body>

<jsp:include page="Encabezado.jsp" />    

<div class="parteDer">
   <h3 class="titulo"> Mis Datos </h3> 
      <%   
		   Cliente cli = new Cliente();
		   cli = (Cliente)session.getAttribute("cliente");
           if(cli!=null)
           {
        	   %><h5>Nombre: <%=cli.getNombre()%></h5><%
          	   %><h5>Apellido: <%=cli.getApellido()%></h5><%
        	   %><h5><%=cli.toString()%></h5><%
           }
      %>
</div>

</body>
</html>