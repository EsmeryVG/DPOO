package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class TrabajoCientifico implements Serializable{

	private static final long serialVersionUID = 1L;
	private String codigo;
    private String titulo;
    private String resumen;
    private String estado;
    private String area;
    private ArrayList<String> autores;
    public static int codigoTrabajoCientifico = 1;

    public TrabajoCientifico(String titulo, String resumen, String area,
			ArrayList<String> autores) {
		super();
		this.codigo = "TRABAJO-N"+codigoTrabajoCientifico;
		this.titulo = titulo;
		this.resumen = resumen;
		this.estado = "Sin Asignar";
		this.area = area;
		this.autores = new ArrayList<>(autores);
		codigoTrabajoCientifico++;
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

	public ArrayList<String> getAutores() {
		return autores;
	}

	public void setAutores(ArrayList<String> autores) {
		this.autores = autores;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public static int getCodigoTrabajoCientifico() {
		return codigoTrabajoCientifico;
	}

	public static void setCodigoTrabajoCientifico(int codigoTrabajoCientifico) {
		TrabajoCientifico.codigoTrabajoCientifico = codigoTrabajoCientifico;
	}


}
