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
import entidades.TipoUsuario;
import entidades.Usuario;
import negocioImp.ClienteNegocioImp;
import negocioImp.GeneroNegocioImp;
import negocioImp.LocalidadNegocioImp;
import negocioImp.NacionalidadNegocioImp;
import negocioImp.ProvinciaNegocioImp;
import negocioImp.UsuarioNegocioImp;

@WebServlet("/ServletAdmin")
public class ServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletAdmin() {
        super();
    }

    ClienteNegocioImp cneg = new ClienteNegocioImp();
	GeneroNegocioImp gneg = new GeneroNegocioImp();
	NacionalidadNegocioImp nneg = new NacionalidadNegocioImp();
	ProvinciaNegocioImp pneg = new ProvinciaNegocioImp();
	LocalidadNegocioImp lneg = new LocalidadNegocioImp();
	CuentaDaoImp cuneg = new CuentaDaoImp();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	if(request.getParameter("ParamACLI")!=null) {
		    int maxId = cneg.obtenerProxId();
			request.setAttribute("ncli", maxId);
			
			ArrayList<Genero> listGeneros = (ArrayList<Genero>) gneg.readAll();
			request.setAttribute("generos", listGeneros);
			
			ArrayList<Nacionalidad> listNacionalidades = (ArrayList<Nacionalidad>) nneg.readAll();
			request.setAttribute("nacionalidades", listNacionalidades);
			
			ArrayList<Provincia> listProvincias = (ArrayList<Provincia>) pneg.readAll();
			request.setAttribute("provincias", listProvincias);
			
			ArrayList<Localidad> listaLocalidad = (ArrayList<Localidad>) lneg.readAll();
			request.setAttribute("localidades", listaLocalidad);
			
			RequestDispatcher rd = request.getRequestDispatcher("AltaClientes.jsp");
			rd.forward(request, response);
	}
	
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
		
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            if(request.getParameter("btnAgregar")!=null) {
			
			boolean alta = false;
			boolean altaUs = false;

			if(request.getParameter("contra").toString().compareTo(request.getParameter("contra2").toString())!=0)
			{
				request.setAttribute("errorContraseña", alta);
				RequestDispatcher rd = request.getRequestDispatcher("ServletAdmin?Param=1");   
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
			u.setContrasenia(request.getParameter("contra").toString());
			u.setEstado(true);
			
			ClienteNegocioImp cn = new ClienteNegocioImp();
			alta = cn.insert(c);
			
			if(alta==true) {
				UsuarioNegocioImp un = new UsuarioNegocioImp();
				altaUs = un.insert(u);
			}		
			
			if(alta==true && altaUs==true) request.setAttribute("exito", alta);
			else request.setAttribute("error", alta);
			RequestDispatcher rd = request.getRequestDispatcher("/AltaClientes.jsp");   
	        rd.forward(request, response);
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
       
		///doGet(request, response);
	}

}
