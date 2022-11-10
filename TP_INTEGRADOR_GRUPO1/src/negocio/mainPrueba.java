package negocio;

import java.io.Console;

import entidades.Usuario;
import negocioImp.UsuarioNegocioImp;

public class mainPrueba {
	
	public static void main(String[] args) {
		
		String usuario = "CarlaEyra";
		String contraseña = "Carla123";
		
		Usuario usu = new Usuario();
		usu.setUsuario(usuario);
		usu.setContraseña(contraseña);
		
		UsuarioNegocioImp neg = new UsuarioNegocioImp();
		System.out.println(neg.esAdmin(usu));
	}
}
