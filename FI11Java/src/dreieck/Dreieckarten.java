package dreieck;

public abstract class Dreieckarten implements Flaecheninhalt
{
	double a;
	
	
	
	
	public Dreieckarten(double a)
	{
		this.a = a;
		
	}

	public double flaeche()
	{
		return (a * hoehe());
	}
	
	
	//Das muss nicht sein, weil es bereits im Interface zusammengefasst wird: public  abstract double hoehe();
	
	public abstract double berechneWinkel();
	
	/*
	public double winkel()
	{
		
		
	}
	*/
	public abstract double umfang();

}
