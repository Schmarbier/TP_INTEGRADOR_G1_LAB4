package servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Cliente;
import entidades.Prestamo;
import negocioImp.CuentaNegocioImp;
import negocioImp.PrestamoNegocioImp;

@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCliente() {
        super();
    }

    PrestamoNegocioImp  Pneg = new PrestamoNegocioImp();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getParameter("SolicitarPrestamo")!=null || request.getParameter("btnCancelarPrestamo")!=null) {
			CargarFechayProxPrestamo(request, response);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/SolicitarPrestamo.jsp");
			rd.forward(request, response);
			
		}
		
		
		if(request.getParameter("btnSimularPrestamo")!=null) {
			float interes = (float) 1.5;
			float ImpSolicitado = Float.parseFloat(request.getParameter("txtImporte").toString());
			request.setAttribute("ImporteSolicitado", ImpSolicitado);
			
			float ImpTotal = ImpSolicitado*interes;
			request.setAttribute("ImporteTotal", ImpTotal);
			
			float InteresTotal = (float) (ImpSolicitado*0.5);
			request.setAttribute("InteresTotal", InteresTotal);
			
			int CuentaDestino = Integer.parseInt(request.getParameter("txtCuentaDepositar").toString());
			request.setAttribute("CuentaDestino", CuentaDestino);
			
					
			int NroPrestamo = Integer.parseInt(request.getParameter("NroPrestamo").toString());
			request.setAttribute("NroPrestamo", NroPrestamo);
			
            
            int CantCuotas = Integer.parseInt(request.getParameter("ddlCuotas").toString());
            request.setAttribute("CantidadCuotas", CantCuotas);
            
            float PagarXmes = ImpTotal/CantCuotas;
            request.setAttribute("PagarXmes", PagarXmes);
            
            
            
            CuentaNegocioImp CuentaNeg = new CuentaNegocioImp();
            if(CuentaNeg.ExisteNroCuenta(CuentaDestino)==false) {
            	request.setAttribute("existe", false);
            	
            	CargarFechayProxPrestamo(request, response);
            	
            	RequestDispatcher rd = request.getRequestDispatcher("/SolicitarPrestamo.jsp");
            	rd.forward(request, response);
            }else {
            
            RequestDispatcher rd = request.getRequestDispatcher("/SimulacionPrestamo.jsp");
			rd.forward(request, response);
		}
		}
		
		
		
		if(request.getParameter("btnConfirmarPrestamo")!=null) {
			boolean PrestamoEnviado = false;
			Prestamo P = new Prestamo();
			Cliente C = new Cliente();
			C.setNro_Cliente(Integer.parseInt(request.getParameter("NroCliente").toString()));
			
			P.setNro_cliente(C);
			P.setImp_solicitado(Float.parseFloat(request.getParameter("ImporteSolicitado").toString()));
			P.setImp_con_intereses(Float.parseFloat(request.getParameter("importeTotal").toString()));
			P.setNro_cuenta_deposito(Integer.parseInt(request.getParameter("CuentaDestino").toString()));
			P.setPlazo_pago_meses(Integer.parseInt(request.getParameter("CantidadCuotas").toString()));
			P.setCant_cuotas(Integer.parseInt(request.getParameter("CantidadCuotas").toString()));
			
			if(Pneg.insert(P)) PrestamoEnviado = true;
			
			request.setAttribute("PrestamoEnviado", PrestamoEnviado);
			
			CargarFechayProxPrestamo(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher("/SolicitarPrestamo.jsp");   
	        rd.forward(request, response);
			
		}
		
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}
	
	
	public void CargarFechayProxPrestamo( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int ProxNroPrestamo = Pneg.ObtenerProxNro_Prestamo();
		request.setAttribute("ProxNroPrestamo", ProxNroPrestamo);
		
		
		Calendar calendario = new GregorianCalendar();
		int dia, mes, anio;
		
		dia =calendario.get(Calendar.DAY_OF_MONTH);
		mes = calendario.get(Calendar.MONTH)+1;
		anio = calendario.get(Calendar.YEAR);
		
		String FechaActual = String.valueOf(dia) +"/"+ String.valueOf(mes)+"/"+String.valueOf(anio);
		request.setAttribute("FechaActual", FechaActual);
	}	

}
