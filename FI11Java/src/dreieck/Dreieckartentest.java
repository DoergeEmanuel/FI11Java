package dreieck;


public class Dreieckartentest
{
	public static void main(String[] args)
	{
		
		
		
		
		double a = 3;
		double b = 4;
		double c;
		
		Dreieckarten gSchenkligDreieck = new GleichschenkligesDreieck(a, b);
		Dreieckarten gSeitigDreieck = new GleichseitigesDreieck(a);
			
		
		
		
		System.out.println("abstrakte Klasse:");
		
		berechnen2(gSchenkligDreieck);
		berechnen2(gSeitigDreieck);
		
		System.out.println("Interface:");
		
		berechnen(gSchenkligDreieck);
		
		berechnen(gSeitigDreieck);
	}
	public static void berechnen2(Dreieckarten dreieck)
	{
		double alpha;
		double umfang;
		
		alpha = dreieck.berechneWinkel();
		System.out.println(Math.round(alpha * 100.0) / 100.0);
		umfang = dreieck.umfang();
		System.out.println(Math.round(umfang * 100.0) / 100.0);
	}
	
	public static void berechnen(Flaecheninhalt flaecheninhalt)
	{
		
		double flaeche = flaecheninhalt.flaeche();
		System.out.println(Math.round(flaeche * 100.0) / 100.0);
		
		double hoehe = flaecheninhalt.hoehe();
		System.out.println(Math.round(hoehe * 100.0) / 100.0);
	}
	
}