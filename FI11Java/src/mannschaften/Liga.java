package mannschaften;

import java.util.ArrayList;

public class Liga<T extends Mannschaft<? extends Spieler>>
{
	private ArrayList<T> mannschaftListe;
	private String name;
	private T dummy1 = null;
	private Spieler dummy2 = null;
	
	public Liga(String name)
	{
		mannschaftListe = new ArrayList<T>();
		this.name = name;
	}
	
	public Class<? extends Mannschaft> getDummyType1()
	{
		return  dummy1.getClass();
	}
	public void setDummy1(T dummy)
	{
		this.dummy1 = dummy;
	}
	public Class<? extends Spieler> getDummyType2()
	{
		return  dummy2.getClass();
	}
	public void setDummy2(Spieler dummy)
	{
		this.dummy2 = dummy;
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

	public void rausschmeissen(T mannschaft)
	{
		mannschaftListe.remove(mannschaft);
		
	}
	
}
