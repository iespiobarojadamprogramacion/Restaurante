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

	public Mesa getMesa() {
		return mesa;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public String toString() {
		return "ID Reserva: " + idReserva + "\n Fecha: " + fechaReserva + "\n Hora: " + horaReserva + "\n Mesa: " + mesa.getIdentificador() + "\n Cliente: " + cliente.obtenerNombre()
				+ "\n Estado: " + estado + "\n";
	}
}