package dreieck;

public class GleichschenkligesDreieck extends Dreieckarten
{
	
	
	public GleichschenkligesDreieck(double a, double b)
	{
		this.a = a;
		this.b = b;
	}
	
	@Override
	public double hoehe()
	{
		
		return Math.sqrt(a*a-(b/2)*2);
		
	}
	public double berechneWinkel()
	{
		return (Math.acos((a*a-b*b-b*b)/(-2*a*b))*180/Math.PI);
	}
	
	@Override
	public double umfang()
	{
		return a + b + b;
	}

	
	
	
}
