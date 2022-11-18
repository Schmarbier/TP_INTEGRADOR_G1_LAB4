package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.PrestamoDao;
import entidades.Cliente;
import entidades.EstadosPrestamo;
import entidades.Prestamo;

public class PrestamoDaoImp implements PrestamoDao{

	private static final String prestamos = "SELECT prestamos.Nro_prestamo, prestamos.Nro_cliente, prestamos.Fecha, prestamos.Imp_con_intereses, prestamos.Imp_solicitado, prestamos.Nro_cuenta_deposito, prestamos.Plazo_pago_meses, prestamos.Monto_pago_por_mes, prestamos.Cant_cuotas, estadosPrestamos.Descripcion FROM prestamos INNER JOIN estadosPrestamos ON prestamos.Est_prestamo = estadosPrestamos.Est_prestamo WHERE prestamos.Est_prestamo = ?";
	private static final String readAll = "SELECT prestamos.Nro_prestamo, prestamos.Nro_cliente, prestamos.Fecha, prestamos.Imp_con_intereses, prestamos.Imp_solicitado, prestamos.Nro_cuenta_deposito, prestamos.Plazo_pago_meses, prestamos.Monto_pago_por_mes, prestamos.Cant_cuotas, estadosPrestamos.Descripcion FROM prestamos INNER JOIN estadosPrestamos ON prestamos.Est_prestamo = estadosPrestamos.Est_prestamo WHERE prestamos.Est_prestamo = 1 OR prestamos.Est_prestamo = 2";
	private static final String respuesta = "UPDATE prestamos SET Est_prestamo = ?  WHERE Nro_prestamo = ?";

	
	@Override
	public List<Prestamo> Prestamos(Prestamo p) {
		PreparedStatement Statement;
		ResultSet resultSet;
		ArrayList<Prestamo> ListaPrestamos = new ArrayList<Prestamo>();
		Conexion conexion = Conexion.getConexion();
		
		try {
			Statement = conexion.getSQLConexion().prepareStatement(prestamos);
			Statement.setInt(1, p.getEst_prestamo().getEst_prestamo());
			resultSet = Statement.executeQuery();
			while(resultSet.next()) {
				ListaPrestamos.add(get(resultSet));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ListaPrestamos;
	}
	
	@Override
	public List<Prestamo> readAll() {
		PreparedStatement Statement;
		ResultSet resultSet;
		ArrayList<Prestamo> ListaPrestamos = new ArrayList<Prestamo>();
		Conexion conexion = Conexion.getConexion();
		
		try {
			Statement = conexion.getSQLConexion().prepareStatement(readAll);
			resultSet = Statement.executeQuery();
			while(resultSet.next()) {
				ListaPrestamos.add(get(resultSet));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ListaPrestamos;
	}

	@Override
	public boolean RespuestaSolicitud(Prestamo p) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean confirmacion = false;
		
		try {
			statement = conexion.prepareStatement(respuesta);
			statement.setInt(1, p.getEst_prestamo().getEst_prestamo());
			statement.setInt(2, p.getNro_prestamo());
			
			if(statement.executeUpdate()>0){
				conexion.commit();
				confirmacion = true;
			}
		}
		catch( SQLException e) {
			e.printStackTrace();
		}
		
		return confirmacion;
	}
	
   @Override
   public ArrayList<Prestamo> obtenerPrestamosQueryCustom(String consulta, String filtro) {
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ArrayList<Prestamo> lista = new ArrayList<Prestamo>();
		String Query = "";
		
		if(consulta.equals("Todo") && filtro.equals("")) {
			Query = "SELECT prestamos.Nro_prestamo, prestamos.Nro_cliente, prestamos.Fecha, prestamos.Imp_con_intereses, prestamos.Imp_solicitado, prestamos.Nro_cuenta_deposito, prestamos.Plazo_pago_meses, prestamos.Monto_pago_por_mes, prestamos.Cant_cuotas, estadosPrestamos.Descripcion FROM prestamos INNER JOIN estadosPrestamos ON prestamos.Est_prestamo = estadosPrestamos.Est_prestamo WHERE prestamos.Est_prestamo = 3 AND " + 
					"prestamos.Nro_prestamo LIKE '%" + filtro + "%' or " + 
					"prestamos.Nro_cliente LIKE '%" + filtro + "%' or " + 
					"prestamos.Fecha LIKE '%" + filtro + "%' or " + 
					"prestamos.Imp_con_intereses LIKE '%" + filtro + "%' or " + 
					"prestamos.Imp_solicitado LIKE '%" + filtro + "%' or " + 
					"prestamos.Nro_cuenta_deposito LIKE '%" + filtro + "%' or " + 
					"prestamos.Plazo_pago_meses LIKE '%" + filtro + "%' or " + 
					"prestamos.Monto_pago_por_mes LIKE '%" + filtro + "%' or " + 
					"prestamos.Cant_cuotas LIKE '%" + filtro + "%'";
		}
		else {
			Query = "SELECT prestamos.Nro_prestamo, prestamos.Nro_cliente, prestamos.Fecha, prestamos.Imp_con_intereses, prestamos.Imp_solicitado, prestamos.Nro_cuenta_deposito, prestamos.Plazo_pago_meses, prestamos.Monto_pago_por_mes, prestamos.Cant_cuotas, estadosPrestamos.Descripcion FROM prestamos INNER JOIN estadosPrestamos ON prestamos.Est_prestamo = estadosPrestamos.Est_prestamo WHERE prestamos.Est_prestamo = 3 AND " + consulta + " LIKE '%" + filtro + "%'";
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

	private Prestamo get(ResultSet resultSet) throws SQLException
	{
		Cliente c = new Cliente();
		EstadosPrestamo ep = new EstadosPrestamo();
		Prestamo p = new Prestamo();
	    
	    p.setNro_prestamo(resultSet.getInt("prestamos.Nro_prestamo"));
		c.setNro_Cliente(resultSet.getInt("prestamos.Nro_cliente"));
		p.setNro_cliente(c);
		p.setFecha(resultSet.getString("prestamos.Fecha"));
		p.setImp_con_intereses(resultSet.getFloat("prestamos.Imp_con_intereses"));
		p.setImp_solicitado(resultSet.getFloat("prestamos.Imp_solicitado"));
		p.setNro_cuenta_deposito(resultSet.getInt("prestamos.Nro_cuenta_deposito"));
	    p.setPlazo_pago_meses(resultSet.getInt("prestamos.Plazo_pago_meses"));
		p.setMonto_pago_por_mes(resultSet.getFloat("prestamos.Monto_pago_por_mes"));
	    p.setCant_cuotas(resultSet.getInt("prestamos.Cant_cuotas"));
	    ep.setDescripcion(resultSet.getString("estadosPrestamos.Descripcion"));
	    p.setEst_prestamo(ep);
	    
	    return p;
	}
}
