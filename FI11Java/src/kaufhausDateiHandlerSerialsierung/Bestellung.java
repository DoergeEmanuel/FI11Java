package kaufhausDateiHandlerSerialsierung;

public class Bestellung 
{
	private String datei;
	private String kundenname;
	private int bestellnummer;
	
	
	
	public Bestellung(String kundenname, int bestellnummer)
	{
		this.kundenname = kundenname;
		this.bestellnummer = bestellnummer;
		
		datei = "Kaufhaus/Bestellungen/" + kundenname + Integer.toString(bestellnummer) + ".txt";
	}
	protected String getKundenname() 
	{
		return kundenname;
	}
	protected String getDatei() 
	{
		return datei;
	}
	
	protected void setDatei(String datei) {
		this.datei = datei;
	}
	
	protected int getBestellnummer() 
	{
		return bestellnummer;
	}
	
	@Override
	public String toString() 
	{
		return kundenname;
	}
}
