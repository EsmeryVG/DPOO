package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import logico.Jurado;
import logico.Persona;
import logico.TrabajoCientifico;
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

public class ListaTrabajosCientificos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private DefaultTableModel TrabajoModel;
	private Object[] row;
	private JTable table;
	private ArrayList<TrabajoCientifico> Tdisponibles = new ArrayList<TrabajoCientifico>();
	private int index;
	private JButton okButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Evento evento = new Evento("aaa", null, "aaa");
			ArrayList<Jurado> a = new ArrayList<Jurado>();
			ListaTrabajosCientificos dialog = new ListaTrabajosCientificos(null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaTrabajosCientificos(TrabajoCientifico tc, Evento evento) {
		setTitle("Trabajos Cientificos");
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
			TrabajoModel = new DefaultTableModel();
			String headers[] = { "Titulo", "Especialidad" };
			TrabajoModel.setColumnIdentifiers(headers);
			table.setModel(TrabajoModel);
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
						Tdisponibles.get(index).setEstado("Asignado");
						CrearComision.trabajo(Tdisponibles.get(index));
						if(tc != null)
						{
							tc.setEstado("Sin Asignar");
						}
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
		LoadTrabajos(evento, tc);
	}

	public void LoadTrabajos(Evento evento, TrabajoCientifico tc) {
		if (evento == null) {
			return;
		}
		TrabajoModel.setRowCount(0);
		row = new Object[table.getColumnCount()];
		EditarEvento.LoadComision();

		if (tc == null) {
			for (TrabajoCientifico aux : evento.getMisTrabajosCientificos()) {
				if(aux.getEstado().equals("Sin Asignar"))
				{
					Tdisponibles.add(aux);
					row[0] = aux.getTitulo();
					row[1] = aux.getArea();
					TrabajoModel.addRow(row);
				}
			}
		} else {
			for (TrabajoCientifico aux : evento.getMisTrabajosCientificos()) {
				if (!aux.equals(tc) && aux.getEstado().equals("Sin Asignar")) {
					Tdisponibles.add(aux);
					row[0] = aux.getTitulo();
					row[1] = aux.getArea();
					TrabajoModel.addRow(row);
				}
			}
		}

	}
}
