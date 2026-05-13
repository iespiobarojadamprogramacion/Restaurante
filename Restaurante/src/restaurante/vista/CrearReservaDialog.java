package restaurante.vista;

import java.awt.*;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import restaurante.modelo.*;
import restaurante.controlador.*;

public class CrearReservaDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<Clientes> comboCliente;
	private SistemaGestion sistemaGestion;
	private Clientes clienteSeleccionado;
	private JTextField txtFecha;
	private JTextField txtHora;
	private JTextField txtComensales;

	public CrearReservaDialog(JFrame parent, SistemaGestion sistemaGestion) {
		super(parent, "Crear reserva", true);
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
		{
			JLabel lblCliente = new JLabel("Cliente");
			GridBagConstraints gbc_lblCliente = new GridBagConstraints();
			gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
			gbc_lblCliente.gridx = 0;
			gbc_lblCliente.gridy = 1;
			contentPanel.add(lblCliente, gbc_lblCliente);
		}
		{
			comboCliente = new JComboBox();
			GridBagConstraints gbc_comboCliente = new GridBagConstraints();
			gbc_comboCliente.insets = new Insets(0, 0, 5, 0);
			gbc_comboCliente.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboCliente.gridx = 2;
			gbc_comboCliente.gridy = 1;
			contentPanel.add(comboCliente, gbc_comboCliente);
			
			for (Clientes c : sistemaGestion.getClientes()) {
				comboCliente.addItem(c);
			}
		}
		{
			JButton btnCliente = new JButton("Nuevo Cliente");
			GridBagConstraints gbc_btnCliente = new GridBagConstraints();
			gbc_btnCliente.insets = new Insets(0, 0, 5, 0);
			gbc_btnCliente.gridx = 2;
			gbc_btnCliente.gridy = 2;
			contentPanel.add(btnCliente, gbc_btnCliente);
			
			btnCliente.addActionListener(e -> {
				CrearClienteDialog dialog = new CrearClienteDialog(this, sistemaGestion);
				dialog.setVisible(true);
				
				Clientes nuevo = dialog.getClientesCreado();
				if (nuevo != null) {
					comboCliente.addItem(nuevo);
					comboCliente.setSelectedItem(nuevo);
				}
			});
		}
		{
			JLabel lblFecha = new JLabel("Fecha");
			GridBagConstraints gbc_lblFecha = new GridBagConstraints();
			gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
			gbc_lblFecha.gridx = 0;
			gbc_lblFecha.gridy = 3;
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
			gbc_txtFecha.insets = new Insets(0, 0, 5, 0);
			gbc_txtFecha.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtFecha.gridx = 2;
			gbc_txtFecha.gridy = 3;
			contentPanel.add(txtFecha, gbc_txtFecha);
			txtFecha.setColumns(10);
		}
		{
			JLabel lblHora = new JLabel("Hora");
			GridBagConstraints gbc_lblHora = new GridBagConstraints();
			gbc_lblHora.insets = new Insets(0, 0, 5, 5);
			gbc_lblHora.gridx = 0;
			gbc_lblHora.gridy = 5;
			contentPanel.add(lblHora, gbc_lblHora);
		}
		{
			MaskFormatter mf = null;
			try {
			    mf = new MaskFormatter("##:##");
			    mf.setPlaceholderCharacter('_');
			} catch (ParseException e) {
			    e.printStackTrace();
			}
			
			txtHora = new JFormattedTextField(mf);
			GridBagConstraints gbc_txtHora = new GridBagConstraints();
			gbc_txtHora.insets = new Insets(0, 0, 5, 0);
			gbc_txtHora.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtHora.gridx = 2;
			gbc_txtHora.gridy = 5;
			contentPanel.add(txtHora, gbc_txtHora);
			txtHora.setColumns(10);
		}
		{
			JLabel lblComensales = new JLabel("Comensales");
			GridBagConstraints gbc_lblComensales = new GridBagConstraints();
			gbc_lblComensales.insets = new Insets(0, 0, 0, 5);
			gbc_lblComensales.gridx = 0;
			gbc_lblComensales.gridy = 7;
			contentPanel.add(lblComensales, gbc_lblComensales);
		}
		{
			txtComensales = new JTextField();
			GridBagConstraints gbc_txtComensales = new GridBagConstraints();
			gbc_txtComensales.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtComensales.gridx = 2;
			gbc_txtComensales.gridy = 7;
			contentPanel.add(txtComensales, gbc_txtComensales);
			txtComensales.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Crear");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
				okButton.addActionListener(e -> {
					ControladorReservas ctrl = new ControladorReservas(sistemaGestion, this);
					ctrl.crearReserva();
				});
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(e -> dispose());
			}
		}
	}
	
	public Clientes getCliente() {
		return(Clientes) comboCliente.getSelectedItem();
	}
	
	public String getFecha() {
		return txtFecha.getText();
	}
	
	public String getHora() {
		return txtHora.getText();
	}
	
	public int getComensale() {
		return Integer.parseInt(txtComensales.getText());
	}
	
	public void mostrarError (String str) {
		JOptionPane.showMessageDialog(this, str);
	}

}
