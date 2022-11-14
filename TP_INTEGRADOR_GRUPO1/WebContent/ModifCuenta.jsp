<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Cuenta"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<!-- data table -->
	<link rel="stylesheet" href="//cdn.datatables.net/1.13.1/css/jquery.dataTables.min.css">
	
	<!-- js data table -->
	<script src="//cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
	
<style type="text/css">
	<jsp:include page="css\Plantilla.css"></jsp:include>
</style>
<title>Modificar Cuentas</title>
</head>
<body>

<jsp:include page="Encabezado.jsp" />  

<div class="parteDer">
   <h3 class="titulo"> Modificar Cuenta </h3> 
 <% if(request.getAttribute("ModificarCuenta")!=null){%>
<form method="post" action="ServletAdmin">
	<table border="1">
		    <thead>
			    <tr>
		            <th>Nro Cuenta</th>
		            <th>Nro Cliente</th>
		            <th>Fecha de creacion</th>
		            <th>Tipo de cuenta</th>
		            <th>Cbu</th>
		            <th>Saldos</th>
		        </tr>
		    </thead>
		    <tbody>
	
		    	<%  
					ArrayList<Cuenta>  cuentaMod = null;
					
					if(request.getAttribute("ModificarCuenta")!=null)
					{
						cuentaMod = (ArrayList<Cuenta>) request.getAttribute("ModificarCuenta");
					}
		    		if(cuentaMod!=null){
						for(Cuenta c:cuentaMod) 
						{
							%>
						<tr>  
							<td><input type="text" name="nroCuentaM" readonly value="<%=c.getNro_cuenta()%>"></td>    
							<td><input type="text" required name="nroClienteM" value="<%=c.getNro_cliente()%>"></td>   
							<td><input type="text" required name="fechaCreacionM" value="<%=c.getFecha_creacion().toString()%>"></td>
							<td>
								<%if(c.getTipo_cuenta().getTipo_cuenta() == 1){%>
									<select name="ddlTipoCuenta">
									  <option value="1" selected>Caja de ahorro</option>
									  <option value="2">Cuenta Corriente</option>
									</select>
								<%}else{%>
									<select name="ddlTipoCuenta">
									  <option value="1">Caja de ahorro</option>
									  <option value="2" selected>Cuenta Corriente</option>
									</select>
								<%}%>
							</td>   
							<td><input name="cbuM" required value="<%=c.getCbu()%>"></td>
							<td><input name="saldoM" required value="<%=c.getSaldo()%>"></td>
						</tr>
					<%  } 
					}
					%>
		    		
		    </tbody>
	
	</table>
	<input type="submit" name="AceptarModificar" value="Aceptar">
	<input type="submit" name="RechazarModificar" value="Rechazar">
</form>
<%}%>
<% if(request.getAttribute("ModCuentas")!=null){%>
<form method="post" action="ServletAdmin">
    	<p>Buscar en: </p>
    	<select name="dllBusqueda">
		  <option value="todo">todo</option>
		  <option value="Nro_cuenta">Numero de Cuenta</option>
		  <option value="Nro_cliente">Numero de cliente</option>
		  <option value="Fecha_creacion">Fecha de creacion</option>
		  <option value="Descripcion">Tipo de cuenta</option>
		  <option value="Cbu">CBU</option>
		  <option value="Saldo">Saldo</option>
		</select>
		<input type="text" name="txtFiltro">
	    <input type="submit" name="btnModBuscar" value="Buscar">
	    <input type="submit" name="modCuenta" value="Mostrar todo">
</form>
	    <table border="1" id="mytable">
		    <thead>
			    <tr>
		            <th>Nro Cuenta</th>
		            <th>Nro Cliente</th>
		            <th>Fecha de creacion</th>
		            <th>Tipo de cuenta</th>
		            <th>Cbu</th>
		            <th>Saldo</th>
		            <th></th>
		        </tr>
		    </thead>
		    <tbody>
	
		    	<%  
					ArrayList<Cuenta> lista = null;
					
					if(request.getAttribute("ModCuentas")!=null)
					{
						lista = (ArrayList<Cuenta>) request.getAttribute("ModCuentas");
					}
		    		if(lista!=null){
						for(Cuenta c:lista) 
						{
							%>
						<tr>  
							<form action="ServletAdmin" method="post">
								<td><%=c.getNro_cuenta()%><input type="hidden" name="nroCuenta" value="<%=c.getNro_cuenta()%>"></td>    
								<td><%=c.getNro_cliente()%><input type="hidden" name="nroCliente" value="<%=c.getNro_cliente()%>"></td>   
								<td><%=c.getFecha_creacion()%><input type="hidden" name="fechaCreacion" value="<%=c.getFecha_creacion()%>"></td>
								<td><%=c.getTipo_cuenta().getDescripcion()%><input type="hidden" name="tipoCuenta" value="<%=c.getTipo_cuenta().getDescripcion()%>"></td>   
								<td><%=c.getCbu()%><input type="hidden" name="cbu" value="<%=c.getCbu()%>"></td>
								<td><%=c.getSaldo()%><input type="hidden" name="saldo" value="<%=c.getSaldo()%>"></td>
								<td><input type="submit" name="btnModificarCuenta" value="Modificar Cuenta"></input></td>
							</form>
						</tr>
					<%  } 
					}
					%>
		    </tbody>
	</table>
	<%}%>
</div>
</body>
</html>