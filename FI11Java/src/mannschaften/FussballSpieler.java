package mannschaften;

public class FussballSpieler extends Spieler
{
	int anzahlTore = 0;
	
	public FussballSpieler(String name)
	{
		super(name);
	}
	public void schiessTor()
	{
		anzahlTore++;
	}
	int anzahlGeschosseneTore()
	{
		return anzahlTore;
	}
	@Override
	public String toString()
	{
		return "FussballSpieler " + name;
	}
	
}
