package negocioImp;

import java.util.List;

import dao.NacionalidadDao;
import daoImp.NacionalidadDaoImp;
import entidades.Nacionalidad;
import negocio.NacionalidadNegocio;

public class NacionalidadNegocioImp implements NacionalidadNegocio{

	NacionalidadDao ndao = new NacionalidadDaoImp();
	
	@Override
	public List<Nacionalidad> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
