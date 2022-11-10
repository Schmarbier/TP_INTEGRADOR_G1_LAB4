package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import entidades.Genero;
import entidades.Localidad;
import entidades.Nacionalidad;
import entidades.Provincia;
import entidades.TipoUsuario;
import entidades.Usuario;
import negocioImp.ClienteNegocioImp;
import negocioImp.UsuarioNegocioImp;

@WebServlet("/ServletAgregarCliente")
public class ServletAgregarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletAgregarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*if(request.getParameter("btnLogin")!=null) {
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");   
			rd.forward(request, response);
		}*/
		
		if(request.getParameter("btnAgregar")!=null) {
			
			boolean alta = false;

			if(request.getParameter("contra").toString().compareTo(request.getParameter("contra2").toString())!=0)
			{
				request.setAttribute("errorContraseña", alta);
				RequestDispatcher rd = request.getRequestDispatcher("ServletAltaCliente?Param=1");   
		        rd.forward(request, response);
			}
			
			Cliente c = new Cliente();
			Usuario u = new Usuario();
			Genero g = new Genero();
			Nacionalidad n = new Nacionalidad();
			Provincia p = new Provincia();
			Localidad l = new Localidad();
			
			g.setCod_genero(Integer.parseInt(request.getParameter("genero").toString()));
			n.setCod_nacionalidad(Integer.parseInt(request.getParameter("nacionalidad").toString()));
			p.setCod_provincia(Integer.parseInt(request.getParameter("provincia").toString()));
			l.setCod_localidad(Integer.parseInt(request.getParameter("localidad").toString()));
			u.setUsuario(request.getParameter("usuario").toString());

			
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
			
			u.setTipo_Us(new TipoUsuario(2,"Cliente"));
			u.setContraseña(request.getParameter("contra").toString());
			u.setEstado(true);
			
			ClienteNegocioImp cn = new ClienteNegocioImp();
			alta = cn.insert(c);
			
			/*UsuarioNegocioImp un = new UsuarioNegocioImp();
			alta = un.insert(u);*/
			
			if(alta==true) request.setAttribute("exito", alta);
			else request.setAttribute("error", alta);
			RequestDispatcher rd = request.getRequestDispatcher("ServletAltaCliente?Param=1");   
	        rd.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
