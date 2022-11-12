package dao;

import entidades.Usuario;

public interface UsuarioDao {

	public boolean insert(Usuario usu);
	public boolean delete(Usuario usu);
	public boolean existeUsuario(Usuario usu);
	public boolean esAdmin(Usuario usu);
	
}
