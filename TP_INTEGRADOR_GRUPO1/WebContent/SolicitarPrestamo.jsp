<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	<jsp:include page="css\Plantilla.css"></jsp:include>
</style>
<title>Solicitar Prestamo</title>
</head>
<body>

<jsp:include page="Encabezado.jsp" />  

 

<div class="parteDer">
   <h3 class="titulo"> Solicitar prestamo </h3> 

<form method="get" action="ServletCliente">


     <% if(request.getAttribute("PrestamoEnviado")!=null){
   		if(request.getAttribute("PrestamoEnviado").equals(true)){%>
   			<p class="alert alert-success" role="alert">Prestamo Solicitado Correctamente!</p>
   		<%} else {%>
   		<p class="alert alert-danger" role="alert">El Prestamo no pudo ser solicitado, intente nuevamente!</p>
   		<%}%>
   <%}%>





 <%
       
       String FechaActual ="";
       
       if(request.getAttribute("FechaActual")!=null){
    	   FechaActual = request.getAttribute("FechaActual").toString(); 
	    }
       
       int ProximoNroPrestamo =-1;
       if(request.getAttribute("ProxNroPrestamo")!=null){
    	   ProximoNroPrestamo = Integer.parseInt(request.getAttribute("ProxNroPrestamo").toString());
       }
       
       %>
   


<b>Numero de Prestamo: </b> <%= ProximoNroPrestamo %> <input type="hidden" name="NroPrestamo" value="<%= ProximoNroPrestamo %>"> <br>
<b>Fecha : </b> <%= FechaActual %> <br>
<b>Importe Solicitado :</b> <input type="number" required name="txtImporte"/> <br>
<b>N° de Cuenta en donde depositar:</b> <input type="number" required name="txtCuentaDepositar"/> <br>

<b>Cantidad de cuotas : </b><select  name="ddlCuotas">
                                   <option> 3 </option>
                                   <option> 6 </option>
                                   <option> 12 </option>
                                   <option> 18 </option>
                                   <option> 24 </option>
                            </select>

<br><br>
<input type="submit" name="btnSimularPrestamo" value="Simular Prestamo">

		   <%if(request.getAttribute("existe")!=null){
   		if(request.getAttribute("existe").equals(false)){%>
   			<p class="alert alert-danger" role="alert">El usuario es inexistente, intente nuevamente!</p>
   		<%}} %>

</form>





</div>

</body>
</html>