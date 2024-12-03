package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

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

import logico.Evento;
import logico.Organizadora;
import logico.TrabajoCientifico;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AgregarTrabajoCientifico extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtTitulo;
	private JTable table;
	private JTextField txtAutor;
	private ArrayList<String> autores = new ArrayList<String>();
	private DefaultTableModel AutorModel;
	private Object[] row;
	private JComboBox comboBox;
	private JTextArea txtResumen;
	private JButton btnEliminar;
	int index;
	private JButton okButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarTrabajoCientifico dialog = new AgregarTrabajoCientifico(null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarTrabajoCientifico(TrabajoCientifico trabajo, Evento evento) {

		setTitle("Registrar Trabajo Cientifico");
		setBounds(100, 100, 616, 578);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Informacion General",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 582, 482);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setBounds(24, 30, 45, 19);
		panel.add(lblNewLabel);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(82, 30, 113, 19);
		panel.add(txtCodigo);
		txtCodigo.setEnabled(false);
		txtCodigo.setColumns(10);
		txtCodigo.setText("TRABAJO-N" + TrabajoCientifico.codigoTrabajoCientifico);

		JLabel lblNewLabel_1 = new JLabel("Titulo:");
		lblNewLabel_1.setBounds(205, 33, 68, 13);
		panel.add(lblNewLabel_1);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(270, 30, 287, 19);
		panel.add(txtTitulo);
		txtTitulo.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Resumen");
		lblNewLabel_2_1.setBounds(24, 107, 92, 13);
		panel.add(lblNewLabel_2_1);

		txtResumen = new JTextArea();
		txtResumen.setBounds(24, 130, 533, 96);
		panel.add(txtResumen);

		JLabel lblNewLabel_2 = new JLabel("Autores");
		lblNewLabel_2.setBounds(24, 243, 45, 13);
		panel.add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 266, 533, 163);
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index = table.getSelectedRow();
				if (index >= 0) {
					btnEliminar.setEnabled(true);
				}
			}
		});
		scrollPane.setViewportView(table);
		AutorModel = new DefaultTableModel();
		String headers[] = { "Autores" };
		AutorModel.setColumnIdentifiers(headers);
		table.setModel(AutorModel);
		scrollPane.setViewportView(table);

		txtAutor = new JTextField();
		txtAutor.setBounds(24, 445, 327, 19);
		panel.add(txtAutor);
		txtAutor.setColumns(10);

		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtAutor.getText().equals("")) {
					autores.add(txtAutor.getText().toString());
					LoadAutores();
					txtAutor.setText("");
				}
			}
		});
		btnNewButton.setBounds(361, 445, 92, 21);
		panel.add(btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("Area de estudio:");
		lblNewLabel_3.setBounds(23, 71, 130, 14);
		panel.add(lblNewLabel_3);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Matemáticas", "Lógica", "Computación", "Física",
				"Química", "Biología", "Astronomía", "Geología", "Sociología", "Psicología", "Economía", "Antropología",
				"Ciencias Políticas", "Ingeniería", "Medicina", "Agronomía", "Bioquímica", "Ecología",
				"Ciencias Ambientales", "Ciencias de Materiales" }));
		comboBox.setBounds(127, 67, 272, 22);
		panel.add(comboBox);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				autores.remove(index);
				LoadAutores();
				btnEliminar.setEnabled(false);
			}
		});
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(465, 444, 92, 21);
		panel.add(btnEliminar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (validarCampos()) {
							if (trabajo == null) {
								TrabajoCientifico tc = new TrabajoCientifico(txtTitulo.getText(), txtResumen.getText(),
										comboBox.getSelectedItem().toString(), autores);
								Organizadora.getInstance().insertarTrabajo(tc);
								evento.getMisTrabajosCientificos().add(tc);
								JOptionPane.showMessageDialog(null, "El trabajo cientifico fue agregado exitosamente");
								EditarEvento.LoadTrabajo();
								clear();
							} else {
								trabajo.setTitulo(txtTitulo.getText());
								trabajo.setArea(comboBox.getSelectedItem().toString());
								trabajo.setResumen(txtResumen.getText());
								trabajo.setAutores(autores);
								JOptionPane.showMessageDialog(null,
										"El Trabajo cientifico fue actualizado exitosamente!");
								EditarEvento.LoadTrabajo();
								dispose();
							}

						} else {
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
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadMode(trabajo);
	}

	public void LoadAutores() {
		AutorModel.setRowCount(0);
		row = new Object[table.getColumnCount()];
		for (String aut : autores) {
			row[0] = aut;
			AutorModel.addRow(row);
		}
	}

	public boolean validarCampos() {

		if (txtTitulo.getText().isEmpty() || txtResumen.getText().isEmpty()) {
			return false;
		}

		if (autores.isEmpty()) {
			return false;
		}

		return true;
	}

	public void clear() {
		txtCodigo.setText("TRABAJO-N" + TrabajoCientifico.codigoTrabajoCientifico);
		txtTitulo.setText("");
		txtAutor.setText("");
		txtResumen.setText("");
		comboBox.setSelectedIndex(0);
		autores.clear();
		LoadAutores();
	}

	public void loadMode(TrabajoCientifico tc) {
		if (tc != null) {
			autores = tc.getAutores();
			setTitle("Actualizar Trabajo Cientifico");
			okButton.setText("Actualizar");
			txtCodigo.setText(tc.getCodigo());
			txtTitulo.setText(tc.getTitulo());
			txtResumen.setText(tc.getResumen());
			comboBox.setSelectedItem(tc.getArea());
			LoadAutores();
		}
	}
}
