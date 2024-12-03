package logico;

import java.io.Serializable;

public class Jurado extends Persona implements Serializable{

	private static final long serialVersionUID = 1L;
    private String especialidad;
    public static int codigoJurado = 1;

    public Jurado(String nombre, String especialidad) {
        super("JURADO-N"+codigoJurado, nombre);
        this.especialidad = especialidad;
        codigoJurado++;
    }

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public static int getCodigoJurado() {
		return codigoJurado;
	}

	public static void setCodigoJurado(int codigoJurado) {
		Jurado.codigoJurado = codigoJurado;
	}

   
}
