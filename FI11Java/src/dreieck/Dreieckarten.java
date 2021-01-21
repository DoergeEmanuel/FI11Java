package dreieck;

public abstract class Dreieckarten implements Flaecheninhalt
{
	double a;
	double b;
	double c;
	
	
	
	
	

	
	public double flaeche()
	{
		return (a * hoehe() / 2);
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
