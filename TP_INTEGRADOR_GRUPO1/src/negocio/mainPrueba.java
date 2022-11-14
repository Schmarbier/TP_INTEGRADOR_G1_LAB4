package negocio;

import java.io.Console;
import java.util.ArrayList;

import entidades.Cuenta;
import entidades.TipoCuenta;
import entidades.Usuario;
import negocioImp.CuentaNegocioImp;
import negocioImp.TipoCuentaNegocioImp;
import daoImp.TipoCuentaDaoImp;
import daoImp.CuentaDaoImp;
import negocioImp.UsuarioNegocioImp;

public class mainPrueba {
	
	public static void main(String[] args) {
		
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
		
		TipoCuentaNegocioImp neg = new TipoCuentaNegocioImp();
		ArrayList<TipoCuenta> lista = (ArrayList<TipoCuenta>) neg.readAll();
		for(TipoCuenta p:lista) { System.out.println( p.toString()); }
		
		*/

		Cuenta obj = new Cuenta();
		obj.setNro_cliente(8);
		obj.setTipo_cuenta(new TipoCuenta(2,""));
		obj.setCbu("000221949978");
		obj.setSaldo(7000);
		obj.setEstado(true);
		
		CuentaNegocioImp cn = new CuentaNegocioImp();
		int Nro = cn.insert(obj);
		if(Nro>0) System.out.print("Cliente agregado - Nro="+ Nro +"-"+obj.toString());
		else System.out.print("Cliente no agregado");
		

	}
}
