package mannschaften;

import java.util.ArrayList;

public class Liga<T extends Mannschaft<? extends FussballSpieler>>
{
	public ArrayList<T> mannschaftListe;
	
	public Liga()
	{
		mannschaftListe = new ArrayList<T>();
	}
	
	public void aufnehmen(T mannschaft)
	{
		mannschaftListe.add(mannschaft);
	}
	public void rausschmeissen(T mannschaft)
	{
		mannschaftListe.remove(mannschaft);
	}
	public void auswechseln(T alt, T neu)
	{
		mannschaftListe.remove(alt);
		mannschaftListe.add(neu);
	}
	public void vereineAusgeben()
	{
		for(Object o:  mannschaftListe)
		{
			System.out.println(o);
		}
	}
	public void vereinAdden(T mannschaft)
	{
		aufnehmen(mannschaft);;
	}
}
