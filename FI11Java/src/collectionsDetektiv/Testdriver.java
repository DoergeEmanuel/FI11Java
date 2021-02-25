package collectionsDetektiv;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Testdriver
{
	public static Set<String> verdaechtige;
	public static Set<String> hatAlibi;
	public static Set<String> liebtGold;
	public static Set<String> zugangZumSafe;
	public static Set<String> zugangZumSafeSchluessel;
	public static Set<String> taeter;
	
	public static void main(String[] args)
	{
		taeter = new HashSet<>();	
		
		verdaechtigeAnlegen();
		
		taeter = ermitteln();
		
		System.out.println(taeter);
	
		
	}
	
	private static void verdaechtigeAnlegen()
	{
		//Die Verdächtigen
		String herrMueller = "Herr Müller";
		String frauMueller = "Frau Müller";
		String herrMaier = "Herr Maier";
		String frauMaier = "Frau Maier";
		String derGaertner = "Der Gärtner";
		String diePutzfrau = "Die Putzfrau";
		String dieDiebischeElster = "Die diebische Elster";
		
		verdaechtige = new HashSet<>();	
		verdaechtige.add(herrMueller);
		verdaechtige.add(frauMueller);
		verdaechtige.add(herrMaier);
		verdaechtige.add(frauMaier);
		verdaechtige.add(derGaertner);
		verdaechtige.add(diePutzfrau);
		verdaechtige.add(dieDiebischeElster);
		
		//Beweisstücke
		//Beweisstück A
		hatAlibi = new HashSet<>();
		hatAlibi.add(frauMueller);
		hatAlibi.add(derGaertner);
		
		//Beweisstück B
		liebtGold = new HashSet<>();
		liebtGold.add(frauMueller);
		liebtGold.add(herrMaier);
		liebtGold.add(derGaertner);
		liebtGold.add(diePutzfrau);
		liebtGold.add(dieDiebischeElster);
	
		//Beweisstück C
		zugangZumSafe = new HashSet<>();
		zugangZumSafe.add(herrMueller);
		zugangZumSafe.add(herrMaier);
		zugangZumSafe.add(derGaertner);
		zugangZumSafe.add(diePutzfrau);
		
		//Beweisstück D
		zugangZumSafeSchluessel = new HashSet<>();
		zugangZumSafeSchluessel.add(herrMueller);
		zugangZumSafeSchluessel.add(frauMueller);
		zugangZumSafeSchluessel.add(herrMaier);
		zugangZumSafeSchluessel.add(frauMaier);
		zugangZumSafeSchluessel.add(dieDiebischeElster);
	}
	
	
	private static Set<String> ermitteln()
	{
		Set<String> eingrenzung = new HashSet<String>();
		
		eingrenzung = verdaechtige;
		
		eingrenzung.removeAll(hatAlibi);
		eingrenzung.retainAll(liebtGold);
		eingrenzung.retainAll(zugangZumSafe);
		eingrenzung.retainAll(zugangZumSafeSchluessel);
		
		
		
		return eingrenzung;
	}
		
	
	
}
