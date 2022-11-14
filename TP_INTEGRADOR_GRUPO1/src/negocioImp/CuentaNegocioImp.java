package negocioImp;

import java.util.ArrayList;

import daoImp.CuentaDaoImp;
import entidades.Cuenta;
import negocio.CuentaNegocio;

public class CuentaNegocioImp implements CuentaNegocio{

	private CuentaDaoImp dao = new CuentaDaoImp();
	
	@Override
	public ArrayList<Cuenta> obtenerCuentas() {
		ArrayList <Cuenta> lista = dao.obtenerCuentas();
		return lista;
	}

	@Override
	public ArrayList<Cuenta> obtenerCuentaQueryCustom(String consulta, String filtro) {
		return dao.obtenerCuentaQueryCustom(consulta, filtro);
	}

	@Override
	public ArrayList<Cuenta> obtenerCuentaPorNr_cuenta(String numero) {
		return dao.obtenerCuentaPorNr_cuenta(numero);
	}

	@Override
	public boolean modificarCuenta(Cuenta c) {
		return dao.modificarCuenta(c);
	}

}
