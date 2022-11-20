package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.MovimientoDao;
import entidades.Movimiento;
import entidades.TipoMovimiento;

public class MovimientoDaoImp implements MovimientoDao{

	private static final String readAll = "SELECT * FROM vistaMovimientos";
	
	@Override
	public List<Movimiento> readAll() {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Movimiento> list = new ArrayList<Movimiento>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readAll);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				list.add(get(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public int dineroTotal() {
		Integer dinero = 0;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		PreparedStatement statement;
		
		try
		{
			statement = conexion.prepareStatement("SELECT SUM(Saldo) From cuentas WHERE Estado = 1");
			ResultSet resultado = statement.executeQuery();
			resultado.next();
			dinero = resultado.getInt(1);
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
		return dinero;
	}
	
	private Movimiento get(ResultSet resultSet) throws SQLException {
		Movimiento m = new Movimiento();
		TipoMovimiento tm = new TipoMovimiento();
		
		m.setNro_Movimiento(resultSet.getInt("Nro_Movimiento"));
		m.setNro_Cuenta(resultSet.getInt("Nro_cuenta"));
		m.setFecha(resultSet.getString("Fecha"));
		tm.setDescripcion(resultSet.getString("Descripcion"));
		m.setTipo_Mov(tm);
		m.setImporte(resultSet.getFloat("Importe"));
		m.setDetalle(resultSet.getString("Detalle"));

		return m;
	}

	@Override
	public List<Movimiento> movimientoXfecha(String fecha1, String fecha2, String filtro) {
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ArrayList<Movimiento> lista = new ArrayList<Movimiento>();
		String Query = "";
		
		if(filtro.toString()!= "Todo") {
			if(fecha1.length() != 0 && fecha2.length() != 0) Query = "SELECT * FROM vistaMovimientos WHERE Tipo_mov = " + filtro + " AND Fecha BETWEEN '"+ fecha1 +"' AND '"+ fecha2 +"'";
			else Query = "SELECT * FROM vistaMovimientos WHERE Tipo_mov = " + filtro + "";
		}
		if(filtro.equals("Todo")) {
			if(fecha1.length() != 0 && fecha2.length() != 0) Query = "SELECT * FROM vistaMovimientos WHERE Fecha BETWEEN '"+ fecha1 +"' AND '"+ fecha2 +"'";
			else Query = "SELECT * FROM vistaMovimientos";
		}

		try{
			ResultSet rs = null;

			Statement st = conexion.createStatement();
			rs = st.executeQuery(Query);

			// Cargo lista
			while(rs.next()){
				lista.add(get(rs));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return lista;
	}


}
