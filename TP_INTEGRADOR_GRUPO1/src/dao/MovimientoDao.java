package dao;

import java.util.List;

import entidades.Movimiento;

public interface MovimientoDao {

	public int dineroTotal();
	public List<Movimiento> readAll();
}
