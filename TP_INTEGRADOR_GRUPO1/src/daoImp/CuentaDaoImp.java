package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.CallableStatement;

import dao.CuentaDao;
import entidades.Cuenta;
import entidades.TipoCuenta;

public class CuentaDaoImp implements CuentaDao {

	private static final String modificar = "update cuentas SET Nro_cliente = ?, Fecha_creacion = ?, Tipo_cuenta = ?, Cbu = ?, Saldo = ? WHERE Nro_cuenta = ?";
	
	private static final String delete = "UPDATE cuentas SET Estado = 0  WHERE Nro_cuenta = ?";
	
	
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
				cuenta.setFecha_creacion(rs.getString("Fecha_creacion"));
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
		
		if(consulta.equals("todo")) {
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
		System.out.println(consulta);
		try{
			ResultSet rs = null;

			Statement st = conexion.createStatement();
			rs = st.executeQuery(Query);

			// Cargo lista
			while(rs.next()){
				Cuenta cuenta = new Cuenta();
				cuenta.setNro_cuenta(rs.getInt("Nro_cuenta"));
				cuenta.setNro_cliente(rs.getInt("Nro_cliente"));
				cuenta.setFecha_creacion(rs.getString("Fecha_creacion"));
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
	public ArrayList<Cuenta> obtenerCuentaPorNr_cuenta(String numero) {
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		ArrayList<Cuenta> lista = new ArrayList<Cuenta>();
		
		try{
			ResultSet rs = null;

			Statement st = conexion.createStatement();
			rs = st.executeQuery("SELECT a.Nro_cuenta, a.Nro_cliente, a.Fecha_creacion, a.Tipo_cuenta, b.Descripcion, a.Cbu, a.Saldo from cuentas as a inner join tiposcuentas as b on a.Tipo_cuenta = b.Tipo_cuenta where Nro_cuenta = " + numero);

			// Cargo lista
			while(rs.next()){
				Cuenta cuenta = new Cuenta();
				cuenta.setNro_cuenta(rs.getInt("Nro_cuenta"));
				cuenta.setNro_cliente(rs.getInt("Nro_cliente"));
				cuenta.setFecha_creacion(rs.getString("Fecha_creacion"));
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
	public boolean modificarCuenta(Cuenta c) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(modificar);
			statement.setInt(1, c.getNro_cliente());
			statement.setString(2, c.getFecha_creacion());
			statement.setInt(3, c.getTipo_cuenta().getTipo_cuenta());
			statement.setString(4, c.getCbu());
			statement.setFloat(5, c.getSaldo());
			statement.setInt(6, c.getNro_cuenta());	
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		System.out.println(isInsertExitoso);
		return isInsertExitoso;
	}
	
	@Override
	public int insert(Cuenta cu) {
		int nroCuenta = -1;
        String QUERY = "{CALL spAltaCuenta(?,?,?,?,?)}";

        Connection conexion = Conexion.getConexion().getSQLConexion();
		try
		{
			PreparedStatement statement = conexion.prepareStatement(QUERY);
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
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setInt(1, cu.getNro_cuenta());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}

	@Override
	public boolean update(Cuenta cu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cuenta get(Cuenta cu) {
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		Cuenta cuenta = new Cuenta();
		
		try{
			ResultSet rs = null;

			Statement st = conexion.createStatement();
			rs = st.executeQuery(
				"SELECT a.Nro_cuenta, a.Nro_cliente, a.Fecha_creacion, a.Tipo_cuenta, b.Descripcion, a.Cbu, a.Saldo " +
				"from cuentas as a inner join tiposcuentas as b on a.Tipo_cuenta = b.Tipo_cuenta " + 
				"where Estado = 1 and Nro_cuenta = " + cu.getNro_cuenta());

			// Cargo lista
			if(rs.next()){
				cuenta.setNro_cuenta(rs.getInt("Nro_cuenta"));
				cuenta.setNro_cliente(rs.getInt("Nro_cliente"));
				cuenta.setFecha_creacion(rs.getString("Fecha_creacion"));
				cuenta.setTipo_cuenta(new TipoCuenta(rs.getInt("tipo_cuenta"),rs.getString("b.Descripcion")));
				cuenta.setCbu(rs.getString("Cbu"));
				cuenta.setSaldo(rs.getFloat("Saldo"));
			}
			else cuenta = null;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return cuenta;
	}

}
