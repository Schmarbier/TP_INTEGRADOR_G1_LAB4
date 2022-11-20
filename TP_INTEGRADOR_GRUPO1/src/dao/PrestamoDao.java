package dao;

import java.util.ArrayList;
import java.util.List;

import entidades.Prestamo;

public interface PrestamoDao {

	public boolean aprobarPrestamo(Prestamo p);
	public boolean rechazarPrestamo(Prestamo p);
	public List<Prestamo> readAll();
	public List<Prestamo> prestamoXfecha(String fecha1, String fecha2, String filtro);
	public List<Prestamo> Solicitudes();
	public ArrayList<Prestamo> obtenerPrestamosQueryCustom(String consulta, String filtro);
	
}
