package negocioImp;

import java.util.List;

import dao.ProvinciaDao;
import daoImp.ProvinciaDaoImp;
import entidades.Provincia;
import negocio.ProvinciaNegocio;

public class ProvinciaNegocioImp implements ProvinciaNegocio{

	ProvinciaDao pdao = new ProvinciaDaoImp();
	
	@Override
	public List<Provincia> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
