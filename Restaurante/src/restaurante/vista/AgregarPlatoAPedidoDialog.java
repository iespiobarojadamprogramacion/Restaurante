package restaurante.vista;

import javax.swing.*;
import java.awt.*;

import restaurante.controlador.ControladorAgregarPlato;
import restaurante.modelo.*;

public class AgregarPlatoAPedidoDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<Pedido> comboPedidos;
	private JComboBox<Plato> comboPlatos;
	private JTextField txtCantidad;
	private JLabel lblNombrePlato;
	private JTextArea txtNotas;
	private SistemaGestion sistemaGestion;

	public AgregarPlatoAPedidoDialog(JFrame parent, SistemaGestion sistemaGestion) {
		super(parent, "Agregar plato a pedido", true);
		this.sistemaGestion = sistemaGestion;

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblIDPedido = new JLabel("ID Pedido");
			GridBagConstraints gbc_lblIDPedido = new GridBagConstraints();
			gbc_lblIDPedido.insets = new Insets(0, 0, 5, 5);
			gbc_lblIDPedido.gridx = 0;
			gbc_lblIDPedido.gridy = 0;
			contentPanel.add(lblIDPedido, gbc_lblIDPedido);
		}
		{
			comboPedidos = new JComboBox<>();
			for (Pedido p : sistemaGestion.getPedidosAbiertos()) {
				comboPedidos.addItem(p);
			}
			
		}
		{
		    GridBagConstraints gbc_comboPedidos = new GridBagConstraints();
		    gbc_comboPedidos.insets = new Insets(0, 0, 5, 0);
		    gbc_comboPedidos.fill = GridBagConstraints.HORIZONTAL;
		    gbc_comboPedidos.gridx = 2;
		    gbc_comboPedidos.gridy = 0;
		    contentPanel.add(comboPedidos, gbc_comboPedidos);
		}
		{
			JLabel lblIDPlato = new JLabel("ID Plato");
			GridBagConstraints gbc_lblIDPlato = new GridBagConstraints();
			gbc_lblIDPlato.insets = new Insets(0, 0, 5, 5);
			gbc_lblIDPlato.gridx = 0;
			gbc_lblIDPlato.gridy = 1;
			contentPanel.add(lblIDPlato, gbc_lblIDPlato);
		}
		{
			comboPlatos = new JComboBox<>();
			for (Plato p : sistemaGestion.getPlatosDisponibles()) {
				comboPlatos.addItem(p);
			}
		}
		{
		    GridBagConstraints gbc_comboPlatos = new GridBagConstraints();
		    gbc_comboPlatos.insets = new Insets(0, 0, 5, 0);
		    gbc_comboPlatos.fill = GridBagConstraints.HORIZONTAL;
		    gbc_comboPlatos.gridx = 2;
		    gbc_comboPlatos.gridy = 1;
		    contentPanel.add(comboPlatos, gbc_comboPlatos);
		}
		{
			lblNombrePlato = new JLabel("");
			GridBagConstraints gbc_lblNombrePlato = new GridBagConstraints();
			gbc_lblNombrePlato.insets = new Insets(0, 0, 5, 0);
			gbc_lblNombrePlato.gridx = 2;
			gbc_lblNombrePlato.gridy = 3;
			contentPanel.add(lblNombrePlato, gbc_lblNombrePlato);
		}
		{
			JLabel lblCantidad = new JLabel("Cantidad");
			GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
			gbc_lblCantidad.insets = new Insets(0, 0, 5, 5);
			gbc_lblCantidad.gridx = 0;
			gbc_lblCantidad.gridy = 4;
			contentPanel.add(lblCantidad, gbc_lblCantidad);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.setColumns(10);
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 2;
			gbc_textField.gridy = 4;
			contentPanel.add(txtCantidad, gbc_textField);
		}
		{
			JLabel lblNotas = new JLabel("Notas");
			GridBagConstraints gbc_lblNotas = new GridBagConstraints();
			gbc_lblNotas.insets = new Insets(0, 0, 0, 5);
			gbc_lblNotas.gridx = 0;
			gbc_lblNotas.gridy = 5;
			contentPanel.add(lblNotas, gbc_lblNotas);
		}
		{
			txtNotas = new JTextArea();
			GridBagConstraints gbc_textArea = new GridBagConstraints();
			gbc_textArea.fill = GridBagConstraints.BOTH;
			gbc_textArea.gridx = 2;
			gbc_textArea.gridy = 5;
			contentPanel.add(txtNotas, gbc_textArea);
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
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);

				okButton.addActionListener(e -> {
					ControladorAgregarPlato ctrl = new ControladorAgregarPlato(sistemaGestion, this);
					ctrl.agregarPlato();
				});

				{
					JButton cancelButton = new JButton("Cancel");
					cancelButton.setActionCommand("Cancelar");
					cancelButton.addActionListener(e -> dispose());
					buttonPane.add(cancelButton);
				}
			}
		}

	}
	
	public Pedido getPedidoSeleccionado() {
		return (Pedido) comboPedidos.getSelectedItem();
	}
	
	public Plato getPlatoSeleccionado() {
	    return (Plato) comboPlatos.getSelectedItem();
	}

	public int getCantidad() {
	    return Integer.parseInt(txtCantidad.getText());
	}

	public String getNotas() {
	    return txtNotas.getText();
	}

	public void mostrarMensaje(String msg) {
	    JOptionPane.showMessageDialog(this, msg);
	}
}
