package negocio;

import java.util.ArrayList;
import java.util.List;

import entidades.Prestamo;

public interface PrestamoNegocio {

	public List<Prestamo> readAll();
	public List<Prestamo> Prestamos(Prestamo p);
	public boolean RespuestaSolicitud(Prestamo p);
	public ArrayList<Prestamo> obtenerPrestamosQueryCustom(String consulta, String filtro);

}
