package mannschaften;

import java.util.ArrayList;
import java.util.Objects;

public class Liga<T extends Mannschaft<? extends Spieler>>
{
	private ArrayList<T> mannschaftListe;
	private String name;
	private T dummy = null;
	
	public Liga(String name)
	{
		mannschaftListe = new ArrayList<T>();
		this.name = name;
	}
	
	public Class<? extends Mannschaft> getDummyType()
	{
		return  dummy.getClass();
	}
	public T getDummy()
	{
		return dummy;
	}
	public void setDummy(T dummy)
	{
		this.dummy = dummy;
	}
	
	public ArrayList<T> getMannschaftListe()
	{
		return mannschaftListe;
	}
	
	public void setMannschaftListe(ArrayList<T> mannschaftListe)
	{
		this.mannschaftListe = mannschaftListe;
	}

	public void rausschmeissen(T mannschaft)
	{
		mannschaftListe.remove(mannschaft);
		
	}

	public void mannschaftAdden(T mannschaft)
	{
		mannschaftListe.add(mannschaft);
	}

	@Override
	public int hashCode()
	{
		int result = 17;
		result = Objects.hash(result, mannschaftListe);
		result = Objects.hash(result, name);
		result = Objects.hash(result, dummy);
		return result;
	}
	
	@Override
	public String toString()
	{
		return "Liga " + name;
	}



	
	
}
