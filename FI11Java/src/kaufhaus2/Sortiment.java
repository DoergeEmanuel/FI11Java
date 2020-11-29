package kaufhaus2;

public class Sortiment 
{
	private String artikelnummer;
	private String artikelbezeichnung;
	private double preis;
	
	public Sortiment(String artikelnummer, String artikelbezeichnung, double preis) 
	{
		this.artikelnummer = artikelnummer;
		this.artikelbezeichnung = artikelbezeichnung;
		this.preis = preis;
	}

	
	
	@Override
	public String toString() 
	{
		return artikelbezeichnung;
	}

	public String getArtikelnummer() {
		return artikelnummer;
	}

	public String getArtikelbezeichnung() {
		return artikelbezeichnung;
	}

	public double getPreis() {
		return preis;
	}
	
	
}
