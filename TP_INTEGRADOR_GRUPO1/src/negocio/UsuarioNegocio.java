package negocio;

import entidades.Usuario;

public interface UsuarioNegocio {

	public boolean insert(Usuario usu);
	public boolean delete(Usuario usu);
	public boolean existeUsuario(Usuario usu);
}
