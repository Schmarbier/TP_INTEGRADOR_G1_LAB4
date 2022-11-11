package negocio;

import java.util.ArrayList;

import entidades.Cliente;

public interface ClienteNegocio {

	public boolean insert(Cliente cli);
	public boolean delete(Cliente cli);
	public int obtenerProxId();
	
    public ArrayList<Cliente> MostrarTodos();
	public ArrayList<Cliente> LeerSegunNombre(String User);

	
}
