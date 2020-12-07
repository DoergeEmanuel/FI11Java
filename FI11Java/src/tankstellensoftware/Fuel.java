package tankstellensoftware;

public class Fuel
{
	private String name;
	private double preis;
	
	
	public Fuel(String name, double preis)
	{
		this.name = name;
		this.preis = preis;
	}	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public double getPreis()
	{
		return preis;
	}
	public void setPreis(double preis)
	{
		this.preis = preis;
	}

	@Override
	public String toString()
	{
		return name + " " + preis;
	}
}
