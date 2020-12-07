package kaufhausDateiHandlerSerialsierung;

import java.io.Serializable;

public class Sortiment implements Serializable
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
	
	protected String getArtikelnummer()
	{
		return artikelnummer;
	}

	protected String getArtikelbezeichnung()
	{
		return artikelbezeichnung;
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
