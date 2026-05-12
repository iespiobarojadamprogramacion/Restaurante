package restaurante.vista;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import restaurante.modelo.SistemaGestion;

public class VentanaPrincipal extends JFrame {
	private SistemaGestion sistemaGestion;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		this.sistemaGestion = new SistemaGestion();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setMinimumSize(new Dimension(600, 400));

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu_3 = new JMenu("Archivo");
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Salir del programa");
		mnNewMenu_3.add(mntmNewMenuItem_10);
		mntmNewMenuItem_10.addActionListener(e -> {
			int opcion = JOptionPane.showConfirmDialog(this, 
					"¿Seguro que desea salir?", 
					"Confirmar salida", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.WARNING_MESSAGE);
			
			if (opcion == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		});

		JMenu mnNewMenu = new JMenu("Reservas");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Reservar");
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Confirmar reserva");
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Cancelar reserva");
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Mostrar reservas");
		mnNewMenu.add(mntmNewMenuItem_3);

		JMenu mnNewMenu_1 = new JMenu("Pedidos");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Crear pedido en sala");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		mntmNewMenuItem_4.addActionListener(e -> {
			CrearPedidoSalaDialog dialog = new CrearPedidoSalaDialog(this, sistemaGestion);
			dialog.setVisible(true);
		});

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Crear pedido para llevar");
		mnNewMenu_1.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Agregar plato o pedidio");
		mnNewMenu_1.add(mntmNewMenuItem_6);
		mntmNewMenuItem_6.addActionListener(e -> {
			AgregarPlatoAPedidoDialog dialog = new AgregarPlatoAPedidoDialog(this, sistemaGestion);
			dialog.setVisible(true);
		});

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Cerrar pedido");
		mnNewMenu_1.add(mntmNewMenuItem_7);

		JMenu mnNewMenu_2 = new JMenu("Platos");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Listar platos disponibles");
		mnNewMenu_2.add(mntmNewMenuItem_8);

		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Añadir plato");
		mnNewMenu_2.add(mntmNewMenuItem_9);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridBagLayout());

		JLabel lblNewLabel = new JLabel("<html><div style='text-align: center;'>"
				+ "<span style='font-size: 32px;'><b>Bienvenido</b></span><br>"
				+ "<span style='font-size: 22px;'>a la interfaz del restaurante GRUPO 1</span>" + "</div></html>");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		contentPane.add(lblNewLabel);

	}

}
