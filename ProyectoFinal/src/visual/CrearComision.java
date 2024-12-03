package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Comision;
import logico.Evento;
import logico.Jurado;
import logico.Organizadora;
import logico.Persona;
import logico.TrabajoCientifico;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CrearComision extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtCodigo;
	private static JTable table;
	private static JTextField txtTrabajo;
	private ArrayList<Jurado> misJurados = new ArrayList<Jurado>();
	private JTextArea txtDescripcion;
	private static TrabajoCientifico miTrabajoCientifico = null;
	private static DefaultTableModel ParticipanteModel;
	private static Object[] row;
	private JButton okButton;
	int index;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearComision dialog = new CrearComision(null,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearComision(Evento evento,Comision comision) {
		setResizable(false);
		setTitle("Crear Comision");
		setBounds(100, 100, 630, 681);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Informacion General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 10, 595, 195);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Nombre:");
				lblNewLabel.setBounds(29, 30, 56, 13);
				panel.add(lblNewLabel);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setBounds(95, 27, 249, 19);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Codigo:");
				lblNewLabel_1.setBounds(370, 30, 45, 13);
				panel.add(lblNewLabel_1);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setEditable(false);
				txtCodigo.setBounds(425, 27, 149, 19);
				panel.add(txtCodigo);
				txtCodigo.setColumns(10);
				txtCodigo.setText("COMISION-N"+Comision.codigoComision);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Descripcion");
				lblNewLabel_2.setBounds(29, 56, 79, 13);
				panel.add(lblNewLabel_2);
			}
			
			txtDescripcion = new JTextArea();
			txtDescripcion.setBounds(29, 80, 545, 89);
			panel.add(txtDescripcion);
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Miembros", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 215, 595, 296);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 575, 234);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index = table.getSelectedRow();
				if(index >= 0)
				{
					btnEliminar.setEnabled(true);
				}
			}
		});
		ParticipanteModel = new DefaultTableModel();
		String headers[] = { "Codigo","Nombre"};
		ParticipanteModel.setColumnIdentifiers(headers);
		table.setModel(ParticipanteModel);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaJurados jre = new ListaJurados(misJurados,evento);
				jre.setModal(true);
				jre.setLocationRelativeTo(null);
				jre.setVisible(true);
			}
		});
		btnNewButton.setBounds(478, 264, 107, 21);
		panel.add(btnNewButton);
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					misJurados.remove(index);
					Load(misJurados);
					btnEliminar.setEnabled(false);
				}
			});
			btnEliminar.setEnabled(false);
			btnEliminar.setBounds(361, 263, 107, 23);
			panel.add(btnEliminar);
		}
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Trabajo Cientifico", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(10, 521, 595, 61);
			contentPanel.add(panel_1);
			panel_1.setLayout(null);
			{
				JLabel lblNewLabel_3 = new JLabel("Titulo:");
				lblNewLabel_3.setBounds(10, 27, 61, 13);
				panel_1.add(lblNewLabel_3);
			}
			{
				txtTrabajo = new JTextField();
				txtTrabajo.setEditable(false);
				txtTrabajo.setBounds(74, 24, 342, 19);
				panel_1.add(txtTrabajo);
				txtTrabajo.setColumns(10);
			}
			{
				JButton btnAgregarTrabajo = new JButton("Agregar Trabajo");
				btnAgregarTrabajo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ListaTrabajosCientificos jre = new ListaTrabajosCientificos(miTrabajoCientifico,evento);
						jre.setModal(true);
						jre.setLocationRelativeTo(null);
						jre.setVisible(true);
					}
				});
				btnAgregarTrabajo.setBounds(440, 23, 145, 21);
				panel_1.add(btnAgregarTrabajo);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Crear");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(validarCampos())
						{
							if(comision == null)
							{
								Comision comision = new Comision(txtNombre.getText(),txtDescripcion.getText(),misJurados,miTrabajoCientifico);
								Organizadora.getInstance().insertarComision(comision);
								evento.getMisComisiones().add(comision);
								JOptionPane.showMessageDialog(null, "La comision fue agregado exitosamente!");
								EditarEvento.LoadComision();
								EditarEvento.LoadTrabajo();
								miTrabajoCientifico = null;
								misJurados = new ArrayList<Jurado>();
								clear();
							}else {
								comision.setNombre(txtNombre.getText());
								comision.setDescripcion(txtDescripcion.getText());
								comision.setMiembros(misJurados);
								comision.setMiTrabajo(miTrabajoCientifico);
								JOptionPane.showMessageDialog(null, "La comision fue actualizada exitosamente!");
								EditarEvento.LoadComision();
								EditarEvento.LoadTrabajo();
								miTrabajoCientifico = null;
								misJurados = new ArrayList<Jurado>();
								dispose();
							}
						}else {
							JOptionPane.showMessageDialog(null, "Debe llenar todos los campos!");
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(miTrabajoCientifico != null)
						{
							miTrabajoCientifico.setEstado("Sin Asignar");
						}
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadMode(comision);
	}
	
	public boolean validarCampos() {
		 
	    if (txtNombre.getText().isEmpty() || 
	    	txtDescripcion.getText().isEmpty() ||
	    	misJurados.isEmpty() ||
	    	miTrabajoCientifico == null)
	    {
	        return false;
	    }

	    return true;
	}
	
	static public void trabajo(TrabajoCientifico tc)
	{
		miTrabajoCientifico = tc;
		txtTrabajo.setText(tc.getTitulo());
	}
	
	public void feedJurados(Comision comision)
	{
		for (Persona jurado : comision.getMiembros()) {
			misJurados.add((Jurado) jurado);
		}
	}
	
	static public void Load(ArrayList<Jurado> jurados) {
		ParticipanteModel.setRowCount(0);
		row = new Object[table.getColumnCount()];
		for (Jurado jurado : jurados) {
			row[0] = jurado.getCodigo();
			row[1] = jurado.getNombre();
			ParticipanteModel.addRow(row);
		}
	}
	
	public void clear()
	{
		txtCodigo.setText("COMISION-N"+Comision.codigoComision);
		txtNombre.setText("");
		txtDescripcion.setText("");
		ParticipanteModel.setRowCount(0);
		txtTrabajo.setText("");
	}
	
	public void loadMode(Comision comision)
	{
		
		if(comision != null)
		{
			feedJurados(comision);
			miTrabajoCientifico = comision.getMiTrabajo();
			misJurados = comision.getMiembros();
			setTitle("Actualizar Comision");
			okButton.setText("Actualizar");
			txtNombre.setText(comision.getNombre());
			txtCodigo.setText(comision.getCodigo());
			txtDescripcion.setText(comision.getDescripcion());
			txtTrabajo.setText(comision.getMiTrabajo().getTitulo());
			Load(misJurados);
		}
	}
}
