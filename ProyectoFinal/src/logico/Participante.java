package logico;

import java.io.Serializable;

public class Participante extends Persona implements Serializable{

	private static final long serialVersionUID = 1L;
    private String email;
    private String rol;
    public static int codigoParticipante = 1;

    public Participante(String nombre, String email, String rol) {
        super("PARTICIPANTE-N"+Participante.codigoParticipante, nombre);
        this.email = email;
        this.rol = rol;
        codigoParticipante++;
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

	public static int getCodigoParticipante() {
		return codigoParticipante;
	}

	public static void setCodigoParticipante(int codigoParticipante) {
		Participante.codigoParticipante = codigoParticipante;
	}

   
}
