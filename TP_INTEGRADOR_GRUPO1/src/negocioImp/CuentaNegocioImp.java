package negocioImp;

import java.util.ArrayList;

import dao.ClienteDao;
import dao.CuentaDao;
import daoImp.ClienteDaoImp;
import daoImp.CuentaDaoImp;
import entidades.Cuenta;
import negocio.CuentaNegocio;

public class CuentaNegocioImp implements CuentaNegocio{

	private CuentaDaoImp dao;

	CuentaDao cdao = new CuentaDaoImp();	
	
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
	public int insert(Cuenta cu) {
		return cdao.insert(cu);
	}

	@Override
	public boolean delete(Cuenta cu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Cuenta cu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cuenta get(Cuenta cu) {
		// TODO Auto-generated method stub
		return null;
	}

}
