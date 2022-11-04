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

<form method="post" action="ServletHTML">

	  <p>  Nro Cliente:  1 </p>
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
				<option value="F">Femenino</option>
				<option value="M">Masculino</option>
				<option value="X">Otros</option>
			</select> 
           
	       Nacionalidad: 
	  		<select name="nacionalidad">
				<option value="01">Argentina</option>
				<option value="02">Chile</option>
				<option value="03">Uruguay</option>
				<option value="04">Brasil</option>
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
				<option value="01">Buenos Aires</option>
				<option value="02">San Luis</option>
				<option value="03">Rio Negro</option>
				<option value="04">Cordoba</option>
			</select> 
           
      <p>  Email: <input type="email" name="email"></input></p>
      
           Teléfono: <input type="tel" name="telefono"></input></p>

      <p>  Usuario:  <input type="text" name="nombre" placeholder="Usuario"
           maxlength="30" required pattern="[A-Za-zñÑ]+" />

	  <p>  Contraseña: <input type="password" required name="Contraseña"></input></p>
	  <p>  Confirmar contraseña: <input type="password" required name="ContraseñaRe"></input></p>
      <p>  Reset: <input type="reset"></input></p>
	  <p>  <input type="submit" name="btnAgregar" value="Agregar Cliente"></input></p>
</form>
   
</div>

</body>
</html>