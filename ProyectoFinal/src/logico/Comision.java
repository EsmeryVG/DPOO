package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Comision implements Serializable{

	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
    private String descripcion;
    private ArrayList<Jurado> miembros;
    private TrabajoCientifico miTrabajo;
    public static int codigoComision = 1;

    public Comision(String nombre, String descripcion, ArrayList<Jurado> miembros, TrabajoCientifico miTrabajo) {
		super();
		this.codigo = "COMISION-N"+codigoComision;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.miembros = miembros;
		this.miTrabajo = miTrabajo;
		codigoComision++;
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

	public ArrayList<Jurado> getMiembros() {
		return miembros;
	}

	public void setMiembros(ArrayList<Jurado> miembros) {
		this.miembros = miembros;
	}

	public TrabajoCientifico getMiTrabajo() {
		return miTrabajo;
	}

	public void setMiTrabajo(TrabajoCientifico miTrabajo) {
		this.miTrabajo = miTrabajo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public static int getCodigoComision() {
		return codigoComision;
	}

	public static void setCodigoComision(int codigoComision) {
		Comision.codigoComision = codigoComision;
	}

}
