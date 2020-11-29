package autohaus;

public class Farbe 
{
	private String farbe;

	
	public Farbe(String farbe)
	{	
		this.farbe = farbe;
	}

	protected String getFarbe() 
	{
		return farbe;
	}
	
	
	@Override
	public String toString() 
	{
		return farbe;
	}
}
