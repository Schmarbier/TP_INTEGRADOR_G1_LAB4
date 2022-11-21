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

	private static final String aceptar = "{CALL spAprobarPrestamo(?)}";
	private static final String rechazar = "{CALL spRechazarPrestamo(?)}";
	private static final String solicitudes = "SELECT Nro_prestamo, fecha_dmy as fecha, Imp_con_intereses, Imp_solicitado, Nro_cuenta_deposito, Plazo_pago_meses, Monto_pago_por_mes, Cant_cuotas, Descripcion, Est_prestamo,Nro_cliente FROM vistaSolicitudes";
	private static final String readAll = "SELECT Nro_prestamo, fecha_dmy as fecha, Imp_con_intereses, Imp_solicitado, Nro_cuenta_deposito, Plazo_pago_meses, Monto_pago_por_mes, Cant_cuotas, Descripcion, Est_prestamo,Nro_cliente FROM vistaPrestamos"; 

	@Override
    public boolean aprobarPrestamo(Prestamo p) {
			boolean aprobado = false;
			Connection conexion = Conexion.getConexion().getSQLConexion();
			try
			{
				PreparedStatement statement = conexion.prepareStatement(aceptar);
				statement.setInt(1, p.getNro_prestamo());
				// En lugar de execute uso executeQuery para obtener el resulset que me devuelve en caso que falle
				// statement.execute();
				ResultSet rs1 = statement.executeQuery();
			    while(rs1.next()) {
			    	aprobado = true;
			    }			
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return aprobado;
    }
    
	@Override
    public boolean rechazarPrestamo(Prestamo p) {
			boolean rechazado = false;
			Connection conexion = Conexion.getConexion().getSQLConexion();
			try
			{
				PreparedStatement statement = conexion.prepareStatement(rechazar);
				statement.setInt(1, p.getNro_prestamo());
				// En lugar de execute uso executeQuery para obtener el resulset que me devuelve en caso que falle
				// statement.execute();
				ResultSet rs1 = statement.executeQuery();
			    while(rs1.next()) {
			    	rechazado = true;
			    }			
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return rechazado;
    }
	
	@Override
	public List<Prestamo> Solicitudes() {
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
   public ArrayList<Prestamo> obtenerPrestamosQueryCustom(String consulta, String filtro) {
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ArrayList<Prestamo> lista = new ArrayList<Prestamo>();
		String Query = "";
		
		if(filtro.length()!=0) {
			if(consulta.toString()!="Todo") Query = "SELECT Nro_prestamo, fecha_dmy as fecha, Imp_con_intereses, Imp_solicitado, Nro_cuenta_deposito, Plazo_pago_meses, Monto_pago_por_mes, Cant_cuotas, Descripcion, Est_prestamo,Nro_cliente FROM vistaSolicitudes WHERE " + consulta + " = '" + filtro + "'";
			else Query = "SELECT Nro_prestamo, fecha_dmy as fecha, Imp_con_intereses, Imp_solicitado, "+
			      "Nro_cuenta_deposito, Plazo_pago_meses, Monto_pago_por_mes, Cant_cuotas, Descripcion, "+
				  "Est_prestamo,Nro_cliente FROM vistaSolicitudes WHERE " + 
			     "(" +
			     "Nro_prestamo = " + filtro + " or " + 
			     "Nro_cliente = " + filtro + " or " + 
			     "fecha_dmy = '" + filtro + "' or " + 
			     "Imp_con_intereses = " + filtro + " or " + 
			     "Imp_solicitado = " + filtro + " or " + 
			     "Nro_cuenta_deposito = " + filtro + " or " + 
			     "Plazo_pago_meses = " + filtro + " or " +
			     "Monto_pago_por_mes = " + filtro + " or " +
			     "Cant_cuotas = " + filtro + " or " +
			     "Descripcion LIKE '%" + filtro + "%'" +
			      ")";
		}
		if(filtro.length() == 0 || consulta.toString()=="Todo") {
			Query = solicitudes;
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
	    
	    p.setNro_prestamo(resultSet.getInt("Nro_prestamo"));
		c.setNro_Cliente(resultSet.getInt("Nro_cliente"));
		p.setNro_cliente(c);
		p.setFecha(resultSet.getString("Fecha"));
		p.setImp_con_intereses(resultSet.getFloat("Imp_con_intereses"));
		p.setImp_solicitado(resultSet.getFloat("Imp_solicitado"));
		p.setNro_cuenta_deposito(resultSet.getInt("Nro_cuenta_deposito"));
	    p.setPlazo_pago_meses(resultSet.getInt("Plazo_pago_meses"));
		p.setMonto_pago_por_mes(resultSet.getFloat("Monto_pago_por_mes"));
	    p.setCant_cuotas(resultSet.getInt("Cant_cuotas"));
	    ep.setDescripcion(resultSet.getString("Descripcion"));
	    p.setEst_prestamo(ep);
	    
	    return p;
	}

	@Override
	public List<Prestamo> prestamoXfecha(String fecha1, String fecha2, String filtro) {
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ArrayList<Prestamo> lista = new ArrayList<Prestamo>();
		String Query = "";
		
		if(filtro.toString()!= "Todo") {
			if(fecha1.length() != 0 && fecha2.length() != 0) Query = "SELECT Nro_prestamo, fecha_dmy as fecha, Imp_con_intereses, Imp_solicitado, Nro_cuenta_deposito, Plazo_pago_meses, Monto_pago_por_mes, Cant_cuotas, Descripcion, Est_prestamo,Nro_cliente FROM vistaPrestamos WHERE Est_prestamo = " + filtro + " AND fecha_dmy BETWEEN '"+ fecha1 +"' AND '"+ fecha2 +"'";
			else Query = "SELECT Nro_prestamo, fecha_dmy as fecha, Imp_con_intereses, Imp_solicitado, Nro_cuenta_deposito, Plazo_pago_meses, Monto_pago_por_mes, Cant_cuotas, Descripcion, Est_prestamo,Nro_cliente FROM vistaPrestamos WHERE Est_prestamo = " + filtro + "";
		}
		if(filtro.equals("Todo")) {
			if(fecha1.length() != 0 && fecha2.length() != 0) Query = "SELECT Nro_prestamo, fecha_dmy as fecha, Imp_con_intereses, Imp_solicitado, Nro_cuenta_deposito, Plazo_pago_meses, Monto_pago_por_mes, Cant_cuotas, Descripcion, Est_prestamo,Nro_cliente FROM vistaPrestamos WHERE fecha_dmy BETWEEN '"+ fecha1 +"' AND '"+ fecha2 +"'";
			else Query = "SELECT Nro_prestamo, fecha_dmy as fecha, Imp_con_intereses, Imp_solicitado, Nro_cuenta_deposito, Plazo_pago_meses, Monto_pago_por_mes, Cant_cuotas, Descripcion, Est_prestamo,Nro_cliente FROM vistaPrestamos";
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

}
