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

}
