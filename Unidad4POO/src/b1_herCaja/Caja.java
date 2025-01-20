package b1_herCaja;

public class Caja {

	public enum Unidades {
		CM, M
	}

//attributes
	protected double height, width, length;
	protected Unidades unit;
	private double volumen;
	public String etiqueta;
//constructors
	

	public Caja(double height, double width, double length, Unidades unit) {
		super();
		this.height = height;
		this.width = width;
		this.length = length;
		this.unit = unit;

		switch (unit) {
		case M:
			this.volumen = height * width * length;
			break;
		case CM:
			this.volumen = (height / 100) * (width / 100) * (length / 100);
			break;

		}
	}

// methods

	public double getVolumen() {
		return volumen;
	}

	@Override
	public String toString() {
		return "Caja [ H" + height + " x W" + width + " x L" 
	            + length + " "+ unit + " ]" + "\n" + etiqueta;
	}

}
