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
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class CrearComision extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearComision dialog = new CrearComision();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearComision() {
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
				textField = new JTextField();
				textField.setBounds(95, 27, 249, 19);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Codigo:");
				lblNewLabel_1.setBounds(370, 30, 45, 13);
				panel.add(lblNewLabel_1);
			}
			{
				textField_1 = new JTextField();
				textField_1.setEditable(false);
				textField_1.setBounds(425, 27, 149, 19);
				panel.add(textField_1);
				textField_1.setColumns(10);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Descripcion");
				lblNewLabel_2.setBounds(29, 56, 79, 13);
				panel.add(lblNewLabel_2);
			}
			
			JTextArea textArea = new JTextArea();
			textArea.setBounds(29, 80, 545, 89);
			panel.add(textArea);
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
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Agregar Miembro");
		btnNewButton.setBounds(440, 264, 145, 21);
		panel.add(btnNewButton);
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Trabajo Cientifico", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(10, 521, 595, 61);
			contentPanel.add(panel_1);
			panel_1.setLayout(null);
			{
				JLabel lblNewLabel_3 = new JLabel("Nombre:");
				lblNewLabel_3.setBounds(10, 27, 61, 13);
				panel_1.add(lblNewLabel_3);
			}
			{
				textField_2 = new JTextField();
				textField_2.setEditable(false);
				textField_2.setBounds(74, 24, 342, 19);
				panel_1.add(textField_2);
				textField_2.setColumns(10);
			}
			{
				JButton btnAgregarTrabajo = new JButton("Agregar Trabajo");
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
				JButton okButton = new JButton("Crear");
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
