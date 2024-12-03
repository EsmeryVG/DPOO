package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import logico.Jurado;
import logico.Organizadora;
import logico.Persona;
import logico.Recurso;
import logico.Evento;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListaRecursos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private DefaultTableModel RecursoModel;
	private Object[] row;
	private JTable table;
	private ArrayList<Recurso> Rdisponible = new ArrayList<Recurso>();
	private int index;
	private JButton okButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {

			ListaRecursos dialog = new ListaRecursos(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaRecursos(Evento evento) {
		setTitle("Recursos");
		setBounds(100, 100, 531, 405);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Listado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 495, 311);
		contentPanel.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 475, 276);
		panel.add(scrollPane);
		{
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					index = table.getSelectedRow();
					if (index >= 0) {
						okButton.setEnabled(true);
					}
				}
			});
			RecursoModel = new DefaultTableModel();
			String headers[] = { "Nombre", "Tipo", "Marca", "Precio" };
			RecursoModel.setColumnIdentifiers(headers);
			table.setModel(RecursoModel);
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Agregar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						evento.getMisRecursos().add(Rdisponible.get(index));
						Rdisponible.get(index).setDisponibilidad(false);
						EditarEvento.LoadRecurso();
						dispose();
					}
				});
				okButton.setEnabled(false);
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
		LoadRecursos(evento);
	}

	public void LoadRecursos(Evento evento) {
		if (evento == null) {
			return;
		}

		RecursoModel.setRowCount(0);
		row = new Object[table.getColumnCount()];
		for (Recurso recurso : Organizadora.getInstance().getMisRecursos()) {
			if(recurso.getDisponibilidad())
			{
				Rdisponible.add(recurso);
				row[0] = recurso.getNombre();
				row[1] = recurso.getTipo();
				row[2] = recurso.getMarca();
				row[3] = recurso.getPrecio();
				RecursoModel.addRow(row);
			}
		}

	}
}
