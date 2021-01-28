package mannschaften;

public class Control
{
	FussballSpieler spieler1;
	FussballSpieler spieler2;
	BasketballSpieler spieler3;
	BasketballSpieler spieler4;
	
	Mannschaft<FussballSpieler> fcBayern;
	Mannschaft<BasketballSpieler> basketball;
	Mannschaft<Spieler> wilderball;
	
	Liga<Mannschaft<FussballSpieler>> bundesliga;
	Liga<Mannschaft<Spieler>> wildeLiga;
	
	public Control()
	{
		fcBayern = new Mannschaft<FussballSpieler>();
		basketball = new Mannschaft<BasketballSpieler>();
		wilderball = new Mannschaft<Spieler>();
		
		
		bundesliga = new Liga<Mannschaft<FussballSpieler>>();
		wildeLiga = new Liga<Mannschaft<Spieler>>();
		
		spieler1 = new FussballSpieler("Lewandwoski");
		spieler2 = new FussballSpieler("name2");
		
		spieler3 = new BasketballSpieler("name3");
		spieler4 = new BasketballSpieler("name4");
		
		
		
		fcBayern.spielerAdden(spieler1);
		fcBayern.spielerAdden(spieler2);
		
		basketball.spielerAdden(spieler3);
		basketball.spielerAdden(spieler4);
		
		
		wilderball.spielerAdden(spieler1);
		wilderball.spielerAdden(spieler2);
		wilderball.spielerAdden(spieler3);
		wilderball.spielerAdden(spieler4);
		
		
		fcBayern.mannschaftAusgeben();
		basketball.mannschaftAusgeben();
		
		bundesliga.aufnehmen(fcBayern);
		//wildeLiga.aufnehmen(wilderball);
	
		
	}
	
}
