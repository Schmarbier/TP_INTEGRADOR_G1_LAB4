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
import entidades.Genero;
import entidades.Localidad;
import entidades.Nacionalidad;
import entidades.Provincia;
import entidades.TipoCuenta;
import entidades.TipoUsuario;
import entidades.Usuario;
import negocioImp.ClienteNegocioImp;
import negocioImp.CuentaNegocioImp;
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
	Cliente c = new Cliente();
	Usuario u = new Usuario();
	Genero g = new Genero();
	Nacionalidad n = new Nacionalidad();
	Provincia p = new Provincia();
	Localidad l = new Localidad();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("ParamLCLI")!=null) {

	    ArrayList<Cliente> ListaClientes = cneg.MostrarTodos();
		
		request.setAttribute("ListaClientes", ListaClientes);
		
		RequestDispatcher rd = request.getRequestDispatcher("/ListarClientes.jsp");
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
		
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           
		if(request.getParameter("btnAgregar")!=null) {

            boolean alta = true;
            
			if(request.getParameter("contra").toString().compareTo(request.getParameter("contra2").toString())!=0)
			{
				alta = false;
				request.setAttribute("errorContraseņa", alta);
				RequestDispatcher rd = request.getRequestDispatcher("ServletDatosAdmin?datosAlta=1");   
		        rd.forward(request, response);
			}
			
			u.setUsuario(request.getParameter("usuario").toString());
			u.setTipo_Us(new TipoUsuario(2,"Cliente"));
			u.setContrasenia(request.getParameter("contra").toString());
			u.setEstado(true);
			
			if(uneg.existeNombreUsuario(u)) {
				alta = false;
				request.setAttribute("usuarioExistente", alta);
				RequestDispatcher rd = request.getRequestDispatcher("ServletDatosAdmin?datosAlta=1");   
		        rd.forward(request, response);
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
			
			if(cneg.insert(c)) {
				request.setAttribute("exito", alta);
				RequestDispatcher rd = request.getRequestDispatcher("ServletDatosAdmin?datosAlta=1");   
		        rd.forward(request, response);
			} else {
				alta = false;
				///uneg.delete(u);
				request.setAttribute("error", alta);
				RequestDispatcher rd = request.getRequestDispatcher("ServletDatosAdmin?datosAlta=1");   
		        rd.forward(request, response);
			}
         }
       
       if(request.getParameter("btnEliminar")!=null) {
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
			
			ArrayList<Cliente> ClienteSegunUser = cneg.LeerSegunNombre(User);
			
			request.setAttribute("CLIENTE",ClienteSegunUser);
			
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
	    	System.out.println("ENTROOOOOOOOOO");
			ArrayList<Cuenta> lista = (ArrayList<Cuenta>) neg.obtenerCuentaQueryCustom(request.getParameter("dllBusqueda").toString(), request.getParameter("txtFiltro").toString());
			System.out.println(request.getParameter("dllBusqueda").toString());
			request.removeAttribute("ModCuentas");
			request.setAttribute("ModCuentas", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ModifCuenta.jsp");   
	        rd.forward(request, response);
		}
	    
	    if(request.getParameter("btnModificarCuenta")!=null) {
	    	
	    	ArrayList<Cuenta> lista = (ArrayList<Cuenta>) neg.obtenerCuentaPorNr_cuenta(request.getParameter("nroCuenta"));
	    	
	    	request.setAttribute("ModificarCuenta", lista);
	    	
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
	    	neg.modificarCuenta(c);
	    	
	    	request.setAttribute("ModCuentas", neg.obtenerCuentas());
			
			RequestDispatcher rd = request.getRequestDispatcher("/ModifCuenta.jsp");
	        rd.forward(request, response);
	    }
	    
	    if(request.getParameter("RechazarModificar")!=null) {
	    	
	    	request.removeAttribute("ModCuentas");
			request.setAttribute("ModCuentas", neg.obtenerCuentas());
			
			RequestDispatcher rd = request.getRequestDispatcher("/ModifCuenta.jsp");
	        rd.forward(request, response);
	    }
       
		doGet(request, response);

	}

}
