package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AgregarJuardo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarJuardo dialog = new AgregarJuardo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarJuardo() {
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
		
		textField = new JTextField();
		textField.setBounds(82, 30, 113, 19);
		panel.add(textField);
		textField.setEnabled(false);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(205, 33, 68, 13);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(270, 30, 287, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Especialidad:");
		lblNewLabel_2_1.setBounds(24, 77, 92, 13);
		panel.add(lblNewLabel_2_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Biología Molecular",
				"Bioquímica", "Astrofísica", "Ingeniería de Software",
				"Inteligencia Artificial", "Física Cuántica", "Nanotecnología", 
				"Robótica", "Ciencias Ambientales", "Ecología", "Genética", "Microbiología",
				"Ciencias de Materiales", "Química Orgánica", "Ingeniería Civil", 
				"Ingeniería Mecánica", "Ingeniería Eléctrica", "Matemáticas Aplicadas",
				"Estadística", "Geología", "Oceanografía", "Climatología", "Neurociencias",
				"Psicología Cognitiva", "Medicina Interna", "Cirugía", "Pediatría",
				"Oncología", "Cardiología", "Epidemiología", "Fisioterapia", "Bioética", 
				"Sociología", "Antropología", "Arqueología", "Lingüística", 
				"Historia de la Ciencia", "Economía", "Filosofía de la Ciencia",
				"Derecho Ambiental", "Biotecnología", "Ciencias de la Computación",
				"Ingeniería Biomédica", "Ciencias Políticas", "Astronomía", "Farmacología",
				"Ciencias Veterinarias", "Hidrología", "Tecnología Espacial"}));
		comboBox.setBounds(114, 73, 443, 21);
		panel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}


