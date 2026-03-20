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
        this.estado = EstadoMesa.LIBRE; // por defecto la mesa empieza libre
    }

    // Método que indica si la mesa está disponible
    public boolean estaDisponible() {
        return estado == EstadoMesa.LIBRE;
    }

    // Método para reservar la mesa
    public void reservar() {
        if (estado == EstadoMesa.LIBRE) {
            estado = EstadoMesa.RESERVADA;
        }
    }

    // Método para ocupar la mesa
    public void ocupar() {
        if (estado == EstadoMesa.RESERVADA || estado == EstadoMesa.LIBRE) {
            estado = EstadoMesa.OCUPADA;
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
