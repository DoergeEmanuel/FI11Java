package Filmdatenbank;

import java.util.Objects;

public class Film
{
	int nummer;
	String titel;
	String genre;
	int nummer2;
	
	
	public Film(int nummer, String titel, String genre, int nummer2)
	{
		super();
		this.nummer = nummer;
		this.titel = titel;
		this.genre = genre;
		this.nummer2 = nummer2;
	}
	
	public int getNummer()
	{
		return nummer;
	}
	public void setNummer(int nummer)
	{
		this.nummer = nummer;
	}
	
	public String getTitel()
	{
		return titel;
	}
	public void setTitel(String titel)
	{
		this.titel = titel;
	}
	public String getGenre()
	{
		return genre;
	}
	public void setGenre(String genre)
	{
		this.genre = genre;
	}
	public int getNummer2()
	{
		return nummer2;
	}
	public void setNummer2(int nummer2)
	{
		this.nummer2 = nummer2;
	}
	/*
	@Override
	public boolean equals(Object obj)
	{
		if((obj instanceof Film) == false)
		{
			return false;
		}
		if(this == obj)
		{
			return true;
		}
		Film film = (Film)obj;
		
		if(film.getNummer() == this.getNummer() && film.getTitel().equals(this.getTitel()) && film.getGenre().equals(this.getGenre()) && film.getNummer2() == this.getNummer2())
		{
			return true;
		}
		else
		{
			return false;
		}	
	}
	*/
	
	@Override
	public boolean equals(Object obj)
	{
		
		if(!(obj instanceof Film))
		{
			return false;
		}
		if(this == obj)
		{
			return true;
		}
		
		Film film = (Film)obj;
		
		return film.getTitel().equals(getTitel()) &&
				film.getNummer() == getNummer() &&
				film.getGenre().equals(getGenre()) &&
				film.getNummer2() == getNummer2();	
	}
	
	@Override
	public int hashCode()
	{
		int result = 17;
		result = Objects.hash(result, titel);
		result = Objects.hash(result, nummer);
		result = Objects.hash(result, genre);
		result = Objects.hash(result, nummer2);
		return result;
	}
	
	
	
	
	
	
	@Override
	public String toString()
	{
		return nummer + " | " + titel + " | ";
	}
}
