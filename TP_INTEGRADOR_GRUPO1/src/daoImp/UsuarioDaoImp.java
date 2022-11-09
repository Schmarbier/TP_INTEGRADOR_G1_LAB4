package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UsuarioDao;
import entidades.Usuario;

public class UsuarioDaoImp implements UsuarioDao{

	private static final String insert = "INSERT INTO usuarios (Usuario, Tipo_Us, Contraseña, Estado) VALUES(?, ?, ?, ?)";
	private static final String delete = "UPDATE usuarios SET Estado = false  WHERE Usuario = ?";

	@Override
	public boolean insert(Usuario usu) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, usu.getUsuario());
			statement.setInt (2, usu.getTipo_Us().getTipo_us());
			statement.setString(3, usu.getContraseña());
			statement.setBoolean(4, usu.getEstado());
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
			statement = conexion.getSQLConexion().prepareStatement("SELECT * FROM usuarios WHERE usuario = ?");
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

}
