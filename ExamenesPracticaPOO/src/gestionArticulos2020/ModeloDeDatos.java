package gestionArticulos2020;


public class ModeloDeDatos
{

	Articulo tArticulos[];
	Cliente tClientes[];
	Factura tFacturas[];

	public ModeloDeDatos()
	{
		this.tArticulos = new Articulo[0];
		this.tClientes = new Cliente[0];
		this.tFacturas = new Factura[0];
	}

	public void anadeArticulo(Articulo ArticuloNuevo)
	{
		Articulo nuevaTArticulos[] = new Articulo[this.tArticulos.length+1];
		for(int i=0;i<this.tArticulos.length;i++)
			nuevaTArticulos[i] = tArticulos[i];

		nuevaTArticulos[this.tArticulos.length]= ArticuloNuevo;
		this.tArticulos = nuevaTArticulos;
	}

	public void anadeFactura(Factura FacturaNueva)
	{
		Factura nuevaTFacturas[] = new Factura[this.tFacturas.length+1];
		for(int i=0;i<this.tFacturas.length;i++)
			nuevaTFacturas[i] = tFacturas[i];

		nuevaTFacturas[this.tFacturas.length]= FacturaNueva;
		this.tFacturas = nuevaTFacturas;
	}

	public void anadeCliente(Cliente clienteNuevo)
	{
		Cliente nuevaTClientes[] = new Cliente[this.tClientes.length+1];
		for(int i=0;i<this.tClientes.length;i++)
			nuevaTClientes[i] = tClientes[i];

		nuevaTClientes[this.tClientes.length]= clienteNuevo;
		this.tClientes = nuevaTClientes;
	}

	public Factura facturaFusionada(Cliente cliente, int numFra)
	{
		return null;
	}

	public Factura facturaFusionadaResumida(Cliente cliente, int numFra)
	{
		return null;
	}

	public float gastoPorCliente(Cliente cliente)
	{
		return 0;
	}
   
	public Cliente clienteMayorGasto()
	{
		return null;
	}
	
   public Articulo[] ArticulosPorVentas()
	{
		return null;
	}
   
	public int totalUnidadesVendidas(Articulo Articulo)
	{
		return 0;
	}


	
	
}
