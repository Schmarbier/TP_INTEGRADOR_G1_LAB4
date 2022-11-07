package negocioImp;

import dao.ClienteDao;
import daoImp.ClienteDaoImp;
import entidades.Cliente;
import negocio.ClienteNegocio;

public class ClienteNegocioImp implements ClienteNegocio{

	ClienteDao pdao = new ClienteDaoImp();
	
	@Override
	public boolean insert(Cliente cli) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Cliente cli) {
		// TODO Auto-generated method stub
		return false;
	}

}
