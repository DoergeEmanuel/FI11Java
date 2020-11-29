package autohaus;

public class Ps 
{
	private int ps;
	private double preis;
	
	
	public Ps(int ps, double preis) 
	{
		this.ps = ps;
		this.preis = preis;
	}


	protected int getPs() 
	{
		return ps;
	}
	protected double getPreis() 
	{
		return preis;
	}



	@Override
	public String toString()
	{
		return Integer.toString(ps);
	}
	
	
}
