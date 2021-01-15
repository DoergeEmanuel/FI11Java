package Filmdatenbank;

import java.util.Comparator;

public class FilmNummerAbsteigendComparator implements Comparator<Film>
{
	public int compare(Film film1, Film film2)
	{	
		if(film1.getNummer() < film2.getNummer())
		{
			return 1;
		}
		else if(film1.getNummer() == film2.getNummer())
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}
}

