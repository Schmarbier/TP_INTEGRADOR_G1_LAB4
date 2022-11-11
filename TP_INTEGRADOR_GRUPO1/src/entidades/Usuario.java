package entidades;

public class Usuario {

	///ATRIBUTOS
	public String Usuario;
    public TipoUsuario Tipo_Us;
    public String Contraseña;
    public Boolean Estado;
    
    ///CONSTRUCTORES
    public Usuario(){}
    
	public Usuario(String usuario, TipoUsuario tipo_Us, String contraseña, Boolean estado) {
		super();
		Usuario = usuario;
		Tipo_Us = tipo_Us;
		Contraseña = contraseña;
		Estado = estado;
	}

	///GETTERS & SETTERS
	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public TipoUsuario getTipo_Us() {
		return Tipo_Us;
	}

	public void setTipo_Us(TipoUsuario tipo_Us) {
		Tipo_Us = tipo_Us;
	}

	public String getContraseña() {
		return Contraseña;
	}

	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}

	public Boolean getEstado() {
		return Estado;
	}

	public void setEstado(Boolean estado) {
		Estado = estado;
	}

	///METODO TOSTRING()
	@Override
	public String toString() {
		return Usuario;
	} 
}
