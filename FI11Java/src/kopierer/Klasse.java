package kopierer;

import java.util.List;

public class Klasse
{
	public static <T> void auflisten(List<? extends T> liste)
	{
		for(T element : liste)
		{
			System.out.println(element);
		}
		
	}
	
	public void hinzufuegen(List<? super Buch> liste)
	{
		liste.add(new Buch("buch5"));
	}
	
}
