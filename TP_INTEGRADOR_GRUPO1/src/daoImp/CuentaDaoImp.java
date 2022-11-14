package daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.CallableStatement;

import dao.CuentaDao;
import entidades.Cuenta;
import entidades.TipoCuenta;

public class CuentaDaoImp implements CuentaDao {

	@Override
	public ArrayList<Cuenta> obtenerCuentas() {
		
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		ArrayList<Cuenta> lista = new ArrayList<Cuenta>();
		
		try{
			ResultSet rs = null;

			Statement st = conexion.createStatement();
			rs = st.executeQuery("SELECT a.Nro_cuenta, a.Nro_cliente, a.Fecha_creacion, a.Tipo_cuenta, b.Descripcion, a.Cbu, a.Saldo from cuentas as a inner join tiposcuentas as b on a.Tipo_cuenta = b.Tipo_cuenta");

			// Cargo lista
			while(rs.next()){
				Cuenta cuenta = new Cuenta();
				cuenta.setNro_cuenta(rs.getInt("Nro_cuenta"));
				cuenta.setNro_cliente(rs.getInt("Nro_cliente"));
				cuenta.setFecha_creacion(rs.getDate("Fecha_creacion"));
				cuenta.setTipo_cuenta(new TipoCuenta(rs.getInt("tipo_cuenta"),rs.getString("b.Descripcion")));
				cuenta.setCbu(rs.getString("Cbu"));
				cuenta.setSaldo(rs.getFloat("Saldo"));
				lista.add(cuenta);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return lista;
	}
	
	public ArrayList<Cuenta> obtenerCuentaQueryCustom(String consulta, String filtro) {
		
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		ArrayList<Cuenta> lista = new ArrayList<Cuenta>();
		String Query = "";
		
		if(consulta == "todo") {
			Query = "SELECT a.Nro_cuenta, a.Nro_cliente, a.Fecha_creacion, a.Tipo_cuenta, b.Descripcion, a.Cbu, a.Saldo " + 
					"from cuentas as a inner join tiposcuentas as b on a.Tipo_cuenta = b.Tipo_cuenta " + 
					"WHERE " + 
					"a.Nro_cuenta LIKE '%" + filtro + "%' or " + 
					"a.Nro_cliente LIKE '%" + filtro + "%' or " + 
					"a.Fecha_creacion LIKE '%" + filtro + "%' or " + 
					"a.Tipo_cuenta LIKE '%" + filtro + "%' or " + 
					"b.Descripcion LIKE '%" + filtro + "%' or " + 
					"a.Cbu LIKE '%" + filtro + "%' or " + 
					"a.Saldo LIKE '%" + filtro + "%'";
		}
		else {
			Query = "SELECT a.Nro_cuenta, a.Nro_cliente, a.Fecha_creacion, a.Tipo_cuenta, b.Descripcion, a.Cbu, a.Saldo from cuentas as a inner join tiposcuentas as b on a.Tipo_cuenta = b.Tipo_cuenta WHERE " + consulta +" LIKE '%" + filtro + "%'";
		}
		
		System.out.println(Query);
		try{
			ResultSet rs = null;

			Statement st = conexion.createStatement();
			rs = st.executeQuery(Query);

			// Cargo lista
			while(rs.next()){
				Cuenta cuenta = new Cuenta();
				cuenta.setNro_cuenta(rs.getInt("Nro_cuenta"));
				cuenta.setNro_cliente(rs.getInt("Nro_cliente"));
				cuenta.setFecha_creacion(rs.getDate("Fecha_creacion"));
				cuenta.setTipo_cuenta(new TipoCuenta(rs.getInt("tipo_cuenta"),rs.getString("b.Descripcion")));
				cuenta.setCbu(rs.getString("Cbu"));
				cuenta.setSaldo(rs.getFloat("Saldo"));
				lista.add(cuenta);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return lista;
	}

	@Override
	public int insert(Cuenta cu) {
		int nroCuenta = -1;
        String QUERY = "{CALL spAltaCuenta(?,?,?,?,?)}";

		try(
			Connection conexion = Conexion.getConexion().getSQLConexion();
			CallableStatement statement = conexion.prepareCall(QUERY);
		)
		{
			statement.setInt(1, cu.getNro_cliente());
			statement.setInt(2, cu.getTipo_cuenta().getTipo_cuenta());
			statement.setString(3, cu.getCbu());
			statement.setFloat(4, cu.getSaldo());
			statement.setBoolean(5, cu.getEstado());

			// statement.execute();

			// En lugar de execute uso executeQuery para obtener el resulset 
			// que me devuelve el nroCuenta asignado o -1 en caso que falle
			ResultSet rs1 = statement.executeQuery();
			
			// Si devolvio algun mensaje de error entonces retorno falso
		    while(rs1.next()) {
		    	nroCuenta = rs1.getInt("NRO");
		    }			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return nroCuenta;
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
