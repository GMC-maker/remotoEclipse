
public class Pais
{
 private String nombre;						// nombre del pa�s
 private Guerra tablaGuerras[]; 			// guerras en las que ha participado este pa�s.
 private int nGuerras;						// n�mero de elementos en la tabla.
 public static final int MAX_GUERRAS = 10;	// constante con el m�ximo de guerras permitido en un pa�s.
 
 public Pais(String nombre)
 {
	 this.nombre = nombre;
	 this.tablaGuerras = new Guerra[Pais.MAX_GUERRAS];
	 this.nGuerras = 0;
 }

@Override
public String toString()
{
	return nombre;
}

public void participoEn(Guerra guerra) 
{
	this.tablaGuerras[this.nGuerras++] = guerra;
	
}
 
 
 
 
}
