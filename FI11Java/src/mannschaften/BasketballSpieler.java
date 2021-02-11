package mannschaften;

import java.util.Objects;

public class BasketballSpieler extends Spieler
{
	int punkte = 0;
	public BasketballSpieler(String name)
	{
		super(name);
	}
	public void wirfKorb()
	{
		punkte += 2;
	}
	
	public int erzielePunkte()
	{
		return punkte;
	}
	@Override
	public String toString()
	{
		return "BasketballSpieler " + name;
	}
}
