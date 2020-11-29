package firma;

public class Arbeiter extends Mitarbeiter
{
	private double anzStd;
	private double lohnStd;
	
	
	public Arbeiter(String name, double anzStd, double lohnStd)
	{
		super(name);
		this.anzStd = anzStd;
		this.lohnStd = lohnStd;
	}
	public Arbeiter(String name, double anzStd)
	{
		super(name);
		this.anzStd = anzStd;
	}
	public Arbeiter(String name)
	{
		super(name);
	}
	
	public void setAnzStd(double anzStd) {
		this.anzStd = anzStd;
	}
	public void setLohnStd(double lohnStd) {
		this.lohnStd = lohnStd;
	}
	public double berechneEntgeld()
	{
		return anzStd * lohnStd;
	}
	
	public String toString()
	{
		return "Arbeiter " + super.toString() + " " + anzStd + " * " + lohnStd;
	}
}
