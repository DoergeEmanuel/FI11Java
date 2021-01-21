package fliegen;

public class Testdriver
{
	public static void main(String[] args)
	{
		Fliegen biene = new Biene();
		
		abflug(biene);
		
		
	}
	
	public static void abflug(Fliegen fliegen)
	{
		fliegen.fliegen();
	}
}
