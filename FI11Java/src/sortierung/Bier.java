package sortierung;

public class Bier implements Comparable<Bier>
{
	private String name;
	private String herkunft;
	private Float inhalt;
	
	public Bier(String name, String herkunft, Float inhalt)
	{
		this.name = name;
		this.herkunft = herkunft;
		this.inhalt = inhalt;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getHerkunft()
	{
		return herkunft;
	}

	public void setHerkunft(String herkunft)
	{
		this.herkunft = herkunft;
	}

	public Float getInhalt()
	{
		return inhalt;
	}

	public void setInhalt(Float inhalt)
	{
		this.inhalt = inhalt;
	}
	
	@Override
	public int compareTo(Bier b)
	{
		if(this.getName() == null && b.getName() == null)
		{
			return 0;
		}
		if(this.getName() == null)
		{
			return 1;
		}
		if(b.getName() == null)
		{
			return -1;
		}
		if(this.getName().compareTo(b.getName()) == 0)
		{
			if(this.getInhalt() == null && b.getInhalt() == null)
			{
				return 0;
			}
			if(this.getInhalt() == null)
			{
				return 1;
			}
			if(b.getInhalt() == null)
			{
				return -1;
			}
			return this.getInhalt().compareTo(b.getInhalt()); 
		}
		return this.getName().compareTo(b.getName()); //-1 heißt das übergebene Objekt ist übergeordnet, -1 bedeutet das übergebene Objekt ist am Ende der Auflistung also unter Z
	}
	
	
	public String toString()
	{
		return this.name + " aus " + this.herkunft + " mit " + this.inhalt + " Litern";
	}
}