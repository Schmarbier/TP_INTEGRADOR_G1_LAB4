package negocioImp;

import java.util.ArrayList;

import daoImp.CuentaDaoImp;
import entidades.Cuenta;
import negocio.CuentaNegocio;

public class CuentaNegocioImp implements CuentaNegocio{

	private CuentaDaoImp dao;
	
	@Override
	public ArrayList<Cuenta> obtenerCuentas() {
		ArrayList <Cuenta> lista = dao.obtenerCuentas();
		return lista;
	}

	@Override
	public ArrayList<Cuenta> obtenerCuentaQueryCustom(String consulta, String filtro) {
		return dao.obtenerCuentaQueryCustom(consulta, filtro);
	}

}
