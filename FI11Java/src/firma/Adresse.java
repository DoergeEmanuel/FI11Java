package firma;

public class Adresse 
{
	private String plz;
	private String strasse;
	private String ort;
	
	public Adresse(String plz, String strasse, String ort)
	{
		this.plz = plz;
		this.strasse = strasse;
		this.ort = ort;
	}
	
	public String toString()
	{
		return plz + " " + strasse + " " + ort;
	}
}
