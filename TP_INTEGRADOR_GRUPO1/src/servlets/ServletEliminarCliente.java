package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import negocioImp.ClienteNegocioImp;

@WebServlet("/ServletEliminarCliente")
public class ServletEliminarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletEliminarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnEliminar")!=null) {
			boolean baja = false;
			Cliente c = new Cliente();
			c.setDni(Integer.parseInt(request.getParameter("dni").toString()));
			
			ClienteNegocioImp cn = new ClienteNegocioImp();
			baja = cn.delete(c);
			
			if(baja==true) request.setAttribute("exito", baja);
			else request.setAttribute("error", baja);
			RequestDispatcher rd = request.getRequestDispatcher("/BajaClientes.jsp");   
	        rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
