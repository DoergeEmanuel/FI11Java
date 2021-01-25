package mannschaften;

public class Control
{
	FussballSpieler spieler1;
	FussballSpieler spieler2;
	BasketballSpieler spieler3;
	BasketballSpieler spieler4;
	
	Mannschaft<FussballSpieler> fcBayern;
	Mannschaft<BasketballSpieler> basketball;
	
	Liga<Mannschaft<FussballSpieler>> bundesliga;
	
	public Control()
	{
		fcBayern = new Mannschaft<FussballSpieler>();
		basketball = new Mannschaft<BasketballSpieler>();
		bundesliga = new Liga<Mannschaft<FussballSpieler>>();
		
		spieler1 = new FussballSpieler("Lewandwoski");
		spieler2 = new FussballSpieler("name2");
		
		spieler3 = new BasketballSpieler("name3");
		spieler4 = new BasketballSpieler("name4");
		
		
		
		fcBayern.spielerAdden(spieler1);
		fcBayern.spielerAdden(spieler2);
		basketball.spielerAdden(spieler3);
		basketball.spielerAdden(spieler4);
		
		
		fcBayern.mannschaftAusgeben();
		basketball.mannschaftAusgeben();
		
		bundesliga.aufnehmen(fcBayern);
		//bundesliga.aufnehmen();
	}
	
}
