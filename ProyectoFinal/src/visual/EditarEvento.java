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
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarEvento extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EditarEvento dialog = new EditarEvento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EditarEvento() {
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
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setBounds(487, 235, 85, 21);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.setBounds(392, 235, 85, 21);
		panel_1.add(btnNewButton_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Participantes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBounds(10, 287, 582, 267);
		contentPanel.add(panel_1_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 22, 562, 203);
		panel_1_1.add(scrollPane_1);
		
		JButton btnNewButton_2 = new JButton("Agregar Participante");
		btnNewButton_2.setBounds(409, 235, 163, 21);
		panel_1_1.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("Eliminar");
		btnNewButton_1_1.setBounds(170, 235, 85, 21);
		panel_1_1.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("Agregar Jurado");
		btnNewButton_2_1.setBounds(265, 235, 134, 21);
		panel_1_1.add(btnNewButton_2_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Trabajos Cientificos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_2.setBounds(602, 10, 582, 267);
		contentPanel.add(panel_1_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 22, 562, 203);
		panel_1_2.add(scrollPane_2);
		
		JButton btnNewButton_3 = new JButton("Agregar");
		btnNewButton_3.setBounds(487, 235, 85, 21);
		panel_1_2.add(btnNewButton_3);
		
		JButton btnNewButton_1_2 = new JButton("Eliminar");
		btnNewButton_1_2.setBounds(392, 235, 85, 21);
		panel_1_2.add(btnNewButton_1_2);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Recursos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_2_1.setBounds(602, 287, 582, 267);
		contentPanel.add(panel_1_2_1);
		
		JScrollPane scrollPane_2_1 = new JScrollPane();
		scrollPane_2_1.setBounds(10, 22, 562, 203);
		panel_1_2_1.add(scrollPane_2_1);
		
		JButton btnNewButton_3_1 = new JButton("Agregar");
		btnNewButton_3_1.setBounds(487, 235, 85, 21);
		panel_1_2_1.add(btnNewButton_3_1);
		
		JButton btnNewButton_1_2_1 = new JButton("Eliminar");
		btnNewButton_1_2_1.setBounds(392, 235, 85, 21);
		panel_1_2_1.add(btnNewButton_1_2_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
