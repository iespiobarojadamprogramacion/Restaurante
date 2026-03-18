package restaurante.modelo;

import java.util.ArrayList;

public class SistemaGestion  {
	
//ATRIBUTOS
	//aqui guardamos todos los datos del sistema
	private ArrayList<Clientes> clientes;
	private ArrayList<Mesa> mesas;
	private ArrayList<Reservas> reservas;
	private ArrayList<Pedido> pedidos;
	private ArrayList<Factura> facturas;
	
//CONSTRUCTOR
	//el constructor inicializa las listas, esto sirve para que las listas empiecen vacias
	public SistemaGestion() {
		clientes = new ArrayList<>();
		mesas = new ArrayList<>();
		reservas = new ArrayList<>();
		pedidos = new ArrayList<>();
		facturas = new ArrayList<>();
	}
	
//METODOS
	//sirve para mostrar las mesas libres
	public void listarMesasDisponibles() {
		for(Mesa m: mesas) {
			if(m.estaDisponible()) {
				System.out.println(m);
			}
		}
	}
	
	public void buscarMesa(int idMesa) {}
	
	//guarda el cliente en la lista
	public void registrarCliente(Cliente clientes) {
		Clientes.add(cliente);
	}
	
	//busca un cliente por su id
	public void buscarCliente(int idCliente) {
		for(Cliente c: clientes) {
			if(c.getIdCliente()== idCliente) {
				return c;
			}
		}
		return null;
	}
	
	//guarda una reserva en el sistema
	public void crearReserva(Reserva reservas) {
		reservas.add(reserva);
	}
		
	//añade un pedido	
	public void crearPedido(Pedido pedido) {
	    pedidos.add(pedido);
	}
	
	public void cancelarReserva(int idReserva) {}
	
	public void confirmarReserva(int idReserva) {}
	
	public void crearPedidoSala(Cliente cliente, Mesa mesa) {}
	
	public void crearPedidoLlevar(Cliente cliente, boolean recogidaEnLocal) {}
	
	public void agregarPlatoAPedido(int idPedido,Plato plato, int cantidad) {}
	
	public void cerrarPedido(int idPlato) {}
	
	public void listarPlatosDisponibles() {}
	
	public void buscarPlato(int idPlato ) {}
	
	public void buscarFactura(int idFactura) {}
	
	}
	
	
}
