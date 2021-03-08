package collectionsAktien;

import java.util.Objects;

public class Aktie implements Comparable<Aktie>
{
	private final String wkn;
	private final String name;
	private int stueckzahl;
	
	
	public int getStueckzahl()
	{
		return stueckzahl;
	}

	public void setStueckzahl(int stueckzahl)
	{
		this.stueckzahl = stueckzahl;
	}

	public String getWkn()
	{
		return wkn;
	}

	public String getName()
	{
		return name;
	}
	
	
	public Aktie(String wkn, String name, int stueckzahl)
	{
		this.wkn = wkn;
		this.name = name;
		this.stueckzahl = stueckzahl;
	}

	public int compareTo(Aktie a)
	{
		if(this.getWkn() == null && a.getWkn() == null)
		{
			return 0;
		}
		if(this.getWkn() == null)
		{
			return 1;
		}
		if(this.getWkn() == null)
		{
			return -1;
		}
		return this.getWkn().compareTo(a.getWkn());
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((wkn == null) ? 0 : wkn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aktie other = (Aktie) obj;
		if (wkn == null)
		{
			if (other.wkn != null)
				return false;
		} else if (!wkn.equals(other.wkn))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Das W von " + name + " mit der Nummer " + wkn + " hat eine Stückzahl von " + stueckzahl;
	}	
	
	
}
