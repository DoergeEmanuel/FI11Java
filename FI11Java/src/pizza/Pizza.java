package pizza;

public class Pizza
{
	private String name;
	private double preis;
	
	public Pizza(String name, double preis)
	{
		this.name = name;
		this.preis = preis;
	}

	public double getPreis()
	{
		return preis;
		//�nderung
	}

	@Override
	public String toString()
	{
		return name;
	}
}
