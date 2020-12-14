package sortierung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Testdriver
{
	public static void main (String[] args)
	{
		/*
		int[] unsorted = {5, 6, 1, 123, 32, 80, 74, 8};
		
		System.out.println("Unsortiert");
		System.out.println("------------------");
		
		for(int i : unsorted)
		{
			System.out.println(i);
		}
		Arrays.sort(unsorted);
		System.out.println("Sortiert");
		System.out.println("------------------");
		
		for(int i : unsorted)
		{
			System.out.println(i);
		}
		*/
		/*
		List<String> list = new ArrayList<String>();
		list.add("Sebastian Würkner");
		list.add("Stefan Kiesel");
		list.add("Andreas Pries");
		list.add("Byte-Welt.de");
		list.add("name1");
		list.add("haha");
		list.add("Boris");
		list.add("muh");
		
		System.out.println("Unsortiert");
		System.out.println("------------------");
		
		for(String wort : list)
		{
			System.out.println(wort);
		}
		Collections.sort(list);
		System.out.println("Sortiert");
		System.out.println("------------------");
		
		for(String wort : list)
		{
			System.out.println(wort);
		}
		*/
		
		Bier[] biere =
			{
					new Bier("Würzburger Hofbräu", "Würzburg", 0.25F),
					new Bier(null, "Bremen", 0.24F),
					new Bier(null, "Bremen", 0.13F),
					new Bier("Pbulaner", "München", 25F),
					new Bier("Paulaner", "München", 0.5F),
					new Bier(null, "Bremen", 0.23F),
					new Bier ("Distelhäuser", "Distelhausen", 0.73F),
					new Bier ("Aistelhäuser", "Distelhausen", 0.53F)
			};
		
		System.out.println("Unsortiert");
		System.out.println("------------------");
		
		for(Bier bier : biere)
		{
			System.out.println(bier);
		}
		Arrays.sort(biere);
		System.out.println("Sortiert");
		System.out.println("------------------");
		
		for(Bier bier : biere)
		{
			System.out.println(bier);
		}
	
		/*
		Comparator<Bier> comp = new BierNamenInhaltComparator();
		
		Bier[] biere =
			{
					new Bier("Würzburger Hofbräu", "Würzburg", 0.25F),
					new Bier(null, "Bremen", 0.24F),
					new Bier(null, "Bremen", 0.13F),
					new Bier("Pbulaner", "München", 25F),
					new Bier("Paulaner", "München", 0.5F),
					new Bier(null, "Bremen", 0.23F),
					new Bier ("Distelhäuser", "Distelhausen", 0.73F),
					new Bier ("Aistelhäuser", "Distelhausen", 0.53F)
			};
		
		System.out.println("Unsortiert");
		System.out.println("------------------");
		
		for(Bier bier : biere)
		{
			System.out.println(bier);
		}
		Arrays.sort(biere, comp);
		System.out.println("Sortiert");
		System.out.println("------------------");
		
		for(Bier bier : biere)
		{
			System.out.println(bier);
		}
		*/
	}
}
