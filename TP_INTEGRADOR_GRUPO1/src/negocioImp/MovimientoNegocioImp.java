package negocioImp;

import java.util.List;

import dao.MovimientoDao;
import daoImp.MovimientoDaoImp;
import entidades.Movimiento;
import negocio.MovimientoNegocio;

public class MovimientoNegocioImp implements MovimientoNegocio{

	MovimientoDao mdao = new MovimientoDaoImp();

	@Override
	public List<Movimiento> readAll() {
		return mdao.readAll();
	}

	@Override
	public int dineroTotal() {
		return mdao.dineroTotal();
	}

	@Override
	public List<Movimiento> movimientoXfecha(String fecha1, String fecha2, String filtro) {
		return mdao.movimientoXfecha(fecha1, fecha2, filtro);
	}

}
