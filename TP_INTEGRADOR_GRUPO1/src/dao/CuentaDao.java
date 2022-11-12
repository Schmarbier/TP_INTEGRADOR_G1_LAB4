package dao;

import java.util.ArrayList;

import entidades.Cuenta;

public interface CuentaDao {
	
	public ArrayList<Cuenta> obtenerCuentas();
	
	public ArrayList<Cuenta> obtenerCuentaQueryCustom(String consulta, String filtro);
}
