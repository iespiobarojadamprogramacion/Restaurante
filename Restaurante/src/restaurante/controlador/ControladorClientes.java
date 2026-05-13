package restaurante.controlador;

import restaurante.modelo.*;

public class ControladorClientes {
	private SistemaGestion sistemaGestion;
	
	public ControladorClientes (SistemaGestion sistemaGestion) {
		this.sistemaGestion = sistemaGestion;
	}
	
	public Clientes crearCliente (String nombre, String telefono, String email) {
		Clientes c = new Clientes(nombre, telefono, email);
		sistemaGestion.registrarCliente(c);
		return c;
	}
}