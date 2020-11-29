package firma;

public class Chef extends Mitarbeiter
{
	private double basisgehalt;
	
	
	public Chef(String name, double basisgehalt)
	{
		super(name);
		this.basisgehalt = basisgehalt;
	}
	public double berechneEntgeld()
	{
		return basisgehalt;
	}
	
	public String toString()
	{
		return "Chef " + super.toString();
	}
}
