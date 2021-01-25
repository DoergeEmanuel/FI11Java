package mannschaften;

import java.util.ArrayList;



public class Mannschaft<T extends Spieler>
{
	public ArrayList<T> spielerliste;
	
	public Mannschaft()
	{
		spielerliste = new ArrayList<T>();
	}
	
	public void aufnehmen(T spieler)
	{
		spielerliste.add(spieler);
	}
	public void rausschmeissen(T spieler)
	{
		spielerliste.remove(spieler);
	}
	public void auswechseln(T alt, T neu)
	{
		spielerliste.remove(alt);
		spielerliste.add(neu);
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
		aufnehmen(spieler);;
	}

}
