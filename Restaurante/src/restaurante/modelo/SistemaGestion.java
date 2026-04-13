package restaurante.modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaGestion {

	
//ATRIBUTOS
	// aqui guardamos todos los datos del sistema - PRIMERA FASE
	
	private ArrayList<Clientes> clientes;
	private ArrayList<Reservas> reservas;
	private ArrayList<Plato> menu;
	
	//Las mesas son fijas, por lo que un ArrayList es innecesario
	private Mesa[] mesas = {new Mesa(1,2), new Mesa(2,4), new Mesa(3,4), new Mesa(4,6), new Mesa(5,8)};

	// SEGUNDA FASE
	private ArrayList<Pedido> pedidos;
	private ArrayList<Factura> facturas;
	


	
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

	
//METODO LISTAR MESAS DISPONIBLES
// sirve para mostrar las mesas libres// la lista de mesas
	public void listarMesasDisponibles() {
		for (Mesa m : mesas) {
			if (m.estaDisponible()) {
				System.out.println("Mesa " + m.getIdentificador() + " - Capacidad: " + m.getCapacidad());
			}
		}
	}

	
//METODO BUSCAR MESA
	public Mesa buscarMesa(int comensales, String fecha, String hora) {
		for (Mesa m : mesas) {
			if (m.getCapacidad() >= comensales && m.getEstado() == EstadoMesa.Libre) {
				return m;
			}
		}
		return null;
	}

	
//METODO REGISTRAR CLIENTE
	// guarda el cliente en la lista
	public void registrarCliente(Clientes cliente) {
		// se añade el cliente a la lista de clientes (arraylist)
		clientes.add(cliente);
	}

	
	
//METODO BUSCAR CLIENTE
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

	
//METODO CREAR RESERVA 
	// guarda una reserva en el sistema, los datos lo envía el main
	public void crearReserva(Reservas reserva) {
		reserva.getMesa().reservar(); // Es necesario reservar la mesa, es decir cambiar el estado de la mesa
		reservas.add(reserva);
	}

//METODO BUSCAR RESERVA
	public Reservas buscarReserva(int idReserva) {
		
		for (Reservas r : reservas) {
			 if (r.getIdReserva() == idReserva) {
				 return r;
			 }
		}
		return null;
	}

	
//METODO CONFIRMAR RESERVA
	public void confirmarReserva(int idReserva) {
		for (int i = 0; i < reservas.size(); i++) {
			if (reservas.get(i).getIdReserva() == idReserva) reservas.get(i).confirmar();
		}
	}

//METODO LISTAR RESERVAS
	public void listarReservas() {
		for (Reservas r : reservas) {
			System.out.println(r.toString());
		}
	}

//METODO LISTAR RESERVAS POR FECHA
	public void listarReservasPorFecha(String fecha) {
		for (Reservas r : reservas) {
			if (r.esParaFecha(fecha)) {
				System.out.println("Reserva encontrada en fecha: " + fecha);
			}
		}
	}

//METODO CANCELAR RESERVA
	public void cancelarReserva(int idReserva) {
		for (int i = 0; i < reservas.size(); i++) {
			if (reservas.get(i).getIdReserva() == idReserva) {
				reservas.get(i).getMesa().liberar();  //Hay que marcar la mesa como libre antes de cancelar la reserva
				reservas.get(i).cancelar();
			}
		}
	}

	// SEGUNDA FASE TODO LO COMENTADO SON LO COSAS QUE FALTAN REALIZAR EN LAS CLASES DE MIS COMPAÑEROS 


//METODO CREAR PEDIDO
	// Estos metodos funcionan con lo estan en las clases
	// añade un pedido
	public void crearPedido(Pedido pedido) {
		pedidos.add(pedido);
	}

	
//METODO CREAR PEDIDO SALA	
	public void crearPedidoSala(Clientes cliente, Mesa mesa) {
		
		//obtener fecha actual como String
		String fecha = java.time.LocalDate.now().toString();
		
		PedidoSala pedidoSala= new PedidoSala(fecha, cliente);
		pedidoSala.asignarMesa(mesa);
		mesa.ocupar();  //la mesa pasa a estar ocupada
		pedidos.add(pedidoSala);
		//System.out.print("Pedido en la sala creado. ID" + pedidoSala.getIdPedido());
	}
	
//CREAR PEDIDOS PARA LLEVAR	
//faltan metodos que tienen que hacer los compañeros en sus clases 
	public void crearPedidoLlevar(Clientes cliente, boolean recogidaEnLocal) {
	
		String fecha = java.time.LocalDate.now().toString();
		String direccionEntrega = recogidaEnLocal ? null : "Direccion por Defecto"; //se puede pedir por parametro por defecto
		
		PedidoLlevar pedidoLlevar = new PedidoLlevar(fecha, recogidaEnLocal, direccionEntrega, cliente);
		
		pedidos.add(pedidoLlevar);
		System.out.println("Pedido para llevar por ID" + pedidoLlevar.getIdPedido());
	}
	
	
//METODO AGREGAR PLATO PEDIDO
// metodos realizados pero faltan algunas cosas en sus clases de los compañeros
	public void agregarPlatoAPedido(int idPedido, Plato plato, int cantidad) {
		//buscar el pedido por id
		for(Pedido p : pedidos){
			
			if(p.getIdPedido() == idPedido) {
				
				int idLinea = p.getLineasPedido().size() + 1;
				
				LineaPedido linea = new LineaPedido(idLinea, cantidad, plato, p);
				
				p.agregarLinea(linea);
				System.out.println("Plato agregado al pedido" + idPedido);
				return;	}} 
		System.out.println("Pedido no encontrado");
	}

	
//METODO CERRAR PEDIDO
	public void cerrarPedido(int idPedido) {
		for(Pedido p: pedidos) {
			
		 if(p.getIdPedido() == idPedido) {
			double total = p.calcularImporte();  // corregir este método en Pedido
			
			if (total == 0) {
                System.out.println("El pedido no tiene platos");
                return;
            }
			
			p.cambiarEstado(EstadoPedido.Servido);  // Servido (con 'S' mayúscula)
            
            // Creamos la factura
            Factura factura = new Factura(
                facturas.size() + 1,
                java.time.LocalDate.now().toString(),
                total,
                total * 0.10,  // impuesto
                MetodPago.Efectivo
            );
            facturas.add(factura);
            
            System.out.println("Pedido cerrado. Total: " + (total + total * 0.10) + "€");
            return;
	}
 }
	    System.out.println("Pedido no encontrado");
}
	
	
	
	
	
//METODO LISTAR PLATOS DISPONIBLES
	public void listarPlatosDisponibles() {
		
		System.out.println("=== PLATOS DISPONIBLES ===");
	    for (Plato p : menu) {
	        if (p.isDisponibilidad()) {  
	            System.out.println(p.getIdPlato() + " - " + p.getNombre() + " - " + p.getPrecioUnitario() + "€");
	        }
	    }
}

	
	
//METODO BUSCAR PLATO	
	public void buscarPlato(int idPlato) {
		
		  for (Plato p : menu) {
		        if (p.getIdPlato() == idPlato) {  
		            System.out.println("Plato encontrado: " + p.getNombre() + " - " + p.getPrecioUnitario() + "€");
		            return;
		        }
		  }
		
	}
	
	



}
	
