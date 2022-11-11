<head>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
	
	<!-- jQuery library -->
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
	
	<!-- Popper JS -->
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<div class="w-100">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <a class="navbar-brand" href="#">Banquito Fiel</a>
	  <ul class="navbar-nav w-100">
	  	<% String usu = (String) session.getAttribute("TipoUsurio");
	  	   if(session.getAttribute("TipoUsurio")=="admin") {
		%>
		   <li class="nav-item dropdown">
		      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Clientes</a>
		      <div class="dropdown-menu">
		        <a class="dropdown-item" href="ServletAdmin?Param=1">Alta cliente</a>
		        <a class="dropdown-item" href="BajaClientes.jsp">Baja cliente</a>
		        <a class="dropdown-item" href="ModifClientes.jsp">Modificacion cliente</a>
		        <a class="dropdown-item" href="Servlet_ML_cliente?ParamListar=1">Listado clientes</a>
		      </div>
		    </li>
		    <li class="nav-item dropdown">
		      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Cuentas</a>
		      <div class="dropdown-menu">
		        <a class="dropdown-item" href="AltaCuenta.jsp">Alta cuenta</a>
		        <a class="dropdown-item" href="BajaCuenta.jsp">Baja cuenta</a>
		        <a class="dropdown-item" href="ModifCuenta.jsp">Modificacion cuenta</a>
		        <a class="dropdown-item" href="ListarCuenta.jsp">Listado cuentas</a>
		      </div>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="Prestamos.jsp">Prestamos</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link" href="Reportes.jsp">Informes y/o Reportes</a>
		    </li>
		<% }
		   else {
		%>
		   <li class="nav-item dropdown">
		      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Cuentas</a>
		      <div class="dropdown-menu">
		        <a class="dropdown-item" href="Cuenta1.jsp">Cuenta 1</a>
		        <a class="dropdown-item" href="Cuenta2.jsp">Cuenta 2</a>
		        <a class="dropdown-item" href="Cuenta3.jsp">Cuenta 3</a>
		      </div>
		    </li>
		    <li class="nav-item dropdown">
		      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Prestamos</a>
		      <div class="dropdown-menu">
		        <a class="dropdown-item" href="SolicitarPrestamo.jsp">Solicitar prestamo</a>
		        <a class="dropdown-item" href="AbonarPrestamo.jsp">Abonar Prestamo</a>
		        <a class="dropdown-item" href="PrestamosPendientes.jsp">Prestamos Pendientes</a>
		        <a class="dropdown-item" href="PrestamosRechazados.jsp">Prestamos Rechazados</a>
		      </div>
		    </li>
		    <li class="nav-item">
		    	<a class="nav-link" href="../cliente/MisDatos.jsp">Datos personales</a>
		    </li>
		<% }
		%>
			<li class="mt-0 mr-0 mb-0 ml-auto d-flex align-items-center" style="gap: 1rem;">
				<span style="color: white;">Usuario <%=session.getAttribute("nombreUsurio")%></span>
				<a href="Login.jsp" class="btn btn-danger"> Cerrar sesion</a>
			</li>
	  </ul>
	</nav>
</div>
