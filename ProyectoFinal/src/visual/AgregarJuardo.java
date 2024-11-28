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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Biolog�a Molecular",
				"Bioqu�mica", "Astrof�sica", "Ingenier�a de Software",
				"Inteligencia Artificial", "F�sica Cu�ntica", "Nanotecnolog�a", 
				"Rob�tica", "Ciencias Ambientales", "Ecolog�a", "Gen�tica", "Microbiolog�a",
				"Ciencias de Materiales", "Qu�mica Org�nica", "Ingenier�a Civil", 
				"Ingenier�a Mec�nica", "Ingenier�a El�ctrica", "Matem�ticas Aplicadas",
				"Estad�stica", "Geolog�a", "Oceanograf�a", "Climatolog�a", "Neurociencias",
				"Psicolog�a Cognitiva", "Medicina Interna", "Cirug�a", "Pediatr�a",
				"Oncolog�a", "Cardiolog�a", "Epidemiolog�a", "Fisioterapia", "Bio�tica", 
				"Sociolog�a", "Antropolog�a", "Arqueolog�a", "Ling��stica", 
				"Historia de la Ciencia", "Econom�a", "Filosof�a de la Ciencia",
				"Derecho Ambiental", "Biotecnolog�a", "Ciencias de la Computaci�n",
				"Ingenier�a Biom�dica", "Ciencias Pol�ticas", "Astronom�a", "Farmacolog�a",
				"Ciencias Veterinarias", "Hidrolog�a", "Tecnolog�a Espacial"}));
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

