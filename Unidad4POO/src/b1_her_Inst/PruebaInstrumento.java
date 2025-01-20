package b1_her_Inst;

public class PruebaInstrumento {

	public static void main(String[] args) {
		
		Piano p1 = new Piano();
		Campana c1 = new Campana();
	
	p1.add(Instrumento.Nota.DO);
	p1.add(Instrumento.Nota.RE);
	p1.add(Instrumento.Nota.MI);
	p1.interpretar();
	
	c1.add(Instrumento.Nota.MI);
	c1.add(Instrumento.Nota.FA);
	c1.add(Instrumento.Nota.SOL);
	c1.interpretar();
	
	
	}

}
