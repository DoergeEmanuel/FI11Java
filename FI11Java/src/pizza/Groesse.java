package pizza;

public class Groesse
{
	private String name;
	private double faktor;
	
	public Groesse(String name, double faktor)
	{
		this.name = name;
		this.faktor = faktor;
	}

	public double getFaktor()
	{
		return faktor;
	}

	@Override
	public String toString()
	{
		return name;
	}	
}
