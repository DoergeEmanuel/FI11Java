package firma;

public class Praktikant extends Mitarbeiter
{
	private double hungerlohn;
	
	
	public Praktikant(String name, double hungerlohn)
	{
		super(name);
		this.hungerlohn = hungerlohn;
	}
	public void setHungerlohn(double hungerlohn)
	{
		this.hungerlohn = hungerlohn;
	}
	public double berechneEntgeld()
	{
		return hungerlohn;
	}
	
	public String toString()
	{
		return "Praktikant " + super.toString();
	}
}
