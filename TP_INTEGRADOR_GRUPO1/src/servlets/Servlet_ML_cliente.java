package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import negocioImp.ClienteNegocioImp;


@WebServlet("/Servlet_ML_cliente")
public class Servlet_ML_cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ClienteNegocioImp CliNeg = new ClienteNegocioImp();
       
   public Servlet_ML_cliente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getParameter("ParamListar")!=null) {
			ArrayList<Cliente> ListaClientes = CliNeg.MostrarTodos();
			
			request.setAttribute("ListaClientes", ListaClientes);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarClientes.jsp");
			rd.forward(request, response);
		}
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getParameter("btnBuscarUser")!=null) {
			
			String User=request.getParameter("txtBuscarUsuario").toString();
			
			ArrayList<Cliente> ClienteSegunUser = CliNeg.LeerSegunNombre(User);
			
			request.setAttribute("CLIENTE",ClienteSegunUser);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarClientes.jsp");
			rd.forward(request, response);
		}
	}
}
