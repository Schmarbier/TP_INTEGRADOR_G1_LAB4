package negocioImp;

import java.util.ArrayList;
import java.util.List;

import dao.PrestamoDao;
import daoImp.PrestamoDaoImp;
import entidades.Prestamo;
import negocio.PrestamoNegocio;

public class PrestamoNegocioImp implements PrestamoNegocio{

	PrestamoDao pdao = new PrestamoDaoImp();

	@Override
	public List<Prestamo> SolicitudesPrestamos() {
		return pdao.SolicitudesPrestamos();
	}
	
	@Override
	public List<Prestamo> Prestamos() {
		return pdao.Prestamos();
	}

	@Override
	public boolean RespuestaSolicitud(Prestamo p) {
		return pdao.RespuestaSolicitud(p);
	}

	@Override
	public ArrayList<Prestamo> obtenerPrestamosQueryCustom(String consulta, String filtro) {
		return pdao.obtenerPrestamosQueryCustom(consulta, filtro);
	}

}
