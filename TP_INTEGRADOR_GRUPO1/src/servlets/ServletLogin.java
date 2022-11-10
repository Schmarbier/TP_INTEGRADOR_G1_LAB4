package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			if(verificarTextbox()) {
				String usuario = request.getParameter("txtUsuario");
				String contraseña = request.getParameter("txtPassword");
				
				Usuario usu = new Usuario();
				usu.setUsuario(usuario);
				usu.setContraseña(contraseña);
				
				UsuarioNegocioImp neg = new UsuarioNegocioImp();
				if(neg.existeUsuario(usu)) {
					request.setAttribute("sessionTipoUsuario", "admin");
					response.sendRedirect("AltaClientes.jsp");
				}
				else {
					request.setAttribute("error", true);
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");   
			rd.forward(request, response);   
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private boolean verificarTextbox() {
		return false;
	}

}
