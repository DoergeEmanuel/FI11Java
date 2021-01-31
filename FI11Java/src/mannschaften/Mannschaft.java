package mannschaften;

import java.util.ArrayList;



public class Mannschaft<T extends Spieler>
{
	private ArrayList<Object> spielerliste;
	private String name;
	
	public Mannschaft(String name)
	{
		spielerliste = new ArrayList<Object>();
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
	public ArrayList<Object> getSpielerliste()
	{
		return spielerliste;
	}
	public void setSpielerliste(ArrayList<Object> spielerliste)
	{
		this.spielerliste = spielerliste;
	}
	

}
