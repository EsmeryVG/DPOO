package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import logico.Jurado;
import logico.Persona;
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

public class ListaJurados extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private DefaultTableModel JuradoModel;
	private Object[] row;
	private JTable table;
	private ArrayList<Jurado> Jdisponibles = new ArrayList<Jurado>();
	private int index;
	private JButton okButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Evento evento = new Evento("aaa", null, "aaa");
			ArrayList<Jurado> a = new ArrayList<Jurado>();
			ListaJurados dialog = new ListaJurados(a, evento);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaJurados(ArrayList<Jurado> jurados, Evento evento) {
		setTitle("Jurados");
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
			JuradoModel = new DefaultTableModel();
			String headers[] = { "Codigo", "Nombre", "Especialidad" };
			JuradoModel.setColumnIdentifiers(headers);
			table.setModel(JuradoModel);
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
						jurados.add(Jdisponibles.get(index));
						CrearComision.Load(jurados);
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
		LoadJurados(evento, jurados);
	}

	public void LoadJurados(Evento evento, ArrayList<Jurado> jurados) {
		if (evento == null) {
			return;
		}

		if (jurados == null) {
			JuradoModel.setRowCount(0);
			row = new Object[table.getColumnCount()];
			for (Persona persona : evento.getMisParticipantes()) {
				if (persona instanceof Jurado) {
					Jurado jr = (Jurado) persona;
					Jdisponibles.add(jr);
					row[0] = jr.getCodigo();
					row[1] = jr.getNombre();
					row[2] = jr.getEspecialidad();
					JuradoModel.addRow(row);
				}

			}
		} else {
			JuradoModel.setRowCount(0);
			row = new Object[table.getColumnCount()];
			for (Persona persona : evento.getMisParticipantes()) {
				if (persona instanceof Jurado) {
					if (!jurados.contains(persona)) {
						Jurado jr = (Jurado) persona;
						Jdisponibles.add(jr);
						row[0] = jr.getCodigo();
						row[1] = jr.getNombre();
						row[2] = jr.getEspecialidad();
						JuradoModel.addRow(row);
					}
				}

			}
		}

	}
}
