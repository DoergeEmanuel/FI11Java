package mannschaften;

import java.util.ArrayList;

public class Liga<T extends Mannschaft<?extends Spieler>>
{
	private ArrayList<T> mannschaftListe;
	private String name;
	
	public Liga(String name)
	{
		mannschaftListe = new ArrayList<T>();
		this.name = name;
	}
	
	

	public void mannschaftAdden(T mannschaft)
	{
		mannschaftListe.add(mannschaft);
	}
	
	public void vereineAusgeben()
	{
		for(Object o:  mannschaftListe)
		{
			System.out.println(o);
		}
	}

	@Override
	public String toString()
	{
		return "Liga " + name;
	}



	public ArrayList<T> getMannschaftListe()
	{
		return mannschaftListe;
	}



	public void setMannschaftListe(ArrayList<T> mannschaftListe)
	{
		this.mannschaftListe = mannschaftListe;
	}
	
}
