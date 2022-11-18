package daoImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	private Movimiento get(ResultSet resultSet) throws SQLException {
		Movimiento m = new Movimiento();
		TipoMovimiento tm = new TipoMovimiento();
		
		m.setNro_Movimiento(resultSet.getInt("Nro_Movimiento"));
		m.setNro_Cuenta(resultSet.getInt("Nro_cuenta"));
		m.setFecha(resultSet.getString("Fecha"));
		tm.setDescripcion("tiposmovimientos.Descripcion");
		m.setTipo_Mov(tm);
		m.setImporte(resultSet.getFloat("Importe"));
		m.setDetalle(resultSet.getString("Detalle"));

		return m;
	}


}
