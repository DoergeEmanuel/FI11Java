package autohaus;

public class Extras
{
	private String bezeichnung;
	private double preis;
	
	public Extras(String bezeichnung, double preis) 
	{
		this.bezeichnung = bezeichnung;
		this.preis = preis;
	}

	
	
	public double getPreis()
	{
		return preis;
	}



	@Override
	public String toString()
	{
		return bezeichnung;
	}
	
	
	
}
