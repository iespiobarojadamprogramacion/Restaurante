package restaurante.vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import restaurante.modelo.SistemaGestion;
import restaurante.controlador.ControladorAgregarPlatoPedido;

public class AgregarPlatoPedidoDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdPedido;
	private JTextField txtIdPlato;
	private JTextField txtCantidad;
	private JTextField txtNotas;
	private SistemaGestion sistemaGestion;

	public AgregarPlatoPedidoDialog(JFrame parent, SistemaGestion sistemaGestion) {
		super(parent, "Agregar plato a pedido", true);
		this.sistemaGestion = sistemaGestion;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		// IDPedido
		JLabel lblIdPedido = new JLabel("ID del Pedido");
		GridBagConstraints gbc_lblIdPedido = new GridBagConstraints();
		gbc_lblIdPedido.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdPedido.gridx = 0;
		gbc_lblIdPedido.gridy = 1;
		contentPanel.add(lblIdPedido, gbc_lblIdPedido);
		
		txtIdPedido = new JTextField();
		GridBagConstraints gbc_txtIdPedido = new GridBagConstraints();
		gbc_txtIdPedido.insets = new Insets(0, 0, 5, 0);
		gbc_txtIdPedido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdPedido.gridx = 2;
		gbc_txtIdPedido.gridy = 1;
		contentPanel.add(txtIdPedido, gbc_txtIdPedido);
		txtIdPedido.setColumns(10);
		
		// ID del Plato
		JLabel lblIdPlato = new JLabel("ID del Plato");
		GridBagConstraints gbc_lblIdPlato = new GridBagConstraints();
		gbc_lblIdPlato.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdPlato.gridx = 0;
		gbc_lblIdPlato.gridy = 3;
		contentPanel.add(lblIdPlato, gbc_lblIdPlato);
		
		txtIdPlato = new JTextField();
		GridBagConstraints gbc_txtIdPlato = new GridBagConstraints();
		gbc_txtIdPlato.insets = new Insets(0, 0, 5, 0);
		gbc_txtIdPlato.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdPlato.gridx = 2;
		gbc_txtIdPlato.gridy = 3;
		contentPanel.add(txtIdPlato, gbc_txtIdPlato);
		txtIdPlato.setColumns(10);
		
		// Cantidad
		JLabel lblCantidad = new JLabel("Cantidad");
		GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
		gbc_lblCantidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantidad.gridx = 0;
		gbc_lblCantidad.gridy = 5;
		contentPanel.add(lblCantidad, gbc_lblCantidad);
		
		txtCantidad = new JTextField();
		GridBagConstraints gbc_txtCantidad = new GridBagConstraints();
		gbc_txtCantidad.insets = new Insets(0, 0, 5, 0);
		gbc_txtCantidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCantidad.gridx = 2;
		gbc_txtCantidad.gridy = 5;
		contentPanel.add(txtCantidad, gbc_txtCantidad);
		txtCantidad.setColumns(10);
		
		// Notas
		JLabel lblNotas = new JLabel("Notas (Opcional)");
		GridBagConstraints gbc_lblNotas = new GridBagConstraints();
		gbc_lblNotas.insets = new Insets(0, 0, 0, 5);
		gbc_lblNotas.gridx = 0;
		gbc_lblNotas.gridy = 7;
		contentPanel.add(lblNotas, gbc_lblNotas);
		
		txtNotas = new JTextField();
		GridBagConstraints gbc_txtNotas = new GridBagConstraints();
		gbc_txtNotas.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNotas.gridx = 2;
		gbc_txtNotas.gridy = 7;
		contentPanel.add(txtNotas, gbc_txtNotas);
		txtNotas.setColumns(10);
		
		// Botones
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		JButton okButton = new JButton("Agregar");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		okButton.addActionListener(e -> {
			ControladorAgregarPlatoPedido ctrl = new ControladorAgregarPlatoPedido(sistemaGestion, this);
			ctrl.agregarPlato();
		});
		
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		cancelButton.addActionListener(e -> dispose());
	}
	
	// Getters 
	public int getIdPedido() throws NumberFormatException {
		return Integer.parseInt(txtIdPedido.getText());
	}
	
	public int getIdPlato() throws NumberFormatException {
		return Integer.parseInt(txtIdPlato.getText());
	}
	
	public int getCantidad() throws NumberFormatException {
		return Integer.parseInt(txtCantidad.getText());
	}
	
	public String getNotas() {
		return txtNotas.getText();
	}
	
	public void mostrarMensaje(String str) {
		JOptionPane.showMessageDialog(this, str);
	}
}