package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;

import logico.Comision;
import logico.Evento;
import logico.Jurado;
import logico.Organizadora;
import logico.Participante;
import logico.Persona;
import logico.Recurso;
import logico.TrabajoCientifico;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditarEvento extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private static DefaultTableModel ParticipanteModel;
	private static Object[] row;
	private static DefaultTableModel ComisionModel;
	private static DefaultTableModel RecursoMdoel;
	private static DefaultTableModel TrabajoModel;
	private static Evento miEvento;
	int indexT;
	int indexC;
	int indexR;
	int indexP;
	private JButton btnEliminarT;
	private JButton btnEliminarR;
	private JButton btnElminarP;
	private JButton btnActualizarT;
	private JButton btnActualizarP;
	private JButton btnEliminarC;
	private JButton btnActualizarC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Evento evt = new Evento(null, null, "123123");
			EditarEvento dialog = new EditarEvento(evt);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EditarEvento(Evento evt) {
		miEvento = evt;
		setTitle("Evento");
		setBounds(100, 100, 1206, 642);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Comisiones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 10, 582, 267);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 562, 203);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				indexC = table.getSelectedRow();
				if(indexC >= 0)
				{
					btnActualizarC.setEnabled(true);
					btnEliminarC.setEnabled(true);
				}
			}
		});
		scrollPane.setViewportView(table);
		ComisionModel = new DefaultTableModel();
		String headers[] = { "Nombre","Trabajo Cientifico","Cantidad de Miembros"};
		ComisionModel.setColumnIdentifiers(headers);
		table.setModel(ComisionModel);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearComision tc = new CrearComision(miEvento, null);
				tc.setModal(true);
				tc.setLocationRelativeTo(null);
				tc.setVisible(true);
			}
		});
		btnNewButton.setBounds(487, 235, 85, 21);
		panel_1.add(btnNewButton);
		
		btnEliminarC = new JButton("Eliminar");
		btnEliminarC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miEvento.getMisComisiones().get(indexC).getMiTrabajo().setEstado("Sin Asignar");
				miEvento.getMisComisiones().remove(indexC);
				btnEliminarC.setEnabled(false);
				btnActualizarC.setEnabled(false);
				LoadComision();
				LoadTrabajo();
			}
		});
		btnEliminarC.setEnabled(false);
		btnEliminarC.setBounds(392, 235, 85, 21);
		panel_1.add(btnEliminarC);
		
		btnActualizarC = new JButton("Actualizar");
		btnActualizarC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearComision tc = new CrearComision(miEvento, miEvento.getMisComisiones().get(indexC));
				tc.setModal(true);
				tc.setLocationRelativeTo(null);
				tc.setVisible(true);
				btnEliminarC.setEnabled(false);
				btnActualizarC.setEnabled(false);
			}
		});
		btnActualizarC.setEnabled(false);
		btnActualizarC.setBounds(283, 235, 101, 21);
		panel_1.add(btnActualizarC);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Participantes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBounds(10, 287, 582, 267);
		contentPanel.add(panel_1_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 22, 562, 203);
		panel_1_1.add(scrollPane_1);
		
		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				indexP = table_2.getSelectedRow();
				if(indexP >= 0)
				{
					btnActualizarP.setEnabled(true);
					btnElminarP.setEnabled(true);
				}
			}
		});
		scrollPane_1.setViewportView(table_2);
		ParticipanteModel = new DefaultTableModel();
		String headers1[] = { "Nombre","Tipo" };
		ParticipanteModel.setColumnIdentifiers(headers1);
		table_2.setModel(ParticipanteModel);
		scrollPane_1.setViewportView(table_2);
		
		JButton btnNewButton_2 = new JButton("Agregar Participante");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarParticipante tc = new AgregarParticipante(null, miEvento);
				tc.setModal(true);
				tc.setLocationRelativeTo(null);
				tc.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(409, 235, 163, 21);
		panel_1_1.add(btnNewButton_2);
		
		btnElminarP = new JButton("Eliminar");
		btnElminarP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validarParticipante())
				{
					miEvento.getMisParticipantes().remove(indexP);
					LoadParticipante();
					btnElminarP.setEnabled(false);
					btnActualizarP.setEnabled(false);
				}else {
					JOptionPane.showMessageDialog(null, "No puede eliminar este participante ya que crearia un conflicto de registro!");
				}
			}
		});
		btnElminarP.setEnabled(false);
		btnElminarP.setBounds(170, 235, 85, 21);
		panel_1_1.add(btnElminarP);
		
		JButton btnNewButton_2_1 = new JButton("Agregar Jurado");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarJuardo tc = new AgregarJuardo(null, miEvento);
				tc.setModal(true);
				tc.setLocationRelativeTo(null);
				tc.setVisible(true);
			}
		});
		btnNewButton_2_1.setBounds(265, 235, 134, 21);
		panel_1_1.add(btnNewButton_2_1);
		
		btnActualizarP = new JButton("Actualizar");
		btnActualizarP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(miEvento.getMisParticipantes().get(indexP) instanceof Jurado)
				{
					AgregarJuardo tc = new AgregarJuardo((Jurado) miEvento.getMisParticipantes().get(indexP), miEvento);
					tc.setModal(true);
					tc.setLocationRelativeTo(null);
					tc.setVisible(true);
					btnElminarP.setEnabled(false);
					btnActualizarP.setEnabled(false);
				}
				if(miEvento.getMisParticipantes().get(indexP) instanceof Participante)
				{
					AgregarParticipante tc = new AgregarParticipante((Participante) miEvento.getMisParticipantes().get(indexP), miEvento);
					tc.setModal(true);
					tc.setLocationRelativeTo(null);
					tc.setVisible(true);
				}
			}
		});
		btnActualizarP.setEnabled(false);
		btnActualizarP.setBounds(63, 235, 97, 21);
		panel_1_1.add(btnActualizarP);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Trabajos Cientificos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_2.setBounds(602, 10, 582, 267);
		contentPanel.add(panel_1_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 22, 562, 203);
		panel_1_2.add(scrollPane_2);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				indexT = table_1.getSelectedRow();
				if(indexT >= 0)
				{
					btnEliminarT.setEnabled(true);
					btnActualizarT.setEnabled(true);
				}
			}
		});
		scrollPane_2.setViewportView(table_1);
		TrabajoModel = new DefaultTableModel();
		String headers2[] = { "Titulo","Area","Estado"};
		TrabajoModel.setColumnIdentifiers(headers2);
		table_1.setModel(TrabajoModel);
		scrollPane_2.setViewportView(table_1);
		
		JButton btnNewButton_3 = new JButton("Agregar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarTrabajoCientifico tc = new AgregarTrabajoCientifico(null, miEvento);
				tc.setModal(true);
				tc.setLocationRelativeTo(null);
				tc.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(487, 235, 85, 21);
		panel_1_2.add(btnNewButton_3);
		
		btnEliminarT = new JButton("Eliminar");
		btnEliminarT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validarTrabajoCientifico())
				{
					miEvento.getMisTrabajosCientificos().remove(indexT);
					LoadTrabajo();
					btnEliminarT.setEnabled(false);
					btnActualizarT.setEnabled(false);
					
				}else {
					JOptionPane.showMessageDialog(null, "No puede eliminar este Trabajo ya que crearia un conflicto de registro!");
				}
			}
		});
		btnEliminarT.setEnabled(false);
		btnEliminarT.setBounds(392, 235, 85, 21);
		panel_1_2.add(btnEliminarT);
		
		btnActualizarT = new JButton("Actualizar");
		btnActualizarT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarTrabajoCientifico tc = new AgregarTrabajoCientifico(miEvento.getMisTrabajosCientificos().get(indexT), miEvento);
				tc.setModal(true);
				tc.setLocationRelativeTo(null);
				tc.setVisible(true);
				btnEliminarT.setEnabled(false);
				btnActualizarT.setEnabled(false);
			}
		});
		btnActualizarT.setEnabled(false);
		btnActualizarT.setBounds(275, 235, 107, 21);
		panel_1_2.add(btnActualizarT);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Recursos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_2_1.setBounds(602, 287, 582, 267);
		contentPanel.add(panel_1_2_1);
		
		JScrollPane scrollPane_2_1 = new JScrollPane();
		scrollPane_2_1.setBounds(10, 22, 562, 203);
		panel_1_2_1.add(scrollPane_2_1);
		
		table_3 = new JTable();
		table_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				indexR = table_3.getSelectedRow();
				if(indexR >= 0)
				{
					btnEliminarR.setEnabled(true);
				}
			}
		});
		scrollPane_2_1.setViewportView(table_3);
		RecursoMdoel = new DefaultTableModel();
		String headers3[] = { "Nombre","Marca","Precio"};
		RecursoMdoel.setColumnIdentifiers(headers3);
		table_3.setModel(RecursoMdoel);
		scrollPane_2_1.setViewportView(table_3);
		
		JButton btnNewButton_3_1 = new JButton("Agregar");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaRecursos tc = new ListaRecursos(miEvento);
				tc.setModal(true);
				tc.setLocationRelativeTo(null);
				tc.setVisible(true);
			}
		});
		btnNewButton_3_1.setBounds(487, 235, 85, 21);
		panel_1_2_1.add(btnNewButton_3_1);
		
		btnEliminarR = new JButton("Eliminar");
		btnEliminarR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miEvento.getMisRecursos().get(indexR).setDisponibilidad(true);
				miEvento.getMisRecursos().remove(indexR);
				LoadRecurso();
			}
		});
		btnEliminarR.setEnabled(false);
		btnEliminarR.setBounds(392, 235, 85, 21);
		panel_1_2_1.add(btnEliminarR);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		LoadComision();
		LoadRecurso();
		LoadTrabajo();
		LoadParticipante();
	}
	
	public boolean validarTrabajoCientifico()
	{
		for(Comision comision: miEvento.getMisComisiones())
		{
			if(comision.getMiTrabajo().equals(miEvento.getMisTrabajosCientificos().get(indexT)))
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean validarParticipante()
	{
		for(Comision comision: miEvento.getMisComisiones())
		{
			for(Jurado jurado:comision.getMiembros())
			{
				if(jurado.equals(miEvento.getMisParticipantes().get(indexP)))
				{
					return false;
				}
			}
		}
		return true;
	}
	
	static public void LoadComision() {
		if(miEvento == null)
		{
			return;
		}
		ComisionModel.setRowCount(0);
		row = new Object[table.getColumnCount()];
		for (Comision comision: miEvento.getMisComisiones()) {
			row[0] = comision.getNombre();
			row[1] = comision.getMiTrabajo().getTitulo();
			row[2] = comision.getMiembros().size();
			ComisionModel.addRow(row);
		}
	}
	
	static public void LoadRecurso() {
		if(miEvento == null)
		{
			return;
		}
		RecursoMdoel.setRowCount(0);
		row = new Object[table.getColumnCount()];
		for (Recurso rec: miEvento.getMisRecursos()) {
			row[0] = rec.getNombre();
			row[1] = rec.getMarca();
			row[2] = rec.getPrecio();
			RecursoMdoel.addRow(row);
		}
	}
	
	static public void LoadTrabajo() {
		if(miEvento == null)
		{
			return;
		}
		TrabajoModel.setRowCount(0);
		row = new Object[table.getColumnCount()];
		for (TrabajoCientifico tc: miEvento.getMisTrabajosCientificos()) {
			row[0] = tc.getTitulo();
			row[1] = tc.getArea();
			row[2] = tc.getEstado();
			TrabajoModel.addRow(row);
		}
	}
	
	static public void LoadParticipante() {
		if(miEvento == null)
		{
			return;
		}
		ParticipanteModel.setRowCount(0);
		row = new Object[table.getColumnCount()];
		for (Persona prs: miEvento.getMisParticipantes()) {
			row[0] = prs.getNombre();
			if(prs instanceof Jurado)
			{
				row[1] = "Jurado";
			}
			if(prs instanceof Participante)
			{
				Participante pcc = (Participante) prs;
				row[1] = pcc.getRol();
			}

			ParticipanteModel.addRow(row);
		}
	} 
}
