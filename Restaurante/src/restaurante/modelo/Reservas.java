package restaurante.modelo;

public class Reservas {
	private static int contador = 1;
	private int idReserva;
	private String fechaReserva;
	private String horaReserva;
	private int comensales;
	private EstadoReservas estado;
	private Mesa mesa;
	private Clientes cliente;

	//Constructor
	public Reservas(String fechaReserva, String horaReserva, int comensales, Mesa mesa,
			Clientes cliente) {
		idReserva = contador++;
		this.fechaReserva = fechaReserva;
		this.horaReserva = horaReserva;
		this.comensales = comensales;
		estado = EstadoReservas.Pendiente;
		this.mesa = mesa;
		this.cliente = cliente;
	}

	//Metodo para confirmar reservas. Si se ha cancelado, no se puede confirmar
	public void confirmar() {
		if (estado == EstadoReservas.Pendiente) estado = EstadoReservas.Confirmada;
		else System.out.println("No se puede confirmar una reserva cancelada");
	}

	//Metodo para cancelar reservas. Si se ha confirmado, no se puede cancelar
	public void cancelar() {
		if (estado == EstadoReservas.Pendiente) estado = EstadoReservas.Cancelada;
		else System.out.println("No se puede cancelar una reserva confirmada");
	}

	//Metodo para confirmar si una hora pertenece a una fecha
	public boolean esParaFecha(String fecha) {
		return this.fechaReserva.equals(fecha);
	}
	
	public EstadoReservas getEstado() {
		return estado;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public String getFechaReserva() {
		return fechaReserva;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public String toString() {
		return idReserva + " " + cliente + " - " + fechaReserva + " - " + horaReserva;
	}
}
