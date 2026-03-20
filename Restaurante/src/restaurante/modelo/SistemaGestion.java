package restaurante.modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaGestion  {
	
//ATRIBUTOS
	//aqui guardamos todos los datos del sistema
	//PRIMERA FASE
	private ArrayList<Clientes> clientes;
	private ArrayList<Reservas> reservas;
	private ArrayList<Mesa> mesas;
	
	//SEGUNDA FASE
	private ArrayList<Pedido> pedidos;
	private ArrayList<Factura> facturas;
	
//CONSTRUCTOR
	//el constructor inicializa las listas, esto sirve para que las listas empiecen vacias
	public SistemaGestion() {
		clientes = new ArrayList<>();
		reservas = new ArrayList<>();
		mesas = new ArrayList<>();
		pedidos = new ArrayList<>();
		facturas = new ArrayList<>();
	}
	
//METODOS
	//sirve para mostrar las mesas libres
	public void listarMesasDisponibles() {
		for(Mesa m: mesas) {
			//TODO:
			//if(m.estaDisponible()) {
			//	System.out.println(m);
			//}
		}
	}
	
	public void buscarMesa(int idMesa) {
		//TODO:
	}
	
	//guarda el cliente en la lista
	public void registrarCliente(Clientes cliente) {
		//se añade el cliente a la lista de clientes (arraylist)
		clientes.add(cliente);
	}
	
	//busca un cliente por su nombre: Si lo encuentra devuelve cliente, sino devuelve un nulo
	public Clientes buscarCliente(String nombre) {
		for(Clientes c: clientes) {
			if(c.obtenerNombre().equals(nombre)) {
				return c;
			}
		}
		return null;
	}
	
	//guarda una reserva en el sistema, los datos lo envía el main
	public void crearReserva(String fecha, String hora, int comensales) {
		//Creamos el objeto reserva, los datos llegan del main.
		//El estado no lo envía el main, lo confirmamos directamente desde el código
		 Reservas reserva = new Reservas(fecha, hora, comensales, EstadoReservas.Confirmada);
		 //Añado la reserva a la lista de reservas (arraylist). 
	     reservas.add(reserva);
		
	}
	
    // Buscar reserva por ID
    public Reservas buscarReserva(int idReserva) {
        // TODO: Hace falta getter en Reservas (esto aún no está hecho, se tiene que hacer el responsable de reservas)
        for (Reservas r : reservas) {
            // if (r.getIdReserva() == idReserva)
        }
        return null;
    }
    
    // Cancelar reserva
    public void cancelarReserva(int idReserva) {
        // TODO: Falta hacer el getter y el metodo cancelar en reservas (esto aún no está hecho, se tiene que hacer el responsable de reservas)
        for (Reservas r : reservas) {
            // if (r.getIdReserva() == idReserva) {
            //     r.cancelar();
            // }
        }
    }
    
    // Confirmar reserva
    public void confirmarReserva(int idReserva) {
        // TODO: Falta hacer el getter y el metodo confirmar en reservas (esto aún no está hecho, se tiene que hacer el responsable de reservas)
        for (Reservas r : reservas) {
            // if (r.getIdReserva() == idReserva) {
            //     r.confirmar();
            // }
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
    
    
    //SEGUNDA FASE
    
	//añade un pedido	 D
	public void crearPedido(Pedido pedido) { pedidos.add(pedido); }	
	
	public void crearPedidoSala(Clientes cliente, Mesa mesa) {}
	
	public void crearPedidoLlevar(Clientes cliente, boolean recogidaEnLocal) {}
	
	public void agregarPlatoAPedido(int idPedido,Plato plato, int cantidad) {}
	
	public void cerrarPedido(int idPlato) {}
	
	public void listarPlatosDisponibles() {}
	
	public void buscarPlato(int idPlato ) {}
	
	public void buscarFactura(int idFactura) {}
	
	
	
	
}
