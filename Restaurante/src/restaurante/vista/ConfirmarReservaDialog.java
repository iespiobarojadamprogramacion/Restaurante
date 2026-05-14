package restaurante.vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import restaurante.controlador.ControladorConfirmarReserva;
import restaurante.modelo.*;

public class ConfirmarReservaDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<Reservas> comboReservas;
	private SistemaGestion sistemaGestion;

	public ConfirmarReservaDialog(JFrame parent, SistemaGestion sistemaGestion) {
		super(parent, "Confirmar reserva", true);
		this.sistemaGestion = sistemaGestion;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblReserva = new JLabel("Reserva");
			GridBagConstraints gbc_lblReserva = new GridBagConstraints();
			gbc_lblReserva.insets = new Insets(0, 0, 0, 5);
			gbc_lblReserva.gridx = 0;
			gbc_lblReserva.gridy = 3;
			contentPanel.add(lblReserva, gbc_lblReserva);
		}
		{
			comboReservas = new JComboBox();
			for (Reservas r : sistemaGestion.getReservasPendientes()) {
				comboReservas.addItem(r);
			}
			
			GridBagConstraints gbc_comboReservas = new GridBagConstraints();
			gbc_comboReservas.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboReservas.gridx = 2;
			gbc_comboReservas.gridy = 3;
			contentPanel.add(comboReservas, gbc_comboReservas);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirmar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
				okButton.addActionListener(e -> {
					ControladorConfirmarReserva ctrl = new ControladorConfirmarReserva(sistemaGestion, this);
					ctrl.confirmar();
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
	
	public Reservas getReservaSeleccionada() {
        return (Reservas) comboReservas.getSelectedItem();
    }

    public void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

}
