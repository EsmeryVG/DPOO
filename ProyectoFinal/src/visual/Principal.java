package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Organizadora;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem mntmNewMenuItem_3;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Organizadora de Eventos");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream organizadora2;
				ObjectOutputStream organizadoraWrite;
				try {
					organizadora2 = new FileOutputStream("organizadora.dat");
					organizadoraWrite = new ObjectOutputStream(organizadora2);
					organizadoraWrite.writeObject(Organizadora.getInstance());
				} catch (FileNotFoundException e1) {

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Eventos");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ver Eventos");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerEvento jre = new VerEvento();
				jre.setModal(true);
				jre.setLocationRelativeTo(null);
				jre.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_1 = new JMenu("Recursos");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Agregar Recursos");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarRecurso jre = new AgregarRecurso(null);
				jre.setModal(true);
				jre.setLocationRelativeTo(null);
				jre.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Listado de Recursos");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarR jre = new ListarR();
				jre.setModal(true);
				jre.setLocationRelativeTo(null);
				jre.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		mnNewMenu_2 = new JMenu("Usuarios");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Listado de Usuarios");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarUsuarios jre = new ListarUsuarios();
				jre.setModal(true);
				jre.setLocationRelativeTo(null);
				jre.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_3 = new JMenuItem("Agregar Usuario");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarUsuario jre = new RegistrarUsuario(null);
				jre.setModal(true);
				jre.setLocationRelativeTo(null);
				jre.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		LoadRoles();
	}
	
	private void LoadRoles() {

		if (Organizadora.getLoginUser().getTipo().equalsIgnoreCase("Basico")) {
			mnNewMenu_2.setVisible(false);
			mnNewMenu_1.setVisible(false);

		}

	}
}
