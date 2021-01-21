package dreieck;


public class Dreieckartentest
{
	public static void main(String[] args)
	{
		double alpha;
		
		
		double umfang;
		double a = 4;
		double b = 10;
		double c = 3;
		
		GleichschenkligesDreieck gSchenkligDreieck = new GleichschenkligesDreieck(a, b, c);
		GleichseitigesDreieck gSeitigDreieck = new GleichseitigesDreieck(a, b, c);
			
		
		alpha = gSchenkligDreieck.winkel();
		System.out.println(alpha);
		alpha = gSeitigDreieck.winkel();
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