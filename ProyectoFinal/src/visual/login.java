package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Comision;
import logico.Evento;
import logico.Jurado;
import logico.Organizadora;
import logico.Participante;
import logico.Recurso;
import logico.TrabajoCientifico;
import logico.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField txtusuario;
	private JPasswordField txtpass;

	/**
	 * Launch the application.
	 */
	 public static void main(String[] args) {
	        EventQueue.invokeLater(() -> {
	            inicializarOrganizadora();
	            try {
	                login frame = new login();
	                frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        });
	    }

	    private static void inicializarOrganizadora() {
	        File archivo = new File("organizadora.dat");

	        if (archivo.exists()) {
	            // Leer datos de archivo existente
	            try (ObjectInputStream organizadoraRead = new ObjectInputStream(new FileInputStream(archivo))) {
	                Organizadora temp = (Organizadora) organizadoraRead.readObject();
	                Organizadora.setOrganizadora(temp);
	            } catch (IOException | ClassNotFoundException e) {
	                e.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Error al cargar los datos de la organizadora.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        } else {
	            // Crear archivo inicial con usuario administrador
	            try (ObjectOutputStream organizadoraWrite = new ObjectOutputStream(new FileOutputStream(archivo))) {
	                User admin = new User("Administrador", "Admin", "Admin");
	                Organizadora organizadoraInstance = Organizadora.getInstance();
	                organizadoraInstance.AgregarUser(admin);
	                organizadoraWrite.writeObject(organizadoraInstance);
	            } catch (IOException e) {
	                e.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Error al inicializar los datos de la organizadora.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    }


	/**
	 * Create the frame.
	 */
	public login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 332, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		txtusuario = new JTextField();
		txtusuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtusuario.getText().equalsIgnoreCase("Nombre de usuario...")) {
					txtusuario.setText("");
					txtusuario.setForeground(Color.black);
				}
				if (String.valueOf(txtpass.getPassword()).isEmpty()) {
					txtpass.setText("*********");
					txtpass.setForeground(Color.gray);
				}
			}
		});
		txtusuario.setBounds(28, 48, 260, 22);
		panel.add(txtusuario);
		txtusuario.setColumns(10);

		JLabel lblusuario = new JLabel("Usuario");
		lblusuario.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblusuario.setBounds(28, 21, 73, 16);
		panel.add(lblusuario);

		txtpass = new JPasswordField();
		txtpass.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (String.valueOf(txtpass.getPassword()).equals("*********")) {
					txtpass.setText("");
					txtpass.setForeground(Color.black);
				}
				if (txtusuario.getText().isEmpty()) {
					txtusuario.setText("Nombre de usuario...");
					txtusuario.setForeground(Color.gray);
				}
			}
		});
		txtpass.setText("*********");
		txtpass.setBounds(28, 125, 260, 22);
		txtpass.setColumns(10);
		panel.add(txtpass);

		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPassword.setBounds(28, 98, 85, 16);
		panel.add(lblPassword);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Organizadora.getInstance().confirmLogin(txtusuario.getText(), String.valueOf(txtpass.getPassword()))) {
					Principal frame = new Principal();
					dispose();
					frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "El usuario ingresado no es valido", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(89, 182, 115, 23);
		panel.add(btnNewButton);

		loadCodes();
	}

	public void loadCodes() {
		Comision.setCodigoComision(Organizadora.getInstance().getMisComisiones().size() + 1);
		Evento.setCodigoEvento(Organizadora.getInstance().getMisEventos().size() + 1);
		Jurado.setCodigoJurado(Organizadora.getInstance().getMisPersonas().size() + 1);
		Participante.setCodigoParticipante(Organizadora.getInstance().getMisPersonas().size() + 1);
		Recurso.setCodigoRecurso(Organizadora.getInstance().getMisRecursos().size() + 1);
		TrabajoCientifico.setCodigoTrabajoCientifico(Organizadora.getInstance().getMisTrabajosCientificos().size() + 1);
	}
}