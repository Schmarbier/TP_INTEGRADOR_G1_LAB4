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
	public List<Prestamo> Solicitudes() {
		return pdao.Solicitudes();
	}

	@Override
	public ArrayList<Prestamo> obtenerPrestamosQueryCustom(String consulta, String filtro) {
		return pdao.obtenerPrestamosQueryCustom(consulta, filtro);
	}

	@Override
	public List<Prestamo> prestamoXfecha(String fecha1, String fecha2, String filtro) {
		return pdao.prestamoXfecha(fecha1, fecha2, filtro);
	}

	@Override
	public boolean aprobarPrestamo(Prestamo p) {
		return pdao.aprobarPrestamo(p);
	}

	@Override
	public boolean rechazarPrestamo(Prestamo p) {
		return pdao.rechazarPrestamo(p);
	}

	@Override
	public int ObtenerProxNro_Prestamo() {
		return pdao.ObtenerProxNro_Prestamo();
	}

	@Override
	public boolean insert(Prestamo prestamo) {
		return pdao.insert(prestamo);
	}

}
