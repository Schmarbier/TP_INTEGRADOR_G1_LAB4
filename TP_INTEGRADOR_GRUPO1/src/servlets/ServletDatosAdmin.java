package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Genero;
import entidades.Localidad;
import entidades.Nacionalidad;
import entidades.Provincia;
import negocioImp.ClienteNegocioImp;
import negocioImp.GeneroNegocioImp;
import negocioImp.LocalidadNegocioImp;
import negocioImp.NacionalidadNegocioImp;
import negocioImp.ProvinciaNegocioImp;


@WebServlet("/ServletDatosAdmin")
public class ServletDatosAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletDatosAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    ClienteNegocioImp cneg = new ClienteNegocioImp();
    GeneroNegocioImp gneg = new GeneroNegocioImp();
	NacionalidadNegocioImp nneg = new NacionalidadNegocioImp();
	ProvinciaNegocioImp pneg = new ProvinciaNegocioImp();
	LocalidadNegocioImp lneg = new LocalidadNegocioImp();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("datosAlta")!=null) {
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
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
