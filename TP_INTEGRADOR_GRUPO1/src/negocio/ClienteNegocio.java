package negocio;

import entidades.Cliente;

public interface ClienteNegocio {

	public boolean insert(Cliente cli);
	public boolean delete(Cliente cli);
	public Integer obtenerProxId();
	
}
