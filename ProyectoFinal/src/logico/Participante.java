package logico;

public class Participante extends Persona {
    private String email;
    private String rol;

    public Participante(String codigo, String nombre, String email, String rol) {
        super(codigo, nombre);
        this.email = email;
        this.rol = rol;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

   
}
