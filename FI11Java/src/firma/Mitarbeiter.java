package firma;

public abstract class Mitarbeiter 
{
	protected String name;
	protected Adresse adresse;
	
	
	
	public Mitarbeiter(String name)
	{
		this.name = name;
	}

	public abstract double berechneEntgeld();
	
	public double berechneEntgeldPlusBonus(double bonus)
	{
		return berechneEntgeld() + bonus;
	}
	public void setAdresse(Adresse adresse)
	{
		this.adresse = adresse;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		return name + " " + adresse;
	}
	
}
