package logico;

import java.util.ArrayList;

public class Organizadora {

	private ArrayList<Evento> misEventos;
    private ArrayList<Recurso> misRecursos;
    private ArrayList<Persona> misPersonas;
    private ArrayList<TrabajoCientifico> misTrabajosCientificos;
    private ArrayList<Comision> misComisiones;
    public static Organizadora organizadora;

    public static Organizadora getInstance() {
		if (organizadora == null) {
			organizadora = new Organizadora();
		}

		return organizadora;
	}
    
    public Organizadora() {
        misEventos = new ArrayList<>();
        misRecursos = new ArrayList<>();
        misPersonas = new ArrayList<>();
        misTrabajosCientificos = new ArrayList<>();
        misComisiones = new ArrayList<>();
    }
    
    

}
