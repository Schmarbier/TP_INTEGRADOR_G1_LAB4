package dao;

import entidades.Cliente;

public interface ClienteDao {
	
	public boolean insert(Cliente cli);
	public boolean delete(Cliente cli);
	public int obtenerProxId();
	public boolean existeDni(Cliente cli);
	
}
