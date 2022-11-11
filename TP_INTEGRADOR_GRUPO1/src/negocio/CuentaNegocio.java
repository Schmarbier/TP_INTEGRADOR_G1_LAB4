package negocio;

import java.util.ArrayList;

import entidades.Cuenta;

public interface CuentaNegocio {
	
	public ArrayList<Cuenta> obtenerCuentas();
	
	public ArrayList<Cuenta> obtenerCuentaQueryCustom(String consulta, String filtro);
	
}
