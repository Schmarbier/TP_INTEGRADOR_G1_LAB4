package negocioImp;

import java.util.List;

import dao.PrestamoDao;
import daoImp.PrestamoDaoImp;
import entidades.Prestamo;
import negocio.PrestamoNegocio;

public class PrestamoNegocioImp implements PrestamoNegocio{

	PrestamoDao pdao = new PrestamoDaoImp();

	@Override
	public List<Prestamo> readAll() {
		return pdao.readAll();
	}

}
