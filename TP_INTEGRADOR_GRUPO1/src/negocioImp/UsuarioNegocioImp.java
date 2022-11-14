package negocioImp;

import dao.UsuarioDao;
import daoImp.UsuarioDaoImp;
import entidades.Usuario;
import negocio.UsuarioNegocio;

public class UsuarioNegocioImp implements UsuarioNegocio{

	UsuarioDao udao = new UsuarioDaoImp();
	
	@Override
	public boolean existeNombreUsuario(Usuario usu) {
        return udao.existeNombreUsuario(usu);
	}

	@Override
	public boolean delete(Usuario usu) {
		return udao.delete(usu);
	}

	@Override
	public boolean existeUsuario(Usuario usu) {
		return udao.existeUsuario(usu);
	}

	@Override
	public boolean esAdmin(Usuario usu) {
		return udao.esAdmin(usu);
	}

}
