package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

import logico.Evento;
import logico.Recurso;

public class Reportes extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea textArea;

	
	public Reportes(Evento evento,boolean r) {
		setBounds(100, 100, 574, 696);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 11, 538, 602);
		contentPanel.add(textArea);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
		reporte(evento,r);
	}
	
	public void reporte(Evento evento,boolean a)
	{
		if(a)
		{
			StringBuilder reporte = new StringBuilder();
			float costoTotal = 0;

			reporte.append("Reporte de Recursos Utilizados\n");
			reporte.append("=============================\n\n");

			if (evento.getMisRecursos() == null || evento.getMisRecursos().isEmpty()) {
			    reporte.append("No hay recursos utilizados.\n");
			} else {
			    // Calcular los anchos máximos dinámicamente
			    int maxCodigo = "Código".length() + 4;
			    int maxNombre = "Nombre".length() + 4;
			    int maxMarca = "Marca".length() + 4;
			    int maxCosto = "Costo".length() + 4;

			    for (Recurso recurso : evento.getMisRecursos()) {
			        if (!recurso.getDisponibilidad()) {
			            maxCodigo = Math.max(maxCodigo, recurso.getCodigo().length() + 4);
			            maxNombre = Math.max(maxNombre, recurso.getNombre().length() + 4);
			            maxMarca = Math.max(maxMarca, recurso.getMarca().length() + 4);
			            maxCosto = Math.max(maxCosto, String.format("$%.2f", recurso.getPrecio()).length() + 4);
			        }
			    }

			    // Formato con columnas alineadas con espacios suficientes
			    String formatHeader = String.format("%%-%ds %%-%ds %%-%ds %%-%ds\n", maxCodigo, maxNombre, maxMarca, maxCosto);
			    String formatData = String.format("%%-%ds %%-%ds %%-%ds %%s\n", maxCodigo, maxNombre, maxMarca);

			    // Encabezados
			    reporte.append(String.format(formatHeader, "Código", "Nombre", "Marca", "Costo"));
			    reporte.append(repeat('-', maxCodigo + maxNombre + maxMarca + maxCosto)).append("\n");


			    // Datos de los recursos
			    for (Recurso recurso : evento.getMisRecursos()) {
			        if (!recurso.getDisponibilidad()) {
			            reporte.append(String.format(
			                formatData,
			                recurso.getCodigo(),
			                recurso.getNombre(),
			                recurso.getMarca(),
			                String.format("$%.2f", recurso.getPrecio())
			            ));
			            costoTotal += recurso.getPrecio();
			        }
			    }

			    // Línea de cierre
			    reporte.append(repeat('-', maxCodigo + maxNombre + maxMarca + maxCosto)).append("\n");
			    reporte.append(String.format("Costo Total: $%.2f\n", costoTotal));
			}

			// Mostrar el reporte en el área de texto
			textArea.setText(reporte.toString());

		}
	}
	
	private static String repeat(char c, int count) {
	    StringBuilder builder = new StringBuilder();
	    for (int i = 0; i < count; i++) {
	        builder.append(c);
	    }
	    return builder.toString();
	}

}
