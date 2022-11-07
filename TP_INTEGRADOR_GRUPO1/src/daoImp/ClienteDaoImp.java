package daoImp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.ClienteDao;
import entidades.Cliente;

public class ClienteDaoImp implements ClienteDao{

	private static final String insert = "INSERT INTO clientes (Nro_Cliente, Dni, Cuil, Nombre, Apellido, Cod_Genero, Cod_nacionalidad, Fecha_nac, Direccion, Cod_localidad, Cod_provincia, Email, Usuario, Estado) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM clientes WHERE Nro_Cliente = ?";
	
	@Override
	public boolean insert(Cliente cli) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, cli.getNro_Cliente());
			statement.setInt(2, cli.getDni());
			statement.setInt(3, cli.getCuil());
			statement.setString(4, cli.getNombre());
			statement.setString(5, cli.getApellido());
			statement.setInt(6, cli.getCod_Genero().getCod_genero());
			statement.setInt(7, cli.getCod_nacionalidad().getCod_nacionalidad());	
			statement.setDate(8, (Date) cli.getFecha_nac());
			statement.setString(9, cli.getDireccion());
			statement.setInt(10, cli.getCod_localidad().getCod_localidad());
			statement.setInt(11, cli.getCod_provincia().getCod_provincia());
			statement.setString(12, cli.getEmail());
			statement.setString(13, cli.getUsuario().getUsuario());
			statement.setBoolean(14, cli.getEstado());
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
		return isInsertExitoso;
	}
	
	@Override
	public boolean delete(Cliente cli) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setInt(1, cli.getNro_Cliente());
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
	
}
