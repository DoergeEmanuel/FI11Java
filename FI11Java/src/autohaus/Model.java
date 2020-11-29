package autohaus;

public class Model 
{
	private String model;
	private Farbe farbe;
	private Ps ps;
	
	
	public Model(String model, Farbe farbe, Ps ps) 
	{
		this.model = model;
		this.farbe = farbe;
		this.ps = ps;
	}

	
	protected String getModel() 
	{
		return model;
	}
	protected Farbe getFarbe() 
	{
		return farbe;
	}
	protected Ps getPs() 
	{
		return ps;
	}
	
	
	@Override
	public String toString() 
	{
		return model;
	}
}
