package daoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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

}
