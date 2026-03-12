package restaurante.modelo;

public class Factura {
    private int idFactura;
    private String fechaFactura;
    private  double baseImponible;
    private double impuesto;
    private MetodPago metodopago;
    
    public Factura(int idFactura,String fechaFactura,double baseImponible,double impuesto,MetodPago metodopago) {
    	this.idFactura=idFactura;
    	this.fechaFactura=fechaFactura;
    	this.baseImponible=baseImponible;
    	this.metodopago=metodopago;
    }

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(String fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public double getBaseImponible() {
		return baseImponible;
	}

	public void setBaseImponible(double baseImponible) {
		this.baseImponible = baseImponible;
	}

	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}

	public MetodPago getMetodopago() {
		return metodopago;
	}

	public void setMetodopago(MetodPago metodopago) {
		this.metodopago = metodopago;
	}

	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", fechaFactura=" + fechaFactura + ", baseImponible=" + baseImponible
				+ ", impuesto=" + impuesto + ", metodopago=" + metodopago + "]";
	}
     
}
