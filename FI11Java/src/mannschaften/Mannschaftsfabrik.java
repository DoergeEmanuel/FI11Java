package mannschaften;

public class Mannschaftsfabrik
{
	
	
	public Mannschaft<? extends Spieler> erzeugeMannschaft(Object o, String name)
	{
		if(o.getClass().isInstance(new FussballSpieler("test")))
		{
			Mannschaft<FussballSpieler> m = new Mannschaft<FussballSpieler>(name);
			m.setDummy((FussballSpieler) o);
			return m;
		}
		if(o.getClass().isInstance(new BasketballSpieler("test")))
		{ 
			Mannschaft<BasketballSpieler> m = new Mannschaft<BasketballSpieler>(name);
			m.setDummy((BasketballSpieler) o);
			return m;
		}
		if(o.getClass().isInstance(new WilderDummySpieler("test")))
		{
			Mannschaft<Spieler> m = new Mannschaft<Spieler>(name);
			m.setDummy((WilderDummySpieler) o);
			return m;
		}
		return null;
		
	}
}
