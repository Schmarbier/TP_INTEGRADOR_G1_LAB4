package negocioImp;

import dao.ClienteDao;
import daoImp.ClienteDaoImp;
import entidades.Cliente;
import negocio.ClienteNegocio;

public class ClienteNegocioImp implements ClienteNegocio{

	ClienteDao cdao = new ClienteDaoImp();
	
	@Override
	public boolean insert(Cliente cli) {
		/*if(cdao.existeDni(cli)==true) return false;
		else*/ return cdao.insert(cli);
	}

	@Override
	public boolean delete(Cliente cli) {
		if(cdao.existeDni(cli)==false) return false;
		else return cdao.delete(cli);
	}
	
	public int obtenerProxId() {
		return cdao.obtenerProxId();
	}

}
