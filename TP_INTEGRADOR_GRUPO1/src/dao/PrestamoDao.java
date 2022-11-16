package dao;

import java.util.ArrayList;
import java.util.List;

import entidades.Prestamo;

public interface PrestamoDao {

	public List<Prestamo> SolicitudesPrestamos();
	public boolean RespuestaSolicitud(Prestamo p);
	public ArrayList<Prestamo> obtenerPrestamosQueryCustom(String consulta, String filtro);
	
}
