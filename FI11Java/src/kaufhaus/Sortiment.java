package kaufhaus;

public class Sortiment 
{
	String artikelnummer;
	String artikelbezeichnung;
	double preis;
	
	public Sortiment(String artikelnummer, String artikelbezeichnung, double preis) 
	{
		this.artikelnummer = artikelnummer;
		this.artikelbezeichnung = artikelbezeichnung;
		this.preis = preis;
	}
	
	
	
	public double getPreis() 
	{
		return preis;
	}


	@Override
	public String toString() 
	{
		return artikelbezeichnung;
	}

	
	
}
