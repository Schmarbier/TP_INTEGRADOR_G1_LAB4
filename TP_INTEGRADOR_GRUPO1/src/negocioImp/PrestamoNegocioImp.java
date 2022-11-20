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
	public List<Prestamo> readAll(){
		return pdao.readAll();
	}

	@Override
	public List<Prestamo> Prestamos(Prestamo p) {
		return pdao.Prestamos(p);
	}

	@Override
	public boolean RespuestaSolicitud(Prestamo p) {
		return pdao.RespuestaSolicitud(p);
	}

	@Override
	public ArrayList<Prestamo> obtenerPrestamosQueryCustom(String consulta, String filtro) {
		return pdao.obtenerPrestamosQueryCustom(consulta, filtro);
	}

	@Override
	public List<Prestamo> prestamoXfecha(String fecha1, String fecha2, String filtro) {
		return pdao.prestamoXfecha(fecha1, fecha2, filtro);
	}

}
