package resturante.vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import restaurante.modelo.Clientes;
import restaurante.modelo.Mesa;
import restaurante.modelo.Reservas;
import restaurante.modelo.SistemaGestion;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private SistemaGestion sistema;
	
	private JTextField txtNombre;
	private JTextField txtFecha;
	private JTextField txtHora;
	private JTextField txtComensales;

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

	public VentanaPrincipal() {
		sistema = new SistemaGestion();
		
		// Configuración de la ventana
		setTitle("Restaurante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 400); 
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// ETIQUETAS Y CAMPOS DE TEXTO
		
		JLabel lblNombre = new JLabel("Cliente:");
		lblNombre.setBounds(30, 30, 80, 20);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(120, 30, 150, 20);
		contentPane.add(txtNombre);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(30, 70, 80, 20);
		contentPane.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(120, 70, 150, 20);
		contentPane.add(txtFecha);

		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(30, 110, 80, 20);
		contentPane.add(lblHora);
		
		txtHora = new JTextField();
		txtHora.setBounds(120, 110, 150, 20);
		contentPane.add(txtHora);

		JLabel lblComensales = new JLabel("Comensales:");
		lblComensales.setBounds(30, 150, 90, 20);
		contentPane.add(lblComensales);
		
		txtComensales = new JTextField();
		txtComensales.setBounds(120, 150, 150, 20);
		contentPane.add(txtComensales);

		//  BOTONES 

		JButton btnCrearReserva = new JButton("Crear Reserva");
		btnCrearReserva.setBounds(80, 200, 150, 30);
		contentPane.add(btnCrearReserva);
		
		JButton btnListarReservas = new JButton("Ver Reservas");
		btnListarReservas.setBounds(80, 250, 150, 30);
		contentPane.add(btnListarReservas);
		
		JButton btnVerPlatos = new JButton("Ver Platos");
		btnVerPlatos.setBounds(80, 300, 150, 30);
		contentPane.add(btnVerPlatos);

		// EVENTOS BOTONES
		
		// Crear Reserva
		btnCrearReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre = txtNombre.getText();
					String fecha = txtFecha.getText();
					String hora = txtHora.getText();
					int comensales = Integer.parseInt(txtComensales.getText());

					// Buscar cliente o crearlo
					Clientes c = sistema.buscarCliente(nombre);
					if (c == null) {
						c = new Clientes(nombre, "000000000", "sin@correo.com");
						sistema.registrarCliente(c);
					}

					Mesa m = sistema.buscarMesa(comensales, fecha, hora);
					
					if (m != null) {
						Reservas r = new Reservas(fecha, hora, comensales, m, c);
						sistema.crearReserva(r);
						JOptionPane.showMessageDialog(null, "Reserva creada con éxito.");
					} else {
						JOptionPane.showMessageDialog(null, "No hay mesas libres.");
					}
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error: Revisa los datos introducidos");
				}
			}
		});

		//Ver Reservas
		btnListarReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("--- LISTA DE RESERVAS ---");
				sistema.listarReservas();
				JOptionPane.showMessageDialog(null, "Mira la consola");
			}
		});

		//Ver Platos
		btnVerPlatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.listarPlatosDisponibles();
				JOptionPane.showMessageDialog(null, "Platos listados en la consola de Eclipse");
			}
		});
	}
}
