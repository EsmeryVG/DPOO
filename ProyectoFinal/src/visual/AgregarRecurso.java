package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AgregarRecurso extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarRecurso dialog = new AgregarRecurso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarRecurso() {
		setTitle("Registrar Recursos");
		setBounds(100, 100, 507, 243);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Recurso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 10, 473, 142);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Nombre:");
				lblNewLabel.setBounds(10, 23, 74, 13);
				panel.add(lblNewLabel);
			}
			{
				textField = new JTextField();
				textField.setBounds(72, 20, 140, 19);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Codigo:");
				lblNewLabel_1.setBounds(236, 23, 55, 13);
				panel.add(lblNewLabel_1);
			}
			{
				textField_1 = new JTextField();
				textField_1.setEnabled(false);
				textField_1.setBounds(301, 20, 140, 19);
				panel.add(textField_1);
				textField_1.setColumns(10);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Tipo:");
				lblNewLabel_2.setBounds(10, 63, 45, 13);
				panel.add(lblNewLabel_2);
			}
			{
				JComboBox comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"Proyector", "Micrófonos", "Altavoces", "Pantalla", "Computadora portátil", "Wi-Fi", "Sillas", "Mesas", "Escenario", "Iluminación", "Pizarra blanca", "Marcadores", "Cámara de video", "Cámara fotográfica", "Podio"}));
				comboBox.setBounds(72, 59, 140, 21);
				panel.add(comboBox);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Marca:");
				lblNewLabel_3.setBounds(236, 63, 55, 13);
				panel.add(lblNewLabel_3);
			}
			{
				JComboBox comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"Epson", "Sony", "BenQ", "ViewSonic", "Optoma", "LG", "Samsung", "Panasonic", "Sharp", "Christie"}));
				comboBox.setBounds(301, 59, 140, 21);
				panel.add(comboBox);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Precio:");
				lblNewLabel_4.setBounds(10, 103, 45, 13);
				panel.add(lblNewLabel_4);
			}
			{
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(72, 100, 140, 19);
				panel.add(textField_2);
			}
		}
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

