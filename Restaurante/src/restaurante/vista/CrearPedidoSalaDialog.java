package restaurante.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.*;
import java.text.ParseException;

import restaurante.controlador.ControladorFechas;
import restaurante.modelo.*;

public class CrearPedidoSalaDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<Clientes> comboClientes;
	private JTextField txtFecha;
	private SistemaGestion sistemaGestion;

	public CrearPedidoSalaDialog(JFrame parent, SistemaGestion sistemaGestion) {
		super(parent, "Crear pedido en sala", true);
		this.sistemaGestion = sistemaGestion;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCliente = new JLabel("Cliente");
			GridBagConstraints gbc_lblCliente = new GridBagConstraints();
			gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
			gbc_lblCliente.gridx = 0;
			gbc_lblCliente.gridy = 2;
			contentPanel.add(lblCliente, gbc_lblCliente);
		}
		{
			comboClientes = new JComboBox();
			for (Clientes c : sistemaGestion.getClientes()) {
				comboClientes.addItem(c);
			}
			
			GridBagConstraints gbc_comboBoxClientes = new GridBagConstraints();
			gbc_comboBoxClientes.insets = new Insets(0, 0, 5, 0);
			gbc_comboBoxClientes.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxClientes.gridx = 2;
			gbc_comboBoxClientes.gridy = 2;
			contentPanel.add(comboClientes, gbc_comboBoxClientes);
		}
		{
			JLabel lblFecha = new JLabel("Fecha");
			GridBagConstraints gbc_lblFecha = new GridBagConstraints();
			gbc_lblFecha.insets = new Insets(0, 0, 0, 5);
			gbc_lblFecha.gridx = 0;
			gbc_lblFecha.gridy = 5;
			contentPanel.add(lblFecha, gbc_lblFecha);
		}
		{
			MaskFormatter mf = null;
			try {
			    mf = new MaskFormatter("##/##/####");
			    mf.setPlaceholderCharacter('_');
			} catch (ParseException e) {
			    e.printStackTrace();
			}

			txtFecha = new JFormattedTextField(mf);
			GridBagConstraints gbc_txtFecha = new GridBagConstraints();
			gbc_txtFecha.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtFecha.gridx = 2;
			gbc_txtFecha.gridy = 5;
			contentPanel.add(txtFecha, gbc_txtFecha);
			txtFecha.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JLabel lblDaniel = new JLabel("byDaniel");
				lblDaniel.setEnabled(false);
				buttonPane.add(lblDaniel);
			}
			{
				JButton okButton = new JButton("Crear pedido");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(e -> {
					Clientes cliente = (Clientes) comboClientes.getSelectedItem();
					String fecha = txtFecha.getText();
					
					if (!ControladorFechas.esFechaValida(fecha)) {
						JOptionPane.showMessageDialog(this, "La fecha no es válida");
					}
					
					if (cliente == null || fecha.isBlank()) {
						JOptionPane.showMessageDialog(this, "Debe seleccionar cliente y escribir una fecha");
						return;
					}
					
					sistemaGestion.crearPedidoSala(cliente, fecha);
					JOptionPane.showMessageDialog(this, "Pedido creado correctamente");
					dispose();
				});
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(e -> dispose());
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
