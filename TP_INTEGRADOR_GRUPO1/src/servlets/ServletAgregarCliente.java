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
  
		if(request.getParameter("btnAgregar")!=null) {
			
			boolean alta = false;
			Cliente c = new Cliente();
			Usuario u = new Usuario();
			c.setNombre(request.getParameter("nombre").toString());
			c.setApellido(request.getParameter("apellido").toString());
			c.setDni(Integer.parseInt(request.getParameter("dni").toString()));
			c.setCuil(Integer.parseInt(request.getParameter("cuil").toString()));
			c.setCod_Genero(new Genero(Integer.parseInt(request.getParameter("genero")),""));
			c.setCod_nacionalidad(new Nacionalidad(Integer.parseInt(request.getParameter("nacionalidad")),""));
			///c.setFecha_nac(request.getParameter("fechaNacimiento").toString());
			c.setDireccion(request.getParameter("direccion").toString());
			c.setCod_localidad(new Localidad((new Provincia(Integer.parseInt(request.getParameter("provincia")),"")),Integer.parseInt(request.getParameter("localidad")), ""));
			c.setCod_provincia(new Provincia(Integer.parseInt(request.getParameter("provincia")),""));
			c.setTelefono(request.getParameter("telefono").toString());
			
			u.setUsuario(request.getParameter("usuario").toString());
			u.setTipo_Us(new TipoUsuario(2,"Cliente"));
			u.setContraseña(request.getParameter("contraseña").toString());
			u.setEstado(true);
			
			c.setUsuario(u);
			c.setEstado(true);
			
			ClienteNegocioImp cn = new ClienteNegocioImp();
			alta = cn.insert(c);
			
			UsuarioNegocioImp un = new UsuarioNegocioImp();
			alta = un.insert(u);
			
			if(alta==true) request.setAttribute("exito", alta);
			else request.setAttribute("error", alta);
			RequestDispatcher rd = request.getRequestDispatcher("/AltaClientes.jsp");   
	        rd.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
