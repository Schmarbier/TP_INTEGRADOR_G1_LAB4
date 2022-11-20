package negocio;

import java.util.List;

import entidades.Movimiento;

public interface MovimientoNegocio {

	public List<Movimiento> movimientoXfecha(String fecha1, String fecha2, String filtro);
	public int dineroTotal();
	public List<Movimiento> readAll();

}
