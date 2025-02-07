package examen2018ListaMiembros;


public class Miembro 
{
	private String email;
	private String nombre;
	private ListaMiembros amigos;


	public Miembro(String email, String nombre)
	{
		this.email = email;
		this.nombre = nombre;
		this.amigos = new ListaMiembros();
	}



	public ListaMiembros getAmigos()
	{
		return amigos;
	}


	public String toString()
	{
		return this.email+" - "+this.nombre;
	}
	
	public void anyadeAmigo(Miembro b)
	{
		this.amigos.anyadeMiembroSinRepetir(b);
	}

	public boolean tieneComoAmigoA(Miembro otro)
	{
		return this.amigos.contieneMiembro(otro);
	}

	public void eliminaAmigo(Miembro m)
	{
		this.amigos.eliminaMiembro(m);
	}

	public ListaMiembros personasQueQuizaConozca()
	{
		return null;
	}


	public ListaMiembros amigosEnComun(Miembro b)
	{
		return null;
	}

	public boolean tieneLosMismosAmigosQue(Miembro b)
	{
	  return true;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Miembro other = (Miembro) obj;
		if (email == null)
		{
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}




}
