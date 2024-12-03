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

import logico.Evento;
import logico.Jurado;
import logico.Organizadora;
import logico.TrabajoCientifico;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarJuardo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JButton okButton;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Jurado jurado = new Jurado("klkwawa","Ingeniería de Software");
			AgregarJuardo dialog = new AgregarJuardo(null,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarJuardo(Jurado jurado,Evento evento) {
		setTitle("Registrar Jurado");
		setBounds(100, 100, 616, 217);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Informacion General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 582, 125);
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
		txtCodigo.setText("JURADO-N"+Jurado.codigoJurado);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(205, 33, 68, 13);
		panel.add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(270, 30, 287, 19);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Especialidad:");
		lblNewLabel_2_1.setBounds(24, 77, 92, 13);
		panel.add(lblNewLabel_2_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Biología Molecular", "Bioquímica", "Astrofísica", "Ingeniería de Software", "Inteligencia Artificial", "Física Cuántica", "Nanotecnología", "Robótica", "Ciencias Ambientales", "Ecología", "Genética", "Microbiología", "Ciencias de Materiales", "Química Orgánica", "Ingeniería Civil", "Ingeniería Mecánica", "Ingeniería Eléctrica", "Matemáticas Aplicadas", "Estadística", "Geología", "Oceanografía", "Climatología", "Neurociencias", "Psicología Cognitiva", "Medicina Interna", "Cirugía", "Pediatría", "Oncología", "Cardiología", "Epidemiología", "Fisioterapia", "Bioética", "Sociología", "Antropología", "Arqueología", "Lingüística", "Historia de la Ciencia", "Economía", "Filosofía de la Ciencia", "Derecho Ambiental", "Biotecnología", "Ciencias de la Computación", "Ingeniería Biomédica", "Ciencias Políticas", "Astronomía", "Farmacología", "Ciencias Veterinarias", "Hidrología", "Tecnología Espacial"}));
		comboBox.setBounds(114, 73, 443, 21);
		panel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(validarCampos())
						{
							if(jurado == null)
							{
								Jurado jurado = new Jurado(txtNombre.getText(),comboBox.getSelectedItem().toString());
								Organizadora.getInstance().insertarPersona(jurado);
								evento.getMisParticipantes().add(jurado);
								JOptionPane.showMessageDialog(null, "El Jurado fue agregado exitosamente!");
								EditarEvento.LoadParticipante();
								clear();
							}else {
								jurado.setNombre(txtNombre.getText());;
								jurado.setEspecialidad(comboBox.getSelectedItem().toString());
								JOptionPane.showMessageDialog(null, "El Jurado fue actualizado exitosamente!");
								EditarEvento.LoadParticipante();
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
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadMode(jurado);
	}
	
	public boolean validarCampos() {
	 
	    if (txtNombre.getText().isEmpty())
	    {
	        return false;
	    }

	    return true;
	}
	
	public void clear()
	{
		txtCodigo.setText("JURADO-N"+Jurado.codigoJurado);
		txtNombre.setText("");
		comboBox.setSelectedIndex(0);
	}
	
	public void loadMode(Jurado Jurado)
	{
		if(Jurado != null)
		{
			setTitle("Actualizar Jurado");
			okButton.setText("Actualizar");
			txtNombre.setText(Jurado.getNombre());
			txtCodigo.setText(Jurado.getCodigo());
			comboBox.setSelectedItem(Jurado.getEspecialidad());
		}
	}

}
