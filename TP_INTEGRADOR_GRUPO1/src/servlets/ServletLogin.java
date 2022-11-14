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

import entidades.Genero;
import entidades.Localidad;
import entidades.Nacionalidad;
import entidades.Provincia;
import entidades.Usuario;
import entidades.TipoCuenta;
import negocioImp.GeneroNegocioImp;
import negocioImp.LocalidadNegocioImp;
import negocioImp.NacionalidadNegocioImp;
import negocioImp.ProvinciaNegocioImp;
import negocioImp.UsuarioNegocioImp;
import negocioImp.TipoCuentaNegocioImp;
/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnLogin")!=null) {
			String usuario = request.getParameter("txtUsuario");
			String contrasena = request.getParameter("txtPassword");
			
			HttpSession session = request.getSession();

			Usuario usu = new Usuario();
			usu.setUsuario(usuario);
			usu.setContrasenia(contrasena);
			
			UsuarioNegocioImp neg = new UsuarioNegocioImp();
			
			if(neg.existeUsuario(usu)) {
				// cargo datos para ddl
				cargarDatosDDL(request,response);
				
				// guardo el usuario y su tipo, y establezco su pagina por defecto 
				session.setAttribute("nombreUsurio", usu.getUsuario());
				if(neg.esAdmin(usu)) {
					session.setAttribute("usuarioAdmin", true);

					RequestDispatcher rd = request.getRequestDispatcher("AltaCuenta.jsp");   
//					RequestDispatcher rd = request.getRequestDispatcher("ServletDatosAdmin?datosAlta=1");   
					rd.forward(request, response);   
				}
				else {
					session.setAttribute("usuarioAdmin", false);

					RequestDispatcher rd = request.getRequestDispatcher("Cuenta1.jsp");   
					rd.forward(request, response); 
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

	// Cargo en variables de tipo session las los datos para mostrar en los ddl
	public void cargarDatosDDL( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();

		TipoCuentaNegocioImp tcneg = new TipoCuentaNegocioImp();
		ArrayList<TipoCuenta> listTipoCuenta = (ArrayList<TipoCuenta>) tcneg.readAll();
		session.setAttribute("TipoCuenta", listTipoCuenta);

		/*
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
		*/
	}	
	
}
