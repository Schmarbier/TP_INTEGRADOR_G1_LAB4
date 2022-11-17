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
import entidades.Prestamo;

public class PrestamoDaoImp implements PrestamoDao{

	private static final String solicitudes = "SELECT * FROM prestamos WHERE Est_prestamo = 3";
	private static final String prestamos = "SELECT * FROM prestamos";
	private static final String respuesta = "UPDATE prestamos SET Est_prestamo = ?  WHERE Nro_prestamo = ?";


	@Override
	public List<Prestamo> SolicitudesPrestamos() {
		PreparedStatement Statement;
		ResultSet resultSet;
		ArrayList<Prestamo> ListaPrestamos = new ArrayList<Prestamo>();
		Conexion conexion = Conexion.getConexion();
		
		try {
			Statement = conexion.getSQLConexion().prepareStatement(solicitudes);
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
	public List<Prestamo> Prestamos() {
		PreparedStatement Statement;
		ResultSet resultSet;
		ArrayList<Prestamo> ListaPrestamos = new ArrayList<Prestamo>();
		Conexion conexion = Conexion.getConexion();
		
		try {
			Statement = conexion.getSQLConexion().prepareStatement(prestamos);
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
			statement.setInt(1, p.getEst_prestamo());
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
			Query = "SELECT * FROM prestamos WHERE Est_prestamo = 3 AND " + 
					"Nro_prestamo LIKE '%" + filtro + "%' or " + 
					"Nro_cliente LIKE '%" + filtro + "%' or " + 
					"Fecha LIKE '%" + filtro + "%' or " + 
					"Imp_con_intereses LIKE '%" + filtro + "%' or " + 
					"Imp_solicitado LIKE '%" + filtro + "%' or " + 
					"Nro_cuenta_deposito LIKE '%" + filtro + "%' or " + 
					"Plazo_pago_meses LIKE '%" + filtro + "%' or " + 
					"Monto_pago_por_mes LIKE '%" + filtro + "%' or " + 
					"Cant_cuotas LIKE '%" + filtro + "%'";
		}
		else {
			Query = "SELECT * FROM prestamos WHERE Est_prestamo = 3 AND " + consulta + " LIKE '%" + filtro + "%'";
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
		Prestamo p = new Prestamo();
	    
	    p.setNro_prestamo(resultSet.getInt("Nro_prestamo"));
		c.setNro_Cliente(resultSet.getInt("Nro_cliente"));
		p.setNro_cliente(c);
		p.setFecha(resultSet.getString("Fecha"));
		p.setImp_con_intereses(resultSet.getFloat("Imp_con_intereses"));
		p.setImp_solicitado(resultSet.getFloat("Imp_solicitado"));
		p.setNro_cuenta_deposito(resultSet.getString("Nro_cuenta_deposito"));
	    p.setPlazo_pago_meses(resultSet.getInt("Plazo_pago_meses"));
		p.setMonto_pago_por_mes(resultSet.getFloat("Monto_pago_por_mes"));
	    p.setMonto_pago_por_mes(resultSet.getInt("Cant_cuotas"));
	    
	    return p;
	}
}
