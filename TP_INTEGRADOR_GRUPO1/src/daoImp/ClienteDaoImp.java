package daoImp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ClienteDao;
import entidades.Cliente;

public class ClienteDaoImp implements ClienteDao{

	private static final String insert = "INSERT INTO clientes (Nro_Cliente, Dni, Cuil, Nombre, Apellido, Cod_Genero, Cod_nacionalidad, Fecha_nac, Direccion, Cod_localidad, Cod_provincia, Email, Telefono, Usuario, Estado) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "UPDATE clientes SET Estado = false  WHERE Dni = ?";
	
	@Override
	public boolean insert(Cliente cli) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, cli.getDni());
			statement.setInt(2, cli.getCuil());
			statement.setString(3, cli.getNombre());
			statement.setString(4, cli.getApellido());
			statement.setInt(5, cli.getCod_Genero().getCod_genero());
			statement.setInt(6, cli.getCod_nacionalidad().getCod_nacionalidad());	
			statement.setDate(7, (Date) cli.getFecha_nac());
			statement.setString(8, cli.getDireccion());
			statement.setInt(9, cli.getCod_localidad().getCod_localidad());
			statement.setInt(10, cli.getCod_provincia().getCod_provincia());
			statement.setString(11, cli.getEmail());
			statement.setString(12, cli.getTelefono());
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
			statement.setInt(1, cli.getDni());
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
	
	public Integer obtenerProxId() {
		Integer maxSeguro = -1;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		PreparedStatement statement;
		
		try
		{
			statement = conexion.prepareStatement("SELECT MAX (Nro_Cliente) FROM clientes");
			ResultSet resultado = statement.executeQuery();
			resultado.next();
			maxSeguro = resultado.getInt(1);
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
		return maxSeguro;
	}
	
	@Override
	public boolean existeDni(Cliente cli) {
		PreparedStatement statement;
		ResultSet resultSet; 
		Conexion conexion = Conexion.getConexion();
		boolean existeCliente = false;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement("SELECT * FROM clientes WHERE dni = ?");
			statement.setInt(1, cli.getDni());
			resultSet = statement.executeQuery();
			if(resultSet.next()) existeCliente = true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return existeCliente;
	}
	
	@Override
	public boolean existeUsuario(Cliente cli) {
		PreparedStatement statement;
		ResultSet resultSet; 
		Conexion conexion = Conexion.getConexion();
		boolean existeUsuario = false;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement("SELECT * FROM clientes WHERE usuario = ?");
			statement.setString(1, cli.getUsuario().getUsuario());
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
