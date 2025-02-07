
public class Gestion
{
	private static Guerra tablaGuerras[];
	private static int nGuerras;
	
	public static void main(String args[])
	{
   
      // Datos de ejemplo para poder hacer pruebas
		// Creacion de varios paises.
		
		Pais francia = new Pais("Francia");
		Pais reinoUnido = new Pais("Reino Unido");
		Pais rusia = new Pais("Rusia");
		Pais usa = new Pais("Estados Unidos");
		Pais austria = new Pais("Austria");
		Pais hungria = new Pais("Hungr�a");
		Pais turquia = new Pais ("Turqu�a");
		Pais alemania = new Pais("Alemania");
		Pais japon = new Pais("Jap�n");
		Pais italia = new Pais("Italia");
		Pais polonia = new Pais("Polonia");
		
		// Creacion de Bandos para las distintas guerras
		
		Bando aliados1 = new Bando("Aliados I");
		Bando centroeuropeo = new Bando("Centro Europeo");
		Bando aliados2 = new Bando("Aliados II");
		Bando eje = new Bando ("Eje Berl�n-Roma-Tokio");
		
		// Añadimos a cada bando de las guerras los paises que lo componian.
		
		aliados1.anadePais(francia);
		aliados1.anadePais(reinoUnido);
		aliados1.anadePais(usa);
		aliados1.anadePais(rusia);
		
		centroeuropeo.anadePais(austria);
		centroeuropeo.anadePais(hungria);
		centroeuropeo.anadePais(turquia);
		centroeuropeo.anadePais(alemania);

		aliados2.anadePais(francia);
		aliados2.anadePais(polonia);
		aliados2.anadePais(reinoUnido);
		aliados2.anadePais(usa);
		aliados2.anadePais(rusia);
		
		eje.anadePais(alemania);
		eje.anadePais(italia);
		eje.anadePais(japon);
		
		// creamos varias batallas
		
		Batalla tannenberg = new Batalla("Tannenberg", rusia, alemania);
		Batalla verdun = new Batalla("Verd�n", francia, alemania);
		Batalla gallipoli = new Batalla("Gallipoli", francia, turquia);
		Batalla elAlamein = new Batalla("El Alamein", reinoUnido, alemania);
		Batalla midway = new Batalla("Midway", usa, japon);
		Batalla stalingrado = new Batalla("Stalingrado", alemania, rusia);
		Batalla normandia = new Batalla("Normand�a", usa, alemania);
		
		// creamos dos guerras, con sus respectivos bandos
		
		Guerra mundialI = new Guerra("Primera guerra mundial", aliados1, centroeuropeo);
		Guerra mundialII = new Guerra("Segunda guerra mundial", eje, aliados2);
		
		// colocamos las batallas en las guerras correspondientes
		
		mundialI.anadeBatalla(tannenberg);
		mundialI.anadeBatalla(verdun);
		mundialI.anadeBatalla(gallipoli);
		
		mundialII.anadeBatalla(elAlamein);
		mundialII.anadeBatalla(midway);
		mundialII.anadeBatalla(stalingrado);
		mundialII.anadeBatalla(normandia);
		
		// hacemos que cada pa�s sepa en qu� guerras ha participado
		
		francia.participoEn(mundialI);
		reinoUnido.participoEn(mundialI);
		rusia.participoEn(mundialI);
		usa.participoEn(mundialI);
		austria.participoEn(mundialI);
		hungria.participoEn(mundialI);
		turquia.participoEn(mundialI);
		alemania.participoEn(mundialI);
		
		japon.participoEn(mundialII);
		italia.participoEn(mundialII);
		alemania.participoEn(mundialII);
		polonia.participoEn(mundialII);
		francia.participoEn(mundialII);
		reinoUnido.participoEn(mundialII);
		rusia.participoEn(mundialII);
		usa.participoEn(mundialII);
		
		// por �ltimo colocamos las guerras en la tabla de Guerras de la gesti�n
		
		tablaGuerras = new Guerra[10];
		nGuerras = 0;
		
		tablaGuerras[nGuerras++] = mundialI;
		tablaGuerras[nGuerras++] = mundialII;
		
		// mostramos los datos almacenados
		
		mostrarTablaGuerras();
	
	}

	private static void mostrarTablaGuerras() 
	{
		for(int i=0;i<nGuerras;i++)
		   System.out.println(tablaGuerras[i]);
	}
}
