package restaurante.modelo;
public class Reservas {
	 private static int contador = 1; 
    private int idReserva;
    private String fechaReserva;
    private String horaReserva;
    private int comensales;
    private EstadoReservas estado;

    public Reservas(String fechaReserva, String horaReserva, int comensales, EstadoReservas estado) {
    	this.idReserva = contador++; 
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
        this.comensales = comensales;
        this.estado = estado;
    }

    public void confirmar() {
        estado = EstadoReservas.Confirmada;
    }

    public void cancelar() {
        estado = EstadoReservas.Cancelada;
    }

    public boolean esParaFecha(String fecha) {
        return this.fechaReserva.equals(fecha);
    }
}