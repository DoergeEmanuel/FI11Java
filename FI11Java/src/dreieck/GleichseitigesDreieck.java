package dreieck;

public class GleichseitigesDreieck extends Dreieckarten
{

	public GleichseitigesDreieck(double a)
	{
		this.a = a;
	}

	@Override
	public double hoehe()
	{
		return ((a/2) * Math.sqrt(3.0));
	}

	public double berechneWinkel()
	{
		return (Math.acos((a*a-a*a-a*a)/(-2*a*a))*180/Math.PI);
	}
	
	@Override
	public double umfang()
	{
		return a + a + a;
	}
	
	
}
