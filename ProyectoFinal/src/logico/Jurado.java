package logico;

public class Jurado extends Persona {
    private String especialidad;

    public Jurado(String codigo, String nombre, String especialidad) {
        super(codigo, nombre);
        this.especialidad = especialidad;
    }

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

   
}
