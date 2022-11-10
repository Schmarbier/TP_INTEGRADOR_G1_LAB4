package negocioImp;

import java.util.ArrayList;

import daoImp.CuentaDaoImp;
import entidades.Cuenta;
import negocio.CuentaNegocio;

public class CuentaNegocioImp implements CuentaNegocio{

	private CuentaDaoImp dao;
	
	@Override
	public ArrayList<Cuenta> obtenerCuentas() {
		return dao.obtenerCuentas();
	}

}
