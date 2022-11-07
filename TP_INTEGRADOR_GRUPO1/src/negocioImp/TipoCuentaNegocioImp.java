package negocioImp;

import java.util.List;

import dao.TipoCuentaDao;
import daoImp.TipoCuentaDaoImp;
import entidades.TipoCuenta;
import negocio.TipoCuentaNegocio;

public class TipoCuentaNegocioImp implements TipoCuentaNegocio{

	TipoCuentaDao tcdao = new TipoCuentaDaoImp();
	
	@Override
	public List<TipoCuenta> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
