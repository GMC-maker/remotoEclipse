
public class Bando
{
 private String nombre;                   // nombre del bando
 private Pais tablaPaises[];              // paises que formaron este bando
 private int nPaises;                     // numero de paises en la tabla
 public static final int MAX_PAISES = 10; // maximo.
 
 public Bando(String nombre)
 {
	 this.nombre = nombre;
	 this.tablaPaises = new Pais[Bando.MAX_PAISES];
	 this.nPaises = 0;
 }
 
 public void anadePais(Pais pais)
 {
	 this.tablaPaises[nPaises++] = pais;
 }
 
 public String toString()
 {
	 String cad = nombre+"\n";
	 for (int i=0;i<this.nPaises;i++)
		 cad += "                      - "+this.tablaPaises[i]+"\n";
	 return cad;
 }
 
}
