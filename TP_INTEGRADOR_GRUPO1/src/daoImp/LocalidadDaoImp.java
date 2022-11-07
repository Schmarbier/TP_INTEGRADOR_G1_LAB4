package daoImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.LocalidadDao;
import entidades.Localidad;
import entidades.Provincia;

public class LocalidadDaoImp implements LocalidadDao {

	private static final String readall = "SELECT * FROM localidades";
	
	@Override
	public List<Localidad> readAll() {
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Localidad> list = new ArrayList<Localidad>();
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
	
	private Localidad get(ResultSet resultSet) throws SQLException
	{
		Localidad loc = new Localidad();
		loc.setCod_provincia(new Provincia(resultSet.getInt("Cod_provincia"),resultSet.getString("Descripcion")));
		loc.setCod_localidad(resultSet.getInt("Cod_localidad"));
		loc.setDescripcion(resultSet.getString("Descripcion"));
		return loc;
	}

}
