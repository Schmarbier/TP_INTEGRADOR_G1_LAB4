package negocio;

import java.io.Console;
import java.util.ArrayList;

import daoImp.CuentaDaoImp;
import entidades.Cuenta;
import entidades.Usuario;
import negocioImp.CuentaNegocioImp;
import negocioImp.UsuarioNegocioImp;

public class mainPrueba {
	
	public static void main(String[] args) {
		
		/*String usuario = "CarlaEyra";
		String contrase�a = "Carla123";
		
		Usuario usu = new Usuario();
		usu.setUsuario(usuario);
		usu.setContrase�a(contrase�a);
		
		UsuarioNegocioImp neg = new UsuarioNegocioImp();
		System.out.println(neg.esAdmin(usu));*/
		
		CuentaDaoImp neg = new CuentaDaoImp();
		ArrayList<Cuenta> listaTs = (ArrayList<Cuenta>) neg.obtenerCuentas();
		for(Cuenta p:listaTs) { System.out.println( p.toString()); }
	}
}
