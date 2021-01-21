package dreieck;

public abstract class Dreieckarten implements Flaecheninhalt
{
	double a;
	double b;
	double c;
	
	
	
	public Dreieckarten(double a, double b, double c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double flaeche()
	{
		return (a * hoehe());
	}
	
	public  abstract double hoehe();
	
	
	
	public abstract double berechneWinkel();
	
	public double winkel()
	{
		return (berechneWinkel() * (180/Math.PI));
		
	}
	
	public double umfang()
	{
		return (a + b + c);
	}
}
