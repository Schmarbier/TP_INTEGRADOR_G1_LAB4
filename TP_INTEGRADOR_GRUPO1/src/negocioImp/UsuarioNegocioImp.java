package negocioImp;

import dao.UsuarioDao;
import daoImp.UsuarioDaoImp;
import entidades.Usuario;
import negocio.UsuarioNegocio;

public class UsuarioNegocioImp implements UsuarioNegocio{

	UsuarioDao udao = new UsuarioDaoImp();
	
	@Override
	public boolean insert(Usuario usu) {
		if(udao.existeUsuario(usu)==true) return false;
		else return udao.insert(usu);
	}

	@Override
	public boolean delete(Usuario usu) {
		return udao.delete(usu);
	}

	@Override
	public boolean existeUsuario(Usuario usu) {
		return udao.existeUsuario(usu);
	}

}
