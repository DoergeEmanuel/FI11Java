package mannschaften;

import java.util.ArrayList;
import java.util.Objects;



public class Mannschaft<T extends Spieler>
{
	private ArrayList<T> spielerliste;
	private String name;
	private T dummy = null;
	
	
	public Class<? extends Spieler> getDummyType()
	{
		return dummy.getClass();
	}
	public void setDummy(T dummy)
	{
		this.dummy = dummy;
	}
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
		for(T o:  spielerliste)
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
	
	@Override
	public int hashCode()
	{
		int result = 17;
		result = Objects.hash(result, spielerliste);
		result = Objects.hash(result, name);
		result = Objects.hash(result, dummy);
		return result;
	}
}
