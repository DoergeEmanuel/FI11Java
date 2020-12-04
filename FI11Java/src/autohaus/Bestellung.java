package autohaus;

public class Bestellung 
{
	Model model;
	Farbe farbe;
	Ps ps;
	Kunde kunde;
	Extras extras;
	double gesamtpreis;
	
	
	
	public Bestellung(Model model, Farbe farbe, Ps ps, Extras extras)
	{
		super();
		this.model = model;
		this.farbe = farbe;
		this.ps = ps;
		this.extras = extras;
	}

	public void berechneGesamtpreis()
	{
		//System.out.println(gesamtpreis + " = " + ps.getPreis() + " + " + extras.getPreis());
		
			gesamtpreis = ps.getPreis() + extras.getPreis();
		
		//System.out.println(gesamtpreis + " = " + ps.getPreis() + " + " + extras.getPreis());
	}
	
	@Override
	public String toString()
	{
		return model + " " + farbe + " " + ps + " " + gesamtpreis;
	}
	
	
	
}
