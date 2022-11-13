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
			String contraseña = request.getParameter("txtPassword");
			Usuario usu = new Usuario();
			usu.setUsuario(usuario);
			usu.setContrasenia(contraseña);

			UsuarioNegocioImp neg = new UsuarioNegocioImp();

			String forwardURL = "Login.jsp"; 
			
			if(neg.existeUsuario(usu)) {
				
				request.setAttribute("nombreUsurio", usu.getUsuario());
				
				// Verifico si es admin o cliente
				
				HttpSession session = request.getSession();
				session.setAttribute("nombreUsurio", usuario);
				
				if(neg.esAdmin(usu)) {
					request.setAttribute("usuarioAdmin", true);
					forwardURL = "ServletDatosAdmin?datosAlta=1";   
				}
				else {
					request.setAttribute("usuarioAdmin", false);
					forwardURL = "Cuenta1.jsp";   
				}
			}
			else {
				request.setAttribute("error", true);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardURL);   
			rd.forward(request, response);   

			request.setAttribute("cad", usu.toString());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
