package mannschaften;

public class Ligafabrik
{
	public Liga<? extends Mannschaft<? extends Spieler>> erzeugeLiga(Object o, String name)
	{
		Mannschaftsfabrik mf = new Mannschaftsfabrik();
		
		if(o.getClass().isInstance(new FussballSpieler("test")))
		{
			Liga<Mannschaft<FussballSpieler>> l = new Liga(name);
			l.setDummy((Mannschaft<FussballSpieler>) mf.erzeugeMannschaft((FussballSpieler) o, "dummy"));
			return l;
		}
		if(o.getClass().isInstance(new BasketballSpieler("test")))
		{ 
			Liga<Mannschaft<BasketballSpieler>> l = new Liga(name);
			l.setDummy((Mannschaft<BasketballSpieler>) mf.erzeugeMannschaft((BasketballSpieler) o, "dummy"));
			return l;
		}
		if(o.getClass().isInstance(new WilderDummySpieler("test")))
		{
			Liga<Mannschaft<Spieler>> l = new Liga(name);
			l.setDummy((Mannschaft<Spieler>) mf.erzeugeMannschaft((WilderDummySpieler) o, "dummy"));
			return l;
		}
		return null;
	}
}
