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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;

import logico.Evento;
import logico.Organizadora;
import logico.Recurso;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarEvento extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JComboBox comboBox;
	private JDateChooser fecha;
	private JButton okButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarEvento dialog = new AgregarEvento(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarEvento(Evento evento) {
		setTitle("Registrar Evento");
		setBounds(100, 100, 616, 220);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Informacion General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 582, 122);
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
		txtCodigo.setText("EVENTO-N"+Evento.codigoEvento);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(205, 33, 68, 13);
		panel.add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(270, 30, 287, 19);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Fecha:");
		lblNewLabel_2_1.setBounds(24, 73, 92, 13);
		panel.add(lblNewLabel_2_1);
		
		fecha = new JDateChooser();
		fecha.setBounds(82, 70, 113, 19);
		panel.add(fecha);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo:");
		lblNewLabel_3.setBounds(205, 73, 57, 13);
		panel.add(lblNewLabel_3);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Conferencia", "Simposio", "Taller", "Seminario", "Congreso", "Congreso Internacional", "Webinar", "Congreso Virtual", "Mesa Redonda", "Panel de Discusión", "Foro Científico", "Exposición Científica"}));
		comboBox.setBounds(270, 69, 287, 21);
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
							if(evento == null)
							{
								Evento evento = new Evento(txtNombre.getText(),fecha.getDate(),comboBox.getSelectedItem().toString());
								Organizadora.getInstance().insertarEvento(evento);
								JOptionPane.showMessageDialog(null, "El Evento fue agregado exitosamente!");
								VerEvento.LoadEventos();
								clear();
							}else {
								evento.setNombre(txtNombre.getText());
								evento.setFecha(fecha.getDate());
								evento.setTipo(comboBox.getSelectedItem().toString());
								JOptionPane.showMessageDialog(null, "El Evento fue actualizado exitosamente!");
								VerEvento.LoadEventos();
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
		loadMode(evento);
	}
	
	public boolean validarCampos() {
		 
	    if (txtNombre.getText().isEmpty() || fecha.getDate() == null)
	    {
	        return false;
	    }

	    return true;
	}
	
	public void clear()
	{
		txtCodigo.setText("EVENTO-N"+Evento.codigoEvento);
		txtNombre.setText("");
		comboBox.setSelectedIndex(0);
		fecha.setDate(null);
	}
	
	public void loadMode(Evento evento)
	{
		if(evento != null)
		{
			setTitle("Actualizar Evento");
			okButton.setText("Actualizar");
			txtNombre.setText(evento.getNombre());
			txtCodigo.setText(evento.getCodigo());
			comboBox.setSelectedItem(evento.getTipo());
			fecha.setDate(evento.getFecha());
		}
	}
}


