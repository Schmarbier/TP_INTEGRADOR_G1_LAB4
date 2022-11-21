package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Usuario;
import entidades.Cliente;
import entidades.Genero;
import entidades.Localidad;
import entidades.Movimiento;
import entidades.Nacionalidad;
import entidades.Prestamo;
import entidades.Provincia;
import entidades.TipoCuenta;
import negocioImp.UsuarioNegocioImp;
import negocioImp.ClienteNegocioImp;
import negocioImp.GeneroNegocioImp;
import negocioImp.LocalidadNegocioImp;
import negocioImp.MovimientoNegocioImp;
import negocioImp.NacionalidadNegocioImp;
import negocioImp.PrestamoNegocioImp;
import negocioImp.ProvinciaNegocioImp;
import negocioImp.TipoCuentaNegocioImp;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	TipoCuentaNegocioImp tcneg = new TipoCuentaNegocioImp();
	GeneroNegocioImp gneg = new GeneroNegocioImp();
	NacionalidadNegocioImp nneg = new NacionalidadNegocioImp();
	ProvinciaNegocioImp provneg = new ProvinciaNegocioImp();
	LocalidadNegocioImp lneg = new LocalidadNegocioImp();
    ClienteNegocioImp cneg = new ClienteNegocioImp();
    MovimientoNegocioImp mneg = new MovimientoNegocioImp();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnLogin")!=null) {
			String usuario = request.getParameter("txtUsuario");
			String contrasena = request.getParameter("txtPassword");
			
			HttpSession session = request.getSession();
			
			session.setAttribute("cliente",null);

			Usuario usu = new Usuario();
			usu.setUsuario(usuario);
			usu.setContrasenia(contrasena);
			
			UsuarioNegocioImp neg = new UsuarioNegocioImp();
			
			if(neg.existeUsuario(usu)) {
				// cargo datos 
				cargarDatos(request,response);
				
				// guardo el usuario y su tipo, y establezco su pagina por defecto 
				session.setAttribute("nombreUsurio", usu.getUsuario());
				
				// Usuario administrador
				if(neg.esAdmin(usu)) {
					session.setAttribute("usuarioAdmin", true);

					RequestDispatcher rd = request.getRequestDispatcher("AltaClientes.jsp"); 
					rd.forward(request, response);   
				}
				// usuario cliente
				else {
					session.setAttribute("usuarioAdmin", false);
					
					Cliente cli = new Cliente();
					ClienteNegocioImp cn = new ClienteNegocioImp();
					cli = cn.getClientePorUsuario(usu.getUsuario());
					
					if (cli!=null) {
						
						//Verifico si el cliente esta activo
						if(cli.getEstado()==true) {
							
							// Gardo cliente en una variable session
							session.setAttribute("cliente",cli);
							
							// Ingreso a la aplicación
							RequestDispatcher rd = request.getRequestDispatcher("Cuenta1.jsp");   
							rd.forward(request, response); 
							
						}
						else request.setAttribute("usuarioInactivo", true);
						
					}
					//  cliente no existe
					else request.setAttribute("error", true);
				}
			}
			else {
				request.setAttribute("error", true);
			}
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");   
			rd.forward(request, response);   
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	// Cargo en variables de tipo session las los datos para mostrar en las pantallas
	public void cargarDatos( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
	    
		ArrayList<TipoCuenta> listTipoCuenta = (ArrayList<TipoCuenta>) tcneg.readAll();
		session.setAttribute("TipoCuenta", listTipoCuenta);
		
		int maxId = cneg.obtenerProxId();
		session.setAttribute("ncli", maxId);
		    
		int dinero = mneg.dineroTotal();
		session.setAttribute("total", dinero);
	    
	    ArrayList<Genero> listGeneros = (ArrayList<Genero>) gneg.readAll();
		session.setAttribute("generos", listGeneros);

		ArrayList<Nacionalidad> listNacionalidades = (ArrayList<Nacionalidad>) nneg.readAll();
		session.setAttribute("nacionalidades", listNacionalidades);
		
		ArrayList<Provincia> listProvincias = (ArrayList<Provincia>) provneg.readAll();
		session.setAttribute("provincias", listProvincias);
		
		ArrayList<Localidad> listaLocalidad = (ArrayList<Localidad>) lneg.readAll();
		session.setAttribute("localidades", listaLocalidad);
		
	}	
	
}
