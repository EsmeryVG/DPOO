package logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Evento implements Serializable{

	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
	private Date fecha;
	private String tipo;
	private String estado;
	private ArrayList<Persona> misParticipantes;
	private ArrayList<TrabajoCientifico> misTrabajosCientificos;
	private ArrayList<Comision> misComisiones;
	private ArrayList<Recurso> misRecursos;
    public static int codigoEvento = 1;

	public Evento(String nombre, Date fecha, String tipo) {
		this.codigo = "EVENTO-N"+codigoEvento;
		this.nombre = nombre;
		this.fecha = fecha;
		this.tipo = tipo;
		this.estado = "Preparandose";
		this.misParticipantes = new ArrayList<Persona>();
		this.misTrabajosCientificos = new ArrayList<TrabajoCientifico>();
		this.misComisiones = new ArrayList<Comision>();
		this.misRecursos = new ArrayList<Recurso>();
		codigoEvento++;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ArrayList<Persona> getMisParticipantes() {
		return misParticipantes;
	}

	public void setMisParticipantes(ArrayList<Persona> misParticipantes) {
		this.misParticipantes = misParticipantes;
	}

	public ArrayList<TrabajoCientifico> getMisTrabajosCientificos() {
		return misTrabajosCientificos;
	}

	public void setMisTrabajosCientificos(ArrayList<TrabajoCientifico> misTrabajosCientificos) {
		this.misTrabajosCientificos = misTrabajosCientificos;
	}

	public ArrayList<Comision> getMisComisiones() {
		return misComisiones;
	}

	public void setMisComisiones(ArrayList<Comision> misComisiones) {
		this.misComisiones = misComisiones;
	}

	public ArrayList<Recurso> getMisRecursos() {
		return misRecursos;
	}

	public void setMisRecursos(ArrayList<Recurso> misRecursos) {
		this.misRecursos = misRecursos;
	}

	public static int getCodigoEvento() {
		return codigoEvento;
	}

	public static void setCodigoEvento(int codigoEvento) {
		Evento.codigoEvento = codigoEvento;
	}

}
