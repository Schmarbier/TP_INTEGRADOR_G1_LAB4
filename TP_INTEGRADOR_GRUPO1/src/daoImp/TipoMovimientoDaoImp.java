package daoImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.TipoMovimientoDao;
import entidades.TipoMovimiento;

public class TipoMovimientoDaoImp implements TipoMovimientoDao{

	private static final String readall = "SELECT * FROM tiposMovimientos";

	@Override
	public List<TipoMovimiento> readAll() {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<TipoMovimiento> list = new ArrayList<TipoMovimiento>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
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

	private TipoMovimiento get(ResultSet resultSet) throws SQLException
	{
		int Tipo_movimiento = resultSet.getInt("Tipo_mov");
		String descripcion = resultSet.getString("Descripcion");
		return new TipoMovimiento(Tipo_movimiento, descripcion);
	}

}
