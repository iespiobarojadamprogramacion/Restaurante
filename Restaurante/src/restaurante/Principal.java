package restaurante;

import java.util.Scanner;
import restaurante.modelo.*;

public class Principal {

	private static SistemaGestion sistemaGestion = new SistemaGestion();

	private static String fecha;
	private static int idReserva;
	private static int idPedido;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean cerrar = false;

		// Bucle de menu
		do {
			menuPrincipal();

			int opcion = comprobarNumero(sc.nextLine()); // metodo para validar que el usuario escriba un número

			switch (opcion) {

			// Reservas
			case 1:
				System.out.print("Escriba el nombre del cliente: ");
				String nombre = sc.nextLine();

				// Comprobación si el nombre del cliente existe en la base de datos
				Clientes cliente = sistemaGestion.buscarCliente(nombre);

				// Si no existe, creamos un cliente nuevo
				if (cliente == null) {
					System.out.print("Introduzca el telefono del cliente: ");
					String telefono = sc.nextLine();

					System.out.print("Introduzca el email del cliente: ");
					String correo = sc.nextLine();

					cliente = new Clientes(nombre, telefono, correo);
					sistemaGestion.registrarCliente(cliente);
				}

				// Preguntamos por el resto de valores necesarios para hacer una reserva
				System.out.print("Indique la fecha de la reserva: ");
				String fecha = sc.nextLine();

				System.out.print("Indique la hora de la reserva: ");
				String hora = sc.nextLine();

				System.out.print("Indique el número de comensales: ");
				int comensales = sc.nextInt();
				sc.nextLine(); // Limpiamos el buffer

				/*
				 * Una reserva tiene una mesa, así que buscamos automaticamente una mesa con la
				 * capacidad adecuada en una hora que esté disponible
				 */
				Mesa mesa = sistemaGestion.buscarMesa(comensales, fecha, hora);

				if (mesa != null) {

					// Si todo ha salido bien, podemos crear la reserva sin problemas
					Reservas reserva = new Reservas(fecha, hora, comensales, mesa, cliente);
					sistemaGestion.crearReserva(reserva);

					System.out.println("Reserva confirmada");
					System.out.println(reserva.toString());
				}

				// Si no hay mesas disponibles, descartamos la creación de la reserva, no es
				// realista pero por ahora puede servir
				else {
					System.out.println("No hay mesas disponibles a esa hora");
					break;
				}

				break;

			//Prototipo de sistema para confirmar reservas. Necesita un buen repaso
			case 2:
				sistemaGestion.listarReservas();

				System.out.println("Indique el codigo ID de la reserva a confirmar o '0' para salir");
				idReserva = sc.nextInt();
				sc.nextLine();

				if (idReserva != 0) {
					sistemaGestion.confirmarReserva(idReserva);

				}

				break;
			
			//Prototipo de sistema para cancelar reservas. Tambien necesita un repaso.
			case 3:
				sistemaGestion.listarReservas();

				System.out.println("Indique el codigo ID de la reserva a cancelar o '0' para salir");
				idReserva = sc.nextInt();
				sc.nextLine();

				if (idReserva != 0) {
					sistemaGestion.cancelarReserva(idReserva);

				}

				break;
			
			//Sistema para mostrar en pantalla las reservas. Idealmente, este sistema y los dos anteriores podrían ir integrados
			case 4:
				sistemaGestion.listarReservas();
				break;
				
			case 5:
				System.out.println("Introduce el nombre del cliente");
				nombre = sc.nextLine();
				
				if (sistemaGestion.buscarCliente(nombre) == null) {
					System.out.println("Cliente no encontrado");
					break;
				}
				
				System.out.println("Introduce la fecha de la reserva");
				fecha = sc.nextLine();
				
				sistemaGestion.crearPedidoSala(sistemaGestion.buscarCliente(nombre), fecha);
				break;
				
			case 6:
				String direccion = "";
				
				System.out.println("Introduce el nombre del cliente");
				nombre = sc.nextLine();
				
				if (sistemaGestion.buscarCliente(nombre) == null) {
					System.out.println("Cliente no encontrado");
					break;
				}
				
				System.out.println("Introduce la fecha de la reserva");
				fecha = sc.nextLine();
				
				System.out.println("¿Se recoge en el local?");
				boolean recogidaEnLocal = sc.nextLine().equalsIgnoreCase("si")? true : false;
				
				if (!recogidaEnLocal) {
					System.out.println("Indique la direcceión de entrega");
					direccion = sc.nextLine();
				}
				
				sistemaGestion.crearPedidoLlevar(fecha, recogidaEnLocal, direccion, sistemaGestion.buscarCliente(nombre));
				break;
				
			case 7:
				System.out.println("Introduzca el id del pedido");
				idPedido = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Introduzca el id del plato");
				int idPlato = sc.nextInt();
				sc.nextLine();
				
				Plato plato = sistemaGestion.buscarPlato(idPlato);
					
				System.out.println("Introduce la cantidad");
				int cantidad = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Escriba notas: ");
				String notas = sc.nextLine();
				
				sistemaGestion.agregarPlatoAPedido(idPedido, plato, cantidad, notas);
				break;
				
			case 8:
				System.out.println("Introduce el id del pedido a cerrar");
				idPedido = sc.nextInt();
				sc.nextLine();
				
				sistemaGestion.cerrarPedido(idPedido);
				break;
				
			case 9:
				sistemaGestion.listarPlatosDisponibles();
				break;
				
			case 10:
				TipoPlato tipo = null;
				
				System.out.println("Introduce el nombre del plato");
				nombre = sc.nextLine();
				
				System.out.println("Introduce el tipo de plato");
				try {
					tipo = TipoPlato.valueOf(sc.nextLine());
				} catch (IllegalArgumentException e) {
					tipo = null;
				}
				
				if (tipo == null) break;
				
				System.out.println("Introduce el precio unitario del plato");
				double precio = sc.nextDouble();
				sc.nextLine();
				
				sistemaGestion.añadirPlato(nombre, tipo, precio);
				break;

			case -1:
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
		System.out.println("Bienvenido al restaurante DAM1" + "\n 1. Reservar" + "\n 2. Confirmar reserva"
				+ "\n 3. Cancelar reserva" + "\n 4. Mostrar reservas" + "\n 5. Crear pedido en sala" 
				+ "\n 6. Crear pedido para llevar" + "\n 7. Agregar plato a pedido" + "\n 8. Cerrar un pedido" 
				+ "\n 9. Listar platos disponibles" + "\n 10. Añadir plato" +"\n -1. SALIR");
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



// ESTO ES UNA PRUEBA
