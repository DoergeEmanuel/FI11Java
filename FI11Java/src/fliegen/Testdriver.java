package fliegen;

public class Testdriver
{
	public static void main(String[] args)
	{
		Fliegen biene = new Biene();
		Fliegen flugzeug = new Flugzeug();
		
		abflug(biene);
		abflug(flugzeug);
	}
	
	public static void abflug(Fliegen fliegen)
	{
		fliegen.fliegen();
		fliegen.landen();
	}
}
