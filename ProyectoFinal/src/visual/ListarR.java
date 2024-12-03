package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Evento;
import logico.Organizadora;
import logico.Recurso;
import logico.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class ListarR extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JButton btnmodificar;
	private Recurso miRecurso = null;
	private DefaultTableModel RecursoModel;
	private Object[] row;

	public ListarR() {
		setResizable(false);
		setTitle("Recursos");
		setBounds(100, 100, 727, 464);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Listado de Recursos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 13, 685, 356);
		contentPanel.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 23, 661, 320);
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				if (index >= 0) {
					btnmodificar.setEnabled(true);
					miRecurso = Organizadora.getInstance().getMisRecursos().get(index);
					;
				}

			}
		});
		RecursoModel = new DefaultTableModel();
		String headers[] = { "Nombre", "Tipo", "Marca", "Precio" };
		RecursoModel.setColumnIdentifiers(headers);
		table.setModel(RecursoModel);
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnmodificar = new JButton("Modificar");
				btnmodificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AgregarRecurso modificar = new AgregarRecurso(miRecurso);
						modificar.setModal(true);
						modificar.setVisible(true);
						LoadRecursos();
					}
				});
				btnmodificar.setEnabled(false);
				btnmodificar.setActionCommand("OK");
				buttonPane.add(btnmodificar);
				getRootPane().setDefaultButton(btnmodificar);
			}
			{
				JButton btncancelar = new JButton("Cancelar");
				btncancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btncancelar.setActionCommand("Cancel");
				buttonPane.add(btncancelar);
			}
		}
		LoadRecursos();
	}

	public void LoadRecursos() {
		RecursoModel.setRowCount(0);
		row = new Object[table.getColumnCount()];
		for (Recurso recurso : Organizadora.getInstance().getMisRecursos()) {
			if (recurso.getDisponibilidad()) {
				row[0] = recurso.getNombre();
				row[1] = recurso.getTipo();
				row[2] = recurso.getMarca();
				row[3] = recurso.getPrecio();
				RecursoModel.addRow(row);
			}
		}

	}
}