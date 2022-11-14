package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Usuario;
import negocioImp.UsuarioNegocioImp;

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
				session.setAttribute("nombreUsurio", usu.getUsuario());
				if(neg.esAdmin(usu)) {
					session.setAttribute("usuarioAdmin", true);

					RequestDispatcher rd = request.getRequestDispatcher("ServletDatosAdmin?datosAlta=1");   
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
}
