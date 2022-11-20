package negocioImp;

import java.util.ArrayList;

import dao.CuentaDao;
import daoImp.CuentaDaoImp;
import entidades.Cuenta;
import negocio.CuentaNegocio;

public class CuentaNegocioImp implements CuentaNegocio{

	private CuentaDao cdao = new CuentaDaoImp();	
	
	@Override
	public ArrayList<Cuenta> obtenerCuentas() {
		ArrayList <Cuenta> lista = cdao.obtenerCuentas();
		return lista;
	}

	@Override
	public ArrayList<Cuenta> obtenerCuentaQueryCustom(String consulta, String filtro) {
		return cdao.obtenerCuentaQueryCustom(consulta, filtro);
	}

	@Override
	public int insert(Cuenta cu) {
		return cdao.insert(cu);
	}

	@Override
	public boolean delete(Cuenta cu) {
		return cdao.delete(cu);
	}

	@Override
	public boolean update(Cuenta cu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cuenta get(Cuenta cu) {
		return cdao.get(cu);
	}

	public ArrayList<Cuenta> obtenerCuentaPorNr_cuenta(String numero) {
		return cdao.obtenerCuentaPorNr_cuenta(numero);
	}

	@Override
	public boolean modificarCuenta(Cuenta c) {
		return cdao.modificarCuenta(c);
	}

	@Override
	public int totalCuentasPorCliente(int nroCliente) {
		return cdao.totalCuentasPorCliente(nroCliente);
	}
}
