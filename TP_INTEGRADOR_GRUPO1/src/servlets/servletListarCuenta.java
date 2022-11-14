package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CuentaDao;
import daoImp.CuentaDaoImp;
import entidades.Cuenta;
import entidades.TipoCuenta;
import negocioImp.CuentaNegocioImp;

/**
 * Servlet implementation class servletListarCuenta
 */
@WebServlet("/servletListarCuenta")
public class servletListarCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletListarCuenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CuentaNegocioImp neg = new CuentaNegocioImp();
		//CuentaNegocioImp neg = new CuentaNegocioImp();
		
		if(request.getParameter("Param")!=null) {
			
			request.setAttribute("cuentas", neg.obtenerCuentas());
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarCuenta.jsp");   
	        rd.forward(request, response);
		}
		
		if(request.getParameter("btnBuscar")!=null) {
			
			ArrayList<Cuenta> lista = (ArrayList<Cuenta>) neg.obtenerCuentaQueryCustom(request.getParameter("dllBusqueda").toString(), request.getParameter("txtFiltro").toString());
			System.out.println(request.getParameter("dllBusqueda").toString());
			request.removeAttribute("cuentas");
			request.setAttribute("cuentas", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ListarCuenta.jsp");   
	        rd.forward(request, response);
		}
		
		if(request.getParameter("modCuenta")!=null) {
	    	
			request.setAttribute("ModCuentas", neg.obtenerCuentas());
			
			RequestDispatcher rd = request.getRequestDispatcher("/ModifCuenta.jsp");
	        rd.forward(request, response);
		}
	    
	    if(request.getParameter("btnBuscarMod")!=null) {
	    	
			ArrayList<Cuenta> lista = (ArrayList<Cuenta>) neg.obtenerCuentaQueryCustom(request.getParameter("dllBusqueda").toString(), request.getParameter("txtFiltro").toString());
			System.out.println(request.getParameter("dllBusqueda").toString());
			request.removeAttribute("ModCuentas");
			request.setAttribute("ModCuentas", lista);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ModifCuenta.jsp");   
	        rd.forward(request, response);
		}
	    
	    if(request.getParameter("btnModificarCuenta")!=null) {
	    	
	    	ArrayList<Cuenta> lista = (ArrayList<Cuenta>) neg.obtenerCuentaPorNr_cuenta(request.getParameter("nroCuenta"));
	    	
	    	request.setAttribute("ModificarCuenta", lista);
	    	
	    	RequestDispatcher rd = request.getRequestDispatcher("/ModifCuenta.jsp");   
	        rd.forward(request, response);
	    }
	    
	    if(request.getParameter("AceptarModificar")!=null) {
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
	    	RequestDispatcher rd = request.getRequestDispatcher("ServletListarCuenta?modCuenta=1");   
	        rd.forward(request, response);
	    }
	    
	    if(request.getParameter("RechazarModificar")!=null) {
	    	
	    	request.removeAttribute("ModCuentas");
			request.setAttribute("ModCuentas", neg.obtenerCuentas());
			
			RequestDispatcher rd = request.getRequestDispatcher("/ModifCuenta.jsp");
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

}
