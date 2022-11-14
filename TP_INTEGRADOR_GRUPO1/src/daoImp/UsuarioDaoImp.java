package daoImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UsuarioDao;
import entidades.Usuario;

public class UsuarioDaoImp implements UsuarioDao{
	
	@Override
	public boolean existeNombreUsuario(Usuario usu) {
		PreparedStatement statement;
		ResultSet resultSet; 
		Conexion conexion = Conexion.getConexion();
		boolean existeUsuario = false;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement("SELECT * FROM usuarios WHERE usuario = ?");
			statement.setString(1, usu.getUsuario());
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
	public boolean existeUsuario(Usuario us) {
		PreparedStatement statement;
		ResultSet resultSet; 
		Conexion conexion = Conexion.getConexion();
		boolean existeUsuario = false;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement("SELECT * FROM usuarios WHERE usuario = ? AND Contraseña = ? AND Estado = 1");
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
			statement = conexion.getSQLConexion().prepareStatement("SELECT * FROM usuarios WHERE usuario = ? AND Contraseña = ? AND Tipo_Us = 1");
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
