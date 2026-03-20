package restaurante.modelo;

public class Mesa {
    // Atributos
    private int identificador;
    private int capacidad;
    private EstadoMesa estado;

    // Constructor
    public Mesa(int identificador, int capacidad) {
        this.identificador = identificador;
        this.capacidad = capacidad;
        this.estado = EstadoMesa.Libre; // por defecto la mesa empieza libre
    }

    // Método que indica si la mesa está disponible
    public boolean estaDisponible() {
        return estado == EstadoMesa.Libre;
    }

    // Método para reservar la mesa
    public void reservar() {
        if (estado == EstadoMesa.Libre) {
            estado = EstadoMesa.Reservada;
        }
    }

    // Método para ocupar la mesa
    public void ocupar() {
        if (estado == EstadoMesa.Reservada || estado == EstadoMesa.Libre) {
            estado = EstadoMesa.Ocupada;
        }
    }

    // Getters
    public int getIdentificador() {
        return identificador;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public EstadoMesa getEstado() {
        return estado;
    }
}
