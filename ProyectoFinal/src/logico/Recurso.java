package logico;


public class Recurso {

	private String codigo;
    private String tipo;
    private String nombre;
    private String marca;
    private float precio;
    private boolean disponibilidad;

    public Recurso(String codigo, String tipo, String nombre, String marca, float precio, boolean disponibilidad) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.disponibilidad = disponibilidad;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}


}

