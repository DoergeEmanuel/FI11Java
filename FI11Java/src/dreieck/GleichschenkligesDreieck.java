package dreieck;

public class GleichschenkligesDreieck extends Dreieckarten
{
	public GleichschenkligesDreieck(double a, double b, double c)
	{
		super(a, b, c);
		
	}

	@Override
	public double hoehe()
	{
		
		return (Math.sqrt((a*a-b*b-c*c)/(-2*a*b))*180/Math.PI);
		
	}

	@Override
	public double berechneWinkel()
	{
		return (Math.acos((a*a-b*b-c*c)/(-2*a*b))*180/Math.PI);
	}

	
	
}
