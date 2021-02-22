package kopierer;

import java.util.ArrayList;
import java.util.List;

public class Testdriver
{

	public static void main(String[] args)
	{
		Buch b1 = new Buch("buch1");
		Buch b2 = new Buch("buch2");
		Buch b3 = new Buch("buch3");
		Buch b4 = new Buch("buch4");
		
		List<Buch> buecher = new ArrayList<>();
		List<Buch> buecherKopien = new ArrayList<>();
		
		buecher.add(b2);
		buecher.add(b1);
		buecher.add(b3);
		buecher.add(b4);
		
		Kopierer<Buch> buchKopierer = new Kopierer<>();
		buchKopierer.kopiere(buecher, buecherKopien);
		
		/*
		for(Buch b: buecherKopien)
		{
			System.out.println(b);
		}
		*/
		
		
		
		
		Klasse klasse = new Klasse();
		
		//klasse.hinzufuegen(buecherKopien);
		
		//Klasse.<Buch>auflisten(buecherKopien);
		
	
		
		hinzufuegen(buecherKopien);
		/*
		auflisten(buecherKopien);
		*/
	}
	
	
	public static void hinzufuegen(List<? super Buch> liste)
	{
		liste.add(new Buch("buch5"));
		
		for(Object element : liste)
		{
			System.out.println(element);
		}
	}
	/*
	public static <T> void auflisten(List<? extends T> liste)
	{
		for(T element : liste)
		{
			System.out.println(element);
		}
	}
	*/
	public static void auflisten(List<? extends Buch> liste)
	{
		for(Buch element : liste)
		{
			System.out.println(element);
		}
	}
}