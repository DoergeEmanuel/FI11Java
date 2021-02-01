package mannschaften;

import java.util.ArrayList;



public class Mannschaft<T extends Spieler>
{
	private ArrayList<T> spielerliste;
	private String name;
	
	public Mannschaft(String name)
	{
		spielerliste = new ArrayList<T>();
		this.name = name;
		
	}
	public void rausschmeissen(T spieler)
	{
		spielerliste.remove(spieler);
	}
	public void mannschaftAusgeben()
	{
		for(Object o:  spielerliste)
		{
			System.out.println(o);
		}
	}
	public void spielerAdden(T spieler)
	{
		spielerliste.add(spieler);
	}
	@Override
	public String toString()
	{
		return "Mannschaft " + name;
	}
	public ArrayList<T> getSpielerliste()
	{
		return spielerliste;
	}
	public void setSpielerliste(ArrayList<T> spielerliste)
	{
		this.spielerliste = spielerliste;
	}
	

}
