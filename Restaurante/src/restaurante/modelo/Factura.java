package restaurante.modelo;

public class Factura {
	private static int indice = 0;
    private int idFactura;
    private String fechaFactura;
    private MetodPago metodopago;
    private int impuesto;
    private Pedido pedido;
    
    public Factura(String fechaFactura, MetodPago metodopago, int impuesto, Pedido pedido) {
    	this.idFactura = indice++;
    	this.fechaFactura=fechaFactura;
    	this.metodopago=metodopago;
    	this.pedido=pedido;
    	this.impuesto = impuesto;
    }

	public int getIdFactura() {
		return idFactura;
	}

	public String getFechaFactura() {
		return fechaFactura;
	}

	public double getImpuesto() {
		return impuesto;
	}

	public MetodPago getMetodopago() {
		return metodopago;
	}

	public Pedido getPedido() {
		return pedido;
	}
	
	public double calcularBaseImponible() {
		return pedido.calcularImporte();
	}
	
	public double calcularImpuesto() {
		return calcularBaseImponible() * (impuesto / 100.0);
	}
	
	public double calcularTotal() {
		return calcularBaseImponible() + calcularImpuesto();
	}

	public String Imprimir() {
		return "Factura [idFactura=" + idFactura + ", fechaFactura=" + fechaFactura + ", baseImponible=" + calcularBaseImponible()
				+ ", impuesto=" + impuesto + ", metodopago=" + metodopago + ", pedido=" + pedido + "]";
	}
	
	public void mostrarPedido() {
		System.out.println(pedido);
	}
    
    }
