package kaufhaus2;

public class Kunde 
{
	private String name;
	private int nummer;
	private String datei;
	private static int anzahl;
	
	
	public Kunde(String name)
	{
		
		this.name = name;
		anzahl++;
		nummer = anzahl;
		
		datei = "Kaufhaus/Bestellungen/" + name + nummer + ".txt"; 
		
		
	}
	protected String getDatei() {
		return datei;
	}
}
