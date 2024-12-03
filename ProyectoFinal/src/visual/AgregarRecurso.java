package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Organizadora;
import logico.Participante;
import logico.Recurso;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AgregarRecurso extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtCodigo;
	private JTextField txtPrecio;
	private JComboBox comboBox1;
	private JComboBox comboBox2;
	private JButton okButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Recurso recurso = new Recurso("Proyector","LA BOCINA","Epson",1000);
			AgregarRecurso dialog = new AgregarRecurso(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarRecurso(Recurso recurso) {
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
				txtNombre = new JTextField();
				txtNombre.setBounds(72, 20, 140, 19);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Codigo:");
				lblNewLabel_1.setBounds(236, 23, 55, 13);
				panel.add(lblNewLabel_1);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setEnabled(false);
				txtCodigo.setBounds(301, 20, 140, 19);
				panel.add(txtCodigo);
				txtCodigo.setColumns(10);
				txtCodigo.setText("RECURSO-N"+Recurso.codigoRecurso);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Tipo:");
				lblNewLabel_2.setBounds(10, 63, 45, 13);
				panel.add(lblNewLabel_2);
			}
			{
				comboBox1 = new JComboBox();
				comboBox1.setModel(new DefaultComboBoxModel(new String[] {"Proyector", "Micrófonos", "Altavoces", "Pantalla", "Computadora portátil", "Wi-Fi", "Sillas", "Mesas", "Escenario", "Iluminación", "Pizarra blanca", "Marcadores", "Cámara de video", "Cámara fotográfica", "Podio"}));
				comboBox1.setBounds(72, 59, 140, 21);
				panel.add(comboBox1);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Marca:");
				lblNewLabel_3.setBounds(236, 63, 55, 13);
				panel.add(lblNewLabel_3);
			}
			{
				comboBox2 = new JComboBox();
				comboBox2.setModel(new DefaultComboBoxModel(new String[] {"Epson", "Sony", "BenQ", "ViewSonic", "Optoma", "LG", "Samsung", "Panasonic", "Sharp", "Christie"}));
				comboBox2.setBounds(301, 59, 140, 21);
				panel.add(comboBox2);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Precio:");
				lblNewLabel_4.setBounds(10, 103, 45, 13);
				panel.add(lblNewLabel_4);
			}
			{
				txtPrecio = new JTextField();
				txtPrecio.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						 char caracter = e.getKeyChar();
			                if (((caracter < '0') || (caracter > '9'))
			                        && (caracter != '\b')) {
			                    e.consume();
			                }
					}
				});
				txtPrecio.setColumns(10);
				txtPrecio.setBounds(72, 100, 140, 19);
				panel.add(txtPrecio);
			}
		}
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
							if(recurso == null)
							{
								Recurso recurso = new Recurso(comboBox1.getSelectedItem().toString(),txtNombre.getText()
										,comboBox2.getSelectedItem().toString(),Float.valueOf(txtPrecio.getText()));
								Organizadora.getInstance().insertarRecurso(recurso);
								JOptionPane.showMessageDialog(null, "El Recurso fue agregado exitosamente!");
								clear();
							}else {
								recurso.setNombre(txtNombre.getText());
								recurso.setPrecio(Float.valueOf(txtPrecio.getText()));
								recurso.setMarca(comboBox2.getSelectedItem().toString());
								recurso.setTipo(comboBox1.getSelectedItem().toString());
								JOptionPane.showMessageDialog(null, "El Recurso fue actualizado exitosamente!");
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
		loadMode(recurso);
	}
	
	public boolean validarCampos() {
		 
	    if (txtNombre.getText().isEmpty() || txtPrecio.getText().isEmpty())
	    {
	        return false;
	    }

	    return true;
	}
	
	public void clear()
	{
		txtCodigo.setText("RECURSO-N"+Recurso.codigoRecurso);
		txtNombre.setText("");
		txtPrecio.setText("");
		comboBox1.setSelectedIndex(0);
		comboBox2.setSelectedIndex(0);
	}
	
	public void loadMode(Recurso recurso)
	{
		if(recurso != null)
		{
			setTitle("Actualizar Recurso");
			okButton.setText("Actualizar");
			txtNombre.setText(recurso.getNombre());
			txtCodigo.setText(recurso.getCodigo());
			comboBox1.setSelectedItem(recurso.getTipo());
			comboBox2.setSelectedItem(recurso.getMarca());
			txtPrecio.setText(String.valueOf(recurso.getPrecio()));
		}
	}

}

