package daoImp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.PrestamoDao;
import entidades.Cliente;
import entidades.Genero;
import entidades.Localidad;
import entidades.Nacionalidad;
import entidades.Prestamo;
import entidades.Provincia;
import entidades.Usuario;

public class PrestamoDaoImp implements PrestamoDao{

	private static final String readallAdmin = "SELECT prestamos.Nro_prestamo, clientes.Nro_cliente, prestamos.Fecha,"
			+ " prestamos.Imp_con_intereses, prestamos.Imp_solicitado, prestamos.Nro_cuenta_deposito, prestamos.Plazo_pago_meses,"
			+ " prestamos.Monto_pago_por_mes, prestamos.Cant_cuotas INNER JOIN clientes ON"
			+ " clientes.Nro_cliente = prestamos.Nro_cliente WHERE prestamo.Est_prestamo = 3";

	@Override
	public List<Prestamo> readAll() {
		PreparedStatement Statement;
		ResultSet resultSet;
		ArrayList<Prestamo> ListaPrestamos = new ArrayList<Prestamo>();
		Conexion conexion = Conexion.getConexion();
		
		try {
			Statement = conexion.getSQLConexion().prepareStatement(readallAdmin);
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

}
