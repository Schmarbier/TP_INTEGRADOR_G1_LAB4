package negocioImp;

import dao.UsuarioDao;
import daoImp.UsuarioDaoImp;
import entidades.Usuario;
import negocio.UsuarioNegocio;

public class UsuarioNegocioImp implements UsuarioNegocio{

	UsuarioDao udao = new UsuarioDaoImp();
	
	@Override
	public boolean insert(Usuario usu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Usuario usu) {
		// TODO Auto-generated method stub
		return false;
	}

}
