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
import logico.Participante;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class AgregarParticipante extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtEmail;
	private JComboBox comboBox;
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
		
			AgregarParticipante dialog = new AgregarParticipante(null,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarParticipante(Participante participante,Evento evento) {
		setTitle("Registrar Participante");
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
		txtCodigo.setText("PARTICIPANTE-N"+Participante.codigoParticipante);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(205, 33, 68, 13);
		panel.add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(270, 30, 287, 19);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email:");
		lblNewLabel_2.setBounds(217, 77, 45, 13);
		panel.add(lblNewLabel_2);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(270, 74, 287, 19);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Rol:");
		lblNewLabel_2_1.setBounds(24, 77, 45, 13);
		panel.add(lblNewLabel_2_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Organizador", "Ponente", "Moderador", "Panelista", "Asistente", "Invitado especial", "Patrocinador", "Voluntario", "Coordinador", "Técnico de soporte", "Traductor", "Fotógrafo", "Prensa", "Expositor", "Facilitador", "Miembro del equipo de logística"}));
		comboBox.setBounds(59, 73, 136, 21);
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
							if(participante == null)
							{
								Participante prt = new Participante(txtNombre.getText(),txtEmail.getText(),comboBox.getSelectedItem().toString());
								Organizadora.getInstance().insertarPersona(prt);
								evento.getMisParticipantes().add(prt);
								JOptionPane.showMessageDialog(null, "El Participante fue agregado exitosamente!");
								EditarEvento.LoadParticipante();
								clear();
							}else {
								participante.setEmail(txtEmail.getText());
								participante.setNombre(txtNombre.getText());
								participante.setRol(comboBox.getSelectedItem().toString());
								JOptionPane.showMessageDialog(null, "El Participante fue actualizado exitosamente!");
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
				cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadMode(participante);
	}
	
	public boolean validarCampos() {
		 
	    if (txtNombre.getText().isEmpty() || txtEmail.getText().isEmpty())
	    {
	        return false;
	    }

	    return true;
	}
	
	public void clear()
	{
		txtCodigo.setText("PARTICIPANTE-N"+Participante.codigoParticipante);
		txtNombre.setText("");
		txtEmail.setText("");
		comboBox.setSelectedIndex(0);
	}
	
	public void loadMode(Participante participante)
	{
		if(participante != null)
		{
			setTitle("Actualizar Participante");
			okButton.setText("Actualizar");
			txtNombre.setText(participante.getNombre());
			txtCodigo.setText(participante.getCodigo());
			comboBox.setSelectedItem(participante.getRol());
			txtEmail.setText(participante.getEmail());
		}
	}
}
