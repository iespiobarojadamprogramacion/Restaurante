package restaurante;

import java.util.Scanner;
import restaurante.modelo.*;

public class Principal {
	
	private static SistemaGestion sistemaGestion = new SistemaGestion();

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		boolean cerrar = false;
		
		//Dar de alta mesas
		sistemaGestion.agregarMesa(new Mesa(1, 2));
		sistemaGestion.agregarMesa(new Mesa(2, 4));
		sistemaGestion.agregarMesa(new Mesa(3, 4));
		sistemaGestion.agregarMesa(new Mesa(4, 6));
		sistemaGestion.agregarMesa(new Mesa(5, 8));
		
		//Bucle de menu
		do {
			menuPrincipal();
			
			int opcion = comprobarNumero(sc.nextLine()); //metodo para validar que el usuario escriba un número
			
			switch(opcion) {
			
			//Reservas
			case 1:
				System.out.print("Escriba el nombre del cliente: ");
				String nombre = sc.nextLine();
				
				//Comprobación si el nombre del cliente existe en la base de datos
				Clientes cliente = sistemaGestion.buscarCliente(nombre);
				
				//Si no existe, creamos un cliente nuevo
				if (cliente == null) {
					System.out.print("Introduzca el telefono del cliente: ");
					String telefono = sc.nextLine();
					
					System.out.print("Introduzca el email del cliente: ");
					String correo = sc.nextLine();
					
					cliente = new Clientes(nombre, telefono, correo);
					sistemaGestion.registrarCliente(cliente);
				}
				
				//Preguntamos por el resto de valores necesarios para hacer una reserva
				System.out.println("Indique la fecha de la reserva");
				String fecha = sc.nextLine();
				
				System.out.println("Indique la hora de la reserva");
				String hora = sc.nextLine();
				
				System.out.println("Indique el número de comensales");
				int comensales = sc.nextInt();
				sc.nextLine(); //Limpiamos el buffer
				
				/*Una reserva tiene una mesa, así que buscamos automaticamente una mesa con la capacidad adecuada 
				 en una hora que esté disponible */
				Mesa mesa = sistemaGestion.buscarMesa(comensales, fecha, hora);
				
				if (mesa != null) {
					
					//Si todo ha salido bien, podemos crear la reserva sin problemas
					Reservas reserva = new Reservas(fecha, hora, comensales, EstadoReservas.Confirmada,mesa, cliente);
					sistemaGestion.crearReserva(reserva);
					
					System.out.println("Reserva confirmada");
					System.out.println("Cliente: " + cliente.obtenerNombre());
					System.out.println("Fecha: " + fecha);
					System.out.println("Hora: " + hora);
					System.out.println("Mesa: " + mesa.getIdentificador());
				} 
				
				//Si no hay mesas disponibles, descartamos la creación de la reserva, no es realista pero por ahora puede servir
				else {
					System.out.println("No hay mesas disponibles a esa hora");
					break;
				}
				
				break;
				
			case 2:
				System.out.println("ADIOS");
				cerrar = true;
				break;
				
			default:
				System.out.println("Opción no válida");
			}
			
		} while (!cerrar);
		
		sc.close();
		
	}
	
	private static void menuPrincipal() {
		System.out.println("Bienvenido al restaurante DAM1"
				+ "\n 1. Reservas"
				+ "\n 2. SALIR");
	}
	
	private static int comprobarNumero(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return -1;
			}
		}
		
		return Integer.parseInt(str);
	}

}
     
