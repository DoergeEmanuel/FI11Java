package dreieck;

public class GleichseitigesDreieck extends Dreieckarten
{

	public GleichseitigesDreieck(double a, double b, double c)
	{
		super(a, b, c);
		
	}

	@Override
	public double hoehe()
	{
		return ((a/2) * Math.sqrt(3.0));
	}
	@Override
	public double berechneWinkel()
	{
		return (Math.acos((a*a-b*b-c*c)/(-2*a*b))*180/Math.PI);
	}
}
