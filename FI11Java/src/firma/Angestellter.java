package firma;

public class Angestellter extends Mitarbeiter
{
	private double gehalt;
	private double zulage;
	
	
	public Angestellter(String name, double gehalt, double zulage)
	{
		super(name);
		this.gehalt = gehalt;
		this.zulage = zulage;
	}
	public double berechneEntgeld()
	{
		return gehalt + zulage;
	}
	public double berechneEntgeld(double zulage)
	{
		this.zulage = zulage;
		return gehalt + zulage;
	}
	
	public String toString()
	{
		return "Angestellter " + super.toString() + " " + gehalt + " + " + zulage;
	}
}
