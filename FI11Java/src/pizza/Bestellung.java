package pizza;

public class Bestellung
{
	Pizza pizza;
	Groesse groesse;
	String extra;
	
	public Bestellung(Pizza pizza, Groesse groesse, String extra)
	{
		this.pizza = pizza;
		this.groesse = groesse;
		this.extra = extra;
	}
	
	public Pizza getPizza()
	{
		return pizza;
	}

	public Groesse getGroesse()
	{
		return groesse;
	}
	
	@Override
	public String toString()
	{
		return pizza + " " + groesse + " " + extra;
	}
}
