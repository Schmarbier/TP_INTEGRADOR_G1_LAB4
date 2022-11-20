package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImp.CuentaDaoImp;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.EstadosPrestamo;
import entidades.Genero;
import entidades.Localidad;
import entidades.Movimiento;
import entidades.Nacionalidad;
import entidades.Prestamo;
import entidades.Provincia;
import entidades.TipoCuenta;
import entidades.TipoUsuario;
import entidades.Usuario;
import negocioImp.ClienteNegocioImp;
import negocioImp.CuentaNegocioImp;
import negocioImp.GeneroNegocioImp;
import negocioImp.LocalidadNegocioImp;
import negocioImp.MovimientoNegocioImp;
import negocioImp.NacionalidadNegocioImp;
import negocioImp.PrestamoNegocioImp;
import negocioImp.ProvinciaNegocioImp;
import negocioImp.UsuarioNegocioImp;


@WebServlet("/ServletAdmin")
public class ServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletAdmin() {
        super();
    }
    
    ClienteNegocioImp cneg = new ClienteNegocioImp();
	CuentaDaoImp cuneg = new CuentaDaoImp();
	CuentaNegocioImp neg = new CuentaNegocioImp();
	UsuarioNegocioImp uneg = new UsuarioNegocioImp();
	PrestamoNegocioImp pneg = new PrestamoNegocioImp();
	MovimientoNegocioImp mneg = new MovimientoNegocioImp();
	Cliente c = new Cliente();
	Usuario u = new Usuario();
	Genero g = new Genero();
	Nacionalidad n = new Nacionalidad();
	Provincia p = new Provincia();
	Localidad l = new Localidad();
	Prestamo pres = new Prestamo();
	EstadosPrestamo ep = new EstadosPrestamo();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("LReportes")!=null) {
			ArrayList<Prestamo> ListaPrestamos = (ArrayList<Prestamo>) pneg.readAll();
		    ArrayList<Movimiento> ListaMovimientos = (ArrayList<Movimiento>) mneg.readAll();
		    request.setAttribute("movimientos", ListaMovimientos);
		    request.setAttribute("prestamos", ListaPrestamos);
		    RequestDispatcher rd = request.getRequestDispatcher("/Reportes.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("LPrestamos")!=null) {
			ep.setEst_prestamo(3);
			pres.setEst_prestamo(ep);
		    ArrayList<Prestamo> ListaPrestamos = (ArrayList<Prestamo>) pneg.Prestamos(pres);
			request.setAttribute("prestamos", ListaPrestamos);
			RequestDispatcher rd = request.getRequestDispatcher("/Prestamos.jsp");
			rd.forward(request, response);
		}
		
        if(request.getParameter("btnAceptarSolicitud")!=null) {
			pres.setNro_prestamo(Integer.parseInt(request.getParameter("nroPrestamo").toString()));
			ep.setEst_prestamo(1);
			pres.setEst_prestamo(ep);
			pneg.RespuestaSolicitud(pres);
			
			ep.setEst_prestamo(3);
			pres.setEst_prestamo(ep);
		    ArrayList<Prestamo> ListaPrestamos = (ArrayList<Prestamo>) pneg.Prestamos(pres);
			request.setAttribute("prestamos", ListaPrestamos);
			request.setAttribute("aceptado", true);
			RequestDispatcher rd = request.getRequestDispatcher("/Prestamos.jsp");
			rd.forward(request, response);
		}
        
        if(request.getParameter("btnRechazarSolicitud")!=null) {
        	pres.setNro_prestamo(Integer.parseInt(request.getParameter("nroPrestamo").toString()));
        	ep.setEst_prestamo(2);
			pres.setEst_prestamo(ep);
			pneg.RespuestaSolicitud(pres);
			
			ep.setEst_prestamo(3);
			pres.setEst_prestamo(ep);
		    ArrayList<Prestamo> ListaPrestamos = (ArrayList<Prestamo>) pneg.Prestamos(pres);
			request.setAttribute("prestamos", ListaPrestamos);
			request.setAttribute("rechazado", true);
			RequestDispatcher rd = request.getRequestDispatcher("/Prestamos.jsp");
			rd.forward(request, response);
		}

		
		//AL HACER CLICK EN 
		if(request.getParameter("ParamListarCLI")!=null) {
	
		    ArrayList<Cliente> ListaClientes = cneg.MostrarTodos();
			
			request.setAttribute("ListaLISTAR_CLIENTE", ListaClientes);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarClientes.jsp");
			rd.forward(request, response);
		}
			
		if(request.getParameter("ParamModifCLI")!=null) {
			
			ArrayList<Cliente> ListaClientes = cneg.MostrarTodos();
			request.setAttribute("ListaClientes", ListaClientes);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ModifClientes.jsp");
			rd.forward(request, response);
			
		}
	       
	    if(request.getParameter("ParamLCU")!=null) {
				
	        request.setAttribute("cuentas", cuneg.obtenerCuentas());
				
			RequestDispatcher rd = request.getRequestDispatcher("/ListarCuenta.jsp");   
		    rd.forward(request, response);
		}
	    
	    if(request.getParameter("modCuenta")!=null) {
	    	
			request.setAttribute("ModCuentas", neg.obtenerCuentas());
			
			RequestDispatcher rd = request.getRequestDispatcher("/ModifCuenta.jsp");
	        rd.forward(request, response);
		}
	    
	    
	    
    	if(request.getParameter("btnModificarCuenta")!=null) {
	    	
	    	ArrayList<Cuenta> lista = (ArrayList<Cuenta>) neg.obtenerCuentaPorNr_cuenta(request.getParameter("nroCuenta"));
	    	
	    	request.setAttribute("ModificarCuenta", lista);
	    	System.out.println("entro mod cuenta");
	    	RequestDispatcher rd = request.getRequestDispatcher("/ModifCuenta.jsp");   
	        rd.forward(request, response);
	    }
    
    	
    	
    	
    	
    	
    	
    	if(request.getParameter("Genero")!=null) {
    		int codigo = Integer.parseInt(request.getParameter("Genero"));
			ArrayList<Cliente> ListGeneros = cneg.CargarSegunCondicion("Genero",codigo);
			request.setAttribute("ListaLISTAR_CLIENTE", ListGeneros);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarClientes.jsp");
			rd.forward(request, response);
		}
    	
    	
    	if(request.getParameter("Nacionalidad")!=null) {
    		int codigo = Integer.parseInt(request.getParameter("Nacionalidad"));
			ArrayList<Cliente> ListNacionalidad = cneg.CargarSegunCondicion("nacionalidad",codigo);
			request.setAttribute("ListaLISTAR_CLIENTE", ListNacionalidad);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarClientes.jsp");
			rd.forward(request, response);
		}
    	
    	
    	
    	if(request.getParameter("Provincia")!=null) {
    		int codigo = Integer.parseInt(request.getParameter("Provincia"));
			ArrayList<Cliente> ListProvincia = cneg.CargarSegunCondicion("provincia",codigo);
			request.setAttribute("ListaLISTAR_CLIENTE", ListProvincia);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarClientes.jsp");
			rd.forward(request, response);
		}
    	
    	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("btnFiltrarPres")!=null) {
			if(request.getParameter("presIni").toString().equals("") && request.getParameter("presFin").toString().equals("") || request.getParameter("presIni").toString().length()>0 && request.getParameter("presFin").toString().length()>0) {
				ArrayList<Prestamo> ListaPrestamos = (ArrayList<Prestamo>) pneg.prestamoXfecha(request.getParameter("presIni").toString(), request.getParameter("presFin").toString(), request.getParameter("filtroPre").toString());
				request.setAttribute("prestamos", ListaPrestamos);
			}
			else request.setAttribute("errorPrestamo", true);
			ArrayList<Movimiento> ListaMovimientos = (ArrayList<Movimiento>) mneg.readAll();
		    request.setAttribute("movimientos", ListaMovimientos);
			RequestDispatcher rd = request.getRequestDispatcher("/Reportes.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnFiltrarMov")!=null) {
			if(request.getParameter("movIni").toString().equals("") && request.getParameter("movFin").toString().equals("") || request.getParameter("movIni").toString().length()>0 && request.getParameter("movFin").toString().length()>0) {
				ArrayList<Movimiento> ListaMovimientos = (ArrayList<Movimiento>) mneg.movimientoXfecha(request.getParameter("movIni").toString(), request.getParameter("movFin").toString(), request.getParameter("filtroMov").toString());
				request.setAttribute("movimientos", ListaMovimientos);
			}
			else request.setAttribute("errorMovimiento", true);
			ArrayList<Prestamo> ListaPrestamos = (ArrayList<Prestamo>) pneg.readAll();
		    request.setAttribute("prestamos", ListaPrestamos);
			RequestDispatcher rd = request.getRequestDispatcher("/Reportes.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnMostrarMov")!=null) {
			ArrayList<Prestamo> ListaPrestamos = (ArrayList<Prestamo>) pneg.readAll();
		    ArrayList<Movimiento> ListaMovimientos = (ArrayList<Movimiento>) mneg.readAll();
		    request.setAttribute("movimientos", ListaMovimientos);
		    request.setAttribute("prestamos", ListaPrestamos);
		    RequestDispatcher rd = request.getRequestDispatcher("/Reportes.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnMostrarPres")!=null) {
			ArrayList<Prestamo> ListaPrestamos = (ArrayList<Prestamo>) pneg.readAll();
		    ArrayList<Movimiento> ListaMovimientos = (ArrayList<Movimiento>) mneg.readAll();
		    request.setAttribute("movimientos", ListaMovimientos);
		    request.setAttribute("prestamos", ListaPrestamos);
		    RequestDispatcher rd = request.getRequestDispatcher("/Reportes.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("filtrarPrestamos")!=null) {
		    ArrayList<Prestamo> ListaPrestamos = (ArrayList<Prestamo>) pneg.obtenerPrestamosQueryCustom(request.getParameter("ddlFiltro").toString(), request.getParameter("txtFiltro").toString());
			request.setAttribute("prestamos", ListaPrestamos);
			RequestDispatcher rd = request.getRequestDispatcher("/Prestamos.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("LPrestamos")!=null) {
			ep.setEst_prestamo(3);
			pres.setEst_prestamo(ep);
		    ArrayList<Prestamo> ListaPrestamos = (ArrayList<Prestamo>) pneg.Prestamos(pres);
			request.setAttribute("prestamos", ListaPrestamos);
			RequestDispatcher rd = request.getRequestDispatcher("/Prestamos.jsp");
			rd.forward(request, response);
		}
		
            if(request.getParameter("AceptarAgregar")!=null) {

            boolean alta = true;
            
			if(request.getParameter("contra").toString().compareTo(request.getParameter("contra2").toString())!=0)
			{
				alta = false;
				request.setAttribute("errorContrase�a", alta);
				RequestDispatcher rd = request.getRequestDispatcher("/AltaClientes.jsp");   
		        rd.forward(request, response);
		        return;
			}
			
			u.setUsuario(request.getParameter("usuario").toString());
			u.setTipo_Us(new TipoUsuario(2,"Cliente"));
			u.setContrasenia(request.getParameter("contra").toString());
			u.setEstado(true);
			
			if(uneg.existeNombreUsuario(u)) {
				alta = false;
				request.setAttribute("usuarioExistente", alta);
				RequestDispatcher rd = request.getRequestDispatcher("/AltaClientes.jsp");   
		        rd.forward(request, response);
		        return;
			}

			g.setCod_genero(Integer.parseInt(request.getParameter("genero").toString()));
			n.setCod_nacionalidad(Integer.parseInt(request.getParameter("nacionalidad").toString()));
			p.setCod_provincia(Integer.parseInt(request.getParameter("provincia").toString()));
			l.setCod_localidad(Integer.parseInt(request.getParameter("localidad").toString()));

				
			c.setNombre(request.getParameter("nombre").toString());
			c.setApellido(request.getParameter("apellido").toString());
			c.setDni(request.getParameter("dni").toString());
			c.setCuil(request.getParameter("cuil").toString());			
			c.setCod_Genero(g);
			c.setCod_nacionalidad(n);
			c.setFecha_nac(request.getParameter("fechaNacimiento").toString());
			c.setDireccion(request.getParameter("direccion").toString());
			c.setCod_provincia(p);
			c.setCod_localidad(l);
			c.setEmail(request.getParameter("email").toString());
			c.setTelefono(request.getParameter("telefono").toString());
			c.setUsuario(u);
			c.setEstado(true);
			
			if(cneg.insert(c) == false) {
				alta = false;
				request.setAttribute("error", alta);
				RequestDispatcher rd = request.getRequestDispatcher("/AltaClientes.jsp");   
		        rd.forward(request, response);
		        return;
			}
			
			if(alta==true) {
				request.setAttribute("exito", alta);
				RequestDispatcher rd = request.getRequestDispatcher("/AltaClientes.jsp");   
			    rd.forward(request, response);
			}
		        
       }
       
       if(request.getParameter("AceptarEliminar")!=null) {
			boolean baja = false;
			Cliente c = new Cliente();
			c.setDni(request.getParameter("UsuarioEliminado").toString());
			
			ClienteNegocioImp cn = new ClienteNegocioImp();
			baja = cn.delete(c);
			
			if(baja==true) request.setAttribute("exito", baja);
			else request.setAttribute("error", baja);
			RequestDispatcher rd = request.getRequestDispatcher("/BajaClientes.jsp");   
	        rd.forward(request, response);
		}
       
       
       
       if(request.getParameter("btnBuscarUser")!=null) {
			
			String User=request.getParameter("txtBuscarUsuario").toString();
			
			ArrayList<Cliente> ClienteSegunUser = cneg.LeerSegunUsuario(User);
			
			request.setAttribute("ListaLISTAR_CLIENTE",ClienteSegunUser);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarClientes.jsp");
			rd.forward(request, response);
		}
       
       
       
       if(request.getParameter("btnBuscar")!=null) {
			
			ArrayList<Cuenta> lista = (ArrayList<Cuenta>) cuneg.obtenerCuentaQueryCustom(request.getParameter("dllBusqueda").toString(), request.getParameter("txtFiltro").toString());
			System.out.println(request.getParameter("dllBusqueda").toString());
			request.removeAttribute("cuentas");
			request.setAttribute("cuentas", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarCuenta.jsp");   
	        rd.forward(request, response);
		}
	    
	    if(request.getParameter("btnModBuscar")!=null) {
			ArrayList<Cuenta> lista = (ArrayList<Cuenta>) neg.obtenerCuentaQueryCustom(request.getParameter("dllBusqueda").toString(), request.getParameter("txtFiltro").toString());
			
			request.removeAttribute("ModCuentas");
			request.setAttribute("ModCuentas", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ModifCuenta.jsp");   
	        rd.forward(request, response);
		}
	    
	    if(request.getParameter("btnModificarCuenta")!=null) {
	    	
	    	ArrayList<Cuenta> lista = (ArrayList<Cuenta>) neg.obtenerCuentaPorNr_cuenta(request.getParameter("nroCuenta"));
	    	
	    	request.setAttribute("ModificarCuenta", lista);
	    	System.out.println("entro mod cuenta");
	    	RequestDispatcher rd = request.getRequestDispatcher("/ModifCuenta.jsp");   
	        rd.forward(request, response);
	    }
	    
	    if(request.getParameter("AceptarModificar")!=null) {
	    	System.out.println(request.getParameter("ddlTipoCuenta").toString());
	    	System.out.println(request.getParameter("nroCuentaM").toString());
	    	
	    	Cuenta c = new Cuenta();
	    	c.setNro_cuenta(Integer.parseInt(request.getParameter("nroCuentaM")));
	    	c.setNro_cliente(Integer.parseInt(request.getParameter("nroClienteM")));
	    	c.setFecha_creacion(request.getParameter("fechaCreacionM"));
	    	c.setCbu(request.getParameter("cbuM"));
	    	c.setTipo_cuenta(new TipoCuenta(Integer.parseInt(request.getParameter("ddlTipoCuenta").toString()),"asd"));
	    	c.setSaldo(Float.valueOf(request.getParameter("saldoM")));
	    	
	    	if(neg.modificarCuenta(c)){
	    		request.setAttribute("infoModify", true);
	    		
	    		request.setAttribute("ModCuentas", neg.obtenerCuentas());
				
				RequestDispatcher rd = request.getRequestDispatcher("/ModifCuenta.jsp");
		        rd.forward(request, response);
	    	}
	    	else {
	    		request.setAttribute("infoModify", false);
	    		
	    		ArrayList<Cuenta> lista = (ArrayList<Cuenta>) neg.obtenerCuentaPorNr_cuenta(request.getParameter("nroCuentaM"));
		    	
		    	request.setAttribute("ModificarCuenta", lista);
		    	
		    	RequestDispatcher rd = request.getRequestDispatcher("/ModifCuenta.jsp");   
		        rd.forward(request, response);
	    	}
	    	
	    	
	    }
	    
	    if(request.getParameter("modCuenta")!=null) {
	    	
			request.setAttribute("ModCuentas", neg.obtenerCuentas());
			
			RequestDispatcher rd = request.getRequestDispatcher("/ModifCuenta.jsp");
	        rd.forward(request, response);
		}
	    
	    if(request.getParameter("ParamLCU")!=null) {
			
	        request.setAttribute("cuentas", cuneg.obtenerCuentas());
				
			RequestDispatcher rd = request.getRequestDispatcher("/ListarCuenta.jsp");   
		    rd.forward(request, response);
		}
	    
	    if(request.getParameter("RechazarModificar")!=null) {
	    	
	    	request.removeAttribute("ModCuentas");
			request.setAttribute("ModCuentas", neg.obtenerCuentas());
			
			RequestDispatcher rd = request.getRequestDispatcher("/ModifCuenta.jsp");
	        rd.forward(request, response);
	    }

       if(request.getParameter("btnAltaCuenta")!=null) {

    	   Cuenta c = new Cuenta();
    	   c.setNro_cliente(Integer.parseInt(request.getParameter("NroCliente").toString()));
    	   c.setTipo_cuenta(new TipoCuenta(Integer.parseInt(request.getParameter("ddlCuentas").toString()),""));
    	   c.setCbu(request.getParameter("Cbu").toString());
    	   c.setSaldo(10000);
    	   c.setEstado(true);
    	   
    	   CuentaNegocioImp cn = new CuentaNegocioImp();
    	   
    	   // Verifico que no haya llegado a la maxima cantidad de cuentas por cliente
    	   int totCuentasCliente = cn.totalCuentasPorCliente(c.getNro_cliente());
    	   if(totCuentasCliente>=3) {
				request.setAttribute("cuenta", c);
  			    request.setAttribute("resultadoAlta", "errorCantidadCuentas");
  	    	    RequestDispatcher rd = request.getRequestDispatcher("MostrarCuenta.jsp");   
  	    	    rd.forward(request, response);
    	   }
			
    	   // Realizo el alta de cuenta
    	   int nroCuenta = cn.insert(c);
    	   request.setAttribute("NRO", nroCuenta);

    	   if(nroCuenta>0) {
				c.setNro_cuenta(nroCuenta);
				request.setAttribute("cuenta", c);
   			    request.setAttribute("resultadoAlta", "ok");
    	   }
    	   else {
				request.setAttribute("cliente", c);
   			    request.setAttribute("resultadoAlta", "error");
    	   }
    	   RequestDispatcher rd = request.getRequestDispatcher("MostrarCuenta.jsp");   
    	   rd.forward(request, response);
       }


       if(request.getParameter("btnBuscarUsuario")!=null) {
			
			String User=request.getParameter("txtUsuarioModificar").toString();
			
			ArrayList<Cliente> ClienteSegunUser = cneg.LeerSegunUsuario(User);
			
			request.setAttribute("CLIENTE",ClienteSegunUser);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ModifClientes.jsp");
			rd.forward(request, response);
		}
		
		
		if(request.getParameter("btnModificarCliente")!=null) {
			
           String User1=request.getParameter("hiddenUsuario").toString();
		   ArrayList<Cliente> ClienteUser = cneg.LeerSegunUsuario(User1);
		   request.setAttribute("ClienteModificar",ClienteUser);
			
			GeneroNegocioImp gneg = new GeneroNegocioImp();
			ArrayList<Genero> listGeneros = (ArrayList<Genero>) gneg.readAll();
			request.setAttribute("generos", listGeneros);
			
			NacionalidadNegocioImp nneg = new NacionalidadNegocioImp();
			ArrayList<Nacionalidad> listNacionalidades = (ArrayList<Nacionalidad>) nneg.readAll();
			request.setAttribute("nacionalidades", listNacionalidades);
			
			ProvinciaNegocioImp pneg = new ProvinciaNegocioImp();
			ArrayList<Provincia> listProvincias = (ArrayList<Provincia>) pneg.readAll();
			request.setAttribute("provincias", listProvincias);
			
			LocalidadNegocioImp lneg = new LocalidadNegocioImp();
			ArrayList<Localidad> listaLocalidad = (ArrayList<Localidad>) lneg.readAll();
			request.setAttribute("localidades", listaLocalidad);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ModifClientes.jsp");
			rd.forward(request, response);
		}
		
		
		
		if(request.getParameter("btnModificarCancelar")!=null || request.getParameter("btnMostrarTodo")!=null) {
			ArrayList<Cliente> ListaClientes = cneg.MostrarTodos();
			request.setAttribute("ListaClientes", ListaClientes);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ModifClientes.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnModificarAceptar")!=null) {
			boolean ModCli = false;
			boolean ModUs = false;
			
			Cliente cliente = new Cliente();
			Usuario usuario = new Usuario();
			Genero genero = new Genero();
			Nacionalidad nac = new Nacionalidad();
			Provincia prov = new Provincia();
			Localidad loc = new Localidad();
			
			genero.setCod_genero(Integer.parseInt(request.getParameter("ddlGenero").toString()));
			nac.setCod_nacionalidad(Integer.parseInt(request.getParameter("ddlNacionalidad").toString()));
			prov.setCod_provincia(Integer.parseInt(request.getParameter("ddlProvincia").toString()));
			loc.setCod_localidad(Integer.parseInt(request.getParameter("ddlLocalidad").toString()));
			
			usuario.setUsuario(request.getParameter("txtUsuario").toString());
			
			cliente.setNro_Cliente(Integer.parseInt(request.getParameter("txtNroCliente").toString()));
			cliente.setNombre(request.getParameter("txtNombre").toString());
			cliente.setApellido(request.getParameter("txtApellido").toString());
			cliente.setDni(request.getParameter("txtDNI").toString());
			cliente.setCuil(request.getParameter("txtCUIL").toString());			
			cliente.setDireccion(request.getParameter("txtDireccion").toString());
			cliente.setTelefono(request.getParameter("txtTelefono").toString());
			cliente.setFecha_nac(request.getParameter("txtFechaNac").toString());
			cliente.setCod_Genero(genero);
			cliente.setCod_nacionalidad(nac);
			cliente.setCod_provincia(prov);
			cliente.setCod_localidad(loc);
			cliente.setEmail(request.getParameter("txtEmail").toString());
			cliente.setEstado(true);
			cliente.setUsuario(usuario);
			
		    ModCli = cneg.update(cliente);
			
			UsuarioNegocioImp NegUser = new UsuarioNegocioImp();
			usuario.setContrasenia(request.getParameter("txtContrase�a").toString());
			
			ModUs = NegUser.update(usuario);
			
			if(ModCli && ModUs) {
				request.setAttribute("ModifTrue", true);
			}
			
            ArrayList<Cliente> ListaClientes = cneg.MostrarTodos();
			request.setAttribute("ListaClientes", ListaClientes);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ModifClientes.jsp");
			rd.forward(request, response);
		}
		
	    if(request.getParameter("btnBuscarCuenta")!=null) {

    	   Cuenta c = new Cuenta();
    	   c.setNro_cuenta(Integer.parseInt(request.getParameter("NroCuentaAEliminar").toString()));
    	   
    	   // Obtengo cuenta
    	   CuentaNegocioImp cn = new CuentaNegocioImp();
    	   c = cn.get(c);
    	   
		   request.setAttribute("cuenta", c);
    	   if(c!=null) {
    		   request.setAttribute("cuentaEncontrada", "true");
    	   }
    	   else
    	   {
    		   request.setAttribute("cuentaEncontrada", "false");
    	   }
    	   
    	   RequestDispatcher rd = request.getRequestDispatcher("BajaCuenta.jsp");   
    	   rd.forward(request, response);
	    }
	    

	    if(request.getParameter("btnEliminarCuenta")!=null) {
    	   Cuenta c = new Cuenta();
    	   String nroCuenta = request.getParameter("hiddenNroCuenta");
    	   c.setNro_cuenta(Integer.parseInt(nroCuenta));
    	   
    	   // Elimino cuenta
    	   CuentaNegocioImp cn = new CuentaNegocioImp();
    	   boolean cuentaEliminada = cn.delete(c);
    	   
    	   if(cuentaEliminada) 
    	   {
    		   request.setAttribute("cuentaEliminada", "true");
    	   }
    	   else 
    	   {
    		   request.setAttribute("cuentaEliminada", "false");
    	   }

    	   RequestDispatcher rd = request.getRequestDispatcher("BajaCuenta.jsp");   
    	   rd.forward(request, response);
		}
	}

}
