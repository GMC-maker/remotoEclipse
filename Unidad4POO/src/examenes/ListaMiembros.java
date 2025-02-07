package examenes;

import java.util.Arrays;

public class ListaMiembros {
	private Miembro tabla[];

	public Miembro[] getTabla() {
		return tabla;
	}

	public int getTamanyo() {
		return this.tabla.length;
	}

	public ListaMiembros() {
		this.tabla = new Miembro[0];
	}

	public void anyadeMiembro(Miembro m) {
		Miembro[] tablaNueva = new Miembro[this.getTamanyo() + 1];
		/*
		 * for(int i=0;i<this.getTamanyo();i++){ tablaNueva[i] = this.tabla[i]; }
		 */
		tablaNueva[this.getTamanyo()] = m;
		this.tabla = tablaNueva;
	}

	public void anyadeMiembroSinRepetir(Miembro m) {
		int posActual = getIndexOf(m);
		
		if(posActual == -1) {
			//tabla[]=m;
		}
	
	}

	public String toString() {
		return Arrays.toString(this.tabla);
	}

	public boolean contieneMiembro(Miembro m) {
		boolean existe = false;
		for (int i = 0; i < this.tabla.length && !existe; i++) {
			if (this.tabla[i].equals(m)) {
				existe = true;
			}
		}
		return existe;
	}

	public void eliminaMiembro(Miembro m) {
	
	int indice = this.getIndexOf(m);
	if(indice <=-1) {
		this.tabla[indice]= this.tabla[this.getTamanyo()-1];
		this.tabla = Arrays.copyOf(tabla, getTamanyo()-1);
	}
	
	}

	private int getIndexOf(Miembro m) {
		int indice = -1;
		for(int i = 0 ; i < this.getTamanyo(); i++) {
			if(tabla[i].equals(m)) {
				indice = i;
			}
		}
		return indice;
	}
	
	

}
