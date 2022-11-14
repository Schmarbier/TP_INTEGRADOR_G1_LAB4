package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UsuarioDao;
import entidades.Usuario;

public class UsuarioDaoImp implements UsuarioDao{

	private static final String delete = "UPDATE usuarios SET Estado = 0  WHERE Usuario = ?";
	
	@Override
	public boolean existeNombreUsuario(Usuario us) {
		PreparedStatement statement;
		ResultSet resultSet; 
		Conexion conexion = Conexion.getConexion();
		boolean existeUsuario = false;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement("SELECT * FROM usuarios WHERE Usuario = ? AND Estado = 1");
			statement.setString(1, us.getUsuario());
			resultSet = statement.executeQuery();
			if(resultSet.next()) existeUsuario = true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return existeUsuario;
	}

	@Override
	public boolean delete(Usuario usu) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, usu.getUsuario());
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
	public boolean existeUsuario(Usuario us) {
		PreparedStatement statement;
		ResultSet resultSet; 
		Conexion conexion = Conexion.getConexion();
		boolean existeUsuario = false;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement("SELECT * FROM usuarios WHERE Usuario = ? AND Contraseña = ? AND Estado = 1");
			statement.setString(1, us.getUsuario());
			statement.setString(2, us.getContraseña());
			resultSet = statement.executeQuery();
			if(resultSet.next()) existeUsuario = true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return existeUsuario;
	}

	@Override
	public boolean esAdmin(Usuario usu) {
		PreparedStatement statement;
		ResultSet resultSet; 
		Conexion conexion = Conexion.getConexion();
		boolean existeUsuario = false;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement("SELECT * FROM usuarios WHERE Usuario = ? AND Contraseña = ? AND Tipo_Us = 1");
			statement.setString(1, usu.getUsuario());
			statement.setString(2, usu.getContraseña());
			resultSet = statement.executeQuery();
			if(resultSet.next()) existeUsuario = true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return existeUsuario;
	}

}
