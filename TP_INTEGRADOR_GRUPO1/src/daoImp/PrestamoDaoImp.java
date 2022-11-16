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
				Cliente c = new Cliente();
				
			    int Nro_Prestamo = resultSet.getInt(1);
				c.setNro_Cliente(resultSet.getInt(2));
				String Fecha = resultSet.getString(3);
				Float Imp_con_intereses = resultSet.getFloat(4);
				Float Imp_solicitado = resultSet.getFloat(5);
				String Nro_cuenta_deposito = resultSet.getString(6);
			    int Plazo_pago_meses = resultSet.getInt(7);
				Float Monto_pago_por_mes = resultSet.getFloat(8);
			    int Cant_cuotas = resultSet.getInt(9);
			    
				Prestamo prestamo = new Prestamo(Nro_Prestamo,c,Fecha,Imp_con_intereses,Imp_solicitado,Nro_cuenta_deposito,Plazo_pago_meses,Monto_pago_por_mes,Cant_cuotas);
				ListaPrestamos.add(prestamo);
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
		
		if(consulta.equals("Todo")) {
			Query = "SELECT Nro_prestamo, Nro_cliente, Fecha, Imp_con_intereses, Imp_solicitado, Nro_cuenta_deposito, Plazo_pago_meses " + 
					"Monto_pago_por_mes, Cant_cuotas FROM prestamo " + 
					"WHERE Est_prestamo = 3 AND " + 
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
			Query = "SELECT Nro_prestamo, Nro_cliente, Fecha, Imp_con_intereses, Imp_solicitado, Nro_cuenta_deposito, Plazo_pago_meses, Monto_pago_por_mes, Cant_cuotas  FROM prestamos WHERE Est_prestamo = 3 AND " + consulta + " LIKE '%" + filtro + "%'";
		}

		try{
			ResultSet rs = null;

			Statement st = conexion.createStatement();
			rs = st.executeQuery(Query);

			// Cargo lista
			while(rs.next()){
				Prestamo prestamo = new Prestamo();
				Cliente c = new Cliente();
				c.setNro_Cliente(rs.getInt("Nro_cliente"));
						
				prestamo.setNro_prestamo(rs.getInt("Nro_cliente"));
				prestamo.setNro_cliente(c);
				prestamo.setFecha(rs.getString("Fecha_creacion"));
				prestamo.setImp_con_intereses(rs.getFloat("Fecha_creacion"));
				prestamo.setImp_solicitado(rs.getFloat("Fecha_creacion"));
				prestamo.setNro_cuenta_deposito(rs.getString("Fecha_creacion"));
				prestamo.setPlazo_pago_meses(rs.getInt("Nro_cliente"));
				prestamo.setMonto_pago_por_mes(rs.getFloat("Fecha_creacion"));
				prestamo.setCant_cuotas(rs.getInt("Nro_cliente"));
				
				lista.add(prestamo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		
		return lista;
	}

}
