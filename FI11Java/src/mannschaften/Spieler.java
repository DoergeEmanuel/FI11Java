package mannschaften;

public class Spieler
{
	protected String name;

	public Spieler(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}

	@Override
	public String toString()
	{
		return "Spieler " + name;
	}
	
	
}
