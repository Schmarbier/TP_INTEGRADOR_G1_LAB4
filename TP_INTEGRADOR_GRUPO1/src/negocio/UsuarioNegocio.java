package negocio;

import entidades.Usuario;

public interface UsuarioNegocio {

	public boolean existeNombreUsuario(Usuario usu);
	public boolean delete(Usuario usu);
	public boolean existeUsuario(Usuario usu);
	public boolean esAdmin(Usuario usu);
}
