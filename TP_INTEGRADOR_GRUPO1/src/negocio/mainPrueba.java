package negocio;

import java.io.Console;
import java.util.ArrayList;

import daoImp.CuentaDaoImp;
import entidades.Cuenta;
import entidades.TipoCuenta;
import entidades.Usuario;
import negocioImp.CuentaNegocioImp;
import negocioImp.TipoCuentaNegocioImp;
import daoImp.TipoCuentaDaoImp;
import negocioImp.UsuarioNegocioImp;

public class mainPrueba {
	
	public static void main(String[] args) {
		
		/* Para pruebas */
		
		/*
		
		String usuario = "CarlaEyra";
		String contraseña = "Carla123";
		
		Usuario usu = new Usuario();
		usu.setUsuario(usuario);
		usu.setContraseña(contraseña);
		
		UsuarioNegocioImp neg = new UsuarioNegocioImp();
		System.out.println(neg.esAdmin(usu));
		
		CuentaDaoImp neg = new CuentaDaoImp();
		ArrayList<Cuenta> listaTs = (ArrayList<Cuenta>) neg.obtenerCuentas();
		for(Cuenta p:listaTs) { System.out.println( p.toString()); }
		
		*/
		
		TipoCuentaNegocioImp neg = new TipoCuentaNegocioImp();
		ArrayList<TipoCuenta> lista = (ArrayList<TipoCuenta>) neg.readAll();
		for(TipoCuenta p:lista) { System.out.println( p.toString()); }

	}
}
