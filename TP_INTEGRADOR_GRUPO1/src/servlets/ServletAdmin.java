package servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
import entidades.TipoCuenta;
import entidades.TipoUsuario;
import entidades.Usuario;
import negocioImp.ClienteNegocioImp;
import negocioImp.CuentaNegocioImp;
import negocioImp.GeneroNegocioImp;
import negocioImp.LocalidadNegocioImp;
import negocioImp.NacionalidadNegocioImp;
import negocioImp.ProvinciaNegocioImp;
import daoImp.CuentaDaoImp;
import entidades.Cuenta;

@WebServlet("/ServletAdmin")
public class ServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	if(request.getParameter("Param")!=null) {
			/*ClienteNegocioImp cneg = new ClienteNegocioImp();
			int maxId = cneg.obtenerProxId();
			request.setAttribute("ncli", maxId);*/
			
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
			
			RequestDispatcher rd = request.getRequestDispatcher("AltaClientes.jsp");
			rd.forward(request, response);
	}
		
    if(request.getParameter("Alta")!=null) {
			
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
    
    if(request.getParameter("Baja")!=null) {	
    	
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
    }
    
    if(request.getParameter("modCuenta")!=null) {
    	CuentaDaoImp neg = new CuentaDaoImp();
    	
		request.setAttribute("ModCuentas", neg.obtenerCuentas());
		
		RequestDispatcher rd = request.getRequestDispatcher("/ModifCuenta.jsp");
        rd.forward(request, response);
	}
    
    if(request.getParameter("btnBuscarMod")!=null) {
    	CuentaDaoImp neg = new CuentaDaoImp();
    	
		ArrayList<Cuenta> lista = (ArrayList<Cuenta>) neg.obtenerCuentaQueryCustom(request.getParameter("dllBusqueda").toString(), request.getParameter("txtFiltro").toString());
		System.out.println(request.getParameter("dllBusqueda").toString());
		request.removeAttribute("ModCuentas");
		request.setAttribute("ModCuentas", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/ModifCuenta.jsp");   
        rd.forward(request, response);
	}
    
    if(request.getParameter("btnModificarCuenta")!=null) {
    	CuentaNegocioImp neg = new CuentaNegocioImp();
    	
    	ArrayList<Cuenta> lista = (ArrayList<Cuenta>) neg.obtenerCuentaPorNr_cuenta(request.getParameter("nroCuenta"));
    	
    	request.setAttribute("ModificarCuenta", lista);
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/ModifCuenta.jsp");   
        rd.forward(request, response);
    }
    
    if(request.getParameter("AceptarModificar")!=null) {
    	CuentaNegocioImp neg = new CuentaNegocioImp();
    	System.out.println(request.getParameter("ddlTipoCuenta").toString());
    	System.out.println(request.getParameter("nroCuentaM").toString());
    	
    	Cuenta c = new Cuenta();
    	c.setNro_cuenta(Integer.parseInt(request.getParameter("nroCuentaM")));
    	c.setNro_cliente(Integer.parseInt(request.getParameter("nroClienteM")));
    	c.setFecha_creacion(request.getParameter("fechaCreacionM"));
    	c.setCbu(request.getParameter("cbuM"));
    	c.setTipo_cuenta(new TipoCuenta(Integer.parseInt(request.getParameter("ddlTipoCuenta").toString()),"asd"));
    	c.setSaldo(Float.valueOf(request.getParameter("saldoM")));
    	neg.modificarCuenta(c);
    	RequestDispatcher rd = request.getRequestDispatcher("ServletAdmin?modCuenta=1");   
        rd.forward(request, response);
    }
    
    if(request.getParameter("RechazarModificar")!=null) {
    	CuentaDaoImp neg = new CuentaDaoImp();
    	
    	request.removeAttribute("ModCuentas");
		request.setAttribute("ModCuentas", neg.obtenerCuentas());
		
		RequestDispatcher rd = request.getRequestDispatcher("/ModifCuenta.jsp");
        rd.forward(request, response);
    }
}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
