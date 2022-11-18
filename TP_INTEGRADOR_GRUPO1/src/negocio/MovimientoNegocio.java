package negocio;

import java.util.List;

import entidades.Movimiento;

public interface MovimientoNegocio {
	
	public int dineroTotal();
	public List<Movimiento> readAll();

}
