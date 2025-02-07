package examenes;

public class Miembro {
	private String email;
	private String nombre;
	private ListaMiembros amigos;

	public Miembro(String email, String nombre) {
		this.email = email;
		this.nombre = nombre;
		this.amigos = new ListaMiembros();
	}

	public ListaMiembros getAmigos() {
		return amigos;
	}

	public String toString() {
		return this.email + " - " + this.nombre;
	}

	public void anyadeAmigo(Miembro b) {
		this.amigos.anyadeMiembroSinRepetir(b);
	}

	public boolean tieneComoAmigoA(Miembro otro) {
		return this.amigos.contieneMiembro(otro);
	}

	public void eliminaAmigo(Miembro m) {
		this.amigos.eliminaMiembro(m);
	}

	public ListaMiembros personasQueQuizaConozca() {
		ListaMiembros pqqc = new ListaMiembros();
		for (int i = 0; i < this.amigos.getTamanyo(); i++) {
			// recorro mis amigos
			Miembro miAmigo = this.amigos.getTabla()[i];

			for (int j = 0; j < miAmigo.amigos.getTamanyo(); j++) {
				// recorro los amigos de mi amigo
				Miembro amigoDeMiAMigo = miAmigo.amigos.getTabla()[j];
				if (!this.equals(amigoDeMiAMigo) && !this.tieneComoAmigoA(amigoDeMiAMigo)) {
					pqqc.anyadeMiembroSinRepetir(amigoDeMiAMigo);

				}
			}
		}
		return pqqc;
	}

	public ListaMiembros amigosEnComun(Miembro b) {
		ListaMiembros enComun = new ListaMiembros();

		for (int i = 0; i < this.amigos.getTamanyo(); i++) {
			// recorro mis amigos
			Miembro miAmigo = this.amigos.getTabla()[i];

			for (int j = 0; j < miAmigo.amigos.getTamanyo(); j++) {
				// recorro los amigos de mi amigo
				Miembro amigoDeMiAMigo = miAmigo.amigos.getTabla()[j];
				if (!this.equals(amigoDeMiAMigo) && this.tieneComoAmigoA(amigoDeMiAMigo)) {
					enComun.anyadeMiembroSinRepetir(amigoDeMiAMigo);

				}
			}
		}
		return enComun;

	}

	public boolean tieneLosMismosAmigosQue(Miembro b) {
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Miembro other = (Miembro) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

}
