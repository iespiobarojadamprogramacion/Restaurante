package restaurante.modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaGestion {

	
//ATRIBUTOS
	// aqui guardamos todos los datos del sistema
	// PRIMERA FASE
	private ArrayList<Clientes> clientes;
	private ArrayList<Reservas> reservas;
	
	//Las mesas son fijas, por lo que un ArrayList es innecesario
	private Mesa[] mesas = {new Mesa(1,2), new Mesa(2,4), new Mesa(3,4), new Mesa(4,6), new Mesa(5,8)};

	// SEGUNDA FASE
	private ArrayList<Pedido> pedidos;
	private ArrayList<Factura> facturas;
	private ArrayList<Plato> menu;


	
//CONSTRUCTOR
	// el constructor inicializa las listas, esto sirve para que las listas empiecen
	// vacias
	public SistemaGestion() {
		clientes = new ArrayList<>();
		reservas = new ArrayList<>();
		pedidos = new ArrayList<>();
		facturas = new ArrayList<>();
		menu = new ArrayList<>();
		
		// Agrego algunos platos de ejemplo 
		menu.add(new Plato(1, "Ensalada César", TipoPlato.Ensalada, 8.50, true));
		menu.add(new Plato(2, "Solomillo", TipoPlato.Carne, 18.00, true));
		menu.add(new Plato(3, "Tarta de queso", TipoPlato.Postre, 5.50, true));
	}

//METODOS HECHOS - PERO FALTAN COSAS EN LAS OTRAS CLASES
	
	// sirve para mostrar las mesas libres// la lista de mesas
	public void listarMesasDisponibles() {
		for (Mesa m : mesas) {
			if (m.estaDisponible()) {
				System.out.println("Mesa " + m.getIdentificador() + " - Capacidad: " + m.getCapacidad());
			}
		}
	}

	public Mesa buscarMesa(int comensales, String fecha, String hora) {
		for (Mesa m : mesas) {
			if (m.getCapacidad() >= comensales && m.getEstado() == EstadoMesa.Libre) {
				return m;
			}
		}
		return null;
	}

	// guarda el cliente en la lista
	public void registrarCliente(Clientes cliente) {
		// se añade el cliente a la lista de clientes (arraylist)
		clientes.add(cliente);
	}

	// busca un cliente por su nombre: Si lo encuentra devuelve cliente, sino
	// devuelve un nulo
	public Clientes buscarCliente(String nombre) {
		for (Clientes c : clientes) {
			if (c.obtenerNombre().equals(nombre)) {
				return c;
			}
		}
		return null;
	}

	// guarda una reserva en el sistema, los datos lo envía el main
	public void crearReserva(Reservas reserva) {
		reserva.getMesa().reservar(); // Es necesario reservar la mesa, es decir cambiar el estado de la mesa
		reservas.add(reserva);
	}

	// Buscar reserva por ID
	public Reservas buscarReserva(int idReserva) {
		// TODO: Hace falta getter en Reservas (esto aún no está hecho, se tiene que
		// hacer el responsable de reservas)
		for (Reservas r : reservas) {
			// if (r.getIdReserva() == idReserva)
		}
		return null;
	}

	// Confirmar reserva
	public void confirmarReserva(int idReserva) {
		for (int i = 0; i < reservas.size(); i++) {
			if (reservas.get(i).getIdReserva() == idReserva) reservas.get(i).confirmar();
		}
	}

	// Listar reservas
	public void listarReservas() {
		for (Reservas r : reservas) {
			System.out.println(r.toString());
		}
	}

	// Listar reservas por fecha
	public void listarReservasPorFecha(String fecha) {
		for (Reservas r : reservas) {
			if (r.esParaFecha(fecha)) {
				System.out.println("Reserva encontrada en fecha: " + fecha);
			}
		}
	}

	// Cancelar reserva
	public void cancelarReserva(int idReserva) {
		for (int i = 0; i < reservas.size(); i++) {
			if (reservas.get(i).getIdReserva() == idReserva) {
				reservas.get(i).getMesa().liberar();  //Hay que marcar la mesa como libre antes de cancelar la reserva
				reservas.get(i).cancelar();
			}
		}
	}

	// SEGUNDA FASE TODO LO COMENTADO SON LO COSAS QUE FALTAN REALIZAR EN LAS CLASES DE MIS COMPAÑEROS 

	
	// Estos metodos funcionan con lo estan en las clases
	// añade un pedido
	public void crearPedido(Pedido pedido) {
		pedidos.add(pedido);
	}

	
	
	public void crearPedidoSala(Clientes cliente, Mesa mesa) {
		
		//obtener fecha actual como String
		String fecha = java.time.LocalDate.now().toString();
		
		PedidoSala pedidoSala= new PedidoSala(fecha, cliente);
		pedidoSala.asignarMesa(mesa);
		mesa.ocupar();  //la mesa pasa a estar ocupada
		pedidos.add(pedidoSala);
		//System.out.print("Pedido en la sala creado. ID" + pedidoSala.getIdPedido());
	}
	
	
//faltan metodos que tienen que hacer los compañeros en sus clases 
	public void crearPedidoLlevar(Clientes cliente, boolean recogidaEnLocal) {
		/*String fecha = java.time.LocalDate.now().toString();
		String direccionEntrega = recogidaLocal ? null : "Direccion por Defecto"; //se puede pedir por parametro por defecto
		
		PedidoLlevar pedidoLlevar = pedidoLlevar(fecha, recogidaEnLocal, direccionEntrega, cliente);
		
		pedidos.add(pedidoLlevar);
		System.out.println("Pedido para llevar por ID" + pedidoLlevar.getIdPedido());*/
	}
	
	
// metodos realizados pero faltan algunas cosas en sus clases de los compañeros
	public void agregarPlatoAPedido(int idPedido, Plato plato, int cantidad) {
		//buscar el pedido por id
		/*for(Pedido p : pedidos{
			if(p.getIdPedido == IdPedido) {
				//necesitas un metodo para generar un id de pedido
				int idLinea = p.getLineasPedido().size() + 1;
				LineaPedido = linea = new LineaPedido(idLinea, cantidad, plato, "");
				p.agregarLinea(linea);
				System.out.println("Plato agregado al pedido" + idPedido);
				return;	}} System.out.println("Pedido no encontrado");*/
		
		 System.out.println("Método no disponible: faltan getters en Pedido y LineaPedido");
	}

	public void cerrarPedido(int idPedido) {
		//for(Pedido p: pedidos) {
		//if(p.getIdPedido() == idPedido) {
			//	//carbiar estado a servido
		//		p.cambiarEstado(EstadoPedido.estadoServido)
		//	}}
		
		 System.out.println("Método no disponible: calcularImporte() tiene errores");
	}

	
	public void listarPlatosDisponibles() {
		
		System.out.println("=== PLATOS DISPONIBLES ===");
	    for (Plato p : menu) {
	        if (p.disponibilidad) {  // Necesitas getter para disponibilidad en Plato
	            System.out.println(p.getIdPlato() + " - " + p.getNombre() + " - " + p.getPrecioUnitario() + "€");
	        }
	    }
}

	
	public void buscarPlato(int idPlato) {
		
		  for (Plato p : menu) {
		        if (p.getIdPlato() == idPlato) {  // Necesitas getter getIdPlato() en Plato
		            System.out.println("Plato encontrado: " + p.getNombre() + " - " + p.getPrecioUnitario() + "€");
		            return;
		        }
		  }
		
	}
	
	



}
	
