package dreieck;


public class Dreieckartentest
{
	public static void main(String[] args)
	{
		double alpha;
		
		
		double umfang;
		double a = 3;
		double b = 3;
		double c = 3;
		
		GleichschenkligesDreieck gSchenkligDreieck = new GleichschenkligesDreieck(a, b);
		GleichseitigesDreieck gSeitigDreieck = new GleichseitigesDreieck(a);
			
		
		alpha = gSchenkligDreieck.berechneWinkel();
		System.out.println(alpha);
		alpha = gSeitigDreieck.berechneWinkel();
		System.out.println(alpha);
		
		umfang = gSchenkligDreieck.umfang();
		System.out.println(umfang);
		umfang = gSeitigDreieck.umfang();
		System.out.println(umfang);
		
		
		
		berechnen(gSchenkligDreieck);
		
		berechnen(gSeitigDreieck);
	}
	
	public static void berechnen(Flaecheninhalt flaecheninhalt)
	{
		double flaeche = flaecheninhalt.flaeche();
		System.out.println(Math.round(flaeche * 100.0) / 100.0);
		
		double hoehe = flaecheninhalt.hoehe();
		System.out.println(Math.round(hoehe * 100.0) / 100.0);
	}
	
}