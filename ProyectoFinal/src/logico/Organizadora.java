package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Organizadora implements Serializable{

	private static final long serialVersionUID = 1L;
	private ArrayList<Evento> misEventos;
    private ArrayList<Recurso> misRecursos;
    private ArrayList<Persona> misPersonas;
    private ArrayList<TrabajoCientifico> misTrabajosCientificos;
    private ArrayList<Comision> misComisiones;
    private ArrayList<User> misUsuarios;
    public static Organizadora organizadora;
    private static User loginUser;

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
        misUsuarios = new ArrayList<>();
    }
    
    
    public void insertarComision(Comision comision)
    {
    	this.misComisiones.add(comision);
    }
    
    public void insertarEvento(Evento evento)
    {
    	this.misEventos.add(evento);
    }
    
    public void insertarPersona(Persona persona)
    {
    	this.misPersonas.add(persona);
    }
    
    public void insertarRecurso(Recurso recurso)
    {
    	this.misRecursos.add(recurso);
    }
    
    public void insertarTrabajo(TrabajoCientifico trabajoCienifico)
    {
    	this.misTrabajosCientificos.add(trabajoCienifico);
    }

	public ArrayList<Evento> getMisEventos() {
		return misEventos;
	}

	public void setMisEventos(ArrayList<Evento> misEventos) {
		this.misEventos = misEventos;
	}

	public ArrayList<Recurso> getMisRecursos() {
		return misRecursos;
	}

	public void setMisRecursos(ArrayList<Recurso> misRecursos) {
		this.misRecursos = misRecursos;
	}

	public ArrayList<Persona> getMisPersonas() {
		return misPersonas;
	}

	public void setMisPersonas(ArrayList<Persona> misPersonas) {
		this.misPersonas = misPersonas;
	}
	
	public static void setOrganizadora(Organizadora organizadora) {
		Organizadora.organizadora = organizadora;
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
	
	public void AgregarUser(User user) {
		misUsuarios.add(user);
	}
	

	public boolean confirmLogin(String usuario, String password) {
		boolean login = false;
		for (User user : misUsuarios) {
			if (user.getUsuario().equals(usuario) && user.getPassword().equals(password)) {
				loginUser = user;
				login = true;
			}
		}
		return login;
	}

	public ArrayList<User> getMisUsuarios() {
		return misUsuarios;
	}

	public void setMisUsuarios(ArrayList<User> misUsuarios) {
		this.misUsuarios = misUsuarios;
	}

	public static User getLoginUser() {
		return loginUser;
	}

	public static void setLoginUser(User loginUser) {
		Organizadora.loginUser = loginUser;
	}
    
	public User getUsuario(String string) {

		User temp = null;
		boolean encontrado = false;
		int ind = 0;

		while (!encontrado && ind < misUsuarios.size()) {
			if (misUsuarios.get(ind).getUsuario().equalsIgnoreCase(string)) {
				temp = misUsuarios.get(ind);
				encontrado = true;
			}
			ind++;
		}
		return temp;
	}
	
	public ArrayList<User> getUsuariosPorTipo(String tipoSeleccionado) {
		ArrayList<User> usuariosPorTipo = new ArrayList<>();

		for (User user : misUsuarios) {
			if (user.getTipo().equals(tipoSeleccionado)) {
				usuariosPorTipo.add(user);
			}
			if (tipoSeleccionado.equalsIgnoreCase("<Todos>")) {
				usuariosPorTipo = getMisUsuarios();
			}
		}

		return usuariosPorTipo;
	}

	public void EliminarUser(User user) {
		misUsuarios.remove(user);
	}
    
    

}
