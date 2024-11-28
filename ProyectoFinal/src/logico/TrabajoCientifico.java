package logico;

import java.util.ArrayList;

public class TrabajoCientifico {

	private String codigo;
    private String titulo;
    private String resumen;
    private String estado;
    private ArrayList<Persona> autores;

    public TrabajoCientifico(String codigo, String titulo, String resumen, String estado) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.resumen = resumen;
        this.estado = estado;
        this.autores = new ArrayList<>();
    }

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ArrayList<Persona> getAutores() {
		return autores;
	}

	public void setAutores(ArrayList<Persona> autores) {
		this.autores = autores;
	}


}
