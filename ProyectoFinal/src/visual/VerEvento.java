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
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;

import logico.Evento;
import logico.Organizadora;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VerEvento extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel EventoModel;
	private static Object[] row;
	private static JTable table;
	int index;
	private JButton btnEditar;
	private JButton btnVer;
	private JButton btnReporte1;
	private JButton btnNewButton;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VerEvento dialog = new VerEvento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VerEvento() {
		setTitle("Registrar Evento");
		setBounds(100, 100, 854, 469);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Listado de Eventos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 10, 818, 371);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 798, 338);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index = table.getSelectedRow();
				if(index >= 0)
				{
					btnEditar.setEnabled(true);
					btnVer.setEnabled(true);
					btnReporte1.setEnabled(true);
					btnEliminar.setEnabled(true);
				}else {
					btnEditar.setEnabled(false);
					btnVer.setEnabled(false);
					btnReporte1.setEnabled(false);
					btnEliminar.setEnabled(false);
				}
			}
		});
		scrollPane.setViewportView(table);
		EventoModel = new DefaultTableModel();
		String headers[] = { "Nombre","Fecha","Tipo","Estado" };
		EventoModel.setColumnIdentifiers(headers);
		table.setModel(EventoModel);
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnNewButton = new JButton("Crear Evento");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AgregarEvento evt = new AgregarEvento(null);
					evt.setModal(true);
					evt.setLocationRelativeTo(null);
					evt.setVisible(true);
				}
			});
			buttonPane.add(btnNewButton);
			{
				btnEditar = new JButton("Editar Informacion");
				btnEditar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AgregarEvento evt = new AgregarEvento(Organizadora.getInstance().getMisEventos().get(index));
						evt.setModal(true);
						evt.setLocationRelativeTo(null);
						evt.setVisible(true);
					}
				});
				
				btnReporte1 = new JButton("Reporte Recursos");
				btnReporte1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Reportes evt = new Reportes(Organizadora.getInstance().getMisEventos().get(index),true);
						evt.setModal(true);
						evt.setLocationRelativeTo(null);
						evt.setVisible(true);
					}
				});
				btnReporte1.setEnabled(false);
				buttonPane.add(btnReporte1);
				
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Organizadora.getInstance().getMisEventos().remove(index);
						btnEditar.setEnabled(false);
						btnVer.setEnabled(false);
						btnReporte1.setEnabled(false);
						btnEliminar.setEnabled(false);
						LoadEventos();
					}
				});
				btnEliminar.setEnabled(false);
				buttonPane.add(btnEliminar);
				btnEditar.setEnabled(false);
				btnEditar.setActionCommand("OK");
				buttonPane.add(btnEditar);
			}
			
			btnVer = new JButton("Gestionar Evento");
			btnVer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EditarEvento evt = new EditarEvento(Organizadora.getInstance().getMisEventos().get(index));
					evt.setModal(true);
					evt.setLocationRelativeTo(null);
					evt.setVisible(true);
				}
			});
			btnVer.setEnabled(false);
			buttonPane.add(btnVer);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		LoadEventos();
		LoadRoles();
	}
	
	static public void LoadEventos() {
		EventoModel.setRowCount(0);
		row = new Object[table.getColumnCount()];
		for (Evento evt: Organizadora.getInstance().getMisEventos()) {
			row[0] = evt.getNombre();
			row[1] = evt.getFecha().toString();
			row[2] = evt.getTipo();
			row[3] = evt.getEstado();
			EventoModel.addRow(row);
		}
	}
	
	private void LoadRoles() {

		if (Organizadora.getLoginUser().getTipo().equalsIgnoreCase("Basico")) {
			btnEditar.setVisible(false);
			btnVer.setVisible(false);
			btnNewButton.setVisible(false);
			btnEliminar.setVisible(false);
		}

	}
}

