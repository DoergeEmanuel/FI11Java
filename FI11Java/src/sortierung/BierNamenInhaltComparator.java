package sortierung;

import java.util.Comparator;

public class BierNamenInhaltComparator implements Comparator<Bier>
{
	@Override
	public int compare(Bier bier1, Bier bier2)
	{
		if(bier2.getName() == null && bier1.getName() == null)
		{
			return 0;
		}
		if(bier1.getName() == null)
		{
			return 1;
		}
		if(bier2.getName() == null)
		{
			return -1;
		}
		if(bier1.getName().compareTo(bier2.getName()) == 0)
		{
			if(bier1.getInhalt() == null && bier2.getInhalt() == 0)
			{
				return 0;
			}
			if(bier1.getInhalt() == null)
			{
				return 1;
			}
			if(bier2.getInhalt() == null)
			{
				return -1;
			}
			return bier1.getInhalt().compareTo(bier2.getInhalt()); 
		}
		return bier1.getName().compareTo(bier2.getName()); //-1 heißt das zweite Objekt (bier2) ist übergeordnet, -1 bedeutet das zweite Objekt ist am Ende der Auflistung also unter Z, das erste Objekt ist bei -1 größer das zweite kleiner, -1 heißt das erste Element wird ans Ende gepusht. Von oben gesehen ist das Absteigend
	}
}

