package logico;

import java.util.ArrayList;

public class Comision {

	private String nombre;
    private String descripcion;
    private ArrayList<Persona> miembros;
    private TrabajoCientifico miTrabajo;

    public Comision(String nombre, String descripcion, ArrayList<Persona> miembros, TrabajoCientifico miTrabajo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.miembros = miembros;
		this.miTrabajo = miTrabajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ArrayList<Persona> getMiembros() {
		return miembros;
	}

	public void setMiembros(ArrayList<Persona> miembros) {
		this.miembros = miembros;
	}

	public TrabajoCientifico getMiTrabajo() {
		return miTrabajo;
	}

	public void setMiTrabajo(TrabajoCientifico miTrabajo) {
		this.miTrabajo = miTrabajo;
	}

}
