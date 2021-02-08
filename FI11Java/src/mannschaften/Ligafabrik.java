package mannschaften;

public class Ligafabrik
{
	public Liga<? extends Mannschaft<? extends Spieler>> erzeugeLiga(Object o1, Object o2, String name)
	{
		
		if(o1.getClass().isInstance(new Mannschaft("test")))
		{
			if(o2.getClass().isInstance(new FussballSpieler("test")))
			{
				Liga<Mannschaft<FussballSpieler>> l = new Liga(name);
				l.setDummy1((Mannschaft) o1);
				l.setDummy2((FussballSpieler) o2);
				return l;
			}
			if(o2.getClass().isInstance(new BasketballSpieler("test")))
			{ 
				Liga<Mannschaft<BasketballSpieler>> l = new Liga(name);
				l.setDummy1((Mannschaft) o1);
				l.setDummy2((BasketballSpieler) o2);
				return l;
			}
			if(o2.getClass().isInstance(new WilderDummySpieler("test")))
			{
				Liga<Mannschaft<Spieler>> l = new Liga(name);
				l.setDummy1((Mannschaft) o1);
				l.setDummy2((WilderDummySpieler) o2);
				return l;
			}
		}
		return null;
		
	}
		
}
