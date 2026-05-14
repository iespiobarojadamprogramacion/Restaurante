package restaurante.vista;

import java.awt.*;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import restaurante.modelo.*;
import restaurante.controlador.*;

public class CrearPedidoSalaDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<Clientes> comboCliente;
	private JTextField txtFecha;
	private SistemaGestion sistemaGestion;

	public CrearPedidoSalaDialog(JFrame parent, SistemaGestion sistemaGestion) {
		super(parent, "Crear pedido en sala", true);
		this.sistemaGestion = sistemaGestion;
		
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		// Etiqueta Client
		JLabel lblCliente = new JLabel("Cliente");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 1;
		contentPanel.add(lblCliente, gbc_lblCliente);
		
		//  Clientes
		comboCliente = new JComboBox<Clientes>();
		GridBagConstraints gbc_comboCliente = new GridBagConstraints();
		gbc_comboCliente.insets = new Insets(0, 0, 5, 0);
		gbc_comboCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboCliente.gridx = 2;
		gbc_comboCliente.gridy = 1;
		contentPanel.add(comboCliente, gbc_comboCliente);
		
		for (Clientes c : sistemaGestion.getClientes()) {
			comboCliente.addItem(c);
		}
		
		//  Fecha
		JLabel lblFecha = new JLabel("Fecha (Reserva)");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.insets = new Insets(0, 0, 0, 5);
		gbc_lblFecha.gridx = 0;
		gbc_lblFecha.gridy = 3;
		contentPanel.add(lblFecha, gbc_lblFecha);
		

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
		gbc_txtFecha.gridy = 3;
		contentPanel.add(txtFecha, gbc_txtFecha);
		txtFecha.setColumns(10);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		JButton okButton = new JButton("Crear Pedido");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		// botón Crear
		okButton.addActionListener(e -> {
			ControladorCrearPedidoSala ctrl = new ControladorCrearPedidoSala(sistemaGestion, this);
			ctrl.crearPedido();
		});
		
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		
		// botón Cancelar
		cancelButton.addActionListener(e -> dispose());
	}
	
	// Getters 
	public Clientes getCliente() {
		return (Clientes) comboCliente.getSelectedItem();
	}
	
	public String getFecha() {
		return txtFecha.getText();
	}
	
	public void mostrarMensaje(String str) {
		JOptionPane.showMessageDialog(this, str);
	}
}
