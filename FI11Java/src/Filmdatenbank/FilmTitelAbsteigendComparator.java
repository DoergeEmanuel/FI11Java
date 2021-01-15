package Filmdatenbank;

import java.util.Comparator;


public class FilmTitelAbsteigendComparator implements Comparator<Film>
{
	@Override
	public int compare(Film film1, Film film2)
	{
		if(film2.getTitel() == null && film1.getTitel() == null)
		{
			return 0;
		}
		if(film1.getTitel() == null)
		{
			return 1;
		}
		if(film1.getTitel() == null)
		{
			return -1;
		}
		
		return film2.getTitel().compareTo(film1.getTitel()); //-1 heißt das zweite Objekt (bier2) ist übergeordnet, -1 bedeutet das zweite Objekt ist am Ende der Auflistung also unter Z, das erste Objekt ist bei -1 größer das zweite kleiner
	}
}
